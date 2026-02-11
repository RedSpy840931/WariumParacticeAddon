package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AutoCannonShellTracerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean trigger = false;
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.getDeltaMovement().length();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 >= 2.0D && !immediatesourceentity.isNoGravity()) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y() + 0.01D, immediatesourceentity.getDeltaMovement().z()));
         }

         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.BULLET_TRAIL.get(), immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ(), 0.0D, 0.0D, 0.0D);
         if (immediatesourceentity.isUnderWater()) {
            trigger = true;
         }

         if (trigger) {
            trigger = false;
            CrustyChunksMod.queueServerWork(1, () -> {
               SmallShellHitProcedure.execute(world, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ(), immediatesourceentity);
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }

            });
         }

         ForceChunksProcedure.execute(world, x, y, z);
      }
   }
}
