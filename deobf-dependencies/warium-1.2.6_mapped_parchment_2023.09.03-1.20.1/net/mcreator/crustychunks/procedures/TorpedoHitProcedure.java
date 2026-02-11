package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class TorpedoHitProcedure {
   public static void execute(LevelAccessor world, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         LargeExplosionProcedure.execute(world, immediatesourceentity.getX(), immediatesourceentity.getY() + immediatesourceentity.getLookAngle().y * 2.0D + 2.0D, immediatesourceentity.getZ());
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, immediatesourceentity.getX() + immediatesourceentity.getLookAngle().x * 2.0D, immediatesourceentity.getY() + 2.5D, immediatesourceentity.getZ() - immediatesourceentity.getLookAngle().z * 2.0D, 6.0F, ExplosionInteraction.NONE);
            }
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
