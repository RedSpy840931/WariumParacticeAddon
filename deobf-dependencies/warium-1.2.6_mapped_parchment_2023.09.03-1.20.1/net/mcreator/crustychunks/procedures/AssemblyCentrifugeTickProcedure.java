package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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

public class AssemblyCentrifugeTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      boolean sufficientheat = false;
      ItemStack result = ItemStack.EMPTY;
      ItemStack input = ItemStack.EMPTY;
      ItemStack Result4 = ItemStack.EMPTY;
      ItemStack Result3 = ItemStack.EMPTY;
      ItemStack Result2 = ItemStack.EMPTY;
      ItemStack Result1 = ItemStack.EMPTY;
      ItemStack catalyst = ItemStack.EMPTY;
      BlockState bottomblock = Blocks.AIR.defaultBlockState();
      double XTrigger = 0.0D;
      double ZTrigger = 0.0D;
      double Chance4 = 0.0D;
      double OffsetX = 0.0D;
      double OffsetZ = 0.0D;
      double Chance3 = 0.0D;
      double Chance2 = 0.0D;
      double Chance1 = 0.0D;
      double kineticpower = 0.0D;
      double Power = 0.0D;
      double passes = 0.0D;
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y - 1.0D, z))).getStepX(), y - 1.0D, z - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y - 1.0D, z))).getStepZ()), "KineticPower") && ((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y - 1.0D, z))).getStepX(), y - 1.0D, z - (double)((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y - 1.0D, z))).getStepZ()))) == ((<undefinedtype>)(new Object() {
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
      })).getDirection(world.getBlockState(BlockPos.containing(x, y - 1.0D, z)))) {
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
         })).getDirection(world.getBlockState(BlockPos.containing(x, y - 1.0D, z))).getStepX(), y - 1.0D, z - (double)((<undefinedtype>)(new Object() {
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
         })).getDirection(world.getBlockState(BlockPos.containing(x, y - 1.0D, z))).getStepZ()), "KineticPower");
      } else {
         Power = 0.0D;
      }

      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      if (world.getBlockState(BlockPos.containing(x - OffsetX, y, z - OffsetZ)).getBlock() == CrustyChunksModBlocks.PRODUCTION_INPUT.get() && world.getBlockState(BlockPos.containing(x + OffsetX, y, z + OffsetZ)).getBlock() == CrustyChunksModBlocks.PRODUCTION_OUTPUT.get() && 30.0D < Power && world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.ASSEMBLY_CENTRIFUGE_BOTTOM.get() && world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == CrustyChunksModBlocks.ASSEMBLY_CENTRIFUGE_TOP.get() && world.getBlockState(BlockPos.containing(x, y - 2.0D, z)).getBlock() == CrustyChunksModBlocks.GIANT_COIL.get()) {
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
         if (input.getItem() == CrustyChunksModItems.URANIUM_NEUTRAL_DUST.get()) {
            Result1 = (new ItemStack((ItemLike)CrustyChunksModItems.URANIUM_ENRICHED_TINY_DUST.get())).copy();
            Chance1 = 1.0D;
            Result2 = (new ItemStack((ItemLike)CrustyChunksModItems.URANIUM_DEPLETED_DUST.get())).copy();
            Chance2 = 0.8D;
            Result3 = (new ItemStack((ItemLike)CrustyChunksModItems.LEAD_DUST.get())).copy();
            Chance3 = 0.05D;
            passes = (double)world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME);
         } else if (input.getItem() == CrustyChunksModItems.LITHIUM_DUST.get()) {
            Result1 = (new ItemStack((ItemLike)CrustyChunksModItems.ENRICHED_LITHIUM_NUGGET.get())).copy();
            Chance1 = 1.0D;
            passes = (double)world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME);
         } else if (input.getItem() == CrustyChunksModItems.ALUMINATE_DUST.get()) {
            Result1 = (new ItemStack((ItemLike)CrustyChunksModItems.FILTERED_ALUMINATE_DUST.get())).copy();
            Chance1 = 1.0D;
            Result2 = (new ItemStack(Blocks.RED_SAND)).copy();
            Chance2 = 0.25D;
            passes = 4.0D;
         } else if (input.getItem() == CrustyChunksModItems.FILTERED_PYROCHLORE_DUST.get()) {
            Result1 = (new ItemStack((ItemLike)CrustyChunksModItems.NIOBIUM_TINY_DUST.get())).copy();
            Chance1 = 1.0D;
            Result2 = (new ItemStack((ItemLike)CrustyChunksModItems.NIOBIUM_TINY_DUST.get())).copy();
            Chance2 = 0.25D;
            Result3 = (new ItemStack((ItemLike)CrustyChunksModItems.SULFUR.get())).copy();
            Chance3 = 0.1D;
            Result4 = (new ItemStack(Items.QUARTZ)).copy();
            Chance4 = 0.1D;
            passes = 80.0D;
         } else {
            Result1 = input.copy();
            Chance1 = 1.0D;
            passes = 0.0D;
         }

         if (input.getItem() != ItemStack.EMPTY.getItem() && (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 0).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 0).getItem() == Result1.getItem() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 0) < Result1.getMaxStackSize()) && (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 1).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 1).getItem() == Result2.getItem() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 1) < Result2.getMaxStackSize()) && (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 2).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 2).getItem() == Result3.getItem() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 2) < Result3.getMaxStackSize()) && (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 3).getItem() == ItemStack.EMPTY.getItem() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 3).getItem() == Result4.getItem() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 3) < Result4.getMaxStackSize())) {
            Level _level;
            ServerLevel _level;
            if (passes > ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "progress")) {
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("progress", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "progress") + 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "Progress") / passes * 3.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "Progress") / passes * 3.0D), false);
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
                     _blockEntity.getPersistentData().putDouble("progress", 0.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (Result1.getItem() != ItemStack.EMPTY.getItem()) {
                  BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x - OffsetX, y, z - OffsetZ));
                  boolean _slotid;
                  if (_ent != null) {
                     _slotid = false;
                     int _amount = true;
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable) {
                           ItemStack _stk = capability.getStackInSlot(0).copy();
                           _stk.shrink(1);
                           ((IItemHandlerModifiable)capability).setStackInSlot(0, _stk);
                        }

                     });
                  }

                  ItemStack _setstack;
                  if (Mth.nextDouble(RandomSource.create(), 0.0D, 1.0D) < Chance1) {
                     _ent = world.getBlockEntity(BlockPos.containing(x + OffsetX, y, z + OffsetZ));
                     if (_ent != null) {
                        _slotid = false;
                        _setstack = Result1.copy();
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
                        })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 0) + 1);
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                           }

                        });
                     }
                  }

                  if (Result2.getItem() != ItemStack.EMPTY.getItem() && Mth.nextDouble(RandomSource.create(), 0.0D, 1.0D) < Chance2) {
                     _ent = world.getBlockEntity(BlockPos.containing(x + OffsetX, y, z + OffsetZ));
                     if (_ent != null) {
                        _slotid = true;
                        _setstack = Result2.copy();
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
                        })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 1) + 1);
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ((IItemHandlerModifiable)capability).setStackInSlot(1, _setstack);
                           }

                        });
                     }
                  }

                  if (Result3.getItem() != ItemStack.EMPTY.getItem() && Mth.nextDouble(RandomSource.create(), 0.0D, 1.0D) < Chance3) {
                     _ent = world.getBlockEntity(BlockPos.containing(x + OffsetX, y, z + OffsetZ));
                     if (_ent != null) {
                        _slotid = true;
                        _setstack = Result3.copy();
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
                        })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 2) + 1);
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ((IItemHandlerModifiable)capability).setStackInSlot(2, _setstack);
                           }

                        });
                     }
                  }

                  if (Result4.getItem() != ItemStack.EMPTY.getItem() && Mth.nextDouble(RandomSource.create(), 0.0D, 1.0D) < Chance4) {
                     _ent = world.getBlockEntity(BlockPos.containing(x + OffsetX, y, z + OffsetZ));
                     if (_ent != null) {
                        _slotid = true;
                        _setstack = Result4.copy();
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
                        })).getAmount(world, BlockPos.containing(x + OffsetX, y, z + OffsetZ), 3) + 1);
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           if (capability instanceof IItemHandlerModifiable) {
                              ((IItemHandlerModifiable)capability).setStackInSlot(3, _setstack);
                           }

                        });
                     }
                  }

                  if (input.getItem() != Result1.getItem()) {
                     if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.6D, 0.6D, 0.6D, 0.1D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.deactivate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                        }
                     }
                  }
               }
            }
         }
      }

      if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("ProgressFraction", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "progress") / Math.max(1.0D, passes));
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

   }
}
