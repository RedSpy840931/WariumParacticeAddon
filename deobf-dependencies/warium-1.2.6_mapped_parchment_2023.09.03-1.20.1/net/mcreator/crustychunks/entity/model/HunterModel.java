package net.mcreator.crustychunks.entity.model;

import net.mcreator.crustychunks.entity.HunterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class HunterModel extends GeoModel<HunterEntity> {
   public ResourceLocation getAnimationResource(HunterEntity entity) {
      return new ResourceLocation("crusty_chunks", "animations/hunter.animation.json");
   }

   public ResourceLocation getModelResource(HunterEntity entity) {
      return new ResourceLocation("crusty_chunks", "geo/hunter.geo.json");
   }

   public ResourceLocation getTextureResource(HunterEntity entity) {
      return new ResourceLocation("crusty_chunks", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(HunterEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("Head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
