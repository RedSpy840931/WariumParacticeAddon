package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class ImpendingDoomActiveTickConditionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         CompoundTag var10000;
         double var10002;
         label23: {
            var10000 = entity.getPersistentData();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)CrustyChunksModMobEffects.IMPENDING_DOOM.get())) {
                  var10002 = (double)_livEnt.getEffect((MobEffect)CrustyChunksModMobEffects.IMPENDING_DOOM.get()).getAmplifier();
                  break label23;
               }
            }

            var10002 = 0.0D;
         }

         var10000.putDouble("DoomType", var10002);
         if (world instanceof ServerLevel) {
            ServerLevel _level2 = (ServerLevel)world;
            if (_level2.isVillage(BlockPos.containing(x, y, z)) && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)CrustyChunksModMobEffects.IMPENDING_DOOM.get());
            }
         }

      }
   }
}
