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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CompactRocketPodBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    // 1. Добавляем свойство HALF (Верхняя или Нижняя половина)
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;

    // Хитбоксы для обычного положения (Half.BOTTOM) - на земле
    public static final VoxelShape SHAPE_NORTH_SOUTH_BOTTOM = Block.box(0, 0, -16, 16, 8, 32);
    public static final VoxelShape SHAPE_EAST_WEST_BOTTOM = Block.box(-16, 0, 0, 32, 8, 16);

    // Хитбоксы для перевернутого положения (Half.TOP) - прикреплены к потолку (смещение Y с 0..8 на 8..16)
    public static final VoxelShape SHAPE_NORTH_SOUTH_TOP = Block.box(0, 8, -16, 16, 16, 32);
    public static final VoxelShape SHAPE_EAST_WEST_TOP = Block.box(-16, 8, 0, 32, 16, 16);

    public CompactRocketPodBlock() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.ANVIL)
                .strength(5.0F, 15.0F)
                .noOcclusion());

        // 2. Добавляем Half.BOTTOM в дефолтное состояние
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, Half.BOTTOM));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        // 3. Логика как у плит/ступенек: определяем, куда кликнул игрок
        Direction clickedFace = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();

        BlockState blockstate = this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());

        // Если игрок кликнул по потолку (грань DOWN) ИЛИ по верхней половине стены -> ставим перевернутым (TOP)
        Half half = clickedFace != Direction.DOWN && (clickedFace == Direction.UP || pContext.getClickLocation().y - (double)blockpos.getY() <= 0.5D) ? Half.BOTTOM : Half.TOP;

        return blockstate.setValue(HALF, half);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        // 4. Обязательно регистрируем новое свойство
        pBuilder.add(FACING, HALF);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        Half half = pState.getValue(HALF);

        // 5. Выдаем нужный хитбокс в зависимости от поворота И высоты
        if (half == Half.TOP) {
            switch (facing) {
                case EAST:
                case WEST: return SHAPE_EAST_WEST_TOP;
                case SOUTH:
                case NORTH:
                default: return SHAPE_NORTH_SOUTH_TOP;
            }
        } else {
            switch (facing) {
                case EAST:
                case WEST: return SHAPE_EAST_WEST_BOTTOM;
                case SOUTH:
                case NORTH:
                default: return SHAPE_NORTH_SOUTH_BOTTOM;
            }
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}