package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.registries.ForgeRegistries;

public class EnergyNodeTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      boolean targetinputonly = false;
      boolean targetoutputonly = false;
      double TestNumber = 0.0D;
      double TestNumber2 = 0.0D;
      double powerx = 0.0D;
      double powery = 0.0D;
      double powerz = 0.0D;
      double targetx = 0.0D;
      double targety = 0.0D;
      double targetz = 0.0D;
      powerx = ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "PowerX");
      powery = ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "PowerY");
      powerz = ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "PowerZ");
      targetx = x - (double)((<undefinedtype>)(new Object() {
         public Direction getDirection(BlockState _bs) {
            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
            if (_prop instanceof DirectionProperty) {
               DirectionProperty _dp = (DirectionProperty)_prop;
               return (Direction)_bs.getValue(_dp);
            } else {
               _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
               Direction var10000;
               if (_prop instanceof EnumProperty) {
                  EnumProperty _ep = (EnumProperty)_prop;
                  if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                     var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                     return var10000;
                  }
               }

               var10000 = Direction.NORTH;
               return var10000;
            }
         }
      })).getDirection(blockstate).getStepX();
      targety = y - (double)((<undefinedtype>)(new Object() {
         public Direction getDirection(BlockState _bs) {
            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
            if (_prop instanceof DirectionProperty) {
               DirectionProperty _dp = (DirectionProperty)_prop;
               return (Direction)_bs.getValue(_dp);
            } else {
               _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
               Direction var10000;
               if (_prop instanceof EnumProperty) {
                  EnumProperty _ep = (EnumProperty)_prop;
                  if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                     var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                     return var10000;
                  }
               }

               var10000 = Direction.NORTH;
               return var10000;
            }
         }
      })).getDirection(blockstate).getStepY();
      targetz = z - (double)((<undefinedtype>)(new Object() {
         public Direction getDirection(BlockState _bs) {
            Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
            if (_prop instanceof DirectionProperty) {
               DirectionProperty _dp = (DirectionProperty)_prop;
               return (Direction)_bs.getValue(_dp);
            } else {
               _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
               Direction var10000;
               if (_prop instanceof EnumProperty) {
                  EnumProperty _ep = (EnumProperty)_prop;
                  if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                     var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                     return var10000;
                  }
               }

               var10000 = Direction.NORTH;
               return var10000;
            }
         }
      })).getDirection(blockstate).getStepZ();
      BlockEntity _ent;
      int _amount;
      if ((powerx != 0.0D || powery != 0.0D || powerz != 0.0D) && world.getBlockState(BlockPos.containing(powerx, powery, powerz)).getBlock() == CrustyChunksModBlocks.ENERGY_NODE.get() && ((<undefinedtype>)(new Object() {
         public int getEnergyStored(LevelAccessor level, BlockPos pos) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getEnergyStored());
               });
            }

            return _retval.get();
         }
      })).getEnergyStored(world, BlockPos.containing(x, y, z)) > ((<undefinedtype>)(new Object() {
         public int getEnergyStored(LevelAccessor level, BlockPos pos) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getEnergyStored());
               });
            }

            return _retval.get();
         }
      })).getEnergyStored(world, BlockPos.containing(powerx, powery, powerz))) {
         TestNumber = (double)((<undefinedtype>)(new Object() {
            public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.receiveEnergy(_amount, true));
                  });
               }

               return _retval.get();
            }
         })).receiveEnergySimulate(world, BlockPos.containing(powerx, powery, powerz), ((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(x, y, z)));
         TestNumber2 = (double)((<undefinedtype>)(new Object() {
            public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.extractEnergy(_amount, true));
                  });
               }

               return _retval.get();
            }
         })).extractEnergySimulate(world, BlockPos.containing(x, y, z), (int)TestNumber);
         _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
         _amount = (int)(TestNumber2 / 2.0D);
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
               capability.extractEnergy(_amount, false);
            });
         }

         _ent = world.getBlockEntity(BlockPos.containing(powerx, powery, powerz));
         _amount = (int)(TestNumber2 / 2.0D);
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
               capability.receiveEnergy(_amount, false);
            });
         }
      }

      if ((((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(powerx, powery, powerz), "PowerX") != x || ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(powerx, powery, powerz), "PowerY") != y || ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(powerx, powery, powerz), "PowerZ") != z) && world.getBlockState(BlockPos.containing(powerx, powery, powerz)).getBlock() == CrustyChunksModBlocks.ENERGY_NODE.get() && world.getBlockState(BlockPos.containing(powerx, powery, powerz)).getBlock() == CrustyChunksModBlocks.ENERGY_NODE.get()) {
         BlockState _bs;
         Level _level;
         BlockPos _bp;
         BlockEntity _blockEntity;
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("PowerX", 0.0D);
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
               _blockEntity.getPersistentData().putDouble("PowerY", 0.0D);
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
               _blockEntity.getPersistentData().putDouble("Powerz", 0.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(powerx, powery, powerz);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("PowerX", 0.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(powerx, powery, powerz);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("PowerY", 0.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(powerx, powery, powerz);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Powerz", 0.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.BLOCKS, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
         }
      }

      if (world.getBlockState(BlockPos.containing(targetx, targety, targetz)).is(BlockTags.create(new ResourceLocation("crusty_chunks:poweroutputonly")))) {
         targetoutputonly = true;
      }

      if (world.getBlockState(BlockPos.containing(targetx, targety, targetz)).is(BlockTags.create(new ResourceLocation("crusty_chunks:powerinputonly")))) {
         targetinputonly = true;
      }

      if (((<undefinedtype>)(new Object() {
         public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
            AtomicBoolean _retval = new AtomicBoolean(false);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.canReceive());
               });
            }

            return _retval.get();
         }
      })).canReceiveEnergy(world, BlockPos.containing(targetx, targety, targetz)) || ((<undefinedtype>)(new Object() {
         public boolean canExtractEnergy(LevelAccessor level, BlockPos pos) {
            AtomicBoolean _retval = new AtomicBoolean(false);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.canExtract());
               });
            }

            return _retval.get();
         }
      })).canExtractEnergy(world, BlockPos.containing(targetx, targety, targetz))) {
         if ((targetoutputonly || ((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(x, y, z)) < ((<undefinedtype>)(new Object() {
            public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getMaxEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getMaxEnergyStored(world, BlockPos.containing(x, y, z)) / 2 && ((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(x, y, z)) < ((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(targetx, targety, targetz)) && !targetinputonly) && ((<undefinedtype>)(new Object() {
            public boolean canExtractEnergy(LevelAccessor level, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.canExtract());
                  });
               }

               return _retval.get();
            }
         })).canExtractEnergy(world, BlockPos.containing(targetx, targety, targetz))) {
            TestNumber = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
               public int getEnergyStored(LevelAccessor level, BlockPos pos) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getEnergyStored());
                     });
                  }

                  return _retval.get();
               }
            })).getEnergyStored(world, BlockPos.containing(targetx, targety, targetz)));
            TestNumber2 = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, BlockPos.containing(targetx, targety, targetz), (int)TestNumber);
            _ent = world.getBlockEntity(BlockPos.containing(targetx, targety, targetz));
            _amount = (int)(TestNumber2 / 2.0D);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            _amount = (int)(TestNumber2 / 2.0D);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         } else if ((targetinputonly || (((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(x, y, z)) > ((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(targetx, targety, targetz)) || ((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(targetx, targety, targetz)) < ((<undefinedtype>)(new Object() {
            public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getMaxEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getMaxEnergyStored(world, BlockPos.containing(targetx, targety, targetz))) && !targetoutputonly) && ((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, BlockPos.containing(targetx, targety, targetz))) {
            TestNumber = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, BlockPos.containing(targetx, targety, targetz), ((<undefinedtype>)(new Object() {
               public int getEnergyStored(LevelAccessor level, BlockPos pos) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getEnergyStored());
                     });
                  }

                  return _retval.get();
               }
            })).getEnergyStored(world, BlockPos.containing(x, y, z)));
            TestNumber2 = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, BlockPos.containing(x, y, z), (int)TestNumber);
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            _amount = (int)(TestNumber2 / 2.0D);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(targetx, targety, targetz));
            _amount = (int)(TestNumber2 / 2.0D);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         } else if (((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(x, y, z)) > ((<undefinedtype>)(new Object() {
            public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getMaxEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getMaxEnergyStored(world, BlockPos.containing(x, y, z)) / 2 && ((<undefinedtype>)(new Object() {
            public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
               AtomicBoolean _retval = new AtomicBoolean(false);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.canReceive());
                  });
               }

               return _retval.get();
            }
         })).canReceiveEnergy(world, BlockPos.containing(targetx, targety, targetz)) && ((<undefinedtype>)(new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getEnergyStored(world, BlockPos.containing(targetx, targety, targetz)) < ((<undefinedtype>)(new Object() {
            public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.getMaxEnergyStored());
                  });
               }

               return _retval.get();
            }
         })).getMaxEnergyStored(world, BlockPos.containing(targetx, targety, targetz))) {
            TestNumber = (double)((<undefinedtype>)(new Object() {
               public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.receiveEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).receiveEnergySimulate(world, BlockPos.containing(targetx, targety, targetz), ((<undefinedtype>)(new Object() {
               public int getEnergyStored(LevelAccessor level, BlockPos pos) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getEnergyStored());
                     });
                  }

                  return _retval.get();
               }
            })).getEnergyStored(world, BlockPos.containing(x, y, z)));
            TestNumber2 = (double)((<undefinedtype>)(new Object() {
               public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = level.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.extractEnergy(_amount, true));
                     });
                  }

                  return _retval.get();
               }
            })).extractEnergySimulate(world, BlockPos.containing(x, y, z), (int)TestNumber);
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            _amount = (int)(TestNumber2 / 2.0D);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.extractEnergy(_amount, false);
               });
            }

            _ent = world.getBlockEntity(BlockPos.containing(targetx, targety, targetz));
            _amount = (int)(TestNumber2 / 2.0D);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }
      }

   }
}
