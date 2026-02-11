package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ContaminatedEffectProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            if (!_livEnt.level().isClientSide()) {
               _livEnt.addEffect(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.RADIATION.get(), 20, 1, false, false));
            }
         }

         int var10000;
         label23: {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)CrustyChunksModMobEffects.CONTAMINATED.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)CrustyChunksModMobEffects.CONTAMINATED.get()).getAmplifier();
                  break label23;
               }
            }

            var10000 = 0;
         }

         if (var10000 >= Mth.nextInt(RandomSource.create(), 0, 12)) {
            entity.getPersistentData().putDouble("Radiation", entity.getPersistentData().getDouble("Radiation") + 1.0D);
         }

      }
   }
}
