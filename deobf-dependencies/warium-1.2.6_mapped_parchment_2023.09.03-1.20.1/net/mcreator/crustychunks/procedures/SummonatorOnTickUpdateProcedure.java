package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonatorOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Modules = 0.0D;
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      boolean PlayerFound = false;
      if (Mth.nextInt(RandomSource.create(), 1, 10) == 10) {
         Rad1TickProcedure.execute(world, x, y, z);
      }

      Modules = 0.0D;
      Vec3 _center = new Vec3(x, y, z);
      List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(15.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.distanceToSqr(_center);
      })).toList();
      Iterator var16 = _entfound.iterator();

      Entity entityiterator;
      LivingEntity _entity;
      while(var16.hasNext()) {
         entityiterator = (Entity)var16.next();
         if (entityiterator instanceof LivingEntity) {
            _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 1, false, false));
            }
         }
      }

      ServerLevel _level;
      if (world.getBlockState(BlockPos.containing(x + 20.0D, y, z)).getBlock() == CrustyChunksModBlocks.SUMMONATOR_MODULE.get()) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.GLOW, x + 10.0D + 0.5D, y + 0.5D, z + 0.5D, 15, 5.0D, 0.0D, 0.0D, 0.01D);
         }

         ++Modules;
      }

      if (world.getBlockState(BlockPos.containing(x, y, z + 20.0D)).getBlock() == CrustyChunksModBlocks.SUMMONATOR_MODULE.get()) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.GLOW, x + 0.5D, y + 0.5D, z + 10.0D + 0.5D, 15, 0.0D, 0.0D, 5.0D, 0.01D);
         }

         ++Modules;
      }

      if (world.getBlockState(BlockPos.containing(x - 20.0D, y, z)).getBlock() == CrustyChunksModBlocks.SUMMONATOR_MODULE.get()) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.GLOW, x - 10.0D + 0.5D, y + 0.5D, z + 0.5D, 15, 5.0D, 0.0D, 0.0D, 0.01D);
         }

         ++Modules;
      }

      if (world.getBlockState(BlockPos.containing(x, y, z - 20.0D)).getBlock() == CrustyChunksModBlocks.SUMMONATOR_MODULE.get()) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.GLOW, x + 0.5D, y + 0.5D, z - 10.0D + 0.5D, 15, 0.0D, 0.0D, 5.0D, 0.01D);
         }

         ++Modules;
      }

      BlockEntity _blockEntity;
      Level _level;
      BlockPos _bp;
      BlockState _bs;
      Level _level;
      if (Modules > 0.0D) {
         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Timer") > 0.0D) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.NEUTRAL, 40.0F, (float)(((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Timer") / 100.0D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.NEUTRAL, 40.0F, (float)(((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Timer") / 100.0D), false);
               }
            }

            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Timer", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Timer") - 1.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 5.0F, (float)(0.2D + Modules / 3.0D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.conduit.activate")), SoundSource.NEUTRAL, 5.0F, (float)(0.2D + Modules / 3.0D), false);
            }
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.FIREWORK, x + 0.5D, y + 5.0D, z + 0.5D, (int)(5.0D * Modules), 0.0D, 10.0D, 0.0D, 0.01D);
         }

         if (null != (Entity)world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0D, 20.0D, 20.0D), (e) -> {
            return true;
         }).stream().sorted(((<undefinedtype>)(new Object() {
            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
               return Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.distanceToSqr(_x, _y, _z);
               });
            }
         })).compareDistOf(x, y, z)).findFirst().orElse((Object)null)) {
            Entity entityToSpawn;
            if (1 == Mth.nextInt(RandomSource.create(), 1, 150)) {
               spawnx = x + (double)Mth.nextInt(RandomSource.create(), -30, 30);
               spawnz = z + (double)Mth.nextInt(RandomSource.create(), -30, 30);
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)CrustyChunksModEntities.STRIKER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemmad")), SoundSource.NEUTRAL, 20.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemmad")), SoundSource.NEUTRAL, 20.0F, 0.5F, false);
                  }
               }
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 600)) {
               spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
               spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  entityToSpawn = ((EntityType)CrustyChunksModEntities.HUNTER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 45), spawnz), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemidle")), SoundSource.NEUTRAL, 20.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:golemidle")), SoundSource.NEUTRAL, 20.0F, 0.5F, false);
                  }
               }
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 600)) {
               _center = new Vec3(x, y, z);
               _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(256.0D), (e) -> {
                  return true;
               }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.distanceToSqr(_center);
               })).toList();
               var16 = _entfound.iterator();

               while(var16.hasNext()) {
                  entityiterator = (Entity)var16.next();
                  if (entityiterator instanceof Player && entityiterator instanceof LivingEntity) {
                     _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.IMPENDING_DOOM.get(), 10000, 0, false, false));
                     }
                  }
               }
            }
         }
      } else {
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Timer", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Timer") + 1.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 40.0F, (float)(((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Timer") / 100.0D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.NEUTRAL, 40.0F, (float)(((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "Timer") / 100.0D), false);
            }
         }

         if (((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Timer") > 200.0D) {
            PlayerFound = false;
            _center = new Vec3(x, y, z);
            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(256.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            var16 = _entfound.iterator();

            while(var16.hasNext()) {
               entityiterator = (Entity)var16.next();
               if (entityiterator instanceof Player && !PlayerFound) {
                  if (entityiterator instanceof LivingEntity) {
                     _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.IMPENDING_DOOM.get(), 40000, 1, false, false));
                     }
                  }

                  PlayerFound = true;
               }
            }

            world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
            IncindiaryExplosionProcedure.execute(world, x, y, z);

            for(int index0 = 0; index0 < 10; ++index0) {
               spawnx = x + (double)Mth.nextInt(RandomSource.create(), -100, 100);
               spawnz = z + (double)Mth.nextInt(RandomSource.create(), -100, 100);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)CrustyChunksModEntities.STRIKER.get()).spawn(_level, BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING_NO_LEAVES, (int)spawnx, (int)spawnz) + 2), spawnz), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setDeltaMovement(0.0D, 0.0D, 0.0D);
                  }
               }
            }

            --CrustyChunksModVariables.MapVariables.get(world).Production;
            CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         }
      }

   }
}
