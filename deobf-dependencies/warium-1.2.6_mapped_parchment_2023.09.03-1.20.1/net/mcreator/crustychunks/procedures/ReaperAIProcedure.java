package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ReaperAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         boolean schedoodlemode = false;
         boolean Trigger = false;
         boolean detonate = false;
         double distancetotarget = 0.0D;
         double buddydistance = 0.0D;
         double distancefromhome = 0.0D;
         double leadvariable = 0.0D;
         double mx = 0.0D;
         double my = 0.0D;
         double mz = 0.0D;
         double speed = 0.0D;
         double Limiter = 0.0D;
         double rev = 0.0D;
         LivingEntity var10000;
         Mob _entity;
         if (entity instanceof Mob) {
            _entity = (Mob)entity;
            var10000 = _entity.getTarget();
         } else {
            var10000 = null;
         }

         Mob _mobEnt;
         Mob _mobEnt;
         if (var10000 != null) {
            if (entity instanceof Mob) {
               _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000.isAlive()) {
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               target = var10000;
            }
         }

         if (0.0D == entity.getPersistentData().getDouble("Direction")) {
            entity.getPersistentData().putDouble("Direction", 1.0D);
         }

         if (1 == Mth.nextInt(RandomSource.create(), 1, 400)) {
            entity.getPersistentData().putDouble("Direction", entity.getPersistentData().getDouble("Direction") * -1.0D);
         }

         if (0.0D == entity.getPersistentData().getDouble("X")) {
            entity.getPersistentData().putDouble("X", x);
         }

         if (0.0D == entity.getPersistentData().getDouble("Z")) {
            entity.getPersistentData().putDouble("Z", z);
         }

         distancefromhome = Math.sqrt(Math.pow(Math.abs(entity.getPersistentData().getDouble("X") - x), 2.0D) + Math.pow(Math.abs(entity.getPersistentData().getDouble("Z") - z), 2.0D));
         if (entity.getPersistentData().getDouble("T") > 0.0D) {
            entity.getPersistentData().putDouble("T", entity.getPersistentData().getDouble("T") - 1.0D);
         }

         if (1 == Mth.nextInt(RandomSource.create(), 1, 160) && (target == null || !((Entity)target).isAlive())) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(256.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var44 = _entfound.iterator();

            label191:
            while(true) {
               Entity entityiterator;
               do {
                  do {
                     do {
                        if (!var44.hasNext()) {
                           break label191;
                        }

                        entityiterator = (Entity)var44.next();
                     } while(!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robotarget"))) && (!(entityiterator instanceof Player) || !((<undefinedtype>)(new Object() {
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
                     })).checkGamemode(entityiterator)));
                  } while(!world.canSeeSkyFromBelowWater(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
               } while((target == null || !((Entity)target).isAlive()) && target != null);

               target = entityiterator;
            }
         }

         label167: {
            if (target != null) {
               if (entity instanceof Mob) {
                  _entity = (Mob)entity;
                  var10000 = _entity.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 != null && Math.sqrt(Math.pow(((Entity)target).getY() - y, 2.0D) + Math.pow(((Entity)target).getX() - x, 2.0D) + Math.pow(((Entity)target).getZ() - z, 2.0D)) - Math.sqrt(Math.pow(((Entity)target).getY() - (y + entity.getDeltaMovement().y()), 2.0D) + Math.pow(((Entity)target).getX() - (x + (entity.getLookAngle().x + entity.getDeltaMovement().x()) / 2.0D), 2.0D) + Math.pow(((Entity)target).getZ() - (z + (entity.getLookAngle().z + entity.getDeltaMovement().z()) / 2.0D), 2.0D)) > 1.15D) {
                  distancetotarget = Math.sqrt(Math.pow(Math.abs(((Entity)target).getX() - x), 2.0D) + Math.pow(Math.abs(((Entity)target).getZ() - z), 2.0D));
                  entity.getPersistentData().putDouble("TargetRange", distancetotarget);
                  if (entity instanceof Mob) {
                     _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 != null) {
                     Anchor var10001 = Anchor.EYES;
                     Vec3 var10002 = new Vec3;
                     LivingEntity var10004;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.getTarget();
                     } else {
                        var10004 = null;
                     }

                     double var37 = var10004.getX();
                     LivingEntity var10005;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.getTarget();
                     } else {
                        var10005 = null;
                     }

                     double var38 = var10005.getY() + 1.0D;
                     LivingEntity var10006;
                     if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.getTarget();
                     } else {
                        var10006 = null;
                     }

                     var10002.<init>(var37, var38, var10006.getZ());
                     entity.lookAt(var10001, var10002);
                  }

                  if (entity instanceof Mob) {
                     _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  label156: {
                     if (!var10000.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:bulletproof")))) {
                        if (entity instanceof Mob) {
                           _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (Math.abs(var10000.getY() - y) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(512.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getY() - y) + 0.5D) <= 0.0D) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
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
                                 break label156;
                              }
                           }
                        }
                     }

                     if (entity.getPersistentData().getDouble("Rocket") < 28.0D) {
                        CrustyChunksMod.queueServerWork(1, () -> {
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

                              double var11 = var10005.getY() + Math.pow(entity.getPersistentData().getDouble("TargetRange") / 35.0D, 2.0D);
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
                                 ReaperPeelerProcedure.execute(world, x, y, z, entity);
                              }
                           }

                        });
                        break label167;
                     }
                  }

                  CrustyChunksMod.queueServerWork(1, () -> {
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
                        LivingEntity var10006;
                        if (entity instanceof Mob) {
                           _mobEntx = (Mob)entity;
                           var10006 = _mobEntx.getTarget();
                        } else {
                           var10006 = null;
                        }

                        double var10005 = 2.0D + var10006.getY() + Math.pow(entity.getPersistentData().getDouble("TargetRange") / 75.0D, 2.0D);
                        if (entity instanceof Mob) {
                           _mobEntx = (Mob)entity;
                           var10006 = _mobEntx.getTarget();
                        } else {
                           var10006 = null;
                        }

                        var10002.<init>(var10, var10005, var10006.getZ());
                        entity.lookAt(var10001, var10002);
                        if (entity.getPersistentData().getDouble("T") <= 0.0D) {
                           ReaperCannonProcedure.execute(world, x, y, z, entity);
                        }
                     }

                  });
                  break label167;
               }
            }

            CrustyChunksMod.queueServerWork(1, () -> {
               entity.setYRot((float)((double)entity.getYRot() - entity.getPersistentData().getDouble("Direction")));
               entity.setXRot(entity.getXRot());
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

            });
         }

         if (entity.getPersistentData().getDouble("Cycle") > 0.0D) {
            entity.getPersistentData().putDouble("Cycle", entity.getPersistentData().getDouble("Cycle") - 1.0D);
         } else {
            entity.getPersistentData().putDouble("Cycle", 7.0D);
            Level _level;
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetidle")), SoundSource.HOSTILE, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetidle")), SoundSource.HOSTILE, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.HOSTILE, 30.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.25D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:jetfar")), SoundSource.HOSTILE, 30.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.25D), false);
               }
            }
         }

         if (entity.getY() < (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x), Mth.floor(z)) + 45)) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() + 0.04D, entity.getDeltaMovement().z()));
         } else if (entity.getY() > (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x), Mth.floor(z)) + 55)) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() - 0.005D, entity.getDeltaMovement().z()));
         }

         entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.995D + entity.getLookAngle().x / 5.0D + (entity.getPersistentData().getDouble("X") - x) / 2500.0D, entity.getDeltaMovement().y() * 0.995D + entity.getLookAngle().y / 25.0D, entity.getDeltaMovement().z() * 0.995D + entity.getLookAngle().z / 5.0D + (entity.getPersistentData().getDouble("Z") - z) / 2500.0D));
         world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x - entity.getLookAngle().x * 4.0D, y + 1.25D - entity.getLookAngle().y, z - entity.getLookAngle().z * 4.0D, entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z());
         float var39;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var39 = _livEnt.getHealth();
         } else {
            var39 = -1.0F;
         }

         if (var39 > 20.0F) {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.CAMP_SMOKE.get(), x - entity.getLookAngle().x * 7.0D, y + 1.25D, z - entity.getLookAngle().z * 7.0D, 0.0D, 0.0D, 0.0D);
         } else {
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x - entity.getLookAngle().x * 7.0D, y + 1.25D, z - entity.getLookAngle().z * 7.0D, 0.0D, 0.0D, 0.0D);
         }

         if (target != null && entity instanceof Mob) {
            _entity = (Mob)entity;
            if (target instanceof LivingEntity) {
               LivingEntity _ent = (LivingEntity)target;
               _entity.setTarget(_ent);
            }
         }

      }
   }
}
