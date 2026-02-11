package net.mcreator.crustychunks.procedures;

public class PhosphorusTrailParticleVisualScaleProcedure {
   public static double execute(double age) {
      double size = 0.0D;
      size = Math.min(Math.max(0.25D, age / 4.0D + 0.5D), 10.0D);
      return size;
   }
}
