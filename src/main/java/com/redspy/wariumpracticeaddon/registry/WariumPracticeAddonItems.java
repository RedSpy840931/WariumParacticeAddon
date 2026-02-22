package com.redspy.wariumpracticeaddon.registry;

import com.redspy.wariumpracticeaddon.WariumPracticeAddon;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class WariumPracticeAddonItems {

    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> COMPACT_ROCKET_POD;

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WariumPracticeAddon.MODID);

        COMPACT_ROCKET_POD = block(WariumPracticeAddonBlocks.COMPACT_ROCKET_POD);
    }

    // Создание предмета на основе существующего блока
    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Подключение регистра к шине событий мода
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}