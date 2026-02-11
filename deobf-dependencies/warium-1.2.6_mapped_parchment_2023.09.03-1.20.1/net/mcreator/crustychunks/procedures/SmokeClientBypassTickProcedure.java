package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class SmokeClientBypassTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double particleAmount = 0.0D;
         immediatesourceentity.noPhysics = true;
         if (!immediatesourceentity.getPersistentData().getBoolean("Used")) {
            for(int index0 = 0; index0 < 60; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE_SCREEN.get(), x + Mth.nextDouble(RandomSource.create(), -6.5D, 7.5D), y + 1.0D, z + Mth.nextDouble(RandomSource.create(), -6.5D, 7.5D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.3D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D));
            }

            immediatesourceentity.getPersistentData().putBoolean("Used", true);
         } else {
            CrustyChunksMod.queueServerWork(2, () -> {
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }

            });
         }

      }
   }
}
