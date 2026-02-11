package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class LKYProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         boolean _setval = true;
         entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.LeftKey = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }
}
