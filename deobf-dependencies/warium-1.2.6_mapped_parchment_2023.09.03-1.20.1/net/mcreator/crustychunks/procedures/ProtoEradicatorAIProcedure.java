package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.FlameThrowerEmberEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ProtoEradicatorAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         double rev = 0.0D;
         double LeadRange = 0.0D;
         double targetrange = 0.0D;
         RandomVoicelinesProcedure.execute(world, x, y, z, entity);
         Level _level;
         if (entity.isAlive()) {
            if (entity.getPersistentData().getDouble("T") > 0.0D) {
               entity.getPersistentData().putDouble("T", entity.getPersistentData().getDouble("T") - 1.0D);
            }

            if (entity.getPersistentData().getDouble("T2") > 0.0D) {
               entity.getPersistentData().putDouble("T2", entity.getPersistentData().getDouble("T2") - 1.0D);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            float var10001;
            float var36;
            label319: {
               if (var10000 != null) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000.isAlive()) {
                     Vec3 var10002;
                     LivingEntity var10004;
                     LivingEntity var10005;
                     LivingEntity var10006;
                     Mob _mobEnt;
                     Anchor var38;
                     double var40;
                     double var41;
                     if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
                        var38 = Anchor.EYES;
                        var10002 = new Vec3;
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10004 = _mobEnt.getTarget();
                        } else {
                           var10004 = null;
                        }

                        var40 = var10004.getX();
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10005 = _mobEnt.getTarget();
                        } else {
                           var10005 = null;
                        }

                        var41 = var10005.getY() + 1.0D;
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10006 = _mobEnt.getTarget();
                        } else {
                           var10006 = null;
                        }

                        var10002.<init>(var40, var41, var10006.getZ());
                        entity.lookAt(var38, var10002);
                     }

                     if (entity.getPersistentData().getDouble("T") <= 0.0D) {
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        Mob _mobEnt;
                        Mob _mobEnt;
                        Mob _mobEnt;
                        if (var10000.getY() > y + 30.0D) {
                           LivingEntity var39;
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var39 = _mobEnt.getTarget();
                           } else {
                              var39 = null;
                           }

                           double var42 = Math.pow(Math.abs(y - var39.getY()), 2.0D);
                           LivingEntity var37;
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var37 = _mobEnt.getTarget();
                           } else {
                              var37 = null;
                           }

                           var42 += Math.pow(Math.abs(z - var37.getZ()), 2.0D);
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var37 = _mobEnt.getTarget();
                           } else {
                              var37 = null;
                           }

                           targetrange = Math.sqrt(var42 + Math.pow(Math.abs(x - var37.getX()), 2.0D));
                           LeadRange = targetrange + Math.pow(targetrange, 2.0D) / 225.0D;
                           var38 = Anchor.EYES;
                           var10002 = new Vec3;
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10004 = _mobEnt.getTarget();
                           } else {
                              var10004 = null;
                           }

                           var40 = var10004.getX();
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10005 = _mobEnt.getTarget();
                           } else {
                              var10005 = null;
                           }

                           var40 += var10005.getDeltaMovement().x() * 1.25D * LeadRange * 0.09D;
                           var41 = y + 25.0D;
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10006 = _mobEnt.getTarget();
                           } else {
                              var10006 = null;
                           }

                           double var43 = var10006.getY() + 3.0D;
                           LivingEntity var10007;
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10007 = _mobEnt.getTarget();
                           } else {
                              var10007 = null;
                           }

                           var41 = Math.max(var41, var43 + var10007.getDeltaMovement().y() * 1.25D * LeadRange * 0.09D);
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10006 = _mobEnt.getTarget();
                           } else {
                              var10006 = null;
                           }

                           var43 = var10006.getZ();
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10007 = _mobEnt.getTarget();
                           } else {
                              var10007 = null;
                           }

                           var10002.<init>(var40, var41, var43 + var10007.getDeltaMovement().z() * 1.25D * LeadRange * 0.09D);
                           entity.lookAt(var38, var10002);
                           CrustyChunksMod.queueServerWork(1, () -> {
                              EradicatorFlakProcedure.execute(world, x, y, z, entity);
                           });
                        } else {
                           label336: {
                              if (entity instanceof Mob) {
                                 _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (!var10000.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:bulletproof")))) {
                                 label330: {
                                    if (entity instanceof Mob) {
                                       _mobEnt = (Mob)entity;
                                       var10000 = _mobEnt.getTarget();
                                    } else {
                                       var10000 = null;
                                    }

                                    label293: {
                                       if (Math.abs(var10000.getY() - y) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getY() - y) + 0.5D) <= 0.0D) {
                                          if (entity instanceof Mob) {
                                             _mobEnt = (Mob)entity;
                                             var10000 = _mobEnt.getTarget();
                                          } else {
                                             var10000 = null;
                                          }

                                          if (Math.abs(var10000.getX() - x) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getX() - x) + 0.5D) <= 0.0D) {
                                             if (entity instanceof Mob) {
                                                Mob _mobEnt = (Mob)entity;
                                                var10000 = _mobEnt.getTarget();
                                             } else {
                                                var10000 = null;
                                             }

                                             if (Math.abs(var10000.getZ() - z) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getZ() - z) + 0.5D) <= 0.0D) {
                                                break label293;
                                             }
                                          }
                                       }

                                       if (world.getBlockState(new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(7.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getX(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(7.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(7.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getZ())).getBlock() == Blocks.AIR) {
                                          break label330;
                                       }
                                    }

                                    CrustyChunksMod.queueServerWork(20, () -> {
                                       LivingEntity var10000;
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var10000 = _mobEnt.getTarget();
                                       } else {
                                          var10000 = null;
                                       }

                                       if (var10000 != null) {
                                          Anchor var10001 = Anchor.EYES;
                                          Vec3 var10002 = new Vec3;
                                          Mob _mobEntx;
                                          LivingEntity var10004;
                                          if (entity instanceof Mob) {
                                             _mobEntx = (Mob)entity;
                                             var10004 = _mobEntx.getTarget();
                                          } else {
                                             var10004 = null;
                                          }

                                          double var10 = var10004.getX();
                                          LivingEntity var10005;
                                          if (entity instanceof Mob) {
                                             _mobEntx = (Mob)entity;
                                             var10005 = _mobEntx.getTarget();
                                          } else {
                                             var10005 = null;
                                          }

                                          double var11 = var10005.getY() + 1.0D;
                                          LivingEntity var10006;
                                          if (entity instanceof Mob) {
                                             _mobEntx = (Mob)entity;
                                             var10006 = _mobEntx.getTarget();
                                          } else {
                                             var10006 = null;
                                          }

                                          var10002.<init>(var10, var11, var10006.getZ());
                                          entity.lookAt(var10001, var10002);
                                          if (entity.getPersistentData().getDouble("T") <= 0.0D) {
                                             DecimatorCoaxSprayProcedure.execute(world, x, y, z, entity);
                                          }
                                       }

                                    });
                                    break label336;
                                 }
                              }

                              CrustyChunksMod.queueServerWork(20, () -> {
                                 LivingEntity var10000;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (var10000 != null) {
                                    Anchor var10001 = Anchor.EYES;
                                    Vec3 var10002 = new Vec3;
                                    Mob _mobEntx;
                                    LivingEntity var10004;
                                    if (entity instanceof Mob) {
                                       _mobEntx = (Mob)entity;
                                       var10004 = _mobEntx.getTarget();
                                    } else {
                                       var10004 = null;
                                    }

                                    double var10 = var10004.getX();
                                    LivingEntity var10005;
                                    if (entity instanceof Mob) {
                                       _mobEntx = (Mob)entity;
                                       var10005 = _mobEntx.getTarget();
                                    } else {
                                       var10005 = null;
                                    }

                                    double var11 = var10005.getY() + 3.0D;
                                    LivingEntity var10006;
                                    if (entity instanceof Mob) {
                                       _mobEntx = (Mob)entity;
                                       var10006 = _mobEntx.getTarget();
                                    } else {
                                       var10006 = null;
                                    }

                                    var10002.<init>(var10, var11, var10006.getZ());
                                    entity.lookAt(var10001, var10002);
                                    if (entity.getPersistentData().getDouble("T") <= 0.0D) {
                                       EradicatorCannonProcedure.execute(world, x, y, z, entity);
                                    }
                                 }

                              });
                           }
                        }

                        if (1 == Mth.nextInt(RandomSource.create(), 1, 200)) {
                           CrustyChunksMod.queueServerWork(1, () -> {
                              DroneLaunchProcedure.execute(world, x, y, z, entity);
                           });
                        }
                     }

                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (var10000.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot"))) && entity instanceof Mob) {
                        try {
                           ((Mob)entity).setTarget((LivingEntity)null);
                        } catch (Exception var24) {
                           var24.printStackTrace();
                        }
                     }
                     break label319;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var36 = _livEnt.getHealth();
               } else {
                  var36 = -1.0F;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMaxHealth();
               } else {
                  var10001 = -1.0F;
               }

               if (var36 < var10001 && 1 == Mth.nextInt(RandomSource.create(), 1, 15)) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sparks")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sparks")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getHealth();
                     } else {
                        var10001 = -1.0F;
                     }

                     _entity.setHealth(var10001 + 1.0F);
                  }
               }
            }

            if (entity.getDeltaMovement().x() != 0.0D && entity.getDeltaMovement().z() != 0.0D) {
               for(int index0 = 0; index0 < 2; ++index0) {
                  world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x + Mth.nextDouble(RandomSource.create(), -1.5D, 1.5D), y, z + Mth.nextDouble(RandomSource.create(), -1.5D, 1.5D), 0.0D, 0.0D, 0.0D);
               }
            }

            if (entity.getPersistentData().getDouble("Cycle") > 0.0D) {
               entity.getPersistentData().putDouble("Cycle", entity.getPersistentData().getDouble("Cycle") - 1.0D);
            } else {
               if (entity.getDeltaMovement().x() != 0.0D && entity.getDeltaMovement().z() != 0.0D) {
                  rev = 1.4D;
                  if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
                     CrustyChunksMod.queueServerWork(1, () -> {
                        EradicatorMeleeProcedure.execute(world, x, y, z);
                     });
                  }
               } else {
                  rev = 0.7D;
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, (float)(3.0D + rev), (float)(Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D) + rev));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:turbine")), SoundSource.NEUTRAL, (float)(3.0D + rev), (float)(Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D) + rev), false);
                  }
               }

               entity.getPersistentData().putDouble("Cycle", 7.0D);
            }

            LivingEntity _livEnt;
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var36 = _livEnt.getHealth();
            } else {
               var36 = -1.0F;
            }

            LivingEntity _livEnt;
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMaxHealth();
            } else {
               var10001 = -1.0F;
            }

            if (var36 < var10001 / 2.0F && 10 == Mth.nextInt(RandomSource.create(), 1, 15)) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 4.0D, z, 0.0D, 1.0D, 0.0D);
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var36 = _livEnt.getHealth();
            } else {
               var36 = -1.0F;
            }

            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMaxHealth();
            } else {
               var10001 = -1.0F;
            }

            if (var36 < var10001 / 4.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x, y + 2.0D, z, 2, 1.0D, 1.0D, 1.0D, 1.0D);
               }

               if (10 == Mth.nextInt(RandomSource.create(), 1, 80) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 4.0F, 0.7F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 4.0F, 0.7F, false);
                  }
               }
            }
         } else {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.AERIAL_SPARKS.get(), x, y + 3.0D, z, Mth.nextDouble(RandomSource.create(), -0.7D, 0.7D), 4.0D, Mth.nextDouble(RandomSource.create(), -0.7D, 0.7D));
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.AERIAL_SPARKS.get(), x, y + 3.0D, z, Mth.nextDouble(RandomSource.create(), -0.7D, 0.7D), 4.0D, Mth.nextDouble(RandomSource.create(), -0.7D, 0.7D));
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.RISING_FLAME.get(), x, y + 3.0D, z, Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 4.0D, Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D));
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.ROCKET_FLAME.get(), x, y + 3.0D, z, Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 2.0D, Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D));
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 2.0D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 1.0D, 2.0D), false);
               }
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 6)) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 2.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 2.0D), false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.NEUTRAL, 30.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 2.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallfarblast")), SoundSource.NEUTRAL, 30.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 2.0D), false);
                  }
               }
            } else if (1 == Mth.nextInt(RandomSource.create(), 1, 4)) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.2D), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new FlameThrowerEmberEntity((EntityType)CrustyChunksModEntities.FLAME_THROWER_EMBER.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 0.0F, 1);
                  _entityToSpawn.setPos(x, y + 3.0D, z);
                  _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, (float)Mth.nextDouble(RandomSource.create(), 0.4D, 1.0D), 45.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }
         }

      }
   }
}
