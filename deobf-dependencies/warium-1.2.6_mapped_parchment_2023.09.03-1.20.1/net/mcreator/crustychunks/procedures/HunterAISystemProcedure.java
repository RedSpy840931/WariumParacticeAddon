package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.HunterEntity;
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
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HunterAISystemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target = null;
         boolean Trigger = false;
         boolean detonate = false;
         boolean schedoodlemode = false;
         double leadvariable = 0.0D;
         double distancetotarget = 0.0D;
         double speed = 0.0D;
         double targetrange = 0.0D;
         double buddydistance = 0.0D;
         LivingEntity var10000;
         Mob _entity;
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

         if (entity.getPersistentData().getDouble("T") > 0.0D) {
            entity.getPersistentData().putDouble("T", entity.getPersistentData().getDouble("T") - 1.0D);
         }

         Entity entityiterator;
         Vec3 _center;
         List _entfound;
         Iterator var32;
         if (1 == Mth.nextInt(RandomSource.create(), 1, 160)) {
            _center = new Vec3(x, y, z);
            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            var32 = _entfound.iterator();

            label149:
            while(true) {
               do {
                  do {
                     do {
                        if (!var32.hasNext()) {
                           break label149;
                        }

                        entityiterator = (Entity)var32.next();
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

         if (1 == Mth.nextInt(RandomSource.create(), 1, 5)) {
            _center = new Vec3(x, y, z);
            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(17.5D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            var32 = _entfound.iterator();

            label123:
            while(true) {
               while(true) {
                  if (!var32.hasNext()) {
                     break label123;
                  }

                  entityiterator = (Entity)var32.next();
                  if (entityiterator instanceof HunterEntity && entityiterator != entity) {
                     schedoodlemode = true;
                     buddydistance = Math.sqrt(Math.pow(Math.abs(entityiterator.getX() - x), 2.0D) + Math.pow(Math.abs(entityiterator.getZ() - z), 2.0D));
                     entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() + (entityiterator.getX() - x) / buddydistance / -18.0D, entity.getDeltaMovement().y(), entity.getDeltaMovement().z() + (entityiterator.getZ() - z) / buddydistance / -18.0D));
                  } else {
                     schedoodlemode = false;
                  }
               }
            }
         }

         LivingEntity _livEnt;
         if (target != null) {
            distancetotarget = Math.sqrt(Math.pow(Math.abs(((Entity)target).getX() - x), 2.0D) + Math.pow(Math.abs(((Entity)target).getZ() - z), 2.0D));
            entity.lookAt(Anchor.EYES, new Vec3(((Entity)target).getX(), ((Entity)target).getY() + 1.0D, ((Entity)target).getZ()));
            if (!schedoodlemode) {
               if (distancetotarget > 10.0D) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() + entity.getLookAngle().x / 18.0D, entity.getDeltaMovement().y(), entity.getDeltaMovement().z() + entity.getLookAngle().z / 18.0D));
                  entity.getPersistentData().putBoolean("Weapon", false);
               } else {
                  entity.getPersistentData().putBoolean("Weapon", true);
               }
            }

            if (entity.getPersistentData().getDouble("T") <= 0.0D) {
               float var26;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var26 = _livEnt.getHealth();
               } else {
                  var26 = -1.0F;
               }

               if (var26 > 0.0F) {
                  if (target instanceof LivingEntity) {
                     _livEnt = (LivingEntity)target;
                     var26 = _livEnt.getHealth();
                  } else {
                     var26 = -1.0F;
                  }

                  if (var26 > 0.0F) {
                     if (entity.getPersistentData().getBoolean("Weapon")) {
                        HunterGrenadeLauncherProcedure.execute(world, x, y, z, entity);
                     } else {
                        HunterCannonProcedure.execute(world, x, y, z, entity);
                     }
                  }
               }
            }

            if (((Entity)target).getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot")))) {
               target = null;
            }
         }

         if (entity.getPersistentData().getDouble("Cycle") > 0.0D) {
            entity.getPersistentData().putDouble("Cycle", entity.getPersistentData().getDouble("Cycle") - 1.0D);
         } else {
            entity.getPersistentData().putDouble("Cycle", 25.0D);
            Level _level;
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:hunternear")), SoundSource.HOSTILE, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:hunternear")), SoundSource.HOSTILE, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }

            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:hunterfar")), SoundSource.HOSTILE, 30.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:hunterfar")), SoundSource.HOSTILE, 30.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }
         }

         if (entity.getY() < (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x), Mth.floor(z)) + 35)) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() + 0.01D, entity.getDeltaMovement().z()));
         } else if (entity.getY() > (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(x), Mth.floor(z)) + 40)) {
            entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y() - 0.005D, entity.getDeltaMovement().z()));
         }

         entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x() * 0.995D, entity.getDeltaMovement().y() * 0.995D, entity.getDeltaMovement().z() * 0.995D));
         if (target != null && entity instanceof Mob) {
            _entity = (Mob)entity;
            if (target instanceof LivingEntity) {
               _livEnt = (LivingEntity)target;
               _entity.setTarget(_livEnt);
            }
         }

      }
   }
}
