package net.mcreator.crustychunks.procedures;

import java.util.Iterator;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class AdvancementBarrelProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof ServerPlayer) {
            ServerPlayer _plr0 = (ServerPlayer)entity;
            if (_plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("crusty_chunks:gun_recipes"))).isDone()) {
               return;
            }
         }

         if (entity instanceof ServerPlayer) {
            ServerPlayer _player = (ServerPlayer)entity;
            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("crusty_chunks:gun_recipes"));
            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
            if (!_ap.isDone()) {
               Iterator var5 = _ap.getRemainingCriteria().iterator();

               while(var5.hasNext()) {
                  String criteria = (String)var5.next();
                  _player.getAdvancements().award(_adv, criteria);
               }
            }
         }

      }
   }
}
