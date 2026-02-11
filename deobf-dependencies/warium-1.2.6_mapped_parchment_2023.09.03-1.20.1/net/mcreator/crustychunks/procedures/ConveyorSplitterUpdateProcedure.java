package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class ConveyorSplitterUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      Direction behind = Direction.NORTH;
      Direction ahead = Direction.NORTH;
      Direction orange = Direction.NORTH;
      Direction magenta = Direction.NORTH;
      ItemStack input = ItemStack.EMPTY;
      double OffsetX = 0.0D;
      double OffsetZ = 0.0D;
      double Power = 0.0D;
      double outputslot = 0.0D;
      double slotlog = 0.0D;
      boolean forward = false;
      boolean orangesend = false;
      boolean magentasend = false;
      outputslot = (double)Mth.nextInt(RandomSource.create(), 0, 3);
      OffsetX = (double)((<undefinedtype>)(new Object() {
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
      OffsetZ = (double)((<undefinedtype>)(new Object() {
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
      ahead = ((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate);
      orange = ((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).getCounterClockWise(Axis.Y);
      magenta = ((<undefinedtype>)(new Object() {
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
      })).getDirection(blockstate).getClockWise(Axis.Y);
      input = ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x - OffsetX, y, z - OffsetZ), 0).copy();
      if (Blocks.AIR.asItem() != input.getItem()) {
         int index1;
         for(index1 = 0; index1 < 6; ++index1) {
            if (((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), (int)slotlog).getItem() == input.getItem()) {
               orangesend = true;
            }

            ++slotlog;
         }

         if (!orangesend) {
            for(index1 = 0; index1 < 6; ++index1) {
               if (((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x, y, z), (int)slotlog).getItem() == input.getItem()) {
                  magentasend = true;
               }

               ++slotlog;
            }

            if (!magentasend) {
               forward = true;
            }
         }

         boolean _slotid;
         ItemStack _setstack;
         BlockEntity _ent;
         Level _level;
         boolean _amount;
         if (orangesend) {
            if (world.getBlockState(BlockPos.containing(x + (double)orange.getStepX(), y, z + (double)orange.getStepZ())).getBlock() == CrustyChunksModBlocks.CONVEYOR.get() && (((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)orange.getStepX(), y + (double)orange.getStepY(), z + (double)orange.getStepZ()), 0).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)orange.getStepX(), y + (double)orange.getStepY(), z + (double)orange.getStepZ()), 0).getItem() == input.getItem() && ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)orange.getStepX(), y + (double)orange.getStepY(), z + (double)orange.getStepZ()), 0).getMaxStackSize() > ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)orange.getStepX(), y + (double)orange.getStepY(), z + (double)orange.getStepZ()), 0).getCount())) {
               _ent = world.getBlockEntity(BlockPos.containing(x + (double)orange.getStepX(), y, z + (double)orange.getStepZ()));
               if (_ent != null) {
                  _slotid = false;
                  _setstack = input.copy();
                  _setstack.setCount(((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.containing(x + (double)orange.getStepX(), y + (double)orange.getStepY(), z + (double)orange.getStepZ()), 0).getCount() + 1);
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                     }

                  });
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_cluster.place")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_cluster.place")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               _ent = world.getBlockEntity(BlockPos.containing(x - OffsetX, y, z - OffsetZ));
               if (_ent != null) {
                  _slotid = false;
                  _amount = true;
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ItemStack _stk = capability.getStackInSlot(0).copy();
                        _stk.shrink(1);
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                     }

                  });
               }
            }
         } else if (magentasend) {
            if (world.getBlockState(BlockPos.containing(x + (double)magenta.getStepX(), y, z + (double)magenta.getStepZ())).getBlock() == CrustyChunksModBlocks.CONVEYOR.get() && (((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)magenta.getStepX(), y + (double)magenta.getStepY(), z + (double)magenta.getStepZ()), 0).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)magenta.getStepX(), y + (double)magenta.getStepY(), z + (double)magenta.getStepZ()), 0).getItem() == input.getItem() && ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)magenta.getStepX(), y + (double)magenta.getStepY(), z + (double)magenta.getStepZ()), 0).getMaxStackSize() > ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x + (double)magenta.getStepX(), y + (double)magenta.getStepY(), z + (double)magenta.getStepZ()), 0).getCount())) {
               _ent = world.getBlockEntity(BlockPos.containing(x + (double)magenta.getStepX(), y, z + (double)magenta.getStepZ()));
               if (_ent != null) {
                  _slotid = false;
                  _setstack = input.copy();
                  _setstack.setCount(((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.containing(x + (double)magenta.getStepX(), y + (double)magenta.getStepY(), z + (double)magenta.getStepZ()), 0).getCount() + 1);
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                     }

                  });
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_cluster.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_cluster.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               _ent = world.getBlockEntity(BlockPos.containing(x - OffsetX, y, z - OffsetZ));
               if (_ent != null) {
                  _slotid = false;
                  _amount = true;
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ItemStack _stk = capability.getStackInSlot(0).copy();
                        _stk.shrink(1);
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                     }

                  });
               }
            }
         } else if (world.getBlockState(BlockPos.containing(x + (double)ahead.getStepX(), y, z + (double)ahead.getStepZ())).getBlock() == CrustyChunksModBlocks.CONVEYOR.get() && (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + (double)ahead.getStepX(), y + (double)ahead.getStepY(), z + (double)ahead.getStepZ()), 0).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + (double)ahead.getStepX(), y + (double)ahead.getStepY(), z + (double)ahead.getStepZ()), 0).getItem() == input.getItem() && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + (double)ahead.getStepX(), y + (double)ahead.getStepY(), z + (double)ahead.getStepZ()), 0).getMaxStackSize() > ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + (double)ahead.getStepX(), y + (double)ahead.getStepY(), z + (double)ahead.getStepZ()), 0).getCount())) {
            _ent = world.getBlockEntity(BlockPos.containing(x + (double)ahead.getStepX(), y, z + (double)ahead.getStepZ()));
            if (_ent != null) {
               _slotid = false;
               _setstack = input.copy();
               _setstack.setCount(((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x + (double)ahead.getStepX(), y + (double)ahead.getStepY(), z + (double)ahead.getStepZ()), 0).getCount() + 1);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                  }

               });
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_cluster.place")), SoundSource.NEUTRAL, 1.0F, 0.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_cluster.place")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x - OffsetX, y, z - OffsetZ));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(1);
                     ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                  }

               });
            }
         }
      }

   }
}
