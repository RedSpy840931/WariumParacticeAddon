package net.mcreator.crustychunks.block.model;

import net.mcreator.crustychunks.block.display.RACBarrelDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RACBarrelDisplayModel extends GeoModel<RACBarrelDisplayItem> {
   public ResourceLocation getAnimationResource(RACBarrelDisplayItem animatable) {
      return new ResourceLocation("crusty_chunks", "animations/racbarrel.animation.json");
   }

   public ResourceLocation getModelResource(RACBarrelDisplayItem animatable) {
      return new ResourceLocation("crusty_chunks", "geo/racbarrel.geo.json");
   }

   public ResourceLocation getTextureResource(RACBarrelDisplayItem entity) {
      return new ResourceLocation("crusty_chunks", "textures/block/racbarrel.png");
   }
}
