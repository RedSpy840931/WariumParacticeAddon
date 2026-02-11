package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class MachineGunReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         Level _level;
         BlockEntity _blockEntity;
         BlockState _bs;
         LivingEntity _livEnt;
         BlockPos _bp;
         Player _player;
         ItemStack var10000;
         BlockPos _bp;
         LivingEntity _livEnt;
         ItemStack var10001;
         ItemStack var10002;
         Player _player;
         Level _level;
         BlockEntity _blockEntity;
         LivingEntity _livEnt;
         BlockState _bs;
         ItemStack _setstack;
         Player _player;
         Level _level;
         Level _level;
         CompoundTag var27;
         ItemCooldowns var28;
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.HEAVY_MACHINE_GUN.get()) {
            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getOrCreateTag().getDouble("AmmoSize") == 1.0D) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == CrustyChunksModItems.MACHINE_GUN_BOX.get()) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                        }
                     }

                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(x, y, z);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           var27 = _blockEntity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var27.putDouble("Ammo", var10002.getOrCreateTag().getDouble("Ammo"));
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
                           _blockEntity.getPersistentData().putBoolean("Loaded", true);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.setCount(0);
                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        var28 = _player.getCooldowns();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        var28.addCooldown(var10001.getItem(), 40);
                     }
                  }
               }
            } else if (((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getCount() == 0) {
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("Loaded", false);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     var28 = _player.getCooldowns();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     var28.addCooldown(var10001.getItem(), 40);
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.MACHINE_GUN_BOX.get())).copy();
                     _setstack.setCount(1);
                     _livEnt.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_livEnt instanceof Player) {
                        _player = (Player)_livEnt;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Ammo"));
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", 0.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("AmmoSize", 1.0D);
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                     }
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.MACHINE_GUN.get()) {
            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.MACHINE_GUN_BOX.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getOrCreateTag().getDouble("AmmoSize") == 0.0D) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                        }
                     }

                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(x, y, z);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           var27 = _blockEntity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var27.putDouble("Ammo", var10002.getOrCreateTag().getDouble("Ammo"));
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
                           _blockEntity.getPersistentData().putBoolean("Loaded", true);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.setCount(0);
                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        var28 = _player.getCooldowns();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        var28.addCooldown(var10001.getItem(), 40);
                     }
                  }
               }
            } else if (((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getCount() == 0) {
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("Loaded", false);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     var28 = _player.getCooldowns();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     var28.addCooldown(var10001.getItem(), 40);
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.MACHINE_GUN_BOX.get())).copy();
                     _setstack.setCount(1);
                     _livEnt.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_livEnt instanceof Player) {
                        _player = (Player)_livEnt;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Ammo"));
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("AmmoSize", 0.0D);
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", 0.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                     }
                  }
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.LIGHT_MACHINE_GUN.get()) {
            if (!((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.MACHINE_GUN_BOX.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getOrCreateTag().getDouble("AmmoSize") == -1.0D) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                        }
                     }

                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(x, y, z);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           var27 = _blockEntity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var27.putDouble("Ammo", var10002.getOrCreateTag().getDouble("Ammo"));
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
                           _blockEntity.getPersistentData().putBoolean("Loaded", true);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.setCount(0);
                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        var28 = _player.getCooldowns();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        var28.addCooldown(var10001.getItem(), 40);
                     }
                  }
               }
            } else if (((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getCount() == 0) {
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("Loaded", false);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     var28 = _player.getCooldowns();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     var28.addCooldown(var10001.getItem(), 40);
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.MACHINE_GUN_BOX.get())).copy();
                     _setstack.setCount(1);
                     _livEnt.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_livEnt instanceof Player) {
                        _player = (Player)_livEnt;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Ammo"));
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("AmmoSize", -1.0D);
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", 0.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:pistolaction")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                     }
                  }
               }
            }
         }

      }
   }
}
