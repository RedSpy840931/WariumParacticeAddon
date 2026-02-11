package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class FireSelectOnKeyPressedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         Level _level;
         Player _player;
         if (var10000.getItem() == CrustyChunksModItems.BURST_RIFLE.get()) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getOrCreateTag().getDouble("Firemode") == 0.0D) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.getOrCreateTag().putDouble("Firemode", 1.0D);
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                  }
               }

               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§6Burst"), true);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getOrCreateTag().getDouble("Firemode") == 1.0D) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Firemode", 0.0D);
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("§6Semi"), true);
                     }
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.MACHINE_CARBINE.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getOrCreateTag().getDouble("Firemode") == 0.0D) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Firemode", 1.0D);
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                     }
                  }

                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("§6Auto"), true);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getOrCreateTag().getDouble("Firemode") == 1.0D) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("Firemode", 0.0D);
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                        }
                     }

                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("§6Semi"), true);
                        }
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.BATTLE_RIFLE.get()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getOrCreateTag().getDouble("Firemode") == 0.0D) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("Firemode", 1.0D);
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                        }
                     }

                     if (entity instanceof Player) {
                        _player = (Player)entity;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("§6Auto"), true);
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("Firemode") == 1.0D) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putDouble("Firemode", 0.0D);
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                           }
                        }

                        if (entity instanceof Player) {
                           _player = (Player)entity;
                           if (!_player.level().isClientSide()) {
                              _player.displayClientMessage(Component.literal("§6Semi"), true);
                           }
                        }
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == CrustyChunksModItems.AUTOMATIC_RIFLE.get()) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getDouble("Firemode") == 0.0D) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putDouble("Firemode", 1.0D);
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                           }
                        }

                        if (entity instanceof Player) {
                           _player = (Player)entity;
                           if (!_player.level().isClientSide()) {
                              _player.displayClientMessage(Component.literal("§6Auto"), true);
                           }
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getDouble("Firemode") == 1.0D) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Firemode", 0.0D);
                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                              } else {
                                 _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                              }
                           }

                           if (entity instanceof Player) {
                              _player = (Player)entity;
                              if (!_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal("§6Semi"), true);
                              }
                           }
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.is(ItemTags.create(new ResourceLocation("crusty_chunks:fireselect")))) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getDouble("Firemode") == 0.0D) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Firemode", 1.0D);
                           if (world instanceof Level) {
                              _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F);
                              } else {
                                 _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.7F, false);
                              }
                           }

                           if (entity instanceof Player) {
                              _player = (Player)entity;
                              if (!_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal("§6Special"), true);
                              }
                           }
                        } else {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.getOrCreateTag().getDouble("Firemode") == 1.0D) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Firemode", 0.0D);
                              if (world instanceof Level) {
                                 _level = (Level)world;
                                 if (!_level.isClientSide()) {
                                    _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F);
                                 } else {
                                    _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.comparator.click")), SoundSource.NEUTRAL, 1.0F, 1.4F, false);
                                 }
                              }

                              if (entity instanceof Player) {
                                 _player = (Player)entity;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal("§6Standard"), true);
                                 }
                              }
                           }
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() == CrustyChunksModItems.AIMER.get()) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           Player _player;
                           if (var10000.getOrCreateTag().getBoolean("Mode")) {
                              if (entity instanceof Player) {
                                 _player = (Player)entity;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal("§6Seat Mode: Off"), true);
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putBoolean("Mode", false);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Pitch", 0.0D);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Yaw", 0.0D);
                           } else {
                              if (entity instanceof Player) {
                                 _player = (Player)entity;
                                 if (!_player.level().isClientSide()) {
                                    _player.displayClientMessage(Component.literal("§6Seat Mode: On"), true);
                                 }
                              }

                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putBoolean("Mode", true);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Pitch", 0.0D);
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Yaw", 0.0D);
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
