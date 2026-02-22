package com.redspy.wariumpracticeaddon.registry;

import com.redspy.wariumpracticeaddon.WariumPracticeAddon;
import com.redspy.wariumpracticeaddon.block.entity.CompactRocketPodBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class WariumPracticeAddonBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES;
    public static final RegistryObject<BlockEntityType<CompactRocketPodBlockEntity>> COMPACT_ROCKET_POD_BE;

    static {
        BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WariumPracticeAddon.MODID);

        // Привязываем наш BlockEntity к нашему блоку
        COMPACT_ROCKET_POD_BE = BLOCK_ENTITIES.register("compact_rocket_pod_be",
                () -> BlockEntityType.Builder.of(CompactRocketPodBlockEntity::new,
                        WariumPracticeAddonBlocks.COMPACT_ROCKET_POD.get()).build(null));
    }

    // Подключение регистра к шине событий мода
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}