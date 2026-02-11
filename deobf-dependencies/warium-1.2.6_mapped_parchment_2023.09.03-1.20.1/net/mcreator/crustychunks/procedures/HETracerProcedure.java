package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;

public class HETracerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         ForceChunksProcedure.execute(world, x, y, z);
         if (!immediatesourceentity.isUnderWater()) {
            SimpleParticleType var10001 = (SimpleParticleType)CrustyChunksModParticleTypes.TRACER.get();
            double var10005 = immediatesourceentity.getLookAngle().x * -1.0D;
            double var10006;
            Projectile _projEnt;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10006 = _projEnt.getDeltaMovement().length();
            } else {
               var10006 = 0.0D;
            }

            var10005 *= var10006;
            var10006 = immediatesourceentity.getLookAngle().y * -1.0D;
            double var10007;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10007 = _projEnt.getDeltaMovement().length();
            } else {
               var10007 = 0.0D;
            }

            var10006 *= var10007;
            var10007 = immediatesourceentity.getLookAngle().z;
            double var10008;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10008 = _projEnt.getDeltaMovement().length();
            } else {
               var10008 = 0.0D;
            }

            world.addParticle(var10001, x, y, z, var10005, var10006, var10007 * var10008);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, 0.0D, 0.0D, 0.0D);
         } else {
            TankFireProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
