package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.fluid.types.ChlorineGasFluidType;
import net.mcreator.crustychunks.fluid.types.CompressedAirFluidType;
import net.mcreator.crustychunks.fluid.types.CrudeOilFluidType;
import net.mcreator.crustychunks.fluid.types.DieselFluidType;
import net.mcreator.crustychunks.fluid.types.HydrazineFluidType;
import net.mcreator.crustychunks.fluid.types.KeroseneFluidType;
import net.mcreator.crustychunks.fluid.types.LiquidHydrogenFluidType;
import net.mcreator.crustychunks.fluid.types.LiquidOxygenFluidType;
import net.mcreator.crustychunks.fluid.types.OilFluidType;
import net.mcreator.crustychunks.fluid.types.PetroliumFluidType;
import net.mcreator.crustychunks.fluid.types.SulfuricAcidFluidType;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;

public class CrustyChunksModFluidTypes {
   public static final DeferredRegister<FluidType> REGISTRY;
   public static final RegistryObject<FluidType> CRUDE_OIL_TYPE;
   public static final RegistryObject<FluidType> OIL_TYPE;
   public static final RegistryObject<FluidType> DIESEL_TYPE;
   public static final RegistryObject<FluidType> KEROSENE_TYPE;
   public static final RegistryObject<FluidType> PETROLIUM_TYPE;
   public static final RegistryObject<FluidType> SULFURIC_ACID_TYPE;
   public static final RegistryObject<FluidType> COMPRESSED_AIR_TYPE;
   public static final RegistryObject<FluidType> LIQUID_OXYGEN_TYPE;
   public static final RegistryObject<FluidType> LIQUID_HYDROGEN_TYPE;
   public static final RegistryObject<FluidType> CHLORINE_GAS_TYPE;
   public static final RegistryObject<FluidType> HYDRAZINE_TYPE;

   static {
      REGISTRY = DeferredRegister.create(Keys.FLUID_TYPES, "crusty_chunks");
      CRUDE_OIL_TYPE = REGISTRY.register("crude_oil", () -> {
         return new CrudeOilFluidType();
      });
      OIL_TYPE = REGISTRY.register("oil", () -> {
         return new OilFluidType();
      });
      DIESEL_TYPE = REGISTRY.register("diesel", () -> {
         return new DieselFluidType();
      });
      KEROSENE_TYPE = REGISTRY.register("kerosene", () -> {
         return new KeroseneFluidType();
      });
      PETROLIUM_TYPE = REGISTRY.register("petrolium", () -> {
         return new PetroliumFluidType();
      });
      SULFURIC_ACID_TYPE = REGISTRY.register("sulfuric_acid", () -> {
         return new SulfuricAcidFluidType();
      });
      COMPRESSED_AIR_TYPE = REGISTRY.register("compressed_air", () -> {
         return new CompressedAirFluidType();
      });
      LIQUID_OXYGEN_TYPE = REGISTRY.register("liquid_oxygen", () -> {
         return new LiquidOxygenFluidType();
      });
      LIQUID_HYDROGEN_TYPE = REGISTRY.register("liquid_hydrogen", () -> {
         return new LiquidHydrogenFluidType();
      });
      CHLORINE_GAS_TYPE = REGISTRY.register("chlorine_gas", () -> {
         return new ChlorineGasFluidType();
      });
      HYDRAZINE_TYPE = REGISTRY.register("hydrazine", () -> {
         return new HydrazineFluidType();
      });
   }
}
