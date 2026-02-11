package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.world.ForgeChunkManager;

public class TankTracerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (!immediatesourceentity.isUnderWater()) {
            SimpleParticleType var10001 = (SimpleParticleType)CrustyChunksModParticleTypes.WHITE_TRACER.get();
            double var10005 = immediatesourceentity.getLookAngle().x * -1.0D;
            double var10006;
            Projectile _projEnt;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10006 = _projEnt.getDeltaMovement().length();
            } else {
               var10006 = 0.0D;
            }

            var10005 *= var10006;
            var10006 = immediatesourceentity.getLookAngle().y * -1.0D;
            double var10007;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10007 = _projEnt.getDeltaMovement().length();
            } else {
               var10007 = 0.0D;
            }

            var10006 *= var10007;
            var10007 = immediatesourceentity.getLookAngle().z;
            double var10008;
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10008 = _projEnt.getDeltaMovement().length();
            } else {
               var10008 = 0.0D;
            }

            world.addParticle(var10001, x, y, z, var10005, var10006, var10007 * var10008);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x, y, z, 0.0D, 0.0D, 0.0D);
         }

         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         ServerLevel _world;
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
