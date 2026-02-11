package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AISiegeTriggerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("DoomType") == 0.0D) {
            AssassinationAttemptProcedure.execute(world, x, y, z);
         } else if (entity.getPersistentData().getDouble("DoomType") == 1.0D) {
            CrustyChunksMod.queueServerWork(140, () -> {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y + 40.0D, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sonicboom")), SoundSource.NEUTRAL, 100.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y + 40.0D, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sonicboom")), SoundSource.NEUTRAL, 100.0F, 1.0F, false);
                  }
               }

            });
            CrustyChunksMod.queueServerWork(160, () -> {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y + 40.0D, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:siren")), SoundSource.NEUTRAL, 40.0F, 0.25F);
                  } else {
                     _level.playLocalSound(x, y + 40.0D, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:siren")), SoundSource.NEUTRAL, 40.0F, 0.25F, false);
                  }
               }

               AISiegeProcedure.execute(world, x, y, z);
            });
         } else if (entity.getPersistentData().getDouble("DoomType") >= 2.0D) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y + 40.0D, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:siren")), SoundSource.NEUTRAL, 40.0F, 0.25F);
               } else {
                  _level.playLocalSound(x, y + 40.0D, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:siren")), SoundSource.NEUTRAL, 40.0F, 0.25F, false);
               }
            }

            CrustyChunksMod.queueServerWork(256, () -> {
               AISuperSiegeProcedure.execute(world, x, z);
            });
         }

      }
   }
}
