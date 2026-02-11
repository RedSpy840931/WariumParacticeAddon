package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorHurtProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (Mth.nextInt(RandomSource.create(), 1, 2) == 1 && entity.getPersistentData().getDouble("T2") <= 0.0D) {
            entity.getPersistentData().putDouble("T2", 20.0D);
            int horizontalRadiusSquare = 3;
            int verticalRadiusSquare = 2;
            int yIterationsSquare = verticalRadiusSquare;

            for(int i = -verticalRadiusSquare; i <= yIterationsSquare; ++i) {
               for(int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; ++xi) {
                  for(int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; ++zi) {
                     world.levelEvent(2001, BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), Block.getId(world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi))));
                     if ((!(world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).getDestroySpeed(world, BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)) < 5.0F) || !(world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).getDestroySpeed(world, BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)) >= 0.0F)) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:chippable")))) {
                        HeavyCrackProcedureProcedure.execute(world, x + (double)xi, y + (double)i + 3.0D, z + (double)zi);
                     } else {
                        world.destroyBlock(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), false);
                     }

                     if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi)).getBlock() == CrustyChunksModBlocks.STRUCTURAL_CONCRETE.get()) {
                        BlockPos _bp = BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi);
                        BlockState _bs = ((Block)CrustyChunksModBlocks.REENFORCED_CONCRETE.get()).defaultBlockState();
                        BlockState _bso = world.getBlockState(_bp);
                        UnmodifiableIterator var17 = _bso.getValues().entrySet().iterator();

                        while(var17.hasNext()) {
                           Entry<Property<?>, Comparable<?>> entry = (Entry)var17.next();
                           Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var21) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                        world.levelEvent(2001, BlockPos.containing(x + (double)xi, y + (double)i + 3.0D, z + (double)zi), Block.getId(((Block)CrustyChunksModBlocks.STEEL_BLOCK.get()).defaultBlockState()));
                     }
                  }
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 5.0F, 0.4F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 5.0F, 0.4F, false);
               }
            }

            if (entity instanceof DecimatorEntity) {
               ((DecimatorEntity)entity).setAnimation("Anger");
            }

            ServerLevel _level;
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x, y + 1.5D, z, 15, 2.0D, 0.0D, 2.0D, 1.0D);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), x, y + 1.5D, z, 15, 2.0D, 0.0D, 2.0D, 1.0D);
            }
         }

      }
   }
}
