package com.wariumapi.munitions.profile;

import com.wariumapi.munitions.MunitionFlag;
import com.wariumapi.munitions.MunitionKind;
import java.util.EnumSet;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;

public record MunitionProfile(MunitionKind kind, double mass, double drag, ResourceLocation warheadId, EnumSet<MunitionFlag> flags, Map<String, Double> extras) {
   public MunitionProfile(MunitionKind kind, double mass, double drag, ResourceLocation warheadId, EnumSet<MunitionFlag> flags, Map<String, Double> extras) {
      if (flags == null) {
         flags = EnumSet.noneOf(MunitionFlag.class);
      }

      if (extras == null) {
         extras = Map.of();
      }

      this.kind = kind;
      this.mass = mass;
      this.drag = drag;
      this.warheadId = warheadId;
      this.flags = flags;
      this.extras = extras;
   }

   public MunitionKind kind() {
      return this.kind;
   }

   public double mass() {
      return this.mass;
   }

   public double drag() {
      return this.drag;
   }

   public ResourceLocation warheadId() {
      return this.warheadId;
   }

   public EnumSet<MunitionFlag> flags() {
      return this.flags;
   }

   public Map<String, Double> extras() {
      return this.extras;
   }
}
