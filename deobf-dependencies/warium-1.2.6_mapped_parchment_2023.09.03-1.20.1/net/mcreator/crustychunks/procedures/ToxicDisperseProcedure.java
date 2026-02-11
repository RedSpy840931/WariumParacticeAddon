package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.ToxicCloudDetectorEntity;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class ToxicDisperseProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y - 1.0D, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x + 1.0D, y, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x - 1.0D, y, z)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y, z + 1.0D)).canOcclude() || !world.getBlockState(BlockPos.containing(x, y, z - 1.0D)).canOcclude()) {
         world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
         ServerLevel projectileLevel;
         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            projectileLevel.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.GAS_CLOUD.get(), x + 0.5D, y + 0.5D, z + 0.5D, 7, 0.0D, 0.0D, 0.0D, 0.2D);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.8D));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 1.5D, 1.8D), false);
            }
         }

         if (world instanceof ServerLevel) {
            projectileLevel = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new ToxicCloudDetectorEntity((EntityType)CrustyChunksModEntities.TOXIC_CLOUD_DETECTOR.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(projectileLevel, 0.0F, 0);
            _entityToSpawn.setPos(x + 0.5D, y + 0.5D, z + 0.5D);
            _entityToSpawn.shoot(0.0D, 1.0D, 0.0D, 0.1F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }
      }

   }
}
