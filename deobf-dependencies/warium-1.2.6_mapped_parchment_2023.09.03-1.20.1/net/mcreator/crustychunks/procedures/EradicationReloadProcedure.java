package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.EradicationItem;
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

public class EradicationReloadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 200.0D;
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
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemEntity entityToSpawn;
         ItemStack var10002;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ServerLevel _level;
         Level _level;
         LivingEntity _livEnt;
         double var29;
         double var30;
         label569: {
            if (!var10000.getOrCreateTag().getString("Type").equals("NULL")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (!var10000.getOrCreateTag().getString("Type").equals("HP")) {
                  break label569;
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

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
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putString("Type", "HP");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (Capacity > var10001.getOrCreateTag().getDouble("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.15D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.15D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof EradicationItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var30 = (double)var10000.getCount();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getMainHandItem();
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     if (var30 >= Capacity - var10002.getOrCreateTag().getDouble("Ammo")) {
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

                        var10000.shrink((int)(Capacity - var10002.getOrCreateTag().getDouble("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var30 = var10000.getOrCreateTag().getDouble("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        Rounds = var30 - var10001.getOrCreateTag().getDouble("Ammo");
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

                        var29 = var10001.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getOffhandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (Capacity > var29 + (double)var10002.getCount()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var30 = var10000.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getOffhandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var30 + (double)var10001.getCount();
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

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         label576: {
            if (!var10000.getOrCreateTag().getString("Type").equals("NULL")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (!var10000.getOrCreateTag().getString("Type").equals("AP")) {
                  break label576;
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

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
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALLBULLET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.SMALLBULLET.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putString("Type", "AP");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (Capacity > var10001.getOrCreateTag().getDouble("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.15D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.15D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof EradicationItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var30 = (double)var10000.getCount();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getMainHandItem();
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     if (var30 >= Capacity - var10002.getOrCreateTag().getDouble("Ammo")) {
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

                        var10000.shrink((int)(Capacity - var10002.getOrCreateTag().getDouble("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var30 = var10000.getOrCreateTag().getDouble("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        Rounds = var30 - var10001.getOrCreateTag().getDouble("Ammo");
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

                        var29 = var10001.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getOffhandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (Capacity > var29 + (double)var10002.getCount()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var30 = var10000.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getOffhandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var30 + (double)var10001.getCount();
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

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         ItemStack var10003;
         CompoundTag var28;
         DecimalFormat var31;
         String var32;
         label583: {
            if (!var10000.getOrCreateTag().getString("Type").equals("NULL")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (!var10000.getOrCreateTag().getString("Type").equals("ST")) {
                  break label583;
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

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
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_STEALTH_BULLET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.SMALL_STEALTH_BULLET.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putString("Type", "ST");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (Capacity > var10001.getOrCreateTag().getDouble("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.15D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:boltreload")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.15D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof EradicationItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "Reload");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var30 = (double)var10000.getCount();
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getMainHandItem();
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     if (var30 >= Capacity - var10002.getOrCreateTag().getDouble("Ammo")) {
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

                        var10000.shrink((int)(Capacity - var10002.getOrCreateTag().getDouble("Ammo")));
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var30 = var10000.getOrCreateTag().getDouble("Ammo") + Capacity;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        Rounds = var30 - var10001.getOrCreateTag().getDouble("Ammo");
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

                        var29 = var10001.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getOffhandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (Capacity > var29 + (double)var10002.getCount()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var30 = var10000.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getOffhandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           Rounds = var30 + (double)var10001.getCount();
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

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  var31 = new DecimalFormat;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.getMainHandItem();
                  } else {
                     var10003 = ItemStack.EMPTY;
                  }

                  var28 = var10003.getOrCreateTag();
                  var31.<init>("§4" + var28.getString("Type") + "§6####§8/§6");
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.getMainHandItem();
                  } else {
                     var10002 = ItemStack.EMPTY;
                  }

                  var32 = var31.format(var10002.getOrCreateTag().getDouble("Ammo"));
                  _player.displayClientMessage(Component.literal(var32 + (new DecimalFormat("####")).format(Capacity)), true);
               }
            }
         }

         Player _player;
         if (entity instanceof Player) {
            _player = (Player)entity;
            ItemCooldowns var33 = _player.getCooldowns();
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            var33.addCooldown(var10001.getItem(), 1);
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               var31 = new DecimalFormat;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10003 = _livEnt.getMainHandItem();
               } else {
                  var10003 = ItemStack.EMPTY;
               }

               var28 = var10003.getOrCreateTag();
               var31.<init>("§4" + var28.getString("Type") + "§6####§8/§6");
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMainHandItem();
               } else {
                  var10002 = ItemStack.EMPTY;
               }

               var32 = var31.format(var10002.getOrCreateTag().getDouble("Ammo"));
               _player.displayClientMessage(Component.literal(var32 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

      }
   }
}
