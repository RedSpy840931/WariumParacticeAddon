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
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class GasDisperseProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x + 1.0D, y, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x - 1.0D, y, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y, z + 1.0D)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y, z - 1.0D)).canOcclude()) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMALL_PUFF.get(), x + 0.5D, y + 0.5D, z + 0.5D, 7, 0.0D, 0.0D, 0.0D, 1.0D);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.8D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.8D), false);
            }
         }
      }

   }
}
