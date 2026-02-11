package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ArtilleryWarningMarkerWhileProjectileFlyingTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
      if (immediatesourceentity != null) {
         double targetrange = 0.0D;
         immediatesourceentity.setNoGravity(true);
         immediatesourceentity.noPhysics = true;
         immediatesourceentity.getPersistentData().putDouble("T", immediatesourceentity.getPersistentData().getDouble("T") + 1.0D);
         immediatesourceentity.setDeltaMovement(new Vec3(0.0D, 0.0D, 0.0D));
         Vec3 _center = new Vec3(x, y, z);
         List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(25.0D), (e) -> {
            return true;
         }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
            return _entcnd.distanceToSqr(_center);
         })).toList();
         Iterator var12 = _entfound.iterator();

         while(var12.hasNext()) {
            Entity entityiterator = (Entity)var12.next();
            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot")))) {
               targetrange = Math.sqrt(Math.pow(Math.abs(z - entityiterator.getZ()), 2.0D) + Math.pow(Math.abs(x - entityiterator.getX()), 2.0D));
               if (entityiterator instanceof Mob) {
                  Mob _entity = (Mob)entityiterator;
                  _entity.getNavigation().moveTo(x + (entityiterator.getZ() - z) * 30.0D / targetrange, y, z + (entityiterator.getX() - x) * 30.0D / targetrange, 1.0D);
               }
            }
         }

         if (200.0D < immediatesourceentity.getPersistentData().getDouble("T") && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
