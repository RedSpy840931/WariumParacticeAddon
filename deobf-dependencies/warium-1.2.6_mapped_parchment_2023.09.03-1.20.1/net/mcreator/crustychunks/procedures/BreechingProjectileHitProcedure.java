package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class BreechingProjectileHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Level _level;
      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:chippable")))) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:breakable_metal")))) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:splinterable")))) {
         world.destroyBlock(BlockPos.containing(x, y, z), false);
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:crushable")))) {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)), false);
            }
         }

         BlockPos _bp = BlockPos.containing(x, y, z);
         BlockState _bs = Blocks.GRAVEL.defaultBlockState();
         BlockState _bso = world.getBlockState(_bp);
         UnmodifiableIterator var10 = _bso.getValues().entrySet().iterator();

         while(var10.hasNext()) {
            Entry<Property<?>, Comparable<?>> entry = (Entry)var10.next();
            Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
            if (_property != null && _bs.getValue(_property) != null) {
               try {
                  _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
               } catch (Exception var14) {
               }
            }
         }

         world.setBlock(_bp, _bs, 3);
         world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.COBBLESTONE.defaultBlockState()));
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.POOF, x + 0.5D, y + 0.5D, z + 0.5D, 3, 0.4D, 0.4D, 0.4D, 0.2D);
         }
      }

      CrackProcedureProcedure.execute(world, x, y, z);
      SmallBulletHitProcedure.execute(world, x, y, z);
      world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:doors")))) {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_iron_door")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_iron_door")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)), false);
            }
         }

         world.destroyBlock(BlockPos.containing(x, y, z), false);
      }

   }
}
