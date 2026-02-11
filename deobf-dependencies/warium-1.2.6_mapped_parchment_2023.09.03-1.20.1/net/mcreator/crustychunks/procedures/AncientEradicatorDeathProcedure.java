package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.EradicatorTurretEntity;
import net.mcreator.crustychunks.entity.FireClientEffectEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class AncientEradicatorDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         MediumExplosionProcedure.execute(world, x, y, z);
         ServerLevel projectileLevel;
         Projectile _entityToSpawn;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new FireClientEffectEntity((EntityType)CrustyChunksModEntities.FIRE_CLIENT_EFFECT.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 0);
            _entityToSpawn.setPos(x, y, z);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 1.0F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new EradicatorTurretEntity((EntityType)CrustyChunksModEntities.ERADICATOR_TURRET.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 0);
            _entityToSpawn.setPos(x, y + 2.0D, z);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 2.0F, 25.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (!entity.level().isClientSide()) {
            entity.discard();
         }

         CrustyChunksMod.queueServerWork(60, () -> {
            for(int index0 = 0; index0 < 3; ++index0) {
               ServerLevel _level;
               ItemEntity entityToSpawnx;
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.HEAT_SHELL.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.HEAT_SHELL.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.BATTLE_CANNON_BARREL.get()));
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
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.UNFABRICATED_TECH_COMPONENT.get()));
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
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
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

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawnx = new ItemEntity(_level, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.URANIUM_DEPLETED_INGOT.get()));
                  entityToSpawnx.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawnx);
               }
            }

            ServerLevel _levelx;
            ItemEntity entityToSpawn;
            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.MG_RECEIVER.get()));
               entityToSpawn.setPickUpDelay(10);
               entityToSpawn.setUnlimitedLifetime();
               _levelx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.BATTLE_CANNON_BREECH.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _levelx = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_levelx, x + 0.5D, y + 1.0D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModBlocks.STEEL_BLOCK.get()));
               entityToSpawn.setPickUpDelay(10);
               _levelx.addFreshEntity(entityToSpawn);
            }

         });
      }
   }
}
