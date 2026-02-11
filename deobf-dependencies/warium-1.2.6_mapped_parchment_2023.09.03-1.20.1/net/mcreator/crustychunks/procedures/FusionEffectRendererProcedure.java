package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;

public class FusionEffectRendererProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean found = false;
         double particleRadius = 0.0D;
         double particleAmount = 0.0D;
         double sx = 0.0D;
         double sy = 0.0D;
         double sz = 0.0D;
         immediatesourceentity.setNoGravity(true);
         immediatesourceentity.noPhysics = true;
         immediatesourceentity.setDeltaMovement(new Vec3(0.0D, 0.0D, 0.0D));
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         int index6;
         if (0.0D <= immediatesourceentity.getPersistentData().getDouble("T") && 17.0D >= immediatesourceentity.getPersistentData().getDouble("T")) {
            for(index6 = 0; index6 < 7; ++index6) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), y - 14.0D + Mth.nextDouble(RandomSource.create(), -80.0D, 15.0D), z + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), 0.0D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
            }

            for(index6 = 0; index6 < 7; ++index6) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_STATIC_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -8.0D, 8.0D), y - 14.0D + Mth.nextDouble(RandomSource.create(), 7.0D, 24.0D), z + Mth.nextDouble(RandomSource.create(), -8.0D, 8.0D), Mth.nextDouble(RandomSource.create(), -0.8D, 0.8D), Mth.nextDouble(RandomSource.create(), -0.7D, 0.25D), Mth.nextDouble(RandomSource.create(), -0.8D, 0.8D));
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -19.0D, 19.0D), y - 14.0D + Mth.nextDouble(RandomSource.create(), 12.0D, 35.0D), z + Mth.nextDouble(RandomSource.create(), -19.0D, 19.0D), Mth.nextDouble(RandomSource.create(), -1.7D, 1.7D), Mth.nextDouble(RandomSource.create(), 0.25D, 1.5D), Mth.nextDouble(RandomSource.create(), -1.7D, 1.7D));
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -12.0D, 12.0D), y - 14.0D + Mth.nextDouble(RandomSource.create(), 14.0D, 44.0D), z + Mth.nextDouble(RandomSource.create(), -12.0D, 12.0D), Mth.nextDouble(RandomSource.create(), -1.7D, 1.7D), Mth.nextDouble(RandomSource.create(), 0.25D, 1.5D), Mth.nextDouble(RandomSource.create(), -1.7D, 1.7D));
            }
         }

         if (40.0D == immediatesourceentity.getPersistentData().getDouble("T")) {
            sx = -80.0D;

            for(index6 = 0; index6 < 160; ++index6) {
               sz = -80.0D;

               for(int index3 = 0; index3 < 160; ++index3) {
                  if (1 == Mth.nextInt(RandomSource.create(), 1, 1200) && Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 200.0D) {
                     world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.GROUND_HUGE_SMOKE.get(), x + sx, (double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)x, (int)z) + Mth.nextDouble(RandomSource.create(), 8.0D, 17.0D), z + sz, Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
                  }

                  ++sz;
               }

               ++sx;
            }
         }

         if (700.0D <= immediatesourceentity.getPersistentData().getDouble("T") && 710.0D >= immediatesourceentity.getPersistentData().getDouble("T")) {
            for(index6 = 0; index6 < 30; ++index6) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), y - 7.0D + Mth.nextDouble(RandomSource.create(), -335.0D, 55.0D) + 40.0D, z + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), Mth.nextDouble(RandomSource.create(), -0.15D, 0.15D), Mth.nextDouble(RandomSource.create(), 0.0D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.15D, 0.15D));
            }

            for(index6 = 0; index6 < 40; ++index6) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -35.0D, 35.0D), y - 7.0D + Mth.nextDouble(RandomSource.create(), 52.0D, 80.0D) + 40.0D, z + Mth.nextDouble(RandomSource.create(), -35.0D, 35.0D), Mth.nextDouble(RandomSource.create(), -1.2D, 1.2D), Mth.nextDouble(RandomSource.create(), -0.5D, 1.3D), Mth.nextDouble(RandomSource.create(), -1.2D, 1.2D));
            }

            for(index6 = 0; index6 < 20; ++index6) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FUSION_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -15.0D, 15.0D), y - 7.0D + Mth.nextDouble(RandomSource.create(), 60.0D, 87.0D) + 40.0D, z + Mth.nextDouble(RandomSource.create(), -15.0D, 15.0D), Mth.nextDouble(RandomSource.create(), -1.1D, 1.1D), Mth.nextDouble(RandomSource.create(), -0.5D, 1.3D), Mth.nextDouble(RandomSource.create(), -1.1D, 1.1D));
            }

            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
