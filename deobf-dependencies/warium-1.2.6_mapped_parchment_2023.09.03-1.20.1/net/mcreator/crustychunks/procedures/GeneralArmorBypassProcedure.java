package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.entity.APMediumBulletEntity;
import net.mcreator.crustychunks.entity.BulletfireProjectileEntity;
import net.mcreator.crustychunks.entity.ExtraLargeBulletFireEntity;
import net.mcreator.crustychunks.entity.LargeAPBulletEntity;
import net.mcreator.crustychunks.entity.LargeBulletFireProjectileEntity;
import net.mcreator.crustychunks.entity.LargeStealthBulletEntity;
import net.mcreator.crustychunks.entity.SmallBulletAltEntity;
import net.mcreator.crustychunks.entity.SmallBulletHPEntity;
import net.mcreator.crustychunks.entity.SmallBulletStealthEntity;
import net.mcreator.crustychunks.entity.SmallbulletfireProjectileEntity;
import net.mcreator.crustychunks.entity.StealthMediumBulletEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GeneralArmorBypassProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double Health = 0.0D;
         double damagemultiplier = 0.0D;
         double penetrationmult = 0.0D;
         if (immediatesourceentity instanceof SmallbulletfireProjectileEntity) {
            penetrationmult = 1.0D;
            damagemultiplier = 0.9D;
         } else if (immediatesourceentity instanceof SmallBulletAltEntity) {
            penetrationmult = 0.5D;
            damagemultiplier = 0.8D;
         } else if (immediatesourceentity instanceof SmallBulletHPEntity) {
            penetrationmult = -0.1D;
            damagemultiplier = 1.0D;
         } else if (immediatesourceentity instanceof SmallBulletStealthEntity) {
            penetrationmult = 0.5D;
            damagemultiplier = 0.8D;
         } else if (immediatesourceentity instanceof BulletfireProjectileEntity) {
            penetrationmult = -0.1D;
            damagemultiplier = 1.1D;
         } else if (immediatesourceentity instanceof APMediumBulletEntity) {
            penetrationmult = 1.0D;
            damagemultiplier = 1.0D;
         } else if (immediatesourceentity instanceof StealthMediumBulletEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 1.0D;
         } else if (immediatesourceentity instanceof LargeBulletFireProjectileEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 2.0D;
         } else if (immediatesourceentity instanceof LargeAPBulletEntity) {
            penetrationmult = 1.5D;
            damagemultiplier = 1.9D;
         } else if (immediatesourceentity instanceof LargeStealthBulletEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 1.9D;
         } else if (immediatesourceentity instanceof ExtraLargeBulletFireEntity) {
            penetrationmult = 0.0D;
            damagemultiplier = 2.25D;
         } else {
            penetrationmult = 0.0D;
            damagemultiplier = 1.0D;
         }

         Level _level;
         if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:bulletproof")))) {
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:wizz")), SoundSource.NEUTRAL, 3.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:wizz")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
               }
            }

            ItemStack var10000;
            LivingEntity _entGetArmor;
            if (entity instanceof LivingEntity) {
               _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            ItemStack _ist;
            LivingEntity _entGetArmor;
            if (var10000.is(ItemTags.create(new ResourceLocation("crusty_chunks:bulletarmor")))) {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(4.0D * damagemultiplier + penetrationmult));
               if (entity instanceof LivingEntity) {
                  _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               _ist = var10000;
               if (_ist.hurt(4, RandomSource.create(), (ServerPlayer)null)) {
                  _ist.shrink(1);
                  _ist.setDamageValue(0);
               }
            } else {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(6.0D * damagemultiplier - penetrationmult));
            }

            if (immediatesourceentity.getY() - immediatesourceentity.getLookAngle().y * Math.sqrt(Math.pow(entity.getX() - immediatesourceentity.getX(), 2.0D) + Math.pow(entity.getZ() - immediatesourceentity.getZ(), 2.0D)) > entity.getY() + 1.55D) {
               if (entity instanceof LivingEntity) {
                  _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (!var10000.is(ItemTags.create(new ResourceLocation("crusty_chunks:bulletarmor")))) {
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(6.0D * damagemultiplier - penetrationmult));
               } else {
                  entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("crusty_chunks:armor_bypass_damage")))), (float)(3.0D * damagemultiplier + penetrationmult));
                  if (entity instanceof LivingEntity) {
                     _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  _ist = var10000;
                  if (_ist.hurt(7, RandomSource.create(), (ServerPlayer)null)) {
                     _ist.shrink(1);
                     _ist.setDamageValue(0);
                  }
               }
            }
         } else {
            if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }
            } else if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bounce")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 1.0D, 3.0D, 1.0D, 0.05D);
            }

            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ARROW)), (float)(4.0D * damagemultiplier + penetrationmult));
         }

      }
   }
}
