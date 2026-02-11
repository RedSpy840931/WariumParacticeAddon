package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.HugeAIBulletEntity;
import net.mcreator.crustychunks.entity.StrikerEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class HunterCannonProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Level _level;
         if (entity.getPersistentData().getDouble("Mag") < 15.0D) {
            Level projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HugeAIBulletEntity((EntityType)CrustyChunksModEntities.HUGE_AI_BULLET.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)3);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, 2.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            entity.getPersistentData().putDouble("T", 6.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.NEUTRAL, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.NEUTRAL, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }

            if (entity instanceof StrikerEntity) {
               ((StrikerEntity)entity).setAnimation("Shoot");
            }

            entity.getPersistentData().putDouble("Mag", entity.getPersistentData().getDouble("Mag") + 1.0D);
         } else {
            entity.getPersistentData().putDouble("T", 200.0D);
            entity.getPersistentData().putDouble("Mag", 0.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }
         }

      }
   }
}
