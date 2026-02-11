package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SmallAIBulletEntity;
import net.mcreator.crustychunks.entity.SmallMuzzleFlashProducerEntity;
import net.mcreator.crustychunks.entity.WorkerEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkerRifleProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Level _level;
         if (entity.getPersistentData().getDouble("Mag") < 20.0D) {
            Mob _entity;
            if (entity instanceof Mob) {
               _entity = (Mob)entity;
               _entity.getNavigation().stop();
            }

            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new SmallAIBulletEntity((EntityType)CrustyChunksModEntities.SMALL_AI_BULLET.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)3);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.0F, 1.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               ServerLevel projectileLevel = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new SmallMuzzleFlashProducerEntity((EntityType)CrustyChunksModEntities.SMALL_MUZZLE_FLASH_PRODUCER.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 0.0F, 0);
               _entityToSpawn.setPos(x + entity.getLookAngle().x * 2.25D, y + (double)entity.getEyeHeight() + entity.getLookAngle().y * 2.25D, z + entity.getLookAngle().z * 2.25D);
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 0.0F, 0.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (entity instanceof Mob) {
               _entity = (Mob)entity;
               _entity.getNavigation().stop();
            }

            entity.getPersistentData().putDouble("T", 3.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantgunfire")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantgunfire")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D), false);
               }
            }

            if (entity instanceof WorkerEntity) {
               ((WorkerEntity)entity).setAnimation("fire");
            }

            entity.getPersistentData().putDouble("Mag", entity.getPersistentData().getDouble("Mag") + 1.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumcasing")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumcasing")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D), false);
               }
            }
         } else {
            entity.getPersistentData().putDouble("T", (double)Mth.nextInt(RandomSource.create(), 90, 120));
            entity.getPersistentData().putDouble("Mag", 0.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }
         }

      }
   }
}
