package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.entity.HugeBulletFireEntity;
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
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class HugeBulletHitProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double Power = 0.0D;
         DamagesProcedure.execute(world, x, y, z);
         int index3;
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dirts")))) {
            for(index3 = 0; index3 < 10; ++index3) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), immediatesourceentity.getX(), immediatesourceentity.getY() + 1.0D, immediatesourceentity.getZ(), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D));
            }
         }

         ServerLevel projectileLevel;
         Projectile _entityToSpawn;
         Projectile _projEnt;
         double var10000;
         double var10001;
         Level _level;
         double var10002;
         Projectile _projEnt;
         double var10003;
         double var10004;
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:chippable")))) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10000 = _projEnt.getDeltaMovement().length();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 2.0D && world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 2.0F, 1, (byte)50);
               _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
               var10001 = immediatesourceentity.getDeltaMovement().x();
               var10002 = immediatesourceentity.getDeltaMovement().y();
               var10003 = immediatesourceentity.getDeltaMovement().z();
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10004 = _projEnt.getDeltaMovement().length();
               } else {
                  var10004 = 0.0D;
               }

               _entityToSpawn.shoot(var10001, var10002, var10003, (float)(var10004 - 0.1D), 0.8F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:breakable_metal")))) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:shatterable")))) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10000 = _projEnt.getDeltaMovement().length();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 2.0D && world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 2.0F, 1, (byte)50);
               _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
               var10001 = immediatesourceentity.getDeltaMovement().x();
               var10002 = immediatesourceentity.getDeltaMovement().y();
               var10003 = immediatesourceentity.getDeltaMovement().z();
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10004 = _projEnt.getDeltaMovement().length();
               } else {
                  var10004 = 0.0D;
               }

               _entityToSpawn.shoot(var10001, var10002, var10003, (float)(var10004 - 0.1D), 0.8F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:splinterable")))) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (immediatesourceentity instanceof Projectile) {
               _projEnt = (Projectile)immediatesourceentity;
               var10000 = _projEnt.getDeltaMovement().length();
            } else {
               var10000 = 0.0D;
            }

            if (var10000 > 2.0D && world instanceof ServerLevel) {
               projectileLevel = (ServerLevel)world;
               _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HugeBulletFireEntity((EntityType)CrustyChunksModEntities.HUGE_BULLET_FIRE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 2.0F, 1, (byte)50);
               _entityToSpawn.setPos(immediatesourceentity.getX() - immediatesourceentity.getLookAngle().x * 1.0D, immediatesourceentity.getY() - immediatesourceentity.getLookAngle().y * 1.0D, immediatesourceentity.getZ() + immediatesourceentity.getLookAngle().z * 1.0D);
               var10001 = immediatesourceentity.getDeltaMovement().x();
               var10002 = immediatesourceentity.getDeltaMovement().y();
               var10003 = immediatesourceentity.getDeltaMovement().z();
               if (immediatesourceentity instanceof Projectile) {
                  _projEnt = (Projectile)immediatesourceentity;
                  var10004 = _projEnt.getDeltaMovement().length();
               } else {
                  var10004 = 0.0D;
               }

               _entityToSpawn.shoot(var10001, var10002, var10003, (float)(var10004 - 0.1D), 0.8F);
               projectileLevel.addFreshEntity(_entityToSpawn);
            }
         }

         ServerLevel _level;
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:resistant")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 0.5F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 0.5F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)), false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.POOF, x + 0.5D, y + 0.5D, z + 0.5D, 7, 0.7D, 0.7D, 0.7D, 0.2D);
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:crushable")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.NEUTRAL, 2.0F, (float)(1.0D + Mth.nextDouble(RandomSource.create(), -0.2D, 0.4D)), false);
               }
            }

            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockState _bs = Blocks.GRAVEL.defaultBlockState();
            BlockState _bso = world.getBlockState(_bp);
            UnmodifiableIterator var24 = _bso.getValues().entrySet().iterator();

            while(var24.hasNext()) {
               Entry<Property<?>, Comparable<?>> entry = (Entry)var24.next();
               Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                  } catch (Exception var17) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);

            for(index3 = 0; index3 < 10; ++index3) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), immediatesourceentity.getX(), immediatesourceentity.getY() + 1.0D, immediatesourceentity.getZ(), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D));
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.GRASS_BLOCK) {
            world.setBlock(BlockPos.containing(x, y, z), Blocks.DIRT.defaultBlockState(), 3);
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
            for(index3 = 0; index3 < 10; ++index3) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SAND.get(), immediatesourceentity.getX(), immediatesourceentity.getY() + 1.0D, immediatesourceentity.getZ(), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D));
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dusts")))) {
            for(index3 = 0; index3 < 10; ++index3) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.WHITE_DUST.get(), immediatesourceentity.getX(), immediatesourceentity.getY() + 1.0D, immediatesourceentity.getZ(), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D), Mth.nextDouble(RandomSource.create(), -0.2D, 0.2D));
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:metals")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.5F, false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SPARKS.get(), x + 0.5D, y + 1.0D, z + 0.5D, 35, 0.3D, 0.3D, 3.0D, 1.0D);
            }
         }

         world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 6.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.0D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.blast")), SoundSource.NEUTRAL, 6.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.0D), false);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:small_expllosion_distant")), SoundSource.NEUTRAL, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:small_expllosion_distant")), SoundSource.NEUTRAL, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) < 5.0F && world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) >= 0.0F && !world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dirts"))) && !world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:sands"))) && !world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:concrete")))) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
         }

         HeavyCrackProcedureProcedure.execute(world, x, y, z);
         CrustyChunksMod.queueServerWork(1, () -> {
            if (world instanceof ServerLevel) {
               ServerLevel projectileLevelx = (ServerLevel)world;
               Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                  public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                     AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevelx, immediatesourceentity, 3.0F, 1, (byte)50);
               _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
               _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 5.0F, 0.0F);
               projectileLevelx.addFreshEntity(_entityToSpawn);
            }

            for(int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 4, 6); ++index4) {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawnx = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        entityToSpawn.setCritArrow(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, immediatesourceentity, 3.0F, 1, (byte)50);
                  _entityToSpawnx.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                  _entityToSpawnx.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 5.0F, 15.0F);
                  projectileLevel.addFreshEntity(_entityToSpawnx);
               }
            }

            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }

         });
      }
   }
}
