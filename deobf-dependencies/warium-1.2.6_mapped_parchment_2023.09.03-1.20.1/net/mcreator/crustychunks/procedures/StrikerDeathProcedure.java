package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.AssassinEntity;
import net.mcreator.crustychunks.entity.BreacherEntity;
import net.mcreator.crustychunks.entity.CommanderEntity;
import net.mcreator.crustychunks.entity.StrikerEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class StrikerDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
            }
         }

         world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(((Block)CrustyChunksModBlocks.STEEL_BLOCK.get()).defaultBlockState()));
         world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(((Block)CrustyChunksModBlocks.GREEN_ARMOR.get()).defaultBlockState()));
         ServerLevel _level;
         ItemEntity entityToSpawn;
         int index14;
         ItemEntity entityToSpawn;
         ServerLevel _level;
         if (entity instanceof StrikerEntity) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 12); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALLBULLET.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 1); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_INGOT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 2); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 20) && world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_BORED_BARREL.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (entity instanceof AssassinEntity) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 12); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_STEALTH_BULLET.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 1); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_INGOT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 2); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 20) && world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_BORED_BARREL.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 20) && world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.WEAPON_SUPRESSOR.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (entity instanceof CommanderEntity) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 12); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BULLET.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 1); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_INGOT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 1); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 3); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 4) && world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_BORED_BARREL.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         } else if (entity instanceof BreacherEntity) {
            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 0, 1); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BRASS_FITTING.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 2, 3); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.VOLATILE_DUST.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 1, 1); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.ADVANCED_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 2, 3); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_INGOT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }

            for(index14 = 0; index14 < Mth.nextInt(RandomSource.create(), 3, 4); ++index14) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 1.0D, z, 5, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x, y + 1.0D, z, 5, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
