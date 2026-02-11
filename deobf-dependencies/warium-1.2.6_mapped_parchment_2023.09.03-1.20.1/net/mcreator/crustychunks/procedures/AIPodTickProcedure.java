package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIPodTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         boolean Trigger = false;
         if (!immediatesourceentity.isUnderWater() && immediatesourceentity.getDeltaMovement().y() <= -0.4D && !immediatesourceentity.isNoGravity() && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y - 90.0D, z))) {
            immediatesourceentity.setDeltaMovement(new Vec3(immediatesourceentity.getDeltaMovement().x() * 0.95D, immediatesourceentity.getDeltaMovement().y() * 0.95D, immediatesourceentity.getDeltaMovement().z() * 0.95D));
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x() * 2.2D + 0.2D, immediatesourceentity.getDeltaMovement().y() * 2.2D, immediatesourceentity.getDeltaMovement().z() * 2.2D + 0.2D);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x() * 2.2D - 0.2D, immediatesourceentity.getDeltaMovement().y() * 2.2D, immediatesourceentity.getDeltaMovement().z() * 2.2D + 0.2D);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x() * 2.2D + 0.2D, immediatesourceentity.getDeltaMovement().y() * 2.2D, immediatesourceentity.getDeltaMovement().z() * 2.2D - 0.2D);
            world.addParticle((SimpleParticleType)CrustyChunksModParticleTypes.JET_FLAME.get(), x, y, z, immediatesourceentity.getDeltaMovement().x() * 2.2D - 0.2D, immediatesourceentity.getDeltaMovement().y() * 2.2D, immediatesourceentity.getDeltaMovement().z() * 2.2D - 0.2D);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 4.0F, (float)Mth.nextDouble(RandomSource.create(), 1.2D, 1.4D), false);
               }
            }
         }

         Vec3 _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.75D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.distanceToSqr(_center);
         })).toList();
         Iterator var11 = _entfound.iterator();

         while(var11.hasNext()) {
            Entity entityiterator = (Entity)var11.next();
            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:bullet")))) {
               if (!entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }

               Trigger = true;
            }
         }

         if (Trigger) {
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }

            CrustyChunksMod.queueServerWork(1, () -> {
               MicroExplosionProcedure.execute(world, x, y, z);
            });
         }

      }
   }
}
