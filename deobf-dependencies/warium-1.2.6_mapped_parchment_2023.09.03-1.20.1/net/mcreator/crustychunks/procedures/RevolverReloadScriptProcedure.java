package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.RevolverAnimatedItem;
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

public class RevolverReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 8.0D;
         ItemCooldowns var10000;
         ItemStack var10001;
         if (entity instanceof Player) {
            Player _plrCldCheck1 = (Player)entity;
            var10000 = _plrCldCheck1.getCooldowns();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            if (var10000.isOnCooldown(var10001.getItem())) {
               return;
            }
         }

         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMainHandItem();
         } else {
            var10001 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         ItemStack var35;
         if (0.0D == var10001.getOrCreateTag().getDouble("Ammo")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var35 = _livEnt.getMainHandItem();
            } else {
               var35 = ItemStack.EMPTY;
            }

            var35.getOrCreateTag().putString("Type", "NULL");
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var35 = _livEnt.getOffhandItem();
         } else {
            var35 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         ItemStack var10002;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         if (var35.getCount() == 0) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            if (1.0D <= var10001.getOrCreateTag().getDouble("Ammo")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.getMainHandItem();
               } else {
                  var35 = ItemStack.EMPTY;
               }

               Rounds = var35.getOrCreateTag().getDouble("Ammo") - 1.0D;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.getMainHandItem();
               } else {
                  var35 = ItemStack.EMPTY;
               }

               var35.getOrCreateTag().putDouble("Ammo", Rounds);
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.getMainHandItem();
               } else {
                  var35 = ItemStack.EMPTY;
               }

               ServerLevel _level;
               ItemEntity entityToSpawn;
               if (var35.getOrCreateTag().getString("Type").equals("HP")) {
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.getMainHandItem();
                  } else {
                     var35 = ItemStack.EMPTY;
                  }

                  if (var35.getOrCreateTag().getString("Type").equals("AP")) {
                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALLBULLET.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (var35.getOrCreateTag().getString("Type").equals("ST") && world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_STEALTH_BULLET.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.getMainHandItem();
               } else {
                  var35 = ItemStack.EMPTY;
               }

               var35.getOrCreateTag().putBoolean("action", false);
            }
         } else {
            label567: {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.getOffhandItem();
               } else {
                  var35 = ItemStack.EMPTY;
               }

               LivingEntity _livEnt;
               LivingEntity _livEnt;
               LivingEntity _livEnt;
               Player _player;
               double var37;
               double var38;
               label549: {
                  if (var35.getItem() == CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (var35.getOrCreateTag().getString("Type").equals("NULL")) {
                        break label549;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (var35.getOrCreateTag().getString("Type").equals("HP")) {
                        break label549;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.getOffhandItem();
                  } else {
                     var35 = ItemStack.EMPTY;
                  }

                  label551: {
                     if (var35.getItem() == CrustyChunksModItems.SMALLBULLET.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        if (var35.getOrCreateTag().getString("Type").equals("NULL")) {
                           break label551;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        if (var35.getOrCreateTag().getString("Type").equals("AP")) {
                           break label551;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getOffhandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (var35.getItem() != CrustyChunksModItems.SMALL_STEALTH_BULLET.get()) {
                        break label567;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (!var35.getOrCreateTag().getString("Type").equals("NULL")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        if (!var35.getOrCreateTag().getString("Type").equals("ST")) {
                           break label567;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     if (Capacity > var10001.getOrCreateTag().getDouble("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        if (var35.getItem() instanceof RevolverAnimatedItem) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.getMainHandItem();
                           } else {
                              var35 = ItemStack.EMPTY;
                           }

                           var35.getOrCreateTag().putString("geckoAnim", "load");
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getOffhandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        var38 = (double)var35.getCount();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getMainHandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (var38 >= Capacity - var10002.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.getOffhandItem();
                           } else {
                              var35 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var35.shrink((int)(Capacity - var10002.getOrCreateTag().getDouble("Ammo")));
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.getMainHandItem();
                           } else {
                              var35 = ItemStack.EMPTY;
                           }

                           var38 = var35.getOrCreateTag().getDouble("Ammo") + Capacity;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var38 - var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.getMainHandItem();
                           } else {
                              var35 = ItemStack.EMPTY;
                           }

                           var35.getOrCreateTag().putDouble("Ammo", Rounds);
                        } else {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           var37 = var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getOffhandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           if (Capacity > var37 + (double)var10002.getCount()) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var35 = _livEnt.getMainHandItem();
                              } else {
                                 var35 = ItemStack.EMPTY;
                              }

                              var38 = var35.getOrCreateTag().getDouble("Ammo");
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              Rounds = var38 + (double)var10001.getCount();
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var35 = _livEnt.getOffhandItem();
                              } else {
                                 var35 = ItemStack.EMPTY;
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              var35.shrink(var10001.getCount());
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var35 = _livEnt.getMainHandItem();
                              } else {
                                 var35 = ItemStack.EMPTY;
                              }

                              var35.getOrCreateTag().putDouble("Ammo", Rounds);
                           }
                        }

                        if (entity instanceof Player) {
                           _player = (Player)entity;
                           var10000 = _player.getCooldowns();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           var10000.addCooldown(var10001.getItem(), 50);
                        }

                        CrustyChunksMod.queueServerWork(1, () -> {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                              } else {
                                 _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                              }
                           }

                        });
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     var35.getOrCreateTag().putString("Type", "ST");
                     break label567;
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (Capacity > var10001.getOrCreateTag().getDouble("Ammo")) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (var35.getItem() instanceof RevolverAnimatedItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        var35.getOrCreateTag().putString("geckoAnim", "load");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getOffhandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     var38 = (double)var35.getCount();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getMainHandItem();
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     if (var38 >= Capacity - var10002.getOrCreateTag().getDouble("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getOffhandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getMainHandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        var35.shrink((int)(Capacity - var10002.getOrCreateTag().getDouble("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        var38 = var35.getOrCreateTag().getDouble("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        Rounds = var38 - var10001.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        var35.getOrCreateTag().putDouble("Ammo", Rounds);
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        var37 = var10001.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getOffhandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (Capacity > var37 + (double)var10002.getCount()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.getMainHandItem();
                           } else {
                              var35 = ItemStack.EMPTY;
                           }

                           var38 = var35.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getOffhandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var38 + (double)var10001.getCount();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.getOffhandItem();
                           } else {
                              var35 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getOffhandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           var35.shrink(var10001.getCount());
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var35 = _livEnt.getMainHandItem();
                           } else {
                              var35 = ItemStack.EMPTY;
                           }

                           var35.getOrCreateTag().putDouble("Ammo", Rounds);
                        }
                     }

                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        var10000 = _player.getCooldowns();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        var10000.addCooldown(var10001.getItem(), 50);
                     }

                     CrustyChunksMod.queueServerWork(1, () -> {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                     });
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.getMainHandItem();
                  } else {
                     var35 = ItemStack.EMPTY;
                  }

                  var35.getOrCreateTag().putString("Type", "AP");
                  break label567;
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMainHandItem();
               } else {
                  var10001 = ItemStack.EMPTY;
               }

               if (Capacity > var10001.getOrCreateTag().getDouble("Ammo")) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.getMainHandItem();
                  } else {
                     var35 = ItemStack.EMPTY;
                  }

                  if (var35.getItem() instanceof RevolverAnimatedItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     var35.getOrCreateTag().putString("geckoAnim", "load");
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var35 = _livEnt.getOffhandItem();
                  } else {
                     var35 = ItemStack.EMPTY;
                  }

                  var38 = (double)var35.getCount();
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.getMainHandItem();
                  } else {
                     var10002 = ItemStack.EMPTY;
                  }

                  if (var38 >= Capacity - var10002.getOrCreateTag().getDouble("Ammo")) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getOffhandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getMainHandItem();
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     var35.shrink((int)(Capacity - var10002.getOrCreateTag().getDouble("Ammo")));
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     var38 = var35.getOrCreateTag().getDouble("Ammo") + Capacity;
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     Rounds = var38 - var10001.getOrCreateTag().getDouble("Ammo");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var35 = _livEnt.getMainHandItem();
                     } else {
                        var35 = ItemStack.EMPTY;
                     }

                     var35.getOrCreateTag().putDouble("Ammo", Rounds);
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     var37 = var10001.getOrCreateTag().getDouble("Ammo");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getOffhandItem();
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     if (Capacity > var37 + (double)var10002.getCount()) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        var38 = var35.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getOffhandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        Rounds = var38 + (double)var10001.getCount();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getOffhandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getOffhandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        var35.shrink(var10001.getCount());
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var35 = _livEnt.getMainHandItem();
                        } else {
                           var35 = ItemStack.EMPTY;
                        }

                        var35.getOrCreateTag().putDouble("Ammo", Rounds);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     var10000 = _player.getCooldowns();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     var10000.addCooldown(var10001.getItem(), 50);
                  }

                  CrustyChunksMod.queueServerWork(1, () -> {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:revolverreload")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                  });
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var35 = _livEnt.getMainHandItem();
               } else {
                  var35 = ItemStack.EMPTY;
               }

               var35.getOrCreateTag().putString("Type", "HP");
            }
         }

         Player _player;
         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               DecimalFormat var39 = new DecimalFormat;
               ItemStack var10003;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10003 = _livEnt.getMainHandItem();
               } else {
                  var10003 = ItemStack.EMPTY;
               }

               CompoundTag var36 = var10003.getOrCreateTag();
               var39.<init>("§4" + var36.getString("Type") + "§6####§8/§6");
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMainHandItem();
               } else {
                  var10002 = ItemStack.EMPTY;
               }

               String var40 = var39.format(var10002.getOrCreateTag().getDouble("Ammo"));
               _player.displayClientMessage(Component.literal(var40 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            var10000 = _player.getCooldowns();
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            var10000.addCooldown(var10001.getItem(), 5);
         }

      }
   }
}
