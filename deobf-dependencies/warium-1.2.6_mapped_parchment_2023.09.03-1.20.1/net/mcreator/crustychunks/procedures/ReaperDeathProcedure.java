package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class ReaperDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         MediumExplosionProcedure.execute(world, x, y, z);
         if (!entity.level().isClientSide()) {
            entity.discard();
         }

         CrustyChunksMod.queueServerWork(60, () -> {
            for(int index0 = 0; index0 < 3; ++index0) {
               ServerLevel _level;
               ItemEntity entityToSpawnx;
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.ALUMINUM_PLATING.get()));
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
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.AUTOCANNON_BARREL.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.UNFABRICATED_TECH_COMPONENT.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_GEAR.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.CAST_COMPONENT.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ELECTRIC_MOTOR.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }
            }

            ServerLevel _levelx;
            ItemEntity entityToSpawn;
            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.TURBINE_ROTOR.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ALUMINUM_PLATE.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

         });
      }
   }
}
