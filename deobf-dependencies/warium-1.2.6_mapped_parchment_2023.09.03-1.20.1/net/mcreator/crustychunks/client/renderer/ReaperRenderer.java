package net.mcreator.crustychunks.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.crustychunks.client.model.ModelReaper;
import net.mcreator.crustychunks.entity.ReaperEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class ReaperRenderer extends MobRenderer<ReaperEntity, ModelReaper<ReaperEntity>> {
   public ReaperRenderer(Context context) {
      super(context, new ModelReaper(context.bakeLayer(ModelReaper.LAYER_LOCATION)), 4.0F);
      this.addLayer(new RenderLayer<ReaperEntity, ModelReaper<ReaperEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("crusty_chunks:textures/entities/reaperglow.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, ReaperEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(this.LAYER_TEXTURE));
            ((ModelReaper)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   protected void scale(ReaperEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(1.5F, 1.5F, 1.5F);
   }

   public ResourceLocation getTextureLocation(ReaperEntity entity) {
      return new ResourceLocation("crusty_chunks:textures/entities/reaper.png");
   }
}
