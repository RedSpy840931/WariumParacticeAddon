package net.mcreator.crustychunks.fluid;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModFluidTypes;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid.Properties;

public abstract class SulfuricAcidFluid extends ForgeFlowingFluid {
   public static final Properties PROPERTIES = (new Properties(() -> {
      return (FluidType)CrustyChunksModFluidTypes.SULFURIC_ACID_TYPE.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.SULFURIC_ACID.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.FLOWING_SULFURIC_ACID.get();
   })).explosionResistance(100.0F).bucket(() -> {
      return (Item)CrustyChunksModItems.SULFURIC_ACID_BUCKET.get();
   }).block(() -> {
      return (LiquidBlock)CrustyChunksModBlocks.SULFURIC_ACID.get();
   });

   private SulfuricAcidFluid() {
      super(PROPERTIES);
   }

   public static class Flowing extends SulfuricAcidFluid {
      protected void createFluidStateDefinition(Builder<Fluid, FluidState> builder) {
         super.createFluidStateDefinition(builder);
         builder.add(new Property[]{LEVEL});
      }

      public int getAmount(FluidState state) {
         return (Integer)state.getValue(LEVEL);
      }

      public boolean isSource(FluidState state) {
         return false;
      }
   }

   public static class Source extends SulfuricAcidFluid {
      public int getAmount(FluidState state) {
         return 8;
      }

      public boolean isSource(FluidState state) {
         return true;
      }
   }
}
