package com.redspy.wariumpracticeaddon.registry;

import com.redspy.wariumpracticeaddon.WariumPracticeAddon;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WariumPracticeAddonItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WariumPracticeAddon.MODID);

    // Предмет для Compact Rocket Pod (ассоциированный с блоком)
    public static final RegistryObject<Item> COMPACT_ROCKET_POD = block(WariumPracticeAddonBlocks.COMPACT_ROCKET_POD);

    // Вспомогательный метод для создания предметов из блоков (как в Warium)
    private static RegistryObject<Item> block(RegistryObject<net.minecraft.world.level.block.Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> {
            return new BlockItem((net.minecraft.world.level.block.Block) block.get(), new Item.Properties());
        });
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}