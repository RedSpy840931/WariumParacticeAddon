package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.APMediumBulletEntity;
import net.mcreator.crustychunks.entity.BulletfireProjectileEntity;
import net.mcreator.crustychunks.entity.StealthMediumBulletEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.item.BurstRifleItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GenericRifleFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         double recoil = 0.0D;
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }

         if (entity.isSprinting()) {
            Movementinnacuracy = 6.0D;
         } else {
            Movementinnacuracy = 2.0D;
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (!var10000.getOrCreateTag().getBoolean("action")) {
            ItemStack var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            if (1.0D <= var10001.getOrCreateTag().getDouble("Ammo")) {
               if (entity instanceof Player) {
                  Player _plrCldCheck7 = (Player)entity;
                  ItemCooldowns var24 = _plrCldCheck7.getCooldowns();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (var24.isOnCooldown(var10001.getItem())) {
                     return;
                  }
               }

               LivingEntity _livEnt;
               LivingEntity _livEnt;
               if (entity.isShiftKeyDown()) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof BurstRifleItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "sightfire");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof BurstRifleItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "fire");
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               Level projectileLevel;
               Projectile _entityToSpawn;
               if (var10000.getOrCreateTag().getString("Type").equals("AP")) {
                  projectileLevel = entity.level();
                  if (!projectileLevel.isClientSide()) {
                     _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new APMediumBulletEntity((EntityType)CrustyChunksModEntities.AP_MEDIUM_BULLET.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setPierceLevel(piercing);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)5);
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.5F, (float)Movementinnacuracy);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getOrCreateTag().getString("Type").equals("MB")) {
                     projectileLevel = entity.level();
                     if (!projectileLevel.isClientSide()) {
                        _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                              AbstractArrow entityToSpawn = new BulletfireProjectileEntity((EntityType)CrustyChunksModEntities.BULLETFIRE_PROJECTILE.get(), level);
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              entityToSpawn.setPierceLevel(piercing);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)2);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.5F, (float)Movementinnacuracy);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getOrCreateTag().getString("Type").equals("ST")) {
                        projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                 AbstractArrow entityToSpawn = new StealthMediumBulletEntity((EntityType)CrustyChunksModEntities.STEALTH_MEDIUM_BULLET.get(), level);
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 entityToSpawn.setPierceLevel(piercing);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)2);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 6.5F, (float)Movementinnacuracy);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               CompoundTag var28 = var10000.getOrCreateTag();
               ItemStack var10002;
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMainHandItem();
               } else {
                  var10002 = ItemStack.EMPTY;
               }

               var28.putDouble("Ammo", var10002.getOrCreateTag().getDouble("Ammo") - 1.0D);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.MEDIUM_CASING.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }

               CasingDropProcedure.execute(world, x, y, z);
               MediumFireSoundProcedure.execute(world, x, y, z);

               for(int index0 = 0; index0 < 3; ++index0) {
                  world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.GUN_SMOKE.get(), x + entity.getLookAngle().x * 0.8D, y + (double)entity.getEyeHeight() - 0.1D, z + entity.getLookAngle().z * 0.8D, entity.getLookAngle().x * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), entity.getLookAngle().y * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), entity.getLookAngle().z * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D));
               }

               entity.getPersistentData().putDouble("GunCooldown", 6.0D);
            } else {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
                  }
               }

               entity.getPersistentData().putDouble("GunCooldown", 6.0D);
            }
         }

      }
   }
}
