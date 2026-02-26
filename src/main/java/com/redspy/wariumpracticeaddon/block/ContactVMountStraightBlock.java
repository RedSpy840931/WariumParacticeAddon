package com.redspy.wariumpracticeaddon.block;

import net.mcreator.crustychunks.entity.*;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ContactVMountStraightBlock extends Block {

    // Горизонтальное направление блока.
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    // Количество установленных плит брони от 0 до 4.
    public static final IntegerProperty TILES = IntegerProperty.create("tiles", 0, 4);
    // Цвет блока (зеленый или желтый).
    public static final EnumProperty<MountColor> COLOR = EnumProperty.create("color", MountColor.class);

    // Хитбокс для направления на север.
    public static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(0, 0, 0, 16, 16, 1),
            Block.box(0, 6.875, 4, 16, 9.125, 16),
            Block.box(0, 5, 1, 16, 11, 5.5)
    );
    // Хитбокс для направления на юг.
    public static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(0, 0, 15, 16, 16, 16),
            Block.box(0, 6.875, 0, 16, 9.125, 12),
            Block.box(0, 5, 10.5, 16, 11, 15)
    );
    // Хитбокс для направления на восток.
    public static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(15, 0, 0, 16, 16, 16),
            Block.box(0, 6.875, 0, 12, 9.125, 16),
            Block.box(10.5, 5, 0, 15, 11, 16)
    );
    // Хитбокс для направления на запад.
    public static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(0, 0, 0, 1, 16, 16),
            Block.box(4, 6.875, 0, 16, 9.125, 16),
            Block.box(1, 5, 0, 5.5, 11, 16)
    );

    public ContactVMountStraightBlock() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .mapColor(MapColor.TERRACOTTA_GREEN)
                .sound(SoundType.NETHERITE_BLOCK)
                .strength(16.0F)
                .noOcclusion());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TILES, 0)
                .setValue(COLOR, MountColor.GREEN));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        // Устанавливаем блок лицевой стороной к игроку.
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, TILES, COLOR);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        // Выбираем правильный хитбокс в зависимости от поворота блока.
        switch (pState.getValue(FACING)) {
            case SOUTH: return SHAPE_SOUTH;
            case EAST: return SHAPE_EAST;
            case WEST: return SHAPE_WEST;
            case NORTH:
            default: return SHAPE_NORTH;
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        int currentTiles = pState.getValue(TILES);
        MountColor currentColor = pState.getValue(COLOR);

        // Проверяем предмет в руке для зарядки плит или покраски.
        if (stack.getItem() == CrustyChunksModItems.ERA_TILE.get() && currentTiles < 4) {
            if (!pLevel.isClientSide) {
                pLevel.setBlock(pPos, pState.setValue(TILES, currentTiles + 1), 3);
                pLevel.playSound(null, pPos, SoundEvents.ARMOR_EQUIP_IRON, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!pPlayer.isCreative()) stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else if (stack.getItem() == Items.GREEN_DYE && currentColor != MountColor.GREEN) {
            if (!pLevel.isClientSide) {
                pLevel.setBlock(pPos, pState.setValue(COLOR, MountColor.GREEN), 3);
                if (!pPlayer.isCreative()) stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else if (stack.getItem() == Items.YELLOW_DYE && currentColor != MountColor.YELLOW) {
            if (!pLevel.isClientSide) {
                pLevel.setBlock(pPos, pState.setValue(COLOR, MountColor.YELLOW), 3);
                if (!pPlayer.isCreative()) stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        int currentTiles = pState.getValue(TILES);

        // Проверяем тип снаряда и наличие активных плит брони.
        if (currentTiles > 0 && (
                pProjectile instanceof HEATEntity ||
                        pProjectile instanceof FireSpearRocketProjectileEntity ||
                        pProjectile instanceof APMediumBulletEntity ||
                        pProjectile instanceof ArtilleryFireProjectileEntity ||
                        pProjectile instanceof ArtillerySolidProjectileEntity ||
                        pProjectile instanceof BlockBusterProjectileEntity ||
                        pProjectile instanceof BreechingProjectileEntity ||
                        pProjectile instanceof BunkerBusterProjectileEntity ||
                        pProjectile instanceof ClusterBombProjectileEntity ||
                        pProjectile instanceof ClusterRocketEntity ||
                        pProjectile instanceof ExtraLargeBulletFireEntity ||
                        pProjectile instanceof FireArtilleryProjectileEntity ||
                        pProjectile instanceof FireBombProjectileEntity ||
                        pProjectile instanceof HugeAIBulletEntity ||
                        pProjectile instanceof HugeBulletFireEntity ||
                        pProjectile instanceof HugeHEBulletFireEntity ||
                        pProjectile instanceof IRMissileEntity ||
                        pProjectile instanceof ImpactGrenadeProjectileEntity ||
                        pProjectile instanceof LargeAPBulletEntity ||
                        pProjectile instanceof LargeAPFireEntity ||
                        pProjectile instanceof LargeBombProjectileEntity ||
                        pProjectile instanceof LargeBulletFireProjectileEntity ||
                        pProjectile instanceof LargeFlakProjectileEntity ||
                        pProjectile instanceof LargeHEATFireEntity ||
                        pProjectile instanceof LargeRadarMissileProjectileEntity ||
                        pProjectile instanceof LargeRocketEntity ||
                        pProjectile instanceof LargeSolidProjectileEntity ||
                        pProjectile instanceof MBTracerFireEntity ||
                        pProjectile instanceof MediumBombProjectileEntity ||
                        pProjectile instanceof MortarProjectileEntity ||
                        pProjectile instanceof RadarSpearMissileProjectileEntity ||
                        pProjectile instanceof RocketEntity ||
                        pProjectile instanceof SeekerSpearMissileProjectileEntity ||
                        pProjectile instanceof StrikeSpearProjectileEntity ||
                        pProjectile instanceof SuperLargeBombProjectileEntity ||
                        pProjectile instanceof TankFireProjectileEntity
        )) {

            // Расчет шанса где 1 тайл это 25 процентов а 4 тайла это 100 процентов.
            float triggerChance = currentTiles * 0.25F;

            if (pLevel.getRandom().nextFloat() < triggerChance) {
                if (!pLevel.isClientSide) {
                    pProjectile.discard();
                    pLevel.setBlock(pHit.getBlockPos(), pState.setValue(TILES, currentTiles - 1), 3);

                    Direction facing = pState.getValue(FACING);
                    BlockPos pos = pHit.getBlockPos();

                    pLevel.explode(null,
                            pos.getX() + 0.5 + facing.getStepX(),
                            pos.getY() + 0.5 + facing.getStepY(),
                            pos.getZ() + 0.5 + facing.getStepZ(),
                            0.5F,
                            Level.ExplosionInteraction.BLOCK);
                }
            } else {
                super.onProjectileHit(pLevel, pState, pHit, pProjectile);
            }
        } else {
            super.onProjectileHit(pLevel, pState, pHit, pProjectile);
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

    // Перечисление для цветов установки.
    public enum MountColor implements StringRepresentable {
        GREEN("green"),
        YELLOW("yellow");

        private final String name;

        MountColor(String name) { this.name = name; }

        @Override
        public String getSerializedName() { return this.name; }
    }
}