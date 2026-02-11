package net.mcreator.crustychunks.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.ForgeRegistries;

public class AsphaltSlabBlock extends SlabBlock {
   public AsphaltSlabBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.TERRACOTTA_BLACK).sound(new ForgeSoundType(1.0F, 1.0F, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.break"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.place"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.deepslate.hit"));
      }, () -> {
         return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.fall"));
      })).strength(1.0F, 8.0F).friction(0.5F).speedFactor(1.05F).jumpFactor(1.25F));
   }
}
