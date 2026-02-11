package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class MGBoxScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         LivingEntity _livEnt;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getOffhandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemStack var10001;
         ItemStack var10002;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         Level _level;
         if (var10000.getCount() == 0) {
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
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               ServerLevel _level;
               ItemEntity entityToSpawn;
               if (var10000.getOrCreateTag().getDouble("AmmoSize") == 0.0D) {
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

                  if (var10000.getOrCreateTag().getDouble("AmmoSize") == 1.0D) {
                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.EXTRA_LARGE_BULLET.get()));
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

                     if (var10000.getOrCreateTag().getDouble("AmmoSize") == -1.0D && world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.BULLET.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                     }
                  }
               }
            }
         } else {
            label536: {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               LivingEntity _livEnt;
               LivingEntity _livEnt;
               LivingEntity _livEnt;
               double var31;
               double var32;
               if (var10000.getItem() == CrustyChunksModItems.LARGE_BULLET.get()) {
                  label534: {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("AmmoSize") != 0.0D) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (!(0.0D >= var10001.getOrCreateTag().getDouble("Ammo"))) {
                           break label534;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("AmmoSize", 0.0D);
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     if (200.0D > var10001.getOrCreateTag().getDouble("Ammo")) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var32 = (double)var10000.getCount();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getMainHandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (var32 >= 200.0D - var10002.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var10000.shrink((int)(200.0D - var10002.getOrCreateTag().getDouble("Ammo")));
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var32 = var10000.getOrCreateTag().getDouble("Ammo") + 200.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var32 - var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                        } else {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           var31 = var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getOffhandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           if (200.0D > var31 + (double)var10002.getCount()) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var32 = var10000.getOrCreateTag().getDouble("Ammo");
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              Rounds = var32 + (double)var10001.getCount();
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              var10000.shrink(var10001.getCount());
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                           }
                        }
                     }
                     break label536;
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.EXTRA_LARGE_BULLET.get()) {
                  label535: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("AmmoSize") != 1.0D) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (!(0.0D >= var10001.getOrCreateTag().getDouble("Ammo"))) {
                           break label535;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("AmmoSize", 1.0D);
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     if (200.0D > var10001.getOrCreateTag().getDouble("Ammo")) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var32 = (double)var10000.getCount();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getMainHandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (var32 >= 200.0D - var10002.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var10000.shrink((int)(200.0D - var10002.getOrCreateTag().getDouble("Ammo")));
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var32 = var10000.getOrCreateTag().getDouble("Ammo") + 200.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var32 - var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                        } else {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           var31 = var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getOffhandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           if (200.0D > var31 + (double)var10002.getCount()) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var32 = var10000.getOrCreateTag().getDouble("Ammo");
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              Rounds = var32 + (double)var10001.getCount();
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              var10000.shrink(var10001.getCount());
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                           }
                        }
                     }
                     break label536;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.BULLET.get()) {
                  label528: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("AmmoSize") != -1.0D) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (!(0.0D >= var10001.getOrCreateTag().getDouble("Ammo"))) {
                           break label528;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("AmmoSize", -1.0D);
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     if (400.0D > var10001.getOrCreateTag().getDouble("Ammo")) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var32 = (double)var10000.getCount();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getMainHandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (var32 >= 400.0D - var10002.getOrCreateTag().getDouble("Ammo")) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var10000.shrink((int)(400.0D - var10002.getOrCreateTag().getDouble("Ammo")));
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var32 = var10000.getOrCreateTag().getDouble("Ammo") + 400.0D;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var32 - var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                        } else {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           var31 = var10001.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getOffhandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           if (400.0D > var31 + (double)var10002.getCount()) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var32 = var10000.getOrCreateTag().getDouble("Ammo");
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              Rounds = var32 + (double)var10001.getCount();
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getOffhandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.getOffhandItem();
                              } else {
                                 var10001 = ItemStack.EMPTY;
                              }

                              var10000.shrink(var10001.getCount());
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Ammo", Rounds);
                           }
                        }
                     }
                  }
               }
            }
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         Player _player;
         CompoundTag var33;
         DecimalFormat var34;
         ItemCooldowns var35;
         if (var10000.getOrCreateTag().getDouble("AmmoSize") == 1.0D) {
            if (entity instanceof Player) {
               _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  var34 = new DecimalFormat("####.");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.getMainHandItem();
                  } else {
                     var10002 = ItemStack.EMPTY;
                  }

                  var33 = var10002.getOrCreateTag();
                  _player.displayClientMessage(Component.literal("XL: " + var34.format(var33.getDouble("Ammo"))), true);
               }
            }

            if (entity instanceof Player) {
               _player = (Player)entity;
               var35 = _player.getCooldowns();
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMainHandItem();
               } else {
                  var10001 = ItemStack.EMPTY;
               }

               var35.addCooldown(var10001.getItem(), 1);
            }
         } else {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getOrCreateTag().getDouble("AmmoSize") == 0.0D) {
               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     var34 = new DecimalFormat("####.");
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getMainHandItem();
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     var33 = var10002.getOrCreateTag();
                     _player.displayClientMessage(Component.literal("L: " + var34.format(var33.getDouble("Ammo"))), true);
                  }
               }

               if (entity instanceof Player) {
                  _player = (Player)entity;
                  var35 = _player.getCooldowns();
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  var35.addCooldown(var10001.getItem(), 1);
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getOrCreateTag().getDouble("AmmoSize") == -1.0D) {
                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        var34 = new DecimalFormat("####.");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getMainHandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        var33 = var10002.getOrCreateTag();
                        _player.displayClientMessage(Component.literal("M:" + var34.format(var33.getDouble("Ammo"))), true);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     var35 = _player.getCooldowns();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     var35.addCooldown(var10001.getItem(), 1);
                  }
               }
            }
         }

      }
   }
}
