package net.mcreator.crustychunks.item;

import java.util.List;
import net.mcreator.crustychunks.procedures.AmmoCountPaintProcedure;
import net.mcreator.crustychunks.procedures.PaintToolFireProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class PaintToolItem extends Item {
   public PaintToolItem() {
      super((new Properties()).stacksTo(1).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      Entity entity = itemstack.getEntityRepresentation();
      String hoverText = AmmoCountPaintProcedure.execute(itemstack);
      if (hoverText != null) {
         String[] var7 = hoverText.split("\n");
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            String line = var7[var9];
            list.add(Component.literal(line));
         }
      }

   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      PaintToolFireProcedure.execute(context.getLevel(), (double)context.getClickedPos().getX(), (double)context.getClickedPos().getY(), (double)context.getClickedPos().getZ(), context.getItemInHand());
      return InteractionResult.SUCCESS;
   }
}
