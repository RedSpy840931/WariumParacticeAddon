package net.mcreator.crustychunks.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CrustyChunksModParticleTypes {
   public static final DeferredRegister<ParticleType<?>> REGISTRY;
   public static final RegistryObject<SimpleParticleType> LARGE_SMOKE;
   public static final RegistryObject<SimpleParticleType> FIREBALL;
   public static final RegistryObject<SimpleParticleType> SAND;
   public static final RegistryObject<SimpleParticleType> DUST;
   public static final RegistryObject<SimpleParticleType> WHITE_DUST;
   public static final RegistryObject<SimpleParticleType> SMOKE_SCREEN;
   public static final RegistryObject<SimpleParticleType> PUFF;
   public static final RegistryObject<SimpleParticleType> TRACER;
   public static final RegistryObject<SimpleParticleType> CAMP_SMOKE;
   public static final RegistryObject<SimpleParticleType> SMALL_TRACER;
   public static final RegistryObject<SimpleParticleType> SPARKS;
   public static final RegistryObject<SimpleParticleType> SMALL_PUFF;
   public static final RegistryObject<SimpleParticleType> HUGE_SPARKS;
   public static final RegistryObject<SimpleParticleType> SHOCK_WAVE;
   public static final RegistryObject<SimpleParticleType> NUCLEAR_SHOCK_PARTICLE;
   public static final RegistryObject<SimpleParticleType> HUGE_FIREBALL;
   public static final RegistryObject<SimpleParticleType> HUGE_SMOKE;
   public static final RegistryObject<SimpleParticleType> GROUND_HUGE_SMOKE;
   public static final RegistryObject<SimpleParticleType> MEDIUM_TRACER;
   public static final RegistryObject<SimpleParticleType> SPLASH_PUFF;
   public static final RegistryObject<SimpleParticleType> SMOKE;
   public static final RegistryObject<SimpleParticleType> BULLET_TRAIL;
   public static final RegistryObject<SimpleParticleType> LARGE_BULLET_TRAIL;
   public static final RegistryObject<SimpleParticleType> AERIAL_SPARKS;
   public static final RegistryObject<SimpleParticleType> GREEN_TRACER;
   public static final RegistryObject<SimpleParticleType> WHITE_TRACER;
   public static final RegistryObject<SimpleParticleType> SMALL_GREEN_TRACER;
   public static final RegistryObject<SimpleParticleType> RISING_FLAME;
   public static final RegistryObject<SimpleParticleType> GUN_SMOKE;
   public static final RegistryObject<SimpleParticleType> DUST_WAVE;
   public static final RegistryObject<SimpleParticleType> FLARE;
   public static final RegistryObject<SimpleParticleType> JET_FLAME;
   public static final RegistryObject<SimpleParticleType> DEATH_RAY;
   public static final RegistryObject<SimpleParticleType> HUGE_STATIC_FIREBALL;
   public static final RegistryObject<SimpleParticleType> GAS_CLOUD;
   public static final RegistryObject<SimpleParticleType> ROCKET_SMOKE;
   public static final RegistryObject<SimpleParticleType> FUSION_FIREBALL;
   public static final RegistryObject<SimpleParticleType> FUSION_STATIC_FIREBALL;
   public static final RegistryObject<SimpleParticleType> FUSION_SMOKE;
   public static final RegistryObject<SimpleParticleType> SPACE_FIREBALL;
   public static final RegistryObject<SimpleParticleType> FLAME_PARTICLE;
   public static final RegistryObject<SimpleParticleType> ROCKET_FLAME;
   public static final RegistryObject<SimpleParticleType> SMALL_SPLASH_PUFF;
   public static final RegistryObject<SimpleParticleType> RADIOACTIVE_CLOUD;
   public static final RegistryObject<SimpleParticleType> PHOSPHORUS_TRAIL;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "crusty_chunks");
      LARGE_SMOKE = REGISTRY.register("large_smoke", () -> {
         return new SimpleParticleType(true);
      });
      FIREBALL = REGISTRY.register("fireball", () -> {
         return new SimpleParticleType(true);
      });
      SAND = REGISTRY.register("sand", () -> {
         return new SimpleParticleType(false);
      });
      DUST = REGISTRY.register("dust", () -> {
         return new SimpleParticleType(false);
      });
      WHITE_DUST = REGISTRY.register("white_dust", () -> {
         return new SimpleParticleType(false);
      });
      SMOKE_SCREEN = REGISTRY.register("smoke_screen", () -> {
         return new SimpleParticleType(true);
      });
      PUFF = REGISTRY.register("puff", () -> {
         return new SimpleParticleType(true);
      });
      TRACER = REGISTRY.register("tracer", () -> {
         return new SimpleParticleType(true);
      });
      CAMP_SMOKE = REGISTRY.register("camp_smoke", () -> {
         return new SimpleParticleType(true);
      });
      SMALL_TRACER = REGISTRY.register("small_tracer", () -> {
         return new SimpleParticleType(true);
      });
      SPARKS = REGISTRY.register("sparks", () -> {
         return new SimpleParticleType(false);
      });
      SMALL_PUFF = REGISTRY.register("small_puff", () -> {
         return new SimpleParticleType(true);
      });
      HUGE_SPARKS = REGISTRY.register("huge_sparks", () -> {
         return new SimpleParticleType(false);
      });
      SHOCK_WAVE = REGISTRY.register("shock_wave", () -> {
         return new SimpleParticleType(true);
      });
      NUCLEAR_SHOCK_PARTICLE = REGISTRY.register("nuclear_shock_particle", () -> {
         return new SimpleParticleType(true);
      });
      HUGE_FIREBALL = REGISTRY.register("huge_fireball", () -> {
         return new SimpleParticleType(true);
      });
      HUGE_SMOKE = REGISTRY.register("huge_smoke", () -> {
         return new SimpleParticleType(true);
      });
      GROUND_HUGE_SMOKE = REGISTRY.register("ground_huge_smoke", () -> {
         return new SimpleParticleType(true);
      });
      MEDIUM_TRACER = REGISTRY.register("medium_tracer", () -> {
         return new SimpleParticleType(true);
      });
      SPLASH_PUFF = REGISTRY.register("splash_puff", () -> {
         return new SimpleParticleType(true);
      });
      SMOKE = REGISTRY.register("smoke", () -> {
         return new SimpleParticleType(true);
      });
      BULLET_TRAIL = REGISTRY.register("bullet_trail", () -> {
         return new SimpleParticleType(true);
      });
      LARGE_BULLET_TRAIL = REGISTRY.register("large_bullet_trail", () -> {
         return new SimpleParticleType(true);
      });
      AERIAL_SPARKS = REGISTRY.register("aerial_sparks", () -> {
         return new SimpleParticleType(true);
      });
      GREEN_TRACER = REGISTRY.register("green_tracer", () -> {
         return new SimpleParticleType(true);
      });
      WHITE_TRACER = REGISTRY.register("white_tracer", () -> {
         return new SimpleParticleType(true);
      });
      SMALL_GREEN_TRACER = REGISTRY.register("small_green_tracer", () -> {
         return new SimpleParticleType(true);
      });
      RISING_FLAME = REGISTRY.register("rising_flame", () -> {
         return new SimpleParticleType(true);
      });
      GUN_SMOKE = REGISTRY.register("gun_smoke", () -> {
         return new SimpleParticleType(true);
      });
      DUST_WAVE = REGISTRY.register("dust_wave", () -> {
         return new SimpleParticleType(true);
      });
      FLARE = REGISTRY.register("flare", () -> {
         return new SimpleParticleType(true);
      });
      JET_FLAME = REGISTRY.register("jet_flame", () -> {
         return new SimpleParticleType(true);
      });
      DEATH_RAY = REGISTRY.register("death_ray", () -> {
         return new SimpleParticleType(true);
      });
      HUGE_STATIC_FIREBALL = REGISTRY.register("huge_static_fireball", () -> {
         return new SimpleParticleType(true);
      });
      GAS_CLOUD = REGISTRY.register("gas_cloud", () -> {
         return new SimpleParticleType(true);
      });
      ROCKET_SMOKE = REGISTRY.register("rocket_smoke", () -> {
         return new SimpleParticleType(true);
      });
      FUSION_FIREBALL = REGISTRY.register("fusion_fireball", () -> {
         return new SimpleParticleType(true);
      });
      FUSION_STATIC_FIREBALL = REGISTRY.register("fusion_static_fireball", () -> {
         return new SimpleParticleType(true);
      });
      FUSION_SMOKE = REGISTRY.register("fusion_smoke", () -> {
         return new SimpleParticleType(true);
      });
      SPACE_FIREBALL = REGISTRY.register("space_fireball", () -> {
         return new SimpleParticleType(true);
      });
      FLAME_PARTICLE = REGISTRY.register("flame_particle", () -> {
         return new SimpleParticleType(true);
      });
      ROCKET_FLAME = REGISTRY.register("rocket_flame", () -> {
         return new SimpleParticleType(true);
      });
      SMALL_SPLASH_PUFF = REGISTRY.register("small_splash_puff", () -> {
         return new SimpleParticleType(true);
      });
      RADIOACTIVE_CLOUD = REGISTRY.register("radioactive_cloud", () -> {
         return new SimpleParticleType(true);
      });
      PHOSPHORUS_TRAIL = REGISTRY.register("phosphorus_trail", () -> {
         return new SimpleParticleType(true);
      });
   }
}
