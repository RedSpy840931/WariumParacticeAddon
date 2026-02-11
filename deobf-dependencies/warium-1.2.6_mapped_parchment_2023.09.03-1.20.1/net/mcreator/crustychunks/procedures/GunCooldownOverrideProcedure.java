package net.mcreator.crustychunks.procedures;

import net.minecraft.world.item.ItemStack;

public class GunCooldownOverrideProcedure {
   public static void execute(ItemStack itemstack) {
      if (itemstack.getOrCreateTag().getDouble("C") > 0.0D) {
         itemstack.getOrCreateTag().putDouble("C", itemstack.getOrCreateTag().getDouble("C") - 1.0D);
      }

   }
}
