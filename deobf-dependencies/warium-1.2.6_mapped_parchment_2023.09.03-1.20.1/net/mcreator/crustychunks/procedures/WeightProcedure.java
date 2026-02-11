package net.mcreator.crustychunks.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.IItemHandler;

@EventBusSubscriber
public class WeightProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.level(), event.player);
      }

   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         double Weight = 0.0D;
         if (1 == Mth.nextInt(RandomSource.create(), 1, 20) && ((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                  return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
               } else if (_ent.level().isClientSide() && _ent instanceof Player) {
                  Player _player = (Player)_ent;
                  return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity)) {
            Weight = 0.0D;
            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
            LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
            Objects.requireNonNull(_iitemhandlerref);
            var10000.ifPresent(_iitemhandlerref::set);
            if (_iitemhandlerref.get() != null) {
               for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                  if (itemstackiterator.is(ItemTags.create(new ResourceLocation("crusty_chunks:mass1")))) {
                     Weight += (double)(itemstackiterator.getCount() * 50);
                  } else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("crusty_chunks:mass2")))) {
                     Weight += (double)(itemstackiterator.getCount() * 100);
                  } else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("crusty_chunks:mass3")))) {
                     Weight += (double)(itemstackiterator.getCount() * 200);
                  } else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("crusty_chunks:mass4")))) {
                     Weight += (double)(itemstackiterator.getCount() * 300);
                  } else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("crusty_chunks:mass5")))) {
                     Weight += (double)(itemstackiterator.getCount() * 600);
                  } else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("crusty_chunks:mass6")))) {
                     Weight += (double)(itemstackiterator.getCount() * 750);
                  }

                  if (itemstackiterator.is(ItemTags.create(new ResourceLocation("crusty_chunks:heavy")))) {
                     Weight += 2000.0D;
                  }
               }
            }

            LivingEntity _entity;
            if (Weight > 1000.0D && entity instanceof LivingEntity) {
               _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2, false, false));
               }
            }

            if (Weight > 1500.0D) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 4, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 2, false, false));
                  }
               }
            }
         }

      }
   }
}
