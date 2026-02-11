package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class ThermalFurnaceUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double previousRecipe = 0.0D;
      BlockEntity _ent;
      if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == CrustyChunksModBlocks.BLAST_FUNNEL.get() && world.getBlockState(BlockPos.containing(x, y + 2.0D, z)).getBlock() == CrustyChunksModBlocks.BLAST_FUNNEL.get() && world.getBlockState(BlockPos.containing(x, y + 3.0D, z)).getBlock() == CrustyChunksModBlocks.BLAST_FUNNEL.get() && ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Heat") >= 200.0D && ((<undefinedtype>)(new Object() {
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
      })).getAmount(world, BlockPos.containing(x, y, z), 1) < 64 && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() != ItemStack.EMPTY.getItem()) {
         label91: {
            label81: {
               if (((<undefinedtype>)(new Object() {
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
               })).getAmount(world, BlockPos.containing(x, y, z), 1) < ((<undefinedtype>)(new Object() {
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
               })).getItemStack(world, BlockPos.containing(x, y, z), 1).getMaxStackSize()) {
                  Item var10000 = ((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem();
                  ItemStack var10001;
                  if (world instanceof Level) {
                     Level _lvlSmeltResult = (Level)world;
                     var10001 = (ItemStack)_lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack[]{((<undefinedtype>)(new Object() {
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
                     })).getItemStack(world, BlockPos.containing(x, y, z), 0)}), _lvlSmeltResult).map((recipe) -> {
                        return recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy();
                     }).orElse(ItemStack.EMPTY);
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (var10000 == var10001.getItem()) {
                     break label81;
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
               })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() != ItemStack.EMPTY.getItem()) {
                  break label91;
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            boolean _slotid;
            Level _level;
            if (_ent != null) {
               _slotid = true;
               ItemStack var23;
               if (world instanceof Level) {
                  _level = (Level)world;
                  var23 = (ItemStack)_level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack[]{((<undefinedtype>)(new Object() {
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
                  })).getItemStack(world, BlockPos.containing(x, y, z), 0)}), _level).map((recipe) -> {
                     return recipe.getResultItem(_level.registryAccess()).copy();
                  }).orElse(ItemStack.EMPTY);
               } else {
                  var23 = ItemStack.EMPTY;
               }

               ItemStack _setstack = var23.copy();
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
               })).getAmount(world, BlockPos.containing(x, y, z), 1) + 1);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(1, _setstack);
                  }

               });
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 5.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 5.0F, 1.0F, false);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
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

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + 0.5D, y + 6.0D, z + 0.5D, 5, 0.0D, 3.0D, 0.0D, 0.01D);
            }

            if (!world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 40.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }
      }

      BlockPos _bp;
      BlockState _bs;
      Level _level;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Heat") >= 5.0D && !world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _ent = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_ent != null) {
            _ent.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
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
         _ent = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_ent != null) {
            _ent.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
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
