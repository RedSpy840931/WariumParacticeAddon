package net.mcreator.crustychunks.procedures;

import net.minecraft.world.item.ItemStack;

public class SMGDoubleFireProcedure {
   public static void execute(ItemStack itemstack) {
      if (itemstack.getOrCreateTag().getDouble("ShotQue") == 0.0D) {
         itemstack.getOrCreateTag().putDouble("ShotQue", 4.0D);
      }

   }
}
