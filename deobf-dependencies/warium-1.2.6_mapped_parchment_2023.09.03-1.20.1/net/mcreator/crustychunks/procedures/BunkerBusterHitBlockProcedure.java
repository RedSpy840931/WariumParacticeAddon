package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.entity.BunkerBusterProjectileEntity;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BunkerBusterHitBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;
         DamagesProcedure.execute(world, x, y, z);
         double var10000;
         if (immediatesourceentity instanceof Projectile) {
            Projectile _projEnt = (Projectile)immediatesourceentity;
            var10000 = _projEnt.getDeltaMovement().length();
         } else {
            var10000 = 0.0D;
         }

         Power = var10000;
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.sendParticles(ParticleTypes.FLASH, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.5D, 0.5D, 0.5D, 0.05D);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.HUGE_SPARKS.get(), x + 0.5D, y + 0.5D, z + 0.5D, 40, 0.6D, 0.6D, 0.6D, 1.2D);
         }

         if (!world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:concrete"))) && (!(world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) <= 10.0F) || !(world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) >= 0.0F))) {
            SuperLargeBombProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
         } else {
            if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:metal"))) && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 15.0F, 0.8F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 15.0F, 0.8F, false);
               }
            }

            if (!(15.0D > immediatesourceentity.getPersistentData().getDouble("Hits"))) {
               SuperLargeBombProjectileHitsBlockProcedure.execute(world, x, y, z, immediatesourceentity);
            } else {
               if (world instanceof ServerLevel) {
                  projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new BunkerBusterProjectileEntity((EntityType)CrustyChunksModEntities.BUNKER_BUSTER_PROJECTILE.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        entityToSpawn.setCritArrow(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, immediatesourceentity, 20.0F, 1, (byte)50);
                  _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                  _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 3.0F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               Vec3 _center = new Vec3(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
               List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5D), (e) -> {
                  return true;
               }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.distanceToSqr(_center);
               })).toList();
               Iterator var12 = _entfound.iterator();

               while(var12.hasNext()) {
                  Entity entityiterator = (Entity)var12.next();
                  if (entityiterator instanceof BunkerBusterProjectileEntity) {
                     entityiterator.getPersistentData().putDouble("Hits", immediatesourceentity.getPersistentData().getDouble("Hits") + 1.0D + (double)Math.round(world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) / 5.0F));
                  }
               }

               if (!immediatesourceentity.level().isClientSide()) {
                  immediatesourceentity.discard();
               }
            }

            world.destroyBlock(BlockPos.containing(x, y, z), false);

            for(int index0 = 0; index0 < 10; ++index0) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
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
                  _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), (float)(Power + 2.0D), 8.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }
         }

      }
   }
}
