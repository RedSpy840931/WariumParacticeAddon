package net.mcreator.crustychunks.item.model;

import net.mcreator.crustychunks.item.AutoPistolItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AutoPistolItemModel extends GeoModel<AutoPistolItem> {
   public ResourceLocation getAnimationResource(AutoPistolItem animatable) {
      return new ResourceLocation("crusty_chunks", "animations/autopistol.animation.json");
   }

   public ResourceLocation getModelResource(AutoPistolItem animatable) {
      return new ResourceLocation("crusty_chunks", "geo/autopistol.geo.json");
   }

   public ResourceLocation getTextureResource(AutoPistolItem animatable) {
      return new ResourceLocation("crusty_chunks", "textures/item/autopistol.png");
   }
}
