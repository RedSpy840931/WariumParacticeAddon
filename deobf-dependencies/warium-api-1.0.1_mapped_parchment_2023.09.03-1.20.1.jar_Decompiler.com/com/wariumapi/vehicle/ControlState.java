package com.wariumapi.vehicle;

import java.util.EnumSet;

public record ControlState(float throttle, float yaw, float pitch, float roll, EnumSet<ControlFlag> flags) {
   public ControlState(float throttle, float yaw, float pitch, float roll, EnumSet<ControlFlag> flags) {
      if (flags == null) {
         flags = EnumSet.noneOf(ControlFlag.class);
      }

      this.throttle = throttle;
      this.yaw = yaw;
      this.pitch = pitch;
      this.roll = roll;
      this.flags = flags;
   }

   public float throttle() {
      return this.throttle;
   }

   public float yaw() {
      return this.yaw;
   }

   public float pitch() {
      return this.pitch;
   }

   public float roll() {
      return this.roll;
   }

   public EnumSet<ControlFlag> flags() {
      return this.flags;
   }
}
