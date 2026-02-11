package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class SolarGeneratorTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Kinetic = 0.0D;
      if (world instanceof Level) {
         Level _lvl0 = (Level)world;
         if (_lvl0.isDay() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
            BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1.0D, z));
            int _amount = 10;
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                  capability.receiveEnergy(_amount, false);
               });
            }
         }
      }

   }
}
