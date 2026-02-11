package net.mcreator.crustychunks.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.crustychunks.procedures.ContaminatedEffectProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class ContaminatedMobEffect extends MobEffect {
   public ContaminatedMobEffect() {
      super(MobEffectCategory.HARMFUL, -16449281);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      ContaminatedEffectProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
