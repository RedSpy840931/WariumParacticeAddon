package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.entity.MuzzleFlashProducerEntity;
import net.mcreator.crustychunks.entity.SmallShellFireEntity;
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

public class DecimatorCannonFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 8, true, false));
            }
         }

         Projectile _entityToSpawn;
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new SmallShellFireEntity((EntityType)CrustyChunksModEntities.SMALL_SHELL_FIRE.get(), level);
                  entityToSpawn.setOwner(shooter);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setCritArrow(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, entity, 1.0F, 1);
            _entityToSpawn.setPos(x + entity.getLookAngle().x * 2.0D, y + 2.0D + entity.getLookAngle().y * 2.0D, z + entity.getLookAngle().z * 2.0D);
            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.0F, 2.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new MuzzleFlashProducerEntity((EntityType)CrustyChunksModEntities.MUZZLE_FLASH_PRODUCER.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 0);
            _entityToSpawn.setPos(x + entity.getLookAngle().x * 3.0D, y + 3.0D + entity.getLookAngle().y * 3.0D, z + entity.getLookAngle().z * 3.0D);
            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.0F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         entity.getPersistentData().putDouble("T", (double)Mth.nextInt(RandomSource.create(), 9, 11));
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 25.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.4D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 25.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.4D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:heavyautocannonshot")), SoundSource.NEUTRAL, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:heavyautocannonshot")), SoundSource.NEUTRAL, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
            }
         }

         if (entity instanceof DecimatorEntity) {
            ((DecimatorEntity)entity).setAnimation("Shoot");
         }

      }
   }
}
