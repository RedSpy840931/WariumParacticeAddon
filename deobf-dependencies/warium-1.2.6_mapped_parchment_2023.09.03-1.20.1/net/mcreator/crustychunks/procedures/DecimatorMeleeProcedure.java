package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorMeleeProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int horizontalRadiusSquare = 3;
         int verticalRadiusSquare = 2;
         int yIterationsSquare = verticalRadiusSquare;

         for(int i = -verticalRadiusSquare; i <= yIterationsSquare; ++i) {
            for(int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; ++xi) {
               for(int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; ++zi) {
                  world.levelEvent(2001, BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), Block.getId(world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi))));
                  if ((!(world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).getDestroySpeed(world, BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)) < 5.0F) || !(world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).getDestroySpeed(world, BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)) >= 0.0F)) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:chippable")))) {
                     HeavyCrackProcedureProcedure.execute(world, x + (double)xi, y + (double)i + 3.0D, z + (double)zi);
                  } else {
                     world.destroyBlock(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), false);
                  }
               }
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 5.0F, 0.4F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 5.0F, 0.4F, false);
            }
         }

         entity.getPersistentData().putDouble("T", 60.0D);
         if (entity instanceof DecimatorEntity) {
            ((DecimatorEntity)entity).setAnimation("Anger");
         }

         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x, y + 1.5D, z, 15, 2.0D, 0.0D, 2.0D, 1.0D);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), x, y + 1.5D, z, 15, 2.0D, 0.0D, 2.0D, 1.0D);
         }

      }
   }
}
