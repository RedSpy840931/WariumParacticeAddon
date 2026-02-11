package com.wariumapi.vs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public interface ShipController {
   void addForce(BlockPos var1, Vec3 var2, double var3, ForceMode var5, ForceDirectionMode var6);

   void addRotation(Vec3 var1, ForceMode var2);

   void setNumber(String var1, Number var2);

   void setBoolean(String var1, boolean var2);

   void setString(String var1, String var2);
}
