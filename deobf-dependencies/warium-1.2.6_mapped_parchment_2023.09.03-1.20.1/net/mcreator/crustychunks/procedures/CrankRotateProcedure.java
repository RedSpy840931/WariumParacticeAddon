package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class CrankRotateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      Property var9 = blockstate.getBlock().getStateDefinition().getProperty("positioned");
      if (var9 instanceof BooleanProperty) {
         BooleanProperty _getbp1 = (BooleanProperty)var9;
         if ((Boolean)blockstate.getValue(_getbp1)) {
            return;
         }
      }

      BlockPos _pos = BlockPos.containing(x, y, z);
      BlockState _bs = world.getBlockState(_pos);
      Property var12 = _bs.getBlock().getStateDefinition().getProperty("positioned");
      if (var12 instanceof BooleanProperty) {
         BooleanProperty _booleanProp = (BooleanProperty)var12;
         world.setBlock(_pos, (BlockState)_bs.setValue(_booleanProp, true), 3);
      }

      CrustyChunksMod.queueServerWork(1, () -> {
         Direction _dir = ((<undefinedtype>)(new Object() {
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
         })).getDirection(BlockPos.containing(x, y, z)).getClockWise(Axis.Y).getClockWise(Axis.Y);
         BlockPos _pos = BlockPos.containing(x, y, z);
         BlockState _bs = world.getBlockState(_pos);
         Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
         if (_property instanceof DirectionProperty) {
            DirectionProperty _dp = (DirectionProperty)_property;
            if (_dp.getPossibleValues().contains(_dir)) {
               world.setBlock(_pos, (BlockState)_bs.setValue(_dp, _dir), 3);
               return;
            }
         }

         _property = _bs.getBlock().getStateDefinition().getProperty("axis");
         if (_property instanceof EnumProperty) {
            EnumProperty _ap = (EnumProperty)_property;
            if (_ap.getPossibleValues().contains(_dir.getAxis())) {
               world.setBlock(_pos, (BlockState)_bs.setValue(_ap, _dir.getAxis()), 3);
            }
         }

      });
   }
}
