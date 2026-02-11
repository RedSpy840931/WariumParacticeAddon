package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class IncendiaryBottleHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         GasolineExplosionProcedure.execute(world, x + immediatesourceentity.getLookAngle().x * 2.0D, y + immediatesourceentity.getLookAngle().y * 2.0D, z - immediatesourceentity.getLookAngle().z * 2.0D);
         world.levelEvent(2001, BlockPos.containing(x + immediatesourceentity.getLookAngle().x * 2.0D, y + immediatesourceentity.getLookAngle().y * 2.0D, z - immediatesourceentity.getLookAngle().z * 2.0D), Block.getId(Blocks.GLASS.defaultBlockState()));
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
            }
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
