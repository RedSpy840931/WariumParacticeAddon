package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class CommanderPodHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

         HeavyCrackProcedureProcedure.execute(world, x, y, z);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x + 0.5D, y + 1.5D, z + 0.5D, 25, 1.0D, 1.0D, 1.0D, 0.1D);
         }

         world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
         CrustyChunksMod.queueServerWork(20, () -> {
            ServerLevel _level;
            Entity entityToSpawn;
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)CrustyChunksModEntities.COMMANDER.get()).spawn(_level, BlockPos.containing(x + 0.5D, y + 1.0D, z + 0.5D), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = ((EntityType)CrustyChunksModEntities.SCOUT.get()).spawn(_level, BlockPos.containing(x + 0.5D, y + 2.0D, z + 0.5D), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
               }
            }

         });
         MicroExplosionProcedure.execute(world, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
      }
   }
}
