package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.CommanderPodEntity;
import net.mcreator.crustychunks.entity.RiflerPodEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;

public class AISiegeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Modules = 0.0D;
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      double Strikers = 0.0D;
      double Riflers = 0.0D;
      double Commanders = 0.0D;
      double Hunters = 0.0D;
      double Mortarers = 0.0D;
      double Decimators = 0.0D;
      double Flamers = 0.0D;
      double Reapers = 0.0D;
      if (world.getLevelData().getGameRules().getBoolean(CrustyChunksModGameRules.APOCALYPSE_MODE)) {
         Riflers = Math.min((double)Mth.nextInt(RandomSource.create(), 3, 4), CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers -= Riflers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Hunters = Math.min((double)Mth.nextInt(RandomSource.create(), 1, 2), CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters -= Hunters;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Commanders = Math.min(3.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseCommanders);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseCommanders -= Commanders;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Mortarers = Math.min((double)Mth.nextInt(RandomSource.create(), 2, 4), CrustyChunksModVariables.MapVariables.get(world).ApocalypseArtillery);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseArtillery -= Mortarers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Decimators = Math.min(1.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators -= Decimators;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Flamers = Math.min((double)Mth.nextInt(RandomSource.create(), 0, 1), CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators -= Flamers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Reapers = Math.min(1.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers -= Reapers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
      } else {
         Reapers = 1.0D;
         Riflers = (double)Mth.nextInt(RandomSource.create(), 3, 4);
         Hunters = (double)Mth.nextInt(RandomSource.create(), 1, 2);
         Commanders = 3.0D;
         Mortarers = (double)Mth.nextInt(RandomSource.create(), 2, 4);
         Decimators = 1.0D;
         Flamers = (double)Mth.nextInt(RandomSource.create(), 0, 1);
      }

      int index6;
      ServerLevel _level;
      Entity entityToSpawn;
      for(index6 = 0; index6 < (int)Hunters; ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.HUNTER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 45), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      Projectile _entityToSpawn;
      for(index6 = 0; index6 < (int)Riflers; ++index6) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new RiflerPodEntity((EntityType)CrustyChunksModEntities.RIFLER_POD.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(_level, 5.0F, 1);
            _entityToSpawn.setPos(x + (double)Mth.nextInt(RandomSource.create(), -30, 30), y + 350.0D, z + (double)Mth.nextInt(RandomSource.create(), -30, 30));
            _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 1.0F, 25.0F);
            _level.addFreshEntity(_entityToSpawn);
         }
      }

      for(index6 = 0; index6 < (int)Commanders; ++index6) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new CommanderPodEntity((EntityType)CrustyChunksModEntities.COMMANDER_POD.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(_level, 5.0F, 1);
            _entityToSpawn.setPos(x + (double)Mth.nextInt(RandomSource.create(), -30, 30), y + 350.0D, z + (double)Mth.nextInt(RandomSource.create(), -30, 30));
            _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 1.0F, 25.0F);
            _level.addFreshEntity(_entityToSpawn);
         }
      }

      spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
      spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);

      for(index6 = 0; index6 < (int)Decimators; ++index6) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.DECIMATOR.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 450), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index6 = 0; index6 < (int)Reapers; ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), 75, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), 75, 100);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.REAPER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + Mth.nextInt(RandomSource.create(), 35, 45)), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index6 = 0; index6 < (int)Flamers; ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.FLAMER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 450), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index6 = 0; index6 < (int)Mortarers; ++index6) {
         if (Mth.nextInt(RandomSource.create(), 0, 1) == 1) {
            spawnx = x + (double)Mth.nextInt(RandomSource.create(), 100, 150);
         } else {
            spawnx = x + (double)Mth.nextInt(RandomSource.create(), -150, -100);
         }

         if (Mth.nextInt(RandomSource.create(), 0, 1) == 1) {
            spawnz = z + (double)Mth.nextInt(RandomSource.create(), 100, 150);
         } else {
            spawnz = z + (double)Mth.nextInt(RandomSource.create(), -150, -100);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.MORTARER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 450), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

   }
}
