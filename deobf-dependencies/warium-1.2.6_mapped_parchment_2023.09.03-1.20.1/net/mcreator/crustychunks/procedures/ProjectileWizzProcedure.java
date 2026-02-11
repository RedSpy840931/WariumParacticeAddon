package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber({Dist.CLIENT})
public class ProjectileWizzProcedure {
   @SubscribeEvent
   public static void updateWorldTick(ClientTickEvent event) {
      if (event.phase == Phase.START) {
         Minecraft minecraft = Minecraft.getInstance();
         ClientLevel level = minecraft.level;
         Entity entity = minecraft.gameRenderer.getMainCamera().getEntity();
         if (level != null && entity != null) {
            Vec3 pos = entity.getPosition(minecraft.getPartialTick());
            execute(event, level, pos.x(), pos.y(), pos.z());
         }

      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      execute((Event)null, world, x, y, z);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
      double locationy = 0.0D;
      double distancewithvector = 0.0D;
      double locationz = 0.0D;
      double distance = 0.0D;
      double locationx = 0.0D;
      Vec3 _center = new Vec3(x, y, z);
      List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(15.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.distanceToSqr(_center);
      })).toList();
      Iterator var20 = _entfound.iterator();

      Entity entityiterator;
      Level _level;
      while(var20.hasNext()) {
         entityiterator = (Entity)var20.next();
         if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:bullet"))) && !entityiterator.getPersistentData().getBoolean("Passed")) {
            distance = Math.sqrt(Math.pow(x - entityiterator.getX(), 2.0D) + Math.pow(y - entityiterator.getY(), 2.0D) + Math.pow(z - entityiterator.getZ(), 2.0D));
            distancewithvector = Math.sqrt(Math.pow(x - (entityiterator.getX() + entityiterator.getDeltaMovement().x()), 2.0D) + Math.pow(y - (entityiterator.getY() + entityiterator.getDeltaMovement().y()), 2.0D) + Math.pow(z - (entityiterator.getZ() + entityiterator.getDeltaMovement().z()), 2.0D));
            if (distancewithvector < distance) {
               entityiterator.getPersistentData().putBoolean("Passed", true);
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bulletcrack")), SoundSource.BLOCKS, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                  } else {
                     _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:bulletcrack")), SoundSource.BLOCKS, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                  }
               }
            }
         }
      }

      _center = new Vec3(x, y, z);
      _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(50.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.distanceToSqr(_center);
      })).toList();
      var20 = _entfound.iterator();

      while(var20.hasNext()) {
         entityiterator = (Entity)var20.next();
         if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:artillery"))) && !entityiterator.getPersistentData().getBoolean("Passed")) {
            distance = Math.sqrt(Math.pow(x - entityiterator.getX(), 2.0D) + Math.pow(y - entityiterator.getY(), 2.0D) + Math.pow(z - entityiterator.getZ(), 2.0D));
            distancewithvector = Math.sqrt(Math.pow(x - (entityiterator.getX() + entityiterator.getDeltaMovement().x()), 2.0D) + Math.pow(y - (entityiterator.getY() + entityiterator.getDeltaMovement().y()), 2.0D) + Math.pow(z - (entityiterator.getZ() + entityiterator.getDeltaMovement().z()), 2.0D));
            if (distancewithvector < distance) {
               entityiterator.getPersistentData().putBoolean("Passed", true);
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:artyfall")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                  } else {
                     _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:artyfall")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                  }
               }
            }
         }
      }

      _center = new Vec3(x, y, z);
      _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(50.0D), (e) -> {
         return true;
      }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
         return _entcnd.distanceToSqr(_center);
      })).toList();
      var20 = _entfound.iterator();

      while(var20.hasNext()) {
         entityiterator = (Entity)var20.next();
         if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:artillery"))) && !entityiterator.getPersistentData().getBoolean("Passed")) {
            distance = Math.sqrt(Math.pow(x - entityiterator.getX(), 2.0D) + Math.pow(y - entityiterator.getY(), 2.0D) + Math.pow(z - entityiterator.getZ(), 2.0D));
            distancewithvector = Math.sqrt(Math.pow(x - (entityiterator.getX() + entityiterator.getDeltaMovement().x()), 2.0D) + Math.pow(y - (entityiterator.getY() + entityiterator.getDeltaMovement().y()), 2.0D) + Math.pow(z - (entityiterator.getZ() + entityiterator.getDeltaMovement().z()), 2.0D));
            if (distancewithvector < distance) {
               entityiterator.getPersistentData().putBoolean("Passed", true);
               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:artyfall")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                  } else {
                     _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:artyfall")), SoundSource.BLOCKS, 10.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                  }
               }
            }
         }
      }

   }
}
