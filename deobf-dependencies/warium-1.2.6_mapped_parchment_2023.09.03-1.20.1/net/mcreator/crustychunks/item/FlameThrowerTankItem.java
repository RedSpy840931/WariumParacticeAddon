package net.mcreator.crustychunks.item;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.mcreator.crustychunks.client.model.ModelFlamePack;
import net.mcreator.crustychunks.procedures.AmmoCountFluidProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public abstract class FlameThrowerTankItem extends ArmorItem {
   public FlameThrowerTankItem(Type type, Properties properties) {
      super(new ArmorMaterial() {
         public int getDurabilityForType(Type type) {
            return (new int[]{13, 15, 16, 11})[type.getSlot().getIndex()] * 25;
         }

         public int getDefenseForType(Type type) {
            return (new int[]{0, 0, 1, 0})[type.getSlot().getIndex()];
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
            return "flame_thrower_tank";
         }

         public float getToughness() {
            return 0.0F;
         }

         public float getKnockbackResistance() {
            return 0.0F;
         }
      }, type, properties);
   }

   public static class Chestplate extends FlameThrowerTankItem {
      public Chestplate() {
         super(Type.CHESTPLATE, new Properties());
      }

      public void initializeClient(Consumer<IClientItemExtensions> consumer) {
         consumer.accept(new IClientItemExtensions() {
            // $FF: synthetic field
            final FlameThrowerTankItem.Chestplate this$0;

            {
               this.this$0 = this$0;
            }

            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
               HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new ModelFlamePack(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlamePack.LAYER_LOCATION))).Pack, "left_arm", (new ModelFlamePack(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlamePack.LAYER_LOCATION))).bone2, "right_arm", (new ModelFlamePack(Minecraft.getInstance().getEntityModels().bakeLayer(ModelFlamePack.LAYER_LOCATION))).bone, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
               armorModel.crouching = living.isShiftKeyDown();
               armorModel.riding = defaultModel.riding;
               armorModel.young = living.isBaby();
               return armorModel;
            }
         });
      }

      public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
         super.appendHoverText(itemstack, level, list, flag);
         Entity entity = itemstack.getEntityRepresentation();
         String hoverText = AmmoCountFluidProcedure.execute(itemstack);
         if (hoverText != null) {
            String[] var7 = hoverText.split("\n");
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               String line = var7[var9];
               list.add(Component.literal(line));
            }
         }

      }

      public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
         return "crusty_chunks:textures/entities/fuelpack.png";
      }
   }
}
