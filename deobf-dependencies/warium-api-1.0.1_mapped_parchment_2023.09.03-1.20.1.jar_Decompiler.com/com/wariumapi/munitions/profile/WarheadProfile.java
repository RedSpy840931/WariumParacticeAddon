package com.wariumapi.munitions.profile;

import com.wariumapi.munitions.WarheadFlag;
import java.util.EnumSet;
import java.util.Map;

public record WarheadProfile(double explosiveMass, double blastRadiusScale, double penetrationFactor, EnumSet<WarheadFlag> flags, Map<String, Double> extras) {
   public WarheadProfile(double explosiveMass, double blastRadiusScale, double penetrationFactor, EnumSet<WarheadFlag> flags, Map<String, Double> extras) {
      if (flags == null) {
         flags = EnumSet.noneOf(WarheadFlag.class);
      }

      if (extras == null) {
         extras = Map.of();
      }

      this.explosiveMass = explosiveMass;
      this.blastRadiusScale = blastRadiusScale;
      this.penetrationFactor = penetrationFactor;
      this.flags = flags;
      this.extras = extras;
   }

   public double explosiveMass() {
      return this.explosiveMass;
   }

   public double blastRadiusScale() {
      return this.blastRadiusScale;
   }

   public double penetrationFactor() {
      return this.penetrationFactor;
   }

   public EnumSet<WarheadFlag> flags() {
      return this.flags;
   }

   public Map<String, Double> extras() {
      return this.extras;
   }
}
