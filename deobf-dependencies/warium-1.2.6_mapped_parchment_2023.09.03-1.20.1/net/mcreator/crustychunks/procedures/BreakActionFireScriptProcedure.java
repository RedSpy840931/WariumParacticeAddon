package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.entity.BirdshotParticleEntity;
import net.mcreator.crustychunks.entity.BreechingProjectileEntity;
import net.mcreator.crustychunks.entity.LargeStealthBulletEntity;
import net.mcreator.crustychunks.entity.ThermalProjectileEntity;
import net.mcreator.crustychunks.entity.TinyprojectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.item.BreakActionShotgunAnimatedItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BreakActionFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getOffhandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
            if (0.0D >= itemstack.getOrCreateTag().getDouble("C")) {
               if (1.0D <= itemstack.getOrCreateTag().getDouble("Ammo")) {
                  int index2;
                  Level projectileLevel;
                  Level projectileLevel;
                  Projectile _entityToSpawn;
                  Projectile _entityToSpawn;
                  if (itemstack.getOrCreateTag().getString("Type").equals("BU")) {
                     for(index2 = 0; index2 < 10; ++index2) {
                        projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new TinyprojectileEntity((EntityType)CrustyChunksModEntities.TINYPROJECTILE.get(), level);
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.05F, 0);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)Mth.nextDouble(RandomSource.create(), 5.9D, 6.1D), 6.0F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     }

                     projectileLevel = entity.level();
                     if (!projectileLevel.isClientSide()) {
                        _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                              AbstractArrow entityToSpawn = new BreechingProjectileEntity((EntityType)CrustyChunksModEntities.BREECHING_PROJECTILE.get(), level);
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              entityToSpawn.setCritArrow(true);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, entity, 0.0F, 1);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.0F, 0.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }
                  } else if (itemstack.getOrCreateTag().getString("Type").equals("BI")) {
                     for(index2 = 0; index2 < 30; ++index2) {
                        projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new BirdshotParticleEntity((EntityType)CrustyChunksModEntities.BIRDSHOT_PARTICLE.get(), level);
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.0F, 0);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)Mth.nextDouble(RandomSource.create(), 5.9D, 6.1D), 6.5F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     }
                  } else if (itemstack.getOrCreateTag().getString("Type").equals("AP")) {
                     projectileLevel = entity.level();
                     if (!projectileLevel.isClientSide()) {
                        _entityToSpawn = ((<undefinedtype>)(new Object() {
                           public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                              AbstractArrow entityToSpawn = new LargeStealthBulletEntity((EntityType)CrustyChunksModEntities.LARGE_STEALTH_BULLET.get(), level);
                              entityToSpawn.setOwner(shooter);
                              entityToSpawn.setBaseDamage((double)damage);
                              entityToSpawn.setKnockback(knockback);
                              entityToSpawn.setSilent(true);
                              entityToSpawn.setPierceLevel(piercing);
                              entityToSpawn.setCritArrow(true);
                              return entityToSpawn;
                           }
                        })).getArrow(projectileLevel, entity, 0.0F, 2, (byte)1);
                        _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                        _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 7.0F, 2.0F);
                        projectileLevel.addFreshEntity(_entityToSpawn);
                     }
                  } else if (itemstack.getOrCreateTag().getString("Type").equals("DB")) {
                     for(index2 = 0; index2 < 20; ++index2) {
                        projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new ThermalProjectileEntity((EntityType)CrustyChunksModEntities.THERMAL_PROJECTILE.get(), level);
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.0F, 0);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)Mth.nextDouble(RandomSource.create(), 5.9D, 6.1D), 6.5F);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     }

                     CrustyChunksMod.queueServerWork(1, () -> {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.twinkle")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
                           }
                        }

                     });
                  }

                  itemstack.getOrCreateTag().putDouble("Ammo", itemstack.getOrCreateTag().getDouble("Ammo") - 1.0D);
                  ShotgunFireSoundProcedure.execute(world, x, y, z);

                  for(index2 = 0; index2 < 5; ++index2) {
                     world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.GUN_SMOKE.get(), x + entity.getLookAngle().x * 0.8D, y + (double)entity.getEyeHeight() - 0.1D, z + entity.getLookAngle().z * 0.8D, entity.getLookAngle().x * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), entity.getLookAngle().y * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), entity.getLookAngle().z * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D));
                  }

                  entity.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -5.0D, 5.0D)));
                  entity.setXRot((float)((double)entity.getXRot() - Mth.nextDouble(RandomSource.create(), 6.0D, 7.0D)));
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (itemstack.getItem() instanceof BreakActionShotgunAnimatedItem) {
                     itemstack.getOrCreateTag().putString("geckoAnim", "fire");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SHOTGUN_CASING.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 2.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
                  }
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
