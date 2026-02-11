package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SeatEntityOnEntityTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.isVehicle()) {
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            Entity var9 = entity.getFirstPassenger();
            ItemStack var10000;
            if (var9 instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)var9;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == CrustyChunksModItems.AIMER.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.MANUAL_AIMER.get()) {
               CrustyChunksMod.queueServerWork(1, () -> {
                  if (entity.isVehicle()) {
                     Entity patt1301$temp = entity.getFirstPassenger();
                     ItemStack var10000;
                     if (patt1301$temp instanceof LivingEntity) {
                        LivingEntity _livEntxx = (LivingEntity)patt1301$temp;
                        var10000 = _livEntxx.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() == CrustyChunksModItems.AIMER.get()) {
                        Entity patt1471$temp = entity.getFirstPassenger();
                        if (patt1471$temp instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)patt1471$temp;
                           var10000 = _livEnt.getMainHandItem();
                        } else {
                           var10000 = ItemStack.EMPTY;
                        }

                        if (var10000.getOrCreateTag().getBoolean("Mode")) {
                           Entity patt1972$temp = entity.getFirstPassenger();
                           LivingEntity _livEntx;
                           if (patt1972$temp instanceof LivingEntity) {
                              _livEntx = (LivingEntity)patt1972$temp;
                              var10000 = _livEntx.getMainHandItem();
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           var10000.getOrCreateTag().putDouble("Pitch", (double)Math.min(Math.max(-22.0F, (entity.getFirstPassenger().getXRot() - entity.getXRot()) * -1.0F), 45.0F));
                           if (180.0F < entity.getFirstPassenger().getYRot() - entity.getYRot()) {
                              patt1972$temp = entity.getFirstPassenger();
                              if (patt1972$temp instanceof LivingEntity) {
                                 _livEntx = (LivingEntity)patt1972$temp;
                                 var10000 = _livEntx.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Yaw", (double)Math.min(Math.max(-30.0F, (360.0F - (entity.getFirstPassenger().getYRot() - entity.getYRot())) * -1.0F), 30.0F));
                           } else {
                              patt1972$temp = entity.getFirstPassenger();
                              if (patt1972$temp instanceof LivingEntity) {
                                 _livEntx = (LivingEntity)patt1972$temp;
                                 var10000 = _livEntx.getMainHandItem();
                              } else {
                                 var10000 = ItemStack.EMPTY;
                              }

                              var10000.getOrCreateTag().putDouble("Yaw", (double)Math.min(Math.max(-30.0F, entity.getFirstPassenger().getYRot() - entity.getYRot()), 30.0F));
                           }
                        }
                     }

                     if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.MANUAL_AIMER.get()) {
                        BlockPos _bp;
                        BlockEntity _blockEntity;
                        BlockState _bs;
                        Level _level;
                        if (!world.isClientSide()) {
                           _bp = BlockPos.containing(x, y, z);
                           _blockEntity = world.getBlockEntity(_bp);
                           _bs = world.getBlockState(_bp);
                           if (_blockEntity != null) {
                              _blockEntity.getPersistentData().putDouble("Pitch", (double)Math.min(Math.max(-22.0F, (entity.getFirstPassenger().getXRot() - entity.getXRot()) * -1.0F), 45.0F));
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                           }
                        }

                        if (!world.isClientSide()) {
                           _bp = BlockPos.containing(x, y, z);
                           _blockEntity = world.getBlockEntity(_bp);
                           _bs = world.getBlockState(_bp);
                           if (_blockEntity != null) {
                              _blockEntity.getPersistentData().putDouble("Updated", 5.0D);
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                           }
                        }

                        if (180.0F < entity.getFirstPassenger().getYRot() - entity.getYRot()) {
                           if (!world.isClientSide()) {
                              _bp = BlockPos.containing(x, y, z);
                              _blockEntity = world.getBlockEntity(_bp);
                              _bs = world.getBlockState(_bp);
                              if (_blockEntity != null) {
                                 _blockEntity.getPersistentData().putDouble("Yaw", (double)Math.min(Math.max(-30.0F, (360.0F - (entity.getFirstPassenger().getYRot() - entity.getYRot())) * -1.0F), 30.0F));
                              }

                              if (world instanceof Level) {
                                 _level = (Level)world;
                                 _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                              }
                           }
                        } else if (!world.isClientSide()) {
                           _bp = BlockPos.containing(x, y, z);
                           _blockEntity = world.getBlockEntity(_bp);
                           _bs = world.getBlockState(_bp);
                           if (_blockEntity != null) {
                              _blockEntity.getPersistentData().putDouble("Yaw", (double)Math.min(Math.max(-30.0F, entity.getFirstPassenger().getYRot() - entity.getYRot()), 30.0F));
                           }

                           if (world instanceof Level) {
                              _level = (Level)world;
                              _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                           }
                        }
                     }
                  }

               });
            }
         }

      }
   }
}
