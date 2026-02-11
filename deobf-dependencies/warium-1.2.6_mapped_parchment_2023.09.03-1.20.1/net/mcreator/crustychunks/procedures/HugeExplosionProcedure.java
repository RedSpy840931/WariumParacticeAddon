package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.entity.DebrisEntity;
import net.mcreator.crustychunks.entity.GiantShockExplosionBypassEntity;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.entity.SplashEffectClientBypassEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class HugeExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double xRadius = 0.0D;
      double loop = 0.0D;
      double zRadius = 0.0D;
      double particleAmount = 0.0D;
      sx = -17.0D;
      found = false;

      int index4;
      for(index4 = 0; index4 < 34; ++index4) {
         sy = -4.0D;

         for(int index1 = 0; index1 < 3; ++index1) {
            sz = -17.0D;

            for(int index2 = 0; index2 < 34; ++index2) {
               if (Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 15.0D && world.getBlockState(BlockPos.containing(x + sx, y + sy + 1.0D, z + sz)).getBlock() != Blocks.AIR && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.DIRT) {
                  BlockPos _bp;
                  BlockState _bs;
                  BlockState _bso;
                  UnmodifiableIterator var28;
                  Entry entry;
                  Property _property;
                  if (Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 5.0D) {
                     _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                     _bs = ((Block)CrustyChunksModBlocks.SCORCH_DIRT.get()).defaultBlockState();
                     _bso = world.getBlockState(_bp);
                     var28 = _bso.getValues().entrySet().iterator();

                     while(var28.hasNext()) {
                        entry = (Entry)var28.next();
                        _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                           try {
                              _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                           } catch (Exception var32) {
                           }
                        }
                     }

                     world.setBlock(_bp, _bs, 3);
                  } else {
                     _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                     _bs = ((Block)CrustyChunksModBlocks.HARDDIRT.get()).defaultBlockState();
                     _bso = world.getBlockState(_bp);
                     var28 = _bso.getValues().entrySet().iterator();

                     while(var28.hasNext()) {
                        entry = (Entry)var28.next();
                        _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                        if (_property != null && _bs.getValue(_property) != null) {
                           try {
                              _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                           } catch (Exception var33) {
                           }
                        }
                     }

                     world.setBlock(_bp, _bs, 3);
                  }
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      Level _level;
      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 120.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.2D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 120.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.2D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:huge_explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.0D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:huge_explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.0D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.MASTER, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.MASTER, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
         }
      }

      ServerLevel projectileLevel;
      Projectile _entityToSpawn;
      if (world.getFluidState(BlockPos.containing(x, y + 1.0D, z)).createLegacyBlock().getBlock() instanceof LiquidBlock) {
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new SplashEffectClientBypassEntity((EntityType)CrustyChunksModEntities.SPLASH_EFFECT_CLIENT_BYPASS.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setPierceLevel(piercing);
                  entityToSpawn.setCritArrow(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 16.0F, 4, (byte)2);
            _entityToSpawn.setPos(x + 0.5D, y + 1.5D, z + 0.5D);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.0F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x + 0.5D, y + 1.0D, z + 0.5D, 10.0F, ExplosionInteraction.TNT);
            }
         }
      } else {
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.LARGE_SMOKE.get(), x, y + 0.5D, z, 5, 4.0D, 4.0D, 4.0D, 1.5D);
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.FIREBALL.get(), x, y + 1.5D, z, 5, 2.0D, 1.5D, 2.0D, 1.0D);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x + 0.5D, y + 0.5D, z + 0.5D, 12.0F, ExplosionInteraction.TNT);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x + 0.5D, y + 0.5D, z + 0.5D, 20.0F, ExplosionInteraction.NONE);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x + 0.5D, y + 0.5D, z + 0.5D, 6.0F, ExplosionInteraction.TNT);
         }
      }

      ServerLevel projectileLevel;
      Projectile _entityToSpawn;
      for(index4 = 0; index4 < 150; ++index4) {
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setPierceLevel(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 16.0F, 4, (byte)2);
            _entityToSpawn.setPos(x + 0.5D, y + 0.9D, z + 0.5D);
            _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 0.1D, Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), (float)Mth.nextDouble(RandomSource.create(), 1.0D, 1.2D), 90.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }

      for(index4 = 0; index4 < 20; ++index4) {
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new DebrisEntity((EntityType)CrustyChunksModEntities.DEBRIS.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setPierceLevel(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 16.0F, 4, (byte)2);
            _entityToSpawn.setPos(x + 0.5D, y + 0.9D, z + 0.5D);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.5D), 45.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }

      if (world instanceof ServerLevel) {
         projectileLevel = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
               AbstractArrow entityToSpawn = new GiantShockExplosionBypassEntity((EntityType)CrustyChunksModEntities.GIANT_SHOCK_EXPLOSION_BYPASS.get(), level);
               entityToSpawn.setBaseDamage((double)damage);
               entityToSpawn.setKnockback(knockback);
               entityToSpawn.setSilent(true);
               entityToSpawn.setPierceLevel(piercing);
               entityToSpawn.setCritArrow(true);
               return entityToSpawn;
            }
         })).getArrow(projectileLevel, 16.0F, 4, (byte)2);
         _entityToSpawn.setPos(x + 0.5D, y + 1.5D, z + 0.5D);
         _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.0F, 0.0F);
         projectileLevel.addFreshEntity(_entityToSpawn);
      }

   }
}
