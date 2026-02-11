package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class FusionEffectsProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      CrustyChunksMod.queueServerWork(1, () -> {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rumble")), SoundSource.NEUTRAL, 100.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rumble")), SoundSource.NEUTRAL, 100.0F, 1.0F, false);
            }
         }

         FusionPlasmaCraterProcedure.execute(world, x, y, z);
         FusionScorchProcedure.execute(world, x, y, z);
         int horizontalRadiusSphere = 199;
         int verticalRadiusSphere = 39;
         int yIterationsSphere = verticalRadiusSphere;

         for(int i = -verticalRadiusSphere; i <= yIterationsSphere; ++i) {
            for(int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; ++xi) {
               for(int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; ++zi) {
                  double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere) + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere) + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
                  if (distanceSq <= 1.0D) {
                     BlockPos _bp;
                     BlockState _bs;
                     BlockState _bso;
                     UnmodifiableIterator var18;
                     Entry entry;
                     Property _property;
                     if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).canOcclude() || world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() != Blocks.GRASS_BLOCK && world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() != Blocks.MOSS_BLOCK) {
                        MassBurnBlockProcedure.execute(world, x + (double)xi, y + (double)i, z + (double)zi);
                     } else if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var18 = _bso.getValues().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var28) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else if ((double)Mth.nextInt(RandomSource.create(), 180, 200) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D)) && world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).canOcclude()) {
                        MassBurnBlockProcedure.execute(world, x + (double)xi, y + (double)i, z + (double)zi);
                     }

                     if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).is(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
                        if (!world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).canOcclude() && Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
                           _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                           _bs = ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK.get()).defaultBlockState();
                           _bso = world.getBlockState(_bp);
                           var18 = _bso.getValues().entrySet().iterator();

                           while(var18.hasNext()) {
                              entry = (Entry)var18.next();
                              _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                              if (_property != null && _bs.getValue(_property) != null) {
                                 try {
                                    _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                                 } catch (Exception var27) {
                                 }
                              }
                           }

                           world.setBlock(_bp, _bs, 3);
                        }

                        if ((double)Mth.nextInt(RandomSource.create(), 50, 200) > Math.sqrt(Math.pow(Math.abs(x + (double)xi - x), 2.0D) + Math.pow(Math.abs(z + (double)zi - z), 2.0D)) && world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).getBlock() == Blocks.AIR) {
                           if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
                              _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                              _bs = ((Block)CrustyChunksModBlocks.TRINITITE.get()).defaultBlockState();
                              _bso = world.getBlockState(_bp);
                              var18 = _bso.getValues().entrySet().iterator();

                              while(var18.hasNext()) {
                                 entry = (Entry)var18.next();
                                 _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                                    } catch (Exception var26) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                           } else {
                              _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                              _bs = Blocks.TUFF.defaultBlockState();
                              _bso = world.getBlockState(_bp);
                              var18 = _bso.getValues().entrySet().iterator();

                              while(var18.hasNext()) {
                                 entry = (Entry)var18.next();
                                 _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                                 if (_property != null && _bs.getValue(_property) != null) {
                                    try {
                                       _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                                    } catch (Exception var25) {
                                    }
                                 }
                              }

                              world.setBlock(_bp, _bs, 3);
                           }
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() == Blocks.SNOW) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.AIR.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var18 = _bso.getValues().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var24) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     }

                     if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() == Blocks.SNOW_BLOCK) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.AIR.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var18 = _bso.getValues().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var23) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     }

                     if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() == Blocks.ICE) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.WATER.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var18 = _bso.getValues().entrySet().iterator();

                        while(var18.hasNext()) {
                           entry = (Entry)var18.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var22) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     }
                  }
               }
            }
         }

      });
      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x, y + 4.0D, z, 30.0F, ExplosionInteraction.BLOCK);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x, y + 4.0D, z, 60.0F, ExplosionInteraction.NONE);
         }
      }

      Iterator var9 = (new ArrayList(world.players())).iterator();

      while(var9.hasNext()) {
         Entity entityiterator = (Entity)var9.next();
         CrustyChunksMod.queueServerWork((int)Math.abs(Math.round(Math.sqrt(Math.pow(x - entityiterator.getX(), 2.0D) + Math.pow(z - entityiterator.getZ(), 2.0D)) * 0.5D)), () -> {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:fissionblast")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:fissionblast")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

         });
      }

   }
}
