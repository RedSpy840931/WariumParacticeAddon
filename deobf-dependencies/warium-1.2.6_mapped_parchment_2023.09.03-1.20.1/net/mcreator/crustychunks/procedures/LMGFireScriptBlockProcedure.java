package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.BulletfireProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class LMGFireScriptBlockProcedure {
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
      BlockPos _bp;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("Barrels", 1.0D);
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
      })).getValue(world, BlockPos.containing(x, y, z), "Cooldown")) {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Cooldown", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") - 1.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
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
            Level _level27 = (Level)world;
            if (_level27.hasNeighborSignal(BlockPos.containing(x, y, z)) && 0.0D < ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Ammo") && world.getBlockState(BlockPos.containing(x + (double)(((<undefinedtype>)(new Object() {
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
            })).getDirection(blockstate).getStepZ() * 1) + 0.5D)).is(BlockTags.create(new ResourceLocation("crusty_chunks:mgbarrel")))) {
               ServerLevel _level;
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new BulletfireProjectileEntity((EntityType)CrustyChunksModEntities.BULLETFIRE_PROJECTILE.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        return entityToSpawn;
                     }
                  })).getArrow(_level, 0.1F, 0, (byte)5);
                  _entityToSpawn.setPos(x + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ() * 2) + 0.5D);
                  _entityToSpawn.shoot(Xvector, Pitch, Zvector, 7.5F, 0.9F);
                  _level.addFreshEntity(_entityToSpawn);
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + (double)(((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ() * 3) + 0.5D, 2, 0.1D, 0.1D, 0.1D, 0.01D);
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
               })).getDirection(blockstate).getStepX() * 2.5D + 0.5D, y + (double)((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepY() * 2.5D + 0.5D, z + (double)((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 2.5D + 0.5D);
               CasingDropProcedure.execute(world, x, y, z);
               MediumFireSoundProcedure.execute(world, x, y, z);
               Level _level;
               BlockPos _bp;
               BlockEntity _blockEntity;
               BlockState _bs;
               if (!world.isClientSide()) {
                  _bp = BlockPos.containing(x, y, z);
                  _blockEntity = world.getBlockEntity(_bp);
                  _bs = world.getBlockState(_bp);
                  if (_blockEntity != null) {
                     _blockEntity.getPersistentData().putDouble("Ammo", ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                        }
                     })).getValue(world, BlockPos.containing(x, y, z), "Ammo") - 1.0D);
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
                     _blockEntity.getPersistentData().putDouble("Cooldown", 1.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y - 1.0D, z, new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_CASING.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            }
         }
      }

   }
}
