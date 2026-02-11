package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.SmallBombProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ClusterRocketFlightTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean Trigger = false;
         ForceChunksProcedure.execute(world, x, y, z);
         immediatesourceentity.getPersistentData().putDouble("MaxTime", 30.0D);
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         int index0;
         Vec3 motion;
         if (immediatesourceentity.getPersistentData().getDouble("Time") <= 30.0D) {
            for(index0 = 0; index0 < 4; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), y + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), z + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
            }

            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z());
            if (immediatesourceentity.getPersistentData().getDouble("Time") / 10.0D == (double)Math.round(immediatesourceentity.getPersistentData().getDouble("Time") / 10.0D)) {
               Level _level;
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 15.0F, (float)(1.4D - immediatesourceentity.getPersistentData().getDouble("Time") / 30.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 15.0F, (float)(1.4D - immediatesourceentity.getPersistentData().getDouble("Time") / 30.0D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 40.0F, (float)(1.4D - immediatesourceentity.getPersistentData().getDouble("Time") / 30.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 40.0F, (float)(1.4D - immediatesourceentity.getPersistentData().getDouble("Time") / 30.0D), false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
            }

            motion = immediatesourceentity.getDeltaMovement().scale(1.02D);
            immediatesourceentity.setDeltaMovement(motion);
         } else {
            for(index0 = 0; index0 < 4; ++index0) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new SmallBombProjectileEntity((EntityType)CrustyChunksModEntities.SMALL_BOMB_PROJECTILE.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 5.0F, 1);
                  _entityToSpawn.setPos(x, y, z);
                  double var10001 = immediatesourceentity.getDeltaMovement().x();
                  double var10002 = immediatesourceentity.getDeltaMovement().y();
                  double var10003 = immediatesourceentity.getDeltaMovement().z();
                  double var10004;
                  if (immediatesourceentity instanceof Projectile) {
                     Projectile _projEnt = (Projectile)immediatesourceentity;
                     var10004 = _projEnt.getDeltaMovement().length();
                  } else {
                     var10004 = 0.0D;
                  }

                  _entityToSpawn.shoot(var10001, var10002, var10003, (float)var10004, 12.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }

            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         if (immediatesourceentity.isUnderWater()) {
            ClusterRocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         motion = new Vec3(x, y, z);
         List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(motion, motion)).inflate(1.25D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.distanceToSqr(motion);
         })).toList();
         Iterator var17 = _entfound.iterator();

         while(var17.hasNext()) {
            Entity entityiterator = (Entity)var17.next();
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
               ClusterRocketHitProcedure.execute(world, x, y, z, immediatesourceentity);
            });
         }

      }
   }
}
