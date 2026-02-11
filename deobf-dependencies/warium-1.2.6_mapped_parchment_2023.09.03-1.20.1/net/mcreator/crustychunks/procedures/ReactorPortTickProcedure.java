package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class ReactorPortTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y - 1.0D, z), "Greenlight") && 0 == ((<undefinedtype>)(new Object() {
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
      })).getAmount(world, BlockPos.containing(x, y - 1.0D, z), 0) && ((<undefinedtype>)(new Object() {
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
      })).getItemStack(world, BlockPos.containing(x, y - 1.0D, z), 0).getItem() == ItemStack.EMPTY.getItem()) {
         BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1.0D, z));
         boolean _slotid;
         if (_ent != null) {
            _slotid = false;
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
            _setstack.setCount(1);
            _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
               if (capability instanceof IItemHandlerModifiable) {
                  ((IItemHandlerModifiable)capability).setStackInSlot(0, _setstack);
               }

            });
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
      }

   }
}
