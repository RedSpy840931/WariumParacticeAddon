package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.BoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.ScopedBoltActionRifleAnimatedItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BoltReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         LivingEntity _livEnt;
         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMainHandItem();
         } else {
            var10001 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         ItemStack var10000;
         if (0.0D == var10001.getOrCreateTag().getDouble("Ammo")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            var10000.getOrCreateTag().putString("Type", "NULL");
         }

         Capacity = 8.0D;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getOffhandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         if (var10000.getCount() == 0) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMainHandItem();
               } else {
                  var10001 = ItemStack.EMPTY;
               }

               if (1.0D <= var10001.getOrCreateTag().getDouble("Ammo")) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  Rounds = var10000.getOrCreateTag().getDouble("Ammo") - 1.0D;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ServerLevel _level;
                  ItemEntity entityToSpawn;
                  if (var10000.getOrCreateTag().getString("Type").equals("MB")) {
                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.LARGE_BULLET.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getString("Type").equals("AP")) {
                        if (world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.AP_LARGE_BULLET.get()));
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getString("Type").equals("ST") && world instanceof ServerLevel) {
                           _level = (ServerLevel)world;
                           entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEALTH_LARGE_BULLET.get()));
                           entityToSpawn.setPickUpDelay(10);
                           _level.addFreshEntity(entityToSpawn);
                        }
                     }
                  }

                  CrustyChunksMod.queueServerWork(1, () -> {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bolt")), SoundSource.NEUTRAL, 0.2F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bolt")), SoundSource.NEUTRAL, 0.2F, 1.0F, false);
                        }
                     }

                  });
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putBoolean("action", false);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("C", 20.0D);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof BoltActionRifleAnimatedItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "bolt");
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof ScopedBoltActionRifleAnimatedItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "bolt");
                  }
               }
            }
         } else {
            label631: {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               LivingEntity _livEnt;
               if (var10000.getItem() == CrustyChunksModItems.LARGE_BULLET.get()) {
                  label629: {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (!var10000.getOrCreateTag().getString("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (!var10000.getOrCreateTag().getString("Type").equals("MB")) {
                           break label629;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("Type", "MB");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getCount() >= 4) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           if (4.0D >= var10001.getOrCreateTag().getDouble("Ammo")) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("C", 40.0D);
                              CrustyChunksMod.queueServerWork(5, () -> {
                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                       _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                 }

                              });
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.shrink(4);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 4.0D;
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getItem() instanceof BoltActionRifleAnimatedItem) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "ReloadClip");
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getItem() instanceof ScopedBoltActionRifleAnimatedItem) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "ReloadClip");
                              }
                              break label631;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (7.0D >= var10001.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("C", 40.0D);
                           CrustyChunksMod.queueServerWork(5, () -> {
                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                 } else {
                                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                 }
                              }

                           });
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.shrink(1);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 1.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.getItem() instanceof BoltActionRifleAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putString("geckoAnim", "ReloadSingle");
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.getItem() instanceof ScopedBoltActionRifleAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putString("geckoAnim", "ReloadSingle");
                           }
                        }
                     }
                     break label631;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.AP_LARGE_BULLET.get()) {
                  label630: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (!var10000.getOrCreateTag().getString("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (!var10000.getOrCreateTag().getString("Type").equals("AP")) {
                           break label630;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("Type", "AP");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getCount() >= 4) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           if (4.0D >= var10001.getOrCreateTag().getDouble("Ammo")) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("C", 40.0D);
                              CrustyChunksMod.queueServerWork(5, () -> {
                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                       _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                 }

                              });
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.shrink(4);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 4.0D;
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getItem() instanceof BoltActionRifleAnimatedItem) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "ReloadClip");
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getItem() instanceof ScopedBoltActionRifleAnimatedItem) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "ReloadClip");
                              }
                              break label631;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (7.0D >= var10001.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("C", 40.0D);
                           CrustyChunksMod.queueServerWork(5, () -> {
                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                 } else {
                                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                 }
                              }

                           });
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.shrink(1);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 1.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.getItem() instanceof BoltActionRifleAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putString("geckoAnim", "ReloadSingle");
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.getItem() instanceof ScopedBoltActionRifleAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putString("geckoAnim", "ReloadSingle");
                           }
                        }
                     }
                     break label631;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.STEALTH_LARGE_BULLET.get()) {
                  label623: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (!var10000.getOrCreateTag().getString("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (!var10000.getOrCreateTag().getString("Type").equals("ST")) {
                           break label623;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("Type", "ST");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
                        label624: {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.getCount() >= 4) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getMainHandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              if (4.0D >= var10001.getOrCreateTag().getDouble("Ammo")) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putDouble("C", 40.0D);
                                 CrustyChunksMod.queueServerWork(5, () -> {
                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                       } else {
                                          _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                       }
                                    }

                                 });
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getOffhandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.shrink(4);
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 4.0D;
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 if (var10000.getItem() instanceof BoltActionRifleAnimatedItem) {
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.getOrCreateTag().putString("geckoAnim", "ReloadClip");
                                 }

                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 if (var10000.getItem() instanceof ScopedBoltActionRifleAnimatedItem) {
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.getOrCreateTag().putString("geckoAnim", "ReloadClip");
                                 }
                                 break label624;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           if (7.0D >= var10001.getOrCreateTag().getDouble("Ammo")) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("C", 40.0D);
                              CrustyChunksMod.queueServerWork(5, () -> {
                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                    } else {
                                       _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                    }
                                 }

                              });
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.shrink(1);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 1.0D;
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getItem() instanceof BoltActionRifleAnimatedItem) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "ReloadSingle");
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getItem() instanceof ScopedBoltActionRifleAnimatedItem) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "ReloadSingle");
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         Player _player;
         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               DecimalFormat var33 = new DecimalFormat;
               ItemStack var10003;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10003 = _livEnt.getMainHandItem();
               } else {
                  var10003 = ItemStack.EMPTY;
               }

               CompoundTag var32 = var10003.getOrCreateTag();
               var33.<init>("§4" + var32.getString("Type") + "§6####§8/§6");
               ItemStack var10002;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMainHandItem();
               } else {
                  var10002 = ItemStack.EMPTY;
               }

               String var34 = var33.format(var10002.getOrCreateTag().getDouble("Ammo"));
               _player.displayClientMessage(Component.literal(var34 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            ItemCooldowns var29 = _player.getCooldowns();
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            var29.addCooldown(var10001.getItem(), 1);
         }

      }
   }
}
