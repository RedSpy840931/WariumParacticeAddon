package net.mcreator.crustychunks.block;

import net.mcreator.crustychunks.procedures.FuelRodsLoadProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmptyFuelRodsBlock extends Block {
   public EmptyFuelRodsBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.COPPER).strength(1.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
         return false;
      }));
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
      return Shapes.or(box(3.0D, 0.0D, 3.0D, 5.0D, 1.0D, 5.0D), new VoxelShape[]{box(2.0D, 0.0D, 10.0D, 6.0D, 2.0D, 14.0D), box(3.0D, 0.0D, 11.0D, 5.0D, 1.0D, 13.0D), box(2.0D, 0.0D, 2.0D, 6.0D, 2.0D, 6.0D), box(11.0D, 0.0D, 11.0D, 13.0D, 1.0D, 13.0D), box(10.0D, 0.0D, 10.0D, 14.0D, 2.0D, 14.0D), box(11.0D, 0.0D, 3.0D, 13.0D, 1.0D, 5.0D), box(10.0D, 0.0D, 2.0D, 14.0D, 2.0D, 6.0D)});
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
      FuelRodsLoadProcedure.execute(world, (double)x, (double)y, (double)z, entity);
      return InteractionResult.SUCCESS;
   }
}
