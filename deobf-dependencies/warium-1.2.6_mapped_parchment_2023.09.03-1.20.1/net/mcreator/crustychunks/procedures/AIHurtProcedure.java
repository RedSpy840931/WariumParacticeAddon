package net.mcreator.crustychunks.procedures;

import javax.annotation.Nullable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AIHurtProcedure {
   @SubscribeEvent
   public static void onEntityAttacked(LivingAttackEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity(), event.getSource().getEntity());
      }

   }

   public static void execute(Entity entity, Entity sourceentity) {
      execute((Event)null, entity, sourceentity);
   }

   private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot"))) && !sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot"))) && entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _ent = (LivingEntity)sourceentity;
               _entity.setTarget(_ent);
            }
         }

      }
   }
}
