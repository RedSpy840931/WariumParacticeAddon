package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.registries.ForgeRegistries;

public class PowerReactorTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y - 2.0D, z)).getBlock() == CrustyChunksModBlocks.POWER_REACTOR_PORT.get() && world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.BREEDER_REACTOR_CORE.get() && world.getBlockState(BlockPos.containing(x, y - 1.0D, z - 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x, y - 1.0D, z + 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x - 2.0D, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x + 2.0D, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y - 1.0D, z - 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y - 1.0D, z + 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x - 2.0D, y - 1.0D, z), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x + 2.0D, y - 1.0D, z), "Ready") && world.getBlockState(BlockPos.containing(x, y, z - 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x, y, z + 2.0D)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x - 2.0D, y, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && world.getBlockState(BlockPos.containing(x + 2.0D, y, z)).getBlock() == CrustyChunksModBlocks.REACTION_CHAMBER.get() && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y, z - 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x, y, z + 2.0D), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x - 2.0D, y, z), "Ready") && ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
         }
      })).getValue(world, BlockPos.containing(x + 2.0D, y, z), "Ready")) {
         BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 2.0D, z));
         int _amount = 3000;
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
               capability.receiveEnergy(_amount, false);
            });
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, 5.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
            }
         }
      }

   }
}
