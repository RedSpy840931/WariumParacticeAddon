package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.registries.ForgeRegistries;

public class DrillProjectileHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      Level _level;
      ServerLevel _level;
      if ((world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) || world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("minecraft:mineable/shovel")))) && 5.0F >= world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) && !world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:concrete")))) {
         BlockPos _pos = BlockPos.containing(x, y, z);
         Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5D, y + 0.5D, z + 0.5D), (BlockEntity)null);
         world.destroyBlock(_pos, false);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 0.5D, z + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x + 0.5D, y + 0.5D, z + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 6.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.2D));
            } else {
               _level.playLocalSound(x + 0.5D, y + 0.5D, z + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 6.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.2D), false);
            }
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:concrete")))) {
         HeavyCrackProcedureProcedure.execute(world, x, y, z);
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 0.5D, z + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x + 0.5D, y + 0.5D, z + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 6.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.2D));
            } else {
               _level.playLocalSound(x + 0.5D, y + 0.5D, z + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 6.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.2D), false);
            }
         }
      }

   }
}
