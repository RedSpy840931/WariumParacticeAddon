package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class FuelTankFillProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         BlockEntity _ent;
         int _amount;
         Player _player;
         LivingEntity _entity;
         Level _level;
         ItemStack _setstack;
         if (var10000.is(ItemTags.create(new ResourceLocation("forge:buckets/diesel")))) {
            if ((((<undefinedtype>)(new Object() {
               public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getFluidInTank(tank).getAmount());
                     });
                  }

                  return _retval.get();
               }
            })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
               public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getFluidInTank(tank).getAmount());
                     });
                  }

                  return _retval.get();
               }
            })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
               public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getTanks());
                     });
                  }

                  return _retval.get();
               }
            })).getBlockTanks(world, BlockPos.containing(x, y, z)))) == 0 || ((<undefinedtype>)(new Object() {
               public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                  BlockEntity blockEntity = level.getBlockEntity(pos);
                  return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                     return fluidHandler.getFluidInTank(tank).copy();
                  }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
               }
            })).getFluidInTank(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
               public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getTanks());
                     });
                  }

                  return _retval.get();
               }
            })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), 1))) && 900 <= ((<undefinedtype>)(new Object() {
               public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), amount), FluidAction.SIMULATE));
                     });
                  }

                  return _retval.get();
               }
            })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000)) {
               _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
               _amount = ((<undefinedtype>)(new Object() {
                  public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), amount), FluidAction.SIMULATE));
                        });
                     }

                     return _retval.get();
                  }
               })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                     capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), _amount), FluidAction.EXECUTE);
                  });
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _setstack = (new ItemStack(Items.BUCKET)).copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
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

            if (var10000.is(ItemTags.create(new ResourceLocation("forge:buckets/kerosene")))) {
               if ((((<undefinedtype>)(new Object() {
                  public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getFluidInTank(tank).getAmount());
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getFluidInTank(tank).getAmount());
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTanks());
                        });
                     }

                     return _retval.get();
                  }
               })).getBlockTanks(world, BlockPos.containing(x, y, z)))) == 0 || ((<undefinedtype>)(new Object() {
                  public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                     BlockEntity blockEntity = level.getBlockEntity(pos);
                     return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                        return fluidHandler.getFluidInTank(tank).copy();
                     }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
                  }
               })).getFluidInTank(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTanks());
                        });
                     }

                     return _retval.get();
                  }
               })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), 1))) && 900 <= ((<undefinedtype>)(new Object() {
                  public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), amount), FluidAction.SIMULATE));
                        });
                     }

                     return _retval.get();
                  }
               })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000)) {
                  _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                  _amount = ((<undefinedtype>)(new Object() {
                     public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), amount), FluidAction.SIMULATE));
                           });
                        }

                        return _retval.get();
                     }
                  })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), _amount), FluidAction.EXECUTE);
                     });
                  }

                  if (entity instanceof LivingEntity) {
                     _entity = (LivingEntity)entity;
                     _setstack = (new ItemStack(Items.BUCKET)).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
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

               if (var10000.is(ItemTags.create(new ResourceLocation("forge:buckets/gasoline")))) {
                  if ((((<undefinedtype>)(new Object() {
                     public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.getFluidInTank(tank).getAmount());
                           });
                        }

                        return _retval.get();
                     }
                  })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                     public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.getFluidInTank(tank).getAmount());
                           });
                        }

                        return _retval.get();
                     }
                  })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                     public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.getTanks());
                           });
                        }

                        return _retval.get();
                     }
                  })).getBlockTanks(world, BlockPos.containing(x, y, z)))) == 0 || ((<undefinedtype>)(new Object() {
                     public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                        BlockEntity blockEntity = level.getBlockEntity(pos);
                        return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                           return fluidHandler.getFluidInTank(tank).copy();
                        }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
                     }
                  })).getFluidInTank(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                     public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.getTanks());
                           });
                        }

                        return _retval.get();
                     }
                  })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), 1))) && 900 <= ((<undefinedtype>)(new Object() {
                     public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), amount), FluidAction.SIMULATE));
                           });
                        }

                        return _retval.get();
                     }
                  })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000)) {
                     _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                     _amount = ((<undefinedtype>)(new Object() {
                        public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), amount), FluidAction.SIMULATE));
                              });
                           }

                           return _retval.get();
                        }
                     })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), _amount), FluidAction.EXECUTE);
                        });
                     }

                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _setstack = (new ItemStack(Items.BUCKET)).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
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

                  if (var10000.is(ItemTags.create(new ResourceLocation("forge:buckets/hydrazine")))) {
                     if ((((<undefinedtype>)(new Object() {
                        public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.getFluidInTank(tank).getAmount());
                              });
                           }

                           return _retval.get();
                        }
                     })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                        public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.getFluidInTank(tank).getAmount());
                              });
                           }

                           return _retval.get();
                        }
                     })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                        public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.getTanks());
                              });
                           }

                           return _retval.get();
                        }
                     })).getBlockTanks(world, BlockPos.containing(x, y, z)))) == 0 || ((<undefinedtype>)(new Object() {
                        public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                           BlockEntity blockEntity = level.getBlockEntity(pos);
                           return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                              return fluidHandler.getFluidInTank(tank).copy();
                           }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
                        }
                     })).getFluidInTank(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                        public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.getTanks());
                              });
                           }

                           return _retval.get();
                        }
                     })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), 1))) && 900 <= ((<undefinedtype>)(new Object() {
                        public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), amount), FluidAction.SIMULATE));
                              });
                           }

                           return _retval.get();
                        }
                     })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000)) {
                        _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                        _amount = ((<undefinedtype>)(new Object() {
                           public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                              AtomicInteger _retval = new AtomicInteger(0);
                              BlockEntity _ent = level.getBlockEntity(pos);
                              if (_ent != null) {
                                 _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                    _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), amount), FluidAction.SIMULATE));
                                 });
                              }

                              return _retval.get();
                           }
                        })).fillTankSimulate(world, BlockPos.containing(x, y, z), 1000);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), _amount), FluidAction.EXECUTE);
                           });
                        }

                        if (entity instanceof LivingEntity) {
                           _entity = (LivingEntity)entity;
                           _setstack = (new ItemStack(Items.BUCKET)).copy();
                           _setstack.setCount(1);
                           _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
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

                     if (var10000.getItem() == CrustyChunksModItems.FUEL_HOSE.get()) {
                        ItemStack var10005;
                        if (entity instanceof LivingEntity) {
                           _entity = (LivingEntity)entity;
                           var10005 = _entity.getMainHandItem();
                        } else {
                           var10005 = ItemStack.EMPTY;
                        }

                        HoseConnectionProcedure.execute(world, x, y, z, entity, var10005);
                     }
                  }
               }
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               String var10001 = (new DecimalFormat("####")).format((long)((<undefinedtype>)(new Object() {
                  public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getFluidInTank(tank).getAmount());
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTanks());
                        });
                     }

                     return _retval.get();
                  }
               })).getBlockTanks(world, BlockPos.containing(x, y, z))));
               _player.displayClientMessage(Component.literal(var10001 + "/" + (new DecimalFormat("####")).format((long)((<undefinedtype>)(new Object() {
                  public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTankCapacity(tank));
                        });
                     }

                     return _retval.get();
                  }
               })).getFluidTankCapacity(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
                  public int getBlockTanks(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getTanks());
                        });
                     }

                     return _retval.get();
                  }
               })).getBlockTanks(world, BlockPos.containing(x, y, z))))), true);
            }
         }

      }
   }
}
