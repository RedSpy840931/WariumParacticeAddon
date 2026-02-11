package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class BlastArmorChestplateTickEventProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == CrustyChunksModItems.BLAST_ARMOR_HELMET.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.BLAST_ARMOR_CHESTPLATE.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.BLAST_ARMOR_LEGGINGS.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == CrustyChunksModItems.BLAST_ARMOR_BOOTS.get() && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 0, false, false));
                     }
                  }
               }
            }
         }

      }
   }
}
