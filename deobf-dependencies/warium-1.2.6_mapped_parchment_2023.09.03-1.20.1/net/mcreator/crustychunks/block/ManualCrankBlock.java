package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.block.entity.ManualCrankBlockEntity;
import net.mcreator.crustychunks.procedures.CrankRotateProcedure;
import net.mcreator.crustychunks.procedures.ManualCrankOnBlockRightClickedProcedure;
import net.mcreator.crustychunks.procedures.ManualCrankOnTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
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
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ManualCrankBlock extends Block implements EntityBlock {
   public static final DirectionProperty FACING;
   public static final BooleanProperty POSITIONED;

   public ManualCrankBlock() {
      super(Properties.of().sound(SoundType.LADDER).strength(1.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
         return false;
      }));
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(POSITIONED, false));
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
         var10000 = Shapes.or(box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 4.0D), new VoxelShape[]{box(1.0D, 7.0D, 6.0D, 15.0D, 9.0D, 7.0D), box(7.0D, 7.0D, 2.0D, 9.0D, 9.0D, 6.0D), box(13.0D, 7.0D, 7.0D, 15.0D, 9.0D, 10.0D), box(1.0D, 7.0D, 7.0D, 3.0D, 9.0D, 10.0D)});
         break;
      case EAST:
         var10000 = Shapes.or(box(12.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D), new VoxelShape[]{box(9.0D, 7.0D, 1.0D, 10.0D, 9.0D, 15.0D), box(10.0D, 7.0D, 7.0D, 14.0D, 9.0D, 9.0D), box(6.0D, 7.0D, 13.0D, 9.0D, 9.0D, 15.0D), box(6.0D, 7.0D, 1.0D, 9.0D, 9.0D, 3.0D)});
         break;
      case WEST:
         var10000 = Shapes.or(box(0.0D, 6.0D, 6.0D, 4.0D, 10.0D, 10.0D), new VoxelShape[]{box(6.0D, 7.0D, 1.0D, 7.0D, 9.0D, 15.0D), box(2.0D, 7.0D, 7.0D, 6.0D, 9.0D, 9.0D), box(7.0D, 7.0D, 1.0D, 10.0D, 9.0D, 3.0D), box(7.0D, 7.0D, 13.0D, 10.0D, 9.0D, 15.0D)});
         break;
      default:
         var10000 = Shapes.or(box(6.0D, 6.0D, 12.0D, 10.0D, 10.0D, 16.0D), new VoxelShape[]{box(1.0D, 7.0D, 9.0D, 15.0D, 9.0D, 10.0D), box(7.0D, 7.0D, 10.0D, 9.0D, 9.0D, 14.0D), box(1.0D, 7.0D, 6.0D, 3.0D, 9.0D, 9.0D), box(13.0D, 7.0D, 6.0D, 15.0D, 9.0D, 9.0D)});
      }

      return var10000;
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING, POSITIONED});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return context.getClickedFace().getAxis() == Axis.Y ? (BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACING, Direction.NORTH)).setValue(POSITIONED, false) : (BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACING, context.getClickedFace())).setValue(POSITIONED, false);
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      world.scheduleTick(pos, this, 1);
      CrankRotateProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), blockstate);
   }

   public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.tick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      ManualCrankOnTickUpdateProcedure.execute(world, (double)x, (double)y, (double)z);
      world.scheduleTick(pos, this, 1);
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
      ManualCrankOnBlockRightClickedProcedure.execute(world, (double)x, (double)y, (double)z);
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
      return new ManualCrankBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.getBlock() != newState.getBlock()) {
         BlockEntity blockEntity = world.getBlockEntity(pos);
         if (blockEntity instanceof ManualCrankBlockEntity) {
            ManualCrankBlockEntity be = (ManualCrankBlockEntity)blockEntity;
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
      if (tileentity instanceof ManualCrankBlockEntity) {
         ManualCrankBlockEntity be = (ManualCrankBlockEntity)tileentity;
         return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
      } else {
         return 0;
      }
   }

   static {
      FACING = HorizontalDirectionalBlock.FACING;
      POSITIONED = BooleanProperty.create("positioned");
   }
}
