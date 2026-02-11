package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ClusterRocketHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         for(int index0 = 0; index0 < 4; ++index0) {
            SmallExplosionProcedure.execute(world, x + immediatesourceentity.getLookAngle().x * 2.0D, y + immediatesourceentity.getLookAngle().y * 2.0D, z - immediatesourceentity.getLookAngle().z * 2.0D);
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
