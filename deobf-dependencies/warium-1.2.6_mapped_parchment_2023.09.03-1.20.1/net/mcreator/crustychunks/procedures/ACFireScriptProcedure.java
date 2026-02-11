package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SmallFlakShellProjectileEntity;
import net.mcreator.crustychunks.entity.SmallShellFireEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class ACFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      Direction playerdirection = Direction.NORTH;
      boolean found = false;
      boolean DetectedPlayer = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double Pitch = 0.0D;
      double Xvector = 0.0D;
      double Zvector = 0.0D;
      double Barrels = 0.0D;
      BlockPos ammodrum = new BlockPos(0, 0, 0);
      if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         ammodrum = BlockPos.containing(x, y + 1.0D, z);
      } else if (world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).getBlock() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         ammodrum = BlockPos.containing(x, y - 1.0D, z);
      } else if (world.getBlockState(BlockPos.containing(x, y, z + 1.0D)).getBlock() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         ammodrum = BlockPos.containing(x, y, z + 1.0D);
      } else if (world.getBlockState(BlockPos.containing(x, y, z - 1.0D)).getBlock() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         ammodrum = BlockPos.containing(x, y, z - 1.0D);
      } else if (world.getBlockState(BlockPos.containing(x + 1.0D, y, z)).getBlock() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         ammodrum = BlockPos.containing(x + 1.0D, y, z);
      } else if (world.getBlockState(BlockPos.containing(x - 1.0D, y, z)).getBlock() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get()) {
         ammodrum = BlockPos.containing(x - 1.0D, y, z);
      }

      if (0.0D < ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Cooldown")) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Cooldown", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") - 1.0D);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else {
         if (1.0D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.getValue(_dp);
               } else {
                  _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                        var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(blockstate).getStepX() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "X")) || 1.0D > Math.abs((double)((<undefinedtype>)(new Object() {
            public Direction getDirection(BlockState _bs) {
               Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
               if (_prop instanceof DirectionProperty) {
                  DirectionProperty _dp = (DirectionProperty)_prop;
                  return (Direction)_bs.getValue(_dp);
               } else {
                  _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                  Direction var10000;
                  if (_prop instanceof EnumProperty) {
                     EnumProperty _ep = (EnumProperty)_prop;
                     if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                        var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                        return var10000;
                     }
                  }

                  var10000 = Direction.NORTH;
                  return var10000;
               }
            }
         })).getDirection(blockstate).getStepZ() - ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Z"))) {
            Pitch = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Pitch");
            Xvector = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "X") + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.getValue(_dp);
                  } else {
                     _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                           var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).getStepX();
            Zvector = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Z") + (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.getValue(_dp);
                  } else {
                     _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                           var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).getStepZ();
         }

         if (0.0D == Xvector * Zvector) {
            Xvector = (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.getValue(_dp);
                  } else {
                     _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                           var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).getStepX();
            Zvector = (double)((<undefinedtype>)(new Object() {
               public Direction getDirection(BlockState _bs) {
                  Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                  if (_prop instanceof DirectionProperty) {
                     DirectionProperty _dp = (DirectionProperty)_prop;
                     return (Direction)_bs.getValue(_dp);
                  } else {
                     _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                     Direction var10000;
                     if (_prop instanceof EnumProperty) {
                        EnumProperty _ep = (EnumProperty)_prop;
                        if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                           var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                           return var10000;
                        }
                     }

                     var10000 = Direction.NORTH;
                     return var10000;
                  }
               }
            })).getDirection(blockstate).getStepZ();
         }

         if (world instanceof Level) {
            Level _level44 = (Level)world;
            if (_level44.hasNeighborSignal(BlockPos.containing(x, y, z))) {
               Level _level;
               BlockPos _bp;
               BlockEntity _blockEntity;
               BlockState _bs;
               if (((<undefinedtype>)(new Object() {
                  public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "fired") && !world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("fired", false);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (0.0D < ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "Ammo") && (((<undefinedtype>)(new Object() {
                  public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                  }
               })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("Large") || ((<undefinedtype>)(new Object() {
                  public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                  }
               })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("LargePF")) && !((<undefinedtype>)(new Object() {
                  public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "fired") && world.getBlockState(BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
                  public Direction getDirection(BlockState _bs) {
                     Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                     if (_prop instanceof DirectionProperty) {
                        DirectionProperty _dp = (DirectionProperty)_prop;
                        return (Direction)_bs.getValue(_dp);
                     } else {
                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                        Direction var10000;
                        if (_prop instanceof EnumProperty) {
                           EnumProperty _ep = (EnumProperty)_prop;
                           if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                              var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                              return var10000;
                           }
                        }

                        var10000 = Direction.NORTH;
                        return var10000;
                     }
                  }
               })).getDirection(blockstate).getStepX() * 1) + 0.5D, y + (double)(((<undefinedtype>)(new Object() {
                  public Direction getDirection(BlockState _bs) {
                     Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                     if (_prop instanceof DirectionProperty) {
                        DirectionProperty _dp = (DirectionProperty)_prop;
                        return (Direction)_bs.getValue(_dp);
                     } else {
                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                        Direction var10000;
                        if (_prop instanceof EnumProperty) {
                           EnumProperty _ep = (EnumProperty)_prop;
                           if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                              var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                              return var10000;
                           }
                        }

                        var10000 = Direction.NORTH;
                        return var10000;
                     }
                  }
               })).getDirection(blockstate).getStepY() * 1) + 0.5D, z + (double)(((<undefinedtype>)(new Object() {
                  public Direction getDirection(BlockState _bs) {
                     Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                     if (_prop instanceof DirectionProperty) {
                        DirectionProperty _dp = (DirectionProperty)_prop;
                        return (Direction)_bs.getValue(_dp);
                     } else {
                        _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                        Direction var10000;
                        if (_prop instanceof EnumProperty) {
                           EnumProperty _ep = (EnumProperty)_prop;
                           if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                              var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                              return var10000;
                           }
                        }

                        var10000 = Direction.NORTH;
                        return var10000;
                     }
                  }
               })).getDirection(blockstate).getStepZ() * 1) + 0.5D)).is(BlockTags.create(new ResourceLocation("crusty_chunks:acbarrel")))) {
                  Barrels = 1.0D;

                  for(int index0 = 0; index0 < 5; ++index0) {
                     if (world.getBlockState(BlockPos.containing(x + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D)).is(BlockTags.create(new ResourceLocation("crusty_chunks:acbarrel")))) {
                        ++Barrels;
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Barrels", Barrels);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.BLOCKS, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                     } else {
                        _level.playLocalSound(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.BLOCKS, 80.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.BLOCKS, 24.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.4D));
                     } else {
                        _level.playLocalSound(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:cannonfar")), SoundSource.BLOCKS, 24.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.4D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:heavyautocannonshot")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                     } else {
                        _level.playLocalSound(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:heavyautocannonshot")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                     }
                  }

                  ServerLevel projectileLevel;
                  if (world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     projectileLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepX() * (2.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepY() * (2.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepZ() * (2.0D + Barrels) + 0.5D, 15, 0.2D, 0.2D, 0.2D, 0.03D);
                  }

                  MuzzleFlashProcedure.execute(world, x + (double)((<undefinedtype>)(new Object() {
                     public Direction getDirection(BlockState _bs) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                        if (_prop instanceof DirectionProperty) {
                           DirectionProperty _dp = (DirectionProperty)_prop;
                           return (Direction)_bs.getValue(_dp);
                        } else {
                           _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                           Direction var10000;
                           if (_prop instanceof EnumProperty) {
                              EnumProperty _ep = (EnumProperty)_prop;
                              if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                 var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                 return var10000;
                              }
                           }

                           var10000 = Direction.NORTH;
                           return var10000;
                        }
                     }
                  })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                     public Direction getDirection(BlockState _bs) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                        if (_prop instanceof DirectionProperty) {
                           DirectionProperty _dp = (DirectionProperty)_prop;
                           return (Direction)_bs.getValue(_dp);
                        } else {
                           _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                           Direction var10000;
                           if (_prop instanceof EnumProperty) {
                              EnumProperty _ep = (EnumProperty)_prop;
                              if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                 var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                 return var10000;
                              }
                           }

                           var10000 = Direction.NORTH;
                           return var10000;
                        }
                     }
                  })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                     public Direction getDirection(BlockState _bs) {
                        Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                        if (_prop instanceof DirectionProperty) {
                           DirectionProperty _dp = (DirectionProperty)_prop;
                           return (Direction)_bs.getValue(_dp);
                        } else {
                           _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                           Direction var10000;
                           if (_prop instanceof EnumProperty) {
                              EnumProperty _ep = (EnumProperty)_prop;
                              if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                 var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                 return var10000;
                              }
                           }

                           var10000 = Direction.NORTH;
                           return var10000;
                        }
                     }
                  })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D);
                  if (world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     projectileLevel.sendParticles(ParticleTypes.FLAME, x + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepX() * (1.0D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepY() * (1.0D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D, 4, 0.0D, 0.0D, 0.0D, 0.02D);
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ());
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "Ammo") - 1.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("fired", true);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(x, y, z);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Cooldown", 5.0D);
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  Projectile _entityToSpawn;
                  if (((<undefinedtype>)(new Object() {
                     public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                     }
                  })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("Large")) {
                     if (world instanceof ServerLevel) {
                        projectileLevel = (ServerLevel)world;
                        _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new SmallShellFireEntity((EntityType)CrustyChunksModEntities.SMALL_SHELL_FIRE.get(), level);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              entityToSpawn.setCritArrow(true);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, 2.5F, 1);
                        _entityToSpawn.setPos(x + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepX() * (1.5D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepY() * (1.5D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                           public Direction getDirection(BlockState _bs) {
                              Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                              if (_prop instanceof DirectionProperty) {
                                 DirectionProperty _dp = (DirectionProperty)_prop;
                                 return (Direction)_bs.getValue(_dp);
                              } else {
                                 _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                                 Direction var10000;
                                 if (_prop instanceof EnumProperty) {
                                    EnumProperty _ep = (EnumProperty)_prop;
                                    if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                       var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                       return var10000;
                                    }
                                 }

                                 var10000 = Direction.NORTH;
                                 return var10000;
                              }
                           }
                        })).getDirection(blockstate).getStepZ() * (1.5D + Barrels) + 0.5D);
                        _entityToSpawn.shoot(Xvector, Pitch, Zvector, (float)(4.5D + Barrels / 1.2D), (float)(8.0D / (Barrels * 2.0D)));
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }
                  } else if (((<undefinedtype>)(new Object() {
                     public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                     }
                  })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("LargePF") && world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new SmallFlakShellProjectileEntity((EntityType)CrustyChunksModEntities.SMALL_FLAK_SHELL_PROJECTILE.get(), level);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setCritArrow(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, 2.5F, 1);
                     _entityToSpawn.setPos(x + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepX() * (1.5D + Barrels) + 0.5D, y + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepY() * (1.5D + Barrels) + 0.5D, z + (double)((<undefinedtype>)(new Object() {
                        public Direction getDirection(BlockState _bs) {
                           Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
                           if (_prop instanceof DirectionProperty) {
                              DirectionProperty _dp = (DirectionProperty)_prop;
                              return (Direction)_bs.getValue(_dp);
                           } else {
                              _prop = _bs.getBlock().getStateDefinition().getProperty("axis");
                              Direction var10000;
                              if (_prop instanceof EnumProperty) {
                                 EnumProperty _ep = (EnumProperty)_prop;
                                 if (_ep.getPossibleValues().toArray()[0] instanceof Axis) {
                                    var10000 = Direction.fromAxisAndDirection((Axis)_bs.getValue(_ep), AxisDirection.POSITIVE);
                                    return var10000;
                                 }
                              }

                              var10000 = Direction.NORTH;
                              return var10000;
                           }
                        }
                     })).getDirection(blockstate).getStepZ() * (1.5D + Barrels) + 0.5D);
                     _entityToSpawn.shoot(Xvector, Pitch, Zvector, (float)(4.5D + Barrels / 1.2D), (float)(8.0D / (Barrels * 2.0D)));
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }
            }
         }
      }

   }
}
