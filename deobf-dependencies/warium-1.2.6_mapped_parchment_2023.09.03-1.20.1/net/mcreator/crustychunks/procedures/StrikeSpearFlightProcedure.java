package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class StrikeSpearFlightProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean detonate = false;
         boolean Trigger = false;
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
         double TargX = 0.0D;
         double TargY = 0.0D;
         double TargZ = 0.0D;
         double startx = 0.0D;
         double starty = 0.0D;
         double startz = 0.0D;
         double vecx = 0.0D;
         double vecy = 0.0D;
         double vecz = 0.0D;
         double distancetostart = 0.0D;
         double beamlength = 0.0D;
         ForceChunksProcedure.execute(world, x, y, z);
         Lblock = world.getBlockState(BlockPos.containing(immediatesourceentity.getPersistentData().getDouble("LX"), immediatesourceentity.getPersistentData().getDouble("LY"), immediatesourceentity.getPersistentData().getDouble("LZ")));
         LX = immediatesourceentity.getPersistentData().getDouble("LX");
         LY = immediatesourceentity.getPersistentData().getDouble("LY");
         LZ = immediatesourceentity.getPersistentData().getDouble("LZ");
         immediatesourceentity.getPersistentData().putDouble("Time", immediatesourceentity.getPersistentData().getDouble("Time") + 1.0D);
         if (1.0D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.getValue(_dp);
               } else {
                  _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                        var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(Lblock).getStepX() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "X")) || 0.5D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.getValue(_dp);
               } else {
                  _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                        var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(Lblock).getStepZ() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(LX, LY, LZ), "Z"))) {
            beamlength = 600.0D;
            startx = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserStartX");
            starty = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserStartY");
            startz = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserStartZ");
            distancetostart = Math.sqrt(Math.pow(Math.abs(starty - y), 2.0D) + Math.pow(Math.abs(startx - x), 2.0D) + Math.pow(Math.abs(startz - z), 2.0D));
            vecx = (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserEndX") - startx) / beamlength;
            vecy = (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserEndY") - starty) / beamlength;
            vecz = (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserEndZ") - startz) / beamlength;
            TargX = (immediatesourceentity.getX() - (startx + vecx * (distancetostart + speed + 1.0D))) * -30.0D;
            TargY = (immediatesourceentity.getY() - (starty + vecy * (distancetostart + speed + 1.0D))) * -30.0D;
            TargZ = (immediatesourceentity.getZ() - (startz + vecz * (distancetostart + speed + 1.0D))) * -30.0D;
            distancetotarget = Math.sqrt(Math.pow(Math.abs(((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserEndY") - y), 2.0D) + Math.pow(Math.abs(((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserEndX") - x), 2.0D) + Math.pow(Math.abs(((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(LX, LY, LZ), "LaserEndZ") - z), 2.0D));
         }

         immediatesourceentity.getPersistentData().putDouble("MaxTime", 220.0D);
         Vec3 _center;
         if (immediatesourceentity.getPersistentData().getDouble("Time") <= 220.0D) {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_BULLET_TRAIL.get(), x, y, z, 0.0D, 0.0D, 0.0D);
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

            _center = immediatesourceentity.getDeltaMovement().scale(1.02D);
            immediatesourceentity.setDeltaMovement(_center);
            immediatesourceentity.setNoGravity(true);
            speed = Math.sqrt(Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().x()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().y()), 2.0D) + Math.pow(Math.abs(immediatesourceentity.getDeltaMovement().z()), 2.0D));
            Limiter = 0.1D * speed;
            if (immediatesourceentity.getPersistentData().getDouble("Time") > 5.0D && (TargX != 0.0D || TargY != 0.0D || TargZ != 0.0D)) {
               immediatesourceentity.setDeltaMovement(new Vec3(Math.min(immediatesourceentity.getDeltaMovement().x() + Limiter, Math.max(immediatesourceentity.getDeltaMovement().x() + TargX / distancetotarget, immediatesourceentity.getDeltaMovement().x() - Limiter)), Math.min(immediatesourceentity.getDeltaMovement().y() + Limiter, Math.max(immediatesourceentity.getDeltaMovement().y() + TargY / distancetotarget, immediatesourceentity.getDeltaMovement().y() - Limiter)), Math.min(immediatesourceentity.getDeltaMovement().z() + Limiter, Math.max(immediatesourceentity.getDeltaMovement().z() + TargZ / distancetotarget, immediatesourceentity.getDeltaMovement().z() - Limiter))));
            }
         } else {
            LargeHEATHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         if (speed > 5.0D && immediatesourceentity.getPersistentData().getDouble("Time") > 10.0D) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x() * 0.8D, immediatesourceentity.getDeltaMovement().y() * 0.8D, immediatesourceentity.getDeltaMovement().z() * 0.8D));
         }

         if (immediatesourceentity.isUnderWater()) {
            LargeHEATHitProcedure.execute(world, x, y, z, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

         _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(1.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.distanceToSqr(_center);
         })).toList();
         Iterator var63 = _entfound.iterator();

         while(var63.hasNext()) {
            Entity entityiterator = (Entity)var63.next();
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
               LargeHEATHitProcedure.execute(world, x, y, z, immediatesourceentity);
            });
         }

      }
   }
}
