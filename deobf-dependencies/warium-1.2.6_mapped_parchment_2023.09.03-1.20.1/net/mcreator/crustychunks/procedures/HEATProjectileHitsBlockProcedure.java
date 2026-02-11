package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.HVParticleProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class HEATProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:era")))) {
            ERAProcedureProcedure.execute(world, x, y, z);
         } else {
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
            if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:pennable"))) || world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) < 15.0F && world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) >= 0.0F && !world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dirts"))) && !world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:sands")))) {
               world.destroyBlock(BlockPos.containing(x, y, z), false);

               for(int index0 = 0; index0 < 35; ++index0) {
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
                     })).getArrow(projectileLevel, immediatesourceentity, 5.0F, 1);
                     _entityToSpawn.setPos(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ());
                     _entityToSpawn.shoot(immediatesourceentity.getDeltaMovement().x(), immediatesourceentity.getDeltaMovement().y(), immediatesourceentity.getDeltaMovement().z(), 2.5F, 37.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }
            }
         }

      }
   }
}
