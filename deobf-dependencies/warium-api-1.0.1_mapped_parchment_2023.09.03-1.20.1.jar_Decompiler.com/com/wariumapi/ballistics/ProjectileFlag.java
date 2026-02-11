package com.wariumapi.ballistics;

public enum ProjectileFlag {
   KINETIC,
   AP,
   HE,
   HEAT,
   INCENDIARY,
   SMOKE,
   CHEMICAL,
   GUIDED,
   FRAG,
   EMP;

   // $FF: synthetic method
   private static ProjectileFlag[] $values() {
      return new ProjectileFlag[]{KINETIC, AP, HE, HEAT, INCENDIARY, SMOKE, CHEMICAL, GUIDED, FRAG, EMP};
   }
}
