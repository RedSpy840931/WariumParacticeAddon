package net.mcreator.crustychunks.item;

import com.google.common.collect.Iterables;
import net.mcreator.crustychunks.procedures.BlastArmorChestplateTickEventProcedure;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public abstract class BlastArmorItem extends ArmorItem {
   public BlastArmorItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return (new int[]{13, 15, 16, 11})[type.getSlot().getIndex()] * 20;
         }

         public int getDefenseForType(Type type) {
            return (new int[]{2, 5, 6, 2})[type.getSlot().getIndex()];
         }

         public int getEnchantmentValue() {
            return 9;
         }

         public SoundEvent getEquipSound() {
            return SoundEvents.EMPTY;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }

         public String getName() {
            return "blast_armor";
         }

         public float getToughness() {
            return 0.0F;
         }

         public float getKnockbackResistance() {
            return 0.25F;
         }
      }, type, properties);
   }

   public static class Boots extends BlastArmorItem {
      public Boots() {
         super(Type.BOOTS, new Properties());
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "crusty_chunks:textures/models/armor/blastarmor_layer_1.png";
      }
   }

   public static class Leggings extends BlastArmorItem {
      public Leggings() {
         super(Type.LEGGINGS, new Properties());
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "crusty_chunks:textures/models/armor/blastarmor_layer_2.png";
      }
   }

   public static class Chestplate extends BlastArmorItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Properties());
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "crusty_chunks:textures/models/armor/blastarmor_layer_1.png";
      }

      public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
         super.inventoryTick(itemstack, world, entity, slot, selected);
         if (entity instanceof Player) {
            Player player = (Player)entity;
            if (Iterables.contains(player.getArmorSlots(), itemstack)) {
               BlastArmorChestplateTickEventProcedure.execute(entity);
            }
         }

      }
   }

   public static class Helmet extends BlastArmorItem {
      public Helmet() {
         super(Type.HELMET, new Properties());
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "crusty_chunks:textures/models/armor/blastarmor_layer_1.png";
      }
   }
}
