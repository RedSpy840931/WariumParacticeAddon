package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.fluid.ChlorineGasFluid;
import net.mcreator.crustychunks.fluid.CompressedAirFluid;
import net.mcreator.crustychunks.fluid.CrudeOilFluid;
import net.mcreator.crustychunks.fluid.DieselFluid;
import net.mcreator.crustychunks.fluid.HydrazineFluid;
import net.mcreator.crustychunks.fluid.KeroseneFluid;
import net.mcreator.crustychunks.fluid.LiquidHydrogenFluid;
import net.mcreator.crustychunks.fluid.LiquidOxygenFluid;
import net.mcreator.crustychunks.fluid.OilFluid;
import net.mcreator.crustychunks.fluid.PetroliumFluid;
import net.mcreator.crustychunks.fluid.SulfuricAcidFluid;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CrustyChunksModFluids {
   public static final DeferredRegister<Fluid> REGISTRY;
   public static final RegistryObject<FlowingFluid> CRUDE_OIL;
   public static final RegistryObject<FlowingFluid> FLOWING_CRUDE_OIL;
   public static final RegistryObject<FlowingFluid> OIL;
   public static final RegistryObject<FlowingFluid> FLOWING_OIL;
   public static final RegistryObject<FlowingFluid> DIESEL;
   public static final RegistryObject<FlowingFluid> FLOWING_DIESEL;
   public static final RegistryObject<FlowingFluid> KEROSENE;
   public static final RegistryObject<FlowingFluid> FLOWING_KEROSENE;
   public static final RegistryObject<FlowingFluid> PETROLIUM;
   public static final RegistryObject<FlowingFluid> FLOWING_PETROLIUM;
   public static final RegistryObject<FlowingFluid> SULFURIC_ACID;
   public static final RegistryObject<FlowingFluid> FLOWING_SULFURIC_ACID;
   public static final RegistryObject<FlowingFluid> COMPRESSED_AIR;
   public static final RegistryObject<FlowingFluid> FLOWING_COMPRESSED_AIR;
   public static final RegistryObject<FlowingFluid> LIQUID_OXYGEN;
   public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_OXYGEN;
   public static final RegistryObject<FlowingFluid> LIQUID_HYDROGEN;
   public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_HYDROGEN;
   public static final RegistryObject<FlowingFluid> CHLORINE_GAS;
   public static final RegistryObject<FlowingFluid> FLOWING_CHLORINE_GAS;
   public static final RegistryObject<FlowingFluid> HYDRAZINE;
   public static final RegistryObject<FlowingFluid> FLOWING_HYDRAZINE;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, "crusty_chunks");
      CRUDE_OIL = REGISTRY.register("crude_oil", () -> {
         return new CrudeOilFluid.Source();
      });
      FLOWING_CRUDE_OIL = REGISTRY.register("flowing_crude_oil", () -> {
         return new CrudeOilFluid.Flowing();
      });
      OIL = REGISTRY.register("oil", () -> {
         return new OilFluid.Source();
      });
      FLOWING_OIL = REGISTRY.register("flowing_oil", () -> {
         return new OilFluid.Flowing();
      });
      DIESEL = REGISTRY.register("diesel", () -> {
         return new DieselFluid.Source();
      });
      FLOWING_DIESEL = REGISTRY.register("flowing_diesel", () -> {
         return new DieselFluid.Flowing();
      });
      KEROSENE = REGISTRY.register("kerosene", () -> {
         return new KeroseneFluid.Source();
      });
      FLOWING_KEROSENE = REGISTRY.register("flowing_kerosene", () -> {
         return new KeroseneFluid.Flowing();
      });
      PETROLIUM = REGISTRY.register("petrolium", () -> {
         return new PetroliumFluid.Source();
      });
      FLOWING_PETROLIUM = REGISTRY.register("flowing_petrolium", () -> {
         return new PetroliumFluid.Flowing();
      });
      SULFURIC_ACID = REGISTRY.register("sulfuric_acid", () -> {
         return new SulfuricAcidFluid.Source();
      });
      FLOWING_SULFURIC_ACID = REGISTRY.register("flowing_sulfuric_acid", () -> {
         return new SulfuricAcidFluid.Flowing();
      });
      COMPRESSED_AIR = REGISTRY.register("compressed_air", () -> {
         return new CompressedAirFluid.Source();
      });
      FLOWING_COMPRESSED_AIR = REGISTRY.register("flowing_compressed_air", () -> {
         return new CompressedAirFluid.Flowing();
      });
      LIQUID_OXYGEN = REGISTRY.register("liquid_oxygen", () -> {
         return new LiquidOxygenFluid.Source();
      });
      FLOWING_LIQUID_OXYGEN = REGISTRY.register("flowing_liquid_oxygen", () -> {
         return new LiquidOxygenFluid.Flowing();
      });
      LIQUID_HYDROGEN = REGISTRY.register("liquid_hydrogen", () -> {
         return new LiquidHydrogenFluid.Source();
      });
      FLOWING_LIQUID_HYDROGEN = REGISTRY.register("flowing_liquid_hydrogen", () -> {
         return new LiquidHydrogenFluid.Flowing();
      });
      CHLORINE_GAS = REGISTRY.register("chlorine_gas", () -> {
         return new ChlorineGasFluid.Source();
      });
      FLOWING_CHLORINE_GAS = REGISTRY.register("flowing_chlorine_gas", () -> {
         return new ChlorineGasFluid.Flowing();
      });
      HYDRAZINE = REGISTRY.register("hydrazine", () -> {
         return new HydrazineFluid.Source();
      });
      FLOWING_HYDRAZINE = REGISTRY.register("flowing_hydrazine", () -> {
         return new HydrazineFluid.Flowing();
      });
   }

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class FluidsClientSideHandler {
      @SubscribeEvent
      public static void clientSetup(FMLClientSetupEvent event) {
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.CRUDE_OIL.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_CRUDE_OIL.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.OIL.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_OIL.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.DIESEL.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_DIESEL.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.KEROSENE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_KEROSENE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.PETROLIUM.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_PETROLIUM.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.SULFURIC_ACID.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_SULFURIC_ACID.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.COMPRESSED_AIR.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_COMPRESSED_AIR.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.LIQUID_OXYGEN.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_LIQUID_OXYGEN.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.LIQUID_HYDROGEN.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_LIQUID_HYDROGEN.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.CHLORINE_GAS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_CHLORINE_GAS.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.HYDRAZINE.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)CrustyChunksModFluids.FLOWING_HYDRAZINE.get(), RenderType.translucent());
      }
   }
}
