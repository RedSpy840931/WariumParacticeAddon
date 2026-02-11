package net.mcreator.crustychunks.item.model;

import net.mcreator.crustychunks.item.MachineCarbineItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MachineCarbineItemModel extends GeoModel<MachineCarbineItem> {
   public ResourceLocation getAnimationResource(MachineCarbineItem animatable) {
      return new ResourceLocation("crusty_chunks", "animations/carbine.animation.json");
   }

   public ResourceLocation getModelResource(MachineCarbineItem animatable) {
      return new ResourceLocation("crusty_chunks", "geo/carbine.geo.json");
   }

   public ResourceLocation getTextureResource(MachineCarbineItem animatable) {
      return new ResourceLocation("crusty_chunks", "textures/item/machinecarbine.png");
   }
}
