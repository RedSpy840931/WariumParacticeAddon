package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class StealthPistolFireSoundProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Movementinnacuracy = 0.0D;
      double recoil = 0.0D;
      CrustyChunksMod.queueServerWork(1, () -> {
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.BLOCKS, 8.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.05D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshot")), SoundSource.BLOCKS, 8.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.05D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:silencedshot")), SoundSource.BLOCKS, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.05D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:silencedshot")), SoundSource.BLOCKS, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.05D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:gunmechanism")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.05D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:gunmechanism")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.05D), false);
            }
         }

      });
   }
}
