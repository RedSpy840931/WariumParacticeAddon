package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GiantShockProcedureProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double particleAmount = 0.0D;
         immediatesourceentity.noPhysics = true;
         if (!immediatesourceentity.getPersistentData().getBoolean("Used")) {
            for(int index0 = 0; index0 < 45; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), y + Mth.nextDouble(RandomSource.create(), -1.0D, 2.0D), z + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), Mth.nextDouble(RandomSource.create(), -2.2D, 2.2D), Mth.nextDouble(RandomSource.create(), -0.7D, 1.0D), Mth.nextDouble(RandomSource.create(), -2.2D, 2.2D));
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), y + Mth.nextDouble(RandomSource.create(), -1.0D, 2.0D), z + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), Mth.nextDouble(RandomSource.create(), -2.2D, 2.2D), Mth.nextDouble(RandomSource.create(), -0.7D, 1.0D), Mth.nextDouble(RandomSource.create(), -2.2D, 2.2D));
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), y + Mth.nextDouble(RandomSource.create(), -1.0D, 2.0D), z + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -0.7D, 0.5D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D));
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), y + Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), z + Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), Mth.nextDouble(RandomSource.create(), -0.7D, 1.0D), Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D));
               world.addParticle(ParticleTypes.FLASH, x + 0.5D, y + 1.5D, z + 1.5D, 0.0D, 0.5D, 0.0D);
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
