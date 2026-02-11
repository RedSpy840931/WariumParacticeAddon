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

public class LargeFireSoundProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Movementinnacuracy = 0.0D;
      CrustyChunksMod.queueServerWork(1, () -> {
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshotmedium")), SoundSource.BLOCKS, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:distantshotmedium")), SoundSource.BLOCKS, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mediumshot")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:largeshot")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
            }
         }

      });
   }
}
