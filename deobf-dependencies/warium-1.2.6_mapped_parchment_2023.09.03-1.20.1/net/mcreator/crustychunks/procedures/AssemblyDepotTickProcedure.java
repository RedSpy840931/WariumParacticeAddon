package net.mcreator.crustychunks.procedures;

import com.google.gson.JsonObject;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
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

public class AssemblyDepotTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      new JsonObject();
      boolean Success = false;
      boolean tagged = false;
      double inputslot = 0.0D;
      double OffsetX = 0.0D;
      double OffsetZ = 0.0D;
      double runs = 0.0D;
      double outputslot = 0.0D;
      double Power = 0.0D;
      double specificindex = 0.0D;
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
      if (0.0D < ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y + 1.0D, z))).getStepX(), y + 1.0D, z - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y + 1.0D, z))).getStepZ()), "KineticPower") && ((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y + 1.0D, z))).getStepX(), y + 1.0D, z - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y + 1.0D, z))).getStepZ()))) == ((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y + 1.0D, z)))) {
         Power = ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x - (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(world.getBlockState(BlockPos.containing(x, y + 1.0D, z))).getStepX(), y + 1.0D, z - (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(world.getBlockState(BlockPos.containing(x, y + 1.0D, z))).getStepZ()), "KineticPower");
      } else {
         Power = 0.0D;
      }

      if (0.0D < Power && world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == CrustyChunksModBlocks.ASSEMBLY_MACHINE.get() && world.getBlockState(BlockPos.containing(x - OffsetX, y, z - OffsetZ)).getBlock() == CrustyChunksModBlocks.PRODUCTION_INPUT.get() && world.getBlockState(BlockPos.containing(x + OffsetX, y, z + OffsetZ)).getBlock() == CrustyChunksModBlocks.PRODUCTION_OUTPUT.get() && ItemStack.EMPTY.getItem() != ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x - OffsetX, y, z - OffsetZ), 0).getItem() && ItemStack.EMPTY.getItem() != ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y + 1.0D, z), 0).getItem()) {
         Success = false;

         BlockEntity _ent;
         for(int index0 = 0; index0 < CrustyChunksModVariables.recipesloaded.size(); ++index0) {
            JsonObject Recipe = CrustyChunksModVariables.recipesloaded.get((int)specificindex).getAsJsonObject();
            if (Recipe.get("type").getAsString().equals("crusty_chunks:assembly")) {
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
               })).getItemStack(world, BlockPos.containing(x - OffsetX, y, z - OffsetZ), 0).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("item").getAsString().toLowerCase(Locale.ENGLISH)))) {
                  tagged = false;
               } else if (Recipe.get("item").getAsString().contains("forge") && ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x - OffsetX, y, z - OffsetZ), 0).is(ItemTags.create(new ResourceLocation(Recipe.get("item").getAsString().toLowerCase(Locale.ENGLISH))))) {
                  tagged = true;
               }

               if ((((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x - OffsetX, y, z - OffsetZ), 0).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("item").getAsString().toLowerCase(Locale.ENGLISH))) || ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x - OffsetX, y, z - OffsetZ), 0).is(ItemTags.create(new ResourceLocation(Recipe.get("item").getAsString().toLowerCase(Locale.ENGLISH)))) && tagged) && ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x, y + 1.0D, z), 0).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) && (((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), (int)outputslot).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), (int)outputslot).getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("result").getAsString().toLowerCase(Locale.ENGLISH))) && ((<undefinedtype>)(new Object() {
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
               })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), (int)outputslot) < (new ItemStack((ItemLike)ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("result").getAsString().toLowerCase(Locale.ENGLISH))))).getMaxStackSize()) && ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("result").getAsString().toLowerCase(Locale.ENGLISH))) != Blocks.AIR.asItem() && (ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation(Recipe.get("item").getAsString().toLowerCase(Locale.ENGLISH)))).getRandomElement(RandomSource.create()).orElseGet(() -> {
                  return Items.AIR;
               }) != Blocks.AIR.asItem() && tagged || ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("item").getAsString().toLowerCase(Locale.ENGLISH))) != Blocks.AIR.asItem() && !tagged)) {
                  runs = Recipe.get("runs").getAsDouble();
                  boolean _slotid;
                  boolean _amount;
                  Level _level;
                  BlockPos _bp;
                  Level _level;
                  BlockEntity _blockEntity;
                  ServerLevel _level;
                  BlockState _bs;
                  if (((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "work") >= runs) {
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

                     _ent = world.getBlockEntity(BlockPos.containing(x, y + 1.0D, z));
                     if (_ent != null) {
                        _slotid = false;
                        _amount = true;
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ItemStack _stk = capability.getStackInSlot(0).copy();
                              if (_stk.hurt(1, RandomSource.create(), (ServerPlayer)null)) {
                                 _stk.shrink(1);
                                 _stk.setDamageValue(0);
                              }

                              ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                           }

                        });
                     }

                     _ent = world.getBlockEntity(BlockPos.containing(x + OffsetX, y, z + OffsetZ));
                     if (_ent != null) {
                        int _slotid = (int)outputslot;
                        ItemStack _setstack = (new ItemStack((ItemLike)ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("result").getAsString().toLowerCase(Locale.ENGLISH))))).copy();
                        _setstack.setCount(((<undefinedtype>)(new Object() {
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
                        })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), (int)outputslot) + 1);
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ((IItemHandlerModifiable)capability).setStackInSlot(_slotid, _setstack);
                           }

                        });
                     }

                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(x, y, z);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putDouble("work", 0.0D);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_PRESS.get()) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 0.8F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 0.8F, false);
                           }
                        }
                     } else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_SHEAR.get()) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")), SoundSource.NEUTRAL, 2.0F, 0.8F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")), SoundSource.NEUTRAL, 2.0F, 0.8F, false);
                           }
                        }
                     } else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_BORE.get()) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 2.0F, 0.8F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 2.0F, 0.8F, false);
                           }
                        }
                     } else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_EXTRUDER.get() && world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.NEUTRAL, 2.0F, 0.8F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.NEUTRAL, 2.0F, 0.8F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 0.9D, z + 0.5D, 5, 0.1D, 0.1D, 0.1D, 0.5D);
                     }
                  } else {
                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(x, y, z);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putDouble("work", 1.0D * (Power / 25.0D) + ((<undefinedtype>)(new Object() {
                              public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                 BlockEntity blockEntity = world.getBlockEntity(pos);
                                 return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                              }
                           })).getValue(world, BlockPos.containing(x, y, z), "work"));
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     _ent = world.getBlockEntity(BlockPos.containing(x, y + 1.0D, z));
                     if (_ent != null) {
                        _slotid = false;
                        _amount = true;
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ItemStack _stk = capability.getStackInSlot(0).copy();
                              if (_stk.hurt(1, RandomSource.create(), (ServerPlayer)null)) {
                                 _stk.shrink(1);
                                 _stk.setDamageValue(0);
                              }

                              ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                           }

                        });
                     }

                     if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_PRESS.get()) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D));
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D), false);
                           }
                        }
                     } else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_SHEAR.get()) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D));
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D), false);
                           }
                        }
                     } else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_BORE.get()) {
                        if (world instanceof Level) {
                           _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D));
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D), false);
                           }
                        }
                     } else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Recipe.get("process").getAsString().toLowerCase(Locale.ENGLISH))) == CrustyChunksModItems.MECHANICAL_EXTRUDER.get() && world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use")), SoundSource.NEUTRAL, 2.0F, (float)(0.1D + runs / 10.0D), false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 0.9D, z + 0.5D, 5, 0.1D, 0.1D, 0.1D, 0.5D);
                     }
                  }

                  Success = true;
               }
            }

            ++specificindex;
         }

         if (!Success && !world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            _ent = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_ent != null) {
               _ent.getPersistentData().putDouble("work", 0.0D);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      }

   }
}
