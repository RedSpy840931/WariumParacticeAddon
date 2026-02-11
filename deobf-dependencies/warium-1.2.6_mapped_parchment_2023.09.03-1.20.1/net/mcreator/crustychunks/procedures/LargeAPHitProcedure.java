package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.entity.HugeFragmentEntity;
import net.mcreator.crustychunks.entity.LargeAPFireEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class LargeAPHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.BATTLE_CANNON_BREECH.get() && ((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
            SmallExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.destroyBlock(BlockPos.containing(x, y, z), false);
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.ARTILLERYBREECH.get() && ((<undefinedtype>)(new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getBoolean(tag) : false;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Loaded")) {
            MediumExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
            world.destroyBlock(BlockPos.containing(x, y, z), false);
         }

         DamagesProcedure.execute(world, x, y, z);
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            _projEnt.getDeltaMovement().length();
         } else {
            double var10000 = 0.0D;
         }

         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.FLASH, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.5D, 0.5D, 0.5D, 0.05D);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x + 0.5D, y + 0.5D, z + 0.5D, 40, 0.6D, 0.6D, 0.6D, 1.2D);
         }

         HugeFragmentHitProcedure.execute(world, x, y, z, immediatesourceentity);
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:pennable"))) || world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) <= 50.0F && world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) >= 0.0F) {
            Level _level;
            if ((world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:metal"))) || world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:breakable_metal")))) && world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 10.0F, 0.8F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 10.0F, 0.8F, false);
               }
            }

            ServerLevel projectileLevel;
            Projectile _entityToSpawn;
            int index1;
            if (10.0D > immediatesourceentity.getPersistentData().getDouble("Hits")) {
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new LargeAPFireEntity((EntityType)CrustyChunksModEntities.LARGE_AP_FIRE.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        entityToSpawn.setCritArrow(true);
                        return entityToSpawn;
                     }
                  })).getArrow(_level, immediatesourceentity, 25.0F, 1, (byte)50);
                  _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                  _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 5.0F, 4.0F);
                  _level.addFreshEntity(_entityToSpawn);
               }

               Vec3 _center = new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
               List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5D), (e) -> {
                  return true;
               }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.distanceToSqr(_center);
               })).toList();
               Iterator var19 = _entfound.iterator();

               while(var19.hasNext()) {
                  Entity entityiterator = (Entity)var19.next();
                  if (entityiterator instanceof LargeAPFireEntity) {
                     entityiterator.getPersistentData().putDouble("Hits", immediatesourceentity.getPersistentData().getDouble("Hits") + (double)Math.round(1.0F + world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) / 4.0F));
                  }
               }

               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.0D, 0.0D, 0.0D, 1.0D);
               }

               for(index1 = 0; index1 < (int)world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)); ++index1) {
                  if (world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setCritArrow(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, immediatesourceentity, 0.5F, 1);
                     _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                     _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 2.5F, 12.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }

               for(index1 = 0; index1 < (int)world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)); ++index1) {
                  if (world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new HugeFragmentEntity((EntityType)CrustyChunksModEntities.HUGE_FRAGMENT.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setCritArrow(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, immediatesourceentity, 3.0F, 1);
                     _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                     _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 3.0F, 8.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }
            } else {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 5.0F, 1.3F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.NEUTRAL, 5.0F, 1.3F, false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 40.0F, 1.3F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.NEUTRAL, 40.0F, 1.3F, false);
                  }
               }

               for(index1 = 0; index1 < 5; ++index1) {
                  if (world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setCritArrow(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, immediatesourceentity, 0.5F, 1);
                     _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                     _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 2.5F, 12.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }

               for(index1 = 0; index1 < 5; ++index1) {
                  if (world instanceof ServerLevel) {
                     projectileLevel = (ServerLevel)world;
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                           AbstractArrow entityToSpawn = new HugeFragmentEntity((EntityType)CrustyChunksModEntities.HUGE_FRAGMENT.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setCritArrow(true);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, immediatesourceentity, 3.0F, 1);
                     _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                     _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 3.0F, 8.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }
            }

            world.destroyBlock(BlockPos.containing(x, y, z), false);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.FLASH, x + 0.5D, y + 0.5D, z + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.0D);
         }

      }
   }
}
