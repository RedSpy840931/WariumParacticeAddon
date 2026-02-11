package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ThermalRadEntityProcedure {
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
         if (immediatesourceentity.getPersistentData().getDouble("T") <= 20.0D) {
            immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);

            for(int index0 = 0; index0 < 200; ++index0) {
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

               if (!world.isEmptyBlock(new BlockPos(immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX(), immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getY(), immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(160.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ()))) {
                  CrustyChunksMod.queueServerWork(1, () -> {
                     BurnBlockProcedure.execute(world, (double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX(), (double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getY(), (double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(150.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ());
                  });
               }
            }
         } else {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(250.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var32 = _entfound.iterator();

            while(var32.hasNext()) {
               Entity entityiterator = (Entity)var32.next();
               if (entityiterator instanceof LivingEntity) {
                  immediatesourceentity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + 1.0D, entityiterator.getZ()));
                  if (Math.abs(entityiterator.getX() - x) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getX() - x) + 0.5D) <= 0.0D && Math.abs(entityiterator.getZ() - z) - (Math.abs((double)immediatesourceentity.level().clip(new ClipContext(immediatesourceentity.getEyePosition(1.0F), immediatesourceentity.getEyePosition(1.0F).add(immediatesourceentity.getViewVector(1.0F).scale(250.0D)), Block.COLLIDER, Fluid.ANY, immediatesourceentity)).getBlockPos().getZ() - z) + 0.5D) <= 0.0D) {
                     entityiterator.setSecondsOnFire(40);
                  }
               }
            }

            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
