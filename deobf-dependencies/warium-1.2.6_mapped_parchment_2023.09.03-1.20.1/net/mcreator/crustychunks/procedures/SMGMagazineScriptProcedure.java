package net.mcreator.crustychunks.procedures;

import java.text.DecimalFormat;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SMGMagazineScriptProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Rounds = 0.0D;
         double Capacity = 0.0D;
         Capacity = 40.0D;
         if (0.0D == itemstack.getOrCreateTag().getDouble("Ammo")) {
            itemstack.getOrCreateTag().putString("Type", "NULL");
         }

         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ServerLevel _level;
         ItemStack var10000;
         ItemEntity entityToSpawn;
         LivingEntity _livEnt;
         double var10001;
         ItemStack var10002;
         Level _level;
         LivingEntity _livEnt;
         LivingEntity _livEnt;
         ItemStack var22;
         double var23;
         if (itemstack.getOrCreateTag().getString("Type").equals("NULL") || itemstack.getOrCreateTag().getString("Type").equals("HP")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getCount() == 0) {
               if (1.0D <= itemstack.getOrCreateTag().getDouble("Ammo")) {
                  Rounds = itemstack.getOrCreateTag().getDouble("Ammo") - 1.0D;
                  itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.SMALL_HOLLOW_POINT_BULLET.get()) {
                  itemstack.getOrCreateTag().putString("Type", "HP");
                  if (Capacity > itemstack.getOrCreateTag().getDouble("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if ((double)var10000.getCount() >= Capacity - itemstack.getOrCreateTag().getDouble("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.shrink((int)(Capacity - itemstack.getOrCreateTag().getDouble("Ammo")));
                        Rounds = itemstack.getOrCreateTag().getDouble("Ammo") + Capacity - itemstack.getOrCreateTag().getDouble("Ammo");
                        itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                     } else {
                        var10001 = itemstack.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getOffhandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (Capacity > var10001 + (double)var10002.getCount()) {
                           var23 = itemstack.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.getOffhandItem();
                           } else {
                              var22 = ItemStack.EMPTY;
                           }

                           Rounds = var23 + (double)var22.getCount();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.getOffhandItem();
                           } else {
                              var22 = ItemStack.EMPTY;
                           }

                           var10000.shrink(var22.getCount());
                           itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                        }
                     }
                  }
               }
            }
         }

         if (itemstack.getOrCreateTag().getString("Type").equals("NULL") || itemstack.getOrCreateTag().getString("Type").equals("AP")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getCount() == 0) {
               if (1.0D <= itemstack.getOrCreateTag().getDouble("Ammo")) {
                  Rounds = itemstack.getOrCreateTag().getDouble("Ammo") - 1.0D;
                  itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALLBULLET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.SMALLBULLET.get()) {
                  itemstack.getOrCreateTag().putString("Type", "AP");
                  if (Capacity > itemstack.getOrCreateTag().getDouble("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if ((double)var10000.getCount() >= Capacity - itemstack.getOrCreateTag().getDouble("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.shrink((int)(Capacity - itemstack.getOrCreateTag().getDouble("Ammo")));
                        Rounds = itemstack.getOrCreateTag().getDouble("Ammo") + Capacity - itemstack.getOrCreateTag().getDouble("Ammo");
                        itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                     } else {
                        var10001 = itemstack.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getOffhandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (Capacity > var10001 + (double)var10002.getCount()) {
                           var23 = itemstack.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.getOffhandItem();
                           } else {
                              var22 = ItemStack.EMPTY;
                           }

                           Rounds = var23 + (double)var22.getCount();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.getOffhandItem();
                           } else {
                              var22 = ItemStack.EMPTY;
                           }

                           var10000.shrink(var22.getCount());
                           itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                        }
                     }
                  }
               }
            }
         }

         Player _player;
         CompoundTag var10003;
         String var24;
         if (itemstack.getOrCreateTag().getString("Type").equals("NULL") || itemstack.getOrCreateTag().getString("Type").equals("ST")) {
            if (entity instanceof LivingEntity) {
               _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getCount() == 0) {
               if (1.0D <= itemstack.getOrCreateTag().getDouble("Ammo")) {
                  Rounds = itemstack.getOrCreateTag().getDouble("Ammo") - 1.0D;
                  itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)CrustyChunksModItems.SMALL_STEALTH_BULLET.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                     }
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == CrustyChunksModItems.SMALL_STEALTH_BULLET.get()) {
                  itemstack.getOrCreateTag().putString("Type", "ST");
                  if (Capacity > itemstack.getOrCreateTag().getDouble("Ammo")) {
                     if (world instanceof Level) {
                        _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.step")), SoundSource.NEUTRAL, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 3.0D, 3.1D), false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if ((double)var10000.getCount() >= Capacity - itemstack.getOrCreateTag().getDouble("Ammo")) {
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getOffhandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        var10000.shrink((int)(Capacity - itemstack.getOrCreateTag().getDouble("Ammo")));
                        Rounds = itemstack.getOrCreateTag().getDouble("Ammo") + Capacity - itemstack.getOrCreateTag().getDouble("Ammo");
                        itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                     } else {
                        var10001 = itemstack.getOrCreateTag().getDouble("Ammo");
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10002 = _livEnt.getOffhandItem();
                        } else {
                           var10002 = ItemStack.EMPTY;
                        }

                        if (Capacity > var10001 + (double)var10002.getCount()) {
                           var23 = itemstack.getOrCreateTag().getDouble("Ammo");
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.getOffhandItem();
                           } else {
                              var22 = ItemStack.EMPTY;
                           }

                           Rounds = var23 + (double)var22.getCount();
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getOffhandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              var22 = _livEnt.getOffhandItem();
                           } else {
                              var22 = ItemStack.EMPTY;
                           }

                           var10000.shrink(var22.getCount());
                           itemstack.getOrCreateTag().putDouble("Ammo", Rounds);
                        }
                     }
                  }
               }
            }

            if (entity instanceof Player) {
               _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  var10003 = itemstack.getOrCreateTag();
                  var24 = (new DecimalFormat("§4" + var10003.getString("Type") + "§6####§8/§6")).format(itemstack.getOrCreateTag().getDouble("Ammo"));
                  _player.displayClientMessage(Component.literal(var24 + (new DecimalFormat("####")).format(Capacity)), true);
               }
            }
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            _player.getCooldowns().addCooldown(itemstack.getItem(), 1);
         }

         if (entity instanceof Player) {
            _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               var10003 = itemstack.getOrCreateTag();
               var24 = (new DecimalFormat("§4" + var10003.getString("Type") + "§6####§8/§6")).format(itemstack.getOrCreateTag().getDouble("Ammo"));
               _player.displayClientMessage(Component.literal(var24 + (new DecimalFormat("####")).format(Capacity)), true);
            }
         }

      }
   }
}
