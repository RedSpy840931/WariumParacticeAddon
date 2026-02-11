package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class HardpointReloadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemStack var10000;
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            LivingEntity _entity;
            ItemStack _setstack;
            Player _player;
            UnmodifiableIterator var15;
            Entry entry;
            Property _property;
            BlockPos _bp;
            Level _level;
            BlockState _bs;
            BlockState _bso;
            BlockEntity _be;
            CompoundTag _bnbt;
            if (var10000.getItem() == CrustyChunksModItems.FIRE_SPEAR_ROCKET.get()) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.FIRE_SPEAR_ROCKET.get())).copy();
                  _setstack.setCount(0);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               _bp = BlockPos.containing(x, y, z);
               _bs = ((Block)CrustyChunksModBlocks.FIRE_SPEAR_MISSILE_HARDPOINT.get()).defaultBlockState();
               _bso = world.getBlockState(_bp);
               var15 = _bso.getValues().entrySet().iterator();

               while(var15.hasNext()) {
                  entry = (Entry)var15.next();
                  _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                  if (_property != null && _bs.getValue(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                     } catch (Exception var36) {
                     }
                  }
               }

               _be = world.getBlockEntity(_bp);
               _bnbt = null;
               if (_be != null) {
                  _bnbt = _be.saveWithFullMetadata();
                  _be.setRemoved();
               }

               world.setBlock(_bp, _bs, 3);
               if (_bnbt != null) {
                  _be = world.getBlockEntity(_bp);
                  if (_be != null) {
                     try {
                        _be.load(_bnbt);
                     } catch (Exception var35) {
                     }
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
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get()) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get())).copy();
                     _setstack.setCount(0);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  _bp = BlockPos.containing(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.SEEKER_SPEAR_MISSILE_HARDPOINT.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var15 = _bso.getValues().entrySet().iterator();

                  while(var15.hasNext()) {
                     entry = (Entry)var15.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var34) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var33) {
                        }
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
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get()) {
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get())).copy();
                        _setstack.setCount(0);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }

                     _bp = BlockPos.containing(x, y, z);
                     _bs = ((Block)CrustyChunksModBlocks.STRIKE_SPEAR_MISSILE_HARDPOINT.get()).defaultBlockState();
                     _bso = world.getBlockState(_bp);
                     var15 = _bso.getValues().entrySet().iterator();

                     while(var15.hasNext()) {
                        entry = (Entry)var15.next();
                        _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                           try {
                              _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                           } catch (Exception var32) {
                           }
                        }
                     }

                     _be = world.getBlockEntity(_bp);
                     _bnbt = null;
                     if (_be != null) {
                        _bnbt = _be.saveWithFullMetadata();
                        _be.setRemoved();
                     }

                     world.setBlock(_bp, _bs, 3);
                     if (_bnbt != null) {
                        _be = world.getBlockEntity(_bp);
                        if (_be != null) {
                           try {
                              _be.load(_bnbt);
                           } catch (Exception var31) {
                           }
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
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() == CrustyChunksModItems.RADAR_SPEAR_MISSILE.get()) {
                        if (entity instanceof LivingEntity) {
                           _entity = (LivingEntity)entity;
                           _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.RADAR_SPEAR_MISSILE.get())).copy();
                           _setstack.setCount(0);
                           _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }

                        _bp = BlockPos.containing(x, y, z);
                        _bs = ((Block)CrustyChunksModBlocks.RADAR_SPEAR_MISSILE_HARDPOINT.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var15 = _bso.getValues().entrySet().iterator();

                        while(var15.hasNext()) {
                           entry = (Entry)var15.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var30) {
                              }
                           }
                        }

                        _be = world.getBlockEntity(_bp);
                        _bnbt = null;
                        if (_be != null) {
                           _bnbt = _be.saveWithFullMetadata();
                           _be.setRemoved();
                        }

                        world.setBlock(_bp, _bs, 3);
                        if (_bnbt != null) {
                           _be = world.getBlockEntity(_bp);
                           if (_be != null) {
                              try {
                                 _be.load(_bnbt);
                              } catch (Exception var29) {
                              }
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
                  }
               }
            }
         } else {
            ServerLevel _level;
            BlockPos _bp;
            Level _level;
            ItemEntity entityToSpawn;
            BlockState _bs;
            BlockState _bso;
            UnmodifiableIterator var48;
            BlockEntity _be;
            Property _property;
            Entry entry;
            CompoundTag _bnbt;
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.FIRE_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.FIRE_SPEAR_ROCKET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  _bp = BlockPos.containing(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var48 = _bso.getValues().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var28) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var27) {
                        }
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.SEEKER_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  _bp = BlockPos.containing(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var48 = _bso.getValues().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var26) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var25) {
                        }
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.STRIKE_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  _bp = BlockPos.containing(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var48 = _bso.getValues().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var24) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var23) {
                        }
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.RADAR_SPEAR_MISSILE_HARDPOINT.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.RADAR_SPEAR_MISSILE.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  _bp = BlockPos.containing(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var48 = _bso.getValues().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var22) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var21) {
                        }
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
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.ORDINANCE_CONTROLLER.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ((Block)CrustyChunksModBlocks.ORDINANCE_CORE.get()).asItem()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.shrink(1);
                  _bp = BlockPos.containing(x, y, z);
                  _bs = ((Block)CrustyChunksModBlocks.ORDINANCE_CORE.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var48 = _bso.getValues().entrySet().iterator();

                  while(var48.hasNext()) {
                     entry = (Entry)var48.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var20) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var19) {
                        }
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
            }
         }

      }
   }
}
