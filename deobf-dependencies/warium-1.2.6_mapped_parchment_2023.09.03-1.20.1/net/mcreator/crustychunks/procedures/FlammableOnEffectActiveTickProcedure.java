package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class FlammableOnEffectActiveTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getRemainingFireTicks() > 0) {
            int var10001;
            label17: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)CrustyChunksModMobEffects.FLAMMABLE.get())) {
                     var10001 = _livEnt.getEffect((MobEffect)CrustyChunksModMobEffects.FLAMMABLE.get()).getAmplifier();
                     break label17;
                  }
               }

               var10001 = 0;
            }

            entity.setSecondsOnFire(var10001);
         }

      }
   }
}
