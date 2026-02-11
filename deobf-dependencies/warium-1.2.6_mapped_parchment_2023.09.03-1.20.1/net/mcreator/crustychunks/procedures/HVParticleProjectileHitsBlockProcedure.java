package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
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

public class HVParticleProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         DamagesProcedure.execute(world, x, y, z);
         ServerLevel _level;
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:dirts")))) {
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.DUST.get(), x + 0.5D, y + 1.0D, z + 0.5D, 5, 0.0D, 2.0D, 0.0D, 1.0D);
            }

            world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(Blocks.DIRT.defaultBlockState()));
         }

         ServerLevel projectileLevel;
         Projectile _entityToSpawn;
         Projectile _projEnt;
         Level _level;
         double var10000;
         Projectile _projEnt;
         double var10001;
         double var10002;
         double var10003;
         double var10004;
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:shatterable")))) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 3.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
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
                     AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 0.1F, 1, (byte)50);
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
                     AbstractArrow entityToSpawn = new HVParticleProjectileEntity((EntityType)CrustyChunksModEntities.HV_PARTICLE_PROJECTILE.get(), level);
                     entityToSpawn.setOwner(shooter);
                     entityToSpawn.setBaseDamage((double)damage);
                     entityToSpawn.setKnockback(knockback);
                     entityToSpawn.setSilent(true);
                     entityToSpawn.setPierceLevel(piercing);
                     entityToSpawn.setCritArrow(true);
                     return entityToSpawn;
                  }
               })).getArrow(projectileLevel, immediatesourceentity, 0.1F, 1, (byte)50);
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

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:splinterable")))) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
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
            UnmodifiableIterator var21 = _bso.getValues().entrySet().iterator();

            while(var21.hasNext()) {
               Entry<Property<?>, Comparable<?>> entry = (Entry)var21.next();
               Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                  } catch (Exception var15) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
            world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.COBBLESTONE.defaultBlockState()));
            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.POOF, x + 0.5D, y + 0.5D, z + 0.5D, 3, 0.4D, 0.4D, 0.4D, 0.2D);
            }
         }

         CrackProcedureProcedure.execute(world, x, y, z);
         world.levelEvent(2001, BlockPos.containing(x, y + 1.0D, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
         SmallBulletHitProcedure.execute(world, x, y, z);
      }
   }
}
