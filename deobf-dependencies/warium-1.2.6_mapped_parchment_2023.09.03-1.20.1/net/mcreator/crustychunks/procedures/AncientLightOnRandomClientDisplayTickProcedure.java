package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AncientLightOnRandomClientDisplayTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Level _level;
      if (1 == Mth.nextInt(RandomSource.create(), 1, 20)) {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sparks")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sparks")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D), false);
            }
         }

         for(int index0 = 0; index0 < 15; ++index0) {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y - 0.1D, z + 0.5D, Mth.nextDouble(RandomSource.create(), -0.4D, 0.4D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.4D, 0.4D));
         }
      }

      if (1 == Mth.nextInt(RandomSource.create(), 1, 15) && world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:humm")), SoundSource.NEUTRAL, 6.0F, 1.2F);
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:humm")), SoundSource.NEUTRAL, 6.0F, 1.2F, false);
         }
      }

   }
}
