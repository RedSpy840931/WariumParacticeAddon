package net.mcreator.crustychunks.init;

import net.mcreator.crustychunks.world.inventory.ABGuiMenu;
import net.mcreator.crustychunks.world.inventory.BlastFurnaceGUIMenu;
import net.mcreator.crustychunks.world.inventory.BreederReactorControlGUIMenu;
import net.mcreator.crustychunks.world.inventory.ConveyorGUIMenu;
import net.mcreator.crustychunks.world.inventory.ConveyorSplitterGUIMenu;
import net.mcreator.crustychunks.world.inventory.CrusherGUIMenu;
import net.mcreator.crustychunks.world.inventory.EnergyDisplayMenu;
import net.mcreator.crustychunks.world.inventory.FireboxGUIMenu;
import net.mcreator.crustychunks.world.inventory.FissionBombGUIMenu;
import net.mcreator.crustychunks.world.inventory.FissionWarheadGUIMenu;
import net.mcreator.crustychunks.world.inventory.FoundryGUIMenu;
import net.mcreator.crustychunks.world.inventory.FusionBombGUIMenu;
import net.mcreator.crustychunks.world.inventory.MachineputGUI4xMenu;
import net.mcreator.crustychunks.world.inventory.MineralGrinderGUIMenu;
import net.mcreator.crustychunks.world.inventory.ProgressGUIMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CrustyChunksModMenus {
   public static final DeferredRegister<MenuType<?>> REGISTRY;
   public static final RegistryObject<MenuType<BlastFurnaceGUIMenu>> BLAST_FURNACE_GUI;
   public static final RegistryObject<MenuType<ConveyorGUIMenu>> CONVEYOR_GUI;
   public static final RegistryObject<MenuType<FoundryGUIMenu>> FOUNDRY_GUI;
   public static final RegistryObject<MenuType<FireboxGUIMenu>> FIREBOX_GUI;
   public static final RegistryObject<MenuType<MineralGrinderGUIMenu>> MINERAL_GRINDER_GUI;
   public static final RegistryObject<MenuType<FissionBombGUIMenu>> FISSION_BOMB_GUI;
   public static final RegistryObject<MenuType<BreederReactorControlGUIMenu>> BREEDER_REACTOR_CONTROL_GUI;
   public static final RegistryObject<MenuType<FissionWarheadGUIMenu>> FISSION_WARHEAD_GUI;
   public static final RegistryObject<MenuType<EnergyDisplayMenu>> ENERGY_DISPLAY;
   public static final RegistryObject<MenuType<ABGuiMenu>> AB_GUI;
   public static final RegistryObject<MenuType<FusionBombGUIMenu>> FUSION_BOMB_GUI;
   public static final RegistryObject<MenuType<MachineputGUI4xMenu>> MACHINEPUT_GUI_4X;
   public static final RegistryObject<MenuType<CrusherGUIMenu>> CRUSHER_GUI;
   public static final RegistryObject<MenuType<ConveyorSplitterGUIMenu>> CONVEYOR_SPLITTER_GUI;
   public static final RegistryObject<MenuType<ProgressGUIMenu>> PROGRESS_GUI;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "crusty_chunks");
      BLAST_FURNACE_GUI = REGISTRY.register("blast_furnace_gui", () -> {
         return IForgeMenuType.create(BlastFurnaceGUIMenu::new);
      });
      CONVEYOR_GUI = REGISTRY.register("conveyor_gui", () -> {
         return IForgeMenuType.create(ConveyorGUIMenu::new);
      });
      FOUNDRY_GUI = REGISTRY.register("foundry_gui", () -> {
         return IForgeMenuType.create(FoundryGUIMenu::new);
      });
      FIREBOX_GUI = REGISTRY.register("firebox_gui", () -> {
         return IForgeMenuType.create(FireboxGUIMenu::new);
      });
      MINERAL_GRINDER_GUI = REGISTRY.register("mineral_grinder_gui", () -> {
         return IForgeMenuType.create(MineralGrinderGUIMenu::new);
      });
      FISSION_BOMB_GUI = REGISTRY.register("fission_bomb_gui", () -> {
         return IForgeMenuType.create(FissionBombGUIMenu::new);
      });
      BREEDER_REACTOR_CONTROL_GUI = REGISTRY.register("breeder_reactor_control_gui", () -> {
         return IForgeMenuType.create(BreederReactorControlGUIMenu::new);
      });
      FISSION_WARHEAD_GUI = REGISTRY.register("fission_warhead_gui", () -> {
         return IForgeMenuType.create(FissionWarheadGUIMenu::new);
      });
      ENERGY_DISPLAY = REGISTRY.register("energy_display", () -> {
         return IForgeMenuType.create(EnergyDisplayMenu::new);
      });
      AB_GUI = REGISTRY.register("ab_gui", () -> {
         return IForgeMenuType.create(ABGuiMenu::new);
      });
      FUSION_BOMB_GUI = REGISTRY.register("fusion_bomb_gui", () -> {
         return IForgeMenuType.create(FusionBombGUIMenu::new);
      });
      MACHINEPUT_GUI_4X = REGISTRY.register("machineput_gui_4x", () -> {
         return IForgeMenuType.create(MachineputGUI4xMenu::new);
      });
      CRUSHER_GUI = REGISTRY.register("crusher_gui", () -> {
         return IForgeMenuType.create(CrusherGUIMenu::new);
      });
      CONVEYOR_SPLITTER_GUI = REGISTRY.register("conveyor_splitter_gui", () -> {
         return IForgeMenuType.create(ConveyorSplitterGUIMenu::new);
      });
      PROGRESS_GUI = REGISTRY.register("progress_gui", () -> {
         return IForgeMenuType.create(ProgressGUIMenu::new);
      });
   }
}
