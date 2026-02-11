package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.entity.DebrisEntity;
import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.entity.SmallClientEffectEntity;
import net.mcreator.crustychunks.entity.SplashEffectClientBypassEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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

public class MediumExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      sx = -7.0D;
      found = false;

      int index4;
      for(index4 = 0; index4 < 14; ++index4) {
         sy = -3.0D;

         for(int index1 = 0; index1 < 2; ++index1) {
            sz = -7.0D;

            for(int index2 = 0; index2 < 14; ++index2) {
               if (Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 7.0D && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.DIRT && world.getBlockState(BlockPos.containing(x + sx, y + sy + 1.0D, z + sz)).getBlock() != Blocks.AIR) {
                  found = true;
                  if (found) {
                     BlockPos _bp;
                     BlockState _bs;
                     BlockState _bso;
                     UnmodifiableIterator var20;
                     Entry entry;
                     Property _property;
                     if (Math.sqrt(Math.pow(sz, 2.0D) + Math.pow(sx, 2.0D)) < 3.0D) {
                        _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                        _bs = ((Block)CrustyChunksModBlocks.SCORCH_DIRT.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var24) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     } else {
                        _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                        _bs = ((Block)CrustyChunksModBlocks.HARDDIRT.get()).defaultBlockState();
                        _bso = world.getBlockState(_bp);
                        var20 = _bso.getValues().entrySet().iterator();

                        while(var20.hasNext()) {
                           entry = (Entry)var20.next();
                           _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                           if (_property != null && _bs.getValue(_property) != null) {
                              try {
                                 _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                              } catch (Exception var25) {
                              }
                           }
                        }

                        world.setBlock(_bp, _bs, 3);
                     }
                  }
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      world.destroyBlock(BlockPos.containing(x, y, z), false);
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
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:huge_explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.3D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:huge_explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.3D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.MASTER, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:explosion")), SoundSource.MASTER, 20.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
         }
      }

      ServerLevel _level;
      Projectile _entityToSpawn;
      if (world.getFluidState(BlockPos.containing(x, y + 1.0D, z)).createLegacyBlock().getBlock() instanceof LiquidBlock) {
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new SplashEffectClientBypassEntity((EntityType)CrustyChunksModEntities.SPLASH_EFFECT_CLIENT_BYPASS.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(_level, 0.0F, 0);
            _entityToSpawn.setPos(x, y + 1.5D, z);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.0F, 120.0F);
            _level.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x, y, z, 4.0F, ExplosionInteraction.TNT);
            }
         }
      } else if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _entityToSpawn = ((<undefinedtype>)(new Object() {
            public Projectile getArrow(Level level, float damage, int knockback) {
               AbstractArrow entityToSpawn = new SmallClientEffectEntity((EntityType)CrustyChunksModEntities.SMALL_CLIENT_EFFECT.get(), level);
               entityToSpawn.setBaseDamage((double)damage);
               entityToSpawn.setKnockback(knockback);
               entityToSpawn.setSilent(true);
               return entityToSpawn;
            }
         })).getArrow(_level, 0.0F, 0);
         _entityToSpawn.setPos(x, y + 1.5D, z);
         _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.0F, 120.0F);
         _level.addFreshEntity(_entityToSpawn);
      }

      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.FLASH, x, y, z, 3, 0.2D, 0.2D, 0.2D, 0.1D);
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x, y, z, 4.0F, ExplosionInteraction.TNT);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.explode((Entity)null, x, y, z, 8.0F, ExplosionInteraction.NONE);
         }
      }

      ServerLevel projectileLevel;
      Projectile _entityToSpawn;
      for(index4 = 0; index4 < 125; ++index4) {
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
            })).getArrow(projectileLevel, 11.0F, 3, (byte)2);
            _entityToSpawn.setPos(x, y + 0.5D, z);
            _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 0.05D, Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), 90.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }

      for(index4 = 0; index4 < 15; ++index4) {
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
            })).getArrow(projectileLevel, 11.0F, 3, (byte)2);
            _entityToSpawn.setPos(x, y + 0.5D, z);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), 45.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }

   }
}
