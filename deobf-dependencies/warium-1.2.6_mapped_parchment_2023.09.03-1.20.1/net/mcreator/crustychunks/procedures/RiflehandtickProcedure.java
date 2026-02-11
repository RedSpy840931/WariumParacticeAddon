package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.AutomaticRifleItem;
import net.mcreator.crustychunks.item.BattleRifleItem;
import net.mcreator.crustychunks.item.BoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.BreechRifleItem;
import net.mcreator.crustychunks.item.BurstRifleItem;
import net.mcreator.crustychunks.item.LMGAnimatedItem;
import net.mcreator.crustychunks.item.LeverRifleItem;
import net.mcreator.crustychunks.item.MachineCarbineItem;
import net.mcreator.crustychunks.item.SemiAutomaticRifleAnimatedItem;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class RiflehandtickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         boolean Sneaking = false;
         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            if (!_livEnt.level().isClientSide()) {
               _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 0, false, false));
            }
         }

         if (entity instanceof Player) {
            LivingEntity _entity;
            if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).LeftKey) {
               entity.setYRot((float)((double)entity.getYRot() - 0.05D));
               entity.setXRot(entity.getXRot());
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).RightKey) {
               entity.setYRot((float)((double)entity.getYRot() + 0.05D));
               entity.setXRot(entity.getXRot());
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).UpKey) {
               entity.setYRot(entity.getYRot());
               entity.setXRot((float)((double)entity.getXRot() - 0.05D));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).DownKey) {
               entity.setYRot(entity.getYRot());
               entity.setXRot((float)((double)entity.getXRot() + 0.05D));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            if (entity.getPersistentData().getDouble("Stamina") < 400.0D && (double)Mth.nextInt(RandomSource.create(), 100, 200) < entity.getPersistentData().getDouble("Stamina")) {
               entity.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D)));
               entity.setXRot((float)((double)entity.getXRot() + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D)));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            } else if (entity.getPersistentData().getDouble("Stamina") >= 400.0D) {
               entity.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D)));
               entity.setXRot((float)((double)entity.getXRot() + Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D)));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            ItemStack var10001;
            LivingEntity _livEnt;
            LivingEntity _livEnt;
            if (var10000.getItem() == CrustyChunksModItems.BURST_RIFLE.get()) {
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof BurstRifleItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "sight");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10001 = _entity.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((BurstRifleItem)var10001.getItem()).animationprocedure)) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof BurstRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof BurstRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            if (var10000.getItem() == CrustyChunksModItems.SEMI_AUTOMATIC_RIFLE_ANIMATED.get()) {
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof SemiAutomaticRifleAnimatedItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "sight");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10001 = _entity.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((SemiAutomaticRifleAnimatedItem)var10001.getItem()).animationprocedure)) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof SemiAutomaticRifleAnimatedItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof SemiAutomaticRifleAnimatedItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            if (var10000.getItem() == CrustyChunksModItems.MACHINE_CARBINE.get()) {
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof MachineCarbineItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "sight");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10001 = _entity.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((MachineCarbineItem)var10001.getItem()).animationprocedure)) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof MachineCarbineItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof MachineCarbineItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            if (var10000.getItem() == CrustyChunksModItems.LMG_ANIMATED.get()) {
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof LMGAnimatedItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "sight");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10001 = _entity.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((LMGAnimatedItem)var10001.getItem()).animationprocedure)) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof LMGAnimatedItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof LMGAnimatedItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            if (var10000.getItem() == CrustyChunksModItems.BATTLE_RIFLE.get()) {
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10000 = _entity.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof BattleRifleItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "sight");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     var10001 = _entity.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((BattleRifleItem)var10001.getItem()).animationprocedure)) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof BattleRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof BattleRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            LivingEntity _livEnt;
            LivingEntity _livEnt;
            Player _plrCldCheck117;
            ItemCooldowns var9;
            if (var10000.getItem() == CrustyChunksModItems.BOLT_ACTION_RIFLE_ANIMATED.get()) {
               label692: {
                  if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                     label685: {
                        if (entity instanceof Player) {
                           _plrCldCheck117 = (Player)entity;
                           var9 = _plrCldCheck117.getCooldowns();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           if (var9.isOnCooldown(var10001.getItem())) {
                              break label685;
                           }
                        }

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

                           var10000.getOrCreateTag().putString("geckoAnim", "sight");
                        }
                        break label692;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((BoltActionRifleAnimatedItem)var10001.getItem()).animationprocedure)) {
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

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

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

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            if (var10000.getItem() == CrustyChunksModItems.BREECH_RIFLE.get()) {
               label686: {
                  label674: {
                     if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                        if (!(entity instanceof Player)) {
                           break label674;
                        }

                        _plrCldCheck117 = (Player)entity;
                        var9 = _plrCldCheck117.getCooldowns();
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (!var9.isOnCooldown(var10001.getItem())) {
                           break label674;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     if ("sight".equals(((BreechRifleItem)var10001.getItem()).animationprocedure)) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() instanceof BreechRifleItem) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putString("geckoAnim", "empty");
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() instanceof BreechRifleItem) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putString("geckoAnim", "idle");
                        }
                     }
                     break label686;
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof BreechRifleItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "sight");
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.LEVER_RIFLE.get()) {
               label693: {
                  if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                     label688: {
                        if (entity instanceof Player) {
                           _plrCldCheck117 = (Player)entity;
                           var9 = _plrCldCheck117.getCooldowns();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           if (var9.isOnCooldown(var10001.getItem())) {
                              break label688;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() instanceof LeverRifleItem) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putString("geckoAnim", "sight");
                        }
                        break label693;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((LeverRifleItem)var10001.getItem()).animationprocedure)) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof LeverRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof LeverRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            if (var10000.getItem() == CrustyChunksModItems.AUTOMATIC_RIFLE.get()) {
               label694: {
                  if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                     label690: {
                        if (entity instanceof Player) {
                           _plrCldCheck117 = (Player)entity;
                           var9 = _plrCldCheck117.getCooldowns();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.getMainHandItem();
                           } else {
                              var10001 = ItemStack.EMPTY;
                           }

                           if (var9.isOnCooldown(var10001.getItem())) {
                              break label690;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getItem() instanceof AutomaticRifleItem) {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putString("geckoAnim", "sight");
                        }
                        break label694;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if ("sight".equals(((AutomaticRifleItem)var10001.getItem()).animationprocedure)) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof AutomaticRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "empty");
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() instanceof AutomaticRifleItem) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putString("geckoAnim", "idle");
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

            if (var10000.getItem() == CrustyChunksModItems.SINGLE_SHOT_RIFLE.get()) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, false, false));
                  }
               }

               entity.setDeltaMovement(new Vec3(0.0D, entity.getDeltaMovement().y(), 0.0D));
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights && entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 4, false, false));
                  }
               }
            }
         }

         if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights && entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            if (!_livEnt.level().isClientSide()) {
               _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 2, false, false));
            }
         }

      }
   }
}
