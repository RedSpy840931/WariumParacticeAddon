package net.mcreator.crustychunks.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class BurstRifleHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         RiflehandtickProcedure.execute(entity);
         if (itemstack.getOrCreateTag().getDouble("ShotQue") > 0.0D) {
            BurstRifleFireScriptProcedure.execute(world, x, y, z, entity, itemstack);
            itemstack.getOrCreateTag().putDouble("ShotQue", itemstack.getOrCreateTag().getDouble("ShotQue") - 1.0D);
         }

      }
   }
}
