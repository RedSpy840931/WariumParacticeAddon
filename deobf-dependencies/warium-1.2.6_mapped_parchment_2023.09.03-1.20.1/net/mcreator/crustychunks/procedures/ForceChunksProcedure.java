package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.world.ForgeChunkManager;

public class ForceChunksProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel) {
         ServerLevel _world = (ServerLevel)world;
         ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z, true, true);
      }

      CrustyChunksMod.queueServerWork(60, () -> {
         if (world instanceof ServerLevel) {
            ServerLevel _world = (ServerLevel)world;
            ForgeChunkManager.forceChunk(_world, "crusty_chunks", new BlockPos(world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, 0, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z), world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().x, world.getChunk(new BlockPos((int)x, (int)y, (int)z)).getPos().z, false, true);
         }

      });
   }
}
