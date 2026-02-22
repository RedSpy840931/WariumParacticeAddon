package com.redspy.wariumpracticeaddon.registry;

import com.redspy.wariumpracticeaddon.block.CompactRocketPodBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class WariumPracticeAddonBlocks{
    public static final DeferredRegister<Block> BLOCKS;
    public static final RegistryObject<Block> COMPACT_ROCKET_POD;

static {
    BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "wariumpracticeaddon");
    COMPACT_ROCKET_POD = BLOCKS.register("compact_rocket_pod", CompactRocketPodBlock::new);

    }

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}
}
