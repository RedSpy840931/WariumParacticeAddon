package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;

public class NuclearSecondEffectRenderProcedure {
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
         int index5;
         if (0.0D <= immediatesourceentity.getPersistentData().getDouble("T") && 20.0D >= immediatesourceentity.getPersistentData().getDouble("T")) {
            for(index5 = 0; index5 < 5; ++index5) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), y - 7.0D + Mth.nextDouble(RandomSource.create(), -40.0D, 15.0D), z + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), 0.0D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
            }

            for(index5 = 0; index5 < 7; ++index5) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_STATIC_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -6.0D, 6.0D), y - 7.0D + Mth.nextDouble(RandomSource.create(), 7.0D, 15.0D), z + Mth.nextDouble(RandomSource.create(), -6.0D, 6.0D), Mth.nextDouble(RandomSource.create(), -0.6D, 0.6D), Mth.nextDouble(RandomSource.create(), -0.7D, 0.25D), Mth.nextDouble(RandomSource.create(), -0.6D, 0.6D));
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -11.0D, 11.0D), y - 7.0D + Mth.nextDouble(RandomSource.create(), 9.0D, 25.0D), z + Mth.nextDouble(RandomSource.create(), -11.0D, 11.0D), Mth.nextDouble(RandomSource.create(), -1.25D, 1.25D), Mth.nextDouble(RandomSource.create(), 0.25D, 1.25D), Mth.nextDouble(RandomSource.create(), -1.25D, 1.25D));
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_FIREBALL.get(), x + Mth.nextDouble(RandomSource.create(), -9.0D, 9.0D), y - 7.0D + Mth.nextDouble(RandomSource.create(), 9.0D, 30.0D), z + Mth.nextDouble(RandomSource.create(), -10.0D, 10.0D), Mth.nextDouble(RandomSource.create(), -1.25D, 1.25D), Mth.nextDouble(RandomSource.create(), 0.25D, 1.25D), Mth.nextDouble(RandomSource.create(), -1.25D, 1.25D));
            }
         }

         if (40.0D == immediatesourceentity.getPersistentData().getDouble("T")) {
            sx = -80.0D;

            for(index5 = 0; index5 < 160; ++index5) {
               sz = -80.0D;

               for(int index3 = 0; index3 < 160; ++index3) {
                  if (1 == Mth.nextInt(RandomSource.create(), 1, 1600) && Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 80.0D) {
                     world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.GROUND_HUGE_SMOKE.get(), x + sx, (double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)x, (int)z) + Mth.nextDouble(RandomSource.create(), 8.0D, 17.0D), z + sz, Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
                  }

                  ++sz;
               }

               ++sx;
            }
         }

         if (400.0D <= immediatesourceentity.getPersistentData().getDouble("T") && 410.0D >= immediatesourceentity.getPersistentData().getDouble("T")) {
            for(index5 = 0; index5 < 25; ++index5) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), y + Mth.nextDouble(RandomSource.create(), -80.0D, 55.0D) - 1.0D, z + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), 0.0D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
            }

            for(index5 = 0; index5 < 35; ++index5) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -15.0D, 15.0D), y + Mth.nextDouble(RandomSource.create(), 55.0D, 65.0D) - 1.0D, z + Mth.nextDouble(RandomSource.create(), -15.0D, 15.0D), Mth.nextDouble(RandomSource.create(), -0.6D, 0.6D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.8D), Mth.nextDouble(RandomSource.create(), -0.6D, 0.6D));
            }

            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
