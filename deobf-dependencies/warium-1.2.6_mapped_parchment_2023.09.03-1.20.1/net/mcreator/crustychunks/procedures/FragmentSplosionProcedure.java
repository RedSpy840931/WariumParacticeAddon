package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class FragmentSplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 40.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 40.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 7.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 7.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
         }
      }

      ServerLevel _level;
      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x + 0.5D, y + 0.5D, z + 0.5D, 5, 1.0D, 1.0D, 1.0D, 1.0D);
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x + 0.5D, y + 1.5D, z + 0.5D, 40, 0.5D, 0.5D, 0.5D, 1.2D);
      }

   }
}
