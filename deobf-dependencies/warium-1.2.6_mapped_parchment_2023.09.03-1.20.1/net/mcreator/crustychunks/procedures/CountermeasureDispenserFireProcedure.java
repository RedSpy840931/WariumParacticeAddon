package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ChaffEntity;
import net.mcreator.crustychunks.entity.VehicleFlareProjectileEntity;
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
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class CountermeasureDispenserFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      Direction playerdirection = Direction.NORTH;
      boolean found = false;
      boolean DetectedPlayer = false;
      boolean fire = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double Pitch = 0.0D;
      double Xvector = 0.0D;
      double Zvector = 0.0D;
      double Barrels = 0.0D;
      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Cooldown") <= 0.0D) {
         BlockState _bs;
         Level _level;
         BlockEntity _blockEntity;
         BlockPos _bp;
         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Ammo") >= 1.0D) {
            Level _level;
            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Type") == 1.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 25.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 25.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.4D, 0.6D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.launch")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.4D, 0.6D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
                  }
               }

               ServerLevel projectileLevel;
               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  projectileLevel.sendParticles(ParticleTypes.FLAME, x + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepX(), y + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepY(), z + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ(), 20, 0.0D, 0.0D, 0.0D, 0.05D);
               }

               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new VehicleFlareProjectileEntity((EntityType)CrustyChunksModEntities.VEHICLE_FLARE_PROJECTILE.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 10.0F, 2, (byte)10);
                  _entityToSpawn.setPos(x + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepX() * 1.5D, y + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepY() * 1.5D, z + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ() * 1.5D);
                  _entityToSpawn.shoot((double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepX(), (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepY(), (double)((<undefinedtype>)(new Object() {
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
                  })).getDirection(blockstate).getStepZ(), 2.0F, 11.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

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
                     _blockEntity.getPersistentData().putDouble("Cooldown", 4.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }
            } else if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Type") == 2.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.BLOCKS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.4D, 0.6D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.4D, 0.6D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle_far")), SoundSource.BLOCKS, 25.0F, (float)Mth.nextDouble(RandomSource.create(), 0.4D, 0.6D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle_far")), SoundSource.BLOCKS, 25.0F, (float)Mth.nextDouble(RandomSource.create(), 0.4D, 0.6D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.dispense")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
                  }
               }

               for(int index0 = 0; index0 < 6; ++index0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel projectileLevel = (ServerLevel)world;
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new ChaffEntity((EntityType)CrustyChunksModEntities.CHAFF.get(), level);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setPierceLevel(piercing);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, 10.0F, 2, (byte)10);
                     _entityToSpawn.setPos(x + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepX() * 1.5D, y + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepY() * 1.5D, z + 0.5D + (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepZ() * 1.5D);
                     _entityToSpawn.shoot((double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepX(), (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepY(), (double)((<undefinedtype>)(new Object() {
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
                     })).getDirection(blockstate).getStepZ(), 1.0F, 15.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }

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
                     _blockEntity.getPersistentData().putDouble("Cooldown", 4.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  }
               }
            }
         } else if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Type", 0.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      }

   }
}
