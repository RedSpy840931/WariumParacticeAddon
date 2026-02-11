package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SmallBombProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ClusterBombTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean Trigger = false;
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         if (!(immediatesourceentity.getPersistentData().getDouble("Time") <= 30.0D)) {
            for(int index0 = 0; index0 < 4; ++index0) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new SmallBombProjectileEntity((EntityType)CrustyChunksModEntities.SMALL_BOMB_PROJECTILE.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 5.0F, 1);
                  _entityToSpawn.setPos(x, y, z);
                  double var10001 = immediatesourceentity.getDeltaMovement().x();
                  double var10002 = immediatesourceentity.getDeltaMovement().y();
                  double var10003 = immediatesourceentity.getDeltaMovement().z();
                  double var10004;
                  if (immediatesourceentity instanceof Projectile) {
                     Projectile _projEnt = (Projectile)immediatesourceentity;
                     var10004 = _projEnt.getDeltaMovement().length();
                  } else {
                     var10004 = 0.0D;
                  }

                  _entityToSpawn.shoot(var10001, var10002, var10003, (float)var10004, 12.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }

            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         if (immediatesourceentity.isUnderWater()) {
            ClusterRocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
