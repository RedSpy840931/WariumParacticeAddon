package com.wariumapi.ballistics;

import java.util.EnumSet;

public record ProjectileProfile(double mass, double calibre, double velocity, EnumSet<ProjectileFlag> flags, double explosiveMass, FuseType fuseType, double penetrationFactor, double damageScale, double spallFactor) {
   public ProjectileProfile(double mass, double calibre, double velocity, EnumSet<ProjectileFlag> flags, double explosiveMass, FuseType fuseType, double penetrationFactor, double damageScale, double spallFactor) {
      if (flags == null) {
         flags = EnumSet.noneOf(ProjectileFlag.class);
      }

      if (fuseType == null) {
         fuseType = FuseType.NONE;
      }

      this.mass = mass;
      this.calibre = calibre;
      this.velocity = velocity;
      this.flags = flags;
      this.explosiveMass = explosiveMass;
      this.fuseType = fuseType;
      this.penetrationFactor = penetrationFactor;
      this.damageScale = damageScale;
      this.spallFactor = spallFactor;
   }

   public double mass() {
      return this.mass;
   }

   public double calibre() {
      return this.calibre;
   }

   public double velocity() {
      return this.velocity;
   }

   public EnumSet<ProjectileFlag> flags() {
      return this.flags;
   }

   public double explosiveMass() {
      return this.explosiveMass;
   }

   public FuseType fuseType() {
      return this.fuseType;
   }

   public double penetrationFactor() {
      return this.penetrationFactor;
   }

   public double damageScale() {
      return this.damageScale;
   }

   public double spallFactor() {
      return this.spallFactor;
   }
}
