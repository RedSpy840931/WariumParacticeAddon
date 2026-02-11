package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.block.display.RACBarrelDisplayItem;
import net.mcreator.crustychunks.item.APFSDSProjectileItem;
import net.mcreator.crustychunks.item.APLargeBulletItem;
import net.mcreator.crustychunks.item.APShellItem;
import net.mcreator.crustychunks.item.AdvancedAlloyComponentItem;
import net.mcreator.crustychunks.item.AdvancedAlloyIngotItem;
import net.mcreator.crustychunks.item.AdvancedAlloyMixtureItem;
import net.mcreator.crustychunks.item.AdvancedAutomaticRifleReceiverItem;
import net.mcreator.crustychunks.item.AdvancedComponentItem;
import net.mcreator.crustychunks.item.AdvancedPistolReceiverItem;
import net.mcreator.crustychunks.item.AimerItem;
import net.mcreator.crustychunks.item.AluminateDustItem;
import net.mcreator.crustychunks.item.AluminumDustItem;
import net.mcreator.crustychunks.item.AluminumIngotItem;
import net.mcreator.crustychunks.item.AluminumPlateItem;
import net.mcreator.crustychunks.item.AluminumTinyDustItem;
import net.mcreator.crustychunks.item.ArmorPeelerAnimatedItem;
import net.mcreator.crustychunks.item.ArmorPeelerRocketItem;
import net.mcreator.crustychunks.item.ArmorPeelerUnloadedItem;
import net.mcreator.crustychunks.item.ArtilleryShellItem;
import net.mcreator.crustychunks.item.ArtillerySolidShellItem;
import net.mcreator.crustychunks.item.AutoPistolItem;
import net.mcreator.crustychunks.item.AutomaticRifleItem;
import net.mcreator.crustychunks.item.AutomaticRifleReceiverItem;
import net.mcreator.crustychunks.item.BasicReceiverItem;
import net.mcreator.crustychunks.item.BattleRifleItem;
import net.mcreator.crustychunks.item.BauxiteDustItem;
import net.mcreator.crustychunks.item.BentComponentItem;
import net.mcreator.crustychunks.item.BerylliumDustItem;
import net.mcreator.crustychunks.item.BerylliumIngotItem;
import net.mcreator.crustychunks.item.BirdShotItem;
import net.mcreator.crustychunks.item.BlastArmorItem;
import net.mcreator.crustychunks.item.BlastClayItem;
import net.mcreator.crustychunks.item.BlastFurnaceBrickItem;
import net.mcreator.crustychunks.item.BodyArmorItem;
import net.mcreator.crustychunks.item.BoltActionReceiverItem;
import net.mcreator.crustychunks.item.BoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.BoredComponentItem;
import net.mcreator.crustychunks.item.BrassDustItem;
import net.mcreator.crustychunks.item.BrassFittingItem;
import net.mcreator.crustychunks.item.BrassIngotItem;
import net.mcreator.crustychunks.item.BrassPlateItem;
import net.mcreator.crustychunks.item.BreakActionShotgunAnimatedItem;
import net.mcreator.crustychunks.item.BreechRifleItem;
import net.mcreator.crustychunks.item.BulletItem;
import net.mcreator.crustychunks.item.BulletResistantHelmet2Item;
import net.mcreator.crustychunks.item.BulletResistantHelmet3Item;
import net.mcreator.crustychunks.item.BulletResistantHelmet4Item;
import net.mcreator.crustychunks.item.BulletResistantHelmetItem;
import net.mcreator.crustychunks.item.BurstRifleItem;
import net.mcreator.crustychunks.item.CableItem;
import net.mcreator.crustychunks.item.CastComponentItem;
import net.mcreator.crustychunks.item.ChaffChargeItem;
import net.mcreator.crustychunks.item.ChiselItem;
import net.mcreator.crustychunks.item.ChlorineDustItem;
import net.mcreator.crustychunks.item.CombustionCylinderItem;
import net.mcreator.crustychunks.item.ComponentFoundryTemplateItem;
import net.mcreator.crustychunks.item.CompressedAdvancedMixtureItem;
import net.mcreator.crustychunks.item.CopperCoilItem;
import net.mcreator.crustychunks.item.CopperDustItem;
import net.mcreator.crustychunks.item.CopperPlateItem;
import net.mcreator.crustychunks.item.CopperWireItem;
import net.mcreator.crustychunks.item.CrudeOilItem;
import net.mcreator.crustychunks.item.CutComponentItem;
import net.mcreator.crustychunks.item.CuttersItem;
import net.mcreator.crustychunks.item.CylinderFoundryTemplateItem;
import net.mcreator.crustychunks.item.DieselItem;
import net.mcreator.crustychunks.item.ERATileItem;
import net.mcreator.crustychunks.item.ElectricMotorItem;
import net.mcreator.crustychunks.item.EmberParticleItem;
import net.mcreator.crustychunks.item.EnergyMeterItem;
import net.mcreator.crustychunks.item.EngineComponentItem;
import net.mcreator.crustychunks.item.EnrichedLithiumIngotItem;
import net.mcreator.crustychunks.item.EnrichedLithiumNuggetItem;
import net.mcreator.crustychunks.item.EradicationItem;
import net.mcreator.crustychunks.item.ExtraLargeBulletItem;
import net.mcreator.crustychunks.item.ExtraLargeCasingItem;
import net.mcreator.crustychunks.item.ExtraLargeProjectileItem;
import net.mcreator.crustychunks.item.ExtraLargeProjectileTemplateItem;
import net.mcreator.crustychunks.item.FilteredAluminateDustItem;
import net.mcreator.crustychunks.item.FilteredPyrochloreDustItem;
import net.mcreator.crustychunks.item.FireAgentItem;
import net.mcreator.crustychunks.item.FireArtilleryShellItem;
import net.mcreator.crustychunks.item.FireSpearRocketItem;
import net.mcreator.crustychunks.item.FiringMechanismItem;
import net.mcreator.crustychunks.item.FiringPinItem;
import net.mcreator.crustychunks.item.FissionCoreItem;
import net.mcreator.crustychunks.item.FlakProjectileItem;
import net.mcreator.crustychunks.item.FlakShellItem;
import net.mcreator.crustychunks.item.FlameThrowerAnimatedItem;
import net.mcreator.crustychunks.item.FlameThrowerTankItem;
import net.mcreator.crustychunks.item.FlareChargeItem;
import net.mcreator.crustychunks.item.FlarePistolItem;
import net.mcreator.crustychunks.item.FoundryTemplateItem;
import net.mcreator.crustychunks.item.FuelHoseItem;
import net.mcreator.crustychunks.item.FuelRodItem;
import net.mcreator.crustychunks.item.FusionCoreItem;
import net.mcreator.crustychunks.item.GasArtilleryShellItem;
import net.mcreator.crustychunks.item.GasCanisterItem;
import net.mcreator.crustychunks.item.GasMaskHelmetItem;
import net.mcreator.crustychunks.item.GasMaskItem;
import net.mcreator.crustychunks.item.GeigerCounterItem;
import net.mcreator.crustychunks.item.GoldDustItem;
import net.mcreator.crustychunks.item.GrenadeItem;
import net.mcreator.crustychunks.item.GrenadeLauncherItem;
import net.mcreator.crustychunks.item.GrenadeShellItem;
import net.mcreator.crustychunks.item.HEATProjectileItem;
import net.mcreator.crustychunks.item.HEProjectileItem;
import net.mcreator.crustychunks.item.HammerItem;
import net.mcreator.crustychunks.item.HandDrillItem;
import net.mcreator.crustychunks.item.HeatShellItem;
import net.mcreator.crustychunks.item.HollowedExtraLargeProjectileItem;
import net.mcreator.crustychunks.item.HollowedHugeProjectileItem;
import net.mcreator.crustychunks.item.HollowedLargeProjectileItem;
import net.mcreator.crustychunks.item.HugeBarrelFoundryTemplateItem;
import net.mcreator.crustychunks.item.HugeBoredBarrelItem;
import net.mcreator.crustychunks.item.HugeBulletItem;
import net.mcreator.crustychunks.item.HugeCannonFoundryTemplateItem;
import net.mcreator.crustychunks.item.HugeCasingItem;
import net.mcreator.crustychunks.item.HugeHEBulletItem;
import net.mcreator.crustychunks.item.HugeProjectileFoundryTemplateItem;
import net.mcreator.crustychunks.item.HugeProjectileItem;
import net.mcreator.crustychunks.item.HugeUnboredBarrelItem;
import net.mcreator.crustychunks.item.HugeUnboredCannonBarrelItem;
import net.mcreator.crustychunks.item.HydrazineItem;
import net.mcreator.crustychunks.item.IRComponentItem;
import net.mcreator.crustychunks.item.ImpactFuzeItem;
import net.mcreator.crustychunks.item.ImplosionLensItem;
import net.mcreator.crustychunks.item.ImplosionModuleItem;
import net.mcreator.crustychunks.item.IncendiaryBottleItem;
import net.mcreator.crustychunks.item.IncendiaryGrenadeItem;
import net.mcreator.crustychunks.item.InvisibleitemItem;
import net.mcreator.crustychunks.item.IronDustItem;
import net.mcreator.crustychunks.item.IrongearItem;
import net.mcreator.crustychunks.item.KeroseneItem;
import net.mcreator.crustychunks.item.LMGAnimatedItem;
import net.mcreator.crustychunks.item.LMGMagazineItem;
import net.mcreator.crustychunks.item.LargeBarrelTemplateItem;
import net.mcreator.crustychunks.item.LargeBoredBarrelItem;
import net.mcreator.crustychunks.item.LargeBulletItem;
import net.mcreator.crustychunks.item.LargeCannonFoundryTemplateItem;
import net.mcreator.crustychunks.item.LargeCasingItem;
import net.mcreator.crustychunks.item.LargeFoundryTemplateItem;
import net.mcreator.crustychunks.item.LargeMagazineItem;
import net.mcreator.crustychunks.item.LargeProjectileFoundryTemplateItem;
import net.mcreator.crustychunks.item.LargeProjectileItem;
import net.mcreator.crustychunks.item.LargeShellItem;
import net.mcreator.crustychunks.item.LargeUnboredBarrelItem;
import net.mcreator.crustychunks.item.LargeUnboredCannonBarrelItem;
import net.mcreator.crustychunks.item.LargeVolatilePileItem;
import net.mcreator.crustychunks.item.LeadDustItem;
import net.mcreator.crustychunks.item.LeadIngotItem;
import net.mcreator.crustychunks.item.LeadNuggetItem;
import net.mcreator.crustychunks.item.LeverRifleItem;
import net.mcreator.crustychunks.item.LithiumDeuterideItem;
import net.mcreator.crustychunks.item.LithiumDustItem;
import net.mcreator.crustychunks.item.LithiumIngotItem;
import net.mcreator.crustychunks.item.LithiumNuggetItem;
import net.mcreator.crustychunks.item.MGReceiverItem;
import net.mcreator.crustychunks.item.MachineCarbineItem;
import net.mcreator.crustychunks.item.MachineGunBoxItem;
import net.mcreator.crustychunks.item.MechanicalBoreItem;
import net.mcreator.crustychunks.item.MechanicalExtruderItem;
import net.mcreator.crustychunks.item.MechanicalPressItem;
import net.mcreator.crustychunks.item.MechanicalShearItem;
import net.mcreator.crustychunks.item.MediumAPBulletItem;
import net.mcreator.crustychunks.item.MediumBarrelTemplateItem;
import net.mcreator.crustychunks.item.MediumBoredBarrelItem;
import net.mcreator.crustychunks.item.MediumCannonFoundryTemplateItem;
import net.mcreator.crustychunks.item.MediumCasingItem;
import net.mcreator.crustychunks.item.MediumMagazineItem;
import net.mcreator.crustychunks.item.MediumProjectileFoundryTemplateItem;
import net.mcreator.crustychunks.item.MediumProjectileItem;
import net.mcreator.crustychunks.item.MediumStealthBulletItem;
import net.mcreator.crustychunks.item.MediumUnboredBarrelItem;
import net.mcreator.crustychunks.item.MediumUnboredCannonBarrelItem;
import net.mcreator.crustychunks.item.MortarShellItem;
import net.mcreator.crustychunks.item.MusketBallItem;
import net.mcreator.crustychunks.item.NVDHelmetItem;
import net.mcreator.crustychunks.item.NeutronReflectorItem;
import net.mcreator.crustychunks.item.NickelDustItem;
import net.mcreator.crustychunks.item.NickelIngotItem;
import net.mcreator.crustychunks.item.NiobiumDustItem;
import net.mcreator.crustychunks.item.NiobiumIngotItem;
import net.mcreator.crustychunks.item.NiobiumTinyDustItem;
import net.mcreator.crustychunks.item.NitrateItem;
import net.mcreator.crustychunks.item.OilItem;
import net.mcreator.crustychunks.item.PaintToolItem;
import net.mcreator.crustychunks.item.Particle2Item;
import net.mcreator.crustychunks.item.ParticleItem;
import net.mcreator.crustychunks.item.PetroliumItem;
import net.mcreator.crustychunks.item.PhosphorusDustItem;
import net.mcreator.crustychunks.item.PistolReceiverItem;
import net.mcreator.crustychunks.item.PlutoniumCoreItem;
import net.mcreator.crustychunks.item.PlutoniumIngotItem;
import net.mcreator.crustychunks.item.PlutoniumNuggetItem;
import net.mcreator.crustychunks.item.PowderChargeItem;
import net.mcreator.crustychunks.item.PowerCellItem;
import net.mcreator.crustychunks.item.PrecisionComponentItem;
import net.mcreator.crustychunks.item.PropellentItem;
import net.mcreator.crustychunks.item.PumpActionShotgunAnimatedItem;
import net.mcreator.crustychunks.item.PyrochloreDustItem;
import net.mcreator.crustychunks.item.PyrochloreItem;
import net.mcreator.crustychunks.item.RadarComponentItem;
import net.mcreator.crustychunks.item.RadarSpearMissileItem;
import net.mcreator.crustychunks.item.RawBerylliumItem;
import net.mcreator.crustychunks.item.RawLeadItem;
import net.mcreator.crustychunks.item.RawLithiumItem;
import net.mcreator.crustychunks.item.RawNickelItem;
import net.mcreator.crustychunks.item.RawUraniumItem;
import net.mcreator.crustychunks.item.RawZincItem;
import net.mcreator.crustychunks.item.ReactioncomponentItem;
import net.mcreator.crustychunks.item.RevolverAnimatedItem;
import net.mcreator.crustychunks.item.RevolverReceiverItem;
import net.mcreator.crustychunks.item.RifleStockItem;
import net.mcreator.crustychunks.item.SMGAnimatedItem;
import net.mcreator.crustychunks.item.SMGMagazineItem;
import net.mcreator.crustychunks.item.SMGReceiverItem;
import net.mcreator.crustychunks.item.ScopedBoltActionRifleAnimatedItem;
import net.mcreator.crustychunks.item.ScopedBreechRifleItem;
import net.mcreator.crustychunks.item.SeekerSpearRocketItem;
import net.mcreator.crustychunks.item.SemiAutomaticPistolAnimatedItem;
import net.mcreator.crustychunks.item.SemiAutomaticRifleAnimatedItem;
import net.mcreator.crustychunks.item.ShaleOilItem;
import net.mcreator.crustychunks.item.ShapedChargeFuzeItem;
import net.mcreator.crustychunks.item.ShieldingComponentItem;
import net.mcreator.crustychunks.item.ShotgunCasingItem;
import net.mcreator.crustychunks.item.ShotgunShellItem;
import net.mcreator.crustychunks.item.SingleShotRifleItem;
import net.mcreator.crustychunks.item.SlugShellItem;
import net.mcreator.crustychunks.item.SmallBarrelTemplateItem;
import net.mcreator.crustychunks.item.SmallBoredBarrelItem;
import net.mcreator.crustychunks.item.SmallCannonFoundryTemplateItem;
import net.mcreator.crustychunks.item.SmallCasingItem;
import net.mcreator.crustychunks.item.SmallEngineItem;
import net.mcreator.crustychunks.item.SmallFlakProjectileItem;
import net.mcreator.crustychunks.item.SmallFlakShellItem;
import net.mcreator.crustychunks.item.SmallHEProjectileItem;
import net.mcreator.crustychunks.item.SmallHollowPointBulletItem;
import net.mcreator.crustychunks.item.SmallProjectileFoundryTemplateItem;
import net.mcreator.crustychunks.item.SmallProjectileItem;
import net.mcreator.crustychunks.item.SmallShellItem;
import net.mcreator.crustychunks.item.SmallStealthBulletItem;
import net.mcreator.crustychunks.item.SmallUnboredBarrelItem;
import net.mcreator.crustychunks.item.SmallUnboredCannonBarrelItem;
import net.mcreator.crustychunks.item.SmallbulletItem;
import net.mcreator.crustychunks.item.SmallmagazineItem;
import net.mcreator.crustychunks.item.SmokeAgentItem;
import net.mcreator.crustychunks.item.SmokeGrenadeItem;
import net.mcreator.crustychunks.item.SmokeGrenadeShellItem;
import net.mcreator.crustychunks.item.SmokeMortarShellItem;
import net.mcreator.crustychunks.item.SmokeProjectileItem;
import net.mcreator.crustychunks.item.SmokeShellItem;
import net.mcreator.crustychunks.item.SolidRocketFuelPackItem;
import net.mcreator.crustychunks.item.SolidShellItem;
import net.mcreator.crustychunks.item.StealthLargeBulletItem;
import net.mcreator.crustychunks.item.StealthPistolItem;
import net.mcreator.crustychunks.item.SteelComponentItem;
import net.mcreator.crustychunks.item.SteelCrushingWheelItem;
import net.mcreator.crustychunks.item.SteelCylinderItem;
import net.mcreator.crustychunks.item.SteelGearItem;
import net.mcreator.crustychunks.item.SteelIngotItem;
import net.mcreator.crustychunks.item.SteelSpringItem;
import net.mcreator.crustychunks.item.SteelTubeItem;
import net.mcreator.crustychunks.item.SteelWireItem;
import net.mcreator.crustychunks.item.SteelplateItem;
import net.mcreator.crustychunks.item.StrikeSpearMissileItem;
import net.mcreator.crustychunks.item.SulfurItem;
import net.mcreator.crustychunks.item.SulfuricAcidItem;
import net.mcreator.crustychunks.item.TechComponentItem;
import net.mcreator.crustychunks.item.ThermalShellItem;
import net.mcreator.crustychunks.item.ThermoNuclearFuelItem;
import net.mcreator.crustychunks.item.ThermometerItem;
import net.mcreator.crustychunks.item.TimedFuzeItem;
import net.mcreator.crustychunks.item.TinyLithiumDeuterideItem;
import net.mcreator.crustychunks.item.TinyprojectileItemItem;
import net.mcreator.crustychunks.item.ToxicAgentItem;
import net.mcreator.crustychunks.item.TransparentItemItem;
import net.mcreator.crustychunks.item.TrinititeShardItem;
import net.mcreator.crustychunks.item.TurbineRotorItem;
import net.mcreator.crustychunks.item.UnfabricatedTechComponentItem;
import net.mcreator.crustychunks.item.UraniumDepletedDustItem;
import net.mcreator.crustychunks.item.UraniumDepletedIngotItem;
import net.mcreator.crustychunks.item.UraniumDepletedTinyDustItem;
import net.mcreator.crustychunks.item.UraniumEnrichedDustItem;
import net.mcreator.crustychunks.item.UraniumEnrichedIngotItem;
import net.mcreator.crustychunks.item.UraniumEnrichedTinyDustItem;
import net.mcreator.crustychunks.item.UraniumNeuralIngotItem;
import net.mcreator.crustychunks.item.UraniumNeutralDustItem;
import net.mcreator.crustychunks.item.UraniumNeutraltinyDustItem;
import net.mcreator.crustychunks.item.VolatileDustItem;
import net.mcreator.crustychunks.item.WeaponBoltItem;
import net.mcreator.crustychunks.item.WeaponSupressorItem;
import net.mcreator.crustychunks.item.WoodComponentItem;
import net.mcreator.crustychunks.item.ZincDustItem;
import net.mcreator.crustychunks.item.ZincIngotItem;
import net.mcreator.crustychunks.procedures.MagazineLevelProcedure;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class CrustyChunksModItems {
   public static final DeferredRegister<Item> REGISTRY;
   public static final RegistryObject<Item> REDSTONE_TNT;
   public static final RegistryObject<Item> EXPLOSIVE_BARREL;
   public static final RegistryObject<Item> BURNTGRASS;
   public static final RegistryObject<Item> HARDDIRT;
   public static final RegistryObject<Item> ZINC_INGOT;
   public static final RegistryObject<Item> ZINC_ORE;
   public static final RegistryObject<Item> ZINC_BLOCK;
   public static final RegistryObject<Item> BRASS_INGOT;
   public static final RegistryObject<Item> BRASS_BLOCK;
   public static final RegistryObject<Item> STEEL_INGOT;
   public static final RegistryObject<Item> STEEL_BLOCK;
   public static final RegistryObject<Item> SMALLBULLET;
   public static final RegistryObject<Item> BULLET;
   public static final RegistryObject<Item> LARGE_BULLET;
   public static final RegistryObject<Item> HUGE_BULLET;
   public static final RegistryObject<Item> SMALL_SHELL;
   public static final RegistryObject<Item> LARGE_SHELL;
   public static final RegistryObject<Item> POWDER_CHARGE;
   public static final RegistryObject<Item> ARTILLERY_SHELL;
   public static final RegistryObject<Item> LEAD_INGOT;
   public static final RegistryObject<Item> LEAD_ORE;
   public static final RegistryObject<Item> LEAD_BLOCK;
   public static final RegistryObject<Item> STEELPLATE;
   public static final RegistryObject<Item> STEEL_COMPONENT;
   public static final RegistryObject<Item> CAST_COMPONENT;
   public static final RegistryObject<Item> STEEL_CYLINDER;
   public static final RegistryObject<Item> STEEL_SPRING;
   public static final RegistryObject<Item> STEEL_TUBE;
   public static final RegistryObject<Item> STEEL_WIRE;
   public static final RegistryObject<Item> CUT_COMPONENT;
   public static final RegistryObject<Item> BORED_COMPONENT;
   public static final RegistryObject<Item> BENT_COMPONENT;
   public static final RegistryObject<Item> STEEL_GEAR;
   public static final RegistryObject<Item> WOOD_COMPONENT;
   public static final RegistryObject<Item> SMALL_CASING;
   public static final RegistryObject<Item> MEDIUM_CASING;
   public static final RegistryObject<Item> LARGE_CASING;
   public static final RegistryObject<Item> HUGE_CASING;
   public static final RegistryObject<Item> SMALLMAGAZINE;
   public static final RegistryObject<Item> MEDIUM_MAGAZINE;
   public static final RegistryObject<Item> COPPER_COIL;
   public static final RegistryObject<Item> COPPER_WIRE;
   public static final RegistryObject<Item> NICKEL_INGOT;
   public static final RegistryObject<Item> NICKEL_ORE;
   public static final RegistryObject<Item> NICKEL_BLOCK;
   public static final RegistryObject<Item> TAR;
   public static final RegistryObject<Item> STEEL_PLATING;
   public static final RegistryObject<Item> STEEL_PLATING_SLAB;
   public static final RegistryObject<Item> STEEL_PLATING_STAIRS;
   public static final RegistryObject<Item> SMOKE_BOMB;
   public static final RegistryObject<Item> STEEL_TRAPDOOR;
   public static final RegistryObject<Item> STEEL_OPTIC;
   public static final RegistryObject<Item> CHARRED_BLOCK;
   public static final RegistryObject<Item> REENFORCED_CONCRETE;
   public static final RegistryObject<Item> CRACKED_CONCRETE;
   public static final RegistryObject<Item> FRACTURED_CONCRETE;
   public static final RegistryObject<Item> DAMAGED_CONCRETE;
   public static final RegistryObject<Item> DESTROYED_CONCRETE;
   public static final RegistryObject<Item> ALUMINUM_INGOT;
   public static final RegistryObject<Item> ALUMINUM_BLOCK;
   public static final RegistryObject<Item> SMG_MAGAZINE;
   public static final RegistryObject<Item> MACHINE_GUN;
   public static final RegistryObject<Item> MACHINE_GUN_BARREL;
   public static final RegistryObject<Item> AIMER;
   public static final RegistryObject<Item> ARTILLERYBREECH;
   public static final RegistryObject<Item> ARTILLERY_BARREL;
   public static final RegistryObject<Item> MACHINE_GUN_BOX;
   public static final RegistryObject<Item> BATTLE_CANNON_BREECH;
   public static final RegistryObject<Item> BATTLE_CANNON_BARREL;
   public static final RegistryObject<Item> PARTICLE;
   public static final RegistryObject<Item> EMBER_PARTICLE;
   public static final RegistryObject<Item> ARMOR_PEELER_UNLOADED;
   public static final RegistryObject<Item> ARMOR_PEELER_ROCKET;
   public static final RegistryObject<Item> HEAT_SHELL;
   public static final RegistryObject<Item> AP_SHELL;
   public static final RegistryObject<Item> GRENADE;
   public static final RegistryObject<Item> TINYPROJECTILE_ITEM;
   public static final RegistryObject<Item> SHOTGUN_SHELL;
   public static final RegistryObject<Item> SHOTGUN_CASING;
   public static final RegistryObject<Item> BLAST_FURNACE;
   public static final RegistryObject<Item> BLAST_FURNACE_BRICKS;
   public static final RegistryObject<Item> BLAST_FURNACE_BRICK;
   public static final RegistryObject<Item> BLAST_FUNNEL;
   public static final RegistryObject<Item> FOUNDRY;
   public static final RegistryObject<Item> CONVEYOR;
   public static final RegistryObject<Item> SMALL_PROJECTILE;
   public static final RegistryObject<Item> FIREBOX;
   public static final RegistryObject<Item> LEAD_NUGGET;
   public static final RegistryObject<Item> CHISEL;
   public static final RegistryObject<Item> BRASS_PLATE;
   public static final RegistryObject<Item> ELECTRIC_MOTOR;
   public static final RegistryObject<Item> HAMMER;
   public static final RegistryObject<Item> CUTTERS;
   public static final RegistryObject<Item> COPPER_PLATE;
   public static final RegistryObject<Item> SMOKE_GRENADE;
   public static final RegistryObject<Item> AUTOCANNON;
   public static final RegistryObject<Item> AUTOCANNON_BARREL;
   public static final RegistryObject<Item> AUTOCANNON_DRUM;
   public static final RegistryObject<Item> RAZOR_WIRE;
   public static final RegistryObject<Item> WIRE_FENCE;
   public static final RegistryObject<Item> CONCRETE_WALL;
   public static final RegistryObject<Item> SHEET_METAL;
   public static final RegistryObject<Item> SHEET_METAL_PANE;
   public static final RegistryObject<Item> AUTOLOADER;
   public static final RegistryObject<Item> MUSKET_BALL;
   public static final RegistryObject<Item> PARTICLE_2;
   public static final RegistryObject<Item> FISSION_BOMB;
   public static final RegistryObject<Item> TRINITITE;
   public static final RegistryObject<Item> DEEPSLATE_LEAD_ORE;
   public static final RegistryObject<Item> RAW_LEAD;
   public static final RegistryObject<Item> RAW_LEAD_BLOCK;
   public static final RegistryObject<Item> LEAD_DUST;
   public static final RegistryObject<Item> BRASS_DUST;
   public static final RegistryObject<Item> RAW_NICKEL;
   public static final RegistryObject<Item> RAW_NICKEL_BLOCK;
   public static final RegistryObject<Item> NICKEL_DUST;
   public static final RegistryObject<Item> RAW_ZINC_BLOCK;
   public static final RegistryObject<Item> RAW_ZINC;
   public static final RegistryObject<Item> BAUXITE;
   public static final RegistryObject<Item> BAUXITE_DUST;
   public static final RegistryObject<Item> ALUMINUM_DUST;
   public static final RegistryObject<Item> IRON_DUST;
   public static final RegistryObject<Item> ZINC_DUST;
   public static final RegistryObject<Item> RAW_URANIUM;
   public static final RegistryObject<Item> URANIUM_NEURAL_INGOT;
   public static final RegistryObject<Item> URANIUM_NEUTRAL_DUST;
   public static final RegistryObject<Item> URANIUM_NEUTRALTINY_DUST;
   public static final RegistryObject<Item> URANIUM_ENRICHED_INGOT;
   public static final RegistryObject<Item> URANIUM_ENRICHED_DUST;
   public static final RegistryObject<Item> URANIUM_ENRICHED_TINY_DUST;
   public static final RegistryObject<Item> URANIUM_DEPLETED_INGOT;
   public static final RegistryObject<Item> URANIUM_DEPLETED_DUST;
   public static final RegistryObject<Item> URANIUM_DEPLETED_TINY_DUST;
   public static final RegistryObject<Item> MINERAL_GRINDER;
   public static final RegistryObject<Item> GOLD_DUST;
   public static final RegistryObject<Item> COPPER_DUST;
   public static final RegistryObject<Item> THERMOMETER;
   public static final RegistryObject<Item> FLAK_SHELL;
   public static final RegistryObject<Item> REBAR;
   public static final RegistryObject<Item> SMALL_BOMB;
   public static final RegistryObject<Item> CLUSTER_OF_BOMBS;
   public static final RegistryObject<Item> FLAME_THROWER_TANK_CHESTPLATE;
   public static final RegistryObject<Item> BULLET_RESISTANT_HELMET_HELMET;
   public static final RegistryObject<Item> SEMI_AUTOMATIC_RIFLE_ANIMATED;
   public static final RegistryObject<Item> SEMI_AUTOMATIC_PISTOL_ANIMATED;
   public static final RegistryObject<Item> BOLT_ACTION_RIFLE_ANIMATED;
   public static final RegistryObject<Item> SCOPED_BOLT_ACTION_RIFLE_ANIMATED;
   public static final RegistryObject<Item> PUMP_ACTION_SHOTGUN_ANIMATED;
   public static final RegistryObject<Item> ARMOR_PEELER_ANIMATED;
   public static final RegistryObject<Item> SMG_ANIMATED;
   public static final RegistryObject<Item> ARTILLERY_AUTOLOADER;
   public static final RegistryObject<Item> ARTILLERY_CHARGE_LOADER;
   public static final RegistryObject<Item> TORPEDO_THRUSTER;
   public static final RegistryObject<Item> TORPEDO_CORE;
   public static final RegistryObject<Item> TORPEDO_WARHEAD;
   public static final RegistryObject<Item> FLAME_THROWER_ANIMATED;
   public static final RegistryObject<Item> REVOLVER_ANIMATED;
   public static final RegistryObject<Item> SINGLE_SHOT_RIFLE;
   public static final RegistryObject<Item> ARTILLERY_SOLID_SHELL;
   public static final RegistryObject<Item> CRUDE_OIL_BUCKET;
   public static final RegistryObject<Item> OIL_BUCKET;
   public static final RegistryObject<Item> DIESEL_BUCKET;
   public static final RegistryObject<Item> KEROSENE_BUCKET;
   public static final RegistryObject<Item> PETROLIUM_BUCKET;
   public static final RegistryObject<Item> MEDIUM_PROJECTILE;
   public static final RegistryObject<Item> LARGE_PROJECTILE;
   public static final RegistryObject<Item> EXTRA_LARGE_PROJECTILE;
   public static final RegistryObject<Item> HUGE_PROJECTILE;
   public static final RegistryObject<Item> HOLLOWED_EXTRA_LARGE_PROJECTILE;
   public static final RegistryObject<Item> HOLLOWED_HUGE_PROJECTILE;
   public static final RegistryObject<Item> FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> COMPONENT_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> CYLINDER_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> SMALL_PROJECTILE_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> MEDIUM_PROJECTILE_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> LARGE_PROJECTILE_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> EXTRA_LARGE_PROJECTILE_TEMPLATE;
   public static final RegistryObject<Item> HUGE_PROJECTILE_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> SMALL_UNBORED_BARREL;
   public static final RegistryObject<Item> MEDIUM_UNBORED_BARREL;
   public static final RegistryObject<Item> LARGE_UNBORED_BARREL;
   public static final RegistryObject<Item> HUGE_UNBORED_BARREL;
   public static final RegistryObject<Item> SMALL_UNBORED_CANNON_BARREL;
   public static final RegistryObject<Item> MEDIUM_UNBORED_CANNON_BARREL;
   public static final RegistryObject<Item> LARGE_UNBORED_CANNON_BARREL;
   public static final RegistryObject<Item> HUGE_UNBORED_CANNON_BARREL;
   public static final RegistryObject<Item> LARGE_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> SMALL_BARREL_TEMPLATE;
   public static final RegistryObject<Item> MEDIUM_BARREL_TEMPLATE;
   public static final RegistryObject<Item> LARGE_BARREL_TEMPLATE;
   public static final RegistryObject<Item> HUGE_BARREL_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> SMALL_CANNON_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> MEDIUM_CANNON_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> LARGE_CANNON_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> HUGE_CANNON_FOUNDRY_TEMPLATE;
   public static final RegistryObject<Item> SMALL_BORED_BARREL;
   public static final RegistryObject<Item> MEDIUM_BORED_BARREL;
   public static final RegistryObject<Item> LARGE_BORED_BARREL;
   public static final RegistryObject<Item> HUGE_BORED_BARREL;
   public static final RegistryObject<Item> INCENDIARY_GRENADE;
   public static final RegistryObject<Item> INVISIBLEITEM;
   public static final RegistryObject<Item> RADIOACTIVE_ASH;
   public static final RegistryObject<Item> GEIGER_COUNTER;
   public static final RegistryObject<Item> RADIOACTIVE_ASH_FULL_BLOCK;
   public static final RegistryObject<Item> ASPHALT;
   public static final RegistryObject<Item> ROCKET_POD;
   public static final RegistryObject<Item> ROCKET_POD_CHAMBER;
   public static final RegistryObject<Item> JET_EXHAUST;
   public static final RegistryObject<Item> JET_TURBINE;
   public static final RegistryObject<Item> JET_COMPRESSOR;
   public static final RegistryObject<Item> SHEET_METAL_SLAB;
   public static final RegistryObject<Item> SHEET_METAL_STAIRS;
   public static final RegistryObject<Item> VOLATILE_DUST;
   public static final RegistryObject<Item> PROPELLENT;
   public static final RegistryObject<Item> LARGE_VOLATILE_PILE;
   public static final RegistryObject<Item> IMPACT_FUZE;
   public static final RegistryObject<Item> TIMED_FUZE;
   public static final RegistryObject<Item> LMG_ANIMATED;
   public static final RegistryObject<Item> LMG_MAGAZINE;
   public static final RegistryObject<Item> BURST_RIFLE;
   public static final RegistryObject<Item> INCENDIARY_BOTTLE;
   public static final RegistryObject<Item> MORTAR;
   public static final RegistryObject<Item> MORTAR_SHELL;
   public static final RegistryObject<Item> AIMER_NODE;
   public static final RegistryObject<Item> SAND_BAGS;
   public static final RegistryObject<Item> BODY_ARMOR_CHESTPLATE;
   public static final RegistryObject<Item> AUTO_PISTOL;
   public static final RegistryObject<Item> SIREN;
   public static final RegistryObject<Item> FIRING_PIN;
   public static final RegistryObject<Item> WEAPON_BOLT;
   public static final RegistryObject<Item> FIRING_MECHANISM;
   public static final RegistryObject<Item> PISTOL_RECEIVER;
   public static final RegistryObject<Item> REVOLVER_RECEIVER;
   public static final RegistryObject<Item> ADVANCED_PISTOL_RECEIVER;
   public static final RegistryObject<Item> BASIC_RECEIVER;
   public static final RegistryObject<Item> BOLT_ACTION_RECEIVER;
   public static final RegistryObject<Item> AUTOMATIC_RIFLE_RECEIVER;
   public static final RegistryObject<Item> ADVANCED_AUTOMATIC_RIFLE_RECEIVER;
   public static final RegistryObject<Item> SMG_RECEIVER;
   public static final RegistryObject<Item> MG_RECEIVER;
   public static final RegistryObject<Item> RIFLE_STOCK;
   public static final RegistryObject<Item> BREAK_ACTION_SHOTGUN_ANIMATED;
   public static final RegistryObject<Item> GREEN_ARMOR;
   public static final RegistryObject<Item> GREEN_ARMOR_SLAB;
   public static final RegistryObject<Item> GREEN_ARMOR_STAIRS;
   public static final RegistryObject<Item> GREEN_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> GREEN_ARMOR_OPTIC;
   public static final RegistryObject<Item> YELLOW_ARMOR;
   public static final RegistryObject<Item> YELLOW_ARMOR_SLAB;
   public static final RegistryObject<Item> YELLOW_ARMOR_STAIRS;
   public static final RegistryObject<Item> YELLOW_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> YELLOW_ARMOR_OPTIC;
   public static final RegistryObject<Item> BROWN_ARMOR;
   public static final RegistryObject<Item> BROWN_ARMOR_SLAB;
   public static final RegistryObject<Item> BROWN_ARMOR_STAIRS;
   public static final RegistryObject<Item> BROWN_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> BROWN_ARMOR_OPTIC;
   public static final RegistryObject<Item> WHITE_ARMOR;
   public static final RegistryObject<Item> WHITE_ARMOR_SLAB;
   public static final RegistryObject<Item> WHITE_ARMOR_STAIRS;
   public static final RegistryObject<Item> WHITE_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> WHITE_ARMOR_OPTIC;
   public static final RegistryObject<Item> LARGE_MAGAZINE;
   public static final RegistryObject<Item> BATTLE_RIFLE;
   public static final RegistryObject<Item> IRONGEAR;
   public static final RegistryObject<Item> ROTARY_AUTO_CANNON;
   public static final RegistryObject<Item> RAC_BARREL;
   public static final RegistryObject<Item> LIGHT_AUTOCANNON;
   public static final RegistryObject<Item> MACHINE_CARBINE;
   public static final RegistryObject<Item> SMOKE_MORTAR_SHELL;
   public static final RegistryObject<Item> SMOKE_LAUNCHER;
   public static final RegistryObject<Item> HE_PROJECTILE;
   public static final RegistryObject<Item> HEAT_PROJECTILE;
   public static final RegistryObject<Item> APFSDS_PROJECTILE;
   public static final RegistryObject<Item> SHAPED_CHARGE_FUZE;
   public static final RegistryObject<Item> FLAK_PROJECTILE;
   public static final RegistryObject<Item> HOLLOWED_LARGE_PROJECTILE;
   public static final RegistryObject<Item> SMALL_HE_PROJECTILE;
   public static final RegistryObject<Item> SMOKE_AGENT;
   public static final RegistryObject<Item> FIRE_AGENT;
   public static final RegistryObject<Item> IMPLOSION_MODULE;
   public static final RegistryObject<Item> URANIUM_ORE;
   public static final RegistryObject<Item> RED_ARMOR;
   public static final RegistryObject<Item> RED_ARMOR_SLAB;
   public static final RegistryObject<Item> RED_ARMOR_STAIRS;
   public static final RegistryObject<Item> RED_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> RED_ARMOR_OPTIC;
   public static final RegistryObject<Item> BLACK_ARMOR;
   public static final RegistryObject<Item> BLACK_ARMOR_SLAB;
   public static final RegistryObject<Item> BLACK_ARMOR_STAIRS;
   public static final RegistryObject<Item> BLACK_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> BLACK_ARMOR_OPTIC;
   public static final RegistryObject<Item> CYAN_ARMOR;
   public static final RegistryObject<Item> CYAN_ARMOR_SLAB;
   public static final RegistryObject<Item> CYAN_ARMOR_STAIRS;
   public static final RegistryObject<Item> CYAN_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> BLUE_ARMOR;
   public static final RegistryObject<Item> BLUE_ARMOR_SLAB;
   public static final RegistryObject<Item> BLUE_ARMOR_STAIRS;
   public static final RegistryObject<Item> BLUE_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> ORANGE_ARMOR;
   public static final RegistryObject<Item> ORANGE_ARMOR_SLAB;
   public static final RegistryObject<Item> ORANGE_ARMOR_STAIRS;
   public static final RegistryObject<Item> ORANGE_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> ORANGE_ARMOR_OPTIC;
   public static final RegistryObject<Item> GRAY_ARMOR;
   public static final RegistryObject<Item> GRAY_ARMOR_SLAB;
   public static final RegistryObject<Item> GRAY_ARMOR_STAIRS;
   public static final RegistryObject<Item> GRAY_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> GRAY_ARMOR_OPTIC;
   public static final RegistryObject<Item> LIME_ARMOR;
   public static final RegistryObject<Item> LIME_ARMOR_SLAB;
   public static final RegistryObject<Item> LIME_ARMOR_STAIRS;
   public static final RegistryObject<Item> LIME_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> LIME_ARMOR_OPTIC;
   public static final RegistryObject<Item> LIGHT_GRAY_ARMOR;
   public static final RegistryObject<Item> LIGHT_GRAY_ARMOR_SLAB;
   public static final RegistryObject<Item> LIGHT_GRAY_ARMOR_STAIRS;
   public static final RegistryObject<Item> LIGHT_GRAY_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> LIGHT_GRAY_ARMOR_OPTIC;
   public static final RegistryObject<Item> LIGHT_BLUE_ARMOR;
   public static final RegistryObject<Item> LIGHT_BLUE_ARMOR_SLAB;
   public static final RegistryObject<Item> LIGHT_BLUE_ARMOR_STAIRS;
   public static final RegistryObject<Item> LIGHT_BLUE_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> LIGHT_BLUE_ARMOR_OPTIC;
   public static final RegistryObject<Item> PLUTONIUM_INGOT;
   public static final RegistryObject<Item> REFINERY;
   public static final RegistryObject<Item> REFINERY_TOWER;
   public static final RegistryObject<Item> ADVANCED_COMPONENT;
   public static final RegistryObject<Item> SHALE_OIL;
   public static final RegistryObject<Item> BLAST_CLAY;
   public static final RegistryObject<Item> SULFUR_ORE;
   public static final RegistryObject<Item> SULFUR;
   public static final RegistryObject<Item> ALUMINUM_PLATE;
   public static final RegistryObject<Item> PLUTONIUM_NUGGET;
   public static final RegistryObject<Item> PLUTONIUM_CORE;
   public static final RegistryObject<Item> FISSION_CORE;
   public static final RegistryObject<Item> SHIELDING_COMPONENT;
   public static final RegistryObject<Item> IMPLOSION_LENS;
   public static final RegistryObject<Item> GIANT_COIL;
   public static final RegistryObject<Item> REACTION_CHAMBER;
   public static final RegistryObject<Item> BREEDER_REACTOR_PORT;
   public static final RegistryObject<Item> REACTIONCOMPONENT;
   public static final RegistryObject<Item> ALUMINUM_TINY_DUST;
   public static final RegistryObject<Item> OIL_FIREBOX;
   public static final RegistryObject<Item> DECIMATOR_SPAWN_EGG;
   public static final RegistryObject<Item> STRIKER_SPAWN_EGG;
   public static final RegistryObject<Item> FLAMER_SPAWN_EGG;
   public static final RegistryObject<Item> HUNTER_SPAWN_EGG;
   public static final RegistryObject<Item> SUMMONATOR;
   public static final RegistryObject<Item> SUMMONATOR_MODULE;
   public static final RegistryObject<Item> STEEL_DOOR;
   public static final RegistryObject<Item> OVERGROWN_REENFORCED_CONCRETE;
   public static final RegistryObject<Item> RUSTY_BLOCK;
   public static final RegistryObject<Item> CRACKED_CONCRETE_WALL;
   public static final RegistryObject<Item> FRACTURED_CONCRETE_WALL;
   public static final RegistryObject<Item> DAMAGED_CONCRETE_WALL;
   public static final RegistryObject<Item> DESTROYED_CONCRETE_WALL;
   public static final RegistryObject<Item> RUSTY_SLAB;
   public static final RegistryObject<Item> RUSTY_STAIRS;
   public static final RegistryObject<Item> RUSTY_TRAPDOOR;
   public static final RegistryObject<Item> ROBOT_CHUTE;
   public static final RegistryObject<Item> STRUCTURAL_CONCRETE;
   public static final RegistryObject<Item> STEEL_TRUSS;
   public static final RegistryObject<Item> SUMMONATOR_ACTIVE;
   public static final RegistryObject<Item> ACTIVE_ROBOT_CHUTE;
   public static final RegistryObject<Item> HAND_DRILL;
   public static final RegistryObject<Item> BRASS_FITTING;
   public static final RegistryObject<Item> COMBUSTION_CYLINDER;
   public static final RegistryObject<Item> ENGINE_COMPONENT;
   public static final RegistryObject<Item> SMALL_ENGINE;
   public static final RegistryObject<Item> BERYLLIUM_ORE;
   public static final RegistryObject<Item> RAW_BERYLLIUM;
   public static final RegistryObject<Item> BERYLLIUM_DUST;
   public static final RegistryObject<Item> BERYLLIUM_INGOT;
   public static final RegistryObject<Item> RAW_BERYLLIUM_BLOCK;
   public static final RegistryObject<Item> NEUTRON_REFLECTOR;
   public static final RegistryObject<Item> BREEDER_REACTOR_CORE;
   public static final RegistryObject<Item> BREEDER_REACTOR_INTERFACE;
   public static final RegistryObject<Item> REACTOR_CASING;
   public static final RegistryObject<Item> CONTROL_ROD;
   public static final RegistryObject<Item> EMPTY_FUEL_RODS;
   public static final RegistryObject<Item> FUEL_RODS_1;
   public static final RegistryObject<Item> FUEL_RODS_2;
   public static final RegistryObject<Item> FUEL_RODS_3;
   public static final RegistryObject<Item> FUEL_RODS_4;
   public static final RegistryObject<Item> FUEL_ROD;
   public static final RegistryObject<Item> SOLID_SHELL;
   public static final RegistryObject<Item> NVD_HELMET_HELMET;
   public static final RegistryObject<Item> TECH_COMPONENT;
   public static final RegistryObject<Item> SMALL_HOLLOW_POINT_BULLET;
   public static final RegistryObject<Item> SMALL_STEALTH_BULLET;
   public static final RegistryObject<Item> MEDIUM_AP_BULLET;
   public static final RegistryObject<Item> MEDIUM_STEALTH_BULLET;
   public static final RegistryObject<Item> AP_LARGE_BULLET;
   public static final RegistryObject<Item> STEALTH_LARGE_BULLET;
   public static final RegistryObject<Item> TRANSPARENT_ITEM;
   public static final RegistryObject<Item> BIRD_SHOT;
   public static final RegistryObject<Item> SLUG_SHELL;
   public static final RegistryObject<Item> RIFLER_SPAWN_EGG;
   public static final RegistryObject<Item> FLARE_PISTOL;
   public static final RegistryObject<Item> FLARE_CHARGE;
   public static final RegistryObject<Item> SCORCH_DIRT;
   public static final RegistryObject<Item> ALUMINUM_PLATING;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL;
   public static final RegistryObject<Item> GLASS_TRAPDOOR;
   public static final RegistryObject<Item> REINFORCED_GLASS;
   public static final RegistryObject<Item> REINFORCED_GLASS_TRAPDOOR;
   public static final RegistryObject<Item> AFTER_BURNER;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL;
   public static final RegistryObject<Item> GAS_BOMB;
   public static final RegistryObject<Item> TOXIC_AGENT;
   public static final RegistryObject<Item> GAS_ARTILLERY_SHELL;
   public static final RegistryObject<Item> GAS_DISPENSER;
   public static final RegistryObject<Item> NODE_TRIGGER;
   public static final RegistryObject<Item> NODE_TRIGGER_ON;
   public static final RegistryObject<Item> COUNTERMEASURE_DISPENSER;
   public static final RegistryObject<Item> MORTARER_SPAWN_EGG;
   public static final RegistryObject<Item> COMMANDER_SPAWN_EGG;
   public static final RegistryObject<Item> CIWS_SPAWN_EGG;
   public static final RegistryObject<Item> STEALTH_PISTOL;
   public static final RegistryObject<Item> WEAPON_SUPRESSOR;
   public static final RegistryObject<Item> ASPHALT_SLAB;
   public static final RegistryObject<Item> ORDINANCE_CORE;
   public static final RegistryObject<Item> ORDINANCE_FINS;
   public static final RegistryObject<Item> ORDINANCE_THRUSTER;
   public static final RegistryObject<Item> ORDINANCE_HEAVY_WARHEAD;
   public static final RegistryObject<Item> ORDINANCE_INCENDIARY_WARHEAD;
   public static final RegistryObject<Item> ORDINANCE_INLINE_WARHEAD;
   public static final RegistryObject<Item> ORDINANCE_KINETIC_HEAD;
   public static final RegistryObject<Item> ORDINANCE_IR_SEEKER_HEAD;
   public static final RegistryObject<Item> ORDINANCE_CLUSTER_WARHEAD;
   public static final RegistryObject<Item> ORDINANCE_INLINE_FISSION_WARHEAD;
   public static final RegistryObject<Item> ORDINANCE_FISSION_INITIATOR_HEAD;
   public static final RegistryObject<Item> SOLID_ROCKET_FUEL_PACK;
   public static final RegistryObject<Item> ANCIENT_LIGHT;
   public static final RegistryObject<Item> SUMMONATION;
   public static final RegistryObject<Item> OPEN_SUMMONATION;
   public static final RegistryObject<Item> LOOT_BOX;
   public static final RegistryObject<Item> GAS_MASK_HELMET;
   public static final RegistryObject<Item> DEFENSE_CORE;
   public static final RegistryObject<Item> ASSASSIN_SPAWN_EGG;
   public static final RegistryObject<Item> BLAST_ARMOR_HELMET;
   public static final RegistryObject<Item> BLAST_ARMOR_CHESTPLATE;
   public static final RegistryObject<Item> BLAST_ARMOR_LEGGINGS;
   public static final RegistryObject<Item> BLAST_ARMOR_BOOTS;
   public static final RegistryObject<Item> RAW_URANIUM_BLOCK;
   public static final RegistryObject<Item> ERADICATOR_SPAWN_EGG;
   public static final RegistryObject<Item> FUSION_BOMB;
   public static final RegistryObject<Item> SCOUT_SPAWN_EGG;
   public static final RegistryObject<Item> RAIDSCOUT_SPAWN_EGG;
   public static final RegistryObject<Item> BERYLLIUM_BLOCK;
   public static final RegistryObject<Item> POLISHED_TRINITITE;
   public static final RegistryObject<Item> SULFUR_BLOCK;
   public static final RegistryObject<Item> WORKER_SPAWN_EGG;
   public static final RegistryObject<Item> ANCIENT_WELL;
   public static final RegistryObject<Item> PASSENGER_SEAT;
   public static final RegistryObject<Item> BREECH_RIFLE;
   public static final RegistryObject<Item> EXTRA_LARGE_BULLET;
   public static final RegistryObject<Item> SCOPED_BREECH_RIFLE;
   public static final RegistryObject<Item> JET_GEARBOX;
   public static final RegistryObject<Item> GENERATOR;
   public static final RegistryObject<Item> GAS_MASK_HELMET_HELMET;
   public static final RegistryObject<Item> ERADICATION;
   public static final RegistryObject<Item> BULLET_RESISTANT_HELMET_2_HELMET;
   public static final RegistryObject<Item> BULLET_RESISTANT_HELMET_3_HELMET;
   public static final RegistryObject<Item> BULLET_RESISTANT_HELMET_4_HELMET;
   public static final RegistryObject<Item> FUEL_TANK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_DARK_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_DARK_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_DARK_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_DARK_GRAY;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_DARK_GRAY;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_DARK_GRAY;
   public static final RegistryObject<Item> EXTENSION_SHAFT;
   public static final RegistryObject<Item> DRIVE_SHAFT;
   public static final RegistryObject<Item> ENGINE_CYLLINDER;
   public static final RegistryObject<Item> LARGE_ENGINE_SMOKESTACK;
   public static final RegistryObject<Item> TINTED_GLASS_TRAPDOOR;
   public static final RegistryObject<Item> CYAN_ARMOR_OPTIC;
   public static final RegistryObject<Item> BLUE_ARMOR_OPTIC;
   public static final RegistryObject<Item> ENERGY_NODE;
   public static final RegistryObject<Item> ENERGY_BATTERY;
   public static final RegistryObject<Item> LARGE_ELECTRIC_MOTOR;
   public static final RegistryObject<Item> CABLE;
   public static final RegistryObject<Item> ENERGY_METER;
   public static final RegistryObject<Item> PINK_ARMOR;
   public static final RegistryObject<Item> PINK_ARMOR_SLAB;
   public static final RegistryObject<Item> PINK_ARMOR_STAIRS;
   public static final RegistryObject<Item> PINK_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> PINK_ARMOR_OPTIC;
   public static final RegistryObject<Item> MAGENTA_ARMOR;
   public static final RegistryObject<Item> MAGENTA_ARMOR_SLAB;
   public static final RegistryObject<Item> MAGENTA_ARMOR_STAIRS;
   public static final RegistryObject<Item> MAGENTA_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> MAGENTA_ARMOR_OPTIC;
   public static final RegistryObject<Item> PURPLE_ARMOR;
   public static final RegistryObject<Item> PURPLE_ARMOR_SLAB;
   public static final RegistryObject<Item> PURPLE_ARMOR_STAIRS;
   public static final RegistryObject<Item> PURPLE_ARMOR_TRAPDOOR;
   public static final RegistryObject<Item> PURPLE_ARMOR_OPTIC;
   public static final RegistryObject<Item> EXTRA_LARGE_CASING;
   public static final RegistryObject<Item> TURBINE_ROTOR;
   public static final RegistryObject<Item> ELECTRIC_FIREBOX;
   public static final RegistryObject<Item> THERMAL_FURNACE;
   public static final RegistryObject<Item> POWER_CELL;
   public static final RegistryObject<Item> POWER_REACTOR_INTERFACE;
   public static final RegistryObject<Item> POWER_REACTOR_PORT;
   public static final RegistryObject<Item> LEVER_RIFLE;
   public static final RegistryObject<Item> LAND_MINE;
   public static final RegistryObject<Item> AI_MINE;
   public static final RegistryObject<Item> REAPER_SPAWN_EGG;
   public static final RegistryObject<Item> FUSION_CORE;
   public static final RegistryObject<Item> ORDINANCE_INLINE_FUSION_WARHEAD_STAGE_1;
   public static final RegistryObject<Item> ORDINANCE_INLINE_FUSION_WARHEAD_STAGE_2;
   public static final RegistryObject<Item> BREACHER_SPAWN_EGG;
   public static final RegistryObject<Item> TRINITITE_SHARD;
   public static final RegistryObject<Item> TRINITITE_GLASS;
   public static final RegistryObject<Item> TRINITITE_GLASS_TRAPDOOR;
   public static final RegistryObject<Item> ENERGY_DISTRIBUTION_NODE;
   public static final RegistryObject<Item> FIRE_ARTILLERY_SHELL;
   public static final RegistryObject<Item> PAINT_TOOL;
   public static final RegistryObject<Item> AUTOMATIC_RIFLE;
   public static final RegistryObject<Item> MANUAL_CRANK;
   public static final RegistryObject<Item> LARGE_ROCKET_POD_CHAMBER;
   public static final RegistryObject<Item> LARGE_ROCKET_POD;
   public static final RegistryObject<Item> FIRE_SPEAR_ROCKET;
   public static final RegistryObject<Item> SEEKER_SPEAR_ROCKET;
   public static final RegistryObject<Item> EMPTY_MISSILE_HARDPOINT;
   public static final RegistryObject<Item> FIRE_SPEAR_MISSILE_HARDPOINT;
   public static final RegistryObject<Item> SEEKER_SPEAR_MISSILE_HARDPOINT;
   public static final RegistryObject<Item> STRIKE_SPEAR_MISSILE;
   public static final RegistryObject<Item> STRIKE_SPEAR_MISSILE_HARDPOINT;
   public static final RegistryObject<Item> LITHIUM_ORE;
   public static final RegistryObject<Item> RAW_LITHIUM;
   public static final RegistryObject<Item> LITHIUM_INGOT;
   public static final RegistryObject<Item> LITHIUM_NUGGET;
   public static final RegistryObject<Item> LITHIUM_DUST;
   public static final RegistryObject<Item> ENRICHED_LITHIUM_INGOT;
   public static final RegistryObject<Item> ENRICHED_LITHIUM_NUGGET;
   public static final RegistryObject<Item> TINY_LITHIUM_DEUTERIDE;
   public static final RegistryObject<Item> LITHIUM_DEUTERIDE;
   public static final RegistryObject<Item> THERMO_NUCLEAR_FUEL;
   public static final RegistryObject<Item> POLISHED_BAUXITE;
   public static final RegistryObject<Item> RAW_LITHIUM_BLOCK;
   public static final RegistryObject<Item> LITHIUM_BLOCK;
   public static final RegistryObject<Item> SMALL_FLAK_SHELL;
   public static final RegistryObject<Item> SMALL_FLAK_PROJECTILE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_GREEN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_GREEN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_GREEN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_GREEN;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_GREEN;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_GREEN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_YELLOW;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_YELLOW;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_YELLOW;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_YELLOW;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_YELLOW;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_YELLOW;
   public static final RegistryObject<Item> ALUMINUM_PLATING_BROWN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_BROWN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_BROWN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_BROWN;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_BROWN;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_BROWN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_RED;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_RED;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_RED;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_RED;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_RED;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_RED;
   public static final RegistryObject<Item> ALUMINUM_PLATING_WHITE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_WHITE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_WHITE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_WHITE;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_WHITE;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_WHITE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_BLUE;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_BLUE;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_ORANGE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_ORANGE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_ORANGE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_ORANGE;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_ORANGE;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_ORANGE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_CYAN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_CYAN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_CYAN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_CYAN;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_CYAN;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_CYAN;
   public static final RegistryObject<Item> ALUMINUM_PLATING_BLACK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_BLACK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_BLACK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_BLACK;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_BLACK;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_BLACK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_GRAY;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_GRAY;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_LIGHT_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_LIGHT_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_LIGHT_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_LIGHT_GRAY;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_LIGHT_GRAY;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_LIGHT_GRAY;
   public static final RegistryObject<Item> ALUMINUM_PLATING_LIME;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_LIME;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_LIME;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_LIME;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_LIME;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_LIME;
   public static final RegistryObject<Item> ALUMINUM_PLATING_LIGHT_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_LIGHT_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_LIGHT_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_LIGHT_BLUE;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_LIGHT_BLUE;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_LIGHT_BLUE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_PINK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_PINK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_PINK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_PINK;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_PINK;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_PINK;
   public static final RegistryObject<Item> ALUMINUM_PLATING_MAGENTA;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_MAGENTA;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_MAGENTA;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_MAGENTA;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_MAGENTA;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_MAGENTA;
   public static final RegistryObject<Item> ALUMINUM_PLATING_PURPLE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_SLAB_PURPLE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_STAIRS_PURPLE;
   public static final RegistryObject<Item> ALUMINUM_PLATING_TRAPDOOR_PURPLE;
   public static final RegistryObject<Item> ALUMINUM_SIDE_PANEL_PURPLE;
   public static final RegistryObject<Item> ALUMINUM_AC_BARREL_PURPLE;
   public static final RegistryObject<Item> MANUAL_AIMER;
   public static final RegistryObject<Item> SOLAR_GENERATOR;
   public static final RegistryObject<Item> RADAR_SPEAR_MISSILE_HARDPOINT;
   public static final RegistryObject<Item> RADAR_SPEAR_MISSILE;
   public static final RegistryObject<Item> RADAR_COMPONENT;
   public static final RegistryObject<Item> IR_COMPONENT;
   public static final RegistryObject<Item> CHAFF_CHARGE;
   public static final RegistryObject<Item> ORDINANCE_CONTROLLER;
   public static final RegistryObject<Item> ORDINANCE_SARH_SEEKER;
   public static final RegistryObject<Item> FUEL_TANK_MODULE;
   public static final RegistryObject<Item> FUEL_HOSE;
   public static final RegistryObject<Item> DAMAGEDFUELTANK;
   public static final RegistryObject<Item> FUEL_TANK_INPUT;
   public static final RegistryObject<Item> HEAVY_MACHINE_GUN;
   public static final RegistryObject<Item> LIGHT_MACHINE_GUN;
   public static final RegistryObject<Item> COVERED_MACHINE_GUN_BARREL;
   public static final RegistryObject<Item> REINFORCED_GLASS_STAIRS;
   public static final RegistryObject<Item> TINTED_GLASS_STAIRS;
   public static final RegistryObject<Item> TRINITITE_GLASS_STAIRS;
   public static final RegistryObject<Item> THICK_BATTLE_CANNON_BARREL;
   public static final RegistryObject<Item> GRENADE_LAUNCHER;
   public static final RegistryObject<Item> MEDIUM_PETROL_ENGINE;
   public static final RegistryObject<Item> SMALL_DIESEL_ENGINE;
   public static final RegistryObject<Item> THERMAL_SHELL;
   public static final RegistryObject<Item> FLAME_THROWER;
   public static final RegistryObject<Item> FLAME_THROWER_BARREL;
   public static final RegistryObject<Item> COVERED_FLAME_THROWER_BARREL;
   public static final RegistryObject<Item> ERA_4;
   public static final RegistryObject<Item> ERA_3;
   public static final RegistryObject<Item> ERA_2;
   public static final RegistryObject<Item> ERA_1;
   public static final RegistryObject<Item> HUGE_HE_BULLET;
   public static final RegistryObject<Item> ERA_TILE;
   public static final RegistryObject<Item> OFFSET_ERA_4;
   public static final RegistryObject<Item> OFFSET_ERA_3;
   public static final RegistryObject<Item> OFFSET_ERA_2;
   public static final RegistryObject<Item> OFFSET_ERA_1;
   public static final RegistryObject<Item> MEDIUM_DIESEL_ENGINE;
   public static final RegistryObject<Item> SMALL_PETROL_ENGINE;
   public static final RegistryObject<Item> PRODUCTION_INPUT;
   public static final RegistryObject<Item> PRODUCTION_OUTPUT;
   public static final RegistryObject<Item> ASSEMBLY_DEPOT;
   public static final RegistryObject<Item> ASSEMBLY_MACHINE;
   public static final RegistryObject<Item> ASSEMBLY_CRUSHER;
   public static final RegistryObject<Item> ASSEMBLY_FURNACE;
   public static final RegistryObject<Item> MECHANICAL_BORE;
   public static final RegistryObject<Item> MECHANICAL_PRESS;
   public static final RegistryObject<Item> MECHANICAL_EXTRUDER;
   public static final RegistryObject<Item> MECHANICAL_SHEAR;
   public static final RegistryObject<Item> STEEL_CRUSHING_WHEEL;
   public static final RegistryObject<Item> NITRATE;
   public static final RegistryObject<Item> NITRATE_BLOCK;
   public static final RegistryObject<Item> PROTOTYPE_ERADICATOR_SPAWN_EGG;
   public static final RegistryObject<Item> BAUXITE_DIGESTER;
   public static final RegistryObject<Item> ALUMINATE_DUST;
   public static final RegistryObject<Item> FILTERED_ALUMINATE_DUST;
   public static final RegistryObject<Item> ASSEMBLY_CENTRIFUGE_BOTTOM;
   public static final RegistryObject<Item> ASSEMBLY_CENTRIFUGE_MIDDLE;
   public static final RegistryObject<Item> ASSEMBLY_CENTRIFUGE_TOP;
   public static final RegistryObject<Item> CONVEYOR_SPLITTER;
   public static final RegistryObject<Item> LIGHT_WOOD_FRAME;
   public static final RegistryObject<Item> LIGHT_WOOD_BLOCK;
   public static final RegistryObject<Item> LIGHT_WOOD_SLAB;
   public static final RegistryObject<Item> LIGHT_WOOD_STAIRS;
   public static final RegistryObject<Item> LIGHT_WOOD_SIDE_PANEL;
   public static final RegistryObject<Item> LIGHT_WOOD_TRAPDOOR;
   public static final RegistryObject<Item> PRECISION_COMPONENT;
   public static final RegistryObject<Item> UNFABRICATED_TECH_COMPONENT;
   public static final RegistryObject<Item> ASSEMBLY_CIRCUIT_FABRICATOR;
   public static final RegistryObject<Item> ASSEMBLY_MECHANICAL_FABRICATOR;
   public static final RegistryObject<Item> PYROCHLORE_ORE;
   public static final RegistryObject<Item> PYROCHLORE;
   public static final RegistryObject<Item> PYROCHLORE_DUST;
   public static final RegistryObject<Item> FILTERED_PYROCHLORE_DUST;
   public static final RegistryObject<Item> NIOBIUM_DUST;
   public static final RegistryObject<Item> NIOBIUM_TINY_DUST;
   public static final RegistryObject<Item> NIOBIUM_INGOT;
   public static final RegistryObject<Item> NIOBIUM_BLOCK;
   public static final RegistryObject<Item> PYROCHLORE_BLOCK;
   public static final RegistryObject<Item> ADVANCED_ALLOY_MIXTURE;
   public static final RegistryObject<Item> COMPRESSED_ADVANCED_MIXTURE;
   public static final RegistryObject<Item> ADVANCED_ALLOY_INGOT;
   public static final RegistryObject<Item> ADVANCED_ALLOY_COMPONENT;
   public static final RegistryObject<Item> URANIUM_NEUTRAL_BLOCK;
   public static final RegistryObject<Item> URANIUM_ENRICHED_BLOCK;
   public static final RegistryObject<Item> URANIUM_DEPLETED_BLOCK;
   public static final RegistryObject<Item> PLUTONIUM_BLOCK;
   public static final RegistryObject<Item> GRENADE_SHELL;
   public static final RegistryObject<Item> SMOKE_GRENADE_SHELL;
   public static final RegistryObject<Item> SMOKE_SHELL;
   public static final RegistryObject<Item> SMOKE_PROJECTILE;
   public static final RegistryObject<Item> PHOSPHORUS_DUST;
   public static final RegistryObject<Item> CHLORINE_DUST;
   public static final RegistryObject<Item> ADVANCED_ALLOY_BLOCK;
   public static final RegistryObject<Item> PHOSPHATE_BLOCK;
   public static final RegistryObject<Item> SULFURIC_ACID_BUCKET;
   public static final RegistryObject<Item> HYDRAZINE_BUCKET;
   public static final RegistryObject<Item> GAS_CANISTER;

   private static RegistryObject<Item> block(RegistryObject<Block> block) {
      return REGISTRY.register(block.getId().getPath(), () -> {
         return new BlockItem((Block)block.get(), new Properties());
      });
   }

   private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
      return REGISTRY.register(block.getId().getPath(), () -> {
         return new DoubleHighBlockItem((Block)block.get(), new Properties());
      });
   }

   @SubscribeEvent
   public static void clientLoad(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         ItemProperties.register((Item)SMALLMAGAZINE.get(), new ResourceLocation("crusty_chunks:smallmagazine_ammunitionload"), (itemStackToRender, clientWorld, entity, itemEntityId) -> {
            return (float)MagazineLevelProcedure.execute(itemStackToRender);
         });
         ItemProperties.register((Item)MEDIUM_MAGAZINE.get(), new ResourceLocation("crusty_chunks:medium_magazine_ammo"), (itemStackToRender, clientWorld, entity, itemEntityId) -> {
            return (float)MagazineLevelProcedure.execute(itemStackToRender);
         });
         ItemProperties.register((Item)SMG_MAGAZINE.get(), new ResourceLocation("crusty_chunks:smg_magazine_ammo"), (itemStackToRender, clientWorld, entity, itemEntityId) -> {
            return (float)MagazineLevelProcedure.execute(itemStackToRender);
         });
         ItemProperties.register((Item)MACHINE_GUN_BOX.get(), new ResourceLocation("crusty_chunks:machine_gun_box_ammo"), (itemStackToRender, clientWorld, entity, itemEntityId) -> {
            return (float)MagazineLevelProcedure.execute(itemStackToRender);
         });
         ItemProperties.register((Item)LMG_MAGAZINE.get(), new ResourceLocation("crusty_chunks:lmg_magazine_ammo"), (itemStackToRender, clientWorld, entity, itemEntityId) -> {
            return (float)MagazineLevelProcedure.execute(itemStackToRender);
         });
         ItemProperties.register((Item)LARGE_MAGAZINE.get(), new ResourceLocation("crusty_chunks:large_magazine_ammo"), (itemStackToRender, clientWorld, entity, itemEntityId) -> {
            return (float)MagazineLevelProcedure.execute(itemStackToRender);
         });
      });
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "crusty_chunks");
      REDSTONE_TNT = block(CrustyChunksModBlocks.REDSTONE_TNT);
      EXPLOSIVE_BARREL = block(CrustyChunksModBlocks.EXPLOSIVE_BARREL);
      BURNTGRASS = block(CrustyChunksModBlocks.BURNTGRASS);
      HARDDIRT = block(CrustyChunksModBlocks.HARDDIRT);
      ZINC_INGOT = REGISTRY.register("zinc_ingot", () -> {
         return new ZincIngotItem();
      });
      ZINC_ORE = block(CrustyChunksModBlocks.ZINC_ORE);
      ZINC_BLOCK = block(CrustyChunksModBlocks.ZINC_BLOCK);
      BRASS_INGOT = REGISTRY.register("brass_ingot", () -> {
         return new BrassIngotItem();
      });
      BRASS_BLOCK = block(CrustyChunksModBlocks.BRASS_BLOCK);
      STEEL_INGOT = REGISTRY.register("steel_ingot", () -> {
         return new SteelIngotItem();
      });
      STEEL_BLOCK = block(CrustyChunksModBlocks.STEEL_BLOCK);
      SMALLBULLET = REGISTRY.register("smallbullet", () -> {
         return new SmallbulletItem();
      });
      BULLET = REGISTRY.register("bullet", () -> {
         return new BulletItem();
      });
      LARGE_BULLET = REGISTRY.register("large_bullet", () -> {
         return new LargeBulletItem();
      });
      HUGE_BULLET = REGISTRY.register("huge_bullet", () -> {
         return new HugeBulletItem();
      });
      SMALL_SHELL = REGISTRY.register("small_shell", () -> {
         return new SmallShellItem();
      });
      LARGE_SHELL = REGISTRY.register("large_shell", () -> {
         return new LargeShellItem();
      });
      POWDER_CHARGE = REGISTRY.register("powder_charge", () -> {
         return new PowderChargeItem();
      });
      ARTILLERY_SHELL = REGISTRY.register("artillery_shell", () -> {
         return new ArtilleryShellItem();
      });
      LEAD_INGOT = REGISTRY.register("lead_ingot", () -> {
         return new LeadIngotItem();
      });
      LEAD_ORE = block(CrustyChunksModBlocks.LEAD_ORE);
      LEAD_BLOCK = block(CrustyChunksModBlocks.LEAD_BLOCK);
      STEELPLATE = REGISTRY.register("steelplate", () -> {
         return new SteelplateItem();
      });
      STEEL_COMPONENT = REGISTRY.register("steel_component", () -> {
         return new SteelComponentItem();
      });
      CAST_COMPONENT = REGISTRY.register("cast_component", () -> {
         return new CastComponentItem();
      });
      STEEL_CYLINDER = REGISTRY.register("steel_cylinder", () -> {
         return new SteelCylinderItem();
      });
      STEEL_SPRING = REGISTRY.register("steel_spring", () -> {
         return new SteelSpringItem();
      });
      STEEL_TUBE = REGISTRY.register("steel_tube", () -> {
         return new SteelTubeItem();
      });
      STEEL_WIRE = REGISTRY.register("steel_wire", () -> {
         return new SteelWireItem();
      });
      CUT_COMPONENT = REGISTRY.register("cut_component", () -> {
         return new CutComponentItem();
      });
      BORED_COMPONENT = REGISTRY.register("bored_component", () -> {
         return new BoredComponentItem();
      });
      BENT_COMPONENT = REGISTRY.register("bent_component", () -> {
         return new BentComponentItem();
      });
      STEEL_GEAR = REGISTRY.register("steel_gear", () -> {
         return new SteelGearItem();
      });
      WOOD_COMPONENT = REGISTRY.register("wood_component", () -> {
         return new WoodComponentItem();
      });
      SMALL_CASING = REGISTRY.register("small_casing", () -> {
         return new SmallCasingItem();
      });
      MEDIUM_CASING = REGISTRY.register("medium_casing", () -> {
         return new MediumCasingItem();
      });
      LARGE_CASING = REGISTRY.register("large_casing", () -> {
         return new LargeCasingItem();
      });
      HUGE_CASING = REGISTRY.register("huge_casing", () -> {
         return new HugeCasingItem();
      });
      SMALLMAGAZINE = REGISTRY.register("smallmagazine", () -> {
         return new SmallmagazineItem();
      });
      MEDIUM_MAGAZINE = REGISTRY.register("medium_magazine", () -> {
         return new MediumMagazineItem();
      });
      COPPER_COIL = REGISTRY.register("copper_coil", () -> {
         return new CopperCoilItem();
      });
      COPPER_WIRE = REGISTRY.register("copper_wire", () -> {
         return new CopperWireItem();
      });
      NICKEL_INGOT = REGISTRY.register("nickel_ingot", () -> {
         return new NickelIngotItem();
      });
      NICKEL_ORE = block(CrustyChunksModBlocks.NICKEL_ORE);
      NICKEL_BLOCK = block(CrustyChunksModBlocks.NICKEL_BLOCK);
      TAR = block(CrustyChunksModBlocks.TAR);
      STEEL_PLATING = block(CrustyChunksModBlocks.STEEL_PLATING);
      STEEL_PLATING_SLAB = block(CrustyChunksModBlocks.STEEL_PLATING_SLAB);
      STEEL_PLATING_STAIRS = block(CrustyChunksModBlocks.STEEL_PLATING_STAIRS);
      SMOKE_BOMB = block(CrustyChunksModBlocks.SMOKE_BOMB);
      STEEL_TRAPDOOR = block(CrustyChunksModBlocks.STEEL_TRAPDOOR);
      STEEL_OPTIC = block(CrustyChunksModBlocks.STEEL_OPTIC);
      CHARRED_BLOCK = block(CrustyChunksModBlocks.CHARRED_BLOCK);
      REENFORCED_CONCRETE = block(CrustyChunksModBlocks.REENFORCED_CONCRETE);
      CRACKED_CONCRETE = block(CrustyChunksModBlocks.CRACKED_CONCRETE);
      FRACTURED_CONCRETE = block(CrustyChunksModBlocks.FRACTURED_CONCRETE);
      DAMAGED_CONCRETE = block(CrustyChunksModBlocks.DAMAGED_CONCRETE);
      DESTROYED_CONCRETE = block(CrustyChunksModBlocks.DESTROYED_CONCRETE);
      ALUMINUM_INGOT = REGISTRY.register("aluminum_ingot", () -> {
         return new AluminumIngotItem();
      });
      ALUMINUM_BLOCK = block(CrustyChunksModBlocks.ALUMINUM_BLOCK);
      SMG_MAGAZINE = REGISTRY.register("smg_magazine", () -> {
         return new SMGMagazineItem();
      });
      MACHINE_GUN = block(CrustyChunksModBlocks.MACHINE_GUN);
      MACHINE_GUN_BARREL = block(CrustyChunksModBlocks.MACHINE_GUN_BARREL);
      AIMER = REGISTRY.register("aimer", () -> {
         return new AimerItem();
      });
      ARTILLERYBREECH = block(CrustyChunksModBlocks.ARTILLERYBREECH);
      ARTILLERY_BARREL = block(CrustyChunksModBlocks.ARTILLERY_BARREL);
      MACHINE_GUN_BOX = REGISTRY.register("machine_gun_box", () -> {
         return new MachineGunBoxItem();
      });
      BATTLE_CANNON_BREECH = block(CrustyChunksModBlocks.BATTLE_CANNON_BREECH);
      BATTLE_CANNON_BARREL = block(CrustyChunksModBlocks.BATTLE_CANNON_BARREL);
      PARTICLE = REGISTRY.register("particle", () -> {
         return new ParticleItem();
      });
      EMBER_PARTICLE = REGISTRY.register("ember_particle", () -> {
         return new EmberParticleItem();
      });
      ARMOR_PEELER_UNLOADED = REGISTRY.register("armor_peeler_unloaded", () -> {
         return new ArmorPeelerUnloadedItem();
      });
      ARMOR_PEELER_ROCKET = REGISTRY.register("armor_peeler_rocket", () -> {
         return new ArmorPeelerRocketItem();
      });
      HEAT_SHELL = REGISTRY.register("heat_shell", () -> {
         return new HeatShellItem();
      });
      AP_SHELL = REGISTRY.register("ap_shell", () -> {
         return new APShellItem();
      });
      GRENADE = REGISTRY.register("grenade", () -> {
         return new GrenadeItem();
      });
      TINYPROJECTILE_ITEM = REGISTRY.register("tinyprojectile_item", () -> {
         return new TinyprojectileItemItem();
      });
      SHOTGUN_SHELL = REGISTRY.register("shotgun_shell", () -> {
         return new ShotgunShellItem();
      });
      SHOTGUN_CASING = REGISTRY.register("shotgun_casing", () -> {
         return new ShotgunCasingItem();
      });
      BLAST_FURNACE = block(CrustyChunksModBlocks.BLAST_FURNACE);
      BLAST_FURNACE_BRICKS = block(CrustyChunksModBlocks.BLAST_FURNACE_BRICKS);
      BLAST_FURNACE_BRICK = REGISTRY.register("blast_furnace_brick", () -> {
         return new BlastFurnaceBrickItem();
      });
      BLAST_FUNNEL = block(CrustyChunksModBlocks.BLAST_FUNNEL);
      FOUNDRY = block(CrustyChunksModBlocks.FOUNDRY);
      CONVEYOR = block(CrustyChunksModBlocks.CONVEYOR);
      SMALL_PROJECTILE = REGISTRY.register("small_projectile", () -> {
         return new SmallProjectileItem();
      });
      FIREBOX = block(CrustyChunksModBlocks.FIREBOX);
      LEAD_NUGGET = REGISTRY.register("lead_nugget", () -> {
         return new LeadNuggetItem();
      });
      CHISEL = REGISTRY.register("chisel", () -> {
         return new ChiselItem();
      });
      BRASS_PLATE = REGISTRY.register("brass_plate", () -> {
         return new BrassPlateItem();
      });
      ELECTRIC_MOTOR = REGISTRY.register("electric_motor", () -> {
         return new ElectricMotorItem();
      });
      HAMMER = REGISTRY.register("hammer", () -> {
         return new HammerItem();
      });
      CUTTERS = REGISTRY.register("cutters", () -> {
         return new CuttersItem();
      });
      COPPER_PLATE = REGISTRY.register("copper_plate", () -> {
         return new CopperPlateItem();
      });
      SMOKE_GRENADE = REGISTRY.register("smoke_grenade", () -> {
         return new SmokeGrenadeItem();
      });
      AUTOCANNON = block(CrustyChunksModBlocks.AUTOCANNON);
      AUTOCANNON_BARREL = block(CrustyChunksModBlocks.AUTOCANNON_BARREL);
      AUTOCANNON_DRUM = block(CrustyChunksModBlocks.AUTOCANNON_DRUM);
      RAZOR_WIRE = block(CrustyChunksModBlocks.RAZOR_WIRE);
      WIRE_FENCE = block(CrustyChunksModBlocks.WIRE_FENCE);
      CONCRETE_WALL = block(CrustyChunksModBlocks.CONCRETE_WALL);
      SHEET_METAL = block(CrustyChunksModBlocks.SHEET_METAL);
      SHEET_METAL_PANE = block(CrustyChunksModBlocks.SHEET_METAL_PANE);
      AUTOLOADER = block(CrustyChunksModBlocks.AUTOLOADER);
      MUSKET_BALL = REGISTRY.register("musket_ball", () -> {
         return new MusketBallItem();
      });
      PARTICLE_2 = REGISTRY.register("particle_2", () -> {
         return new Particle2Item();
      });
      FISSION_BOMB = block(CrustyChunksModBlocks.FISSION_BOMB);
      TRINITITE = block(CrustyChunksModBlocks.TRINITITE);
      DEEPSLATE_LEAD_ORE = block(CrustyChunksModBlocks.DEEPSLATE_LEAD_ORE);
      RAW_LEAD = REGISTRY.register("raw_lead", () -> {
         return new RawLeadItem();
      });
      RAW_LEAD_BLOCK = block(CrustyChunksModBlocks.RAW_LEAD_BLOCK);
      LEAD_DUST = REGISTRY.register("lead_dust", () -> {
         return new LeadDustItem();
      });
      BRASS_DUST = REGISTRY.register("brass_dust", () -> {
         return new BrassDustItem();
      });
      RAW_NICKEL = REGISTRY.register("raw_nickel", () -> {
         return new RawNickelItem();
      });
      RAW_NICKEL_BLOCK = block(CrustyChunksModBlocks.RAW_NICKEL_BLOCK);
      NICKEL_DUST = REGISTRY.register("nickel_dust", () -> {
         return new NickelDustItem();
      });
      RAW_ZINC_BLOCK = block(CrustyChunksModBlocks.RAW_ZINC_BLOCK);
      RAW_ZINC = REGISTRY.register("raw_zinc", () -> {
         return new RawZincItem();
      });
      BAUXITE = block(CrustyChunksModBlocks.BAUXITE);
      BAUXITE_DUST = REGISTRY.register("bauxite_dust", () -> {
         return new BauxiteDustItem();
      });
      ALUMINUM_DUST = REGISTRY.register("aluminum_dust", () -> {
         return new AluminumDustItem();
      });
      IRON_DUST = REGISTRY.register("iron_dust", () -> {
         return new IronDustItem();
      });
      ZINC_DUST = REGISTRY.register("zinc_dust", () -> {
         return new ZincDustItem();
      });
      RAW_URANIUM = REGISTRY.register("raw_uranium", () -> {
         return new RawUraniumItem();
      });
      URANIUM_NEURAL_INGOT = REGISTRY.register("uranium_neural_ingot", () -> {
         return new UraniumNeuralIngotItem();
      });
      URANIUM_NEUTRAL_DUST = REGISTRY.register("uranium_neutral_dust", () -> {
         return new UraniumNeutralDustItem();
      });
      URANIUM_NEUTRALTINY_DUST = REGISTRY.register("uranium_neutraltiny_dust", () -> {
         return new UraniumNeutraltinyDustItem();
      });
      URANIUM_ENRICHED_INGOT = REGISTRY.register("uranium_enriched_ingot", () -> {
         return new UraniumEnrichedIngotItem();
      });
      URANIUM_ENRICHED_DUST = REGISTRY.register("uranium_enriched_dust", () -> {
         return new UraniumEnrichedDustItem();
      });
      URANIUM_ENRICHED_TINY_DUST = REGISTRY.register("uranium_enriched_tiny_dust", () -> {
         return new UraniumEnrichedTinyDustItem();
      });
      URANIUM_DEPLETED_INGOT = REGISTRY.register("uranium_depleted_ingot", () -> {
         return new UraniumDepletedIngotItem();
      });
      URANIUM_DEPLETED_DUST = REGISTRY.register("uranium_depleted_dust", () -> {
         return new UraniumDepletedDustItem();
      });
      URANIUM_DEPLETED_TINY_DUST = REGISTRY.register("uranium_depleted_tiny_dust", () -> {
         return new UraniumDepletedTinyDustItem();
      });
      MINERAL_GRINDER = block(CrustyChunksModBlocks.MINERAL_GRINDER);
      GOLD_DUST = REGISTRY.register("gold_dust", () -> {
         return new GoldDustItem();
      });
      COPPER_DUST = REGISTRY.register("copper_dust", () -> {
         return new CopperDustItem();
      });
      THERMOMETER = REGISTRY.register("thermometer", () -> {
         return new ThermometerItem();
      });
      FLAK_SHELL = REGISTRY.register("flak_shell", () -> {
         return new FlakShellItem();
      });
      REBAR = block(CrustyChunksModBlocks.REBAR);
      SMALL_BOMB = block(CrustyChunksModBlocks.SMALL_BOMB);
      CLUSTER_OF_BOMBS = block(CrustyChunksModBlocks.CLUSTER_OF_BOMBS);
      FLAME_THROWER_TANK_CHESTPLATE = REGISTRY.register("flame_thrower_tank_chestplate", () -> {
         return new FlameThrowerTankItem.Chestplate();
      });
      BULLET_RESISTANT_HELMET_HELMET = REGISTRY.register("bullet_resistant_helmet_helmet", () -> {
         return new BulletResistantHelmetItem.Helmet();
      });
      SEMI_AUTOMATIC_RIFLE_ANIMATED = REGISTRY.register("semi_automatic_rifle_animated", () -> {
         return new SemiAutomaticRifleAnimatedItem();
      });
      SEMI_AUTOMATIC_PISTOL_ANIMATED = REGISTRY.register("semi_automatic_pistol_animated", () -> {
         return new SemiAutomaticPistolAnimatedItem();
      });
      BOLT_ACTION_RIFLE_ANIMATED = REGISTRY.register("bolt_action_rifle_animated", () -> {
         return new BoltActionRifleAnimatedItem();
      });
      SCOPED_BOLT_ACTION_RIFLE_ANIMATED = REGISTRY.register("scoped_bolt_action_rifle_animated", () -> {
         return new ScopedBoltActionRifleAnimatedItem();
      });
      PUMP_ACTION_SHOTGUN_ANIMATED = REGISTRY.register("pump_action_shotgun_animated", () -> {
         return new PumpActionShotgunAnimatedItem();
      });
      ARMOR_PEELER_ANIMATED = REGISTRY.register("armor_peeler_animated", () -> {
         return new ArmorPeelerAnimatedItem();
      });
      SMG_ANIMATED = REGISTRY.register("smg_animated", () -> {
         return new SMGAnimatedItem();
      });
      ARTILLERY_AUTOLOADER = block(CrustyChunksModBlocks.ARTILLERY_AUTOLOADER);
      ARTILLERY_CHARGE_LOADER = block(CrustyChunksModBlocks.ARTILLERY_CHARGE_LOADER);
      TORPEDO_THRUSTER = block(CrustyChunksModBlocks.TORPEDO_THRUSTER);
      TORPEDO_CORE = block(CrustyChunksModBlocks.TORPEDO_CORE);
      TORPEDO_WARHEAD = block(CrustyChunksModBlocks.TORPEDO_WARHEAD);
      FLAME_THROWER_ANIMATED = REGISTRY.register("flame_thrower_animated", () -> {
         return new FlameThrowerAnimatedItem();
      });
      REVOLVER_ANIMATED = REGISTRY.register("revolver_animated", () -> {
         return new RevolverAnimatedItem();
      });
      SINGLE_SHOT_RIFLE = REGISTRY.register("single_shot_rifle", () -> {
         return new SingleShotRifleItem();
      });
      ARTILLERY_SOLID_SHELL = REGISTRY.register("artillery_solid_shell", () -> {
         return new ArtillerySolidShellItem();
      });
      CRUDE_OIL_BUCKET = REGISTRY.register("crude_oil_bucket", () -> {
         return new CrudeOilItem();
      });
      OIL_BUCKET = REGISTRY.register("oil_bucket", () -> {
         return new OilItem();
      });
      DIESEL_BUCKET = REGISTRY.register("diesel_bucket", () -> {
         return new DieselItem();
      });
      KEROSENE_BUCKET = REGISTRY.register("kerosene_bucket", () -> {
         return new KeroseneItem();
      });
      PETROLIUM_BUCKET = REGISTRY.register("petrolium_bucket", () -> {
         return new PetroliumItem();
      });
      MEDIUM_PROJECTILE = REGISTRY.register("medium_projectile", () -> {
         return new MediumProjectileItem();
      });
      LARGE_PROJECTILE = REGISTRY.register("large_projectile", () -> {
         return new LargeProjectileItem();
      });
      EXTRA_LARGE_PROJECTILE = REGISTRY.register("extra_large_projectile", () -> {
         return new ExtraLargeProjectileItem();
      });
      HUGE_PROJECTILE = REGISTRY.register("huge_projectile", () -> {
         return new HugeProjectileItem();
      });
      HOLLOWED_EXTRA_LARGE_PROJECTILE = REGISTRY.register("hollowed_extra_large_projectile", () -> {
         return new HollowedExtraLargeProjectileItem();
      });
      HOLLOWED_HUGE_PROJECTILE = REGISTRY.register("hollowed_huge_projectile", () -> {
         return new HollowedHugeProjectileItem();
      });
      FOUNDRY_TEMPLATE = REGISTRY.register("foundry_template", () -> {
         return new FoundryTemplateItem();
      });
      COMPONENT_FOUNDRY_TEMPLATE = REGISTRY.register("component_foundry_template", () -> {
         return new ComponentFoundryTemplateItem();
      });
      CYLINDER_FOUNDRY_TEMPLATE = REGISTRY.register("cylinder_foundry_template", () -> {
         return new CylinderFoundryTemplateItem();
      });
      SMALL_PROJECTILE_FOUNDRY_TEMPLATE = REGISTRY.register("small_projectile_foundry_template", () -> {
         return new SmallProjectileFoundryTemplateItem();
      });
      MEDIUM_PROJECTILE_FOUNDRY_TEMPLATE = REGISTRY.register("medium_projectile_foundry_template", () -> {
         return new MediumProjectileFoundryTemplateItem();
      });
      LARGE_PROJECTILE_FOUNDRY_TEMPLATE = REGISTRY.register("large_projectile_foundry_template", () -> {
         return new LargeProjectileFoundryTemplateItem();
      });
      EXTRA_LARGE_PROJECTILE_TEMPLATE = REGISTRY.register("extra_large_projectile_template", () -> {
         return new ExtraLargeProjectileTemplateItem();
      });
      HUGE_PROJECTILE_FOUNDRY_TEMPLATE = REGISTRY.register("huge_projectile_foundry_template", () -> {
         return new HugeProjectileFoundryTemplateItem();
      });
      SMALL_UNBORED_BARREL = REGISTRY.register("small_unbored_barrel", () -> {
         return new SmallUnboredBarrelItem();
      });
      MEDIUM_UNBORED_BARREL = REGISTRY.register("medium_unbored_barrel", () -> {
         return new MediumUnboredBarrelItem();
      });
      LARGE_UNBORED_BARREL = REGISTRY.register("large_unbored_barrel", () -> {
         return new LargeUnboredBarrelItem();
      });
      HUGE_UNBORED_BARREL = REGISTRY.register("huge_unbored_barrel", () -> {
         return new HugeUnboredBarrelItem();
      });
      SMALL_UNBORED_CANNON_BARREL = REGISTRY.register("small_unbored_cannon_barrel", () -> {
         return new SmallUnboredCannonBarrelItem();
      });
      MEDIUM_UNBORED_CANNON_BARREL = REGISTRY.register("medium_unbored_cannon_barrel", () -> {
         return new MediumUnboredCannonBarrelItem();
      });
      LARGE_UNBORED_CANNON_BARREL = REGISTRY.register("large_unbored_cannon_barrel", () -> {
         return new LargeUnboredCannonBarrelItem();
      });
      HUGE_UNBORED_CANNON_BARREL = REGISTRY.register("huge_unbored_cannon_barrel", () -> {
         return new HugeUnboredCannonBarrelItem();
      });
      LARGE_FOUNDRY_TEMPLATE = REGISTRY.register("large_foundry_template", () -> {
         return new LargeFoundryTemplateItem();
      });
      SMALL_BARREL_TEMPLATE = REGISTRY.register("small_barrel_template", () -> {
         return new SmallBarrelTemplateItem();
      });
      MEDIUM_BARREL_TEMPLATE = REGISTRY.register("medium_barrel_template", () -> {
         return new MediumBarrelTemplateItem();
      });
      LARGE_BARREL_TEMPLATE = REGISTRY.register("large_barrel_template", () -> {
         return new LargeBarrelTemplateItem();
      });
      HUGE_BARREL_FOUNDRY_TEMPLATE = REGISTRY.register("huge_barrel_foundry_template", () -> {
         return new HugeBarrelFoundryTemplateItem();
      });
      SMALL_CANNON_FOUNDRY_TEMPLATE = REGISTRY.register("small_cannon_foundry_template", () -> {
         return new SmallCannonFoundryTemplateItem();
      });
      MEDIUM_CANNON_FOUNDRY_TEMPLATE = REGISTRY.register("medium_cannon_foundry_template", () -> {
         return new MediumCannonFoundryTemplateItem();
      });
      LARGE_CANNON_FOUNDRY_TEMPLATE = REGISTRY.register("large_cannon_foundry_template", () -> {
         return new LargeCannonFoundryTemplateItem();
      });
      HUGE_CANNON_FOUNDRY_TEMPLATE = REGISTRY.register("huge_cannon_foundry_template", () -> {
         return new HugeCannonFoundryTemplateItem();
      });
      SMALL_BORED_BARREL = REGISTRY.register("small_bored_barrel", () -> {
         return new SmallBoredBarrelItem();
      });
      MEDIUM_BORED_BARREL = REGISTRY.register("medium_bored_barrel", () -> {
         return new MediumBoredBarrelItem();
      });
      LARGE_BORED_BARREL = REGISTRY.register("large_bored_barrel", () -> {
         return new LargeBoredBarrelItem();
      });
      HUGE_BORED_BARREL = REGISTRY.register("huge_bored_barrel", () -> {
         return new HugeBoredBarrelItem();
      });
      INCENDIARY_GRENADE = REGISTRY.register("incendiary_grenade", () -> {
         return new IncendiaryGrenadeItem();
      });
      INVISIBLEITEM = REGISTRY.register("invisibleitem", () -> {
         return new InvisibleitemItem();
      });
      RADIOACTIVE_ASH = block(CrustyChunksModBlocks.RADIOACTIVE_ASH);
      GEIGER_COUNTER = REGISTRY.register("geiger_counter", () -> {
         return new GeigerCounterItem();
      });
      RADIOACTIVE_ASH_FULL_BLOCK = block(CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK);
      ASPHALT = block(CrustyChunksModBlocks.ASPHALT);
      ROCKET_POD = block(CrustyChunksModBlocks.ROCKET_POD);
      ROCKET_POD_CHAMBER = block(CrustyChunksModBlocks.ROCKET_POD_CHAMBER);
      JET_EXHAUST = block(CrustyChunksModBlocks.JET_EXHAUST);
      JET_TURBINE = block(CrustyChunksModBlocks.JET_TURBINE);
      JET_COMPRESSOR = block(CrustyChunksModBlocks.JET_COMPRESSOR);
      SHEET_METAL_SLAB = block(CrustyChunksModBlocks.SHEET_METAL_SLAB);
      SHEET_METAL_STAIRS = block(CrustyChunksModBlocks.SHEET_METAL_STAIRS);
      VOLATILE_DUST = REGISTRY.register("volatile_dust", () -> {
         return new VolatileDustItem();
      });
      PROPELLENT = REGISTRY.register("propellent", () -> {
         return new PropellentItem();
      });
      LARGE_VOLATILE_PILE = REGISTRY.register("large_volatile_pile", () -> {
         return new LargeVolatilePileItem();
      });
      IMPACT_FUZE = REGISTRY.register("impact_fuze", () -> {
         return new ImpactFuzeItem();
      });
      TIMED_FUZE = REGISTRY.register("timed_fuze", () -> {
         return new TimedFuzeItem();
      });
      LMG_ANIMATED = REGISTRY.register("lmg_animated", () -> {
         return new LMGAnimatedItem();
      });
      LMG_MAGAZINE = REGISTRY.register("lmg_magazine", () -> {
         return new LMGMagazineItem();
      });
      BURST_RIFLE = REGISTRY.register("burst_rifle", () -> {
         return new BurstRifleItem();
      });
      INCENDIARY_BOTTLE = REGISTRY.register("incendiary_bottle", () -> {
         return new IncendiaryBottleItem();
      });
      MORTAR = block(CrustyChunksModBlocks.MORTAR);
      MORTAR_SHELL = REGISTRY.register("mortar_shell", () -> {
         return new MortarShellItem();
      });
      AIMER_NODE = block(CrustyChunksModBlocks.AIMER_NODE);
      SAND_BAGS = block(CrustyChunksModBlocks.SAND_BAGS);
      BODY_ARMOR_CHESTPLATE = REGISTRY.register("body_armor_chestplate", () -> {
         return new BodyArmorItem.Chestplate();
      });
      AUTO_PISTOL = REGISTRY.register("auto_pistol", () -> {
         return new AutoPistolItem();
      });
      SIREN = block(CrustyChunksModBlocks.SIREN);
      FIRING_PIN = REGISTRY.register("firing_pin", () -> {
         return new FiringPinItem();
      });
      WEAPON_BOLT = REGISTRY.register("weapon_bolt", () -> {
         return new WeaponBoltItem();
      });
      FIRING_MECHANISM = REGISTRY.register("firing_mechanism", () -> {
         return new FiringMechanismItem();
      });
      PISTOL_RECEIVER = REGISTRY.register("pistol_receiver", () -> {
         return new PistolReceiverItem();
      });
      REVOLVER_RECEIVER = REGISTRY.register("revolver_receiver", () -> {
         return new RevolverReceiverItem();
      });
      ADVANCED_PISTOL_RECEIVER = REGISTRY.register("advanced_pistol_receiver", () -> {
         return new AdvancedPistolReceiverItem();
      });
      BASIC_RECEIVER = REGISTRY.register("basic_receiver", () -> {
         return new BasicReceiverItem();
      });
      BOLT_ACTION_RECEIVER = REGISTRY.register("bolt_action_receiver", () -> {
         return new BoltActionReceiverItem();
      });
      AUTOMATIC_RIFLE_RECEIVER = REGISTRY.register("automatic_rifle_receiver", () -> {
         return new AutomaticRifleReceiverItem();
      });
      ADVANCED_AUTOMATIC_RIFLE_RECEIVER = REGISTRY.register("advanced_automatic_rifle_receiver", () -> {
         return new AdvancedAutomaticRifleReceiverItem();
      });
      SMG_RECEIVER = REGISTRY.register("smg_receiver", () -> {
         return new SMGReceiverItem();
      });
      MG_RECEIVER = REGISTRY.register("mg_receiver", () -> {
         return new MGReceiverItem();
      });
      RIFLE_STOCK = REGISTRY.register("rifle_stock", () -> {
         return new RifleStockItem();
      });
      BREAK_ACTION_SHOTGUN_ANIMATED = REGISTRY.register("break_action_shotgun_animated", () -> {
         return new BreakActionShotgunAnimatedItem();
      });
      GREEN_ARMOR = block(CrustyChunksModBlocks.GREEN_ARMOR);
      GREEN_ARMOR_SLAB = block(CrustyChunksModBlocks.GREEN_ARMOR_SLAB);
      GREEN_ARMOR_STAIRS = block(CrustyChunksModBlocks.GREEN_ARMOR_STAIRS);
      GREEN_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.GREEN_ARMOR_TRAPDOOR);
      GREEN_ARMOR_OPTIC = block(CrustyChunksModBlocks.GREEN_ARMOR_OPTIC);
      YELLOW_ARMOR = block(CrustyChunksModBlocks.YELLOW_ARMOR);
      YELLOW_ARMOR_SLAB = block(CrustyChunksModBlocks.YELLOW_ARMOR_SLAB);
      YELLOW_ARMOR_STAIRS = block(CrustyChunksModBlocks.YELLOW_ARMOR_STAIRS);
      YELLOW_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.YELLOW_ARMOR_TRAPDOOR);
      YELLOW_ARMOR_OPTIC = block(CrustyChunksModBlocks.YELLOW_ARMOR_OPTIC);
      BROWN_ARMOR = block(CrustyChunksModBlocks.BROWN_ARMOR);
      BROWN_ARMOR_SLAB = block(CrustyChunksModBlocks.BROWN_ARMOR_SLAB);
      BROWN_ARMOR_STAIRS = block(CrustyChunksModBlocks.BROWN_ARMOR_STAIRS);
      BROWN_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.BROWN_ARMOR_TRAPDOOR);
      BROWN_ARMOR_OPTIC = block(CrustyChunksModBlocks.BROWN_ARMOR_OPTIC);
      WHITE_ARMOR = block(CrustyChunksModBlocks.WHITE_ARMOR);
      WHITE_ARMOR_SLAB = block(CrustyChunksModBlocks.WHITE_ARMOR_SLAB);
      WHITE_ARMOR_STAIRS = block(CrustyChunksModBlocks.WHITE_ARMOR_STAIRS);
      WHITE_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.WHITE_ARMOR_TRAPDOOR);
      WHITE_ARMOR_OPTIC = block(CrustyChunksModBlocks.WHITE_ARMOR_OPTIC);
      LARGE_MAGAZINE = REGISTRY.register("large_magazine", () -> {
         return new LargeMagazineItem();
      });
      BATTLE_RIFLE = REGISTRY.register("battle_rifle", () -> {
         return new BattleRifleItem();
      });
      IRONGEAR = REGISTRY.register("irongear", () -> {
         return new IrongearItem();
      });
      ROTARY_AUTO_CANNON = block(CrustyChunksModBlocks.ROTARY_AUTO_CANNON);
      RAC_BARREL = REGISTRY.register(CrustyChunksModBlocks.RAC_BARREL.getId().getPath(), () -> {
         return new RACBarrelDisplayItem((Block)CrustyChunksModBlocks.RAC_BARREL.get(), new Properties());
      });
      LIGHT_AUTOCANNON = block(CrustyChunksModBlocks.LIGHT_AUTOCANNON);
      MACHINE_CARBINE = REGISTRY.register("machine_carbine", () -> {
         return new MachineCarbineItem();
      });
      SMOKE_MORTAR_SHELL = REGISTRY.register("smoke_mortar_shell", () -> {
         return new SmokeMortarShellItem();
      });
      SMOKE_LAUNCHER = block(CrustyChunksModBlocks.SMOKE_LAUNCHER);
      HE_PROJECTILE = REGISTRY.register("he_projectile", () -> {
         return new HEProjectileItem();
      });
      HEAT_PROJECTILE = REGISTRY.register("heat_projectile", () -> {
         return new HEATProjectileItem();
      });
      APFSDS_PROJECTILE = REGISTRY.register("apfsds_projectile", () -> {
         return new APFSDSProjectileItem();
      });
      SHAPED_CHARGE_FUZE = REGISTRY.register("shaped_charge_fuze", () -> {
         return new ShapedChargeFuzeItem();
      });
      FLAK_PROJECTILE = REGISTRY.register("flak_projectile", () -> {
         return new FlakProjectileItem();
      });
      HOLLOWED_LARGE_PROJECTILE = REGISTRY.register("hollowed_large_projectile", () -> {
         return new HollowedLargeProjectileItem();
      });
      SMALL_HE_PROJECTILE = REGISTRY.register("small_he_projectile", () -> {
         return new SmallHEProjectileItem();
      });
      SMOKE_AGENT = REGISTRY.register("smoke_agent", () -> {
         return new SmokeAgentItem();
      });
      FIRE_AGENT = REGISTRY.register("fire_agent", () -> {
         return new FireAgentItem();
      });
      IMPLOSION_MODULE = REGISTRY.register("implosion_module", () -> {
         return new ImplosionModuleItem();
      });
      URANIUM_ORE = block(CrustyChunksModBlocks.URANIUM_ORE);
      RED_ARMOR = block(CrustyChunksModBlocks.RED_ARMOR);
      RED_ARMOR_SLAB = block(CrustyChunksModBlocks.RED_ARMOR_SLAB);
      RED_ARMOR_STAIRS = block(CrustyChunksModBlocks.RED_ARMOR_STAIRS);
      RED_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.RED_ARMOR_TRAPDOOR);
      RED_ARMOR_OPTIC = block(CrustyChunksModBlocks.RED_ARMOR_OPTIC);
      BLACK_ARMOR = block(CrustyChunksModBlocks.BLACK_ARMOR);
      BLACK_ARMOR_SLAB = block(CrustyChunksModBlocks.BLACK_ARMOR_SLAB);
      BLACK_ARMOR_STAIRS = block(CrustyChunksModBlocks.BLACK_ARMOR_STAIRS);
      BLACK_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.BLACK_ARMOR_TRAPDOOR);
      BLACK_ARMOR_OPTIC = block(CrustyChunksModBlocks.BLACK_ARMOR_OPTIC);
      CYAN_ARMOR = block(CrustyChunksModBlocks.CYAN_ARMOR);
      CYAN_ARMOR_SLAB = block(CrustyChunksModBlocks.CYAN_ARMOR_SLAB);
      CYAN_ARMOR_STAIRS = block(CrustyChunksModBlocks.CYAN_ARMOR_STAIRS);
      CYAN_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.CYAN_ARMOR_TRAPDOOR);
      BLUE_ARMOR = block(CrustyChunksModBlocks.BLUE_ARMOR);
      BLUE_ARMOR_SLAB = block(CrustyChunksModBlocks.BLUE_ARMOR_SLAB);
      BLUE_ARMOR_STAIRS = block(CrustyChunksModBlocks.BLUE_ARMOR_STAIRS);
      BLUE_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.BLUE_ARMOR_TRAPDOOR);
      ORANGE_ARMOR = block(CrustyChunksModBlocks.ORANGE_ARMOR);
      ORANGE_ARMOR_SLAB = block(CrustyChunksModBlocks.ORANGE_ARMOR_SLAB);
      ORANGE_ARMOR_STAIRS = block(CrustyChunksModBlocks.ORANGE_ARMOR_STAIRS);
      ORANGE_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.ORANGE_ARMOR_TRAPDOOR);
      ORANGE_ARMOR_OPTIC = block(CrustyChunksModBlocks.ORANGE_ARMOR_OPTIC);
      GRAY_ARMOR = block(CrustyChunksModBlocks.GRAY_ARMOR);
      GRAY_ARMOR_SLAB = block(CrustyChunksModBlocks.GRAY_ARMOR_SLAB);
      GRAY_ARMOR_STAIRS = block(CrustyChunksModBlocks.GRAY_ARMOR_STAIRS);
      GRAY_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.GRAY_ARMOR_TRAPDOOR);
      GRAY_ARMOR_OPTIC = block(CrustyChunksModBlocks.GRAY_ARMOR_OPTIC);
      LIME_ARMOR = block(CrustyChunksModBlocks.LIME_ARMOR);
      LIME_ARMOR_SLAB = block(CrustyChunksModBlocks.LIME_ARMOR_SLAB);
      LIME_ARMOR_STAIRS = block(CrustyChunksModBlocks.LIME_ARMOR_STAIRS);
      LIME_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.LIME_ARMOR_TRAPDOOR);
      LIME_ARMOR_OPTIC = block(CrustyChunksModBlocks.LIME_ARMOR_OPTIC);
      LIGHT_GRAY_ARMOR = block(CrustyChunksModBlocks.LIGHT_GRAY_ARMOR);
      LIGHT_GRAY_ARMOR_SLAB = block(CrustyChunksModBlocks.LIGHT_GRAY_ARMOR_SLAB);
      LIGHT_GRAY_ARMOR_STAIRS = block(CrustyChunksModBlocks.LIGHT_GRAY_ARMOR_STAIRS);
      LIGHT_GRAY_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.LIGHT_GRAY_ARMOR_TRAPDOOR);
      LIGHT_GRAY_ARMOR_OPTIC = block(CrustyChunksModBlocks.LIGHT_GRAY_ARMOR_OPTIC);
      LIGHT_BLUE_ARMOR = block(CrustyChunksModBlocks.LIGHT_BLUE_ARMOR);
      LIGHT_BLUE_ARMOR_SLAB = block(CrustyChunksModBlocks.LIGHT_BLUE_ARMOR_SLAB);
      LIGHT_BLUE_ARMOR_STAIRS = block(CrustyChunksModBlocks.LIGHT_BLUE_ARMOR_STAIRS);
      LIGHT_BLUE_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.LIGHT_BLUE_ARMOR_TRAPDOOR);
      LIGHT_BLUE_ARMOR_OPTIC = block(CrustyChunksModBlocks.LIGHT_BLUE_ARMOR_OPTIC);
      PLUTONIUM_INGOT = REGISTRY.register("plutonium_ingot", () -> {
         return new PlutoniumIngotItem();
      });
      REFINERY = block(CrustyChunksModBlocks.REFINERY);
      REFINERY_TOWER = block(CrustyChunksModBlocks.REFINERY_TOWER);
      ADVANCED_COMPONENT = REGISTRY.register("advanced_component", () -> {
         return new AdvancedComponentItem();
      });
      SHALE_OIL = REGISTRY.register("shale_oil", () -> {
         return new ShaleOilItem();
      });
      BLAST_CLAY = REGISTRY.register("blast_clay", () -> {
         return new BlastClayItem();
      });
      SULFUR_ORE = block(CrustyChunksModBlocks.SULFUR_ORE);
      SULFUR = REGISTRY.register("sulfur", () -> {
         return new SulfurItem();
      });
      ALUMINUM_PLATE = REGISTRY.register("aluminum_plate", () -> {
         return new AluminumPlateItem();
      });
      PLUTONIUM_NUGGET = REGISTRY.register("plutonium_nugget", () -> {
         return new PlutoniumNuggetItem();
      });
      PLUTONIUM_CORE = REGISTRY.register("plutonium_core", () -> {
         return new PlutoniumCoreItem();
      });
      FISSION_CORE = REGISTRY.register("fission_core", () -> {
         return new FissionCoreItem();
      });
      SHIELDING_COMPONENT = REGISTRY.register("shielding_component", () -> {
         return new ShieldingComponentItem();
      });
      IMPLOSION_LENS = REGISTRY.register("implosion_lens", () -> {
         return new ImplosionLensItem();
      });
      GIANT_COIL = block(CrustyChunksModBlocks.GIANT_COIL);
      REACTION_CHAMBER = block(CrustyChunksModBlocks.REACTION_CHAMBER);
      BREEDER_REACTOR_PORT = block(CrustyChunksModBlocks.BREEDER_REACTOR_PORT);
      REACTIONCOMPONENT = REGISTRY.register("reactioncomponent", () -> {
         return new ReactioncomponentItem();
      });
      ALUMINUM_TINY_DUST = REGISTRY.register("aluminum_tiny_dust", () -> {
         return new AluminumTinyDustItem();
      });
      OIL_FIREBOX = block(CrustyChunksModBlocks.OIL_FIREBOX);
      DECIMATOR_SPAWN_EGG = REGISTRY.register("decimator_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.DECIMATOR, -12757452, -13553094, new Properties());
      });
      STRIKER_SPAWN_EGG = REGISTRY.register("striker_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.STRIKER, -11764658, -4698803, new Properties());
      });
      FLAMER_SPAWN_EGG = REGISTRY.register("flamer_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.FLAMER, -11127756, -13553094, new Properties());
      });
      HUNTER_SPAWN_EGG = REGISTRY.register("hunter_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.HUNTER, -10057884, -2039584, new Properties());
      });
      SUMMONATOR = block(CrustyChunksModBlocks.SUMMONATOR);
      SUMMONATOR_MODULE = block(CrustyChunksModBlocks.SUMMONATOR_MODULE);
      STEEL_DOOR = doubleBlock(CrustyChunksModBlocks.STEEL_DOOR);
      OVERGROWN_REENFORCED_CONCRETE = block(CrustyChunksModBlocks.OVERGROWN_REENFORCED_CONCRETE);
      RUSTY_BLOCK = block(CrustyChunksModBlocks.RUSTY_BLOCK);
      CRACKED_CONCRETE_WALL = block(CrustyChunksModBlocks.CRACKED_CONCRETE_WALL);
      FRACTURED_CONCRETE_WALL = block(CrustyChunksModBlocks.FRACTURED_CONCRETE_WALL);
      DAMAGED_CONCRETE_WALL = block(CrustyChunksModBlocks.DAMAGED_CONCRETE_WALL);
      DESTROYED_CONCRETE_WALL = block(CrustyChunksModBlocks.DESTROYED_CONCRETE_WALL);
      RUSTY_SLAB = block(CrustyChunksModBlocks.RUSTY_SLAB);
      RUSTY_STAIRS = block(CrustyChunksModBlocks.RUSTY_STAIRS);
      RUSTY_TRAPDOOR = block(CrustyChunksModBlocks.RUSTY_TRAPDOOR);
      ROBOT_CHUTE = block(CrustyChunksModBlocks.ROBOT_CHUTE);
      STRUCTURAL_CONCRETE = block(CrustyChunksModBlocks.STRUCTURAL_CONCRETE);
      STEEL_TRUSS = block(CrustyChunksModBlocks.STEEL_TRUSS);
      SUMMONATOR_ACTIVE = block(CrustyChunksModBlocks.SUMMONATOR_ACTIVE);
      ACTIVE_ROBOT_CHUTE = block(CrustyChunksModBlocks.ACTIVE_ROBOT_CHUTE);
      HAND_DRILL = REGISTRY.register("hand_drill", () -> {
         return new HandDrillItem();
      });
      BRASS_FITTING = REGISTRY.register("brass_fitting", () -> {
         return new BrassFittingItem();
      });
      COMBUSTION_CYLINDER = REGISTRY.register("combustion_cylinder", () -> {
         return new CombustionCylinderItem();
      });
      ENGINE_COMPONENT = REGISTRY.register("engine_component", () -> {
         return new EngineComponentItem();
      });
      SMALL_ENGINE = REGISTRY.register("small_engine", () -> {
         return new SmallEngineItem();
      });
      BERYLLIUM_ORE = block(CrustyChunksModBlocks.BERYLLIUM_ORE);
      RAW_BERYLLIUM = REGISTRY.register("raw_beryllium", () -> {
         return new RawBerylliumItem();
      });
      BERYLLIUM_DUST = REGISTRY.register("beryllium_dust", () -> {
         return new BerylliumDustItem();
      });
      BERYLLIUM_INGOT = REGISTRY.register("beryllium_ingot", () -> {
         return new BerylliumIngotItem();
      });
      RAW_BERYLLIUM_BLOCK = block(CrustyChunksModBlocks.RAW_BERYLLIUM_BLOCK);
      NEUTRON_REFLECTOR = REGISTRY.register("neutron_reflector", () -> {
         return new NeutronReflectorItem();
      });
      BREEDER_REACTOR_CORE = block(CrustyChunksModBlocks.BREEDER_REACTOR_CORE);
      BREEDER_REACTOR_INTERFACE = block(CrustyChunksModBlocks.BREEDER_REACTOR_INTERFACE);
      REACTOR_CASING = block(CrustyChunksModBlocks.REACTOR_CASING);
      CONTROL_ROD = block(CrustyChunksModBlocks.CONTROL_ROD);
      EMPTY_FUEL_RODS = block(CrustyChunksModBlocks.EMPTY_FUEL_RODS);
      FUEL_RODS_1 = block(CrustyChunksModBlocks.FUEL_RODS_1);
      FUEL_RODS_2 = block(CrustyChunksModBlocks.FUEL_RODS_2);
      FUEL_RODS_3 = block(CrustyChunksModBlocks.FUEL_RODS_3);
      FUEL_RODS_4 = block(CrustyChunksModBlocks.FUEL_RODS_4);
      FUEL_ROD = REGISTRY.register("fuel_rod", () -> {
         return new FuelRodItem();
      });
      SOLID_SHELL = REGISTRY.register("solid_shell", () -> {
         return new SolidShellItem();
      });
      NVD_HELMET_HELMET = REGISTRY.register("nvd_helmet_helmet", () -> {
         return new NVDHelmetItem.Helmet();
      });
      TECH_COMPONENT = REGISTRY.register("tech_component", () -> {
         return new TechComponentItem();
      });
      SMALL_HOLLOW_POINT_BULLET = REGISTRY.register("small_hollow_point_bullet", () -> {
         return new SmallHollowPointBulletItem();
      });
      SMALL_STEALTH_BULLET = REGISTRY.register("small_stealth_bullet", () -> {
         return new SmallStealthBulletItem();
      });
      MEDIUM_AP_BULLET = REGISTRY.register("medium_ap_bullet", () -> {
         return new MediumAPBulletItem();
      });
      MEDIUM_STEALTH_BULLET = REGISTRY.register("medium_stealth_bullet", () -> {
         return new MediumStealthBulletItem();
      });
      AP_LARGE_BULLET = REGISTRY.register("ap_large_bullet", () -> {
         return new APLargeBulletItem();
      });
      STEALTH_LARGE_BULLET = REGISTRY.register("stealth_large_bullet", () -> {
         return new StealthLargeBulletItem();
      });
      TRANSPARENT_ITEM = REGISTRY.register("transparent_item", () -> {
         return new TransparentItemItem();
      });
      BIRD_SHOT = REGISTRY.register("bird_shot", () -> {
         return new BirdShotItem();
      });
      SLUG_SHELL = REGISTRY.register("slug_shell", () -> {
         return new SlugShellItem();
      });
      RIFLER_SPAWN_EGG = REGISTRY.register("rifler_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.RIFLER, -11764658, -4698803, new Properties());
      });
      FLARE_PISTOL = REGISTRY.register("flare_pistol", () -> {
         return new FlarePistolItem();
      });
      FLARE_CHARGE = REGISTRY.register("flare_charge", () -> {
         return new FlareChargeItem();
      });
      SCORCH_DIRT = block(CrustyChunksModBlocks.SCORCH_DIRT);
      ALUMINUM_PLATING = block(CrustyChunksModBlocks.ALUMINUM_PLATING);
      ALUMINUM_PLATING_SLAB = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB);
      ALUMINUM_PLATING_STAIRS = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS);
      ALUMINUM_PLATING_TRAPDOOR = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR);
      ALUMINUM_SIDE_PANEL = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL);
      GLASS_TRAPDOOR = block(CrustyChunksModBlocks.GLASS_TRAPDOOR);
      REINFORCED_GLASS = block(CrustyChunksModBlocks.REINFORCED_GLASS);
      REINFORCED_GLASS_TRAPDOOR = block(CrustyChunksModBlocks.REINFORCED_GLASS_TRAPDOOR);
      AFTER_BURNER = block(CrustyChunksModBlocks.AFTER_BURNER);
      ALUMINUM_AC_BARREL = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL);
      GAS_BOMB = block(CrustyChunksModBlocks.GAS_BOMB);
      TOXIC_AGENT = REGISTRY.register("toxic_agent", () -> {
         return new ToxicAgentItem();
      });
      GAS_ARTILLERY_SHELL = REGISTRY.register("gas_artillery_shell", () -> {
         return new GasArtilleryShellItem();
      });
      GAS_DISPENSER = block(CrustyChunksModBlocks.GAS_DISPENSER);
      NODE_TRIGGER = block(CrustyChunksModBlocks.NODE_TRIGGER);
      NODE_TRIGGER_ON = block(CrustyChunksModBlocks.NODE_TRIGGER_ON);
      COUNTERMEASURE_DISPENSER = block(CrustyChunksModBlocks.COUNTERMEASURE_DISPENSER);
      MORTARER_SPAWN_EGG = REGISTRY.register("mortarer_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.MORTARER, -13035239, -14801636, new Properties());
      });
      COMMANDER_SPAWN_EGG = REGISTRY.register("commander_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.COMMANDER, -14601442, -65536, new Properties());
      });
      CIWS_SPAWN_EGG = REGISTRY.register("ciws_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.CIWS, -13678800, -1, new Properties());
      });
      STEALTH_PISTOL = REGISTRY.register("stealth_pistol", () -> {
         return new StealthPistolItem();
      });
      WEAPON_SUPRESSOR = REGISTRY.register("weapon_supressor", () -> {
         return new WeaponSupressorItem();
      });
      ASPHALT_SLAB = block(CrustyChunksModBlocks.ASPHALT_SLAB);
      ORDINANCE_CORE = block(CrustyChunksModBlocks.ORDINANCE_CORE);
      ORDINANCE_FINS = block(CrustyChunksModBlocks.ORDINANCE_FINS);
      ORDINANCE_THRUSTER = block(CrustyChunksModBlocks.ORDINANCE_THRUSTER);
      ORDINANCE_HEAVY_WARHEAD = block(CrustyChunksModBlocks.ORDINANCE_HEAVY_WARHEAD);
      ORDINANCE_INCENDIARY_WARHEAD = block(CrustyChunksModBlocks.ORDINANCE_INCENDIARY_WARHEAD);
      ORDINANCE_INLINE_WARHEAD = block(CrustyChunksModBlocks.ORDINANCE_INLINE_WARHEAD);
      ORDINANCE_KINETIC_HEAD = block(CrustyChunksModBlocks.ORDINANCE_KINETIC_HEAD);
      ORDINANCE_IR_SEEKER_HEAD = block(CrustyChunksModBlocks.ORDINANCE_IR_SEEKER_HEAD);
      ORDINANCE_CLUSTER_WARHEAD = block(CrustyChunksModBlocks.ORDINANCE_CLUSTER_WARHEAD);
      ORDINANCE_INLINE_FISSION_WARHEAD = block(CrustyChunksModBlocks.ORDINANCE_INLINE_FISSION_WARHEAD);
      ORDINANCE_FISSION_INITIATOR_HEAD = block(CrustyChunksModBlocks.ORDINANCE_FISSION_INITIATOR_HEAD);
      SOLID_ROCKET_FUEL_PACK = REGISTRY.register("solid_rocket_fuel_pack", () -> {
         return new SolidRocketFuelPackItem();
      });
      ANCIENT_LIGHT = block(CrustyChunksModBlocks.ANCIENT_LIGHT);
      SUMMONATION = block(CrustyChunksModBlocks.SUMMONATION);
      OPEN_SUMMONATION = block(CrustyChunksModBlocks.OPEN_SUMMONATION);
      LOOT_BOX = block(CrustyChunksModBlocks.LOOT_BOX);
      GAS_MASK_HELMET = REGISTRY.register("gas_mask_helmet", () -> {
         return new GasMaskItem.Helmet();
      });
      DEFENSE_CORE = block(CrustyChunksModBlocks.DEFENSE_CORE);
      ASSASSIN_SPAWN_EGG = REGISTRY.register("assassin_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.ASSASSIN, -16777216, -4698803, new Properties());
      });
      BLAST_ARMOR_HELMET = REGISTRY.register("blast_armor_helmet", () -> {
         return new BlastArmorItem.Helmet();
      });
      BLAST_ARMOR_CHESTPLATE = REGISTRY.register("blast_armor_chestplate", () -> {
         return new BlastArmorItem.Chestplate();
      });
      BLAST_ARMOR_LEGGINGS = REGISTRY.register("blast_armor_leggings", () -> {
         return new BlastArmorItem.Leggings();
      });
      BLAST_ARMOR_BOOTS = REGISTRY.register("blast_armor_boots", () -> {
         return new BlastArmorItem.Boots();
      });
      RAW_URANIUM_BLOCK = block(CrustyChunksModBlocks.RAW_URANIUM_BLOCK);
      ERADICATOR_SPAWN_EGG = REGISTRY.register("eradicator_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.ERADICATOR, -14604513, -13553094, new Properties());
      });
      FUSION_BOMB = block(CrustyChunksModBlocks.FUSION_BOMB);
      SCOUT_SPAWN_EGG = REGISTRY.register("scout_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.SCOUT, -8343168, -4935761, new Properties());
      });
      RAIDSCOUT_SPAWN_EGG = REGISTRY.register("raidscout_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.RAIDSCOUT, -8343168, -4935761, new Properties());
      });
      BERYLLIUM_BLOCK = block(CrustyChunksModBlocks.BERYLLIUM_BLOCK);
      POLISHED_TRINITITE = block(CrustyChunksModBlocks.POLISHED_TRINITITE);
      SULFUR_BLOCK = block(CrustyChunksModBlocks.SULFUR_BLOCK);
      WORKER_SPAWN_EGG = REGISTRY.register("worker_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.WORKER, -13150152, -7716543, new Properties());
      });
      ANCIENT_WELL = block(CrustyChunksModBlocks.ANCIENT_WELL);
      PASSENGER_SEAT = block(CrustyChunksModBlocks.PASSENGER_SEAT);
      BREECH_RIFLE = REGISTRY.register("breech_rifle", () -> {
         return new BreechRifleItem();
      });
      EXTRA_LARGE_BULLET = REGISTRY.register("extra_large_bullet", () -> {
         return new ExtraLargeBulletItem();
      });
      SCOPED_BREECH_RIFLE = REGISTRY.register("scoped_breech_rifle", () -> {
         return new ScopedBreechRifleItem();
      });
      JET_GEARBOX = block(CrustyChunksModBlocks.JET_GEARBOX);
      GENERATOR = block(CrustyChunksModBlocks.GENERATOR);
      GAS_MASK_HELMET_HELMET = REGISTRY.register("gas_mask_helmet_helmet", () -> {
         return new GasMaskHelmetItem.Helmet();
      });
      ERADICATION = REGISTRY.register("eradication", () -> {
         return new EradicationItem();
      });
      BULLET_RESISTANT_HELMET_2_HELMET = REGISTRY.register("bullet_resistant_helmet_2_helmet", () -> {
         return new BulletResistantHelmet2Item.Helmet();
      });
      BULLET_RESISTANT_HELMET_3_HELMET = REGISTRY.register("bullet_resistant_helmet_3_helmet", () -> {
         return new BulletResistantHelmet3Item.Helmet();
      });
      BULLET_RESISTANT_HELMET_4_HELMET = REGISTRY.register("bullet_resistant_helmet_4_helmet", () -> {
         return new BulletResistantHelmet4Item.Helmet();
      });
      FUEL_TANK = block(CrustyChunksModBlocks.FUEL_TANK);
      ALUMINUM_PLATING_DARK_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_DARK_GRAY);
      ALUMINUM_PLATING_SLAB_DARK_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_DARK_GRAY);
      ALUMINUM_PLATING_STAIRS_DARK_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_DARK_GRAY);
      ALUMINUM_PLATING_TRAPDOOR_DARK_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_DARK_GRAY);
      ALUMINUM_SIDE_PANEL_DARK_GRAY = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_DARK_GRAY);
      ALUMINUM_AC_BARREL_DARK_GRAY = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_DARK_GRAY);
      EXTENSION_SHAFT = block(CrustyChunksModBlocks.EXTENSION_SHAFT);
      DRIVE_SHAFT = block(CrustyChunksModBlocks.DRIVE_SHAFT);
      ENGINE_CYLLINDER = block(CrustyChunksModBlocks.ENGINE_CYLLINDER);
      LARGE_ENGINE_SMOKESTACK = block(CrustyChunksModBlocks.LARGE_ENGINE_SMOKESTACK);
      TINTED_GLASS_TRAPDOOR = block(CrustyChunksModBlocks.TINTED_GLASS_TRAPDOOR);
      CYAN_ARMOR_OPTIC = block(CrustyChunksModBlocks.CYAN_ARMOR_OPTIC);
      BLUE_ARMOR_OPTIC = block(CrustyChunksModBlocks.BLUE_ARMOR_OPTIC);
      ENERGY_NODE = block(CrustyChunksModBlocks.ENERGY_NODE);
      ENERGY_BATTERY = block(CrustyChunksModBlocks.ENERGY_BATTERY);
      LARGE_ELECTRIC_MOTOR = block(CrustyChunksModBlocks.LARGE_ELECTRIC_MOTOR);
      CABLE = REGISTRY.register("cable", () -> {
         return new CableItem();
      });
      ENERGY_METER = REGISTRY.register("energy_meter", () -> {
         return new EnergyMeterItem();
      });
      PINK_ARMOR = block(CrustyChunksModBlocks.PINK_ARMOR);
      PINK_ARMOR_SLAB = block(CrustyChunksModBlocks.PINK_ARMOR_SLAB);
      PINK_ARMOR_STAIRS = block(CrustyChunksModBlocks.PINK_ARMOR_STAIRS);
      PINK_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.PINK_ARMOR_TRAPDOOR);
      PINK_ARMOR_OPTIC = block(CrustyChunksModBlocks.PINK_ARMOR_OPTIC);
      MAGENTA_ARMOR = block(CrustyChunksModBlocks.MAGENTA_ARMOR);
      MAGENTA_ARMOR_SLAB = block(CrustyChunksModBlocks.MAGENTA_ARMOR_SLAB);
      MAGENTA_ARMOR_STAIRS = block(CrustyChunksModBlocks.MAGENTA_ARMOR_STAIRS);
      MAGENTA_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.MAGENTA_ARMOR_TRAPDOOR);
      MAGENTA_ARMOR_OPTIC = block(CrustyChunksModBlocks.MAGENTA_ARMOR_OPTIC);
      PURPLE_ARMOR = block(CrustyChunksModBlocks.PURPLE_ARMOR);
      PURPLE_ARMOR_SLAB = block(CrustyChunksModBlocks.PURPLE_ARMOR_SLAB);
      PURPLE_ARMOR_STAIRS = block(CrustyChunksModBlocks.PURPLE_ARMOR_STAIRS);
      PURPLE_ARMOR_TRAPDOOR = block(CrustyChunksModBlocks.PURPLE_ARMOR_TRAPDOOR);
      PURPLE_ARMOR_OPTIC = block(CrustyChunksModBlocks.PURPLE_ARMOR_OPTIC);
      EXTRA_LARGE_CASING = REGISTRY.register("extra_large_casing", () -> {
         return new ExtraLargeCasingItem();
      });
      TURBINE_ROTOR = REGISTRY.register("turbine_rotor", () -> {
         return new TurbineRotorItem();
      });
      ELECTRIC_FIREBOX = block(CrustyChunksModBlocks.ELECTRIC_FIREBOX);
      THERMAL_FURNACE = block(CrustyChunksModBlocks.THERMAL_FURNACE);
      POWER_CELL = REGISTRY.register("power_cell", () -> {
         return new PowerCellItem();
      });
      POWER_REACTOR_INTERFACE = block(CrustyChunksModBlocks.POWER_REACTOR_INTERFACE);
      POWER_REACTOR_PORT = block(CrustyChunksModBlocks.POWER_REACTOR_PORT);
      LEVER_RIFLE = REGISTRY.register("lever_rifle", () -> {
         return new LeverRifleItem();
      });
      LAND_MINE = block(CrustyChunksModBlocks.LAND_MINE);
      AI_MINE = block(CrustyChunksModBlocks.AI_MINE);
      REAPER_SPAWN_EGG = REGISTRY.register("reaper_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.REAPER, -16052206, -5684927, new Properties());
      });
      FUSION_CORE = REGISTRY.register("fusion_core", () -> {
         return new FusionCoreItem();
      });
      ORDINANCE_INLINE_FUSION_WARHEAD_STAGE_1 = block(CrustyChunksModBlocks.ORDINANCE_INLINE_FUSION_WARHEAD_STAGE_1);
      ORDINANCE_INLINE_FUSION_WARHEAD_STAGE_2 = block(CrustyChunksModBlocks.ORDINANCE_INLINE_FUSION_WARHEAD_STAGE_2);
      BREACHER_SPAWN_EGG = REGISTRY.register("breacher_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.BREACHER, -12509152, -14399962, new Properties());
      });
      TRINITITE_SHARD = REGISTRY.register("trinitite_shard", () -> {
         return new TrinititeShardItem();
      });
      TRINITITE_GLASS = block(CrustyChunksModBlocks.TRINITITE_GLASS);
      TRINITITE_GLASS_TRAPDOOR = block(CrustyChunksModBlocks.TRINITITE_GLASS_TRAPDOOR);
      ENERGY_DISTRIBUTION_NODE = block(CrustyChunksModBlocks.ENERGY_DISTRIBUTION_NODE);
      FIRE_ARTILLERY_SHELL = REGISTRY.register("fire_artillery_shell", () -> {
         return new FireArtilleryShellItem();
      });
      PAINT_TOOL = REGISTRY.register("paint_tool", () -> {
         return new PaintToolItem();
      });
      AUTOMATIC_RIFLE = REGISTRY.register("automatic_rifle", () -> {
         return new AutomaticRifleItem();
      });
      MANUAL_CRANK = block(CrustyChunksModBlocks.MANUAL_CRANK);
      LARGE_ROCKET_POD_CHAMBER = block(CrustyChunksModBlocks.LARGE_ROCKET_POD_CHAMBER);
      LARGE_ROCKET_POD = block(CrustyChunksModBlocks.LARGE_ROCKET_POD);
      FIRE_SPEAR_ROCKET = REGISTRY.register("fire_spear_rocket", () -> {
         return new FireSpearRocketItem();
      });
      SEEKER_SPEAR_ROCKET = REGISTRY.register("seeker_spear_rocket", () -> {
         return new SeekerSpearRocketItem();
      });
      EMPTY_MISSILE_HARDPOINT = block(CrustyChunksModBlocks.EMPTY_MISSILE_HARDPOINT);
      FIRE_SPEAR_MISSILE_HARDPOINT = block(CrustyChunksModBlocks.FIRE_SPEAR_MISSILE_HARDPOINT);
      SEEKER_SPEAR_MISSILE_HARDPOINT = block(CrustyChunksModBlocks.SEEKER_SPEAR_MISSILE_HARDPOINT);
      STRIKE_SPEAR_MISSILE = REGISTRY.register("strike_spear_missile", () -> {
         return new StrikeSpearMissileItem();
      });
      STRIKE_SPEAR_MISSILE_HARDPOINT = block(CrustyChunksModBlocks.STRIKE_SPEAR_MISSILE_HARDPOINT);
      LITHIUM_ORE = block(CrustyChunksModBlocks.LITHIUM_ORE);
      RAW_LITHIUM = REGISTRY.register("raw_lithium", () -> {
         return new RawLithiumItem();
      });
      LITHIUM_INGOT = REGISTRY.register("lithium_ingot", () -> {
         return new LithiumIngotItem();
      });
      LITHIUM_NUGGET = REGISTRY.register("lithium_nugget", () -> {
         return new LithiumNuggetItem();
      });
      LITHIUM_DUST = REGISTRY.register("lithium_dust", () -> {
         return new LithiumDustItem();
      });
      ENRICHED_LITHIUM_INGOT = REGISTRY.register("enriched_lithium_ingot", () -> {
         return new EnrichedLithiumIngotItem();
      });
      ENRICHED_LITHIUM_NUGGET = REGISTRY.register("enriched_lithium_nugget", () -> {
         return new EnrichedLithiumNuggetItem();
      });
      TINY_LITHIUM_DEUTERIDE = REGISTRY.register("tiny_lithium_deuteride", () -> {
         return new TinyLithiumDeuterideItem();
      });
      LITHIUM_DEUTERIDE = REGISTRY.register("lithium_deuteride", () -> {
         return new LithiumDeuterideItem();
      });
      THERMO_NUCLEAR_FUEL = REGISTRY.register("thermo_nuclear_fuel", () -> {
         return new ThermoNuclearFuelItem();
      });
      POLISHED_BAUXITE = block(CrustyChunksModBlocks.POLISHED_BAUXITE);
      RAW_LITHIUM_BLOCK = block(CrustyChunksModBlocks.RAW_LITHIUM_BLOCK);
      LITHIUM_BLOCK = block(CrustyChunksModBlocks.LITHIUM_BLOCK);
      SMALL_FLAK_SHELL = REGISTRY.register("small_flak_shell", () -> {
         return new SmallFlakShellItem();
      });
      SMALL_FLAK_PROJECTILE = REGISTRY.register("small_flak_projectile", () -> {
         return new SmallFlakProjectileItem();
      });
      ALUMINUM_PLATING_GREEN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_GREEN);
      ALUMINUM_PLATING_SLAB_GREEN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_GREEN);
      ALUMINUM_PLATING_STAIRS_GREEN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_GREEN);
      ALUMINUM_PLATING_TRAPDOOR_GREEN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_GREEN);
      ALUMINUM_SIDE_PANEL_GREEN = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_GREEN);
      ALUMINUM_AC_BARREL_GREEN = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_GREEN);
      ALUMINUM_PLATING_YELLOW = block(CrustyChunksModBlocks.ALUMINUM_PLATING_YELLOW);
      ALUMINUM_PLATING_SLAB_YELLOW = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_YELLOW);
      ALUMINUM_PLATING_STAIRS_YELLOW = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_YELLOW);
      ALUMINUM_PLATING_TRAPDOOR_YELLOW = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_YELLOW);
      ALUMINUM_SIDE_PANEL_YELLOW = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_YELLOW);
      ALUMINUM_AC_BARREL_YELLOW = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_YELLOW);
      ALUMINUM_PLATING_BROWN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_BROWN);
      ALUMINUM_PLATING_SLAB_BROWN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_BROWN);
      ALUMINUM_PLATING_STAIRS_BROWN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_BROWN);
      ALUMINUM_PLATING_TRAPDOOR_BROWN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_BROWN);
      ALUMINUM_SIDE_PANEL_BROWN = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_BROWN);
      ALUMINUM_AC_BARREL_BROWN = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_BROWN);
      ALUMINUM_PLATING_RED = block(CrustyChunksModBlocks.ALUMINUM_PLATING_RED);
      ALUMINUM_PLATING_SLAB_RED = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_RED);
      ALUMINUM_PLATING_STAIRS_RED = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_RED);
      ALUMINUM_PLATING_TRAPDOOR_RED = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_RED);
      ALUMINUM_SIDE_PANEL_RED = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_RED);
      ALUMINUM_AC_BARREL_RED = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_RED);
      ALUMINUM_PLATING_WHITE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_WHITE);
      ALUMINUM_PLATING_SLAB_WHITE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_WHITE);
      ALUMINUM_PLATING_STAIRS_WHITE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_WHITE);
      ALUMINUM_PLATING_TRAPDOOR_WHITE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_WHITE);
      ALUMINUM_SIDE_PANEL_WHITE = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_WHITE);
      ALUMINUM_AC_BARREL_WHITE = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_WHITE);
      ALUMINUM_PLATING_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_BLUE);
      ALUMINUM_PLATING_SLAB_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_BLUE);
      ALUMINUM_PLATING_STAIRS_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_BLUE);
      ALUMINUM_PLATING_TRAPDOOR_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_BLUE);
      ALUMINUM_SIDE_PANEL_BLUE = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_BLUE);
      ALUMINUM_AC_BARREL_BLUE = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_BLUE);
      ALUMINUM_PLATING_ORANGE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_ORANGE);
      ALUMINUM_PLATING_SLAB_ORANGE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_ORANGE);
      ALUMINUM_PLATING_STAIRS_ORANGE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_ORANGE);
      ALUMINUM_PLATING_TRAPDOOR_ORANGE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_ORANGE);
      ALUMINUM_SIDE_PANEL_ORANGE = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_ORANGE);
      ALUMINUM_AC_BARREL_ORANGE = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_ORANGE);
      ALUMINUM_PLATING_CYAN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_CYAN);
      ALUMINUM_PLATING_SLAB_CYAN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_CYAN);
      ALUMINUM_PLATING_STAIRS_CYAN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_CYAN);
      ALUMINUM_PLATING_TRAPDOOR_CYAN = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_CYAN);
      ALUMINUM_SIDE_PANEL_CYAN = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_CYAN);
      ALUMINUM_AC_BARREL_CYAN = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_CYAN);
      ALUMINUM_PLATING_BLACK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_BLACK);
      ALUMINUM_PLATING_SLAB_BLACK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_BLACK);
      ALUMINUM_PLATING_STAIRS_BLACK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_BLACK);
      ALUMINUM_PLATING_TRAPDOOR_BLACK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_BLACK);
      ALUMINUM_SIDE_PANEL_BLACK = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_BLACK);
      ALUMINUM_AC_BARREL_BLACK = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_BLACK);
      ALUMINUM_PLATING_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_GRAY);
      ALUMINUM_PLATING_SLAB_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_GRAY);
      ALUMINUM_PLATING_STAIRS_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_GRAY);
      ALUMINUM_PLATING_TRAPDOOR_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_GRAY);
      ALUMINUM_SIDE_PANEL_GRAY = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_GRAY);
      ALUMINUM_AC_BARREL_GRAY = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_GRAY);
      ALUMINUM_PLATING_LIGHT_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_LIGHT_GRAY);
      ALUMINUM_PLATING_SLAB_LIGHT_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_LIGHT_GRAY);
      ALUMINUM_PLATING_STAIRS_LIGHT_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_LIGHT_GRAY);
      ALUMINUM_PLATING_TRAPDOOR_LIGHT_GRAY = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_LIGHT_GRAY);
      ALUMINUM_SIDE_PANEL_LIGHT_GRAY = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_LIGHT_GRAY);
      ALUMINUM_AC_BARREL_LIGHT_GRAY = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_LIGHT_GRAY);
      ALUMINUM_PLATING_LIME = block(CrustyChunksModBlocks.ALUMINUM_PLATING_LIME);
      ALUMINUM_PLATING_SLAB_LIME = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_LIME);
      ALUMINUM_PLATING_STAIRS_LIME = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_LIME);
      ALUMINUM_PLATING_TRAPDOOR_LIME = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_LIME);
      ALUMINUM_SIDE_PANEL_LIME = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_LIME);
      ALUMINUM_AC_BARREL_LIME = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_LIME);
      ALUMINUM_PLATING_LIGHT_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_LIGHT_BLUE);
      ALUMINUM_PLATING_SLAB_LIGHT_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_LIGHT_BLUE);
      ALUMINUM_PLATING_STAIRS_LIGHT_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_LIGHT_BLUE);
      ALUMINUM_PLATING_TRAPDOOR_LIGHT_BLUE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_LIGHT_BLUE);
      ALUMINUM_SIDE_PANEL_LIGHT_BLUE = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_LIGHT_BLUE);
      ALUMINUM_AC_BARREL_LIGHT_BLUE = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_LIGHT_BLUE);
      ALUMINUM_PLATING_PINK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_PINK);
      ALUMINUM_PLATING_SLAB_PINK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_PINK);
      ALUMINUM_PLATING_STAIRS_PINK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_PINK);
      ALUMINUM_PLATING_TRAPDOOR_PINK = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_PINK);
      ALUMINUM_SIDE_PANEL_PINK = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_PINK);
      ALUMINUM_AC_BARREL_PINK = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_PINK);
      ALUMINUM_PLATING_MAGENTA = block(CrustyChunksModBlocks.ALUMINUM_PLATING_MAGENTA);
      ALUMINUM_PLATING_SLAB_MAGENTA = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_MAGENTA);
      ALUMINUM_PLATING_STAIRS_MAGENTA = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_MAGENTA);
      ALUMINUM_PLATING_TRAPDOOR_MAGENTA = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_MAGENTA);
      ALUMINUM_SIDE_PANEL_MAGENTA = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_MAGENTA);
      ALUMINUM_AC_BARREL_MAGENTA = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_MAGENTA);
      ALUMINUM_PLATING_PURPLE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_PURPLE);
      ALUMINUM_PLATING_SLAB_PURPLE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_SLAB_PURPLE);
      ALUMINUM_PLATING_STAIRS_PURPLE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_STAIRS_PURPLE);
      ALUMINUM_PLATING_TRAPDOOR_PURPLE = block(CrustyChunksModBlocks.ALUMINUM_PLATING_TRAPDOOR_PURPLE);
      ALUMINUM_SIDE_PANEL_PURPLE = block(CrustyChunksModBlocks.ALUMINUM_SIDE_PANEL_PURPLE);
      ALUMINUM_AC_BARREL_PURPLE = block(CrustyChunksModBlocks.ALUMINUM_AC_BARREL_PURPLE);
      MANUAL_AIMER = block(CrustyChunksModBlocks.MANUAL_AIMER);
      SOLAR_GENERATOR = block(CrustyChunksModBlocks.SOLAR_GENERATOR);
      RADAR_SPEAR_MISSILE_HARDPOINT = block(CrustyChunksModBlocks.RADAR_SPEAR_MISSILE_HARDPOINT);
      RADAR_SPEAR_MISSILE = REGISTRY.register("radar_spear_missile", () -> {
         return new RadarSpearMissileItem();
      });
      RADAR_COMPONENT = REGISTRY.register("radar_component", () -> {
         return new RadarComponentItem();
      });
      IR_COMPONENT = REGISTRY.register("ir_component", () -> {
         return new IRComponentItem();
      });
      CHAFF_CHARGE = REGISTRY.register("chaff_charge", () -> {
         return new ChaffChargeItem();
      });
      ORDINANCE_CONTROLLER = block(CrustyChunksModBlocks.ORDINANCE_CONTROLLER);
      ORDINANCE_SARH_SEEKER = block(CrustyChunksModBlocks.ORDINANCE_SARH_SEEKER);
      FUEL_TANK_MODULE = block(CrustyChunksModBlocks.FUEL_TANK_MODULE);
      FUEL_HOSE = REGISTRY.register("fuel_hose", () -> {
         return new FuelHoseItem();
      });
      DAMAGEDFUELTANK = block(CrustyChunksModBlocks.DAMAGEDFUELTANK);
      FUEL_TANK_INPUT = block(CrustyChunksModBlocks.FUEL_TANK_INPUT);
      HEAVY_MACHINE_GUN = block(CrustyChunksModBlocks.HEAVY_MACHINE_GUN);
      LIGHT_MACHINE_GUN = block(CrustyChunksModBlocks.LIGHT_MACHINE_GUN);
      COVERED_MACHINE_GUN_BARREL = block(CrustyChunksModBlocks.COVERED_MACHINE_GUN_BARREL);
      REINFORCED_GLASS_STAIRS = block(CrustyChunksModBlocks.REINFORCED_GLASS_STAIRS);
      TINTED_GLASS_STAIRS = block(CrustyChunksModBlocks.TINTED_GLASS_STAIRS);
      TRINITITE_GLASS_STAIRS = block(CrustyChunksModBlocks.TRINITITE_GLASS_STAIRS);
      THICK_BATTLE_CANNON_BARREL = block(CrustyChunksModBlocks.THICK_BATTLE_CANNON_BARREL);
      GRENADE_LAUNCHER = REGISTRY.register("grenade_launcher", () -> {
         return new GrenadeLauncherItem();
      });
      MEDIUM_PETROL_ENGINE = block(CrustyChunksModBlocks.MEDIUM_PETROL_ENGINE);
      SMALL_DIESEL_ENGINE = block(CrustyChunksModBlocks.SMALL_DIESEL_ENGINE);
      THERMAL_SHELL = REGISTRY.register("thermal_shell", () -> {
         return new ThermalShellItem();
      });
      FLAME_THROWER = block(CrustyChunksModBlocks.FLAME_THROWER);
      FLAME_THROWER_BARREL = block(CrustyChunksModBlocks.FLAME_THROWER_BARREL);
      COVERED_FLAME_THROWER_BARREL = block(CrustyChunksModBlocks.COVERED_FLAME_THROWER_BARREL);
      ERA_4 = block(CrustyChunksModBlocks.ERA_4);
      ERA_3 = block(CrustyChunksModBlocks.ERA_3);
      ERA_2 = block(CrustyChunksModBlocks.ERA_2);
      ERA_1 = block(CrustyChunksModBlocks.ERA_1);
      HUGE_HE_BULLET = REGISTRY.register("huge_he_bullet", () -> {
         return new HugeHEBulletItem();
      });
      ERA_TILE = REGISTRY.register("era_tile", () -> {
         return new ERATileItem();
      });
      OFFSET_ERA_4 = block(CrustyChunksModBlocks.OFFSET_ERA_4);
      OFFSET_ERA_3 = block(CrustyChunksModBlocks.OFFSET_ERA_3);
      OFFSET_ERA_2 = block(CrustyChunksModBlocks.OFFSET_ERA_2);
      OFFSET_ERA_1 = block(CrustyChunksModBlocks.OFFSET_ERA_1);
      MEDIUM_DIESEL_ENGINE = block(CrustyChunksModBlocks.MEDIUM_DIESEL_ENGINE);
      SMALL_PETROL_ENGINE = block(CrustyChunksModBlocks.SMALL_PETROL_ENGINE);
      PRODUCTION_INPUT = block(CrustyChunksModBlocks.PRODUCTION_INPUT);
      PRODUCTION_OUTPUT = block(CrustyChunksModBlocks.PRODUCTION_OUTPUT);
      ASSEMBLY_DEPOT = block(CrustyChunksModBlocks.ASSEMBLY_DEPOT);
      ASSEMBLY_MACHINE = block(CrustyChunksModBlocks.ASSEMBLY_MACHINE);
      ASSEMBLY_CRUSHER = block(CrustyChunksModBlocks.ASSEMBLY_CRUSHER);
      ASSEMBLY_FURNACE = block(CrustyChunksModBlocks.ASSEMBLY_FURNACE);
      MECHANICAL_BORE = REGISTRY.register("mechanical_bore", () -> {
         return new MechanicalBoreItem();
      });
      MECHANICAL_PRESS = REGISTRY.register("mechanical_press", () -> {
         return new MechanicalPressItem();
      });
      MECHANICAL_EXTRUDER = REGISTRY.register("mechanical_extruder", () -> {
         return new MechanicalExtruderItem();
      });
      MECHANICAL_SHEAR = REGISTRY.register("mechanical_shear", () -> {
         return new MechanicalShearItem();
      });
      STEEL_CRUSHING_WHEEL = REGISTRY.register("steel_crushing_wheel", () -> {
         return new SteelCrushingWheelItem();
      });
      NITRATE = REGISTRY.register("nitrate", () -> {
         return new NitrateItem();
      });
      NITRATE_BLOCK = block(CrustyChunksModBlocks.NITRATE_BLOCK);
      PROTOTYPE_ERADICATOR_SPAWN_EGG = REGISTRY.register("prototype_eradicator_spawn_egg", () -> {
         return new ForgeSpawnEggItem(CrustyChunksModEntities.PROTOTYPE_ERADICATOR, -15522036, -14608106, new Properties());
      });
      BAUXITE_DIGESTER = block(CrustyChunksModBlocks.BAUXITE_DIGESTER);
      ALUMINATE_DUST = REGISTRY.register("aluminate_dust", () -> {
         return new AluminateDustItem();
      });
      FILTERED_ALUMINATE_DUST = REGISTRY.register("filtered_aluminate_dust", () -> {
         return new FilteredAluminateDustItem();
      });
      ASSEMBLY_CENTRIFUGE_BOTTOM = block(CrustyChunksModBlocks.ASSEMBLY_CENTRIFUGE_BOTTOM);
      ASSEMBLY_CENTRIFUGE_MIDDLE = block(CrustyChunksModBlocks.ASSEMBLY_CENTRIFUGE_MIDDLE);
      ASSEMBLY_CENTRIFUGE_TOP = block(CrustyChunksModBlocks.ASSEMBLY_CENTRIFUGE_TOP);
      CONVEYOR_SPLITTER = block(CrustyChunksModBlocks.CONVEYOR_SPLITTER);
      LIGHT_WOOD_FRAME = block(CrustyChunksModBlocks.LIGHT_WOOD_FRAME);
      LIGHT_WOOD_BLOCK = block(CrustyChunksModBlocks.LIGHT_WOOD_BLOCK);
      LIGHT_WOOD_SLAB = block(CrustyChunksModBlocks.LIGHT_WOOD_SLAB);
      LIGHT_WOOD_STAIRS = block(CrustyChunksModBlocks.LIGHT_WOOD_STAIRS);
      LIGHT_WOOD_SIDE_PANEL = block(CrustyChunksModBlocks.LIGHT_WOOD_SIDE_PANEL);
      LIGHT_WOOD_TRAPDOOR = block(CrustyChunksModBlocks.LIGHT_WOOD_TRAPDOOR);
      PRECISION_COMPONENT = REGISTRY.register("precision_component", () -> {
         return new PrecisionComponentItem();
      });
      UNFABRICATED_TECH_COMPONENT = REGISTRY.register("unfabricated_tech_component", () -> {
         return new UnfabricatedTechComponentItem();
      });
      ASSEMBLY_CIRCUIT_FABRICATOR = block(CrustyChunksModBlocks.ASSEMBLY_CIRCUIT_FABRICATOR);
      ASSEMBLY_MECHANICAL_FABRICATOR = block(CrustyChunksModBlocks.ASSEMBLY_MECHANICAL_FABRICATOR);
      PYROCHLORE_ORE = block(CrustyChunksModBlocks.PYROCHLORE_ORE);
      PYROCHLORE = REGISTRY.register("pyrochlore", () -> {
         return new PyrochloreItem();
      });
      PYROCHLORE_DUST = REGISTRY.register("pyrochlore_dust", () -> {
         return new PyrochloreDustItem();
      });
      FILTERED_PYROCHLORE_DUST = REGISTRY.register("filtered_pyrochlore_dust", () -> {
         return new FilteredPyrochloreDustItem();
      });
      NIOBIUM_DUST = REGISTRY.register("niobium_dust", () -> {
         return new NiobiumDustItem();
      });
      NIOBIUM_TINY_DUST = REGISTRY.register("niobium_tiny_dust", () -> {
         return new NiobiumTinyDustItem();
      });
      NIOBIUM_INGOT = REGISTRY.register("niobium_ingot", () -> {
         return new NiobiumIngotItem();
      });
      NIOBIUM_BLOCK = block(CrustyChunksModBlocks.NIOBIUM_BLOCK);
      PYROCHLORE_BLOCK = block(CrustyChunksModBlocks.PYROCHLORE_BLOCK);
      ADVANCED_ALLOY_MIXTURE = REGISTRY.register("advanced_alloy_mixture", () -> {
         return new AdvancedAlloyMixtureItem();
      });
      COMPRESSED_ADVANCED_MIXTURE = REGISTRY.register("compressed_advanced_mixture", () -> {
         return new CompressedAdvancedMixtureItem();
      });
      ADVANCED_ALLOY_INGOT = REGISTRY.register("advanced_alloy_ingot", () -> {
         return new AdvancedAlloyIngotItem();
      });
      ADVANCED_ALLOY_COMPONENT = REGISTRY.register("advanced_alloy_component", () -> {
         return new AdvancedAlloyComponentItem();
      });
      URANIUM_NEUTRAL_BLOCK = block(CrustyChunksModBlocks.URANIUM_NEUTRAL_BLOCK);
      URANIUM_ENRICHED_BLOCK = block(CrustyChunksModBlocks.URANIUM_ENRICHED_BLOCK);
      URANIUM_DEPLETED_BLOCK = block(CrustyChunksModBlocks.URANIUM_DEPLETED_BLOCK);
      PLUTONIUM_BLOCK = block(CrustyChunksModBlocks.PLUTONIUM_BLOCK);
      GRENADE_SHELL = REGISTRY.register("grenade_shell", () -> {
         return new GrenadeShellItem();
      });
      SMOKE_GRENADE_SHELL = REGISTRY.register("smoke_grenade_shell", () -> {
         return new SmokeGrenadeShellItem();
      });
      SMOKE_SHELL = REGISTRY.register("smoke_shell", () -> {
         return new SmokeShellItem();
      });
      SMOKE_PROJECTILE = REGISTRY.register("smoke_projectile", () -> {
         return new SmokeProjectileItem();
      });
      PHOSPHORUS_DUST = REGISTRY.register("phosphorus_dust", () -> {
         return new PhosphorusDustItem();
      });
      CHLORINE_DUST = REGISTRY.register("chlorine_dust", () -> {
         return new ChlorineDustItem();
      });
      ADVANCED_ALLOY_BLOCK = block(CrustyChunksModBlocks.ADVANCED_ALLOY_BLOCK);
      PHOSPHATE_BLOCK = block(CrustyChunksModBlocks.PHOSPHATE_BLOCK);
      SULFURIC_ACID_BUCKET = REGISTRY.register("sulfuric_acid_bucket", () -> {
         return new SulfuricAcidItem();
      });
      HYDRAZINE_BUCKET = REGISTRY.register("hydrazine_bucket", () -> {
         return new HydrazineItem();
      });
      GAS_CANISTER = REGISTRY.register("gas_canister", () -> {
         return new GasCanisterItem();
      });
   }
}
