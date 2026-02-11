package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.item.ArmorPeelerAnimatedItem;
import net.mcreator.crustychunks.item.AutoPistolItem;
import net.mcreator.crustychunks.item.AutomaticRifleItem;
import net.mcreator.crustychunks.item.BattleRifleItem;
import net.mcreator.crustychunks.item.BoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.BreakActionShotgunAnimatedItem;
import net.mcreator.crustychunks.item.BreechRifleItem;
import net.mcreator.crustychunks.item.BurstRifleItem;
import net.mcreator.crustychunks.item.EradicationItem;
import net.mcreator.crustychunks.item.FlameThrowerAnimatedItem;
import net.mcreator.crustychunks.item.FlarePistolItem;
import net.mcreator.crustychunks.item.GrenadeLauncherItem;
import net.mcreator.crustychunks.item.HandDrillItem;
import net.mcreator.crustychunks.item.LMGAnimatedItem;
import net.mcreator.crustychunks.item.LeverRifleItem;
import net.mcreator.crustychunks.item.MachineCarbineItem;
import net.mcreator.crustychunks.item.PumpActionShotgunAnimatedItem;
import net.mcreator.crustychunks.item.RevolverAnimatedItem;
import net.mcreator.crustychunks.item.SMGAnimatedItem;
import net.mcreator.crustychunks.item.ScopedBoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.ScopedBreechRifleItem;
import net.mcreator.crustychunks.item.SemiAutomaticPistolAnimatedItem;
import net.mcreator.crustychunks.item.SemiAutomaticRifleAnimatedItem;
import net.mcreator.crustychunks.item.SingleShotRifleItem;
import net.mcreator.crustychunks.item.StealthPistolItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
   @SubscribeEvent
   public static void animatedItems(PlayerTickEvent event) {
      String animation = "";
      ItemStack mainhandItem = event.player.getMainHandItem().copy();
      ItemStack offhandItem = event.player.getOffhandItem().copy();
      if (event.phase == Phase.START && (mainhandItem.getItem() instanceof GeoItem || offhandItem.getItem() instanceof GeoItem)) {
         Item var5 = mainhandItem.getItem();
         SemiAutomaticRifleAnimatedItem animatable;
         if (var5 instanceof SemiAutomaticRifleAnimatedItem) {
            animatable = (SemiAutomaticRifleAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SemiAutomaticRifleAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof SemiAutomaticRifleAnimatedItem) {
            animatable = (SemiAutomaticRifleAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SemiAutomaticRifleAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         SemiAutomaticPistolAnimatedItem animatable;
         if (var5 instanceof SemiAutomaticPistolAnimatedItem) {
            animatable = (SemiAutomaticPistolAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SemiAutomaticPistolAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof SemiAutomaticPistolAnimatedItem) {
            animatable = (SemiAutomaticPistolAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SemiAutomaticPistolAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         BoltActionRifleAnimatedItem animatable;
         if (var5 instanceof BoltActionRifleAnimatedItem) {
            animatable = (BoltActionRifleAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BoltActionRifleAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof BoltActionRifleAnimatedItem) {
            animatable = (BoltActionRifleAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BoltActionRifleAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         ScopedBoltActionRifleAnimatedItem animatable;
         if (var5 instanceof ScopedBoltActionRifleAnimatedItem) {
            animatable = (ScopedBoltActionRifleAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ScopedBoltActionRifleAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof ScopedBoltActionRifleAnimatedItem) {
            animatable = (ScopedBoltActionRifleAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ScopedBoltActionRifleAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         PumpActionShotgunAnimatedItem animatable;
         if (var5 instanceof PumpActionShotgunAnimatedItem) {
            animatable = (PumpActionShotgunAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((PumpActionShotgunAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof PumpActionShotgunAnimatedItem) {
            animatable = (PumpActionShotgunAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((PumpActionShotgunAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         ArmorPeelerAnimatedItem animatable;
         if (var5 instanceof ArmorPeelerAnimatedItem) {
            animatable = (ArmorPeelerAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ArmorPeelerAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof ArmorPeelerAnimatedItem) {
            animatable = (ArmorPeelerAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ArmorPeelerAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         SMGAnimatedItem animatable;
         if (var5 instanceof SMGAnimatedItem) {
            animatable = (SMGAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SMGAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof SMGAnimatedItem) {
            animatable = (SMGAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SMGAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         FlameThrowerAnimatedItem animatable;
         if (var5 instanceof FlameThrowerAnimatedItem) {
            animatable = (FlameThrowerAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((FlameThrowerAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof FlameThrowerAnimatedItem) {
            animatable = (FlameThrowerAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((FlameThrowerAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         RevolverAnimatedItem animatable;
         if (var5 instanceof RevolverAnimatedItem) {
            animatable = (RevolverAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((RevolverAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof RevolverAnimatedItem) {
            animatable = (RevolverAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((RevolverAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         SingleShotRifleItem animatable;
         if (var5 instanceof SingleShotRifleItem) {
            animatable = (SingleShotRifleItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SingleShotRifleItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof SingleShotRifleItem) {
            animatable = (SingleShotRifleItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SingleShotRifleItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         LMGAnimatedItem animatable;
         if (var5 instanceof LMGAnimatedItem) {
            animatable = (LMGAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((LMGAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof LMGAnimatedItem) {
            animatable = (LMGAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((LMGAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         BurstRifleItem animatable;
         if (var5 instanceof BurstRifleItem) {
            animatable = (BurstRifleItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BurstRifleItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof BurstRifleItem) {
            animatable = (BurstRifleItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BurstRifleItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         AutoPistolItem animatable;
         if (var5 instanceof AutoPistolItem) {
            animatable = (AutoPistolItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((AutoPistolItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof AutoPistolItem) {
            animatable = (AutoPistolItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((AutoPistolItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         BreakActionShotgunAnimatedItem animatable;
         if (var5 instanceof BreakActionShotgunAnimatedItem) {
            animatable = (BreakActionShotgunAnimatedItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BreakActionShotgunAnimatedItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof BreakActionShotgunAnimatedItem) {
            animatable = (BreakActionShotgunAnimatedItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BreakActionShotgunAnimatedItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         BattleRifleItem animatable;
         if (var5 instanceof BattleRifleItem) {
            animatable = (BattleRifleItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BattleRifleItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof BattleRifleItem) {
            animatable = (BattleRifleItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BattleRifleItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         MachineCarbineItem animatable;
         if (var5 instanceof MachineCarbineItem) {
            animatable = (MachineCarbineItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((MachineCarbineItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof MachineCarbineItem) {
            animatable = (MachineCarbineItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((MachineCarbineItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         HandDrillItem animatable;
         if (var5 instanceof HandDrillItem) {
            animatable = (HandDrillItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((HandDrillItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof HandDrillItem) {
            animatable = (HandDrillItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((HandDrillItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         FlarePistolItem animatable;
         if (var5 instanceof FlarePistolItem) {
            animatable = (FlarePistolItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((FlarePistolItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof FlarePistolItem) {
            animatable = (FlarePistolItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((FlarePistolItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         StealthPistolItem animatable;
         if (var5 instanceof StealthPistolItem) {
            animatable = (StealthPistolItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((StealthPistolItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof StealthPistolItem) {
            animatable = (StealthPistolItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((StealthPistolItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         BreechRifleItem animatable;
         if (var5 instanceof BreechRifleItem) {
            animatable = (BreechRifleItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BreechRifleItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof BreechRifleItem) {
            animatable = (BreechRifleItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BreechRifleItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         ScopedBreechRifleItem animatable;
         if (var5 instanceof ScopedBreechRifleItem) {
            animatable = (ScopedBreechRifleItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ScopedBreechRifleItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof ScopedBreechRifleItem) {
            animatable = (ScopedBreechRifleItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ScopedBreechRifleItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         EradicationItem animatable;
         if (var5 instanceof EradicationItem) {
            animatable = (EradicationItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((EradicationItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof EradicationItem) {
            animatable = (EradicationItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((EradicationItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         LeverRifleItem animatable;
         if (var5 instanceof LeverRifleItem) {
            animatable = (LeverRifleItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((LeverRifleItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof LeverRifleItem) {
            animatable = (LeverRifleItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((LeverRifleItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         AutomaticRifleItem animatable;
         if (var5 instanceof AutomaticRifleItem) {
            animatable = (AutomaticRifleItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((AutomaticRifleItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof AutomaticRifleItem) {
            animatable = (AutomaticRifleItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((AutomaticRifleItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         GrenadeLauncherItem animatable;
         if (var5 instanceof GrenadeLauncherItem) {
            animatable = (GrenadeLauncherItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GrenadeLauncherItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof GrenadeLauncherItem) {
            animatable = (GrenadeLauncherItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GrenadeLauncherItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }
      }

   }
}
