package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.ImpactGrenadeProjectileEntity;
import net.mcreator.crustychunks.entity.SmokeImpactGrenadeEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.item.GrenadeLauncherItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GrenadeLauncherFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         if (entity.isSprinting()) {
            Movementinnacuracy = 9.0D;
         } else {
            Movementinnacuracy = 5.0D;
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getOffhandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
            if (itemstack.getOrCreateTag().getBoolean("Loaded")) {
               if (itemstack.getItem() instanceof GrenadeLauncherItem) {
                  itemstack.getOrCreateTag().putString("geckoAnim", "fire");
               }

               Level projectileLevel;
               Projectile _entityToSpawn;
               if (0.0D == itemstack.getOrCreateTag().getDouble("AmmoType")) {
                  projectileLevel = entity.level();
                  if (!projectileLevel.isClientSide()) {
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new ImpactGrenadeProjectileEntity((EntityType)CrustyChunksModEntities.IMPACT_GRENADE_PROJECTILE.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setPierceLevel(piercing);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, 3.0F, 1, (byte)5);
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.5F, (float)Movementinnacuracy);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               } else if (1.0D == itemstack.getOrCreateTag().getDouble("AmmoType")) {
                  projectileLevel = entity.level();
                  if (!projectileLevel.isClientSide()) {
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new SmokeImpactGrenadeEntity((EntityType)CrustyChunksModEntities.SMOKE_IMPACT_GRENADE.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setPierceLevel(piercing);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, 3.0F, 1, (byte)5);
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.5F, (float)Movementinnacuracy);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }

               CrustyChunksMod.queueServerWork(1, () -> {
                  Level _level;
                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.PLAYERS, 40.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.5D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:medium_small_explosion_distant")), SoundSource.PLAYERS, 40.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.5D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bloop")), SoundSource.PLAYERS, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 0.95D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bloop")), SoundSource.PLAYERS, 5.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 0.95D), false);
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.PLAYERS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.85D, 0.9D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:autocannonshot")), SoundSource.PLAYERS, 15.0F, (float)Mth.nextDouble(RandomSource.create(), 0.85D, 0.9D), false);
                     }
                  }

               });

               for(int index0 = 0; index0 < 25; ++index0) {
                  world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.GUN_SMOKE.get(), x + entity.getLookAngle().x * 1.0D, y + entity.getLookAngle().y + 1.5D, z + entity.getLookAngle().z * 1.0D, entity.getLookAngle().x * 0.3D + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), entity.getLookAngle().y * 0.3D + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D), entity.getLookAngle().z * 0.3D + Mth.nextDouble(RandomSource.create(), -0.1D, 0.1D));
               }

               entity.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -8.0D, 8.0D)));
               entity.setXRot((float)((double)entity.getXRot() - Mth.nextDouble(RandomSource.create(), 12.0D, 14.0D)));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               itemstack.getOrCreateTag().putBoolean("Loaded", false);
            } else if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§4Weapon requires 2 hands to fire."), true);
            }
         }

      }
   }
}
