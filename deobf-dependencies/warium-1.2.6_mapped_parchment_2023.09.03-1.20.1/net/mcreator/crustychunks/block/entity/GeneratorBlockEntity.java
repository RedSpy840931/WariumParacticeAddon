package net.mcreator.crustychunks.block.entity;

import java.util.Iterator;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.init.CrustyChunksModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class GeneratorBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
   private NonNullList<ItemStack> stacks;
   private final LazyOptional<? extends IItemHandler>[] handlers;
   private final EnergyStorage energyStorage;

   public GeneratorBlockEntity(BlockPos position, BlockState state) {
      super((BlockEntityType)CrustyChunksModBlockEntities.GENERATOR.get(), position, state);
      this.stacks = NonNullList.withSize(0, ItemStack.EMPTY);
      this.handlers = SidedInvWrapper.create(this, Direction.values());
      this.energyStorage = new EnergyStorage(1000, 1000, 1000, 0) {
         public int receiveEnergy(int maxReceive, boolean simulate) {
            int retval = super.receiveEnergy(maxReceive, simulate);
            if (!simulate) {
               GeneratorBlockEntity.this.setChanged();
               GeneratorBlockEntity.this.level.sendBlockUpdated(GeneratorBlockEntity.this.worldPosition, GeneratorBlockEntity.this.level.getBlockState(GeneratorBlockEntity.this.worldPosition), GeneratorBlockEntity.this.level.getBlockState(GeneratorBlockEntity.this.worldPosition), 2);
            }

            return retval;
         }

         public int extractEnergy(int maxExtract, boolean simulate) {
            int retval = super.extractEnergy(maxExtract, simulate);
            if (!simulate) {
               GeneratorBlockEntity.this.setChanged();
               GeneratorBlockEntity.this.level.sendBlockUpdated(GeneratorBlockEntity.this.worldPosition, GeneratorBlockEntity.this.level.getBlockState(GeneratorBlockEntity.this.worldPosition), GeneratorBlockEntity.this.level.getBlockState(GeneratorBlockEntity.this.worldPosition), 2);
            }

            return retval;
         }
      };
   }

   public void load(CompoundTag compound) {
      super.load(compound);
      if (!this.tryLoadLootTable(compound)) {
         this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
      }

      ContainerHelper.loadAllItems(compound, this.stacks);
      Tag var3 = compound.get("energyStorage");
      if (var3 instanceof IntTag) {
         IntTag intTag = (IntTag)var3;
         this.energyStorage.deserializeNBT(intTag);
      }

   }

   public void saveAdditional(CompoundTag compound) {
      super.saveAdditional(compound);
      if (!this.trySaveLootTable(compound)) {
         ContainerHelper.saveAllItems(compound, this.stacks);
      }

      compound.put("energyStorage", this.energyStorage.serializeNBT());
   }

   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.create(this);
   }

   public CompoundTag getUpdateTag() {
      return this.saveWithFullMetadata();
   }

   public int getContainerSize() {
      return this.stacks.size();
   }

   public boolean isEmpty() {
      Iterator var1 = this.stacks.iterator();

      ItemStack itemstack;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         itemstack = (ItemStack)var1.next();
      } while(itemstack.isEmpty());

      return false;
   }

   public Component getDefaultName() {
      return Component.literal("generator");
   }

   public int getMaxStackSize() {
      return 64;
   }

   public AbstractContainerMenu createMenu(int id, Inventory inventory) {
      return ChestMenu.threeRows(id, inventory);
   }

   public Component getDisplayName() {
      return Component.literal("Rotation Generator");
   }

   protected NonNullList<ItemStack> getItems() {
      return this.stacks;
   }

   protected void setItems(NonNullList<ItemStack> stacks) {
      this.stacks = stacks;
   }

   public boolean canPlaceItem(int index, ItemStack stack) {
      return true;
   }

   public int[] getSlotsForFace(Direction side) {
      return IntStream.range(0, this.getContainerSize()).toArray();
   }

   public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
      return this.canPlaceItem(index, stack);
   }

   public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
      return true;
   }

   public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
      if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
         return this.handlers[facing.ordinal()].cast();
      } else {
         return !this.remove && capability == ForgeCapabilities.ENERGY ? LazyOptional.of(() -> {
            return this.energyStorage;
         }).cast() : super.getCapability(capability, facing);
      }
   }

   public void setRemoved() {
      super.setRemoved();
      LazyOptional[] var1 = this.handlers;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         LazyOptional<? extends IItemHandler> handler = var1[var3];
         handler.invalidate();
      }

   }
}
