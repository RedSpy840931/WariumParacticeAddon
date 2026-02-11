package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.item.ItemStack;

public class AmmoCount1Procedure {
   public static String execute(ItemStack itemstack) {
      double Loaded = 0.0D;
      if (itemstack.getOrCreateTag().getBoolean("Loaded")) {
         Loaded = 1.0D;
      } else {
         Loaded = 0.0D;
      }

      return "§8Ammo: §6" + (new DecimalFormat("####")).format(Loaded) + "§8/§61";
   }
}
