package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpaceFusionThermalRadEntityProcedureProcedure {
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
         List _entfound;
         Iterator var33;
         Entity entityiterator;
         Vec3 _center;
         if (immediatesourceentity.getPersistentData().getDouble("T") <= 20.0D) {
            immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);

            for(int index0 = 0; index0 < 256; ++index0) {
               immediatesourceentity.setYRot((float)Mth.nextDouble(RandomSource.create(), -360.0D, 360.0D));
               immediatesourceentity.setXRot((float)Mth.nextDouble(RandomSource.create(), -360.0D, 360.0D));
               immediatesourceentity.setYBodyRot(immediatesourceentity.getYRot());
               immediatesourceentity.setYHeadRot(immediatesourceentity.getYRot());
               immediatesourceentity.yRotO = immediatesourceentity.getYRot();
               immediatesourceentity.xRotO = immediatesourceentity.getXRot();
               if (immediatesourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)immediatesourceentity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (!world.isEmptyBlock(new BlockPos(immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(300.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX(), immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(300.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getY(), immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(300.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ())) && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, (double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(300.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX(), (double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(300.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getY(), (double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(300.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ(), 6.0F, ExplosionInteraction.BLOCK);
                  }
               }

               if (1 == Mth.nextInt(RandomSource.create(), 1, 3)) {
                  world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.SPACE_FIREBALL.get(), x, y, z, immediatesourceentity.getLookAngle().x * Mth.nextDouble(RandomSource.create(), -1.5D, 1.5D), immediatesourceentity.getLookAngle().y * Mth.nextDouble(RandomSource.create(), -1.5D, 1.5D), immediatesourceentity.getLookAngle().z * Mth.nextDouble(RandomSource.create(), -1.5D, 1.5D));
               }
            }

            _center = new Vec3(x, y, z);
            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(80.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            var33 = _entfound.iterator();

            while(var33.hasNext()) {
               entityiterator = (Entity)var33.next();
               if (entityiterator != immediatesourceentity && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:projectile"))) && !entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }
            }
         } else if (21.0D == immediatesourceentity.getPersistentData().getDouble("T")) {
            _center = new Vec3(x, y, z);
            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(250.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            var33 = _entfound.iterator();

            while(var33.hasNext()) {
               entityiterator = (Entity)var33.next();
               if (entityiterator instanceof LivingEntity) {
                  immediatesourceentity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 1.0D, entityiterator.getZ()));
                  if (Math.abs(entityiterator.getX() - x) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX() - x) + 0.5D) <= 0.0D && Math.abs(entityiterator.getZ() - z) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ() - z) + 0.5D) <= 0.0D) {
                     entityiterator.setSecondsOnFire(40);
                  }
               }
            }

            immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         } else if (immediatesourceentity.getPersistentData().getDouble("T") <= 250.0D) {
            immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         } else if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
