package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.MortarProjectileEntity;
import net.mcreator.crustychunks.entity.SmokeMortarProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
import net.minecraftforge.registries.ForgeRegistries;

public class MortarOnBlockRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
      if (entity != null) {
         double RocketVelocity = 0.0D;
         double Barrels = 0.0D;
         double Xvector = 0.0D;
         double Zvector = 0.0D;
         double Pitch = 0.0D;
         if (1.0D >= Math.abs((double)((<undefinedtype>)(new Object() {
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
         })).getValue(world, BlockPos.containing(x, y, z), "X")) || 1.0D >= Math.abs((double)((<undefinedtype>)(new Object() {
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
            })).getValue(world, BlockPos.containing(x, y, z), "Pitch") + 0.5D;
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

         ItemStack var10000;
         LivingEntity _livEnt;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         ItemStack var10001;
         Level _level;
         Projectile _entityToSpawn;
         LivingEntity _livEnt;
         Level _level;
         ServerLevel projectileLevel;
         ItemStack _setstack;
         LivingEntity _entity;
         BlockEntity _blockEntity;
         BlockPos _bp;
         Player _player;
         BlockState _bs;
         if (var10000.getItem() == CrustyChunksModItems.MORTAR_SHELL.get() && 0.0D >= ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "cooldown") && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.MORTAR.get()) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.NEUTRAL, 20.0F, 1.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.NEUTRAL, 20.0F, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 100.0F, 1.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 100.0F, 1.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               projectileLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepX() * 1) + 0.5D, y + 2.0D, z + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 1) + 0.5D, 10, 0.0D, 0.0D, 0.0D, 0.01D);
            }

            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               projectileLevel.sendParticles(ParticleTypes.FLASH, x + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepX() * 1) + 0.5D, y + 2.0D, z + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 1) + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.1D);
            }

            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new MortarProjectileEntity((EntityType)CrustyChunksModEntities.MORTAR_PROJECTILE.get(), level);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 5.0F, 1);
               _entityToSpawn.setPos(x + 0.5D, y + 3.0D, z + 0.5D);
               _entityToSpawn.shoot(Xvector / 2.0D, Pitch, Zvector / 2.0D, 5.0F, 5.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.MORTAR_SHELL.get())).copy();
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMainHandItem();
               } else {
                  var10001 = ItemStack.EMPTY;
               }

               _setstack.setCount(var10001.getCount() - 1);
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("cooldown", 4.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == CrustyChunksModItems.SMOKE_MORTAR_SHELL.get() && 0.0D >= ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "cooldown") && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.MORTAR.get()) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.NEUTRAL, 20.0F, 1.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.NEUTRAL, 20.0F, 1.5F, false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 100.0F, 1.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion_distant")), SoundSource.NEUTRAL, 100.0F, 1.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               projectileLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepX() * 1) + 0.5D, y + 2.0D, z + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 1) + 0.5D, 10, 0.0D, 0.0D, 0.0D, 0.01D);
            }

            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               projectileLevel.sendParticles(ParticleTypes.FLASH, x + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepX() * 1) + 0.5D, y + 2.0D, z + (double)(((<undefinedtype>)(new Object() {
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
               })).getDirection(blockstate).getStepZ() * 1) + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.1D);
            }

            if (world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, float damage, int knockback) {
                     AbstractArrow entityToSpawn = new SmokeMortarProjectileEntity((EntityType)CrustyChunksModEntities.SMOKE_MORTAR_PROJECTILE.get(), level);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, 5.0F, 1);
               _entityToSpawn.setPos(x + 0.5D, y + 3.0D, z + 0.5D);
               _entityToSpawn.shoot(Xvector / 2.0D, Pitch, Zvector / 2.0D, 5.0F, 5.0F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMOKE_MORTAR_SHELL.get())).copy();
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMainHandItem();
               } else {
                  var10001 = ItemStack.EMPTY;
               }

               _setstack.setCount(var10001.getCount() - 1);
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("cooldown", 4.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }

      }
   }
}
