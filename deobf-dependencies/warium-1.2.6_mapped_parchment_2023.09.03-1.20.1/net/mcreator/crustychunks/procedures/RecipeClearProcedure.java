package net.mcreator.crustychunks.procedures;

import com.google.gson.JsonArray;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraftforge.event.level.LevelEvent.Unload;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RecipeClearProcedure {
   @SubscribeEvent
   public static void onWorldUnload(Unload event) {
      execute(event);
   }

   public static void execute() {
      execute((Event)null);
   }

   private static void execute(@Nullable Event event) {
      double indexclear = 0.0D;
      CrustyChunksModVariables.recipesloaded = new JsonArray();
   }
}
