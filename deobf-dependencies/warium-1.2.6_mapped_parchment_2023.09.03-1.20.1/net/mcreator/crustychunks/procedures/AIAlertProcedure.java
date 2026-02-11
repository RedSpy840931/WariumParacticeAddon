package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.entity.FlamerEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIAlertProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (!sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot")))) {
            if (entity instanceof Mob) {
               Mob _entity = (Mob)entity;
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _ent = (LivingEntity)sourceentity;
                  _entity.setTarget(_ent);
               }
            }

            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(256.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var11 = _entfound.iterator();

            while(true) {
               Entity entityiterator;
               do {
                  do {
                     if (!var11.hasNext()) {
                        return;
                     }

                     entityiterator = (Entity)var11.next();
                  } while(!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot"))));
               } while(entityiterator instanceof DecimatorEntity && entityiterator instanceof FlamerEntity);

               if (entityiterator instanceof Mob) {
                  Mob _entity = (Mob)entityiterator;
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)sourceentity;
                     _entity.setTarget(_ent);
                  }
               }
            }
         }
      }
   }
}
