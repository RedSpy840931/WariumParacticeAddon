package com.wariumapi.ballistics;

public final class ImpactResult {
   private boolean didPenetrate;
   private double penetrationDepth;
   private double damageMultiplier = 1.0D;
   private boolean ricochet;
   private int spallCount;
   private boolean explosionTriggered;

   public boolean didPenetrate() {
      return this.didPenetrate;
   }

   public void setDidPenetrate(boolean didPenetrate) {
      this.didPenetrate = didPenetrate;
   }

   public double penetrationDepth() {
      return this.penetrationDepth;
   }

   public void setPenetrationDepth(double penetrationDepth) {
      this.penetrationDepth = penetrationDepth;
   }

   public double damageMultiplier() {
      return this.damageMultiplier;
   }

   public void setDamageMultiplier(double damageMultiplier) {
      this.damageMultiplier = damageMultiplier;
   }

   public boolean ricochet() {
      return this.ricochet;
   }

   public void setRicochet(boolean ricochet) {
      this.ricochet = ricochet;
   }

   public int spallCount() {
      return this.spallCount;
   }

   public void setSpallCount(int spallCount) {
      this.spallCount = spallCount;
   }

   public boolean explosionTriggered() {
      return this.explosionTriggered;
   }

   public void setExplosionTriggered(boolean explosionTriggered) {
      this.explosionTriggered = explosionTriggered;
   }
}
