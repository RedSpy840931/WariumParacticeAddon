package com.wariumapi.ballistics;

public enum FuseType {
   NONE,
   IMPACT,
   TIMED,
   PROXIMITY,
   CONTACT;

   // $FF: synthetic method
   private static FuseType[] $values() {
      return new FuseType[]{NONE, IMPACT, TIMED, PROXIMITY, CONTACT};
   }
}
