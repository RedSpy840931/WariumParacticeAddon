package com.redspy.wariumpracticeaddon.block;

import com.redspy.wariumpracticeaddon.block.entity.CompactRocketPodBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CompactRocketPodBlock extends Block implements EntityBlock {

    // Направление блока.
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    // Положение блока.
    public static final EnumProperty<PodOrientation> ORIENTATION = EnumProperty.create("orientation", PodOrientation.class);

    // Хитбоксы на полу.
    public static final VoxelShape SHAPE_NORTH_SOUTH_DOWN = Block.box(0, 0, -16, 16, 8, 32);
    public static final VoxelShape SHAPE_EAST_WEST_DOWN = Block.box(-16, 0, 0, 32, 8, 16);

    // Хитбоксы на потолке.
    public static final VoxelShape SHAPE_NORTH_SOUTH_UP = Block.box(0, 8, -16, 16, 16, 32);
    public static final VoxelShape SHAPE_EAST_WEST_UP = Block.box(-16, 8, 0, 32, 16, 16);

    // Хитбоксы для левой стороны.
    public static final VoxelShape SHAPE_NORTH_SOUTH_V_LEFT = Block.box(0, 0, -16, 8, 16, 32);
    public static final VoxelShape SHAPE_EAST_WEST_V_LEFT = Block.box(-16, 0, 8, 32, 16, 16);

    // Хитбоксы для правой стороны.
    public static final VoxelShape SHAPE_NORTH_SOUTH_V_RIGHT = Block.box(8, 0, -16, 16, 16, 32);
    public static final VoxelShape SHAPE_EAST_WEST_V_RIGHT = Block.box(-16, 0, 0, 32, 16, 8);

    public CompactRocketPodBlock() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.ANVIL)
                .strength(5.0F, 15.0F)
                .noOcclusion());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(ORIENTATION, PodOrientation.DOWN));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction facing = pContext.getHorizontalDirection().getOpposite();

        // Установка боком при зажатом шифте.
        if (pContext.getPlayer() != null && pContext.getPlayer().isShiftKeyDown()) {
            Vec3 hitPos = pContext.getClickLocation().subtract(Vec3.atLowerCornerOf(pContext.getClickedPos()));
            double hitX = hitPos.x;
            double hitZ = hitPos.z;

            boolean isLeft = (facing.getAxis() == Direction.Axis.Z) ? (hitX < 0.5) : (hitZ > 0.5);

            return this.defaultBlockState().setValue(FACING, facing)
                    .setValue(ORIENTATION, isLeft ? PodOrientation.VERTICAL_LEFT : PodOrientation.VERTICAL_RIGHT);
        } else {
            // Обычная установка на пол или потолок.
            Direction clickedFace = pContext.getClickedFace();
            BlockPos blockpos = pContext.getClickedPos();

            PodOrientation orientation = (clickedFace != Direction.DOWN && (clickedFace == Direction.UP || pContext.getClickLocation().y - (double)blockpos.getY() <= 0.5D))
                    ? PodOrientation.DOWN
                    : PodOrientation.UP;

            return this.defaultBlockState().setValue(FACING, facing).setValue(ORIENTATION, orientation);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, ORIENTATION);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        PodOrientation orientation = pState.getValue(ORIENTATION);

        // Выбор хитбокса.
        switch (orientation) {
            case UP:
                return (facing.getAxis() == Direction.Axis.X) ? SHAPE_EAST_WEST_UP : SHAPE_NORTH_SOUTH_UP;
            case VERTICAL_LEFT:
                return (facing.getAxis() == Direction.Axis.X) ? SHAPE_EAST_WEST_V_LEFT : SHAPE_NORTH_SOUTH_V_LEFT;
            case VERTICAL_RIGHT:
                return (facing.getAxis() == Direction.Axis.X) ? SHAPE_EAST_WEST_V_RIGHT : SHAPE_NORTH_SOUTH_V_RIGHT;
            case DOWN:
            default:
                return (facing.getAxis() == Direction.Axis.X) ? SHAPE_EAST_WEST_DOWN : SHAPE_NORTH_SOUTH_DOWN;
        }
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
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        // Создание сущности блока.
        return new CompactRocketPodBlockEntity(pPos, pState);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        // Проверка клика на сервере.
        if (!pLevel.isClientSide) {
            BlockEntity be = pLevel.getBlockEntity(pPos);
            if (be instanceof CompactRocketPodBlockEntity pod) {
                ItemStack stack = pPlayer.getItemInHand(pHand);

                // Проверка на пустую руку и шифт для разрядки.
                if (pPlayer.isShiftKeyDown() && stack.isEmpty()) {
                    if (pod.unload(pPlayer)) return InteractionResult.SUCCESS;
                } else {
                    // Иначе попытка зарядки.
                    if (pod.reload(stack, pPlayer)) return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        // Обновление логики каждый тик.
        if (pLevel.isClientSide()) return null;
        return (level, pos, state, blockEntity) -> {
            if (blockEntity instanceof CompactRocketPodBlockEntity be) {
                be.tick();
            }
        };
    }

    // Варианты положения блока.
    public enum PodOrientation implements StringRepresentable {
        DOWN("down"),
        UP("up"),
        VERTICAL_LEFT("vertical_left"),
        VERTICAL_RIGHT("vertical_right");

        private final String name;

        PodOrientation(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }
}