package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IRMissileFlightTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean detonate = false;
         boolean Trigger = false;
         new Vec3(0.0D, 0.0D, 0.0D);
         double distancetotarget = 0.0D;
         double speed = 0.0D;
         double targetspeed = 0.0D;
         double leadvariable = 0.0D;
         double Limiter = 0.0D;
         double mx = 0.0D;
         double my = 0.0D;
         double mz = 0.0D;
         ForceChunksProcedure.execute(world, x, y, z);
         immediatesourceentity.getPersistentData().putDouble("MaxTime", 130.0D);
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         Vec3 _center;
         if (immediatesourceentity.getPersistentData().getDouble("Time") <= 130.0D) {
            for(int index0 = 0; index0 < 4; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), y + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), z + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D));
            }

            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z());
            if (immediatesourceentity.getPersistentData().getDouble("Time") / 5.0D == (double)Math.round(immediatesourceentity.getPersistentData().getDouble("Time") / 5.0D)) {
               Level _level;
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 15.0F, (float)(1.8D - immediatesourceentity.getPersistentData().getDouble("Time") / 80.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 15.0F, (float)(1.8D - immediatesourceentity.getPersistentData().getDouble("Time") / 80.0D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 40.0F, (float)(1.8D - immediatesourceentity.getPersistentData().getDouble("Time") / 80.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 40.0F, (float)(1.8D - immediatesourceentity.getPersistentData().getDouble("Time") / 80.0D), false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
            }

            _center = immediatesourceentity.getDeltaMovement().scale(1.01D);
            immediatesourceentity.setDeltaMovement(_center);
            immediatesourceentity.setNoGravity(true);
         } else {
            ArtilleryHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(300.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.distanceToSqr(_center);
         })).toList();
         Iterator var29 = _entfound.iterator();

         while(true) {
            Entity entityiterator;
            do {
               if (!var29.hasNext()) {
                  if (speed > 12.0D && 10.0D < immediatesourceentity.getPersistentData().getDouble("Time")) {
                     immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x() * 0.9D, immediatesourceentity.getDeltaMovement().y() * 0.9D, immediatesourceentity.getDeltaMovement().z() * 0.9D));
                  }

                  if (10.0D < immediatesourceentity.getPersistentData().getDouble("Time")) {
                     _center = new Vec3(x, y, z);
                     _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(7.5D), (e) -> {
                        return true;
                     }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                     })).toList();
                     var29 = _entfound.iterator();

                     while(var29.hasNext()) {
                        entityiterator = (Entity)var29.next();
                        if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:warm")))) {
                           detonate = true;
                           double var10001;
                           if (entityiterator instanceof Projectile) {
                              Projectile _projEnt = (Projectile)entityiterator;
                              var10001 = _projEnt.getDeltaMovement().length();
                           } else {
                              var10001 = 0.0D;
                           }

                           if (0.0D < var10001 && !entityiterator.level().isClientSide()) {
                              entityiterator.discard();
                           }
                        }
                     }
                  }

                  if (detonate) {
                     CrustyChunksMod.queueServerWork(1, () -> {
                        ArtilleryHitProcedure.execute(world, x, y, z, immediatesourceentity);
                        if (!immediatesourceentity.level().isClientSide()) {
                           immediatesourceentity.discard();
                        }

                     });
                  }

                  if (immediatesourceentity.isUnderWater()) {
                     ArtilleryHitProcedure.execute(world, x, y, z, immediatesourceentity);
                     if (!immediatesourceentity.level().isClientSide()) {
                        immediatesourceentity.discard();
                     }
                  }

                  _center = new Vec3(x, y, z);
                  _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(1.0D), (e) -> {
                     return true;
                  }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                     return _entcnd.distanceToSqr(_center);
                  })).toList();
                  var29 = _entfound.iterator();

                  while(var29.hasNext()) {
                     entityiterator = (Entity)var29.next();
                     if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:bullet")))) {
                        if (!entityiterator.level().isClientSide()) {
                           entityiterator.discard();
                        }

                        Trigger = true;
                     }
                  }

                  if (Trigger) {
                     if (!immediatesourceentity.level().isClientSide()) {
                        immediatesourceentity.discard();
                     }

                     CrustyChunksMod.queueServerWork(1, () -> {
                        ArtilleryHitProcedure.execute(world, x, y, z, immediatesourceentity);
                     });
                  }

                  return;
               }

               entityiterator = (Entity)var29.next();
            } while(!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:warm"))));

            if (0.0D == entityiterator.getPersistentData().getDouble("Mx") && 0.0D == entityiterator.getPersistentData().getDouble("My") && 0.0D == entityiterator.getPersistentData().getDouble("Mz")) {
               mx = entityiterator.getDeltaMovement().x();
               my = entityiterator.getDeltaMovement().y();
               mz = entityiterator.getDeltaMovement().z();
            } else {
               mx = entityiterator.getPersistentData().getDouble("Mx");
               my = entityiterator.getPersistentData().getDouble("My");
               mz = entityiterator.getPersistentData().getDouble("Mz");
            }

            distancetotarget = Math.sqrt(Math.pow(Math.abs(entityiterator.getY() - y), 2.0D) + Math.pow(Math.abs(entityiterator.getX() - x), 2.0D) + Math.pow(Math.abs(entityiterator.getZ() - z), 2.0D));
            speed = Math.sqrt(Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().x()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().y()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().z()), 2.0D));
            Limiter = 0.04D * speed;
            leadvariable = 1.0D;
            leadvariable = leadvariable * distancetotarget / speed;
            if (Math.sqrt(Math.pow(entityiterator.getY() - y, 2.0D) + Math.pow(entityiterator.getX() - x, 2.0D) + Math.pow(entityiterator.getZ() - z, 2.0D)) - Math.sqrt(Math.pow(entityiterator.getY() - (y + immediatesourceentity.getDeltaMovement().y()), 2.0D) + Math.pow(entityiterator.getX() - (x + immediatesourceentity.getDeltaMovement().x()), 2.0D) + Math.pow(entityiterator.getZ() - (z + immediatesourceentity.getDeltaMovement().z()), 2.0D)) > 1.25D) {
               immediatesourceentity.setDeltaMovement(new Vec3(Math.min(immediatesourceentity.getDeltaMovement().x() + Limiter, Math.max((immediatesourceentity.getDeltaMovement().x() * 7.0D + (entityiterator.getX() + mx * leadvariable - x) * speed / distancetotarget) / 8.0D, immediatesourceentity.getDeltaMovement().x() - Limiter)), Math.min(immediatesourceentity.getDeltaMovement().y() + Limiter, Math.max((immediatesourceentity.getDeltaMovement().y() * 7.0D + (entityiterator.getY() + my * leadvariable - y) * speed / distancetotarget) / 8.0D, immediatesourceentity.getDeltaMovement().y() - Limiter)), Math.min(immediatesourceentity.getDeltaMovement().z() + Limiter, Math.max((immediatesourceentity.getDeltaMovement().z() * 7.0D + (entityiterator.getZ() + mz * leadvariable - z) * speed / distancetotarget) / 8.0D, immediatesourceentity.getDeltaMovement().z() - Limiter))));
            }
         }
      }
   }
}
