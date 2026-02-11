package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ClusterBombProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

public class ClusterBombDropProcedure {
   public static void execute(final LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x + 0.5D, y - 1.0D, z + 0.5D)).getBlock() == Blocks.AIR) {
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new ClusterBombProjectileEntity((EntityType)CrustyChunksModEntities.CLUSTER_BOMB_PROJECTILE.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 5.0F, 1);
            _entityToSpawn.setPos(x + 0.5D, y - 0.9D, z + 0.5D);
            _entityToSpawn.shoot((double)((<undefinedtype>)(new Object() {
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
            })).getDirection(BlockPos.containing(x, y, z)).getStepX(), (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(BlockPos.containing(x, y, z)).getStepY(), (double)((<undefinedtype>)(new Object() {
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
            })).getDirection(BlockPos.containing(x, y, z)).getStepZ(), 0.2F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
      } else {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
         MediumExplosionProcedure.execute(world, x, y, z);
      }

   }
}
