package net.mcreator.crustychunks.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BulletResistantHelmet3Item extends ArmorItem {
   public BulletResistantHelmet3Item(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return (new int[]{13, 15, 16, 11})[type.getSlot().getIndex()] * 25;
         }

         public int getDefenseForType(Type type) {
            return (new int[]{0, 0, 0, 1})[type.getSlot().getIndex()];
         }

         public int getEnchantmentValue() {
            return 0;
         }

         public SoundEvent getEquipSound() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_generic"));
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }

         public String getName() {
            return "bullet_resistant_helmet_3";
         }

         public float getToughness() {
            return 0.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Helmet extends BulletResistantHelmet3Item {
      public Helmet() {
         super(Type.HELMET, new Properties());
      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "crusty_chunks:textures/models/armor/placeholder3_layer_1.png";
      }
   }
}
