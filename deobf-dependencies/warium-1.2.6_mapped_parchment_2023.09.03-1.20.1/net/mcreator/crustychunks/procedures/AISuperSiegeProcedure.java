package net.mcreator.crustychunks.procedures;

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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;

public class AISuperSiegeProcedure {
   public static void execute(LevelAccessor world, double x, double z) {
      double Modules = 0.0D;
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      double Riflers = 0.0D;
      double Commanders = 0.0D;
      double Decimators = 0.0D;
      double Mortarers = 0.0D;
      double Flamers = 0.0D;
      double Hunters = 0.0D;
      double eradicators = 0.0D;
      double reapers = 0.0D;
      if (world.getLevelData().getGameRules().getBoolean(CrustyChunksModGameRules.APOCALYPSE_MODE)) {
         Riflers = Math.min((double)Mth.nextInt(RandomSource.create(), 3, 4), CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers -= Riflers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Hunters = Math.min((double)Mth.nextInt(RandomSource.create(), 2, 3), CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters -= Hunters;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Commanders = Math.min(3.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseCommanders);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseCommanders -= Commanders;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Mortarers = Math.min((double)Mth.nextInt(RandomSource.create(), 2, 4), CrustyChunksModVariables.MapVariables.get(world).ApocalypseArtillery);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseArtillery -= Mortarers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         Decimators = Math.min((double)Mth.nextInt(RandomSource.create(), 1, 2), CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseDecimators -= Decimators;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         eradicators = Math.min(1.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseEradicators);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseEradicators -= eradicators;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         reapers = Math.min(2.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers -= reapers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
      } else {
         reapers = 2.0D;
         Riflers = (double)Mth.nextInt(RandomSource.create(), 3, 4);
         Hunters = (double)Mth.nextInt(RandomSource.create(), 2, 3);
         Commanders = 3.0D;
         Mortarers = (double)Mth.nextInt(RandomSource.create(), 2, 4);
         Decimators = (double)Mth.nextInt(RandomSource.create(), 1, 2);
         Flamers = (double)Mth.nextInt(RandomSource.create(), 0, 1);
         eradicators = 1.0D;
      }

      int index6;
      ServerLevel _level;
      Entity entityToSpawn;
      for(index6 = 0; index6 < (int)Riflers; ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.RIFLER_POD.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 350), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

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

      for(index6 = 0; index6 < (int)eradicators; ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)CrustyChunksModEntities.PROTOTYPE_ERADICATOR.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
               }
            }
         } else if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.ERADICATOR.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index6 = 0; index6 < (int)Decimators; ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.DECIMATOR.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index6 = 0; index6 < (int)reapers; ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), 75, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, -75);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.REAPER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + Mth.nextInt(RandomSource.create(), 35, 55)), spawnz), MobSpawnType.MOB_SUMMONED);
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
            entityToSpawn = ((EntityType)CrustyChunksModEntities.MORTARER.get()).spawn(_level, BlockPos.containing(spawnx, (double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 0.5D, spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index6 = 0; index6 < Mth.nextInt(RandomSource.create(), 1, 2); ++index6) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.SCOUT.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 15), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

   }
}
