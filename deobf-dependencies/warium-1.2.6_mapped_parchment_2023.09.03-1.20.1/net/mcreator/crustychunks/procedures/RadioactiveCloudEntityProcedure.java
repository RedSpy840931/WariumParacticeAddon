package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RadioactiveCloudEntityProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean found = false;
         double particleRadius = 0.0D;
         double particleAmount = 0.0D;
         double sx = 0.0D;
         double sy = 0.0D;
         double sz = 0.0D;
         double xRadius = 0.0D;
         double loop = 0.0D;
         double zRadius = 0.0D;
         double Groundatspot = 0.0D;
         immediatesourceentity.setNoGravity(true);
         immediatesourceentity.noPhysics = true;
         immediatesourceentity.setDeltaMovement(new Vec3(0.0D, 0.0D, 0.0D));
         if (!immediatesourceentity.getPersistentData().getBoolean("Used")) {
            for(int index0 = 0; index0 < 5; ++index0) {
               world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.RADIOACTIVE_CLOUD.get(), x + Mth.nextDouble(RandomSource.create(), -6.5D, 7.5D), y + 1.0D, z + Mth.nextDouble(RandomSource.create(), -6.5D, 7.5D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D), Mth.nextDouble(RandomSource.create(), -0.1D, 0.3D), Mth.nextDouble(RandomSource.create(), -0.5D, 0.5D));
            }

            immediatesourceentity.getPersistentData().putBoolean("Used", true);
         }

         if (immediatesourceentity.getPersistentData().getDouble("T") <= 200.0D) {
            immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
            if (1 == Mth.nextInt(RandomSource.create(), 1, 20)) {
               Vec3 _center = new Vec3(x, y, z);
               List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(15.0D), (e) -> {
                  return true;
               }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                  return _entcnd.distanceToSqr(_center);
               })).toList();
               Iterator var29 = _entfound.iterator();

               while(var29.hasNext()) {
                  Entity entityiterator = (Entity)var29.next();
                  if (entityiterator instanceof LivingEntity) {
                     immediatesourceentity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 1.0D, entityiterator.getZ()));
                     if (Math.abs(entityiterator.getY() - y) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(8.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getY() - y) + 0.5D) <= 0.0D && Math.abs(entityiterator.getX() - x) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(17.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX() - x) + 0.5D) <= 0.0D && Math.abs(entityiterator.getZ() - z) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(17.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ() - z) + 0.5D) <= 0.0D) {
                        ItemStack var10000;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                           var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (!var10000.is(ItemTags.create(new ResourceLocation("crusty_chunks:gasmask"))) && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.CONTAMINATED.get(), 2400, 3, false, false));
                           }
                        }
                     }
                  }
               }
            }
         } else if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
