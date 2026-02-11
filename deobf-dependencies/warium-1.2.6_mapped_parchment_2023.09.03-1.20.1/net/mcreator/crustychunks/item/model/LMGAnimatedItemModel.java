package net.mcreator.crustychunks.item.model;

import net.mcreator.crustychunks.item.LMGAnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LMGAnimatedItemModel extends GeoModel<LMGAnimatedItem> {
   public ResourceLocation getAnimationResource(LMGAnimatedItem animatable) {
      return new ResourceLocation("crusty_chunks", "animations/lmg.animation.json");
   }

   public ResourceLocation getModelResource(LMGAnimatedItem animatable) {
      return new ResourceLocation("crusty_chunks", "geo/lmg.geo.json");
   }

   public ResourceLocation getTextureResource(LMGAnimatedItem animatable) {
      return new ResourceLocation("crusty_chunks", "textures/item/lmgtexture.png");
   }
}
