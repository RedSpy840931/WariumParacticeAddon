package net.mcreator.crustychunks.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModelTorpedo_Converted<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("crusty_chunks", "model_torpedo_converted"), "main");
   public final ModelPart Thruster;
   public final ModelPart Warhead;
   public final ModelPart Core;

   public ModelTorpedo_Converted(ModelPart root) {
      this.Thruster = root.getChild("Thruster");
      this.Warhead = root.getChild("Warhead");
      this.Core = root.getChild("Core");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      partdefinition.addOrReplaceChild("Thruster", CubeListBuilder.create().texOffs(0, 55).addBox(-12.0F, -6.0F, 4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(20, 58).addBox(-9.0F, -6.0F, 2.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(36, 43).addBox(-14.0F, -16.0F, 2.0F, 12.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-14.0F, -6.0F, 7.0F, 12.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));
      partdefinition.addOrReplaceChild("Warhead", CubeListBuilder.create().texOffs(0, 28).addBox(-14.0F, -47.0F, 2.0F, 12.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(64, 16).addBox(-11.0F, -48.0F, 5.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));
      partdefinition.addOrReplaceChild("Core", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -32.0F, 2.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(36, 12).addBox(-11.0F, -29.0F, 0.0F, 6.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(64, 0).addBox(-16.0F, -29.0F, 5.0F, 16.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));
      return LayerDefinition.create(meshdefinition, 128, 128);
   }

   public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.Thruster.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Warhead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.Core.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
