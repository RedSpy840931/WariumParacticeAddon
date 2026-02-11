package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class CableConnectionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         Player _player;
         if (0.0D == itemstack.getOrCreateTag().getDouble("SelectedX") && 0.0D == itemstack.getOrCreateTag().getDouble("SelectedY") && 0.0D == itemstack.getOrCreateTag().getDouble("SelectedZ") && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.ENERGY_NODE.get()) {
            itemstack.getOrCreateTag().putDouble("SelectedX", x);
            itemstack.getOrCreateTag().putDouble("SelectedY", y);
            itemstack.getOrCreateTag().putDouble("SelectedZ", z);
            if (entity instanceof Player) {
               _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§6Position 1 Selected!"), true);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SCRAPE, x + 0.5D, y + 0.5D, z + 0.5D, 25, 0.25D, 0.25D, 0.25D, 0.0D);
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.ENERGY_NODE.get()) {
            if (25.0D >= Math.abs(x - itemstack.getOrCreateTag().getDouble("SelectedX")) && 25.0D >= Math.abs(y - itemstack.getOrCreateTag().getDouble("SelectedY")) && 25.0D >= Math.abs(z - itemstack.getOrCreateTag().getDouble("SelectedZ"))) {
               BlockEntity _blockEntity;
               BlockState _bs;
               Level _level;
               BlockPos _bp;
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("PowerX", itemstack.getOrCreateTag().getDouble("SelectedX"));
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("PowerY", itemstack.getOrCreateTag().getDouble("SelectedY"));
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("PowerZ", itemstack.getOrCreateTag().getDouble("SelectedZ"));
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(itemstack.getOrCreateTag().getDouble("SelectedX"), itemstack.getOrCreateTag().getDouble("SelectedY"), itemstack.getOrCreateTag().getDouble("SelectedZ"));
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("PowerX", x);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(itemstack.getOrCreateTag().getDouble("SelectedX"), itemstack.getOrCreateTag().getDouble("SelectedY"), itemstack.getOrCreateTag().getDouble("SelectedZ"));
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("PowerY", y);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(itemstack.getOrCreateTag().getDouble("SelectedX"), itemstack.getOrCreateTag().getDouble("SelectedY"), itemstack.getOrCreateTag().getDouble("SelectedZ"));
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("PowerZ", z);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               CrustyChunksMod.queueServerWork(1, () -> {
                  BlockPos _bp;
                  BlockEntity _blockEntity;
                  BlockState _bs;
                  Level _level;
                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("PowerX", itemstack.getOrCreateTag().getDouble("SelectedX"));
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("PowerY", itemstack.getOrCreateTag().getDouble("SelectedY"));
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("PowerZ", itemstack.getOrCreateTag().getDouble("SelectedZ"));
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(itemstack.getOrCreateTag().getDouble("SelectedX"), itemstack.getOrCreateTag().getDouble("SelectedY"), itemstack.getOrCreateTag().getDouble("SelectedZ"));
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("PowerX", x);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(itemstack.getOrCreateTag().getDouble("SelectedX"), itemstack.getOrCreateTag().getDouble("SelectedY"), itemstack.getOrCreateTag().getDouble("SelectedZ"));
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("PowerY", y);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(itemstack.getOrCreateTag().getDouble("SelectedX"), itemstack.getOrCreateTag().getDouble("SelectedY"), itemstack.getOrCreateTag().getDouble("SelectedZ"));
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("PowerZ", z);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal("§6Link Succesful!"), true);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _levelx = (ServerLevel)world;
                     _levelx.sendParticles(ParticleTypes.ELECTRIC_SPARK, x + 0.5D, y + 0.5D, z + 0.5D, 25, 0.25D, 0.25D, 0.25D, 0.0D);
                  }

                  if (world instanceof Level) {
                     Level _levelxx = (Level)world;
                     if (!_levelxx.isClientSide()) {
                        _levelxx.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _levelxx.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  itemstack.getOrCreateTag().putDouble("SelectedX", 0.0D);
                  itemstack.getOrCreateTag().putDouble("SelectedY", 0.0D);
                  itemstack.getOrCreateTag().putDouble("SelectedZ", 0.0D);
                  itemstack.shrink(1);
               });
            } else {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                  }
               }

               if (entity instanceof Player) {
                  _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§6Link Failed: Out of Range."), true);
                  }
               }
            }
         }

      }
   }
}
