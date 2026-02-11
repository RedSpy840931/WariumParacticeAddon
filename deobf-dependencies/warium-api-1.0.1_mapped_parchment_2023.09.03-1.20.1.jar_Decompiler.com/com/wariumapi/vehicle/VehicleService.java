package com.wariumapi.vehicle;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface VehicleService {
   Optional<VehicleControlNode> getNodeAt(Level var1, BlockPos var2);

   Optional<VehicleController> getVehicleController(Level var1, BlockPos var2);

   boolean isVehicleControlNode(BlockState var1);
}
