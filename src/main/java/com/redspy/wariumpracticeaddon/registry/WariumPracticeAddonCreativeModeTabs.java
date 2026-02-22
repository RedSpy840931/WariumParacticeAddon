package com.redspy.wariumpracticeaddon.registry;

import com.redspy.wariumpracticeaddon.WariumPracticeAddon;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class WariumPracticeAddonCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS;
    public static final RegistryObject<CreativeModeTab> WARIUM_ADDON_TAB;

    static {
        CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WariumPracticeAddon.MODID);

        WARIUM_ADDON_TAB = CREATIVE_MODE_TABS.register("warium_addon_tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(WariumPracticeAddonItems.COMPACT_ROCKET_POD.get()))
                .title(Component.translatable("creativetab.warium_addon_tab"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(WariumPracticeAddonItems.COMPACT_ROCKET_POD.get());
                    pOutput.accept(Items.DIAMOND); // Тестовый предмет
                })
                .build());
    }

    // Подключение регистра к шине событий мода
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}