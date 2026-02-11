package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ScorchDirtOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.SCORCH_DIRT.get()) {
         world.setBlock(BlockPos.containing(x, y - 1.0D, z), ((Block)CrustyChunksModBlocks.HARDDIRT.get()).defaultBlockState(), 3);
      }

      if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == Blocks.AIR && 1 != Mth.nextInt(RandomSource.create(), 1, 35)) {
         if (1 == Mth.nextInt(RandomSource.create(), 1, 5) && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 3.0D, z, 1, 1.0D, 3.0D, 1.0D, 0.01D);
         }
      } else {
         world.setBlock(BlockPos.containing(x, y, z), ((Block)CrustyChunksModBlocks.HARDDIRT.get()).defaultBlockState(), 3);
      }

   }
}
