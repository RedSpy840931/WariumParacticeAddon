package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class ReactionChamberTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean Ready = false;
      Ready = false;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      BlockPos _bp;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") <= 0.0D) {
         if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:fuelrod")))) {
            FuelRodsDepleteProcedure.execute(world, x, y + 1.0D, z);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.NEUTRAL, 1.0F, 2.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
               }
            }

            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Cooldown", 24000.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }
      } else if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("Cooldown", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") - 1.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z + 1.0D)).getBlock() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.getBlockState(BlockPos.containing(x, y, z - 1.0D)).getBlock() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.getBlockState(BlockPos.containing(x + 1.0D, y, z)).getBlock() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.getBlockState(BlockPos.containing(x - 1.0D, y, z)).getBlock() == CrustyChunksModBlocks.CONTROL_ROD.get() && world.getBlockState(BlockPos.containing(x + 1.0D, y, z + 1.0D)).getBlock() == CrustyChunksModBlocks.REACTOR_CASING.get() && world.getBlockState(BlockPos.containing(x - 1.0D, y, z - 1.0D)).getBlock() == CrustyChunksModBlocks.REACTOR_CASING.get() && world.getBlockState(BlockPos.containing(x + 1.0D, y, z - 1.0D)).getBlock() == CrustyChunksModBlocks.REACTOR_CASING.get() && world.getBlockState(BlockPos.containing(x - 1.0D, y, z + 1.0D)).getBlock() == CrustyChunksModBlocks.REACTOR_CASING.get()) {
         if (world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get()) {
            if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:fuelrod")))) {
               Ready = true;
            } else {
               Ready = false;
            }
         } else if (!world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:fuelrod"))) && world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() != CrustyChunksModBlocks.REACTION_CHAMBER.get()) {
            Ready = false;
         } else {
            Ready = true;
         }
      } else {
         Ready = false;
      }

      if (Ready && world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x + 0.5D, y + 0.7D, z + 0.5D, 8, 0.2D, 0.4D, 0.2D, 0.01D);
      }

      if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putBoolean("Ready", Ready);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

   }
}
