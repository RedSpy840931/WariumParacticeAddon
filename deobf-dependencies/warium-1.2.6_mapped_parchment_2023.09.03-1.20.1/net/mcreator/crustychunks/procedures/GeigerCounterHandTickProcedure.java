package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GeigerCounterHandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String severitycolor = "";
         if (0.0D <= entity.getPersistentData().getDouble("Radiation")) {
            severitycolor = "§a";
            if (25.0D <= entity.getPersistentData().getDouble("Radiation")) {
               severitycolor = "§e";
               if (50.0D <= entity.getPersistentData().getDouble("Radiation")) {
                  severitycolor = "§6";
                  if (100.0D <= entity.getPersistentData().getDouble("Radiation")) {
                     severitycolor = "§c";
                     if (150.0D <= entity.getPersistentData().getDouble("Radiation")) {
                        severitycolor = "§4";
                        if (200.0D <= entity.getPersistentData().getDouble("Radiation")) {
                           severitycolor = "§4";
                           if (250.0D <= entity.getPersistentData().getDouble("Radiation")) {
                              severitycolor = "§0";
                           }
                        }
                     }
                  }
               }
            }
         }

         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            if (_livEnt.hasEffect((MobEffect)CrustyChunksModMobEffects.RADIATION.get()) && Mth.nextDouble(RandomSource.create(), 2.0D, 250.0D) <= entity.getPersistentData().getDouble("Radiation") && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() != CrustyChunksModItems.GEIGER_COUNTER.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != CrustyChunksModItems.GEIGER_COUNTER.get()) {
               return;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal(severitycolor + "Radiation Exposure:" + (new DecimalFormat("####")).format(entity.getPersistentData().getDouble("Radiation"))), true);
            }
         }

      }
   }
}
