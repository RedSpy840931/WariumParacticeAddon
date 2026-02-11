package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ArtilleryFireProjectileEntity;
import net.mcreator.crustychunks.entity.GasArtilleryProjectileEntity;
import net.mcreator.crustychunks.entity.MortarerEntity;
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

public class MortarerCannonProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Level projectileLevel;
         Projectile _entityToSpawn;
         if (1 == Mth.nextInt(RandomSource.create(), 1, 10)) {
            projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new GasArtilleryProjectileEntity((EntityType)CrustyChunksModEntities.GAS_ARTILLERY_PROJECTILE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 1.0F, 1);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 4.0F, 4.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         } else {
            projectileLevel = entity.level();
            if (!projectileLevel.isClientSide()) {
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new ArtilleryFireProjectileEntity((EntityType)CrustyChunksModEntities.ARTILLERY_FIRE_PROJECTILE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, entity, 1.0F, 1);
               _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
               _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 4.0F, 4.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         }

         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.NEUTRAL, 60.0F, 0.9F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.NEUTRAL, 60.0F, 0.9F, false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 60.0F, 0.9F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.NEUTRAL, 60.0F, 0.9F, false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonclose")), SoundSource.NEUTRAL, 20.0F, 0.8F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonclose")), SoundSource.NEUTRAL, 20.0F, 0.8F, false);
            }
         }

         if (entity instanceof MortarerEntity) {
            ((MortarerEntity)entity).setAnimation("Fire");
         }

         entity.getPersistentData().putDouble("T", (double)Mth.nextInt(RandomSource.create(), 320, 380));
      }
   }
}
