package net.mcreator.crustychunks.init;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CrustyChunksModFuels {
   @SubscribeEvent
   public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
      ItemStack itemstack = event.getItemStack();
      if (itemstack.getItem() == CrustyChunksModItems.OIL_BUCKET.get()) {
         event.setBurnTime(2000);
      } else if (itemstack.getItem() == CrustyChunksModItems.DIESEL_BUCKET.get()) {
         event.setBurnTime(2400);
      } else if (itemstack.getItem() == CrustyChunksModItems.KEROSENE_BUCKET.get()) {
         event.setBurnTime(3600);
      } else if (itemstack.getItem() == CrustyChunksModItems.PETROLIUM_BUCKET.get()) {
         event.setBurnTime(2600);
      } else if (itemstack.getItem() == CrustyChunksModItems.SHALE_OIL.get()) {
         event.setBurnTime(40);
      }

   }
}
