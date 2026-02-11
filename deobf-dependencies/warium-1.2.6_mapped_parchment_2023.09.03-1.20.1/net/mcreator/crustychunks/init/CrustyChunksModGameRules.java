package net.mcreator.crustychunks.init;

import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.GameRules.Category;
import net.minecraft.world.level.GameRules.IntegerValue;
import net.minecraft.world.level.GameRules.Key;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class CrustyChunksModGameRules {
   public static final Key<IntegerValue> ENRICHMENT_TIME;
   public static final Key<BooleanValue> ALLOW_IMPACT_FUZE;
   public static final Key<BooleanValue> STRATEGIC_WEAPONS;
   public static final Key<BooleanValue> APOCALYPSE_MODE;
   public static final Key<IntegerValue> BULLET_DAMAGE_MULTIPLIER;
   public static final Key<BooleanValue> WARIUM_APOCALYPSE_DYNAMIC_PRODUCTION;

   static {
      ENRICHMENT_TIME = GameRules.register("enrichmentTime", Category.MISC, IntegerValue.create(800));
      ALLOW_IMPACT_FUZE = GameRules.register("allowImpactFuze", Category.PLAYER, BooleanValue.create(true));
      STRATEGIC_WEAPONS = GameRules.register("strategicWeapons", Category.MISC, BooleanValue.create(true));
      APOCALYPSE_MODE = GameRules.register("apocalypseMode", Category.PLAYER, BooleanValue.create(false));
      BULLET_DAMAGE_MULTIPLIER = GameRules.register("bulletDamageMultiplier", Category.PLAYER, IntegerValue.create(1));
      WARIUM_APOCALYPSE_DYNAMIC_PRODUCTION = GameRules.register("wariumApocalypseDynamicProduction", Category.MOBS, BooleanValue.create(true));
   }
}
