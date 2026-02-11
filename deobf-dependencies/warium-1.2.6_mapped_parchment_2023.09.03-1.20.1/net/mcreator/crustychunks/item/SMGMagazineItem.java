package net.mcreator.crustychunks.item;

import java.util.List;
import net.mcreator.crustychunks.procedures.AmmoCount40Procedure;
import net.mcreator.crustychunks.procedures.SMGMagazineScriptProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class SMGMagazineItem extends Item {
   public SMGMagazineItem() {
      super((new Properties()).stacksTo(1).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      Entity entity = itemstack.getEntityRepresentation();
      String hoverText = AmmoCount40Procedure.execute(itemstack);
      if (hoverText != null) {
         String[] var7 = hoverText.split("\n");
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            String line = var7[var9];
            list.add(Component.literal(line));
         }
      }

   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      SMGMagazineScriptProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }
}
