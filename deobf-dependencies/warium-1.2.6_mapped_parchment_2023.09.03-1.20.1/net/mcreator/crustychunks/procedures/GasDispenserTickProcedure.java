package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import net.mcreator.crustychunks.entity.ToxicCloudDetectorEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GasDispenserTickProcedure {
   public static void execute(final LevelAccessor world, double x, double y, double z) {
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      Level _level;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") <= 0.0D) {
         if (null != (Entity)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x + 0.5D, y, z + 0.5D), 5.0D, 5.0D, 5.0D), (e) -> {
            return true;
         }).stream().sorted(((<undefinedtype>)(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.distanceToSqr(_x, _y, _z);
               });
            }
         })).compareDistOf(x + 0.5D, y, z + 0.5D)).findFirst().orElse((Object)null)) {
            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Cooldown", 120.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
               }
            }
         }
      } else if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("Cooldown", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") - 1.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") >= 110.0D && world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 1.6D, 1.8D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 1.6D, 1.8D), false);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") == 110.0D) {
         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new ToxicCloudDetectorEntity((EntityType)CrustyChunksModEntities.TOXIC_CLOUD_DETECTOR.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(_level, 5.0F, 1);
            _entityToSpawn.setPos(x + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.getBlockState(pos);
                  Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (property != null) {
                     Comparable var5 = _bs.getValue(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                     return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                  } else {
                     return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS) ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.containing(x, y, z)).getStepX() + 0.5D, y + 0.5D, z + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.getBlockState(pos);
                  Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (property != null) {
                     Comparable var5 = _bs.getValue(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                     return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                  } else {
                     return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS) ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.containing(x, y, z)).getStepZ() + 0.5D);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 1.0F, 0.0F);
            _level.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.GAS_CLOUD.get(), x + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.getBlockState(pos);
                  Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (property != null) {
                     Comparable var5 = _bs.getValue(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                     return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                  } else {
                     return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS) ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.containing(x, y, z)).getStepX() + 0.5D, y + 0.5D, z + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockPos pos) {
                  BlockState _bs = world.getBlockState(pos);
                  Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (property != null) {
                     Comparable var5 = _bs.getValue(property);
                     if (var5 instanceof Direction) {
                        Direction _dir = (Direction)var5;
                        return _dir;
                     }
                  }

                  if (_bs.hasProperty(BlockStateProperties.AXIS)) {
                     return Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.AXIS), AxisDirection.POSITIVE);
                  } else {
                     return _bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS) ? Direction.fromAxisAndDirection((Axis)_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), AxisDirection.POSITIVE) : Direction.NORTH;
                  }
               }
            })).getDirection(BlockPos.containing(x, y, z)).getStepZ() + 0.5D, 25, 0.0D, 0.0D, 0.0D, 0.25D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.NEUTRAL, 4.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
            }
         }
      }

   }
}
