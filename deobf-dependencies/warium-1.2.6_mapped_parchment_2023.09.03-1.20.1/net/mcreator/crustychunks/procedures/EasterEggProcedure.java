package net.mcreator.crustychunks.procedures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModGameRules;
import net.mcreator.crustychunks.network.CrustyChunksModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class EasterEggProcedure {
   @SubscribeEvent
   public static void onChat(ServerChatEvent event) {
      execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getRawText());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String text) {
      execute((Event)null, world, x, y, z, entity, text);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String text) {
      if (entity != null && text != null) {
         if (world.getLevelData().getGameRules().getBoolean(CrustyChunksModGameRules.APOCALYPSE_MODE) && 0.0D == ((CrustyChunksModVariables.PlayerVariables)entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new CrustyChunksModVariables.PlayerVariables())).eastereggcooldown && text.contains("clanker")) {
            Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(250.0D), (e) -> {
               return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
               return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var12 = _entfound.iterator();

            while(var12.hasNext()) {
               Entity entityiterator = (Entity)var12.next();
               if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("crusty_chunks:robot")))) {
                  CrustyChunksMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 20), () -> {
                     if (entityiterator instanceof Mob) {
                        Mob _entity = (Mob)entityiterator;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _ent = (LivingEntity)entity;
                           _entity.setTarget(_ent);
                        }
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.level().isClientSide()) {
                           _player.displayClientMessage(Component.literal("<Strategist> §cWHAT DID YOU SAY?!"), false);
                        }
                     }

                     Level _level;
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderalert")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                        } else {
                           _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderalert")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                        }
                     }

                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderwaffing")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D));
                        } else {
                           _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:commanderwaffing")), SoundSource.HOSTILE, 3.0F, (float)Mth.nextDouble(RandomSource.create(), 0.95D, 1.05D), false);
                        }
                     }

                  });
                  double _setval = 400000.0D;
                  entity.getCapability(CrustyChunksModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.eastereggcooldown = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }
         }

      }
   }
}
