package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SplashClientEffectTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double particleAmount = 0.0D;
         immediatesourceentity.noPhysics = true;
         if (!immediatesourceentity.getPersistentData().getBoolean("Used")) {
            for(int index0 = 0; index0 < 35; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x + Mth.nextDouble(RandomSource.create(), -0.5D, 1.5D), y + Mth.nextDouble(RandomSource.create(), -0.5D, 2.5D), z + Mth.nextDouble(RandomSource.create(), -0.5D, 1.5D), Mth.nextDouble(RandomSource.create(), -1.5D, 1.5D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.8D), Mth.nextDouble(RandomSource.create(), -1.5D, 1.5D));
            }

            world.addParticle(ParticleTypes.FLASH, x, y + 1.0D, z, 0.0D, 0.1D, 0.0D);
            immediatesourceentity.getPersistentData().putBoolean("Used", true);
         } else if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
