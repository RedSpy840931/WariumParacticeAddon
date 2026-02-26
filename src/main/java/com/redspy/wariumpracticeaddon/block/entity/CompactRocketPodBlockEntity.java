package com.redspy.wariumpracticeaddon.block.entity;

import com.redspy.wariumpracticeaddon.block.CompactRocketPodBlock;
import com.redspy.wariumpracticeaddon.registry.WariumPracticeAddonBlockEntities;
import net.mcreator.crustychunks.entity.FireSpearRocketProjectileEntity;
import net.mcreator.crustychunks.entity.SeekerSpearMissileProjectileEntity;
import net.mcreator.crustychunks.entity.StrikeSpearProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CompactRocketPodBlockEntity extends BlockEntity {

    public int ammo = 0;
    public int cooldown = 0;
    public String rocketType = "Null";

    public CompactRocketPodBlockEntity(BlockPos pPos, BlockState pState) {
        super(WariumPracticeAddonBlockEntities.COMPACT_ROCKET_POD_BE.get(), pPos, pState);
    }

    public void tick() {
        if (cooldown > 0) cooldown--;

        if (cooldown <= 0 && level != null && level.hasNeighborSignal(worldPosition)) {
            BlockState state = level.getBlockState(worldPosition);
            Direction facing = state.getValue(CompactRocketPodBlock.FACING);
            fire(facing);
        }
    }

    private void fire(Direction facing) {
        if (ammo <= 0 || level == null || level.isClientSide) return;

        double spawnX = worldPosition.getX() + 0.5 + (facing.getStepX() * 2);
        double spawnY = worldPosition.getY() + 0.5;
        double spawnZ = worldPosition.getZ() + 0.5 + (facing.getStepZ() * 2);

        net.minecraft.world.entity.projectile.Projectile projectile = null;
        if (rocketType.equals("Fire")) {
            projectile = new FireSpearRocketProjectileEntity(CrustyChunksModEntities.FIRE_SPEAR_ROCKET_PROJECTILE.get(), level);
        } else if (rocketType.equals("Seeker")) {
            projectile = new SeekerSpearMissileProjectileEntity(CrustyChunksModEntities.SEEKER_SPEAR_MISSILE_PROJECTILE.get(), level);
        } else if (rocketType.equals("Strike")) {
            projectile = new StrikeSpearProjectileEntity(CrustyChunksModEntities.STRIKE_SPEAR_PROJECTILE.get(), level);
        }

        if (projectile != null) {
            projectile.setPos(spawnX, spawnY, spawnZ);
            // Увеличил скорость с 3.0F до 5.0F
            projectile.shoot(facing.getStepX(), facing.getStepY(), facing.getStepZ(), 5.0F, 0.0F);
            level.addFreshEntity(projectile);

        }

        ammo--;
        cooldown = 10;
        if (ammo == 0) rocketType = "Null";
        setChanged();
    }

    public boolean reload(ItemStack stack, Player player) {
        if (ammo >= 2) return false;

        String typeToLoad = "Null";
        if (stack.getItem() == CrustyChunksModItems.FIRE_SPEAR_ROCKET.get()) typeToLoad = "Fire";
        if (stack.getItem() == CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get()) typeToLoad = "Seeker";
        if (stack.getItem() == CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get()) typeToLoad = "Strike";

        if (typeToLoad.equals("Null")) return false;

        if (ammo > 0 && !rocketType.equals(typeToLoad)) return false;

        rocketType = typeToLoad;
        ammo++;
        if (!player.isCreative()) stack.shrink(1);

        if (level != null) {
            level.playSound(null, worldPosition, SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.BLOCKS, 1.0F, 0.3F);
        }

        setChanged();
        return true;
    }

    public boolean unload(Player player) {
        if (ammo <= 0 || level == null || level.isClientSide) return false;

        // Возвращаем предмет в мир
        Item itemToDrop = null;
        if (rocketType.equals("Fire")) itemToDrop = CrustyChunksModItems.FIRE_SPEAR_ROCKET.get();
        if (rocketType.equals("Seeker")) itemToDrop = CrustyChunksModItems.SEEKER_SPEAR_ROCKET.get();
        if (rocketType.equals("Strike")) itemToDrop = CrustyChunksModItems.STRIKE_SPEAR_MISSILE.get();

        if (itemToDrop != null) {
            // Выбрасываем предмет над установкой
            ItemEntity entityToSpawn = new ItemEntity(level, worldPosition.getX() + 0.5, worldPosition.getY() + 1.0, worldPosition.getZ() + 0.5, new ItemStack(itemToDrop));
            entityToSpawn.setPickUpDelay(10);
            level.addFreshEntity(entityToSpawn);
        }

        // Проигрываем звук металлического люка при разрядке
        level.playSound(null, worldPosition, SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.BLOCKS, 1.0F, 0.3F);

        ammo--;
        if (ammo == 0) rocketType = "Null";
        setChanged();
        return true;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Ammo", ammo);
        tag.putInt("Cooldown", cooldown);
        tag.putString("Type", rocketType);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ammo = tag.getInt("Ammo");
        cooldown = tag.getInt("Cooldown");
        rocketType = tag.getString("Type");
    }
}