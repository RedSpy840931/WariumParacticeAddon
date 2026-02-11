package com.wariumapi.armor;

import java.util.Collections;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;

public record ArmorProfile(double thickness, double hardness, double toughness, double spallFactor, double ricochetChance, double blastReduction, Map<ResourceLocation, Double> extras) {
   public ArmorProfile(double thickness, double hardness, double toughness, double spallFactor, double ricochetChance, double blastReduction, Map<ResourceLocation, Double> extras) {
      if (extras == null) {
         extras = Collections.emptyMap();
      }

      this.thickness = thickness;
      this.hardness = hardness;
      this.toughness = toughness;
      this.spallFactor = spallFactor;
      this.ricochetChance = ricochetChance;
      this.blastReduction = blastReduction;
      this.extras = extras;
   }

   public double thickness() {
      return this.thickness;
   }

   public double hardness() {
      return this.hardness;
   }

   public double toughness() {
      return this.toughness;
   }

   public double spallFactor() {
      return this.spallFactor;
   }

   public double ricochetChance() {
      return this.ricochetChance;
   }

   public double blastReduction() {
      return this.blastReduction;
   }

   public Map<ResourceLocation, Double> extras() {
      return this.extras;
   }
}
