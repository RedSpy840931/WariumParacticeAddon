package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MeltdownProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel) {
         ServerLevel _level = (ServerLevel)world;
         _level.sendParticles(ParticleTypes.ASH, x + 0.5D, y + 3.0D, z + 0.5D, 90, 5.0D, 3.0D, 5.0D, 0.0D);
      }

      Vec3 _center = new Vec3(x + 0.5D, y + 0.5D, z + 0.5D);
      List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(5.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.distanceToSqr(_center);
      })).toList();
      Iterator var9 = _entfound.iterator();

      while(var9.hasNext()) {
         Entity entityiterator = (Entity)var9.next();
         entityiterator.getPersistentData().putDouble("Radiation", entityiterator.getPersistentData().getDouble("Radiation") + 25.0D);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)CrustyChunksModMobEffects.RADIATION.get(), 60, 1, false, false));
            }
         }
      }

      world.setBlock(BlockPos.containing(x, y, z), ((Block)CrustyChunksModBlocks.RADIOACTIVE_ASH.get()).defaultBlockState(), 3);
   }
}
