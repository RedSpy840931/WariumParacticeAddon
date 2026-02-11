package net.mcreator.crustychunks.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class IncendiaryGrenadeTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      ServerLevel _level;
      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.SMOKE, x, y, z, 5, 0.0D, 0.0D, 0.0D, 0.05D);
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.FLAME, x, y, z, 5, 0.0D, 0.0D, 0.0D, 0.05D);
      }

   }
}
