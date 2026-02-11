package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.item.ItemStack;

public class AmmoCount100Procedure {
   public static String execute(ItemStack itemstack) {
      String var10000 = itemstack.getOrCreateTag().getString("AmmoType");
      return "§8Ammo: §4" + var10000 + " §6" + (new DecimalFormat("####")).format(itemstack.getOrCreateTag().getDouble("Ammo")) + "§8/§6100";
   }
}
