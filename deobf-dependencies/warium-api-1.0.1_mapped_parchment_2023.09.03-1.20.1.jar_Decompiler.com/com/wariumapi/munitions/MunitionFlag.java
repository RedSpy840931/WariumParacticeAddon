package com.wariumapi.munitions;

public enum MunitionFlag {
   IR_GUIDED,
   RADAR_GUIDED,
   SEEKER_GUIDED,
   STRIKE_GUIDED;

   // $FF: synthetic method
   private static MunitionFlag[] $values() {
      return new MunitionFlag[]{IR_GUIDED, RADAR_GUIDED, SEEKER_GUIDED, STRIKE_GUIDED};
   }
}
