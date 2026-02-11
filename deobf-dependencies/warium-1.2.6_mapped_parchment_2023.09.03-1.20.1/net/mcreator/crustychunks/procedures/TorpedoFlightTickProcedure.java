package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.registries.ForgeRegistries;

public class TorpedoFlightTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         ServerLevel _world;
         if (immediatesourceentity.isUnderWater()) {
            immediatesourceentity.setNoGravity(true);
            if (immediatesourceentity.getPersistentData().getDouble("Time") >= 20.0D) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), y + Mth.nextDouble(RandomSource.create(), 0.1D, 0.3D), z + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.swim")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.9D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.swim")), SoundSource.NEUTRAL, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.9D), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  _world = (ServerLevel)world;
                  _world.sendParticles(ParticleTypes.SPLASH, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
               }

               if (world.getBlockState(BlockPos.containing(x, y + 1.5D, z)).getBlock() instanceof LiquidBlock) {
                  immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getLookAngle().x * -1.0D, 0.4D, immediatesourceentity.getLookAngle().z));
               } else {
                  immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getLookAngle().x * -1.0D, -0.2D, immediatesourceentity.getLookAngle().z));
               }
            }
         } else {
            immediatesourceentity.setNoGravity(false);
         }

         if (immediatesourceentity.getPersistentData().getDouble("Time") >= 400.0D) {
            TorpedoHitProcedure.execute(world, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().z, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().z, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().z, true, true);
         }

         if (world instanceof ServerLevel) {
            _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().z, true, true);
         }

         CrustyChunksMod.queueServerWork(40, () -> {
            ServerLevel _world;
            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)(x + 16.0D), (int)y, (int)z)).getPos().z, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)(z + 16.0D))).getPos().z, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)(x - 16.0D), (int)y, (int)z)).getPos().z, false, true);
            }

            if (world instanceof ServerLevel) {
               _world = (ServerLevel)world;
               ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)(z - 16.0D))).getPos().z, false, true);
            }

         });
      }
   }
}
