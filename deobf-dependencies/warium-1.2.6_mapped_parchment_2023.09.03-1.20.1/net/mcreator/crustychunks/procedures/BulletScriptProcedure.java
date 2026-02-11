package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class BulletScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.getDeltaMovement().length();
         } else {
            var10000 = 0.0D;
         }

         if (var10000 >= 2.0D) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y() + 0.04D, immediatesourceentity.getDeltaMovement().z()));
         }

         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.BULLET_TRAIL.get(), x, y, z, immediatesourceentity.getDeltaMovement().x() * 0.1D, immediatesourceentity.getDeltaMovement().y() * 0.1D, immediatesourceentity.getDeltaMovement().z() * 0.1D);
      }
   }
}
