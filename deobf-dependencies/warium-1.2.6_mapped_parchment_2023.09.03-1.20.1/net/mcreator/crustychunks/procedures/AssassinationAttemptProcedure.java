package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.AssassinpodEntity;
import net.mcreator.crustychunks.entity.RiflerPodEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.registries.ForgeRegistries;

public class AssassinationAttemptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Riflers = 0.0D;
      double spawnx = 0.0D;
      double spawnz = 0.0D;
      double strikers = 0.0D;
      double attempts = 0.0D;
      Level _level;
      if (world.getLevelData().getGameRules().getBoolean(CrustyChunksModGameRules.APOCALYPSE_MODE)) {
         if (CrustyChunksModVariables.MapVariables.get(world).ApocalypseWorkers > 3.0D && 1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
            if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
               spawnx = (double)Mth.nextInt(RandomSource.create(), -100, -75);
            } else {
               spawnx = (double)Mth.nextInt(RandomSource.create(), 75, 100);
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
               spawnz = (double)Mth.nextInt(RandomSource.create(), -100, -75);
            } else {
               spawnz = (double)Mth.nextInt(RandomSource.create(), 75, 100);
            }

            SmallAttackProcedure.execute(world, x + spawnx, z + spawnz);
         } else {
            label111: {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (_level.isDay()) {
                     Riflers = Math.min(3.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers);
                     CrustyChunksModVariables.MapVariables.get(world).ApocalypseRiflers -= Riflers;
                     CrustyChunksModVariables.MapVariables.get(world).syncData(world);
                     strikers = Math.min(3.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers);
                     CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers -= strikers;
                     CrustyChunksModVariables.MapVariables.get(world).syncData(world);
                     break label111;
                  }
               }

               Riflers = 0.0D;
               strikers = Math.min(6.0D, CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers);
               CrustyChunksModVariables.MapVariables.get(world).ApocalypseStrikers -= strikers;
               CrustyChunksModVariables.MapVariables.get(world).syncData(world);
            }
         }
      } else {
         label93: {
            if (world instanceof Level) {
               _level = (Level)world;
               if (_level.isDay()) {
                  Riflers = 3.0D;
                  strikers = 3.0D;
                  break label93;
               }
            }

            Riflers = 0.0D;
            strikers = 6.0D;
         }
      }

      if (1 == Mth.nextInt(RandomSource.create(), 1, 3) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
         if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
            spawnx = (double)Mth.nextInt(RandomSource.create(), -100, -75);
         } else {
            spawnx = (double)Mth.nextInt(RandomSource.create(), 75, 100);
         }

         if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
            spawnz = (double)Mth.nextInt(RandomSource.create(), -100, -75);
         } else {
            spawnz = (double)Mth.nextInt(RandomSource.create(), 75, 100);
         }

         for(; world.getBlockState(BlockPos.containing(spawnx, (double)(world.getHeight(Types.MOTION_BLOCKING, Mth.floor(spawnx), Mth.floor(spawnz)) - 2), spawnz)).getBlock() instanceof LiquidBlock || 10.0D < attempts; ++attempts) {
            if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
               spawnx = (double)Mth.nextInt(RandomSource.create(), -100, -75);
            } else {
               spawnx = (double)Mth.nextInt(RandomSource.create(), 75, 100);
            }

            if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
               spawnz = (double)Mth.nextInt(RandomSource.create(), -100, -75);
            } else {
               spawnz = (double)Mth.nextInt(RandomSource.create(), 75, 100);
            }
         }

         CrustyChunksModVariables.MapVariables.get(world).motivation = 0.0D;
         CrustyChunksModVariables.MapVariables.get(world).syncData(world);
         SmallAttackProcedure.execute(world, x + spawnx, z + spawnz);
      } else {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y + 300.0D, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sonicboom")), SoundSource.NEUTRAL, 100.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
            } else {
               _level.playLocalSound(x, y + 300.0D, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:sonicboom")), SoundSource.NEUTRAL, 100.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
            }
         }

         int index2;
         for(index2 = 0; index2 < (int)Riflers; ++index2) {
            CrustyChunksMod.queueServerWork(20, () -> {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new RiflerPodEntity((EntityType)CrustyChunksModEntities.RIFLER_POD.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 5.0F, 1);
                  _entityToSpawn.setPos(x + (double)Mth.nextInt(RandomSource.create(), -30, 30), y + 350.0D, z + (double)Mth.nextInt(RandomSource.create(), -30, 30));
                  _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 1.0F, 25.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

            });
         }

         for(index2 = 0; index2 < (int)strikers; ++index2) {
            CrustyChunksMod.queueServerWork(20, () -> {
               if (world instanceof ServerLevel) {
                  ServerLevel projectileLevel = (ServerLevel)world;
                  Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                     public Projectile getArrow(Level level, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new AssassinpodEntity((EntityType)CrustyChunksModEntities.ASSASSINPOD.get(), level);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                     }
                  })).getArrow(projectileLevel, 5.0F, 1);
                  _entityToSpawn.setPos(x + (double)Mth.nextInt(RandomSource.create(), -30, 30), y + 350.0D, z + (double)Mth.nextInt(RandomSource.create(), -30, 30));
                  _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D), 1.0F, 25.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

            });
         }
      }

   }
}
