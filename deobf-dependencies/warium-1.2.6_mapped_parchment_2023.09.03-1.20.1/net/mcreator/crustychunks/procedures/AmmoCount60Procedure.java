package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class AmmoCount60Procedure {
   public static String execute(ItemStack itemstack) {
      DecimalFormat var10000 = new DecimalFormat("####");
      CompoundTag var10001 = itemstack.getOrCreateTag();
      return "§8Ammo: §6" + var10000.format(var10001.getDouble("Ammo")) + "§8/§660";
   }
}
