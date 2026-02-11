package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class DebrisTrailProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (100.0D <= immediatesourceentity.getPersistentData().getDouble("T") && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

         if (40.0D >= immediatesourceentity.getPersistentData().getDouble("T")) {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, 0.0D, 0.0D, 0.0D);
         }

         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
      }
   }
}
