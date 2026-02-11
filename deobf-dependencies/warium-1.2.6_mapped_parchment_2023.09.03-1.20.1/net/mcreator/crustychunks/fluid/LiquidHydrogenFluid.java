package net.mcreator.crustychunks.fluid;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModFluidTypes;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid.Properties;

public abstract class LiquidHydrogenFluid extends ForgeFlowingFluid {
   public static final Properties PROPERTIES = (new Properties(() -> {
      return (FluidType)CrustyChunksModFluidTypes.LIQUID_HYDROGEN_TYPE.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.LIQUID_HYDROGEN.get();
   }, () -> {
      return (Fluid)CrustyChunksModFluids.FLOWING_LIQUID_HYDROGEN.get();
   })).explosionResistance(100.0F).block(() -> {
      return (LiquidBlock)CrustyChunksModBlocks.LIQUID_HYDROGEN.get();
   });

   private LiquidHydrogenFluid() {
      super(PROPERTIES);
   }

   public static class Flowing extends LiquidHydrogenFluid {
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

   public static class Source extends LiquidHydrogenFluid {
      public int getAmount(FluidState state) {
         return 8;
      }

      public boolean isSource(FluidState state) {
         return true;
      }
   }
}
