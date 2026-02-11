package net.mcreator.crustychunks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MachineGunBarrelBlock extends Block {
   public static final DirectionProperty FACING;

   public MachineGunBarrelBlock() {
      super(Properties.of().sound(SoundType.ANVIL).strength(1.0F, 10.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
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
         var10000 = Shapes.or(box(6.5D, 6.5D, 0.0D, 9.5D, 9.5D, 16.0D), new VoxelShape[]{box(6.6D, 6.6D, -14.9D, 9.4D, 9.4D, 0.9D), box(5.5D, 6.5D, -16.0D, 10.5D, 9.5D, -9.0D)});
         break;
      case EAST:
         var10000 = Shapes.or(box(0.0D, 6.5D, 6.5D, 16.0D, 9.5D, 9.5D), new VoxelShape[]{box(15.1D, 6.6D, 6.6D, 30.9D, 9.4D, 9.4D), box(25.0D, 6.5D, 5.5D, 32.0D, 9.5D, 10.5D)});
         break;
      case WEST:
         var10000 = Shapes.or(box(0.0D, 6.5D, 6.5D, 16.0D, 9.5D, 9.5D), new VoxelShape[]{box(-14.9D, 6.6D, 6.6D, 0.9D, 9.4D, 9.4D), box(-16.0D, 6.5D, 5.5D, -9.0D, 9.5D, 10.5D)});
         break;
      default:
         var10000 = Shapes.or(box(6.5D, 6.5D, 0.0D, 9.5D, 9.5D, 16.0D), new VoxelShape[]{box(6.6D, 6.6D, 15.1D, 9.4D, 9.4D, 30.9D), box(5.5D, 6.5D, 25.0D, 10.5D, 9.5D, 32.0D)});
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

   static {
      FACING = HorizontalDirectionalBlock.FACING;
   }
}
