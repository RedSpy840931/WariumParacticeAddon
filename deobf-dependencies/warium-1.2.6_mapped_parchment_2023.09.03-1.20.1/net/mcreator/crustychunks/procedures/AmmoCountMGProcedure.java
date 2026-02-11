package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.item.ItemStack;

public class AmmoCountMGProcedure {
   public static String execute(ItemStack itemstack) {
      String Type = "";
      double capacity = 0.0D;
      capacity = 200.0D;
      if (itemstack.getOrCreateTag().getDouble("AmmoSize") == 0.0D) {
         Type = "Large ";
      } else if (itemstack.getOrCreateTag().getDouble("AmmoSize") == 1.0D) {
         Type = "XL ";
      } else if (itemstack.getOrCreateTag().getDouble("AmmoSize") == -1.0D) {
         Type = "Medium";
         capacity = 400.0D;
      }

      return "§8Ammo: §4" + Type + " §6" + (new DecimalFormat("####")).format(itemstack.getOrCreateTag().getDouble("Ammo")) + "§8/§6" + (new DecimalFormat("####")).format(capacity);
   }
}
