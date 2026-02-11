package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.FlameThrowerEmberEntity;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class FlameThrowerFireScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Movementinnacuracy = 0.0D;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == CrustyChunksModItems.FLAME_THROWER_TANK_CHESTPLATE.get()) {
            itemstack.getOrCreateTag().putBoolean("firinglog", true);
            if (entity.isSprinting()) {
               Movementinnacuracy = 10.0D;
            } else {
               Movementinnacuracy = 9.0D;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
               if (0.0D >= itemstack.getOrCreateTag().getDouble("Cooldown")) {
                  ItemStack var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10001 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var10001 = ItemStack.EMPTY;
                  }

                  if (0.0D < var10001.getOrCreateTag().getDouble("Fluid")) {
                     LivingEntity _entity;
                     for(int index0 = 0; index0 < 3; ++index0) {
                        if (entity instanceof LivingEntity) {
                           _entity = (LivingEntity)entity;
                           var10001 = _entity.getItemBySlot(EquipmentSlot.CHEST);
                        } else {
                           var10001 = ItemStack.EMPTY;
                        }

                        if (1.0D < var10001.getOrCreateTag().getDouble("Fluid")) {
                           Level projectileLevel = entity.level();
                           if (!projectileLevel.isClientSide()) {
                              Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                                 public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                                    AbstractArrow entityToSpawn = new FlameThrowerEmberEntity((EntityType)CrustyChunksModEntities.FLAME_THROWER_EMBER.get(), level);
                                    entityToSpawn.setOwner(shooter);
                                    entityToSpawn.setBaseDamage((double)damage);
                                    entityToSpawn.setKnockback(knockback);
                                    entityToSpawn.setSilent(true);
                                    return entityToSpawn;
                                 }
                              })).getArrow(projectileLevel, entity, 0.0F, 0);
                              _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1D, entity.getZ());
                              _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)Mth.nextDouble(RandomSource.create(), 1.4D, 1.5D), (float)Movementinnacuracy);
                              projectileLevel.addFreshEntity(_entityToSpawn);
                           }

                           LivingEntity _entGetArmor;
                           if (entity instanceof LivingEntity) {
                              _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           CompoundTag var22 = var10000.getOrCreateTag();
                           ItemStack var10002;
                           if (entity instanceof LivingEntity) {
                              _entGetArmor = (LivingEntity)entity;
                              var10002 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                           } else {
                              var10002 = ItemStack.EMPTY;
                           }

                           var22.putDouble("Fluid", var10002.getOrCreateTag().getDouble("Fluid") - 2.0D);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.9D, 1.1D), false);
                        }
                     }

                     entity.setYRot(entity.getYRot());
                     entity.setXRot((float)((double)entity.getXRot() - Mth.nextDouble(RandomSource.create(), 0.2D, 0.4D)));
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  }
               }
            } else if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§4Weapon requires 2 hands to fire."), true);
               }
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§4Fuel tank required."), true);
            }
         }

      }
   }
}
