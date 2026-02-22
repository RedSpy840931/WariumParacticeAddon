package com.redspy.wariumpracticeaddon.block.entity;

import com.redspy.wariumpracticeaddon.registry.WariumPracticeAddonBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CompactRocketPodBlockEntity extends BlockEntity {

    // Конструктор требуемый игрой
    public CompactRocketPodBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(WariumPracticeAddonBlockEntities.COMPACT_ROCKET_POD_BE.get(), pPos, pBlockState);
    }

    // Скоро мы добавим сюда инвентарь для хранения ракет
    // И метод tick который будет проверять редстоун сигнал
}