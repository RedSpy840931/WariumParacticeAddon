package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ThermalProjectileEntity;
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
import net.minecraftforge.registries.ForgeRegistries;

public class BSDespawnProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (immediatesourceentity instanceof ThermalProjectileEntity) {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.AERIAL_SPARKS.get(), x, y, z, Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D));
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.AERIAL_SPARKS.get(), x, y, z, Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D));
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_FLAME.get(), x, y, z, 0.0D, 0.0D, 0.0D);
         }

         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         if (immediatesourceentity.getPersistentData().getDouble("T") >= 10.0D && immediatesourceentity instanceof ThermalProjectileEntity) {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }

            if (immediatesourceentity instanceof ThermalProjectileEntity && 1 == Mth.nextInt(RandomSource.create(), 1, 4) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }
         } else if (immediatesourceentity.getPersistentData().getDouble("T") >= 20.0D && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
