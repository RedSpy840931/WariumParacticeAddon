package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.registries.ForgeRegistries;

public class MineralGrinderProcessProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      ItemStack Grindresult = ItemStack.EMPTY;
      ItemStack SecondaryGrindresult = ItemStack.EMPTY;
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == Blocks.COBBLESTONE.asItem()) {
         Grindresult = (new ItemStack(Blocks.GRAVEL)).copy();
         SecondaryGrindresult = (new ItemStack(Items.FLINT)).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == Blocks.GRAVEL.asItem()) {
         Grindresult = (new ItemStack(Blocks.SAND)).copy();
         SecondaryGrindresult = (new ItemStack(Items.FLINT)).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == Items.RAW_IRON) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.IRON_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.IRON_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == Items.RAW_GOLD) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.GOLD_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.GOLD_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == Items.RAW_COPPER) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.COPPER_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.COPPER_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:raw_materials/lead")))) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.LEAD_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.LEAD_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:raw_materials/zinc")))) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.ZINC_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.ZINC_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == ((Block)CrustyChunksModBlocks.BAUXITE.get()).asItem()) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.BAUXITE_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack(Blocks.SAND)).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).getItem() == CrustyChunksModItems.PYROCHLORE.get()) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.PYROCHLORE_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.PYROCHLORE_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:raw_materials/nickel")))) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.NICKEL_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.NICKEL_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:raw_materials/beryllium")))) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.BERYLLIUM_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.BERYLLIUM_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:raw_materials/uranium")))) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.URANIUM_NEUTRALTINY_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.URANIUM_DEPLETED_TINY_DUST.get())).copy();
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("forge:raw_materials/lithium")))) {
         Grindresult = (new ItemStack((ItemLike)CrustyChunksModItems.LITHIUM_DUST.get())).copy();
         SecondaryGrindresult = (new ItemStack((ItemLike)CrustyChunksModItems.LITHIUM_DUST.get())).copy();
      }

      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
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
      })).getAmount(world, BlockPos.containing(x, y, z), 1) < 64 && (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.STEEL_CRUSHING_WHEEL.get() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 2).getItem() == CrustyChunksModItems.IRONGEAR.get()) && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 0).is(ItemTags.create(new ResourceLocation("crusty_chunks:grindable"))) && (((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == Grindresult.getItem() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 1).getItem() == ItemStack.EMPTY.getItem()) && (((<undefinedtype>)(new Object() {
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
      })).getAmount(world, BlockPos.containing(x, y, z), 3) <= 63 && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 3).getItem() == SecondaryGrindresult.getItem() || ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y, z), 3).getItem() == ItemStack.EMPTY.getItem())) {
         BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
         boolean _slotid;
         boolean _amount;
         if (_ent != null) {
            _slotid = true;
            _amount = true;
            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ItemStack _stk = capability.getStackInSlot(2).copy();
                  if (_stk.hurt(1, RandomSource.create(), (ServerPlayer)null)) {
                     _stk.shrink(1);
                     _stk.setDamageValue(0);
                  }

                  ((IItemHandlerModifiable)capability).setStackInSlot(2, _stk);
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

         _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
         ItemStack _setstack;
         if (_ent != null) {
            _slotid = true;
            _setstack = Grindresult.copy();
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

         if (Mth.nextDouble(RandomSource.create(), 0.0D, 1.0D) < 0.25D) {
            _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
            if (_ent != null) {
               _slotid = true;
               _setstack = SecondaryGrindresult.copy();
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
               })).getAmount(world, BlockPos.containing(x, y, z), 3) + 1);
               _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  if (capability instanceof IItemHandlerModifiable) {
                     ((IItemHandlerModifiable)capability).setStackInSlot(3, _setstack);
                  }

               });
            }
         }

         ItemStack _ist = ((<undefinedtype>)(new Object() {
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
         })).getItemStack(world, BlockPos.containing(x, y, z), 2);
         if (_ist.hurt(1, RandomSource.create(), (ServerPlayer)null)) {
            _ist.shrink(1);
            _ist.setDamageValue(0);
         }

         world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.COBBLESTONE.defaultBlockState()));
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")), SoundSource.BLOCKS, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.stonecutter.take_result")), SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putBoolean("Work", true);
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
            _blockEntity.getPersistentData().putBoolean("Work", false);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

   }
}
