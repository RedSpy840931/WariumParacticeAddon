package net.mcreator.crustychunks.procedures;

import javax.annotation.Nullable;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.world.ForgeChunkManager;
import net.minecraftforge.event.level.ChunkEvent.Load;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ChunkUnloadProcedure {
   @SubscribeEvent
   public static void onEventTriggered(Load event) {
      execute(event, event.getChunk().getWorldForge(), (LevelChunk)event.getChunk());
   }

   public static void execute(LevelAccessor world, LevelChunk chunk) {
      execute((Event)null, world, chunk);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, LevelChunk chunk) {
      if (chunk != null) {
         CrustyChunksMod.queueServerWork(40, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel _world = (ServerLevel)world;
               if (ForgeChunkManager.hasForcedChunks(_world)) {
                  ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(chunk.getPos().x, 0, chunk.getPos().z), chunk.getPos().x, chunk.getPos().z, false, true);
                  ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(chunk.getPos().x, 0, chunk.getPos().z), chunk.getPos().x, chunk.getPos().z, false, false);
               }
            }

         });
      }
   }
}
