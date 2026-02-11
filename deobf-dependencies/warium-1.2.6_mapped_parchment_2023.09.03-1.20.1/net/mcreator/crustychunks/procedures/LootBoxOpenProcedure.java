package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class LootBoxOpenProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double random = 0.0D;
      random = (double)Mth.nextInt(RandomSource.create(), 1, 17);
      int index14;
      ServerLevel _level;
      ItemEntity entityToSpawn;
      ServerLevel _level;
      if (1.0D == random) {
         for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 6, 9); ++index14) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.SMALLBULLET.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }

         for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 5, 6); ++index14) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.BULLET.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }

         for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 2, 3); ++index14) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.LARGE_BULLET.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }
      } else if (2.0D == random) {
         for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 2); ++index14) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.GRENADE.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }
      } else {
         ItemEntity entityToSpawn;
         if (3.0D == random) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ARMOR_PEELER_ROCKET.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (4.0D == random) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 5); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ALUMINUM_PLATE.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 5); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_INGOT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 5); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }
         } else if (5.0D == random) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 3); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.ELECTRIC_MOTOR.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }
         } else if (6.0D == random) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.SMG_RECEIVER.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_BORED_BARREL.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (7.0D == random) {
            world.setBlock(BlockPos.containing(x, y, z), ((Block)CrustyChunksModBlocks.OIL.get()).defaultBlockState(), 3);
         } else if (8.0D == random) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 3, 5); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.HUGE_BULLET.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }
         } else if (9.0D == random) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 6, 9); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.BRASS_PLATE.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 6, 9); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.COPPER_PLATE.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }
         } else if (10.0D <= random && 16.0D >= random) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)CrustyChunksModEntities.STRIKER.get()).spawn(_level, BlockPos.containing(x + 0.5D, y + 0.5D, z + 0.5D), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
               }
            }
         } else if (17.0D == random) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 6, 9); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Items.IRON_INGOT));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 2, 3); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Items.DIAMOND));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 2, 3); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Items.GOLD_INGOT));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 2, 3); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Items.EMERALD));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }
         }
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 0.5D, z + 0.5D, 5, 1.0D, 1.0D, 1.0D, 0.1D);
      }

      if (world instanceof Level) {
         Level _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x + 0.5D, y + 0.5D, z + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 2.0F, 1.0F);
         } else {
            _level.playLocalSound(x + 0.5D, y + 0.5D, z + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
         }
      }

   }
}
