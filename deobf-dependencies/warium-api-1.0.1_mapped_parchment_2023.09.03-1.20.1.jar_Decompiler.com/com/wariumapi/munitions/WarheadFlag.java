package com.wariumapi.munitions;

public enum WarheadFlag {
   INCENDIARY,
   GAS,
   CLUSTER,
   NUCLEAR,
   FUSION;

   // $FF: synthetic method
   private static WarheadFlag[] $values() {
      return new WarheadFlag[]{INCENDIARY, GAS, CLUSTER, NUCLEAR, FUSION};
   }
}
