package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.mcreator.crustychunks.item.MachineCarbineItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class MachineCarbineReloadScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double Rounds = 0.0D;
         LivingEntity _livEnt;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getOffhandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemStack _setstack;
         Player _player;
         ItemStack var10001;
         ItemStack var10002;
         LivingEntity _livEnt;
         Level _level;
         CompoundTag var22;
         if (var10000.getCount() == 0) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            if (var10001.getOrCreateTag().getBoolean("Loaded")) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMG_MAGAZINE.get())).copy();
                  _setstack.setCount(1);
                  _livEnt.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_livEnt instanceof Player) {
                     _player = (Player)_livEnt;
                     _player.getInventory().setChanged();
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var22 = var10000.getOrCreateTag();
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMainHandItem();
               } else {
                  var10002 = ItemStack.EMPTY;
               }

               var22.putDouble("Ammo", var10002.getOrCreateTag().getDouble("Ammo"));
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.getOrCreateTag().putBoolean("Loaded", false);
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.getOrCreateTag().putDouble("Ammo", 0.0D);
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var22 = var10000.getOrCreateTag();
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10002 = _livEnt.getMainHandItem();
               } else {
                  var10002 = ItemStack.EMPTY;
               }

               var22.putString("Type", var10002.getOrCreateTag().getString("Type"));
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.getOrCreateTag().putString("Type", "NULL");
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity var23 = new ItemEntity;
                  double var10004 = y + 1.0D;
                  ItemStack var10006;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10006 = _livEnt.getOffhandItem();
                  } else {
                     var10006 = ItemStack.EMPTY;
                  }

                  var23.<init>(_level, x, var10004, z, var10006);
                  ItemEntity entityToSpawn = var23;
                  entityToSpawn.setPickUpDelay(10);
                  entityToSpawn.setUnlimitedLifetime();
                  _level.addFreshEntity(entityToSpawn);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMG_MAGAZINE.get())).copy();
                  _setstack.setCount(0);
                  _livEnt.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_livEnt instanceof Player) {
                     _player = (Player)_livEnt;
                     _player.getInventory().setChanged();
                  }
               }

               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() instanceof MachineCarbineItem) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putString("geckoAnim", "MagOut");
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.SMG_MAGAZINE.get()) {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMainHandItem();
               } else {
                  var10001 = ItemStack.EMPTY;
               }

               if (!var10001.getOrCreateTag().getBoolean("Loaded")) {
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putBoolean("Loaded", true);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putBoolean("action", true);
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var22 = var10000.getOrCreateTag();
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.getOffhandItem();
                  } else {
                     var10002 = ItemStack.EMPTY;
                  }

                  var22.putDouble("Ammo", var10002.getOrCreateTag().getDouble("Ammo"));
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var22 = var10000.getOrCreateTag();
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10002 = _livEnt.getOffhandItem();
                  } else {
                     var10002 = ItemStack.EMPTY;
                  }

                  var22.putString("Type", var10002.getOrCreateTag().getString("Type"));
                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.SMG_MAGAZINE.get())).copy();
                     _setstack.setCount(0);
                     _livEnt.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                     if (_livEnt instanceof Player) {
                        _player = (Player)_livEnt;
                        _player.getInventory().setChanged();
                     }
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:magazine")), SoundSource.NEUTRAL, 0.1F, 1.5F, false);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() instanceof MachineCarbineItem) {
                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putString("geckoAnim", "MagIn");
                  }
               }
            }
         }

         if (entity instanceof LivingEntity) {
            _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMainHandItem();
         } else {
            var10001 = ItemStack.EMPTY;
         }

         if (var10001.getOrCreateTag().getBoolean("Loaded")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.SMG_MAGAZINE.get() && entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§4Weapon still contains magazine."), true);
               }
            }
         }

      }
   }
}
