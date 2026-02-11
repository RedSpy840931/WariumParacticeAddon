package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.ParticleProjectileEntity;
import net.mcreator.crustychunks.entity.SmallClientEffectEntity;
import net.mcreator.crustychunks.entity.SplashEffectClientBypassEntity;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class TinyExplosionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      sx = -4.0D;
      found = false;

      int index3;
      for(index3 = 0; index3 < 8; ++index3) {
         sy = -3.0D;

         for(int index1 = 0; index1 < 4; ++index1) {
            sz = -4.0D;

            for(int index2 = 0; index2 < 8; ++index2) {
               if (Math.sqrt(Math.pow(sx, 2.0D) + Math.pow(sz, 2.0D)) < 3.0D && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.GRASS_BLOCK) {
                  BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
                  BlockState _bs = Blocks.DIRT.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bp);
                  UnmodifiableIterator var20 = _bso.getValues().entrySet().iterator();

                  while(var20.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry)var20.next();
                     Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var24) {
                        }
                     }
                  }

                  world.setBlock(_bp, _bs, 3);
               }

               ++sz;
            }

            ++sy;
         }

         ++sx;
      }

      ServerLevel _level;
      Level _level;
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
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.0F, 180.0F);
            _level.addFreshEntity(_entityToSpawn);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x + 0.0D, y + 0.0D, z + 0.0D, 2.0F, ExplosionInteraction.TNT);
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
         _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.0F, 180.0F);
         _level.addFreshEntity(_entityToSpawn);
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.MASTER, 60.0F, (float)Mth.nextDouble(RandomSource.create(), 0.8D, 0.9D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.2D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:smallexplosion")), SoundSource.MASTER, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 1.1D, 1.2D), false);
         }
      }

      if (world instanceof Level) {
         _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 200.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.4D));
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:farblast")), SoundSource.MASTER, 200.0F, (float)Mth.nextDouble(RandomSource.create(), 1.3D, 1.4D), false);
         }
      }

      for(index3 = 0; index3 < 100; ++index3) {
         if (world instanceof ServerLevel) {
            ServerLevel projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
                  AbstractArrow entityToSpawn = new ParticleProjectileEntity((EntityType)CrustyChunksModEntities.PARTICLE_PROJECTILE.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  entityToSpawn.setPierceLevel(piercing);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 3, (byte)2);
            _entityToSpawn.setPos(x, y + 0.5D, z);
            _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 0.2D, Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), (float)Mth.nextDouble(RandomSource.create(), 0.8D, 1.2D), 45.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }

      CrustyChunksMod.queueServerWork(2, () -> {
         Level _level;
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x, y, z, 2.0F, ExplosionInteraction.TNT);
            }
         }

         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x + 0.0D, y + 0.0D, z + 0.0D, 4.0F, ExplosionInteraction.NONE);
            }
         }

      });
      if (world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0.5D, 0.5D, 0.5D, 0.6D);
      }

   }
}
