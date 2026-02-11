package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class ChaffTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x, y, z, 0.0D, 0.0D, 0.0D);
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().getDouble("T") >= 20.0D) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y() + 0.049D, immediatesourceentity.getDeltaMovement().z()));
         }

         if (immediatesourceentity.getPersistentData().getDouble("T") >= 40.0D && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
