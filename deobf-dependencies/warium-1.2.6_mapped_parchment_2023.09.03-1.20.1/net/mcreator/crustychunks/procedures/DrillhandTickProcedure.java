package net.mcreator.crustychunks.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DrillhandTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
      if (0.0D < itemstack.getOrCreateTag().getDouble("T")) {
         itemstack.getOrCreateTag().putDouble("T", itemstack.getOrCreateTag().getDouble("T") - 1.0D);
      }

      if (0.0D < itemstack.getOrCreateTag().getDouble("Fluid")) {
         Level _level;
         if (0.0D < itemstack.getOrCreateTag().getDouble("T")) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.7F, (float)Mth.nextDouble(RandomSource.create(), 2.3D, 2.4D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.7F, (float)Mth.nextDouble(RandomSource.create(), 2.3D, 2.4D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.polished_deepslate.break")), SoundSource.NEUTRAL, 0.7F, (float)Mth.nextDouble(RandomSource.create(), 2.3D, 2.4D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.polished_deepslate.break")), SoundSource.NEUTRAL, 0.7F, (float)Mth.nextDouble(RandomSource.create(), 2.3D, 2.4D), false);
               }
            }
         } else if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.5F, (float)Mth.nextDouble(RandomSource.create(), 1.8D, 2.0D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), SoundSource.NEUTRAL, 0.5F, (float)Mth.nextDouble(RandomSource.create(), 1.8D, 2.0D), false);
            }
         }
      }

   }
}
