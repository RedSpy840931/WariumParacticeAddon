package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
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

public class FoundryUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.COMPONENT_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "Component");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.CYLINDER_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "Cylinder");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.SMALL_PROJECTILE_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "PR1");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.MEDIUM_PROJECTILE_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "PR2");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.LARGE_PROJECTILE_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "PR3");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.EXTRA_LARGE_PROJECTILE_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "PR4");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.HUGE_PROJECTILE_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "PR5");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.SMALL_BARREL_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR1");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.MEDIUM_BARREL_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR2");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.LARGE_BARREL_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR3");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.HUGE_BARREL_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR4");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.SMALL_CANNON_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR5");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.MEDIUM_CANNON_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR6");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.LARGE_CANNON_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR7");
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.HUGE_CANNON_FOUNDRY_TEMPLATE.get()) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putString("Produce", "BR8");
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
            _blockEntity.getPersistentData().putString("Produce", "None");
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
      })).getValue(world, BlockPos.containing(x, y, z), "Heat") >= 200.0D) {
         BlockEntity _ent;
         boolean _slotid;
         Level _level;
         boolean _amount;
         ItemStack _setstack;
         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("Cylinder") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 15 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.STEEL_CYLINDER.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 10.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.STEEL_CYLINDER.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("Component")) {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && (((<undefinedtype>)(new Object() {
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
            })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 15 && ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.CAST_COMPONENT.get() || ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
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
                     })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 10.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
               if (_ent != null) {
                  _slotid = true;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.CAST_COMPONENT.get())).copy();
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
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
                  }
               }
            } else if (((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == CrustyChunksModItems.PLUTONIUM_INGOT.get() && ((<undefinedtype>)(new Object() {
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
            })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 4 && ((<undefinedtype>)(new Object() {
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
            })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem()) {
               _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
               if (_ent != null) {
                  _slotid = false;
                  _amount = true;
                  _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     if (capability instanceof IItemHandlerModifiable) {
                        ItemStack _stk = capability.getStackInSlot(0).copy();
                        _stk.shrink(4);
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
                     })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 200.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
               if (_ent != null) {
                  _slotid = true;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.PLUTONIUM_CORE.get())).copy();
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
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.BLOCKS, 20.0F, 0.3F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.BLOCKS, 20.0F, 0.3F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.AERIAL_SPARKS.get(), x + 0.5D, y + 0.5D, z + 0.5D, 25, 1.0D, 1.0D, 1.0D, 0.3D);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("PR1") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:nuggets/lead"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 2 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 63 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.SMALL_PROJECTILE.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(2);
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

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMALL_PROJECTILE.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("PR2") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:nuggets/lead"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 4 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 63 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.MEDIUM_PROJECTILE.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(4);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 15.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_PROJECTILE.get())).copy();
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
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("PR3") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:nuggets/lead"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 6 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 63 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.LARGE_PROJECTILE.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(6);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 15.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.LARGE_PROJECTILE.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("PR4") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/lead"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 2 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 63 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.EXTRA_LARGE_PROJECTILE.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(2);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 20.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.EXTRA_LARGE_PROJECTILE.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("PR5") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/lead"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 3 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 63 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.HUGE_PROJECTILE.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(3);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 25.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.HUGE_PROJECTILE.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR1") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 1 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 15 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.SMALL_UNBORED_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
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

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMALL_UNBORED_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR2") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 3 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 15 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.MEDIUM_UNBORED_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(3);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 10.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_UNBORED_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR3") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 4 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 7 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.LARGE_UNBORED_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(4);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 15.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.LARGE_UNBORED_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR4") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 6 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 7 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.HUGE_UNBORED_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(6);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 20.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.HUGE_UNBORED_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR5") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 6 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 0 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.SMALL_UNBORED_CANNON_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(6);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 25.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMALL_UNBORED_CANNON_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR6") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 8 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 0 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.MEDIUM_UNBORED_CANNON_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(8);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 30.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_UNBORED_CANNON_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR7") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 8 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 0 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.LARGE_UNBORED_CANNON_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(8);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 35.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.LARGE_UNBORED_CANNON_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
            }
         }

         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Produce").equals("BR8") && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:ingots/steel"))) && ((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 0) >= 9 && (((<undefinedtype>)(new Object() {
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
         })).getAmount(world, BlockPos.containing(x, y, z), 1) <= 0 && ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == CrustyChunksModItems.HUGE_UNBORED_CANNON_BARREL.get() || ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem())) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = false;
               _amount = true;
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ItemStack _stk = capability.getStackInSlot(0).copy();
                     _stk.shrink(9);
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
                  })).getValue(world, BlockPos.containing(x, y, z), "Heat") - 40.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.HUGE_UNBORED_CANNON_BARREL.get())).copy();
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
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.furnace.fire_crackle")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
               }
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
      })).getValue(world, BlockPos.containing(x, y, z), "Heat") >= 1000.0D && !world.isClientSide()) {
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
