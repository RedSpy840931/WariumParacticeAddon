package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class CuttersRightclickedOnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
      Level _level;
      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.RAZOR_WIRE.get()) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.hurt(4, RandomSource.create(), (ServerPlayer)null)) {
            itemstack.shrink(1);
            itemstack.setDamageValue(0);
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.COBWEB) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.hurt(1, RandomSource.create(), (ServerPlayer)null)) {
            itemstack.shrink(1);
            itemstack.setDamageValue(0);
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.IRON_BARS) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.hurt(8, RandomSource.create(), (ServerPlayer)null)) {
            itemstack.shrink(1);
            itemstack.setDamageValue(0);
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.VINE) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.hurt(1, RandomSource.create(), (ServerPlayer)null)) {
            itemstack.shrink(1);
            itemstack.setDamageValue(0);
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.WIRE_FENCE.get()) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (itemstack.hurt(8, RandomSource.create(), (ServerPlayer)null)) {
            itemstack.shrink(1);
            itemstack.setDamageValue(0);
         }
      }

   }
}
