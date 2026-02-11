package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.ERAProcedureProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
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

public class OffsetERA4Block extends Block {
   public static final DirectionProperty FACING;

   public OffsetERA4Block() {
      super(Properties.of().sound(SoundType.ANVIL).strength(7.0F, 10.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
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
         var10000 = Shapes.or(box(1.0D, 0.0D, 7.0D, 7.0D, 7.0D, 9.0D), new VoxelShape[]{box(9.0D, 0.0D, 7.0D, 15.0D, 7.0D, 9.0D), box(9.0D, 8.0D, 7.0D, 15.0D, 15.0D, 9.0D), box(1.0D, 8.0D, 7.0D, 7.0D, 15.0D, 9.0D), box(0.0D, 0.0D, 9.0D, 16.0D, 16.0D, 16.0D)});
         break;
      case EAST:
         var10000 = Shapes.or(box(7.0D, 0.0D, 1.0D, 9.0D, 7.0D, 7.0D), new VoxelShape[]{box(7.0D, 0.0D, 9.0D, 9.0D, 7.0D, 15.0D), box(7.0D, 8.0D, 9.0D, 9.0D, 15.0D, 15.0D), box(7.0D, 8.0D, 1.0D, 9.0D, 15.0D, 7.0D), box(0.0D, 0.0D, 0.0D, 7.0D, 16.0D, 16.0D)});
         break;
      case WEST:
         var10000 = Shapes.or(box(7.0D, 0.0D, 9.0D, 9.0D, 7.0D, 15.0D), new VoxelShape[]{box(7.0D, 0.0D, 1.0D, 9.0D, 7.0D, 7.0D), box(7.0D, 8.0D, 1.0D, 9.0D, 15.0D, 7.0D), box(7.0D, 8.0D, 9.0D, 9.0D, 15.0D, 15.0D), box(9.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)});
         break;
      case UP:
         var10000 = Shapes.or(box(1.0D, 7.0D, 0.0D, 7.0D, 9.0D, 7.0D), new VoxelShape[]{box(9.0D, 7.0D, 0.0D, 15.0D, 9.0D, 7.0D), box(9.0D, 7.0D, 8.0D, 15.0D, 9.0D, 15.0D), box(1.0D, 7.0D, 8.0D, 7.0D, 9.0D, 15.0D), box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D)});
         break;
      case DOWN:
         var10000 = Shapes.or(box(1.0D, 7.0D, 9.0D, 7.0D, 9.0D, 16.0D), new VoxelShape[]{box(9.0D, 7.0D, 9.0D, 15.0D, 9.0D, 16.0D), box(9.0D, 7.0D, 1.0D, 15.0D, 9.0D, 8.0D), box(1.0D, 7.0D, 1.0D, 7.0D, 9.0D, 8.0D), box(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 16.0D)});
         break;
      default:
         var10000 = Shapes.or(box(9.0D, 0.0D, 7.0D, 15.0D, 7.0D, 9.0D), new VoxelShape[]{box(1.0D, 0.0D, 7.0D, 7.0D, 7.0D, 9.0D), box(1.0D, 8.0D, 7.0D, 7.0D, 15.0D, 9.0D), box(9.0D, 8.0D, 7.0D, 15.0D, 15.0D, 9.0D), box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 7.0D)});
      }

      return var10000;
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)super.getStateForPlacement(context).setValue(FACING, context.getNearestLookingDirection().getOpposite());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public void wasExploded(Level world, BlockPos pos, Explosion e) {
      super.wasExploded(world, pos, e);
      ERAProcedureProcedure.execute(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   static {
      FACING = DirectionalBlock.FACING;
   }
}
