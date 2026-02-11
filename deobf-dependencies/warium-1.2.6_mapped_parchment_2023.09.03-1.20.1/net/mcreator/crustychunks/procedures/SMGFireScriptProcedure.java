package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.SmallBulletHPEntity;
import net.mcreator.crustychunks.entity.SmallBulletStealthEntity;
import net.mcreator.crustychunks.entity.SmallbulletfireProjectileEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.SMGAnimatedItem;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

public class SMGFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         if (entity.isSprinting()) {
            Movementinnacuracy = 7.0D;
         } else {
            Movementinnacuracy = 5.0D;
         }

         if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
            Movementinnacuracy = 1.0D;
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getOffhandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
            if (!itemstack.getOrCreateTag().getBoolean("action")) {
               itemstack.getOrCreateTag().putBoolean("action", true);
               if (1.0D <= itemstack.getOrCreateTag().getDouble("Ammo")) {
                  if (itemstack.getOrCreateTag().getBoolean("Loaded") && 0.0D >= itemstack.getOrCreateTag().getDouble("Cooldown")) {
                     if (((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).AimDownSights) {
                        if (itemstack.getItem() instanceof SMGAnimatedItem) {
                           itemstack.getOrCreateTag().putString("geckoAnim", "sightfire");
                        }
                     } else if (itemstack.getItem() instanceof SMGAnimatedItem) {
                        itemstack.getOrCreateTag().putString("geckoAnim", "fire");
                     }

                     Level projectileLevel;
                     Projectile _entityToSpawn;
                     if (itemstack.getOrCreateTag().getString("Type").equals("AP")) {
                        projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                                 AbstractArrow entityToSpawn = new SmallbulletfireProjectileEntity((EntityType)CrustyChunksModEntities.SMALLBULLETFIRE_PROJECTILE.get(), level);
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 entityToSpawn.setPierceLevel(piercing);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.1F, 0, (byte)1);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, (float)Movementinnacuracy);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     } else if (itemstack.getOrCreateTag().getString("Type").equals("HP")) {
                        projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new SmallBulletHPEntity((EntityType)CrustyChunksModEntities.SMALL_BULLET_HP.get(), level);
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.1F, 0);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, (float)Movementinnacuracy);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     } else if (itemstack.getOrCreateTag().getString("Type").equals("ST")) {
                        projectileLevel = entity.level();
                        if (!projectileLevel.isClientSide()) {
                           _entityToSpawn = ((<undefinedtype>)(new Object() {
                              public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                 AbstractArrow entityToSpawn = new SmallBulletStealthEntity((EntityType)CrustyChunksModEntities.SMALL_BULLET_STEALTH.get(), level);
                                 entityToSpawn.setOwner(shooter);
                                 entityToSpawn.setBaseDamage((double)damage);
                                 entityToSpawn.setKnockback(knockback);
                                 entityToSpawn.setSilent(true);
                                 return entityToSpawn;
                              }
                           })).getArrow(projectileLevel, entity, 0.1F, 0);
                           _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                           _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 5.0F, (float)Movementinnacuracy);
                           projectileLevel.addFreshEntity(_entityToSpawn);
                        }
                     }

                     itemstack.getOrCreateTag().putDouble("Ammo", itemstack.getOrCreateTag().getDouble("Ammo") - 1.0D);
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_CASING.get()));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                     }

                     SmallCasingDropProcedure.execute(world, x, y, z);
                     PistolFireSoundProcedure.execute(world, x, y, z);
                     GunMechanismSoundProcedure.execute(world, x, y, z);
                     entity.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -1.0D, 1.0D)));
                     entity.setXRot((float)((double)entity.getXRot() - Mth.nextDouble(RandomSource.create(), 0.8D, 1.4D)));
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     itemstack.getOrCreateTag().putBoolean("action", false);
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:dryfire")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
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
