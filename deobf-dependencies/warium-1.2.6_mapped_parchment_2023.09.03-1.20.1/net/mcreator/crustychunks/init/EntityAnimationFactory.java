package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.entity.AssassinEntity;
import net.mcreator.crustychunks.entity.CIWSEntity;
import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.entity.EradicatorEntity;
import net.mcreator.crustychunks.entity.FlamerEntity;
import net.mcreator.crustychunks.entity.HunterEntity;
import net.mcreator.crustychunks.entity.MortarerEntity;
import net.mcreator.crustychunks.entity.PrototypeEradicatorEntity;
import net.mcreator.crustychunks.entity.RaidscoutEntity;
import net.mcreator.crustychunks.entity.RiflerEntity;
import net.mcreator.crustychunks.entity.ScoutEntity;
import net.mcreator.crustychunks.entity.StrikerEntity;
import net.mcreator.crustychunks.entity.WorkerEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityAnimationFactory {
   @SubscribeEvent
   public static void onEntityTick(LivingTickEvent event) {
      if (event != null && event.getEntity() != null) {
         LivingEntity var2 = event.getEntity();
         String animation;
         if (var2 instanceof DecimatorEntity) {
            DecimatorEntity syncable = (DecimatorEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof StrikerEntity) {
            StrikerEntity syncable = (StrikerEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof FlamerEntity) {
            FlamerEntity syncable = (FlamerEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof HunterEntity) {
            HunterEntity syncable = (HunterEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof RiflerEntity) {
            RiflerEntity syncable = (RiflerEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof MortarerEntity) {
            MortarerEntity syncable = (MortarerEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof CIWSEntity) {
            CIWSEntity syncable = (CIWSEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof AssassinEntity) {
            AssassinEntity syncable = (AssassinEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof EradicatorEntity) {
            EradicatorEntity syncable = (EradicatorEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof ScoutEntity) {
            ScoutEntity syncable = (ScoutEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof RaidscoutEntity) {
            RaidscoutEntity syncable = (RaidscoutEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof WorkerEntity) {
            WorkerEntity syncable = (WorkerEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }

         var2 = event.getEntity();
         if (var2 instanceof PrototypeEradicatorEntity) {
            PrototypeEradicatorEntity syncable = (PrototypeEradicatorEntity)var2;
            animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               syncable.animationprocedure = animation;
            }
         }
      }

   }
}
