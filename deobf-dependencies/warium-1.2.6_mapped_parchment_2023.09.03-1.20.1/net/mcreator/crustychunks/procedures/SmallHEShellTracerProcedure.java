package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class SmallHEShellTracerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double magnitude = 0.0D;
         double vx = 0.0D;
         double vy = 0.0D;
         double vz = 0.0D;
         double yaw = 0.0D;
         double pitch = 0.0D;
         double var10000;
         Projectile _projEnt;
         if (immediatesourceentity instanceof Projectile) {
            _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.getDeltaMovement().length();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 >= 2.0D && !immediatesourceentity.isNoGravity()) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y() + 0.04D, immediatesourceentity.getDeltaMovement().z()));
         }

         if (immediatesourceentity instanceof Projectile) {
            _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.getDeltaMovement().length();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 <= 0.75D && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.BULLET_TRAIL.get(), immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ(), 0.0D, 0.0D, 0.0D);
         ForceChunksProcedure.execute(world, x, y, z);
         if (immediatesourceentity.isInWater()) {
            HugeHEBulletHitProcedure.execute(world, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ(), immediatesourceentity);
         }

      }
   }
}
