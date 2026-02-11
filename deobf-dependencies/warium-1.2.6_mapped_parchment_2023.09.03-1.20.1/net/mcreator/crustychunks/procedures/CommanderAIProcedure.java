package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class CommanderAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distancetotarget = 0.0D;
         Entity Robotarget = null;
         Entity target = null;
         RandomVoicelinesProcedure.execute(world, x, y, z, entity);
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

         if (var10000 != null) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000.isAlive()) {
               Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               Mob _mobEnt;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               double var21 = var10004.getX();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               double var23 = var10005.getY() + 1.0D;
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.getTarget();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var21, var23, var10006.getZ());
               entity.lookAt(var10001, var10002);
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (Math.abs(var10000.getY() - y) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(200.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getY() - y) + 0.5D) <= 0.0D) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (Math.abs(var10000.getX() - x) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getX() - x) + 0.5D) <= 0.0D) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (Math.abs(var10000.getZ() - z) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getZ() - z) + 0.5D) <= 0.0D && entity.getPersistentData().getDouble("T2") <= 0.0D) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderalert")), SoundSource.HOSTILE, 5.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderalert")), SoundSource.HOSTILE, 5.0F, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().putDouble("T2", 80.0D);
                        CrustyChunksMod.queueServerWork(80, () -> {
                           Vec3 _center = new Vec3(x, y, z);
                           List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(256.0D), (e) -> {
                              return true;
                           }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                              return _entcnd.distanceToSqr(_center);
                           })).toList();
                           Iterator var10 = _entfound.iterator();

                           while(var10.hasNext()) {
                              Entity entityiterator = (Entity)var10.next();
                              if (entity.isAlive() && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot")))) {
                                 LivingEntity var10000;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (var10000 != null && entityiterator instanceof Mob) {
                                    Mob _entity = (Mob)entityiterator;
                                    if (entity instanceof Mob) {
                                       Mob _mobEntx = (Mob)entity;
                                       var10000 = _mobEntx.getTarget();
                                    } else {
                                       var10000 = null;
                                    }

                                    Entity patt4499$temp = var10000;
                                    if (patt4499$temp instanceof LivingEntity) {
                                       LivingEntity _ent = (LivingEntity)patt4499$temp;
                                       _entity.setTarget(_ent);
                                    }
                                 }
                              }
                           }

                        });
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("T") <= 0.0D) {
                  float var22;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var22 = _livEnt.getHealth();
                  } else {
                     var22 = -1.0F;
                  }

                  if (var22 > 0.0F) {
                     CrustyChunksMod.queueServerWork(1, () -> {
                        EliteRifleProcedure.execute(world, x, y, z, entity);
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
                  } catch (Exception var18) {
                     var18.printStackTrace();
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("Cycle") > 0.0D) {
            entity.getPersistentData().putDouble("Cycle", entity.getPersistentData().getDouble("Cycle") - 1.0D);
         } else if (entity.getDeltaMovement().x() != 0.0D && entity.getDeltaMovement().z() != 0.0D) {
            entity.getPersistentData().putDouble("Cycle", 5.0D);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.5D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.5D), false);
               }
            }
         }

         if (entity.getPersistentData().getDouble("Cycle2") > 0.0D) {
            entity.getPersistentData().putDouble("Cycle2", entity.getPersistentData().getDouble("Cycle2") - 1.0D);
         } else {
            entity.getPersistentData().putDouble("Cycle2", 440.0D);
            CrustyChunksMod.queueServerWork(1, () -> {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderwaffing")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderwaffing")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                  }
               }

            });
         }

      }
   }
}
