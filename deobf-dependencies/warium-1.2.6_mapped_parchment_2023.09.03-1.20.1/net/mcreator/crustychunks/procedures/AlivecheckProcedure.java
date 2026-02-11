package net.mcreator.crustychunks.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class AlivecheckProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 != null) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (!var10000.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot")))) {
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               LivingEntity var5 = var10001;
               float var8;
               if (var5 instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)var5;
                  var8 = _livEnt.getHealth();
               } else {
                  var8 = -1.0F;
               }

               if (!(0.0F >= var8)) {
                  return;
               }
            }

            if (entity instanceof Mob) {
               Mob _entity = (Mob)entity;
               if (entity instanceof LivingEntity) {
                  LivingEntity _ent = (LivingEntity)entity;
                  _entity.setTarget(_ent);
               }
            }
         }

      }
   }
}
