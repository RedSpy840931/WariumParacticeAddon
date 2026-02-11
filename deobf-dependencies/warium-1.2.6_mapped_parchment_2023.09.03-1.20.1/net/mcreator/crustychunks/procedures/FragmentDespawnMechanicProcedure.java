package net.mcreator.crustychunks.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;

public class FragmentDespawnMechanicProcedure {
   public static void execute(Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.getDeltaMovement().length();
         } else {
            var10000 = 0.0D;
         }

         if ((var10000 < 0.75D || immediatesourceentity.getPersistentData().getDouble("T") > (double)Mth.nextInt(RandomSource.create(), 20, 40)) && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
