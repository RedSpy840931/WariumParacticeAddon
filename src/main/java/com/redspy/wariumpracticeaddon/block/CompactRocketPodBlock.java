package com.redspy.wariumpracticeaddon.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CompactRocketPodBlock extends Block {

    // 1. ОБЯЗАТЕЛЬНО: Объявляем свойство FACING
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    // 2. Определяем формы хитбокса для разных направлений.
    // Так как твой блок сильно вытянут, для Севера/Юга хитбокс один, для Запада/Востока - повернутый.
    // Внимание: Я повернул координаты для Востока/Запада (оси X и Z меняются местами).
    // Возможно, тебе придется немного подогнать цифры под твою модель в Blockbench.
    public static final VoxelShape SHAPE_NORTH_SOUTH = Block.box(0, 0, -16, 16, 8, 32);
    public static final VoxelShape SHAPE_EAST_WEST = Block.box(-16, 0, 0, 32, 8, 16);

    // Конструктор без аргументов (свойства задаем прямо здесь)
    public CompactRocketPodBlock() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.ANVIL)
                .strength(5.0F, 15.0F)
                .noOcclusion()); // <--- Очень важно для больших/нестандартных моделей!

        // 3. Задаем состояние по умолчанию при создании блока
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    // 4. Возвращаем правильный хитбокс в зависимости от того, куда смотрит блок
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        switch (facing) {
            case EAST:
            case WEST:
                return SHAPE_EAST_WEST;
            case SOUTH:
            case NORTH:
            default:
                return SHAPE_NORTH_SOUTH;
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}