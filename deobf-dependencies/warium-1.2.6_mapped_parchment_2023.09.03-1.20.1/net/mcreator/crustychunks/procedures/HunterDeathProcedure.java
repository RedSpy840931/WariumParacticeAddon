package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class HunterDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         SmallExplosionProcedure.execute(world, x, y, z);
         GasolineExplosionProcedure.execute(world, x, y, z);
         if (!entity.level().isClientSide()) {
            entity.discard();
         }

         CrustyChunksMod.queueServerWork(60, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel _levelx = (ServerLevel)world;
               ItemEntity entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ENGINE_COMPONENT.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

            for(int index0 = 0; index0 < 3; ++index0) {
               ItemEntity entityToSpawnx;
               ServerLevel _level;
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ALUMINUM_PLATE.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.HUGE_BULLET.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.HUGE_BULLET.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ELECTRIC_MOTOR.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }
            }

         });
      }
   }
}
