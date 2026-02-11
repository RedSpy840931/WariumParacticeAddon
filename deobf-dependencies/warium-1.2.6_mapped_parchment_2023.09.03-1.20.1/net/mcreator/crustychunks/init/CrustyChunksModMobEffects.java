package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.potion.ContaminatedMobEffect;
import net.mcreator.crustychunks.potion.FlammableMobEffect;
import net.mcreator.crustychunks.potion.ImpendingDoomMobEffect;
import net.mcreator.crustychunks.potion.RadiationMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CrustyChunksModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY;
   public static final RegistryObject<MobEffect> FLAMMABLE;
   public static final RegistryObject<MobEffect> RADIATION;
   public static final RegistryObject<MobEffect> IMPENDING_DOOM;
   public static final RegistryObject<MobEffect> CONTAMINATED;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "crusty_chunks");
      FLAMMABLE = REGISTRY.register("flammable", () -> {
         return new FlammableMobEffect();
      });
      RADIATION = REGISTRY.register("radiation", () -> {
         return new RadiationMobEffect();
      });
      IMPENDING_DOOM = REGISTRY.register("impending_doom", () -> {
         return new ImpendingDoomMobEffect();
      });
      CONTAMINATED = REGISTRY.register("contaminated", () -> {
         return new ContaminatedMobEffect();
      });
   }
}
