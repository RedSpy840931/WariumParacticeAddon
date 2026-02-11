package net.mcreator.crustychunks.block;

import io.netty.buffer.Unpooled;
import java.util.List;
import net.mcreator.crustychunks.block.entity.FusionBombBlockEntity;
import net.mcreator.crustychunks.procedures.FusionBombOnTickUpdateProcedure;
import net.mcreator.crustychunks.procedures.FusionBombRedstoneOnProcedure;
import net.mcreator.crustychunks.world.inventory.FusionBombGUIMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

public class FusionBombBlock extends Block implements EntityBlock {
   public static final DirectionProperty FACING;
   public static final EnumProperty<AttachFace> FACE;

   public FusionBombBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.ANVIL).strength(1.0F, 10.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
         return false;
      }));
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(FACE, AttachFace.WALL));
   }

   public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.translatable("block.crusty_chunks.fusion_bomb.description_0"));
      list.add(Component.translatable("block.crusty_chunks.fusion_bomb.description_1"));
   }

   public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      VoxelShape var10000;
      switch((Direction)state.getValue(FACING)) {
      case NORTH:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), new VoxelShape[]{box(12.0D, 1.0D, -1.0D, 14.0D, 14.0D, 17.0D), box(2.0D, 1.0D, -1.0D, 4.0D, 14.0D, 17.0D), box(1.0D, 12.0D, 1.0D, 15.0D, 16.0D, 15.0D), box(2.0D, 16.0D, 2.0D, 14.0D, 20.0D, 14.0D), box(3.0D, 20.0D, 3.0D, 13.0D, 24.0D, 13.0D), box(4.0D, 24.0D, 4.0D, 12.0D, 28.0D, 12.0D), box(5.0D, 28.0D, 5.0D, 11.0D, 32.0D, 11.0D)});
            return var10000;
         case WALL:
            var10000 = Shapes.or(box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D), new VoxelShape[]{box(12.0D, -1.0D, 2.0D, 14.0D, 17.0D, 15.0D), box(2.0D, -1.0D, 2.0D, 4.0D, 17.0D, 15.0D), box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 4.0D), box(2.0D, 2.0D, -4.0D, 14.0D, 14.0D, 0.0D), box(3.0D, 3.0D, -8.0D, 13.0D, 13.0D, -4.0D), box(4.0D, 4.0D, -12.0D, 12.0D, 12.0D, -8.0D), box(5.0D, 5.0D, -16.0D, 11.0D, 11.0D, -12.0D)});
            return var10000;
         case CEILING:
            var10000 = Shapes.or(box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D), new VoxelShape[]{box(2.0D, 2.0D, -1.0D, 4.0D, 15.0D, 17.0D), box(12.0D, 2.0D, -1.0D, 14.0D, 15.0D, 17.0D), box(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), box(2.0D, -4.0D, 2.0D, 14.0D, 0.0D, 14.0D), box(3.0D, -8.0D, 3.0D, 13.0D, -4.0D, 13.0D), box(4.0D, -12.0D, 4.0D, 12.0D, -8.0D, 12.0D), box(5.0D, -16.0D, 5.0D, 11.0D, -12.0D, 11.0D)});
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      case EAST:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), new VoxelShape[]{box(-1.0D, 1.0D, 12.0D, 17.0D, 14.0D, 14.0D), box(-1.0D, 1.0D, 2.0D, 17.0D, 14.0D, 4.0D), box(1.0D, 12.0D, 1.0D, 15.0D, 16.0D, 15.0D), box(2.0D, 16.0D, 2.0D, 14.0D, 20.0D, 14.0D), box(3.0D, 20.0D, 3.0D, 13.0D, 24.0D, 13.0D), box(4.0D, 24.0D, 4.0D, 12.0D, 28.0D, 12.0D), box(5.0D, 28.0D, 5.0D, 11.0D, 32.0D, 11.0D)});
            return var10000;
         case WALL:
            var10000 = Shapes.or(box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D), new VoxelShape[]{box(1.0D, -1.0D, 12.0D, 14.0D, 17.0D, 14.0D), box(1.0D, -1.0D, 2.0D, 14.0D, 17.0D, 4.0D), box(12.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D), box(16.0D, 2.0D, 2.0D, 20.0D, 14.0D, 14.0D), box(20.0D, 3.0D, 3.0D, 24.0D, 13.0D, 13.0D), box(24.0D, 4.0D, 4.0D, 28.0D, 12.0D, 12.0D), box(28.0D, 5.0D, 5.0D, 32.0D, 11.0D, 11.0D)});
            return var10000;
         case CEILING:
            var10000 = Shapes.or(box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D), new VoxelShape[]{box(-1.0D, 2.0D, 2.0D, 17.0D, 15.0D, 4.0D), box(-1.0D, 2.0D, 12.0D, 17.0D, 15.0D, 14.0D), box(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), box(2.0D, -4.0D, 2.0D, 14.0D, 0.0D, 14.0D), box(3.0D, -8.0D, 3.0D, 13.0D, -4.0D, 13.0D), box(4.0D, -12.0D, 4.0D, 12.0D, -8.0D, 12.0D), box(5.0D, -16.0D, 5.0D, 11.0D, -12.0D, 11.0D)});
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      case WEST:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), new VoxelShape[]{box(-1.0D, 1.0D, 2.0D, 17.0D, 14.0D, 4.0D), box(-1.0D, 1.0D, 12.0D, 17.0D, 14.0D, 14.0D), box(1.0D, 12.0D, 1.0D, 15.0D, 16.0D, 15.0D), box(2.0D, 16.0D, 2.0D, 14.0D, 20.0D, 14.0D), box(3.0D, 20.0D, 3.0D, 13.0D, 24.0D, 13.0D), box(4.0D, 24.0D, 4.0D, 12.0D, 28.0D, 12.0D), box(5.0D, 28.0D, 5.0D, 11.0D, 32.0D, 11.0D)});
            return var10000;
         case WALL:
            var10000 = Shapes.or(box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), new VoxelShape[]{box(2.0D, -1.0D, 2.0D, 15.0D, 17.0D, 4.0D), box(2.0D, -1.0D, 12.0D, 15.0D, 17.0D, 14.0D), box(0.0D, 1.0D, 1.0D, 4.0D, 15.0D, 15.0D), box(-4.0D, 2.0D, 2.0D, 0.0D, 14.0D, 14.0D), box(-8.0D, 3.0D, 3.0D, -4.0D, 13.0D, 13.0D), box(-12.0D, 4.0D, 4.0D, -8.0D, 12.0D, 12.0D), box(-16.0D, 5.0D, 5.0D, -12.0D, 11.0D, 11.0D)});
            return var10000;
         case CEILING:
            var10000 = Shapes.or(box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D), new VoxelShape[]{box(-1.0D, 2.0D, 12.0D, 17.0D, 15.0D, 14.0D), box(-1.0D, 2.0D, 2.0D, 17.0D, 15.0D, 4.0D), box(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), box(2.0D, -4.0D, 2.0D, 14.0D, 0.0D, 14.0D), box(3.0D, -8.0D, 3.0D, 13.0D, -4.0D, 13.0D), box(4.0D, -12.0D, 4.0D, 12.0D, -8.0D, 12.0D), box(5.0D, -16.0D, 5.0D, 11.0D, -12.0D, 11.0D)});
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      default:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), new VoxelShape[]{box(2.0D, 1.0D, -1.0D, 4.0D, 14.0D, 17.0D), box(12.0D, 1.0D, -1.0D, 14.0D, 14.0D, 17.0D), box(1.0D, 12.0D, 1.0D, 15.0D, 16.0D, 15.0D), box(2.0D, 16.0D, 2.0D, 14.0D, 20.0D, 14.0D), box(3.0D, 20.0D, 3.0D, 13.0D, 24.0D, 13.0D), box(4.0D, 24.0D, 4.0D, 12.0D, 28.0D, 12.0D), box(5.0D, 28.0D, 5.0D, 11.0D, 32.0D, 11.0D)});
            break;
         case WALL:
            var10000 = Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D), new VoxelShape[]{box(2.0D, -1.0D, 1.0D, 4.0D, 17.0D, 14.0D), box(12.0D, -1.0D, 1.0D, 14.0D, 17.0D, 14.0D), box(1.0D, 1.0D, 12.0D, 15.0D, 15.0D, 16.0D), box(2.0D, 2.0D, 16.0D, 14.0D, 14.0D, 20.0D), box(3.0D, 3.0D, 20.0D, 13.0D, 13.0D, 24.0D), box(4.0D, 4.0D, 24.0D, 12.0D, 12.0D, 28.0D), box(5.0D, 5.0D, 28.0D, 11.0D, 11.0D, 32.0D)});
            break;
         case CEILING:
            var10000 = Shapes.or(box(0.0D, 4.0D, 0.0D, 16.0D, 16.0D, 16.0D), new VoxelShape[]{box(12.0D, 2.0D, -1.0D, 14.0D, 15.0D, 17.0D), box(2.0D, 2.0D, -1.0D, 4.0D, 15.0D, 17.0D), box(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D), box(2.0D, -4.0D, 2.0D, 14.0D, 0.0D, 14.0D), box(3.0D, -8.0D, 3.0D, 13.0D, -4.0D, 13.0D), box(4.0D, -12.0D, 4.0D, 12.0D, -8.0D, 12.0D), box(5.0D, -16.0D, 5.0D, 11.0D, -12.0D, 11.0D)});
            break;
         default:
            throw new IncompatibleClassChangeError();
         }
      }

      return var10000;
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING, FACE});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACE, this.faceForDirection(context.getNearestLookingDirection()))).setValue(FACING, context.getHorizontalDirection().getOpposite());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   private AttachFace faceForDirection(Direction direction) {
      if (direction.getAxis() == Axis.Y) {
         return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
      } else {
         return AttachFace.WALL;
      }
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 20);
   }

   public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
      if (world.getBestNeighborSignal(pos) > 0) {
         FusionBombRedstoneOnProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
      }

   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      FusionBombOnTickUpdateProcedure.execute(world, (double)x, (double)y, (double)z);
      world.scheduleTick(pos, this, 20);
   }

   public InteractionResult use(BlockState blockstate, Level world, final BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.use(blockstate, world, pos, entity, hand, hit);
      if (entity instanceof ServerPlayer) {
         ServerPlayer player = (ServerPlayer)entity;
         NetworkHooks.openScreen(player, new MenuProvider() {
            public Component getDisplayName() {
               return Component.literal("§dFusion Bomb");
            }

            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
               return new FusionBombGUIMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).writeBlockPos(pos));
            }
         }, pos);
      }

      return InteractionResult.SUCCESS;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      BlockEntity tileEntity = worldIn.getBlockEntity(pos);
      MenuProvider var10000;
      if (tileEntity instanceof MenuProvider) {
         MenuProvider menuProvider = (MenuProvider)tileEntity;
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new FusionBombBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.getBlock() != newState.getBlock()) {
         BlockEntity blockEntity = world.getBlockEntity(pos);
         if (blockEntity instanceof FusionBombBlockEntity) {
            FusionBombBlockEntity be = (FusionBombBlockEntity)blockEntity;
            Containers.dropContents(world, pos, be);
            world.updateNeighbourForOutputSignal(pos, this);
         }

         super.onRemove(state, world, pos, newState, isMoving);
      }

   }

   public boolean hasAnalogOutputSignal(BlockState state) {
      return true;
   }

   public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
      BlockEntity tileentity = world.getBlockEntity(pos);
      if (tileentity instanceof FusionBombBlockEntity) {
         FusionBombBlockEntity be = (FusionBombBlockEntity)tileentity;
         return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
      } else {
         return 0;
      }
   }

   static {
      FACING = HorizontalDirectionalBlock.FACING;
      FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
   }
}
