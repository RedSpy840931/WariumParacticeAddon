package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.LargeAPBulletEntity;
import net.mcreator.crustychunks.entity.LargeBulletFireProjectileEntity;
import net.mcreator.crustychunks.entity.LargeStealthBulletEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.mcreator.crustychunks.item.BattleRifleItem;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
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

public class BattleRifleFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         double recoil = 0.0D;
         if (entity.isSprinting()) {
            Movementinnacuracy = 5.0D;
         } else {
            Movementinnacuracy = 2.0D;
         }

         if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
            Movementinnacuracy = 0.2D;
            recoil = Mth.nextDouble(RandomSource.create(), 2.0D, 3.0D);
         } else {
            recoil = Mth.nextDouble(RandomSource.create(), 3.0D, 4.0D);
         }

         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMainHandItem();
         } else {
            var10001 = ItemStack.EMPTY;
         }

         if (0.0D != var10001.getOrCreateTag().getDouble("Firemode") || ((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).clickrelease) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal("§4Weapon requires 2 hands to fire."), true);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (!var10000.getOrCreateTag().getBoolean("action")) {
                  LivingEntity _livEnt;
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putBoolean("action", true);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMainHandItem();
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (!(1.0D <= var10001.getOrCreateTag().getDouble("Ammo"))) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     if (var10001.getOrCreateTag().getBoolean("Loaded")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMainHandItem();
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (0.0D >= var10001.getOrCreateTag().getDouble("Cooldown")) {
                           LivingEntity _livEnt;
                           LivingEntity _entity;
                           if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 var10000 = _livEnt.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              if (var10000.getItem() instanceof BattleRifleItem) {
                                 if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity;
                                    var10000 = _entity.getMainHandItem();
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

                              if (var10000.getItem() instanceof BattleRifleItem) {
                                 if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity;
                                    var10000 = _entity.getMainHandItem();
                                 } else {
                                    var10000 = ItemStack.EMPTY;
                                 }

                                 var10000.getOrCreateTag().putString("geckoAnim", "fire");
                              }
                           }

                           Projectile _entityToSpawn;
                           Level projectileLevel;
                           if (itemstack.getOrCreateTag().getString("Type").equals("AP")) {
                              projectileLevel = entity.level();
                              if (!projectileLevel.isClientSide()) {
                                 _entityToSpawn = ((<undefinedtype>)(new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                       AbstractArrow entityToSpawn = new LargeAPBulletEntity((EntityType)CrustyChunksModEntities.LARGE_AP_BULLET.get(), level);
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       entityToSpawn.setPierceLevel(piercing);
                                       return entityToSpawn;
                                    }
                                 })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)5);
                                 _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                                 _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 8.0F, (float)Movementinnacuracy);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }
                           } else if (itemstack.getOrCreateTag().getString("Type").equals("MB")) {
                              projectileLevel = entity.level();
                              if (!projectileLevel.isClientSide()) {
                                 _entityToSpawn = ((<undefinedtype>)(new Object() {
                                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                       AbstractArrow entityToSpawn = new LargeBulletFireProjectileEntity((EntityType)CrustyChunksModEntities.LARGE_BULLET_FIRE_PROJECTILE.get(), level);
                                       entityToSpawn.setOwner(shooter);
                                       entityToSpawn.setBaseDamage((double)damage);
                                       entityToSpawn.setKnockback(knockback);
                                       entityToSpawn.setSilent(true);
                                       entityToSpawn.setPierceLevel(piercing);
                                       return entityToSpawn;
                                    }
                                 })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)2);
                                 _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                                 _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 8.0F, (float)Movementinnacuracy);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }
                           } else if (itemstack.getOrCreateTag().getString("Type").equals("ST")) {
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
                                       return entityToSpawn;
                                    }
                                 })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)2);
                                 _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                                 _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 8.0F, (float)Movementinnacuracy);
                                 projectileLevel.addFreshEntity(_entityToSpawn);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           CompoundTag var29 = var10000.getOrCreateTag();
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10002 = _livEnt.getMainHandItem();
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var29.putDouble("Ammo", var10002.getOrCreateTag().getDouble("Ammo") - 1.0D);
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.LARGE_CASING.get()));
                              entityToSpawn.setPickUpDelay(10);
                              _level.addFreshEntity(entityToSpawn);
                           }

                           CasingDropProcedure.execute(world, x, y, z);
                           LargeFireSoundProcedure.execute(world, x, y, z);
                           GunMechanismSoundProcedure.execute(world, x, y, z);

                           for(int index0 = 0; index0 < 3; ++index0) {
                              world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.GUN_SMOKE.get(), x + entity.getLookAngle().x * 0.8D, y + (double)entity.getEyeHeight() - 0.1D, z + entity.getLookAngle().z * 0.8D, entity.getLookAngle().x * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), entity.getLookAngle().y * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D), entity.getLookAngle().z * 0.2D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D));
                           }

                           entity.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -2.0D, 2.0D)));
                           entity.setXRot((float)((double)entity.getXRot() - recoil));
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putBoolean("action", false);
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putBoolean("reset", false);
                        }
                     }
                  }
               }
            }

            boolean _setval = false;
            entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.clickrelease = _setval;
               capability.syncPlayerVariables(entity);
            });
         }

      }
   }
}
