package net.mcreator.crustychunks.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;

public abstract class BodyArmorItem extends ArmorItem {
   public BodyArmorItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return (new int[]{13, 15, 16, 11})[type.getSlot().getIndex()] * 25;
         }

         public int getDefenseForType(Type type) {
            return (new int[]{2, 4, 2, 2})[type.getSlot().getIndex()];
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
            return "body_armor";
         }

         public float getToughness() {
            return 0.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Chestplate extends BodyArmorItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Properties());
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "crusty_chunks:textures/models/armor/placeholder_layer_1.png";
      }
   }
}
