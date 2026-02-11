package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class CountermeasureDispenserReloadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _entity;
         ItemStack _setstack;
         LivingEntity _livEnt;
         Level _level;
         ItemStack var10000;
         BlockPos _bp;
         ItemStack var10001;
         Level _level;
         BlockEntity _blockEntity;
         ServerLevel _level;
         ItemEntity entityToSpawn;
         Player _player;
         BlockState _bs;
         if (0.0D == ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Type") || 1.0D == ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Type")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.FLARE_CHARGE.get()) {
               if (12.0D > ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Ammo")) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.FLARE_CHARGE.get())).copy();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     _setstack.setCount(var10001.getCount() - 1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(x, y, z), "Ammo") + 1.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("Type", 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem() && 1.0D <= ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Ammo")) {
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(x, y, z), "Ammo") - 1.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.FLARE_CHARGE.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Type", 1.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }
               }
            }
         }

         if (0.0D == ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Type") || 2.0D == ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Type")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.CHAFF_CHARGE.get()) {
               if (12.0D > ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Ammo")) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.CHAFF_CHARGE.get())).copy();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     _setstack.setCount(var10001.getCount() - 1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(x, y, z), "Ammo") + 1.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("Type", 2.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem() && 1.0D <= ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Ammo")) {
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(x, y, z), "Ammo") - 1.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x + 0.5D, y + 1.5D, z + 0.5D, new ItemStack((ItemLike)CrustyChunksModItems.CHAFF_CHARGE.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Type", 2.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }
               }
            }
         }

         if (0.0D == ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Ammo") && !world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Type", 0.0D);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

      }
   }
}
