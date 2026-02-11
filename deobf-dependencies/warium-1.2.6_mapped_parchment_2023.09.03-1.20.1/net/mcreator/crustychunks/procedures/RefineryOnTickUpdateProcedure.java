package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class RefineryOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      if (((<undefinedtype>)(new Object() {
         public int getAmountInTank(LevelAccessor level, BlockPos pos, int tank) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            return blockEntity != null ? (Integer)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
               return fluidHandler.getFluidInTank(tank).getAmount();
            }).orElse(0) : 0;
         }
      })).getAmountInTank(world, BlockPos.containing(x, y + 1.0D, z), ((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x, y + 1.0D, z))) <= 15750 && ((<undefinedtype>)(new Object() {
         public int getAmountInTank(LevelAccessor level, BlockPos pos, int tank) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            return blockEntity != null ? (Integer)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
               return fluidHandler.getFluidInTank(tank).getAmount();
            }).orElse(0) : 0;
         }
      })).getAmountInTank(world, BlockPos.containing(x, y + 2.0D, z), ((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x, y + 2.0D, z))) <= 15750 && ((<undefinedtype>)(new Object() {
         public int getAmountInTank(LevelAccessor level, BlockPos pos, int tank) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            return blockEntity != null ? (Integer)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
               return fluidHandler.getFluidInTank(tank).getAmount();
            }).orElse(0) : 0;
         }
      })).getAmountInTank(world, BlockPos.containing(x, y + 3.0D, z), ((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x, y + 3.0D, z))) <= 15750 && ((<undefinedtype>)(new Object() {
         public int getAmountInTank(LevelAccessor level, BlockPos pos, int tank) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            return blockEntity != null ? (Integer)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
               return fluidHandler.getFluidInTank(tank).getAmount();
            }).orElse(0) : 0;
         }
      })).getAmountInTank(world, BlockPos.containing(x, y + 4.0D, z), ((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x, y + 4.0D, z))) <= 15750) {
         if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == CrustyChunksModBlocks.REFINERY_TOWER.get()) {
            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y + 1.0D, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putString("Fluid", "Oil");
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            if (world.getBlockState(BlockPos.containing(x, y + 2.0D, z)).getBlock() == CrustyChunksModBlocks.REFINERY_TOWER.get()) {
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y + 2.0D, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putString("Fluid", "Diesel");
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world.getBlockState(BlockPos.containing(x, y + 3.0D, z)).getBlock() == CrustyChunksModBlocks.REFINERY_TOWER.get()) {
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y + 3.0D, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putString("Fluid", "Kerosene");
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x, y + 4.0D, z)).getBlock() == CrustyChunksModBlocks.REFINERY_TOWER.get()) {
                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(x, y + 4.0D, z);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putString("Fluid", "Petrolium");
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(x, y, z);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putBoolean("Ready", true);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }
                  } else if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("Ready", false);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }
               } else if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("Ready", false);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }
            } else if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putBoolean("Ready", false);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         } else if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putBoolean("Ready", false);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Heat") >= 200.0D && ((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Ready") && ((<undefinedtype>)(new Object() {
            public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
               AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.EMPTY);
               BlockEntity _ent = world.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getStackInSlot(slotid).copy());
                  });
               }

               return (ItemStack)_retval.get();
            }
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == CrustyChunksModItems.SHALE_OIL.get()) {
            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               int _slotid = false;
               int _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(1);
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                  }

               });
            }

            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 5.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y + 6.0D, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 20.0F, 0.2F);
               } else {
                  _level.playLocalSound(x, y + 6.0D, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 20.0F, 0.2F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.RISING_FLAME.get(), x + 0.5D, y + 6.0D, z + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.1D);
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y + 1.0D, z));
            int _amount = ((<undefinedtype>)(new Object() {
               public int fillTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.OIL.get(), amount), FluidAction.SIMULATE));
                     });
                  }

                  return _retval.get();
               }
            })).fillTankSimulate(world, BlockPos.containing(x, y + 1.0D, z), 250);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.OIL.get(), _amount), FluidAction.EXECUTE);
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y + 2.0D, z));
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
            })).fillTankSimulate(world, BlockPos.containing(x, y + 2.0D, z), 250);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), _amount), FluidAction.EXECUTE);
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y + 3.0D, z));
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
            })).fillTankSimulate(world, BlockPos.containing(x, y + 3.0D, z), 250);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), _amount), FluidAction.EXECUTE);
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y + 4.0D, z));
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
            })).fillTankSimulate(world, BlockPos.containing(x, y + 4.0D, z), 250);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.fill(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), _amount), FluidAction.EXECUTE);
               });
            }
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Heat") >= 5.0D && !world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 1.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Heat") >= 1500.0D && !world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 10.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

   }
}
