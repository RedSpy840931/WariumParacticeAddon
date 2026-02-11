package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class ReturnPowerProcedure {
   public static String execute(LevelAccessor world, double x, double y, double z) {
      String var10000 = (new DecimalFormat("####")).format((long)((<undefinedtype>)(new Object() {
         public int getEnergyStored(LevelAccessor level, BlockPos pos) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getEnergyStored());
               });
            }

            return _retval.get();
         }
      })).getEnergyStored(world, BlockPos.containing(x, y, z)));
      return var10000 + "/" + (new DecimalFormat("####")).format((long)((<undefinedtype>)(new Object() {
         public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getMaxEnergyStored());
               });
            }

            return _retval.get();
         }
      })).getMaxEnergyStored(world, BlockPos.containing(x, y, z)));
   }
}
