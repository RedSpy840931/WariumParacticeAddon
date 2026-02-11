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

public class AirRaidProcedure {
   public static void execute(LevelAccessor world, double x, double z) {
      double Riflers = 0.0D;
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      double strikers = 0.0D;
      double workers = 0.0D;
      double reapers = 0.0D;
      double hunters = 0.0D;
      if (world.getLevelData().getGameRules().getBoolean(CrustyChunksModGameRules.APOCALYPSE_MODE)) {
         reapers = Math.min(1.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseReapers -= reapers;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         hunters = Math.min(1.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters);
         CrustyChunksModVariables.MapVariables.get(world).ApocalypseHunters -= hunters;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
      } else {
         reapers = 1.0D;
         hunters = 1.0D;
      }

      int index1;
      ServerLevel _level;
      Entity entityToSpawn;
      for(index1 = 0; index1 < (int)reapers; ++index1) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -25, 25);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -25, 25);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.REAPER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 20), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

      for(index1 = 0; index1 < (int)hunters; ++index1) {
         spawnx = x + (double)Mth.nextInt(RandomSource.create(), -25, 25);
         spawnz = z + (double)Mth.nextInt(RandomSource.create(), -25, 25);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = ((EntityType)CrustyChunksModEntities.HUNTER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 10), spawnz), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
            }
         }
      }

   }
}
