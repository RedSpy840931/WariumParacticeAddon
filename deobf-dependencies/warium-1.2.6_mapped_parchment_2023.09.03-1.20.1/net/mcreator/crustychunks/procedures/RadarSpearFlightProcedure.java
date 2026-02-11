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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class RadarSpearFlightProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean detonate = false;
         boolean Trigger = false;
         new Vec3(0.0D, 0.0D, 0.0D);
         BlockState Lblock = Blocks.AIR.defaultBlockState();
         double distancetotarget = 0.0D;
         double speed = 0.0D;
         double targetspeed = 0.0D;
         double leadvariable = 0.0D;
         double Limiter = 0.0D;
         double mx = 0.0D;
         double my = 0.0D;
         double mz = 0.0D;
         double Xvector = 0.0D;
         double Zvector = 0.0D;
         double Pitch = 0.0D;
         double LX = 0.0D;
         double LY = 0.0D;
         double LZ = 0.0D;
         double RadarTargetX = 0.0D;
         double RadarTargetY = 0.0D;
         double RadarTargetZ = 0.0D;
         double RadarVelocityX = 0.0D;
         double RadarVelocityY = 0.0D;
         double RadarVelocityZ = 0.0D;
         ForceChunksProcedure.execute(world, x, y, z);
         world.getBlockState(BlockPos.containing(immediatesourceentity.getPersistentData().getDouble("LX"), immediatesourceentity.getPersistentData().getDouble("LY"), immediatesourceentity.getPersistentData().getDouble("LZ")));
         LX = immediatesourceentity.getPersistentData().getDouble("LX");
         LY = immediatesourceentity.getPersistentData().getDouble("LY");
         LZ = immediatesourceentity.getPersistentData().getDouble("LZ");
         RadarTargetX = ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "TargetX");
         RadarTargetY = ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "TargetY");
         RadarTargetZ = ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "TargetZ");
         RadarVelocityX = ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "MX");
         RadarVelocityY = ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "MY");
         RadarVelocityZ = ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "MZ");
         immediatesourceentity.getPersistentData().putDouble("MaxTime", 130.0D);
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         Vec3 _center;
         if (immediatesourceentity.getPersistentData().getDouble("Time") <= 130.0D) {
            for(int index0 = 0; index0 < 2; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_SMOKE.get(), x + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), y + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), z + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D));
            }

            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z());
            if (immediatesourceentity.getPersistentData().getDouble("Time") / 5.0D == (double)Math.round(immediatesourceentity.getPersistentData().getDouble("Time") / 5.0D)) {
               Level _level;
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)(2.0D - immediatesourceentity.getPersistentData().getDouble("Time") / 140.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 10.0F, (float)(2.0D - immediatesourceentity.getPersistentData().getDouble("Time") / 140.0D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 25.0F, (float)(2.0D - immediatesourceentity.getPersistentData().getDouble("Time") / 140.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketfar")), SoundSource.NEUTRAL, 25.0F, (float)(2.0D - immediatesourceentity.getPersistentData().getDouble("Time") / 140.0D), false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0.1D, 0.1D, 0.1D, 0.01D);
            }

            _center = immediatesourceentity.getDeltaMovement().scale(1.02D);
            immediatesourceentity.setDeltaMovement(_center);
            immediatesourceentity.setNoGravity(true);
         } else {
            TankFireProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         if (immediatesourceentity.getPersistentData().getDouble("Time") >= 10.0D && speed > 8.0D) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x() * 0.9D, immediatesourceentity.getDeltaMovement().y() * 0.9D, immediatesourceentity.getDeltaMovement().z() * 0.9D));
         }

         mx = RadarVelocityX * 1.0D;
         my = RadarVelocityY * 1.0D;
         mz = RadarVelocityZ * 1.0D;
         distancetotarget = Math.sqrt(Math.pow(Math.abs(RadarTargetY - y), 2.0D) + Math.pow(Math.abs(RadarTargetX - x), 2.0D) + Math.pow(Math.abs(RadarTargetZ - z), 2.0D));
         speed = Math.sqrt(Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().x()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().y()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().z()), 2.0D));
         Limiter = 0.03D * speed;
         leadvariable = 1.0D;
         leadvariable = leadvariable * distancetotarget / speed;
         if (immediatesourceentity.getPersistentData().getDouble("Time") >= 10.0D && (0.0D != RadarTargetX || 0.0D != RadarTargetY || 0.0D != RadarTargetZ)) {
            immediatesourceentity.setDeltaMovement(new Vec3(Math.min(immediatesourceentity.getDeltaMovement().x() + Limiter, Math.max((immediatesourceentity.getDeltaMovement().x() * 7.0D + (RadarTargetX + mx * leadvariable - x) * speed / distancetotarget) / 8.0D, immediatesourceentity.getDeltaMovement().x() - Limiter)), Math.min(immediatesourceentity.getDeltaMovement().y() + Limiter, Math.max((immediatesourceentity.getDeltaMovement().y() * 7.0D + (RadarTargetY + my * leadvariable - y) * speed / distancetotarget) / 8.0D, immediatesourceentity.getDeltaMovement().y() - Limiter)), Math.min(immediatesourceentity.getDeltaMovement().z() + Limiter, Math.max((immediatesourceentity.getDeltaMovement().z() * 7.0D + (RadarTargetZ + mz * leadvariable - z) * speed / distancetotarget) / 8.0D, immediatesourceentity.getDeltaMovement().z() - Limiter))));
         }

         List _entfound;
         Iterator var54;
         Entity entityiterator;
         if (immediatesourceentity.getPersistentData().getDouble("Time") >= 10.0D) {
            _center = new Vec3(x, y, z);
            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(7.5D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            var54 = _entfound.iterator();

            while(var54.hasNext()) {
               entityiterator = (Entity)var54.next();
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
               TankFireProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }

            });
         }

         if (immediatesourceentity.isUnderWater()) {
            TankFireProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
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
         var54 = _entfound.iterator();

         while(var54.hasNext()) {
            entityiterator = (Entity)var54.next();
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
               TankFireProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
            });
         }

      }
   }
}
