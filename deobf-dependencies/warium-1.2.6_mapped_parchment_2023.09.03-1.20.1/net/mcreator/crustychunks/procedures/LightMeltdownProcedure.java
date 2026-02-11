package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.RadioactiveCloudDetectorEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LightMeltdownProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      ServerLevel projectileLevel;
      if (world instanceof ServerLevel) {
         projectileLevel = (ServerLevel)world;
         projectileLevel.sendParticles(ParticleTypes.ASH, x + 0.5D, y + 3.0D, z + 0.5D, 90, 5.0D, 3.0D, 5.0D, 0.0D);
      }

      Vec3 _center = new Vec3(x + 0.5D, y + 0.5D, z + 0.5D);
      List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(5.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.distanceToSqr(_center);
      })).toList();
      Iterator var9 = _entfound.iterator();

      while(var9.hasNext()) {
         Entity entityiterator = (Entity)var9.next();
         entityiterator.getPersistentData().putDouble("Radiation", entityiterator.getPersistentData().getDouble("Radiation") + 20.0D);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.RADIATION.get(), 60, 1, false, false));
            }
         }
      }

      if (world instanceof ServerLevel) {
         projectileLevel = (ServerLevel)world;
         Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new RadioactiveCloudDetectorEntity((EntityType)CrustyChunksModEntities.RADIOACTIVE_CLOUD_DETECTOR.get(), level);
               entityToSpawn.setBaseDamage((double)damage);
               entityToSpawn.setKnockback(knockback);
               entityToSpawn.setSilent(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 5.0F, 1);
         _entityToSpawn.setPos(x + 0.5D, y + 0.5D, z + 0.5D);
         _entityToSpawn.shoot(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
         projectileLevel.addFreshEntity(_entityToSpawn);
      }

   }
}
