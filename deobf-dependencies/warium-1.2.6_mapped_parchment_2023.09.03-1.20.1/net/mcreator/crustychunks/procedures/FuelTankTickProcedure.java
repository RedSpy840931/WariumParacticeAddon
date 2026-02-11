package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class FuelTankTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double amount = 0.0D;
      double fluid = 0.0D;
      double fillamount = 0.0D;
      double tanknumberself = 0.0D;
      double tanknumbertarget = 0.0D;
      sx = ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "ConnectionX") * -1.0D;
      sy = ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "ConnectionY") * -1.0D;
      sz = ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "ConnectionZ") * -1.0D;
      tanknumberself = (double)((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x, y, z));
      tanknumbertarget = (double)((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x + sx, y + sy, z + sz));
      BlockEntity _ent;
      int _amount;
      if (!((<undefinedtype>)(new Object() {
         public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
               return fluidHandler.getFluidInTank(tank).copy();
            }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
         }
      })).getFluidInTank(world, BlockPos.containing(x, y, z), (int)tanknumberself).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), 1)) || !((<undefinedtype>)(new Object() {
         public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
               return fluidHandler.getFluidInTank(tank).copy();
            }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
         }
      })).getFluidInTank(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), 1)) && 0 < ((<undefinedtype>)(new Object() {
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
      })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
         if (!((<undefinedtype>)(new Object() {
            public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
               BlockEntity blockEntity = level.getBlockEntity(pos);
               return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                  return fluidHandler.getFluidInTank(tank).copy();
               }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
            }
         })).getFluidInTank(world, BlockPos.containing(x, y, z), (int)tanknumberself).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), 1)) || !((<undefinedtype>)(new Object() {
            public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
               BlockEntity blockEntity = level.getBlockEntity(pos);
               return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                  return fluidHandler.getFluidInTank(tank).copy();
               }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
            }
         })).getFluidInTank(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), 1)) && 0 < ((<undefinedtype>)(new Object() {
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
         })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
            if (((<undefinedtype>)(new Object() {
               public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                  BlockEntity blockEntity = level.getBlockEntity(pos);
                  return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                     return fluidHandler.getFluidInTank(tank).copy();
                  }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
               }
            })).getFluidInTank(world, BlockPos.containing(x, y, z), (int)tanknumberself).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), 1)) && (((<undefinedtype>)(new Object() {
               public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                  BlockEntity blockEntity = level.getBlockEntity(pos);
                  return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                     return fluidHandler.getFluidInTank(tank).copy();
                  }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
               }
            })).getFluidInTank(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), 1)) || 0 >= ((<undefinedtype>)(new Object() {
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
            })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget))) {
               if (((<undefinedtype>)(new Object() {
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
               })).getFluidTankLevel(world, BlockPos.containing(x, y, z), (int)tanknumberself) > ((<undefinedtype>)(new Object() {
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
               })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
                  amount = (double)((<undefinedtype>)(new Object() {
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
                  })).fillTankSimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), 250);
                  fillamount = (double)((<undefinedtype>)(new Object() {
                     public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                           });
                        }

                        return _retval.get();
                     }
                  })).drainTankSimulate(world, BlockPos.containing(x, y, z), (int)amount);
                  _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                  _amount = (int)fillamount;
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        capability.drain(_amount, FluidAction.EXECUTE);
                     });
                  }

                  _ent = world.getBlockEntity(BlockPos.containing(x + sx, y + sy, z + sz));
                  _amount = (int)fillamount;
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), _amount), FluidAction.EXECUTE);
                     });
                  }
               }
            } else if (!((<undefinedtype>)(new Object() {
               public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                  BlockEntity blockEntity = level.getBlockEntity(pos);
                  return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                     return fluidHandler.getFluidInTank(tank).copy();
                  }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
               }
            })).getFluidInTank(world, BlockPos.containing(x, y, z), (int)tanknumberself).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), 1)) || !((<undefinedtype>)(new Object() {
               public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                  BlockEntity blockEntity = level.getBlockEntity(pos);
                  return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                     return fluidHandler.getFluidInTank(tank).copy();
                  }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
               }
            })).getFluidInTank(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), 1)) && 0 < ((<undefinedtype>)(new Object() {
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
            })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
               if (!((<undefinedtype>)(new Object() {
                  public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                     BlockEntity blockEntity = level.getBlockEntity(pos);
                     return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                        return fluidHandler.getFluidInTank(tank).copy();
                     }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
                  }
               })).getFluidInTank(world, BlockPos.containing(x, y, z), (int)tanknumberself).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_OXYGEN.get(), 1)) || !((<undefinedtype>)(new Object() {
                  public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                     BlockEntity blockEntity = level.getBlockEntity(pos);
                     return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                        return fluidHandler.getFluidInTank(tank).copy();
                     }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
                  }
               })).getFluidInTank(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_OXYGEN.get(), 1)) && 0 < ((<undefinedtype>)(new Object() {
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
               })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
                  if (((<undefinedtype>)(new Object() {
                     public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                        BlockEntity blockEntity = level.getBlockEntity(pos);
                        return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                           return fluidHandler.getFluidInTank(tank).copy();
                        }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
                     }
                  })).getFluidInTank(world, BlockPos.containing(x, y, z), (int)tanknumberself).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_HYDROGEN.get(), 1)) && (((<undefinedtype>)(new Object() {
                     public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
                        BlockEntity blockEntity = level.getBlockEntity(pos);
                        return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                           return fluidHandler.getFluidInTank(tank).copy();
                        }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
                     }
                  })).getFluidInTank(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_HYDROGEN.get(), 1)) || 0 >= ((<undefinedtype>)(new Object() {
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
                  })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) && ((<undefinedtype>)(new Object() {
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
                  })).getFluidTankLevel(world, BlockPos.containing(x, y, z), (int)tanknumberself) > ((<undefinedtype>)(new Object() {
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
                  })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
                     amount = (double)((<undefinedtype>)(new Object() {
                        public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_HYDROGEN.get(), amount), FluidAction.SIMULATE));
                              });
                           }

                           return _retval.get();
                        }
                     })).fillTankSimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), 250);
                     fillamount = (double)((<undefinedtype>)(new Object() {
                        public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                           AtomicInteger _retval = new AtomicInteger(0);
                           BlockEntity _ent = level.getBlockEntity(pos);
                           if (_ent != null) {
                              _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                                 _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                              });
                           }

                           return _retval.get();
                        }
                     })).drainTankSimulate(world, BlockPos.containing(x, y, z), (int)amount);
                     _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                     _amount = (int)fillamount;
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           capability.drain(_amount, FluidAction.EXECUTE);
                        });
                     }

                     _ent = world.getBlockEntity(BlockPos.containing(x + sx, y + sy, z + sz));
                     _amount = (int)fillamount;
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_HYDROGEN.get(), _amount), FluidAction.EXECUTE);
                        });
                     }
                  }
               } else if (((<undefinedtype>)(new Object() {
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
               })).getFluidTankLevel(world, BlockPos.containing(x, y, z), (int)tanknumberself) > ((<undefinedtype>)(new Object() {
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
               })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
                  amount = (double)((<undefinedtype>)(new Object() {
                     public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_OXYGEN.get(), amount), FluidAction.SIMULATE));
                           });
                        }

                        return _retval.get();
                     }
                  })).fillTankSimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), 250);
                  fillamount = (double)((<undefinedtype>)(new Object() {
                     public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                        AtomicInteger _retval = new AtomicInteger(0);
                        BlockEntity _ent = level.getBlockEntity(pos);
                        if (_ent != null) {
                           _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                              _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                           });
                        }

                        return _retval.get();
                     }
                  })).drainTankSimulate(world, BlockPos.containing(x, y, z), (int)amount);
                  _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                  _amount = (int)fillamount;
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        capability.drain(_amount, FluidAction.EXECUTE);
                     });
                  }

                  _ent = world.getBlockEntity(BlockPos.containing(x + sx, y + sy, z + sz));
                  _amount = (int)fillamount;
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.LIQUID_OXYGEN.get(), _amount), FluidAction.EXECUTE);
                     });
                  }
               }
            } else if (((<undefinedtype>)(new Object() {
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
            })).getFluidTankLevel(world, BlockPos.containing(x, y, z), (int)tanknumberself) > ((<undefinedtype>)(new Object() {
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
            })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
               amount = (double)((<undefinedtype>)(new Object() {
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
               })).fillTankSimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), 250);
               fillamount = (double)((<undefinedtype>)(new Object() {
                  public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                        });
                     }

                     return _retval.get();
                  }
               })).drainTankSimulate(world, BlockPos.containing(x, y, z), (int)amount);
               _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
               _amount = (int)fillamount;
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                     capability.drain(_amount, FluidAction.EXECUTE);
                  });
               }

               _ent = world.getBlockEntity(BlockPos.containing(x + sx, y + sy, z + sz));
               _amount = (int)fillamount;
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                     capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), _amount), FluidAction.EXECUTE);
                  });
               }
            }
         } else if (((<undefinedtype>)(new Object() {
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
         })).getFluidTankLevel(world, BlockPos.containing(x, y, z), (int)tanknumberself) > ((<undefinedtype>)(new Object() {
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
         })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
            amount = (double)((<undefinedtype>)(new Object() {
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
            })).fillTankSimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), 250);
            fillamount = (double)((<undefinedtype>)(new Object() {
               public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                     });
                  }

                  return _retval.get();
               }
            })).drainTankSimulate(world, BlockPos.containing(x, y, z), (int)amount);
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            _amount = (int)fillamount;
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.drain(_amount, FluidAction.EXECUTE);
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(x + sx, y + sy, z + sz));
            _amount = (int)fillamount;
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), _amount), FluidAction.EXECUTE);
               });
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getFluidTankLevel(world, BlockPos.containing(x, y, z), (int)tanknumberself) > ((<undefinedtype>)(new Object() {
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
      })).getFluidTankLevel(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)tanknumbertarget)) {
         amount = (double)((<undefinedtype>)(new Object() {
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
         })).fillTankSimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), 250);
         fillamount = (double)((<undefinedtype>)(new Object() {
            public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                  });
               }

               return _retval.get();
            }
         })).drainTankSimulate(world, BlockPos.containing(x, y, z), (int)amount);
         _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
         _amount = (int)fillamount;
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
               capability.drain(_amount, FluidAction.EXECUTE);
            });
         }

         _ent = world.getBlockEntity(BlockPos.containing(x + sx, y + sy, z + sz));
         _amount = (int)fillamount;
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
               capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), _amount), FluidAction.EXECUTE);
            });
         }
      }

   }
}
