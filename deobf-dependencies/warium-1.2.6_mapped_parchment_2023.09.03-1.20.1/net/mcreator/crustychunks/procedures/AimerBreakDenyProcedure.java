package net.mcreator.crustychunks.procedures;

import javax.annotation.Nullable;
import net.mcreator.crustychunks.entity.SeatEntityEntity;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AimerBreakDenyProcedure {
   @SubscribeEvent
   public static void onBlockBreak(BreakEvent event) {
      execute(event, event.getPlayer());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         Object var10000 = CrustyChunksModItems.AIMER.get();
         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMainHandItem();
         } else {
            var10001 = ItemStack.EMPTY;
         }

         if (var10000 == var10001.getItem() || entity.getRootVehicle() instanceof SeatEntityEntity) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            } else if (event != null && event.hasResult()) {
               event.setResult(Result.DENY);
            }
         }

      }
   }
}
