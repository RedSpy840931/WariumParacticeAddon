package net.mcreator.crustychunks.procedures;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexBuffer.Usage;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.mojang.math.Axis;
import java.util.Iterator;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.entity.FusionEffectProjectileEntity;
import net.mcreator.crustychunks.entity.NuclearSecondaryEffectEntity;
import net.mcreator.crustychunks.entity.SpaceFusionThermalRadEntityEntity;
import net.mcreator.crustychunks.entity.SpaceThermalRadEntityEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.joml.Matrix4f;

@EventBusSubscriber({Dist.CLIENT})
public class FireBallRenderProcedure {
   private static BufferBuilder bufferBuilder = null;
   private static VertexBuffer vertexBuffer = null;
   private static Mode mode = null;
   private static VertexFormat format = null;
   private static PoseStack poseStack = null;
   private static Matrix4f projectionMatrix = null;
   private static boolean worldCoordinate = true;
   private static Vec3 offset;
   private static int currentStage;
   private static int targetStage;

   private static void add(double x, double y, double z, int color) {
      add(x, y, z, 0.0F, 0.0F, color);
   }

   private static void add(double x, double y, double z, float u, float v, int color) {
      if (bufferBuilder != null && bufferBuilder.building()) {
         if (format == DefaultVertexFormat.POSITION_COLOR) {
            bufferBuilder.vertex(x, y, z).color(color).endVertex();
         } else if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
            bufferBuilder.vertex(x, y, z).uv(u, v).color(color).endVertex();
         }

      }
   }

   private static boolean begin(Mode mode, VertexFormat format, boolean update) {
      if (bufferBuilder == null || !bufferBuilder.building()) {
         if (update) {
            clear();
         }

         if (vertexBuffer == null) {
            if (format == DefaultVertexFormat.POSITION_COLOR) {
               FireBallRenderProcedure.mode = mode;
               FireBallRenderProcedure.format = format;
               bufferBuilder = Tesselator.getInstance().getBuilder();
               bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_COLOR);
               return true;
            }

            if (format == DefaultVertexFormat.POSITION_TEX_COLOR) {
               FireBallRenderProcedure.mode = mode;
               FireBallRenderProcedure.format = format;
               bufferBuilder = Tesselator.getInstance().getBuilder();
               bufferBuilder.begin(mode, DefaultVertexFormat.POSITION_TEX_COLOR);
               return true;
            }
         }
      }

      return false;
   }

   private static void clear() {
      if (vertexBuffer != null) {
         vertexBuffer.close();
         vertexBuffer = null;
      }

   }

   private static void end() {
      if (bufferBuilder != null && bufferBuilder.building()) {
         if (vertexBuffer != null) {
            vertexBuffer.close();
         }

         vertexBuffer = new VertexBuffer(Usage.STATIC);
         vertexBuffer.bind();
         vertexBuffer.upload(bufferBuilder.end());
         VertexBuffer.unbind();
      }
   }

   private static void offset(double x, double y, double z) {
      offset = new Vec3(x, y, z);
   }

   private static void release() {
      targetStage = 0;
   }

   private static VertexBuffer shape() {
      return vertexBuffer;
   }

   private static void system(boolean worldCoordinate) {
      FireBallRenderProcedure.worldCoordinate = worldCoordinate;
   }

   private static boolean target(int targetStage) {
      if (targetStage == currentStage) {
         FireBallRenderProcedure.targetStage = targetStage;
         return true;
      } else {
         return false;
      }
   }

   private static void renderShape(VertexBuffer vertexBuffer, double x, double y, double z, float yaw, float pitch, float roll, float xScale, float yScale, float zScale, int color) {
      if (currentStage != 0 && currentStage == targetStage) {
         if (poseStack != null && projectionMatrix != null) {
            if (vertexBuffer != null) {
               float i;
               float j;
               float k;
               if (worldCoordinate) {
                  Vec3 pos = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
                  i = (float)(x - pos.x());
                  j = (float)(y - pos.y());
                  k = (float)(z - pos.z());
               } else {
                  i = (float)x;
                  j = (float)y;
                  k = (float)z;
               }

               poseStack.pushPose();
               poseStack.translate(i, j, k);
               poseStack.mulPose(Axis.YN.rotationDegrees(yaw));
               poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
               poseStack.mulPose(Axis.ZN.rotationDegrees(roll));
               poseStack.scale(xScale, yScale, zScale);
               poseStack.translate(offset.x(), offset.y(), offset.z());
               RenderSystem.setShaderColor((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F, (float)(color >>> 24) / 255.0F);
               vertexBuffer.bind();
               vertexBuffer.drawWithShader(poseStack.last().pose(), projectionMatrix, vertexBuffer.getFormat().hasUV(0) ? GameRenderer.getPositionTexColorShader() : GameRenderer.getPositionColorShader());
               VertexBuffer.unbind();
               RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
               poseStack.popPose();
            }
         }
      }
   }

   @SubscribeEvent
   public static void renderLevel(RenderLevelStageEvent event) {
      if (event.getStage() == Stage.AFTER_SKY) {
         currentStage = 1;
         RenderSystem.depthMask(false);
         renderShapes(event);
         RenderSystem.enableCull();
         RenderSystem.depthMask(true);
         currentStage = 0;
      } else if (event.getStage() == Stage.AFTER_PARTICLES) {
         currentStage = 2;
         RenderSystem.depthMask(true);
         renderShapes(event);
         RenderSystem.enableCull();
         RenderSystem.depthMask(true);
         currentStage = 0;
      }

   }

   private static void renderShapes(RenderLevelStageEvent event) {
      Minecraft minecraft = Minecraft.getInstance();
      ClientLevel level = minecraft.level;
      Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
      if (level != null && entity != null) {
         poseStack = event.getPoseStack();
         projectionMatrix = event.getProjectionMatrix();
         entity.getPosition(event.getPartialTick());
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         execute(event, level);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableBlend();
         RenderSystem.enableDepthTest();
      }

   }

   public static void execute(LevelAccessor world) {
      execute((Event)null, world);
   }

   private static void execute(@Nullable Event event, LevelAccessor world) {
      double scale = 0.0D;
      double pitch = 0.0D;
      double Yaw = 0.0D;
      if (world instanceof ClientLevel) {
         Iterator var8 = ((ClientLevel)world).entitiesForRendering().iterator();

         while(true) {
            Entity entityiterator;
            do {
               if (!var8.hasNext()) {
                  return;
               }

               entityiterator = (Entity)var8.next();
               Yaw = Math.atan2(Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().x() - entityiterator.getX(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().z() - entityiterator.getZ()) * 57.29577951308232D * -1.0D + 180.0D;
               pitch = Math.atan2(Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().y() - entityiterator.getY(), Math.sqrt(Math.pow(Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().x() - entityiterator.getX(), 2.0D) + Math.pow(Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().z() - entityiterator.getZ(), 2.0D))) * 57.29577951308232D * 1.0D - 90.0D;
               if (entityiterator instanceof NuclearSecondaryEffectEntity) {
                  scale = Math.max(250.0D - entityiterator.getPersistentData().getDouble("T") / 2.0D, 0.0D);
                  if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR, false)) {
                     add(0.5D, 0.0D, 0.5D, 0.0F, 0.0F, -1);
                     add(0.5D, 0.0D, -0.5D, 0.0F, 1.0F, -1);
                     add(-0.5D, 0.0D, -0.5D, 1.0F, 1.0F, -1);
                     add(-0.5D, 0.0D, 0.5D, 1.0F, 0.0F, -1);
                     end();
                  }

                  if (target(2)) {
                     RenderSystem.depthMask(false);
                     RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA);
                     RenderSystem.setShaderTexture(0, new ResourceLocation("crusty_chunks:textures/yellowglare.png"));
                     renderShape(shape(), entityiterator.getX(), entityiterator.getY() + entityiterator.getPersistentData().getDouble("T") / 10.0D, entityiterator.getZ(), (float)Yaw, (float)pitch, 0.0F, (float)scale, (float)scale, (float)scale, -1);
                     release();
                  }

                  clear();
               }

               if (entityiterator instanceof FusionEffectProjectileEntity) {
                  scale = Math.max(450.0D - entityiterator.getPersistentData().getDouble("T") / 2.0D, 0.0D);
                  if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR, false)) {
                     add(0.5D, 0.0D, 0.5D, 0.0F, 0.0F, -1);
                     add(0.5D, 0.0D, -0.5D, 0.0F, 1.0F, -1);
                     add(-0.5D, 0.0D, -0.5D, 1.0F, 1.0F, -1);
                     add(-0.5D, 0.0D, 0.5D, 1.0F, 0.0F, -1);
                     end();
                  }

                  if (target(2)) {
                     RenderSystem.depthMask(false);
                     RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA);
                     RenderSystem.setShaderTexture(0, new ResourceLocation("crusty_chunks:textures/purpleglare.png"));
                     renderShape(shape(), entityiterator.getX(), entityiterator.getY() + entityiterator.getPersistentData().getDouble("T") / 10.0D, entityiterator.getZ(), (float)Yaw, (float)pitch, 0.0F, (float)scale, (float)scale, (float)scale, -1);
                     release();
                  }

                  clear();
               }

               if (entityiterator instanceof SpaceFusionThermalRadEntityEntity || entityiterator instanceof SpaceThermalRadEntityEntity) {
                  scale = Math.max(500.0D - entityiterator.getPersistentData().getDouble("T") * 2.0D, 0.0D);
                  if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR, false)) {
                     add(0.5D, 0.0D, 0.5D, 0.0F, 0.0F, -1);
                     add(0.5D, 0.0D, -0.5D, 0.0F, 1.0F, -1);
                     add(-0.5D, 0.0D, -0.5D, 1.0F, 1.0F, -1);
                     add(-0.5D, 0.0D, 0.5D, 1.0F, 0.0F, -1);
                     end();
                  }

                  if (target(2)) {
                     RenderSystem.depthMask(false);
                     RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA);
                     RenderSystem.setShaderTexture(0, new ResourceLocation("crusty_chunks:textures/blueglare.png"));
                     renderShape(shape(), entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (float)Yaw, (float)pitch, 0.0F, (float)scale, (float)scale, (float)scale, -1);
                     release();
                  }

                  clear();
                  scale = Math.max(255.0D - entityiterator.getPersistentData().getDouble("T") * 1.0D, 0.0D);
                  if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, false)) {
                     add(0.5D, -0.5D, -0.5D, -1);
                     add(0.5D, -0.5D, 0.5D, -1);
                     add(-0.5D, -0.5D, 0.5D, -1);
                     add(-0.5D, -0.5D, -0.5D, -1);
                     add(0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, -0.5D, -1);
                     add(0.5D, -0.5D, -0.5D, -1);
                     add(-0.5D, -0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, 0.5D, -1);
                     add(-0.5D, -0.5D, 0.5D, -1);
                     add(0.5D, -0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, -0.5D, 0.5D, -1);
                     add(0.5D, -0.5D, -0.5D, -1);
                     add(0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, -0.5D, -0.5D, -1);
                     add(-0.5D, -0.5D, 0.5D, -1);
                     add(-0.5D, 0.5D, 0.5D, -1);
                     end();
                  }

                  if (target(1)) {
                     RenderSystem.disableDepthTest();
                     RenderSystem.depthMask(false);
                     RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
                     renderShape(shape(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().x(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().y(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().z(), 0.0F, 0.0F, 0.0F, -2.0F, -1.0F, -1.0F, (int)Math.max(Math.min(200.0D, scale), 0.0D) << 24 | (int)Math.min(255.0D, scale) << 16 | (int)Math.min(255.0D, scale) << 8 | 255);
                     release();
                  }

                  clear();
                  if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, false)) {
                     add(0.5D, -0.5D, -0.5D, -1);
                     add(0.5D, -0.5D, 0.5D, -1);
                     add(-0.5D, -0.5D, 0.5D, -1);
                     add(-0.5D, -0.5D, -0.5D, -1);
                     add(0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, -0.5D, -1);
                     add(0.5D, -0.5D, -0.5D, -1);
                     add(-0.5D, -0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, 0.5D, -1);
                     add(-0.5D, -0.5D, 0.5D, -1);
                     add(0.5D, -0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, 0.5D, 0.5D, -1);
                     add(0.5D, -0.5D, 0.5D, -1);
                     add(0.5D, -0.5D, -0.5D, -1);
                     add(0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, 0.5D, -0.5D, -1);
                     add(-0.5D, -0.5D, -0.5D, -1);
                     add(-0.5D, -0.5D, 0.5D, -1);
                     add(-0.5D, 0.5D, 0.5D, -1);
                     end();
                  }

                  if (target(2)) {
                     RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
                     renderShape(shape(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().x(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().y(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().z(), 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, -1.0F, (int)Math.max(scale / 3.0D, 0.0D) << 24 | (int)scale << 16 | (int)scale << 8 | 255);
                     release();
                  }

                  clear();
               }
            } while(!(entityiterator instanceof NuclearSecondaryEffectEntity) && !(entityiterator instanceof FusionEffectProjectileEntity));

            scale = Math.max(255.0D - entityiterator.getPersistentData().getDouble("T") * 1.0D, 0.0D);
            if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, false)) {
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               end();
            }

            if (target(1)) {
               RenderSystem.disableDepthTest();
               RenderSystem.depthMask(false);
               RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
               renderShape(shape(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().x(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().y(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().z(), 0.0F, 0.0F, 0.0F, -2.0F, -1.0F, -1.0F, (int)Math.max(Math.min(200.0D, scale), 0.0D) << 24 | 16711680 | (int)Math.min(255.0D, scale) << 8 | (int)Math.min(255.0D, scale));
               release();
            }

            clear();
            if (begin(Mode.QUADS, DefaultVertexFormat.POSITION_COLOR, false)) {
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, 0.5D, 0.5D, -1);
               add(0.5D, -0.5D, 0.5D, -1);
               add(0.5D, -0.5D, -0.5D, -1);
               add(0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, 0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, -0.5D, -1);
               add(-0.5D, -0.5D, 0.5D, -1);
               add(-0.5D, 0.5D, 0.5D, -1);
               end();
            }

            if (target(2)) {
               RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ONE, DestFactor.ZERO);
               renderShape(shape(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().x(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().y(), Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().z(), 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, -1.0F, (int)Math.max(scale / 2.0D, 0.0D) << 24 | 16711680 | (int)scale << 8 | (int)scale);
               release();
            }

            clear();
         }
      }
   }

   static {
      offset = Vec3.ZERO;
      currentStage = 0;
      targetStage = 0;
   }
}
