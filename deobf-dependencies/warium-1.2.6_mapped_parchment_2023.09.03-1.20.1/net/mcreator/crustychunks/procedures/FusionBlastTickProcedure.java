package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;

public class FusionBlastTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean found = false;
         double particleRadius = 0.0D;
         double particleAmount = 0.0D;
         double sx = 0.0D;
         double sy = 0.0D;
         double sz = 0.0D;
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double Groundatspot = 0.0D;
         if (1.0D == immediatesourceentity.getPersistentData().getDouble("T")) {
            FusionEffectsProcedure.execute(world, x, immediatesourceentity.getY() - 15.0D, z);
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(500.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var29 = _entfound.iterator();

            while(var29.hasNext()) {
               Entity entityiterator = (Entity)var29.next();
               CrustyChunksMod.queueServerWork((int)Math.abs(Math.round(Math.sqrt(Math.pow(x - entityiterator.getX(), 2.0D) + Math.pow(z - entityiterator.getZ(), 2.0D)) * 0.5D)), () -> {
                  immediatesourceentity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 1.0D, entityiterator.getZ()));
                  if (Math.abs(entityiterator.getY() + 0.5D - y) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getY() - y) + 0.5D) <= 0.0D && Math.abs(entityiterator.getX() - x) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX() - x) + 0.5D) <= 0.0D && Math.abs(entityiterator.getZ() - z) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ() - z) + 0.5D) <= 0.0D) {
                     entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 7.0F);
                     entityiterator.setDeltaMovement(new Vec3(immediatesourceentity.getLookAngle().x * 2.0D + entityiterator.getDeltaMovement().x(), immediatesourceentity.getLookAngle().y * 2.0D + entityiterator.getDeltaMovement().y(), immediatesourceentity.getLookAngle().z * 2.0D + entityiterator.getDeltaMovement().z()));
                  }

               });
            }
         }

         immediatesourceentity.setNoGravity(true);
         immediatesourceentity.noPhysics = true;
         immediatesourceentity.setDeltaMovement(new Vec3(0.0D, 0.0D, 0.0D));
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         xRadius = 1.0D + immediatesourceentity.getPersistentData().getDouble("T");
         zRadius = 1.0D + immediatesourceentity.getPersistentData().getDouble("T");

         for(particleAmount = (double)(1L + Math.round(xRadius * 0.9D)); loop < particleAmount; ++loop) {
            if (immediatesourceentity.getPersistentData().getDouble("T") / 2.0D == (double)Math.round(immediatesourceentity.getPersistentData().getDouble("T") / 2.0D)) {
               if (1 == Mth.nextInt(RandomSource.create(), 1, 5)) {
                  Level _level;
                  if (y + 10.0D > (double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) && !ModList.get().isLoaded("explosionoverhaul") && world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) + 9), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, 6.0F, ExplosionInteraction.BLOCK);
                     }
                  }

                  if (5.0D <= immediatesourceentity.getPersistentData().getDouble("T") && !ModList.get().isLoaded("explosionoverhaul") && y + 5.0D > (double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) && world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, Math.max((double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) + 22), y + 8.0D), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, (float)(16.0D / Math.ceil(xRadius / 75.0D) + 4.0D), ExplosionInteraction.BLOCK);
                     }
                  }

                  if (1 == Mth.nextInt(RandomSource.create(), 1, 2) && 550.0D >= immediatesourceentity.getPersistentData().getDouble("T")) {
                     Groundatspot = (double)world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), (int)(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius));
                     if (5.0D <= immediatesourceentity.getPersistentData().getDouble("T")) {
                        world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.DUST_WAVE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius), Mth.floor(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius)) + 4), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, Math.cos(6.283185307179586D / particleAmount * loop), 0.0D, Math.sin(6.283185307179586D / particleAmount * loop));
                        world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.NUCLEAR_SHOCK_PARTICLE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * xRadius, y + Mth.nextDouble(RandomSource.create(), 25.0D, 30.0D), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * zRadius, Math.cos(6.283185307179586D / particleAmount * loop), 0.0D, Math.sin(6.283185307179586D / particleAmount * loop));
                        if (30.0D <= immediatesourceentity.getPersistentData().getDouble("T")) {
                           world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.NUCLEAR_SHOCK_PARTICLE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * (xRadius - 30.0D), y + Mth.nextDouble(RandomSource.create(), 75.0D, 80.0D), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * (zRadius - 30.0D), Math.cos(6.283185307179586D / particleAmount * loop), 0.0D, Math.sin(6.283185307179586D / particleAmount * loop));
                        }
                     }
                  }
               }

               if (Mth.nextInt(RandomSource.create(), 1, 10) == 1 && 130.0D > immediatesourceentity.getPersistentData().getDouble("T") && 5.0D <= immediatesourceentity.getPersistentData().getDouble("T")) {
                  world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.GROUND_HUGE_SMOKE.get(), x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * (xRadius - 20.0D), (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x + 0.5D + Math.cos(6.283185307179586D / particleAmount * loop) * (xRadius - 20.0D)), Mth.floor(z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * (zRadius - 20.0D))) + 8), z + 0.5D + Math.sin(6.283185307179586D / particleAmount * loop) * (zRadius - 20.0D), 0.0D, 0.25D, 0.0D);
               }
            }
         }

         immediatesourceentity.getPersistentData().putDouble("Iterations", immediatesourceentity.getPersistentData().getDouble("Iterations") + 1.0D);
         if (450.0D <= immediatesourceentity.getPersistentData().getDouble("T") && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
