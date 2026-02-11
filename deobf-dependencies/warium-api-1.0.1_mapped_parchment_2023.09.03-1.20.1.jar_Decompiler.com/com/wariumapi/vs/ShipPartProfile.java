package com.wariumapi.vs;

import java.util.Collections;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;

public record ShipPartProfile(double mass, double buoyancy, double drag, double lift, Map<ResourceLocation, Double> extras) {
   public ShipPartProfile(double mass, double buoyancy, double drag, double lift, Map<ResourceLocation, Double> extras) {
      if (extras == null) {
         extras = Collections.emptyMap();
      }

      this.mass = mass;
      this.buoyancy = buoyancy;
      this.drag = drag;
      this.lift = lift;
      this.extras = extras;
   }

   public double mass() {
      return this.mass;
   }

   public double buoyancy() {
      return this.buoyancy;
   }

   public double drag() {
      return this.drag;
   }

   public double lift() {
      return this.lift;
   }

   public Map<ResourceLocation, Double> extras() {
      return this.extras;
   }
}
