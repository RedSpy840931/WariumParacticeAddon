package net.mcreator.crustychunks.procedures;

import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent.MouseButton.Post;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber({Dist.CLIENT})
public class SemiAutoReleaseProcedure {
   @SubscribeEvent
   public static void onRightClickReleased(Post event) {
      if (event.getButton() == 1 && event.getAction() == 0 && Minecraft.getInstance().screen == null) {
         CrustyChunksMod.PACKET_HANDLER.sendToServer(new SemiAutoReleaseProcedure.SemiAutoReleaseMessage());
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         boolean _setval = true;
         entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.clickrelease = _setval;
            capability.syncPlayerVariables(entity);
         });
      }
   }

   @EventBusSubscriber(
      bus = Bus.MOD
   )
   public static class SemiAutoReleaseMessage {
      public SemiAutoReleaseMessage() {
      }

      public SemiAutoReleaseMessage(FriendlyByteBuf buffer) {
      }

      public static void buffer(SemiAutoReleaseProcedure.SemiAutoReleaseMessage message, FriendlyByteBuf buffer) {
      }

      public static void handler(SemiAutoReleaseProcedure.SemiAutoReleaseMessage message, Supplier<Context> contextSupplier) {
         Context context = (Context)contextSupplier.get();
         context.enqueueWork(() -> {
            Entity sender = context.getSender();
            if (sender != null && sender.level().hasChunkAt(sender.blockPosition())) {
               SemiAutoReleaseProcedure.execute(sender);
            }

         });
         context.setPacketHandled(true);
      }

      @SubscribeEvent
      public static void registerMessage(FMLCommonSetupEvent event) {
         CrustyChunksMod.addNetworkMessage(SemiAutoReleaseProcedure.SemiAutoReleaseMessage.class, SemiAutoReleaseProcedure.SemiAutoReleaseMessage::buffer, SemiAutoReleaseProcedure.SemiAutoReleaseMessage::new, SemiAutoReleaseProcedure.SemiAutoReleaseMessage::handler);
      }
   }
}
