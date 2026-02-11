package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AimerConstantUpdatingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         Player _plrCldCheck28;
         label93: {
            String WeaponAttatched = "";
            boolean Sneaking = false;
            if (entity instanceof Player) {
               _plrCldCheck28 = (Player)entity;
               if (_plrCldCheck28.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  break label93;
               }
            }

            if (entity.isShiftKeyDown()) {
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).LeftKey) {
                  LeftPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }

               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).RightKey) {
                  RightPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }

               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).UpKey) {
                  UpPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }

               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).DownKey) {
                  DownPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }
            } else {
               Player _player;
               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).LeftKey) {
                  LeftPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 4);
                  }
               }

               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).RightKey) {
                  RightPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 4);
                  }
               }

               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).UpKey) {
                  UpPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 4);
                  }
               }

               if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).DownKey) {
                  DownPullOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof Player) {
                     _player = (Player)entity;
                     _player.getCooldowns().addCooldown(itemstack.getItem(), 4);
                  }
               }
            }
         }

         if (itemstack.getOrCreateTag().getDouble("POSX") != 0.0D || itemstack.getOrCreateTag().getDouble("POSY") != 0.0D || itemstack.getOrCreateTag().getDouble("POSZ") != 0.0D) {
            DirectionUpdateProcedure.execute(world, entity, itemstack);
            if ((entity.getPersistentData().getBoolean("Mode") || ((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).LeftKey || ((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).RightKey || ((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).UpKey || ((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).DownKey) && !world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(itemstack.getOrCreateTag().getDouble("POSX"), itemstack.getOrCreateTag().getDouble("POSY"), itemstack.getOrCreateTag().getDouble("POSZ"));
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Updated", 1.0D);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }

         if (itemstack.getOrCreateTag().getBoolean("ATGMMode")) {
            if (entity instanceof Player) {
               _plrCldCheck28 = (Player)entity;
               if (_plrCldCheck28.getCooldowns().isOnCooldown(itemstack.getItem())) {
                  return;
               }
            }

            itemstack.getOrCreateTag().putDouble("Yaw", 0.0D);
            itemstack.getOrCreateTag().putDouble("Pitch", 0.0D);
         }

      }
   }
}
