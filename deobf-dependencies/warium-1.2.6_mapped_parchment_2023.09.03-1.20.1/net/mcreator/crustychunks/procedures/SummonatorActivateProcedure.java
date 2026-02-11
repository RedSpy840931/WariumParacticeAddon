package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class SummonatorActivateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.SONIC_BOOM, x, y, z, 15, 3.0D, 3.0D, 3.0D, 1.0D);
      }

      int horizontalRadiusSquare = 49;
      int verticalRadiusSquare = 49;
      int yIterationsSquare = verticalRadiusSquare;

      for(int i = -verticalRadiusSquare; i <= yIterationsSquare; ++i) {
         for(int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; ++xi) {
            for(int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; ++zi) {
               BlockPos _bp;
               BlockState _bs;
               BlockState _bso;
               UnmodifiableIterator var16;
               Entry entry;
               Property _property;
               BlockEntity _be;
               CompoundTag _bnbt;
               if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() == CrustyChunksModBlocks.ROBOT_CHUTE.get()) {
                  _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.ACTIVE_ROBOT_CHUTE.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var16 = _bso.getValues().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var20) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var27) {
                        }
                     }
                  }
               }

               if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() == CrustyChunksModBlocks.GAS_DISPENSER.get()) {
                  _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.GAS_DISPENSER.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var16 = _bso.getValues().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var26) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var25) {
                        }
                     }
                  }
               }

               if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() == CrustyChunksModBlocks.SUMMONATOR.get()) {
                  _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.SUMMONATOR_ACTIVE.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var16 = _bso.getValues().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var24) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var23) {
                        }
                     }
                  }
               }

               if (world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).getBlock() == CrustyChunksModBlocks.DEFENSE_CORE.get()) {
                  _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                  _bs = ((Block)CrustyChunksModBlocks.DEFENSE_CORE.get()).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var16 = _bso.getValues().entrySet().iterator();

                  while(var16.hasNext()) {
                     entry = (Entry)var16.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var22) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var21) {
                        }
                     }
                  }
               }
            }
         }
      }

      ++CrustyChunksModVariables.MapVariables.get(world).Production;
      CrustyChunksModVariables.MapVariables.get(world).syncData(world);
   }
}
