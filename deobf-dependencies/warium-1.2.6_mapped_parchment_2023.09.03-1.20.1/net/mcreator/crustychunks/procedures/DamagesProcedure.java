package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class DamagesProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.MEDIUM_DIESEL_ENGINE.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.JET_TURBINE.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.MEDIUM_PETROL_ENGINE.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.ENGINE_CYLLINDER.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.SMALL_DIESEL_ENGINE.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.SMALL_PETROL_ENGINE.get()) {
         if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.FUEL_TANK_INPUT.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.FUEL_TANK.get() && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != CrustyChunksModBlocks.FUEL_TANK_MODULE.get()) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.AUTOCANNON_DRUM.get() && ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Ammo") > 3.0D) {
               world.destroyBlock(BlockPos.containing(x, y, z), false);
               CrustyChunksMod.queueServerWork(20, () -> {
                  MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
                  execute(world, x, y + 1.0D, z);
                  execute(world, x, y - 1.0D, z);
                  execute(world, x + 1.0D, y, z);
                  execute(world, x - 1.0D, y, z);
                  execute(world, x, y, z + 1.0D);
                  execute(world, x, y, z - 1.0D);
                  MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
               });
               CrustyChunksMod.queueServerWork(40, () -> {
                  MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
               });
               CrustyChunksMod.queueServerWork(50, () -> {
                  MicroExplosionProcedure.execute(world, x + 0.5D, y + 0.5D, z + 0.5D);
               });
            }
         } else {
            FuelTankDamagedProcedure.execute(world, x, y, z);
         }
      } else {
         LightCombustionEngineBlockDestroyedProcedure.execute(world, x, y, z);
         execute(world, x, y + 1.0D, z);
         execute(world, x, y - 1.0D, z);
         execute(world, x + 1.0D, y, z);
         execute(world, x - 1.0D, y, z);
         execute(world, x, y, z + 1.0D);
         execute(world, x, y, z - 1.0D);
      }

      if (0 < ((<undefinedtype>)(new Object() {
         public int getContainerSize(LevelAccessor world, BlockPos pos) {
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null && _ent instanceof BaseContainerBlockEntity) {
               BaseContainerBlockEntity _block = (BaseContainerBlockEntity)_ent;
               return _block.getContainerSize();
            } else {
               return 0;
            }
         }

         public int getAmount(LevelAccessor world, BlockPos pos) {
            Block block = world.getBlockState(pos).getBlock();
            if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
               boolean var10000;
               label17: {
                  Property var6 = block.getStateDefinition().getProperty("type");
                  if (var6 instanceof EnumProperty) {
                     EnumProperty _getep5 = (EnumProperty)var6;
                     if (world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE")) {
                        var10000 = true;
                        break label17;
                     }
                  }

                  var10000 = false;
               }

               boolean isSingle = var10000;
               if (!isSingle) {
                  return this.getContainerSize(world, pos) * 2;
               }
            }

            return this.getContainerSize(world, pos);
         }
      })).getAmount(world, new BlockPos((int)x, (int)y, (int)z))) {
         AmmoRackHitSystemProcedure.execute(world, x, y, z);
      }

   }
}
