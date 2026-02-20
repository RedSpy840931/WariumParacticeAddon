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

public class WariumPracticeAddonCreativeModeTabs {
    // Создаем "отложенный регистр" (DeferredRegister) для вкладок
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WariumPracticeAddon.MODID);

    // Регистрируем саму вкладку
    public static final RegistryObject<CreativeModeTab> WARIUM_ADDON_TAB = CREATIVE_MODE_TABS.register("warium_addon_tab",
            () -> CreativeModeTab.builder()
                    // Иконка вкладки (наш предмет)
                    .icon(() -> new ItemStack(WariumPracticeAddonItems.COMPACT_ROCKET_POD.get()))
                    // Название вкладки (ссылка на файл перевода)
                    .title(Component.translatable("creativetab.warium_addon_tab"))
                    // Логика отображения предметов
                    .displayItems((pParameters, pOutput) -> {
                        // Добавляем наш Compact Rocket Pod в креативную вкладку
                        pOutput.accept(WariumPracticeAddonItems.COMPACT_ROCKET_POD.get());

                        // Для теста оставим алмаз
                        pOutput.accept(Items.DIAMOND);
                    })
                    .build());

    // Метод, который мы вызовем в главном классе
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}