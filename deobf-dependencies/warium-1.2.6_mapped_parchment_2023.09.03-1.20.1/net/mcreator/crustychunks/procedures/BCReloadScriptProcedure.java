package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BCReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
            LivingEntity _livEnt;
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            LivingEntity _livEnt;
            BlockEntity _blockEntity;
            BlockState _bs;
            Level _level;
            BlockPos _bp;
            Level _level;
            if (var10000.getItem() == CrustyChunksModItems.LARGE_SHELL.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.setCount(0);
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("Loaded", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("HE", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.SOLID_SHELL.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.setCount(0);
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("Loaded", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("SOLID", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.HEAT_SHELL.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.setCount(0);
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("Loaded", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("HEAT", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.AP_SHELL.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.setCount(0);
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("Loaded", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("AP", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.FLAK_SHELL.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.setCount(0);
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("Loaded", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("FLAK", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.SMOKE_SHELL.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.setCount(0);
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("Loaded", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("SMOKE", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.open")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }
         }

      }
   }
}
