package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.BreakActionShotgunAnimatedItem;
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

public class BreakActionReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 2.0D;
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
                  if (var10000.getOrCreateTag().getString("Type").equals("BU")) {
                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SHOTGUN_SHELL.get()));
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
                           entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SLUG_SHELL.get()));
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

                        if (var10000.getOrCreateTag().getString("Type").equals("BI")) {
                           if (world instanceof ServerLevel) {
                              _level = (ServerLevel)world;
                              entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BIRD_SHOT.get()));
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

                           if (var10000.getOrCreateTag().getString("Type").equals("DB") && world instanceof ServerLevel) {
                              _level = (ServerLevel)world;
                              entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.THERMAL_SHELL.get()));
                              entityToSpawn.setPickUpDelay(10);
                              _level.addFreshEntity(entityToSpawn);
                           }
                        }
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 0.2F, 1.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 0.2F, 1.5F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("C", 40.0D);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                  }
               }
            }
         } else {
            label766: {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               Level _level;
               Level _level;
               label767: {
                  if (var10000.getItem() == CrustyChunksModItems.SHOTGUN_SHELL.get()) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getString("Type").equals("NULL")) {
                        break label767;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getString("Type").equals("BU")) {
                        break label767;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == CrustyChunksModItems.SLUG_SHELL.get()) {
                     label768: {
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
                              break label768;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
                           label762: {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getCount() >= 2) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.getMainHandItem();
                                 } else {
                                    var10001 = ItemStack.EMPTY;
                                 }

                                 if (0.0D == var10001.getOrCreateTag().getDouble("Ammo")) {
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.getOrCreateTag().putDouble("C", 40.0D);
                                    if (world instanceof Level) {
                                       _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                       } else {
                                          _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getOffhandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.shrink(2);
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 2.0D;
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

                                    if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                                       if (entity instanceof LivingEntity) {
                                          _livEnt = (LivingEntity)entity;
                                          var10000 = _livEnt.getMainHandItem();
                                       } else {
                                          var10000 = ItemStack.EMPTY;
                                       }

                                       var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                                    }

                                    CrustyChunksMod.queueServerWork(37, () -> {
                                       if (world instanceof Level) {
                                          Level _level = (Level)world;
                                          if (!_level.isClientSide()) {
                                             _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                          } else {
                                             _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                          }
                                       }

                                    });
                                    break label762;
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getMainHandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              if (2.0D > var10001.getOrCreateTag().getDouble("Ammo")) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putDouble("C", 40.0D);
                                 if (world instanceof Level) {
                                    _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                    } else {
                                       _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                    }
                                 }

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

                                 if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                                 }

                                 CrustyChunksMod.queueServerWork(37, () -> {
                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                       } else {
                                          _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                       }
                                    }

                                 });
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("Type", "AP");
                        break label766;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  label747: {
                     if (var10000.getItem() == CrustyChunksModItems.BIRD_SHOT.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getString("Type").equals("NULL")) {
                           break label747;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getString("Type").equals("BI")) {
                           break label747;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() == CrustyChunksModItems.THERMAL_SHELL.get()) {
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

                           if (!var10000.getOrCreateTag().getString("Type").equals("DB")) {
                              break label766;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
                           label763: {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getCount() >= 2) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10001 = _livEnt.getMainHandItem();
                                 } else {
                                    var10001 = ItemStack.EMPTY;
                                 }

                                 if (0.0D == var10001.getOrCreateTag().getDouble("Ammo")) {
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.getOrCreateTag().putDouble("C", 40.0D);
                                    if (world instanceof Level) {
                                       _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                       } else {
                                          _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getOffhandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.shrink(2);
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 2.0D;
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

                                    if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                                       if (entity instanceof LivingEntity) {
                                          _livEnt = (LivingEntity)entity;
                                          var10000 = _livEnt.getMainHandItem();
                                       } else {
                                          var10000 = ItemStack.EMPTY;
                                       }

                                       var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                                    }

                                    CrustyChunksMod.queueServerWork(37, () -> {
                                       if (world instanceof Level) {
                                          Level _level = (Level)world;
                                          if (!_level.isClientSide()) {
                                             _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                          } else {
                                             _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                          }
                                       }

                                    });
                                    break label763;
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getMainHandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              if (2.0D > var10001.getOrCreateTag().getDouble("Ammo")) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putDouble("C", 40.0D);
                                 if (world instanceof Level) {
                                    _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                    } else {
                                       _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                    }
                                 }

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

                                 if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                                    if (entity instanceof LivingEntity) {
                                       _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                                 }

                                 CrustyChunksMod.queueServerWork(37, () -> {
                                    if (world instanceof Level) {
                                       Level _level = (Level)world;
                                       if (!_level.isClientSide()) {
                                          _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                       } else {
                                          _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                       }
                                    }

                                 });
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("Type", "DB");
                     }
                     break label766;
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
                     label764: {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getCount() >= 2) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           if (0.0D == var10001.getOrCreateTag().getDouble("Ammo")) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("C", 40.0D);
                              if (world instanceof Level) {
                                 _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                 } else {
                                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.shrink(2);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 2.0D;
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

                              if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10000 = _livEnt.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                              }

                              CrustyChunksMod.queueServerWork(37, () -> {
                                 if (world instanceof Level) {
                                    Level _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                       _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                    } else {
                                       _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                    }
                                 }

                              });
                              break label764;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (2.0D > var10001.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("C", 40.0D);
                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                              } else {
                                 _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                              }
                           }

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

                           if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                           }

                           CrustyChunksMod.queueServerWork(37, () -> {
                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                 } else {
                                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                 }
                              }

                           });
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putString("Type", "BI");
                  break label766;
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getOrCreateTag().getDouble("C") <= 0.0D) {
                  label765: {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getCount() >= 2) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (0.0D == var10001.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("C", 40.0D);
                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                              } else {
                                 _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.shrink(2);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           Rounds = var10000.getOrCreateTag().getDouble("Ammo") + 2.0D;
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

                           if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                           }

                           CrustyChunksMod.queueServerWork(37, () -> {
                              if (world instanceof Level) {
                                 Level _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                                 } else {
                                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                                 }
                              }

                           });
                           break label765;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     if (2.0D > var10001.getOrCreateTag().getDouble("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putDouble("C", 40.0D);
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.open")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                           }
                        }

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

                        if (var10000.getItem() instanceof BreakActionShotgunAnimatedItem) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                        }

                        CrustyChunksMod.queueServerWork(37, () -> {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                              } else {
                                 _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_door.close")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                              }
                           }

                        });
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.getOrCreateTag().putString("Type", "BU");
            }
         }

         Player _player;
         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               DecimalFormat var38 = new DecimalFormat;
               ItemStack var10003;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10003 = _livEnt.getMainHandItem();
               } else {
                  var10003 = ItemStack.EMPTY;
               }

               CompoundTag var37 = var10003.getOrCreateTag();
               var38.<init>("§4" + var37.getString("Type") + "§6####§8/§6");
               ItemStack var10002;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMainHandItem();
               } else {
                  var10002 = ItemStack.EMPTY;
               }

               String var39 = var38.format(var10002.getOrCreateTag().getDouble("Ammo"));
               _player.displayClientMessage(Component.literal(var39 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            ItemCooldowns var40 = _player.getCooldowns();
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            var40.addCooldown(var10001.getItem(), 1);
         }

      }
   }
}
