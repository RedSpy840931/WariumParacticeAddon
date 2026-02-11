package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.AimerBeamEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class AimerNodeUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double Multiplier = 0.0D;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double FX = 0.0D;
      double FY = 0.0D;
      double FZ = 0.0D;
      double Barrels = 0.0D;
      double Xvector = 0.0D;
      double Zvector = 0.0D;
      double Pitch = 0.0D;
      Direction fdirection = Direction.NORTH;
      sx = -6.0D;
      found = false;

      for(int index0 = 0; index0 < 12; ++index0) {
         sy = -3.0D;

         for(int index1 = 0; index1 < 6; ++index1) {
            sz = -6.0D;

            for(int index2 = 0; index2 < 12; ++index2) {
               BlockPos _bp;
               BlockEntity _blockEntity;
               BlockState _bs;
               Level _level;
               if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).is(BlockTags.create(new ResourceLocation("crusty_chunks:cannon"))) && world.getBlockState(BlockPos.containing(x + sx - (double)((<undefinedtype>)(new Object() {
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
               })).getDirection(world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getStepX(), y + sy - (double)((<undefinedtype>)(new Object() {
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
               })).getDirection(world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getStepY(), z + sz - (double)((<undefinedtype>)(new Object() {
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
               })).getDirection(world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getStepZ())).getBlock() != CrustyChunksModBlocks.MANUAL_AIMER.get()) {
                  FX = x + sx;
                  FY = y + sy;
                  FZ = z + sz;
                  fdirection = ((<undefinedtype>)(new Object() {
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
                  })).getDirection(world.getBlockState(BlockPos.containing(FX, FY, FZ)));
                  if (fdirection != Direction.NORTH && fdirection != Direction.EAST) {
                     Multiplier = -1.0D;
                  } else {
                     Multiplier = 1.0D;
                  }

                  if (!world.isClientSide()) {
                     _bp = BlockPos.containing(FX, FY, FZ);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Pitch", Math.tan(((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(x, y, z), "Pitch") * 0.017453292519943295D));
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (fdirection.getStepX() == 0) {
                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(FX, FY, FZ);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putDouble("X", Math.tan(((<undefinedtype>)(new Object() {
                              public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                 BlockEntity blockEntity = world.getBlockEntity(pos);
                                 return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                              }
                           })).getValue(world, BlockPos.containing(x, y, z), "Yaw") * 0.017453292519943295D) * Multiplier);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(FX, FY, FZ);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putDouble("Z", 0.0D);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }
                  }

                  if (fdirection.getStepZ() == 0) {
                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(FX, FY, FZ);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putDouble("Z", Math.tan(((<undefinedtype>)(new Object() {
                              public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                 BlockEntity blockEntity = world.getBlockEntity(pos);
                                 return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                              }
                           })).getValue(world, BlockPos.containing(x, y, z), "Yaw") * 0.017453292519943295D) * Multiplier);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(FX, FY, FZ);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putDouble("X", 0.0D);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }
                  }

                  if (1.0D >= Math.abs((double)fdirection.getStepX() - ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(FX, FY, FZ), "X")) || 0.5D >= Math.abs((double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(world.getBlockState(BlockPos.containing(FX, FY, FZ))).getStepZ() - ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(FX, FY, FZ), "Z"))) {
                     Pitch = ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(FX, FY, FZ), "Pitch") + 0.05D;
                     Xvector = ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(FX, FY, FZ), "X") + (double)fdirection.getStepX();
                     Zvector = ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(FX, FY, FZ), "Z") + (double)fdirection.getStepZ();
                  }

                  if (0.0D == Xvector * Zvector) {
                     Xvector = (double)fdirection.getStepX();
                     Zvector = (double)fdirection.getStepZ();
                  }

                  if (((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Updated") > 0.0D && !world.isClientSide()) {
                     _bp = BlockPos.containing(FX, FY, FZ);
                     _blockEntity = world.getBlockEntity(_bp);
                     _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putDouble("Updated", ((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(x, y, z), "Updated"));
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }

                  if (((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(FX, FY, FZ), "Updated") > 0.0D) {
                     if (!world.isClientSide()) {
                        _bp = BlockPos.containing(FX, FY, FZ);
                        _blockEntity = world.getBlockEntity(_bp);
                        _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putDouble("Updated", ((<undefinedtype>)(new Object() {
                              public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                                 BlockEntity blockEntity = world.getBlockEntity(pos);
                                 return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                              }
                           })).getValue(world, BlockPos.containing(FX, FY, FZ), "Updated") - 1.0D);
                        }

                        if (world instanceof Level) {
                           _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }

                     ServerLevel projectileLevel;
                     Projectile _entityToSpawn;
                     if (world.getBlockState(BlockPos.containing(FX, FY, FZ)).getBlock() == CrustyChunksModBlocks.ORDINANCE_CORE.get()) {
                        if (world instanceof ServerLevel) {
                           projectileLevel = (ServerLevel)world;
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new AimerBeamEntity((EntityType)CrustyChunksModEntities.AIMER_BEAM.get(), level);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, 0.0F, 0);
                           _entityToSpawn.setPos(FX + (double)(2 * fdirection.getStepX()) + 0.5D, FY + 0.5D, FZ + (double)(2 * fdirection.getStepZ()) + 0.5D);
                           _entityToSpawn.shoot(Xvector, Pitch, Zvector, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     } else if (world.getBlockState(BlockPos.containing(FX, FY, FZ)).getBlock() == CrustyChunksModBlocks.MORTAR.get()) {
                        if (world instanceof ServerLevel) {
                           projectileLevel = (ServerLevel)world;
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new AimerBeamEntity((EntityType)CrustyChunksModEntities.AIMER_BEAM.get(), level);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, 0.0F, 0);
                           _entityToSpawn.setPos(FX + (double)(1 * fdirection.getStepX()) + 0.5D, FY + 1.5D, FZ + (double)(1 * fdirection.getStepZ()) + 0.5D);
                           _entityToSpawn.shoot(Xvector / 2.0D, Pitch + 0.5D, Zvector / 2.0D, 1.0F, 0.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     } else if (world instanceof ServerLevel) {
                        projectileLevel = (ServerLevel)world;
                        _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new AimerBeamEntity((EntityType)CrustyChunksModEntities.AIMER_BEAM.get(), level);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, 0.0F, 0);
                        _entityToSpawn.setPos(FX + (((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(FX, FY, FZ), "Barrels") + 1.0D) * (double)fdirection.getStepX() + 0.5D, FY + 0.5D, FZ + (((<undefinedtype>)(new Object() {
                           public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                              BlockEntity blockEntity = world.getBlockEntity(pos);
                              return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                           }
                        })).getValue(world, BlockPos.containing(FX, FY, FZ), "Barrels") + 1.0D) * (double)((<undefinedtype>)(new Object() {
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
                        })).getDirection(world.getBlockState(BlockPos.containing(FX, FY, FZ))).getStepZ() + 0.5D);
                        _entityToSpawn.shoot(Xvector, Pitch, Zvector, 1.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }
                  }
               } else if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == CrustyChunksModBlocks.NODE_TRIGGER.get() && ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Trigger") > 0.0D && !world.isClientSide()) {
                  _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("Trigger", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "Trigger"));
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("Updated", 0.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Trigger") > 0.0D && !world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("Trigger", 0.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

   }
}
