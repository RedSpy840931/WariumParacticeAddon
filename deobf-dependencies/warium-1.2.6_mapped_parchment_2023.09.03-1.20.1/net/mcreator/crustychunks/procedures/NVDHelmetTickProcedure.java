package net.mcreator.crustychunks.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class NVDHelmetTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("HelmetState") == 0.0D) {
            entity.getPersistentData().putDouble("HelmetState", 1.0D);
         }

         if (entity.getPersistentData().getDouble("HelmetState") == 1.0D) {
            entity.getPersistentData().putDouble("HelmetState", 2.0D);
         } else if (entity.getPersistentData().getDouble("HelmetState") == 2.0D) {
            entity.getPersistentData().putDouble("HelmetState", 1.0D);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 4, 3, false, false));
            }
         }

      }
   }
}
