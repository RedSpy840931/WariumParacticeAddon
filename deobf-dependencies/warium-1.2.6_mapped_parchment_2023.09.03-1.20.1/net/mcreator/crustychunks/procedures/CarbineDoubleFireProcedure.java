package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CarbineDoubleFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.getOrCreateTag().getDouble("Firemode") == 0.0D) {
            MCFireScriptProcedure.execute(world, x, y, z, entity, itemstack);
            itemstack.getOrCreateTag().putDouble("ShotQue", 0.0D);
         } else if (itemstack.getOrCreateTag().getDouble("Firemode") == 1.0D && itemstack.getOrCreateTag().getDouble("ShotQue") == 0.0D) {
            itemstack.getOrCreateTag().putDouble("ShotQue", 4.0D);
         }

      }
   }
}
