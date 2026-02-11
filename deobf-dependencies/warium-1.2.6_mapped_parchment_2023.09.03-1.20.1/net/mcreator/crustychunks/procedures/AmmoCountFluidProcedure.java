package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class AmmoCountFluidProcedure {
   public static String execute(ItemStack itemstack) {
      DecimalFormat var10000 = new DecimalFormat("####");
      CompoundTag var10001 = itemstack.getOrCreateTag();
      return "§8Fluid §6" + var10000.format(var10001.getDouble("Fluid")) + "§8/§61000";
   }
}
