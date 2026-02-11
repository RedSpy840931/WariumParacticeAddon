package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.client.model.ModelAPFSDS;
import net.mcreator.crustychunks.client.model.ModelArmorPeelerRocket_Converted;
import net.mcreator.crustychunks.client.model.ModelBlockBusterBomb;
import net.mcreator.crustychunks.client.model.ModelBomber;
import net.mcreator.crustychunks.client.model.ModelFireSpearRocket_Converted;
import net.mcreator.crustychunks.client.model.ModelFissionBomb;
import net.mcreator.crustychunks.client.model.ModelFlamePack;
import net.mcreator.crustychunks.client.model.ModelFusionBomb;
import net.mcreator.crustychunks.client.model.ModelGasHelmet;
import net.mcreator.crustychunks.client.model.ModelGasmask_Converted_Converted;
import net.mcreator.crustychunks.client.model.ModelHEATFS;
import net.mcreator.crustychunks.client.model.ModelIRGuidedRocket;
import net.mcreator.crustychunks.client.model.ModelLargeRocket;
import net.mcreator.crustychunks.client.model.ModelMediumBomb_Converted;
import net.mcreator.crustychunks.client.model.ModelPassengerSeat_Converted;
import net.mcreator.crustychunks.client.model.ModelReaper;
import net.mcreator.crustychunks.client.model.ModelSmallBomb_Converted;
import net.mcreator.crustychunks.client.model.ModelSuperheavyBomb;
import net.mcreator.crustychunks.client.model.ModelTorpedo_Converted;
import net.mcreator.crustychunks.client.model.Modelartilleryshell;
import net.mcreator.crustychunks.client.model.Modelcommander;
import net.mcreator.crustychunks.client.model.Modelheavybomb;
import net.mcreator.crustychunks.client.model.Modelunknown;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class CrustyChunksModModels {
   @SubscribeEvent
   public static void registerLayerDefinitions(RegisterLayerDefinitions event) {
      event.registerLayerDefinition(ModelIRGuidedRocket.LAYER_LOCATION, ModelIRGuidedRocket::createBodyLayer);
      event.registerLayerDefinition(ModelPassengerSeat_Converted.LAYER_LOCATION, ModelPassengerSeat_Converted::createBodyLayer);
      event.registerLayerDefinition(ModelArmorPeelerRocket_Converted.LAYER_LOCATION, ModelArmorPeelerRocket_Converted::createBodyLayer);
      event.registerLayerDefinition(Modelunknown.LAYER_LOCATION, Modelunknown::createBodyLayer);
      event.registerLayerDefinition(ModelBomber.LAYER_LOCATION, ModelBomber::createBodyLayer);
      event.registerLayerDefinition(ModelFissionBomb.LAYER_LOCATION, ModelFissionBomb::createBodyLayer);
      event.registerLayerDefinition(ModelFlamePack.LAYER_LOCATION, ModelFlamePack::createBodyLayer);
      event.registerLayerDefinition(ModelReaper.LAYER_LOCATION, ModelReaper::createBodyLayer);
      event.registerLayerDefinition(Modelheavybomb.LAYER_LOCATION, Modelheavybomb::createBodyLayer);
      event.registerLayerDefinition(ModelTorpedo_Converted.LAYER_LOCATION, ModelTorpedo_Converted::createBodyLayer);
      event.registerLayerDefinition(ModelFusionBomb.LAYER_LOCATION, ModelFusionBomb::createBodyLayer);
      event.registerLayerDefinition(ModelMediumBomb_Converted.LAYER_LOCATION, ModelMediumBomb_Converted::createBodyLayer);
      event.registerLayerDefinition(ModelSmallBomb_Converted.LAYER_LOCATION, ModelSmallBomb_Converted::createBodyLayer);
      event.registerLayerDefinition(ModelGasmask_Converted_Converted.LAYER_LOCATION, ModelGasmask_Converted_Converted::createBodyLayer);
      event.registerLayerDefinition(ModelGasHelmet.LAYER_LOCATION, ModelGasHelmet::createBodyLayer);
      event.registerLayerDefinition(Modelcommander.LAYER_LOCATION, Modelcommander::createBodyLayer);
      event.registerLayerDefinition(ModelBlockBusterBomb.LAYER_LOCATION, ModelBlockBusterBomb::createBodyLayer);
      event.registerLayerDefinition(ModelHEATFS.LAYER_LOCATION, ModelHEATFS::createBodyLayer);
      event.registerLayerDefinition(ModelAPFSDS.LAYER_LOCATION, ModelAPFSDS::createBodyLayer);
      event.registerLayerDefinition(Modelartilleryshell.LAYER_LOCATION, Modelartilleryshell::createBodyLayer);
      event.registerLayerDefinition(ModelFireSpearRocket_Converted.LAYER_LOCATION, ModelFireSpearRocket_Converted::createBodyLayer);
      event.registerLayerDefinition(ModelSuperheavyBomb.LAYER_LOCATION, ModelSuperheavyBomb::createBodyLayer);
      event.registerLayerDefinition(ModelLargeRocket.LAYER_LOCATION, ModelLargeRocket::createBodyLayer);
   }
}
