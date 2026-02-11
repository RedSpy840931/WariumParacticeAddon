package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.MuzzleFlashProducerEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class MuzzleFlashProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel) {
         ServerLevel projectileLevel = (ServerLevel)world;
         Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new MuzzleFlashProducerEntity((EntityType)CrustyChunksModEntities.MUZZLE_FLASH_PRODUCER.get(), level);
               entityToSpawn.setBaseDamage((double)damage);
               entityToSpawn.setKnockback(knockback);
               entityToSpawn.setSilent(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 0.0F, 0);
         _entityToSpawn.setPos(x, y, z);
         _entityToSpawn.shoot(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
         projectileLevel.addFreshEntity(_entityToSpawn);
      }

   }
}
