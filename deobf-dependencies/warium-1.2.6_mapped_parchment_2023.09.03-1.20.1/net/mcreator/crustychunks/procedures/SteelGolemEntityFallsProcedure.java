package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SteelGolemEntityFallsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      sx = -3.0D;
      found = false;

      for(int index0 = 0; index0 < 8; ++index0) {
         sy = -1.0D;

         for(int index1 = 0; index1 < 3; ++index1) {
            sz = -3.0D;

            for(int index2 = 0; index2 < 8; ++index2) {
               if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).is(BlockTags.create(new ResourceLocation("crusty_chunks:splinterable"))) || world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).is(BlockTags.create(new ResourceLocation("crusty_chunks:shatterable")))) {
                  found = true;
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      if (found) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
      }

      if (world instanceof Level) {
         Level _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 0.5F);
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
         }
      }

      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x, y, z, 15, 3.0D, 1.0D, 3.0D, 0.1D);
      }

   }
}
