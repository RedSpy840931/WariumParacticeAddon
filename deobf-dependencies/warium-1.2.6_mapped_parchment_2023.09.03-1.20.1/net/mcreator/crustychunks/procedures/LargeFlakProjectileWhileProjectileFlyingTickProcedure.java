package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LargeFlakProjectileWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean trigger = false;
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_BULLET_TRAIL.get(), x, y, z, immediatesourceentity.getDeltaMovement().x() * 0.1D, immediatesourceentity.getDeltaMovement().y() * 0.1D, immediatesourceentity.getDeltaMovement().z() * 0.1D);
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() instanceof LiquidBlock) {
            trigger = true;
         }

         if (immediatesourceentity.getPersistentData().getDouble("T") > 60.0D) {
            trigger = true;
         }

         double var10000;
         if (0.0D < immediatesourceentity.getPersistentData().getDouble("Range")) {
            var10000 = immediatesourceentity.getPersistentData().getDouble("T");
            double var10001 = immediatesourceentity.getPersistentData().getDouble("Range");
            double var10002;
            if (immediatesourceentity instanceof Projectile) {
               Projectile _projEnt = (Projectile)immediatesourceentity;
               var10002 = _projEnt.getDeltaMovement().length();
            } else {
               var10002 = 0.0D;
            }

            if (var10000 >= var10001 / var10002) {
               trigger = true;
            }
         }

         Vec3 _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(10.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.distanceToSqr(_center);
         })).toList();
         Iterator var11 = _entfound.iterator();

         while(true) {
            Entity entityiterator;
            do {
               do {
                  if (!var11.hasNext()) {
                     if (trigger) {
                        trigger = false;
                        CrustyChunksMod.queueServerWork(1, () -> {
                           TankFireProjectileHitsBlockProcedure.execute(world, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ(), immediatesourceentity);
                        });
                     }

                     ForceChunksProcedure.execute(world, x, y, z);
                     return;
                  }

                  entityiterator = (Entity)var11.next();
               } while(!(immediatesourceentity.getPersistentData().getDouble("T") >= 7.0D));
            } while(!(entityiterator instanceof LivingEntity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:warm"))));

            trigger = true;
            if (entityiterator instanceof Projectile) {
               Projectile _projEnt = (Projectile)entityiterator;
               var10000 = _projEnt.getDeltaMovement().length();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 0.0D && !entityiterator.level().isClientSide()) {
               entityiterator.discard();
            }
         }
      }
   }
}
