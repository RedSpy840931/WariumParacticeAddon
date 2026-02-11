package net.mcreator.crustychunks.procedures;

import net.minecraft.world.item.ItemStack;

public class MagazineLevelProcedure {
   public static double execute(ItemStack itemstack) {
      return itemstack.getOrCreateTag().getDouble("Ammo");
   }
}
