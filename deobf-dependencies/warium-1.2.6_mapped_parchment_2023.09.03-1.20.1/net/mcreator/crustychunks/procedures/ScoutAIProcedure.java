package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
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

public class ScoutAIProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean schedoodlemode = false;
         double buddydistance = 0.0D;
         double distancetotarget = 0.0D;
         Entity target = null;
         Mob _entity;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            _entity = (Mob)entity;
            var10000 = _entity.getTarget();
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
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               target = var10000;
            }
         }

         if (1 == Mth.nextInt(RandomSource.create(), 1, 160) && (target != null && !((Entity)target).isAlive() || target == null)) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var22 = _entfound.iterator();

            label112:
            while(true) {
               Entity entityiterator;
               do {
                  do {
                     do {
                        if (!var22.hasNext()) {
                           break label112;
                        }

                        entityiterator = (Entity)var22.next();
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
               } while((target == null || ((Entity)target).isAlive()) && target != null);

               target = entityiterator;
            }
         }

         if (entity.getPersistentData().getDouble("T") > 0.0D) {
            entity.getPersistentData().putDouble("T", entity.getPersistentData().getDouble("T") - 1.0D);
         }

         Level _level;
         if (target != null) {
            distancetotarget = Math.sqrt(Math.pow(Math.abs(((Entity)target).getX() - x), 2.0D) + Math.pow(Math.abs(((Entity)target).getZ() - z), 2.0D));
            entity.lookAt(Anchor.EYES, new Vec3(((Entity)target).getX(), ((Entity)target).getY() + 1.0D, ((Entity)target).getZ()));
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() + entity.getLookAngle().x / 18.0D, entity.getDeltaMovement().y(), entity.getDeltaMovement().z() + entity.getLookAngle().z / 18.0D));
            if (Math.abs(((Entity)target).getY() - y) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(200.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getY() - y) + 0.5D) <= 0.0D && Math.abs(((Entity)target).getX() - x) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getX() - x) + 0.5D) <= 0.0D && Math.abs(((Entity)target).getZ() - z) - (Math.abs((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(10.0D)), Block.COLLIDER, Fluid.ANY, entity)).getBlockPos().getZ() - z) + 0.5D) <= 0.0D && entity.getPersistentData().getDouble("T") <= 0.0D) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:beep")), SoundSource.HOSTILE, 5.0F, 2.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:beep")), SoundSource.HOSTILE, 5.0F, 2.0F, false);
                  }
               }

               entity.getPersistentData().putDouble("T", 160.0D);
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

                           Entity patt6055$temp = var10000;
                           if (patt6055$temp instanceof LivingEntity) {
                              LivingEntity _ent = (LivingEntity)patt6055$temp;
                              _entity.setTarget(_ent);
                           }
                        }
                     }
                  }

               });
            }
         }

         if (entity.getPersistentData().getDouble("Cycle") > 0.0D) {
            entity.getPersistentData().putDouble("Cycle", entity.getPersistentData().getDouble("Cycle") - 1.0D);
         } else {
            entity.getPersistentData().putDouble("Cycle", 15.0D);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:drone")), SoundSource.HOSTILE, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:drone")), SoundSource.HOSTILE, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }
         }

         if (entity.getY() < (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x), Mth.floor(z)) + 15)) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() + 0.01D, entity.getDeltaMovement().z()));
         } else if (entity.getY() > (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x), Mth.floor(z)) + 20)) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() - 0.005D, entity.getDeltaMovement().z()));
         }

         entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.995D, entity.getDeltaMovement().y() * 0.995D, entity.getDeltaMovement().z() * 0.995D));
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
