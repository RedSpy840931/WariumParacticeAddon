package net.mcreator.crustychunks.item.model;

import net.mcreator.crustychunks.item.BreakActionShotgunAnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BreakActionShotgunAnimatedItemModel extends GeoModel<BreakActionShotgunAnimatedItem> {
   public ResourceLocation getAnimationResource(BreakActionShotgunAnimatedItem animatable) {
      return new ResourceLocation("crusty_chunks", "animations/breakshotgun.animation.json");
   }

   public ResourceLocation getModelResource(BreakActionShotgunAnimatedItem animatable) {
      return new ResourceLocation("crusty_chunks", "geo/breakshotgun.geo.json");
   }

   public ResourceLocation getTextureResource(BreakActionShotgunAnimatedItem animatable) {
      return new ResourceLocation("crusty_chunks", "textures/item/breakactionshotgun.png");
   }
}
