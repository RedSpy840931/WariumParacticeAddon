package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.CIWSEntity;
import net.mcreator.crustychunks.entity.HugeAIBulletEntity;
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

public class CIWSGunProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Barrels = 0.0D;
         double Xvector = 0.0D;
         double DrumPosition = 0.0D;
         double Zvector = 0.0D;
         double Pitch = 0.0D;
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
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, entity, 0.1F, 1, (byte)3);
            _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 8.0F, 2.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:brtttfar")), SoundSource.BLOCKS, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:brtttfar")), SoundSource.BLOCKS, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rac")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rac")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.BLOCKS, 8.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.6D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.BLOCKS, 8.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.6D), false);
            }
         }

         if (entity instanceof CIWSEntity) {
            ((CIWSEntity)entity).setAnimation("Fire");
         }

      }
   }
}
