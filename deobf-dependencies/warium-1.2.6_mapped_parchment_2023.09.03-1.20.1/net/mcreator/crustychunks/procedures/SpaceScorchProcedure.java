package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpaceScorchProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, double scale) {
      Vec3 _center = new Vec3(x, y, z);
      List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(60.0D * scale / 2.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.distanceToSqr(_center);
      })).toList();
      Iterator var11 = _entfound.iterator();

      while(var11.hasNext()) {
         Entity entityiterator = (Entity)var11.next();
         entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("crusty_chunks:vaporized")))), 4000.0F);
         entityiterator.setSecondsOnFire(30);
      }

      int horizontalRadiusSphere = (int)(60.0D * scale) - 1;
      int verticalRadiusSphere = (int)(60.0D * scale) - 1;
      int yIterationsSphere = verticalRadiusSphere;

      for(int i = -verticalRadiusSphere; i <= yIterationsSphere; ++i) {
         for(int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; ++xi) {
            for(int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; ++zi) {
               double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere) + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere) + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
               if (distanceSq <= 1.0D) {
                  BlockPos _bp;
                  BlockState _bs;
                  BlockState _bso;
                  UnmodifiableIterator var20;
                  Entry entry;
                  Property _property;
                  if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).is(BlockTags.create(new ResourceLocation("crusty_chunks:stone"))) || world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).is(BlockTags.create(new ResourceLocation("crusty_chunks:crushable")))) {
                     if (1 == Mth.nextInt(RandomSource.create(), 1, 50) && !world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).canOcclude()) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var32) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else if (Math.random() < 0.5D) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.COBBLED_DEEPSLATE.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var31) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.TUFF.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var30) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dirts")))) {
                     if (1 == Mth.nextInt(RandomSource.create(), 1, 50) && !world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).canOcclude()) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var29) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else if (Math.random() < 0.5D) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.PACKED_MUD.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var28) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.TERRACOTTA.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
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
                  }

                  if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).is(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
                     if (1 == Mth.nextInt(RandomSource.create(), 1, 50) && !world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i + 1.0D, z + (double)zi)).canOcclude()) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH_FULL_BLOCK.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var26) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else if (Math.random() < 0.5D) {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = ((Block)CrustyChunksModBlocks.TRINITITE.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var25) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else {
                        _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                        _bs = Blocks.COBBLED_DEEPSLATE.defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
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
                  }
               }
            }
         }
      }

   }
}
