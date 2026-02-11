package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.item.ItemStack;

public class DirectionLogProcedure {
   public static String execute(ItemStack itemstack) {
      String WeaponAttatched = "";
      String ATGMMode = "";
      String Mode = "";
      if (itemstack.getOrCreateTag().getDouble("POSX") == 0.0D && itemstack.getOrCreateTag().getDouble("POSY") == 0.0D && itemstack.getOrCreateTag().getDouble("POSZ") == 0.0D) {
         WeaponAttatched = " ";
      } else {
         WeaponAttatched = "§3Weapon Attached";
      }

      if (itemstack.getOrCreateTag().getBoolean("Mode")) {
         Mode = "§9Mouse-Aim Mode";
      } else {
         Mode = " ";
      }

      String var10000 = (new DecimalFormat("####")).format(itemstack.getOrCreateTag().getDouble("Pitch"));
      return "§8Pitch: §6" + var10000 + "§8Yaw:§6" + (new DecimalFormat("####")).format(itemstack.getOrCreateTag().getDouble("Yaw")) + WeaponAttatched + Mode + "§7 Shift-Click on an Aimer Node while the item is in your off hand for linking.";
   }
}
