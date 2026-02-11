package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.block.entity.SmokeLauncherBlockEntity;
import net.mcreator.crustychunks.procedures.BCUpdateScriptProcedure;
import net.mcreator.crustychunks.procedures.SmokeLauncherFireScriptProcedure;
import net.mcreator.crustychunks.procedures.SmokeLauncherReloadProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmokeLauncherBlock extends Block implements EntityBlock {
   public static final DirectionProperty FACING;

   public SmokeLauncherBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.ANVIL).strength(1.0F, 10.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
         return false;
      }));
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
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
         var10000 = Shapes.or(box(3.0D, 0.0D, 2.0D, 13.0D, 2.0D, 12.0D), new VoxelShape[]{box(4.0D, 0.0D, 3.0D, 6.0D, 2.0D, 9.0D), box(7.0D, 0.0D, 3.0D, 9.0D, 2.0D, 9.0D), box(10.0D, 0.0D, 3.0D, 12.0D, 2.0D, 9.0D)});
         break;
      case EAST:
         var10000 = Shapes.or(box(4.0D, 0.0D, 3.0D, 14.0D, 2.0D, 13.0D), new VoxelShape[]{box(7.0D, 0.0D, 4.0D, 13.0D, 2.0D, 6.0D), box(7.0D, 0.0D, 7.0D, 13.0D, 2.0D, 9.0D), box(7.0D, 0.0D, 10.0D, 13.0D, 2.0D, 12.0D)});
         break;
      case WEST:
         var10000 = Shapes.or(box(2.0D, 0.0D, 3.0D, 12.0D, 2.0D, 13.0D), new VoxelShape[]{box(3.0D, 0.0D, 10.0D, 9.0D, 2.0D, 12.0D), box(3.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D), box(3.0D, 0.0D, 4.0D, 9.0D, 2.0D, 6.0D)});
         break;
      default:
         var10000 = Shapes.or(box(3.0D, 0.0D, 4.0D, 13.0D, 2.0D, 14.0D), new VoxelShape[]{box(10.0D, 0.0D, 7.0D, 12.0D, 2.0D, 13.0D), box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 13.0D), box(4.0D, 0.0D, 7.0D, 6.0D, 2.0D, 13.0D)});
      }

      return var10000;
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
      return true;
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 2);
   }

   public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
      if (world.getBestNeighborSignal(pos) > 0) {
         SmokeLauncherFireScriptProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), blockstate);
      }

   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      BCUpdateScriptProcedure.execute(world, (double)x, (double)y, (double)z, blockstate);
      world.scheduleTick(pos, this, 2);
   }

   public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.use(blockstate, world, pos, entity, hand, hit);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      double hitX = hit.getLocation().x;
      double hitY = hit.getLocation().y;
      double hitZ = hit.getLocation().z;
      Direction direction = hit.getDirection();
      SmokeLauncherReloadProcedure.execute(world, (double)x, (double)y, (double)z, entity);
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
      return new SmokeLauncherBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.getBlock() != newState.getBlock()) {
         BlockEntity blockEntity = world.getBlockEntity(pos);
         if (blockEntity instanceof SmokeLauncherBlockEntity) {
            SmokeLauncherBlockEntity be = (SmokeLauncherBlockEntity)blockEntity;
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
      if (tileentity instanceof SmokeLauncherBlockEntity) {
         SmokeLauncherBlockEntity be = (SmokeLauncherBlockEntity)tileentity;
         return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
      } else {
         return 0;
      }
   }

   static {
      FACING = HorizontalDirectionalBlock.FACING;
   }
}
