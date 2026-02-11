package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class FireClientEffectTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double particleAmount = 0.0D;
         immediatesourceentity.noPhysics = true;
         if (!immediatesourceentity.getPersistentData().getBoolean("Used")) {
            int index1;
            for(index1 = 0; index1 < 35; ++index1) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), y + Mth.nextDouble(RandomSource.create(), 0.0D, 3.0D), z + Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), Mth.nextDouble(RandomSource.create(), -4.0D, 4.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 2.0D), Mth.nextDouble(RandomSource.create(), -4.0D, 4.0D));
            }

            for(index1 = 0; index1 < 35; ++index1) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x, y, z, Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D), Mth.nextDouble(RandomSource.create(), -3.0D, 3.0D));
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
