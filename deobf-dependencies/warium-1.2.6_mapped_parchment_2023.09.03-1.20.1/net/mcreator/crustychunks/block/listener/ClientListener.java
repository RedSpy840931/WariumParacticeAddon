package net.mcreator.crustychunks.block.listener;

import net.mcreator.crustychunks.block.renderer.RACBarrelTileRenderer;
import net.mcreator.crustychunks.init.CrustyChunksModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "crusty_chunks",
   bus = Bus.MOD
)
public class ClientListener {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void registerRenderers(RegisterRenderers event) {
      event.registerBlockEntityRenderer((BlockEntityType)CrustyChunksModBlockEntities.RAC_BARREL.get(), (context) -> {
         return new RACBarrelTileRenderer();
      });
   }
}
