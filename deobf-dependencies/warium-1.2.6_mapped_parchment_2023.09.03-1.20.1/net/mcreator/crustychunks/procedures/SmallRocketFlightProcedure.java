package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SmallRocketFlightProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         ForceChunksProcedure.execute(world, x, y, z);
         immediatesourceentity.getPersistentData().putDouble("MaxTime", 60.0D);
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         if (immediatesourceentity.getPersistentData().getDouble("Time") <= 60.0D) {
            for(int index0 = 0; index0 < 4; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), y + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), z + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
            }

            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z());
            if (immediatesourceentity.getPersistentData().getDouble("Time") / 10.0D == (double)Math.round(immediatesourceentity.getPersistentData().getDouble("Time") / 10.0D) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.0D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.0D), false);
               }
            }

            Vec3 motion = immediatesourceentity.getDeltaMovement().scale(1.01D);
            immediatesourceentity.setDeltaMovement(motion);
         }

         if (immediatesourceentity.isUnderWater()) {
            RocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
