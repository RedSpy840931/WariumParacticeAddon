package net.mcreator.crustychunks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.ForgeRegistries;

public class SteelBlockBlock extends Block {
   public SteelBlockBlock() {
      super(Properties.of().sound(new ForgeSoundType(1.0F, 1.0F, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.break"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.netherite_block.step"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.hit"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.fall"));
      })).strength(10.0F).requiresCorrectToolForDrops());
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
