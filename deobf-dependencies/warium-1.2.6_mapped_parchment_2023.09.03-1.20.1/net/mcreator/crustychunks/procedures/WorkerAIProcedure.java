package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class WorkerAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("T") > 0.0D) {
            entity.getPersistentData().putDouble("T", entity.getPersistentData().getDouble("T") - 1.0D);
         }

         if (1 == Mth.nextInt(RandomSource.create(), 1, 400)) {
            entity.getPersistentData().putBoolean("SuppressiveFire", !entity.getPersistentData().getBoolean("SuppressiveFire"));
         }

         if (1 == Mth.nextInt(RandomSource.create(), 1, 40) && world.getLevelData().getGameRules().getBoolean(CrustyChunksModGameRules.APOCALYPSE_MODE) && entity.getDeltaMovement().x() != 0.0D && entity.getDeltaMovement().z() != 0.0D) {
            CrustyChunksMod.queueServerWork(1, () -> {
               WorkerLandmineDeployProcedure.execute(world, x, y, z);
            });
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 != null) {
            Mob _mobEnt;
            if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
               AlivecheckProcedure.execute(entity);
               Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               double var17 = var10004.getX();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               double var18 = var10005.getY() + 1.0D;
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.getTarget();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var17, var18, var10006.getZ());
               entity.lookAt(var10001, var10002);
            }

            if (entity.getPersistentData().getDouble("T") <= 0.0D) {
               float var16;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var16 = _livEnt.getHealth();
               } else {
                  var16 = -1.0F;
               }

               if (var16 > 0.0F) {
                  label136: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     label114: {
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
                                 break label114;
                              }
                           }
                        }

                        if (!entity.getPersistentData().getBoolean("SuppressiveFire")) {
                           break label136;
                        }
                     }

                     CrustyChunksMod.queueServerWork(10, () -> {
                        if (entity.getPersistentData().getDouble("T") <= 0.0D) {
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
                           }

                           WorkerRifleProcedure.execute(world, x, y, z, entity);
                        }

                     });
                  }
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
               } catch (Exception var13) {
                  var13.printStackTrace();
               }
            }
         }

         if (entity.getPersistentData().getDouble("Cycle") > 0.0D) {
            entity.getPersistentData().putDouble("Cycle", entity.getPersistentData().getDouble("Cycle") - 1.0D);
         } else if (entity.getDeltaMovement().x() != 0.0D && entity.getDeltaMovement().z() != 0.0D) {
            entity.getPersistentData().putDouble("Cycle", 7.0D);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:strikerstep")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 0.8D), false);
               }
            }
         }

      }
   }
}
