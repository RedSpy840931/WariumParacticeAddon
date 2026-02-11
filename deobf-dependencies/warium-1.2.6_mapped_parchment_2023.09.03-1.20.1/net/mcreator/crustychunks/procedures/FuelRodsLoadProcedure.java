package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class FuelRodsLoadProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Object var10000 = CrustyChunksModItems.FUEL_ROD.get();
         ItemStack var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMainHandItem();
         } else {
            var10001 = ItemStack.EMPTY;
         }

         Level _level;
         if (var10000 == var10001.getItem() && CrustyChunksModBlocks.FUEL_RODS_4.get() != world.getBlockState(BlockPos.containing(x, y, z)).getBlock()) {
            if (CrustyChunksModBlocks.FUEL_RODS_3.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()) {
               world.setBlock(BlockPos.containing(x, y, z), ((Block)CrustyChunksModBlocks.FUEL_RODS_4.get()).defaultBlockState(), 3);
            }

            if (CrustyChunksModBlocks.FUEL_RODS_2.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()) {
               world.setBlock(BlockPos.containing(x, y, z), ((Block)CrustyChunksModBlocks.FUEL_RODS_3.get()).defaultBlockState(), 3);
            }

            if (CrustyChunksModBlocks.FUEL_RODS_1.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()) {
               world.setBlock(BlockPos.containing(x, y, z), ((Block)CrustyChunksModBlocks.FUEL_RODS_2.get()).defaultBlockState(), 3);
            }

            if (CrustyChunksModBlocks.EMPTY_FUEL_RODS.get() == world.getBlockState(BlockPos.containing(x, y, z)).getBlock()) {
               world.setBlock(BlockPos.containing(x, y, z), ((Block)CrustyChunksModBlocks.FUEL_RODS_1.get()).defaultBlockState(), 3);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)CrustyChunksModItems.FUEL_ROD.get())).copy();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMainHandItem();
               } else {
                  var10001 = ItemStack.EMPTY;
               }

               _setstack.setCount(var10001.getCount() - 1);
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            CrustyChunksMod.queueServerWork(10, () -> {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 0.4F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 0.4F, false);
                  }
               }

            });
            if (world instanceof Level) {
               _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 1.0F, 0.4F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 1.0F, 0.4F, false);
               }
            }
         } else {
            Item var17 = ItemStack.EMPTY.getItem();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.getMainHandItem();
            } else {
               var10001 = ItemStack.EMPTY;
            }

            if (var17 == var10001.getItem() && CrustyChunksModBlocks.EMPTY_FUEL_RODS.get() != world.getBlockState(BlockPos.containing(x, y, z)).getBlock()) {
               FuelRodsDepleteProcedure.execute(world, x, y, z);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x + 1.0D, y + 1.0D, z + 1.0D, new ItemStack((ItemLike)CrustyChunksModItems.FUEL_ROD.get()));
                  entityToSpawn.setPickUpDelay(5);
                  _level.addFreshEntity(entityToSpawn);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 0.4F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lever.click")), SoundSource.NEUTRAL, 1.0F, 0.4F, false);
                  }
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 1.0F, 0.3F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.axe.scrape")), SoundSource.NEUTRAL, 1.0F, 0.3F, false);
                  }
               }
            }
         }

      }
   }
}
