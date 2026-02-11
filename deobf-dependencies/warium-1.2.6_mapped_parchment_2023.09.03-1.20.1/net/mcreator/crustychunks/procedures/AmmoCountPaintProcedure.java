package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.world.item.ItemStack;

public class AmmoCountPaintProcedure {
   public static String execute(ItemStack itemstack) {
      String Type = "";
      if (itemstack.getOrCreateTag().getString("Color").equals("")) {
         Type = "§8NONE";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("none")) {
         Type = "§8NONE";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("remove")) {
         Type = "§8Remover";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("black")) {
         Type = "§0Black";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("white")) {
         Type = "§fWhite";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("light_gray")) {
         Type = "§7Light Gray";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("gray")) {
         Type = "§8Gray";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("red")) {
         Type = "§4Red";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("lime")) {
         Type = "§aLime";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("brown")) {
         Type = "§6Brown";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("orange")) {
         Type = "§6Orange";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("yellow")) {
         Type = "§eYellow";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("blue")) {
         Type = "§9Blue";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("green")) {
         Type = "§2Green";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("cyan")) {
         Type = "§3Cyan";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("light_blue")) {
         Type = "§bLight Blue";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("pink")) {
         Type = "§cPink";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("magenta")) {
         Type = "§dMagenta";
      }

      if (itemstack.getOrCreateTag().getString("Color").equals("Purple")) {
         Type = "§5Purple";
      }

      String var10000 = (new DecimalFormat("####")).format(itemstack.getOrCreateTag().getDouble("Fluid"));
      return "§8Fluid §6" + var10000 + "§8/§6100 Type: " + Type;
   }
}
