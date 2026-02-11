package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.entity.SmokeLauncherProjectileEntity;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorSmokeScreenProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof DecimatorEntity) {
            ((DecimatorEntity)entity).setAnimation("SmokeDeploy");
         }

         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new SmokeLauncherProjectileEntity((EntityType)CrustyChunksModEntities.SMOKE_LAUNCHER_PROJECTILE.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setCritArrow(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 5.0F, 1);
            _entityToSpawn.setPos(x, y + 2.0D, z);
            _entityToSpawn.shoot(entity.getLookAngle().x, 0.25D, entity.getLookAngle().z, 1.0F, 45.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.egg.throw")), SoundSource.NEUTRAL, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.egg.throw")), SoundSource.NEUTRAL, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
            }
         }

      }
   }
}
