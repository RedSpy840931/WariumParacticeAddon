package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class ConveyorUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      double ZOffset = 0.0D;
      double checkslotID = 0.0D;
      double ItemCount = 0.0D;
      double YOffset = 0.0D;
      double XOffset = 0.0D;
      XOffset = (double)((<undefinedtype>)(new Object() {
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
      YOffset = (double)((<undefinedtype>)(new Object() {
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
      ZOffset = (double)((<undefinedtype>)(new Object() {
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
      int index1;
      BlockEntity _ent;
      boolean _slotid;
      ItemStack _setstack;
      int _slotid;
      if (((<undefinedtype>)(new Object() {
         public int getContainerSize(LevelAccessor world, BlockPos pos) {
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null && _ent instanceof BaseContainerBlockEntity) {
               BaseContainerBlockEntity _block = (BaseContainerBlockEntity)_ent;
               return _block.getContainerSize();
            } else {
               return 0;
            }
         }

         public int getAmount(LevelAccessor world, BlockPos pos) {
            Block block = world.getBlockState(pos).getBlock();
            if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
               boolean var10000;
               label17: {
                  Property var6 = block.getStateDefinition().getProperty("type");
                  if (var6 instanceof EnumProperty) {
                     EnumProperty _getep5 = (EnumProperty)var6;
                     if (world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE")) {
                        var10000 = true;
                        break label17;
                     }
                  }

                  var10000 = false;
               }

               boolean isSingle = var10000;
               if (!isSingle) {
                  return this.getContainerSize(world, pos) * 2;
               }
            }

            return this.getContainerSize(world, pos);
         }
      })).getAmount(world, new BlockPos((int)(x - XOffset), (int)(y - YOffset), (int)(z - ZOffset))) > 0) {
         checkslotID = 0.0D;

         for(index1 = 0; index1 < ((<undefinedtype>)(new Object() {
            public int getContainerSize(LevelAccessor world, BlockPos pos) {
               BlockEntity _ent = world.getBlockEntity(pos);
               if (_ent != null && _ent instanceof BaseContainerBlockEntity) {
                  BaseContainerBlockEntity _block = (BaseContainerBlockEntity)_ent;
                  return _block.getContainerSize();
               } else {
                  return 0;
               }
            }

            public int getAmount(LevelAccessor world, BlockPos pos) {
               Block block = world.getBlockState(pos).getBlock();
               if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
                  boolean var10000;
                  label17: {
                     Property var6 = block.getStateDefinition().getProperty("type");
                     if (var6 instanceof EnumProperty) {
                        EnumProperty _getep5 = (EnumProperty)var6;
                        if (world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE")) {
                           var10000 = true;
                           break label17;
                        }
                     }

                     var10000 = false;
                  }

                  boolean isSingle = var10000;
                  if (!isSingle) {
                     return this.getContainerSize(world, pos) * 2;
                  }
               }

               return this.getContainerSize(world, pos);
            }
         })).getAmount(world, new BlockPos((int)(x - XOffset), (int)(y - YOffset), (int)(z - ZOffset))); ++index1) {
            if ((world.getBlockState(BlockPos.containing(x - XOffset, y - YOffset, z - ZOffset)).is(BlockTags.create(new ResourceLocation("crusty_chunks:extractable"))) || ((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x - XOffset, y - YOffset, z - ZOffset), "Greenlight")) && ((<undefinedtype>)(new Object() {
               public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
                  AtomicInteger _retval = new AtomicInteger(0);
                  BlockEntity _ent = world.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getStackInSlot(slotid).getCount());
                     });
                  }

                  return _retval.get();
               }
            })).getAmount(world, BlockPos.containing(x, y, z), 0) == 0) {
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
               })).getItemStack(world, BlockPos.containing(x - XOffset, y - YOffset, z - ZOffset), (int)checkslotID).getItem() != ItemStack.EMPTY.getItem()) {
                  _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                  if (_ent != null) {
                     _slotid = false;
                     _setstack = ((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x - XOffset, y - YOffset, z - ZOffset), (int)checkslotID).copy();
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
                     })).getItemStack(world, BlockPos.containing(x - XOffset, y - YOffset, z - ZOffset), (int)checkslotID).getCount());
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                        }

                     });
                  }

                  _ent = world.getBlockEntity(BlockPos.containing(x - XOffset, y - YOffset, z - ZOffset));
                  if (_ent != null) {
                     _slotid = (int)checkslotID;
                     _setstack = ((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x - XOffset, y - YOffset, z - ZOffset), (int)checkslotID).copy();
                     _setstack.setCount(0);
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ((IItemHandlerModifiable)capability).setStackInSlot(_slotid, _setstack);
                        }

                     });
                  }
                  break;
               }

               ++checkslotID;
            }
         }
      }

      if (((<undefinedtype>)(new Object() {
         public int getContainerSize(LevelAccessor world, BlockPos pos) {
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null && _ent instanceof BaseContainerBlockEntity) {
               BaseContainerBlockEntity _block = (BaseContainerBlockEntity)_ent;
               return _block.getContainerSize();
            } else {
               return 0;
            }
         }

         public int getAmount(LevelAccessor world, BlockPos pos) {
            Block block = world.getBlockState(pos).getBlock();
            if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
               boolean var10000;
               label17: {
                  Property var6 = block.getStateDefinition().getProperty("type");
                  if (var6 instanceof EnumProperty) {
                     EnumProperty _getep5 = (EnumProperty)var6;
                     if (world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE")) {
                        var10000 = true;
                        break label17;
                     }
                  }

                  var10000 = false;
               }

               boolean isSingle = var10000;
               if (!isSingle) {
                  return this.getContainerSize(world, pos) * 2;
               }
            }

            return this.getContainerSize(world, pos);
         }
      })).getAmount(world, new BlockPos((int)(x + XOffset), (int)(y + YOffset), (int)(z + ZOffset))) > 0) {
         checkslotID = 0.0D;

         for(index1 = 0; index1 < ((<undefinedtype>)(new Object() {
            public int getContainerSize(LevelAccessor world, BlockPos pos) {
               BlockEntity _ent = world.getBlockEntity(pos);
               if (_ent != null && _ent instanceof BaseContainerBlockEntity) {
                  BaseContainerBlockEntity _block = (BaseContainerBlockEntity)_ent;
                  return _block.getContainerSize();
               } else {
                  return 0;
               }
            }

            public int getAmount(LevelAccessor world, BlockPos pos) {
               Block block = world.getBlockState(pos).getBlock();
               if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
                  boolean var10000;
                  label17: {
                     Property var6 = block.getStateDefinition().getProperty("type");
                     if (var6 instanceof EnumProperty) {
                        EnumProperty _getep5 = (EnumProperty)var6;
                        if (world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE")) {
                           var10000 = true;
                           break label17;
                        }
                     }

                     var10000 = false;
                  }

                  boolean isSingle = var10000;
                  if (!isSingle) {
                     return this.getContainerSize(world, pos) * 2;
                  }
               }

               return this.getContainerSize(world, pos);
            }
         })).getAmount(world, new BlockPos((int)(x + XOffset), (int)(y + YOffset), (int)(z + ZOffset))); ++index1) {
            if ((world.getBlockState(BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset)).is(BlockTags.create(new ResourceLocation("crusty_chunks:insertable"))) || ((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), "Greenlight")) && ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 0).getCount() != 0) {
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
               })).getItemStack(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), (int)checkslotID).getItem() == ItemStack.EMPTY.getItem()) {
                  _ent = world.getBlockEntity(BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset));
                  if (_ent != null) {
                     _slotid = (int)checkslotID;
                     _setstack = ((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x, y, z), 0).copy();
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
                     })).getItemStack(world, BlockPos.containing(x, y, z), 0).getCount());
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ((IItemHandlerModifiable)capability).setStackInSlot(_slotid, _setstack);
                        }

                     });
                  }

                  _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                  if (_ent != null) {
                     _slotid = false;
                     _setstack = ((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x, y, z), 0).copy();
                     _setstack.setCount(0);
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                        }

                     });
                  }
                  break;
               }

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
               })).getItemStack(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), (int)checkslotID).getItem() == ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() && ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), (int)checkslotID).getMaxStackSize() - ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), (int)checkslotID).getCount() > 0) {
                  ItemCount = (double)Math.min(((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), (int)checkslotID).getMaxStackSize() - ((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), (int)checkslotID).getCount(), ((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.containing(x, y, z), 0).getCount());
                  _ent = world.getBlockEntity(BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset));
                  if (_ent != null) {
                     _slotid = (int)checkslotID;
                     _setstack = ((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x, y, z), 0).copy();
                     _setstack.setCount((int)((double)((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset), (int)checkslotID).getCount() + ItemCount));
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ((IItemHandlerModifiable)capability).setStackInSlot(_slotid, _setstack);
                        }

                     });
                  }

                  _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
                  if (_ent != null) {
                     _slotid = false;
                     _setstack = ((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x, y, z), 0).copy();
                     _setstack.setCount((int)((double)((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x, y, z), 0).getCount() - ItemCount));
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                        }

                     });
                  }
                  break;
               }

               ++checkslotID;
            }
         }
      } else if (world.getBlockState(BlockPos.containing(x + XOffset, y + YOffset, z + ZOffset)).getBlock() == Blocks.AIR && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getCount() >= 1) {
         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            ItemEntity entityToSpawn = new ItemEntity(_level, x + XOffset + 0.5D, y + YOffset + 0.5D, z + ZOffset + 0.5D, ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 0));
            entityToSpawn.setPickUpDelay(10);
            _level.addFreshEntity(entityToSpawn);
         }

         BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
         if (_ent != null) {
            int _slotid = false;
            ItemStack _setstack = ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 0).copy();
            _setstack.setCount(0);
            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
               }

            });
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.POOF, x + XOffset + 0.5D, y + YOffset + 0.5D, z + ZOffset + 0.5D, 5, 0.5D, 0.5D, 0.5D, 0.02D);
         }
      }

   }
}
