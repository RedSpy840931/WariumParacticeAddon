package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.ClusterRocketEntity;
import net.mcreator.crustychunks.entity.DecimatorEntity;
import net.mcreator.crustychunks.entity.IRMissileEntity;
import net.mcreator.crustychunks.entity.IncindiaryRocketProjectileEntity;
import net.mcreator.crustychunks.entity.LargeRocketEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DecimatorAISystemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean Trigger = false;
         boolean hottarget = false;
         Entity target = null;
         double rev = 0.0D;
         double LeadRange = 0.0D;
         double leady = 0.0D;
         double leadx = 0.0D;
         double leadz = 0.0D;
         double targetrange = 0.0D;
         RandomVoicelinesProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("T") > 0.0D) {
            entity.getPersistentData().putDouble("T", entity.getPersistentData().getDouble("T") - 1.0D);
         }

         if (entity.getPersistentData().getDouble("T2") > 0.0D) {
            entity.getPersistentData().putDouble("T2", entity.getPersistentData().getDouble("T2") - 1.0D);
         }

         Mob _mobEnt;
         if (1 == Mth.nextInt(RandomSource.create(), 1, 20)) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var25 = _entfound.iterator();

            label371:
            while(true) {
               Entity entityiterator;
               do {
                  do {
                     if (!var25.hasNext()) {
                        break label371;
                     }

                     entityiterator = (Entity)var25.next();
                  } while(!(entityiterator.getY() > y + 25.0D));
               } while((!((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                     } else if (_ent.level().isClientSide() && _ent instanceof Player) {
                        Player _player = (Player)_ent;
                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entityiterator) || !(entityiterator instanceof Player)) && !(entityiterator instanceof LargeRocketEntity) && !(entityiterator instanceof IncindiaryRocketProjectileEntity) && !(entityiterator instanceof ClusterRocketEntity) && !(entityiterator instanceof IRMissileEntity));

               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)entityiterator;
                     _mobEnt.setTarget(_ent);
                  }
               }
            }
         }

         LivingEntity var10000;
         Mob _mobEnt;
         if (entity instanceof Mob) {
            _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity entityToSpawn;
         Mob _mobEnt;
         if (var10000 != null) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            target = var10000;
            hottarget = false;
            Vec3 _center = new Vec3(target.getX(), target.getY(), target.getZ());
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(25.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var41 = _entfound.iterator();

            label346:
            while(true) {
               while(true) {
                  if (!var41.hasNext()) {
                     break label346;
                  }

                  entityToSpawn = (Entity)var41.next();
                  if (entityToSpawn.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:warm"))) && !entityToSpawn.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot"))) && entityToSpawn.getY() > y + 25.0D) {
                     leadx = entityToSpawn.getPersistentData().getDouble("Mx");
                     leady = entityToSpawn.getPersistentData().getDouble("My");
                     leadz = entityToSpawn.getPersistentData().getDouble("Mz");
                     hottarget = true;
                  } else {
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     leadx = var10000.getDeltaMovement().x();
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     leady = var10000.getDeltaMovement().y();
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     leadz = var10000.getDeltaMovement().z();
                  }
               }
            }
         }

         if (entity instanceof Mob) {
            _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         LivingEntity _livEnt;
         float var50;
         float var53;
         if (var10000 != null) {
            if (target.isAlive()) {
               if (hottarget && target.getY() > y + 25.0D) {
                  targetrange = Math.sqrt(Math.pow(Math.abs(y - target.getY()), 2.0D) + Math.pow(Math.abs(z - target.getZ()), 2.0D) + Math.pow(Math.abs(x - target.getX()), 2.0D));
                  entity.getPersistentData().putDouble("TargetX", target.getX() + leadx * 1.5D * targetrange * 0.09D);
                  entity.getPersistentData().putDouble("TargetY", Math.max(y + 30.0D, target.getY() + 3.0D + leady * 1.5D * targetrange * 0.09D + Math.pow(targetrange / 50.0D, 2.0D)));
                  entity.getPersistentData().putDouble("TargetZ", target.getZ() + leadz * 1.5D * targetrange * 0.09D);
                  entity.getPersistentData().putDouble("Range", targetrange);
                  if (50.0D < targetrange) {
                     CrustyChunksMod.queueServerWork(1, () -> {
                        if (entity.getPersistentData().getDouble("T") < 1.0D) {
                           entity.lookAt(Anchor.EYES, new Vec3(entity.getPersistentData().getDouble("TargetX"), entity.getPersistentData().getDouble("TargetY"), entity.getPersistentData().getDouble("TargetZ")));
                           DecimatorFlakProcedure.execute(world, x, y, z, entity);
                        }

                     });
                  }
               } else {
                  Mob _mobEnt;
                  if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
                     Anchor var10001 = Anchor.EYES;
                     Vec3 var10002 = new Vec3;
                     LivingEntity var10004;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.getTarget();
                     } else {
                        var10004 = null;
                     }

                     double var51 = var10004.getX();
                     LivingEntity var10005;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.getTarget();
                     } else {
                        var10005 = null;
                     }

                     double var52 = var10005.getY() + 1.0D;
                     LivingEntity var10006;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.getTarget();
                     } else {
                        var10006 = null;
                     }

                     var10002.<init>(var51, var52, var10006.getZ());
                     entity.lookAt(var10001, var10002);
                  }

                  if (entity.getPersistentData().getDouble("T") <= 0.0D) {
                     label392: {
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (!var10000.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:bulletproof")))) {
                           if (entity instanceof Mob) {
                              _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

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
                                    break label392;
                                 }
                              }
                           }
                        }

                        if (entity.getPersistentData().getBoolean("Cannon")) {
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
                                    DecimatorCannonFireProcedure.execute(world, x, y, z, entity);
                                 }
                              }

                           });
                        } else {
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
                                    DecimatorPeelerProcedure.execute(world, x, y, z, entity);
                                 }
                              }

                           });
                        }
                     }
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
                     DecimatorMeleeProcedure.execute(world, x, y, z, entity);
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 200) == 1 && entity.getPersistentData().getDouble("I") <= 6.0D) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        entityToSpawn = ((EntityType)CrustyChunksModEntities.STRIKER.get()).spawn(_level, BlockPos.containing(x, y + 1.0D, z), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                           entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
                        }
                     }

                     entity.getPersistentData().putDouble("I", entity.getPersistentData().getDouble("I") + 1.0D);
                     if (entity instanceof DecimatorEntity) {
                        ((DecimatorEntity)entity).setAnimation("SmokeDeploy");
                     }

                     entity.getPersistentData().putDouble("T", entity.getPersistentData().getDouble("T") + 80.0D);
                  }

                  if (Mth.nextInt(RandomSource.create(), 1, 200) == 1) {
                     if (entity.getPersistentData().getBoolean("Cannon")) {
                        entity.getPersistentData().putBoolean("Cannon", false);
                     } else {
                        entity.getPersistentData().putBoolean("Cannon", true);
                     }
                  }

                  if (4.0D <= entity.getPersistentData().getDouble("Rocket")) {
                     entity.getPersistentData().putBoolean("Cannon", true);
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
                     } catch (Exception var30) {
                        var30.printStackTrace();
                     }
                  }
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var53 = _livEnt.getHealth();
            } else {
               var53 = -1.0F;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var50 = _livEnt.getMaxHealth();
            } else {
               var50 = -1.0F;
            }

            if (var53 < var50 && 1 == Mth.nextInt(RandomSource.create(), 1, 15)) {
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
                     var50 = _livEnt.getHealth();
                  } else {
                     var50 = -1.0F;
                  }

                  _entity.setHealth(var50 + 1.0F);
               }
            }
         }

         Level _level;
         if (entity.getPersistentData().getDouble("Cycle") > 0.0D) {
            entity.getPersistentData().putDouble("Cycle", entity.getPersistentData().getDouble("Cycle") - 1.0D);
         } else {
            if (entity.getDeltaMovement().x() != 0.0D && entity.getDeltaMovement().z() != 0.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mechstep")), SoundSource.NEUTRAL, 2.5F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.1D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:mechstep")), SoundSource.NEUTRAL, 2.5F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.1D), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x, y + 0.5D, z, 7, 3.0D, 0.0D, 3.0D, 0.1D);
               }

               rev = 2.0D;
            } else {
               rev = 0.0D;
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, (float)(2.0D + rev), (float)(Mth.nextDouble(RandomSource.create(), 0.5D, 0.6D) + rev));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, (float)(2.0D + rev), (float)(Mth.nextDouble(RandomSource.create(), 0.5D, 0.6D) + rev), false);
               }
            }

            entity.getPersistentData().putDouble("Cycle", 10.0D);
         }

         LivingEntity _entity;
         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            var53 = _entity.getHealth();
         } else {
            var53 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var50 = _livEnt.getMaxHealth();
         } else {
            var50 = -1.0F;
         }

         if (var53 < var50 / 2.0F && 10 == Mth.nextInt(RandomSource.create(), 1, 15)) {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x, y + 4.0D, z, 0.0D, 1.0D, 0.0D);
         }

         if (entity instanceof LivingEntity) {
            _entity = (LivingEntity)entity;
            var53 = _entity.getHealth();
         } else {
            var53 = -1.0F;
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var50 = _livEnt.getMaxHealth();
         } else {
            var50 = -1.0F;
         }

         if (var53 < var50 / 4.0F) {
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

         if (Mth.nextInt(RandomSource.create(), 1, 200) == 1 && 0.0D < entity.getPersistentData().getDouble("Rocket")) {
            entity.getPersistentData().putDouble("Rocket", entity.getPersistentData().getDouble("Rocket") - 1.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.close")), SoundSource.NEUTRAL, 2.5F, (float)Mth.nextDouble(RandomSource.create(), 0.2D, 0.4D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.iron_trapdoor.close")), SoundSource.NEUTRAL, 2.5F, (float)Mth.nextDouble(RandomSource.create(), 0.2D, 0.4D), false);
               }
            }
         }

         if (entity.isInWater()) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.6D, 0.8D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.6D, 0.8D), false);
               }
            }

            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SPLASH_PUFF.get(), x, y, z, 0.0D, -1.0D, 0.0D);
            entity.push(entity.getLookAngle().x / 20.0D, 0.0D, entity.getLookAngle().z / 20.0D);
         } else if (!entity.isNoGravity() && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y - 200.0D, z)) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y - 10.0D, z)) && !entity.onGround()) {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.getDeltaMovement().x() * 2.0D + 1.0D, entity.getDeltaMovement().y() * 3.0D, entity.getDeltaMovement().z() * 2.0D + 1.0D);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.getDeltaMovement().x() * 2.0D - 1.0D, entity.getDeltaMovement().y() * 3.0D, entity.getDeltaMovement().z() * 2.0D + 1.0D);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.getDeltaMovement().x() * 2.0D + 1.0D, entity.getDeltaMovement().y() * 3.0D, entity.getDeltaMovement().z() * 2.0D - 1.0D);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, entity.getDeltaMovement().x() * 2.0D - 1.0D, entity.getDeltaMovement().y() * 3.0D, entity.getDeltaMovement().z() * 2.0D - 1.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 7.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:rocketflight")), SoundSource.NEUTRAL, 7.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.NEUTRAL, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.NEUTRAL, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
               }
            }

            if (entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 0));
               }
            }
         }

      }
   }
}
