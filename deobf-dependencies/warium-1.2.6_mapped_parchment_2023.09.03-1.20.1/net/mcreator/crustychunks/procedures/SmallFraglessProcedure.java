package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SmallClientEffectEntity;
import net.mcreator.crustychunks.entity.SplashEffectClientBypassEntity;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.registries.ForgeRegistries;

public class SmallFraglessProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      Level _level;
      ServerLevel projectileLevel;
      Projectile _entityToSpawn;
      if (world.getFluidState(BlockPos.containing(x, y + 1.0D, z)).createLegacyBlock().getBlock() instanceof LiquidBlock) {
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new SplashEffectClientBypassEntity((EntityType)CrustyChunksModEntities.SPLASH_EFFECT_CLIENT_BYPASS.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 0);
            _entityToSpawn.setPos(x, y + 1.5D, z);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.3F, 180.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x, y, z, 3.0F, ExplosionInteraction.TNT);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x, y, z, 5.0F, ExplosionInteraction.NONE);
            }
         }
      } else if (world instanceof ServerLevel) {
         projectileLevel = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new SmallClientEffectEntity((EntityType)CrustyChunksModEntities.SMALL_CLIENT_EFFECT.get(), level);
               entityToSpawn.setBaseDamage((double)damage);
               entityToSpawn.setKnockback(knockback);
               entityToSpawn.setSilent(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 0.0F, 0);
         _entityToSpawn.setPos(x, y, z);
         _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.3F, 180.0F);
         projectileLevel.addFreshEntity(_entityToSpawn);
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x, y, z, 2.5F, ExplosionInteraction.TNT);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 120.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 1.2D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 120.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 1.2D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 1.2D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 1.2D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
         }
      }

   }
}
