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
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class BirdshotBlockHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Level _level;
      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:shatterable")))) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 3.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
            }
         }
      }

      if (5 == Mth.nextInt(RandomSource.create(), 1, 5)) {
         ServerLevel _level;
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dirts")))) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x + 0.5D, y + 1.0D, z + 0.5D, 4, 0.0D, 2.0D, 0.0D, 1.0D);
            }

            world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(Blocks.DIRT.defaultBlockState()));
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:chippable"))) && world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:resistant")))) {
            if (Mth.nextInt(RandomSource.create(), 1, 3) == 3) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 1.5F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 1.5F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D), false);
                  }
               }
            } else if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D), false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMALL_PUFF.get(), x + 0.5D, y + 1.0D, z + 0.5D, 4, 0.0D, 0.0D, 0.0D, 0.7D);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 1.0D, z + 0.5D, 4, 0.3D, 0.3D, 0.3D, 1.5D);
            }
         } else if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:wizz")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 1.3D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:wizz")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 1.3D), false);
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SAND.get(), x + 0.5D, y + 1.0D, z + 0.5D, 5, 0.0D, 2.0D, 0.0D, 1.0D);
            }

            world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(Blocks.SAND.defaultBlockState()));
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dusts")))) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), x + 0.5D, y + 1.0D, z + 0.5D, 5, 0.0D, 2.0D, 0.0D, 1.0D);
            }

            world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(Blocks.GRAVEL.defaultBlockState()));
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:metals")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 1.0D, z + 0.5D, 7, 0.3D, 0.3D, 0.3D, 1.0D);
            }
         }

         world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:splinterable"))) && world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }
      }

   }
}
