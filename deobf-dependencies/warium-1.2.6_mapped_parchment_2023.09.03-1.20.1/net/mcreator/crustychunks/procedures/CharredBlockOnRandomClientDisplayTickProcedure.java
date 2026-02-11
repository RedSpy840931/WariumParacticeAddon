package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class CharredBlockOnRandomClientDisplayTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (5 == Mth.nextInt(RandomSource.create(), 1, 5)) {
         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), 0.2D, 0.8D), y + Mth.nextDouble(RandomSource.create(), 0.2D, 0.8D), z + Mth.nextDouble(RandomSource.create(), 0.2D, 0.8D), 0.0D, 1.0D, 0.0D);
      }

   }
}
