package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.HugeBulletFireEntity;
import net.mcreator.crustychunks.entity.HugeHEBulletFireEntity;
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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class RACFireScriptProcedure {
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
         Level _level41 = (Level)world;
         if (_level41.hasNeighborSignal(BlockPos.containing(x, y, z))) {
            BlockPos _pos;
            BlockEntity _blockEntity;
            BlockState _bs;
            Level _level;
            if (((<undefinedtype>)(new Object() {
               public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "fired") && !world.isClientSide()) {
               _pos = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_pos);
               _bs = world.getBlockState(_pos);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putBoolean("fired", false);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_pos, _bs, _bs, 3);
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
            })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("Small") || ((<undefinedtype>)(new Object() {
               public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
               }
            })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("SmallHE")) && !((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).getStepZ() * 1) + 0.5D)).getBlock() == CrustyChunksModBlocks.RAC_BARREL.get()) {
               Barrels = 1.0D;
               _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepX() * 1), y + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepY() * 1), z + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 1));
               BlockState _bs = world.getBlockState(_pos);
               Property var36 = _bs.getBlock().getStateDefinition().getProperty("animation");
               IntegerProperty _integerProp;
               if (var36 instanceof IntegerProperty) {
                  _integerProp = (IntegerProperty)var36;
                  world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, 0), 3);
               }

               int _value = 3;
               BlockPos _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepX() * 1), y + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepY() * 1), z + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 1));
               _bs = world.getBlockState(_pos);
               Property var31 = _bs.getBlock().getStateDefinition().getProperty("animation");
               IntegerProperty _integerProp;
               if (var31 instanceof IntegerProperty) {
                  _integerProp = (IntegerProperty)var31;
                  if (_integerProp.getPossibleValues().contains(Integer.valueOf(_value))) {
                     world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, Integer.valueOf(_value)), 3);
                  }
               }

               if (world.getBlockState(BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepX() * 2) + 0.5D, y + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepY() * 2) + 0.5D, z + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 2) + 0.5D)).getBlock() == CrustyChunksModBlocks.RAC_BARREL.get()) {
                  Barrels = 2.0D;
                  _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepX() * 2), y + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepY() * 2), z + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ() * 2));
                  _bs = world.getBlockState(_pos);
                  var36 = _bs.getBlock().getStateDefinition().getProperty("animation");
                  if (var36 instanceof IntegerProperty) {
                     _integerProp = (IntegerProperty)var36;
                     world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, 0), 3);
                  }

                  _value = 3;
                  _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepX() * 2), y + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepY() * 2), z + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ() * 2));
                  _bs = world.getBlockState(_pos);
                  var31 = _bs.getBlock().getStateDefinition().getProperty("animation");
                  if (var31 instanceof IntegerProperty) {
                     _integerProp = (IntegerProperty)var31;
                     if (_integerProp.getPossibleValues().contains(Integer.valueOf(_value))) {
                        world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, Integer.valueOf(_value)), 3);
                     }
                  }

                  if (world.getBlockState(BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepX() * 3) + 0.5D, y + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepY() * 3) + 0.5D, z + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ() * 3) + 0.5D)).getBlock() == CrustyChunksModBlocks.RAC_BARREL.get()) {
                     Barrels = 3.0D;
                     _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepX() * 3), y + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepY() * 3), z + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepZ() * 3));
                     _bs = world.getBlockState(_pos);
                     var36 = _bs.getBlock().getStateDefinition().getProperty("animation");
                     if (var36 instanceof IntegerProperty) {
                        _integerProp = (IntegerProperty)var36;
                        world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, 0), 3);
                     }

                     _value = 3;
                     _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepX() * 3), y + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepY() * 3), z + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepZ() * 3));
                     _bs = world.getBlockState(_pos);
                     var31 = _bs.getBlock().getStateDefinition().getProperty("animation");
                     if (var31 instanceof IntegerProperty) {
                        _integerProp = (IntegerProperty)var31;
                        if (_integerProp.getPossibleValues().contains(Integer.valueOf(_value))) {
                           world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, Integer.valueOf(_value)), 3);
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepX() * 4) + 0.5D, y + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepY() * 4) + 0.5D, z + (double)(((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepZ() * 4) + 0.5D)).getBlock() == CrustyChunksModBlocks.RAC_BARREL.get()) {
                        Barrels = 4.0D;
                        _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepX() * 4), y + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepY() * 4), z + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepZ() * 4));
                        _bs = world.getBlockState(_pos);
                        var36 = _bs.getBlock().getStateDefinition().getProperty("animation");
                        if (var36 instanceof IntegerProperty) {
                           _integerProp = (IntegerProperty)var36;
                           world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, 0), 3);
                        }

                        _value = 3;
                        _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepX() * 4), y + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepY() * 4), z + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepZ() * 4));
                        _bs = world.getBlockState(_pos);
                        var31 = _bs.getBlock().getStateDefinition().getProperty("animation");
                        if (var31 instanceof IntegerProperty) {
                           _integerProp = (IntegerProperty)var31;
                           if (_integerProp.getPossibleValues().contains(Integer.valueOf(_value))) {
                              world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, Integer.valueOf(_value)), 3);
                           }
                        }

                        if (world.getBlockState(BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepX() * 5) + 0.5D, y + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepY() * 5) + 0.5D, z + (double)(((<undefinedtype>)(new Object() {
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
                        })).getDirection(blockstate).getStepZ() * 5) + 0.5D)).getBlock() == CrustyChunksModBlocks.RAC_BARREL.get()) {
                           Barrels = 5.0D;
                           _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                           })).getDirection(blockstate).getStepX() * 5), y + (double)(((<undefinedtype>)(new Object() {
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
                           })).getDirection(blockstate).getStepY() * 5), z + (double)(((<undefinedtype>)(new Object() {
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
                           })).getDirection(blockstate).getStepZ() * 5));
                           _bs = world.getBlockState(_pos);
                           var36 = _bs.getBlock().getStateDefinition().getProperty("animation");
                           if (var36 instanceof IntegerProperty) {
                              _integerProp = (IntegerProperty)var36;
                              world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, 0), 3);
                           }

                           _value = 3;
                           _pos = BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
                           })).getDirection(blockstate).getStepX() * 5), y + (double)(((<undefinedtype>)(new Object() {
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
                           })).getDirection(blockstate).getStepY() * 5), z + (double)(((<undefinedtype>)(new Object() {
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
                           })).getDirection(blockstate).getStepZ() * 5));
                           _bs = world.getBlockState(_pos);
                           var31 = _bs.getBlock().getStateDefinition().getProperty("animation");
                           if (var31 instanceof IntegerProperty) {
                              _integerProp = (IntegerProperty)var31;
                              if (_integerProp.getPossibleValues().contains(Integer.valueOf(_value))) {
                                 world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, Integer.valueOf(_value)), 3);
                              }
                           }
                        }
                     }
                  }
               }

               if (!world.isClientSide()) {
                  _pos = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_pos);
                  _bs = world.getBlockState(_pos);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("Barrels", Barrels);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_pos, _bs, _bs, 3);
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
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:brtttfar")), SoundSource.BLOCKS, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
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
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:brtttfar")), SoundSource.BLOCKS, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
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
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rac")), SoundSource.BLOCKS, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
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
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rac")), SoundSource.BLOCKS, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
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
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.BLOCKS, 8.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.6D));
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
                     })).getDirection(blockstate).getStepZ() * (1.0D + Barrels) + 0.5D, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.BLOCKS, 8.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.6D), false);
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
                  })).getDirection(blockstate).getStepZ() * (2.0D + Barrels) + 0.5D, 3, 0.2D, 0.2D, 0.2D, 0.03D);
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
               if (!world.isClientSide()) {
                  _pos = BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ());
                  _blockEntity = world.getBlockEntity(_pos);
                  _bs = world.getBlockState(_pos);
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
                     _level.sendBlockUpdated(_pos, _bs, _bs, 3);
                  }
               }

               if (!world.isClientSide()) {
                  _pos = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_pos);
                  _bs = world.getBlockState(_pos);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putBoolean("fired", true);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_pos, _bs, _bs, 3);
                  }
               }

               Projectile _entityToSpawn;
               if (((<undefinedtype>)(new Object() {
                  public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                  }
               })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("Small")) {
                  if (world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, 5.0F, 1);
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
                     })).getDirection(blockstate).getStepZ() * (2.0D + Barrels) + 0.5D);
                     _entityToSpawn.shoot(Xvector, Pitch, Zvector, (float)(5.0D + Barrels / 1.5D), (float)(8.0D / (Barrels * 2.0D)));
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               } else if (((<undefinedtype>)(new Object() {
                  public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
                  }
               })).getValue(world, BlockPos.containing((double)ammodrum.getX(), (double)ammodrum.getY(), (double)ammodrum.getZ()), "AmmoType").equals("SmallHE") && world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new HugeHEBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_HE_BULLET_FIRE.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 5.0F, 1);
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
                  })).getDirection(blockstate).getStepZ() * (2.0D + Barrels) + 0.5D);
                  _entityToSpawn.shoot(Xvector, Pitch, Zvector, (float)(5.0D + Barrels / 1.5D), (float)(8.0D / (Barrels * 2.0D)));
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }
         }
      }

   }
}
