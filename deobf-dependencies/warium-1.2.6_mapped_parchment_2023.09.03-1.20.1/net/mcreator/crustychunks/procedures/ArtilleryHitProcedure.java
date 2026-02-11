package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.IRMissileEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class ArtilleryHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (immediatesourceentity instanceof IRMissileEntity) {
            if (immediatesourceentity.getPersistentData().getDouble("Time") > 2.0D) {
               MediumExplosionProcedure.execute(world, x, y, z);
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }

               Level _level;
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y, z, 5.0F, ExplosionInteraction.BLOCK);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ(), 6.0F, ExplosionInteraction.BLOCK);
                  }
               }
            }
         } else {
            MediumExplosionProcedure.execute(world, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
