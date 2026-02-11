package net.mcreator.crustychunks.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AimerBeamWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.noPhysics = true;
         immediatesourceentity.setInvisible(true);
         immediatesourceentity.setNoGravity(true);
         world.addParticle(ParticleTypes.SCRAPE, x, y, z, 0.0D, 0.0D, 0.0D);
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().getDouble("T") > 15.0D && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
