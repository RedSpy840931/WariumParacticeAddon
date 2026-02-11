package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ScoutDeathProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
            }
         }

         world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(((Block)CrustyChunksModBlocks.GREEN_ARMOR.get()).defaultBlockState()));

         ServerLevel _level;
         ItemEntity entityToSpawn;
         int index1;
         for(index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 0, 3); ++index1) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.ELECTRIC_MOTOR.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.ALUMINUM_PLATE.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }

         for(index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 0, 1); ++index1) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.STEEL_COMPONENT.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }

         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 1.0D, z, 5, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x, y + 1.0D, z, 25, 0.0D, 0.0D, 0.0D, 0.5D);
         }

         if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
