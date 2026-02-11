package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SpaceThermalRadEntityEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class SpaceFissionExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double xRadius = 0.0D;
      double loop = 0.0D;
      double zRadius = 0.0D;
      double particleAmount = 0.0D;
      SpaceScorchProcedure.execute(world, x, y, z, 0.5D);
      SpacePlasmaCraterProcedure.execute(world, x, y, z, 0.5D);
      if (!world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
      }

      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x, y, z, 60.0F, ExplosionInteraction.BLOCK);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x, y, z, 45.0F, ExplosionInteraction.NONE);
         }
      }

      if (world instanceof ServerLevel) {
         ServerLevel projectileLevel = (ServerLevel)world;
         Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new SpaceThermalRadEntityEntity((EntityType)CrustyChunksModEntities.SPACE_THERMAL_RAD_ENTITY.get(), level);
               entityToSpawn.setBaseDamage((double)damage);
               entityToSpawn.setKnockback(knockback);
               entityToSpawn.setSilent(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 5.0F, 1);
         _entityToSpawn.setPos(x, y, z);
         _entityToSpawn.shoot(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
         projectileLevel.addFreshEntity(_entityToSpawn);
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:spacenuke")), SoundSource.BLOCKS, 100.0F, 1.0F);
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:spacenuke")), SoundSource.BLOCKS, 100.0F, 1.0F, false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rumble")), SoundSource.BLOCKS, 100.0F, 1.0F);
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rumble")), SoundSource.BLOCKS, 100.0F, 1.0F, false);
         }
      }

   }
}
