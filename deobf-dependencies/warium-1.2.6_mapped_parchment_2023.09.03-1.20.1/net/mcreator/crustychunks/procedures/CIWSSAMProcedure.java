package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SeekerSpearMissileProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class CIWSSAMProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Xvector = 0.0D;
         double Zvector = 0.0D;
         double Pitch = 0.0D;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 8, true, false));
            }
         }

         if (entity.getPersistentData().getDouble("Rocket") < 4.0D) {
            if (entity instanceof Mob) {
               Mob _entity = (Mob)entity;
               _entity.getNavigation().stop();
            }

            if (world instanceof ServerLevel) {
               ServerLevel projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new SeekerSpearMissileProjectileEntity((EntityType)CrustyChunksModEntities.SEEKER_SPEAR_MISSILE_PROJECTILE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 1.0F, 1);
               _entityToSpawn.setPos(x + entity.getLookAngle().x * 2.0D, y + 3.0D, z + entity.getLookAngle().z * 2.0D);
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y + 0.08D, entity.getLookAngle().z, 5.0F, 1.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            entity.getPersistentData().putDouble("T", (double)Mth.nextInt(RandomSource.create(), 15, 20));
            entity.getPersistentData().putDouble("Rocket", entity.getPersistentData().getDouble("Rocket") + 1.0D);
            Level _level;
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:heavylaunch")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:heavylaunch")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:peelerpodfar")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:peelerpodfar")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
               }
            }
         }

      }
   }
}
