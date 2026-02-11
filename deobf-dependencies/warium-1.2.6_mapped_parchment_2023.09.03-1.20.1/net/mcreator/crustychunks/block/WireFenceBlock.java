package net.mcreator.crustychunks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.ForgeRegistries;

public class WireFenceBlock extends IronBarsBlock {
   public WireFenceBlock() {
      super(Properties.of().sound(new ForgeSoundType(1.0F, 1.0F, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.break"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place"));
      })).strength(20.0F, 10.0F).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> {
         return false;
      }));
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }
}
