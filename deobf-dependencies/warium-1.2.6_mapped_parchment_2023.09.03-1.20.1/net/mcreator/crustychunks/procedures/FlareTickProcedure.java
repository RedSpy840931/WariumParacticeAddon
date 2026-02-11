package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class FlareTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.FLARE.get(), x, y, z, 0.0D, 1.0D, 0.0D);
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         if (immediatesourceentity.getPersistentData().getDouble("Time") >= 50.0D) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y() + 0.049D, immediatesourceentity.getDeltaMovement().z()));
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), 0.7D, 0.9D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
         } else {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
         }

         if (immediatesourceentity.getPersistentData().getDouble("Time") >= 400.0D && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
