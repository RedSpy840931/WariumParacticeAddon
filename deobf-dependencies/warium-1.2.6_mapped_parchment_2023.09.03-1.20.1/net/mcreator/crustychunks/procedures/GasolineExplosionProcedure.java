package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.FlameThrowerEmberEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class GasolineExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      sx = -4.0D;
      found = false;

      int index3;
      for(index3 = 0; index3 < 8; ++index3) {
         sy = -3.0D;

         for(int index1 = 0; index1 < 4; ++index1) {
            sz = -4.0D;

            for(int index2 = 0; index2 < 8; ++index2) {
               if (Math.sqrt(Math.pow(sx, 2.0D) + Math.pow(sz, 2.0D)) < 3.0D) {
                  BurnBlockProcedure.execute(world, x + sx, y + sy, z + sz);
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      world.destroyBlock(BlockPos.containing(x, y, z), false);
      ServerLevel _level;
      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.FLAME, x, y + 1.0D, z, 15, 0.5D, 0.5D, 0.5D, 0.6D);
      }

      for(index3 = 0; index3 < 50; ++index3) {
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new FlameThrowerEmberEntity((EntityType)CrustyChunksModEntities.FLAME_THROWER_EMBER.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setPierceLevel(piercing);
                  entityToSpawn.setSecondsOnFire(100);
                  entityToSpawn.setCritArrow(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 1.0F, 0, (byte)2);
            _entityToSpawn.setPos(x + 0.0D, y + 0.0D, z + 0.0D);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.2F, 180.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0.5D, 0.5D, 0.5D, 0.6D);
      }

   }
}
