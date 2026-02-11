package net.mcreator.crustychunks.block.entity;

import java.util.Iterator;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.init.CrustyChunksModBlockEntities;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class FuelTankModuleBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
   private NonNullList<ItemStack> stacks;
   private final LazyOptional<? extends IItemHandler>[] handlers;
   private final FluidTank fluidTank;

   public FuelTankModuleBlockEntity(BlockPos position, BlockState state) {
      super((BlockEntityType)CrustyChunksModBlockEntities.FUEL_TANK_MODULE.get(), position, state);
      this.stacks = NonNullList.withSize(0, ItemStack.EMPTY);
      this.handlers = SidedInvWrapper.create(this, Direction.values());
      this.fluidTank = new FluidTank(1000, (fs) -> {
         if (fs.getFluid() == CrustyChunksModFluids.OIL.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.FLOWING_OIL.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.DIESEL.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.FLOWING_DIESEL.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.KEROSENE.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.FLOWING_KEROSENE.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.PETROLIUM.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.FLOWING_PETROLIUM.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.LIQUID_HYDROGEN.get()) {
            return true;
         } else if (fs.getFluid() == CrustyChunksModFluids.HYDRAZINE.get()) {
            return true;
         } else {
            return fs.getFluid() == CrustyChunksModFluids.LIQUID_OXYGEN.get();
         }
      }) {
         protected void onContentsChanged() {
            super.onContentsChanged();
            FuelTankModuleBlockEntity.this.setChanged();
            FuelTankModuleBlockEntity.this.level.sendBlockUpdated(FuelTankModuleBlockEntity.this.worldPosition, FuelTankModuleBlockEntity.this.level.getBlockState(FuelTankModuleBlockEntity.this.worldPosition), FuelTankModuleBlockEntity.this.level.getBlockState(FuelTankModuleBlockEntity.this.worldPosition), 2);
         }
      };
   }

   public void load(CompoundTag compound) {
      super.load(compound);
      if (!this.tryLoadLootTable(compound)) {
         this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
      }

      ContainerHelper.loadAllItems(compound, this.stacks);
      Tag var3 = compound.get("fluidTank");
      if (var3 instanceof CompoundTag) {
         CompoundTag compoundTag = (CompoundTag)var3;
         this.fluidTank.readFromNBT(compoundTag);
      }

   }

   public void saveAdditional(CompoundTag compound) {
      super.saveAdditional(compound);
      if (!this.trySaveLootTable(compound)) {
         ContainerHelper.saveAllItems(compound, this.stacks);
      }

      compound.put("fluidTank", this.fluidTank.writeToNBT(new CompoundTag()));
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
      return Component.literal("fuel_tank_module");
   }

   public int getMaxStackSize() {
      return 64;
   }

   public AbstractContainerMenu createMenu(int id, Inventory inventory) {
      return ChestMenu.threeRows(id, inventory);
   }

   public Component getDisplayName() {
      return Component.literal("Fuel Tank Module");
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
         return !this.remove && capability == ForgeCapabilities.FLUID_HANDLER ? LazyOptional.of(() -> {
            return this.fluidTank;
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
