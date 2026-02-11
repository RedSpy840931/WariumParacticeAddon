package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

public class ScopeOverlay2ConditionProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean Sneaking = false;
         if (entity instanceof Player) {
            Player _plrCldCheck1 = (Player)entity;
            ItemCooldowns var10000 = _plrCldCheck1.getCooldowns();
            ItemStack var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            if (var10000.isOnCooldown(var10001.getItem())) {
               return Sneaking;
            }
         }

         ItemStack var5;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var5 = _livEnt.getMainHandItem();
         } else {
            var5 = ItemStack.EMPTY;
         }

         if (var5.getItem() == CrustyChunksModItems.SINGLE_SHOT_RIFLE.get()) {
            if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
               Sneaking = true;
            } else {
               Sneaking = false;
            }
         }

         return Sneaking;
      }
   }
}
