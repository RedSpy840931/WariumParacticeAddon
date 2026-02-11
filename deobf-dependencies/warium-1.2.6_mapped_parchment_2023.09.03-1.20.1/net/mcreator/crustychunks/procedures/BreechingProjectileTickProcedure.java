package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;

public class BreechingProjectileTickProcedure {
   public static void execute(Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().getDouble("T") >= 2.0D && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
