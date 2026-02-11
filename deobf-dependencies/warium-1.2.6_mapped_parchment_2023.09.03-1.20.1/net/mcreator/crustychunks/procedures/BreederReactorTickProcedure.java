package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class BreederReactorTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y - 2.0D, z)).getBlock() == CrustyChunksModBlocks.BREEDER_REACTOR_PORT.get() && world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.BREEDER_REACTOR_CORE.get() && world.getBlockState(BlockPos.containing(x, y - 1.0D, z - 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x, y - 1.0D, z + 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x - 2.0D, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x + 2.0D, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y - 1.0D, z - 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y - 1.0D, z + 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x - 2.0D, y - 1.0D, z), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x + 2.0D, y - 1.0D, z), "Ready") && world.getBlockState(BlockPos.containing(x, y, z - 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x, y, z + 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x - 2.0D, y, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x + 2.0D, y, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y, z - 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y, z + 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x - 2.0D, y, z), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x + 2.0D, y, z), "Ready")) {
         BlockPos _bp;
         BlockEntity _blockEntity;
         BlockState _bs;
         Level _level;
         BlockEntity _ent;
         ServerLevel _level;
         boolean _slotid;
         Level _level;
         ItemStack _setstack;
         boolean _amount;
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == CrustyChunksModItems.URANIUM_ENRICHED_DUST.get() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y - 2.0D, z), 0) < 64 && (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y - 2.0D, z), 0).getItem() == CrustyChunksModItems.PLUTONIUM_NUGGET.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y - 2.0D, z), 0).getItem() == ItemStack.EMPTY.getItem())) {
            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "T") >= (double)(world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME) * 2)) {
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("T", 0.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.getBlockEntity(BlockPos.containing(x, y - 2.0D, z));
               if (_ent != null) {
                  _slotid = false;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.PLUTONIUM_NUGGET.get())).copy();
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
                  })).getAmount(world, BlockPos.containing(x, y - 2.0D, z), 0) + 1);
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                     }

                  });
               }

               _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
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

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SONIC_BOOM, x + 0.5D, y + 0.5D, z + 0.5D, 15, 0.6D, 0.6D, 0.6D, 0.1D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }
            } else {
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("T", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "T") + 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.3D, 0.6D, 0.3D, 0.01D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "T") / (double)(world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME) * 2) * 2.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "T") / (double)(world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME) * 2) * 2.0D), false);
                  }
               }
            }
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == CrustyChunksModItems.ENRICHED_LITHIUM_INGOT.get() && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y - 2.0D, z), 0) < 64 && (((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y - 2.0D, z), 0).getItem() == CrustyChunksModItems.TINY_LITHIUM_DEUTERIDE.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y - 2.0D, z), 0).getItem() == ItemStack.EMPTY.getItem())) {
            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "T") >= (double)(world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME) * 2)) {
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("T", 0.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.getBlockEntity(BlockPos.containing(x, y - 2.0D, z));
               if (_ent != null) {
                  _slotid = false;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.TINY_LITHIUM_DEUTERIDE.get())).copy();
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
                  })).getAmount(world, BlockPos.containing(x, y - 2.0D, z), 0) + 1);
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
                     }

                  });
               }

               _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
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

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SONIC_BOOM, x + 0.5D, y + 0.5D, z + 0.5D, 15, 0.6D, 0.6D, 0.6D, 0.1D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 20.0F, 3.0F, false);
                  }
               }
            } else {
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("T", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "T") + 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.3D, 0.6D, 0.3D, 0.01D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "T") / (double)(world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME) * 2) * 2.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.ambient")), SoundSource.NEUTRAL, 10.0F, (float)(1.0D + ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "T") / (double)(world.getLevelData().getGameRules().getInt(CrustyChunksModGameRules.ENRICHMENT_TIME) * 2) * 2.0D), false);
                  }
               }
            }
         }
      }

   }
}
