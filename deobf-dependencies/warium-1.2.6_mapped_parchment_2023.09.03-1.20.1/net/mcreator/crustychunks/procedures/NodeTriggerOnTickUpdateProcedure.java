package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class NodeTriggerOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      double Power = 0.0D;
      BlockPos _bp;
      BlockState _bs;
      BlockState _bs;
      UnmodifiableIterator var12;
      Entry entry;
      Property _property;
      BlockEntity _blockEntity;
      Level _level;
      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.NODE_TRIGGER.get()) {
         if (0.0D < ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Trigger")) {
            Power = ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "Trigger");
            _bp = BlockPos.containing(x, y, z);
            _bs = ((Block)CrustyChunksModBlocks.NODE_TRIGGER_ON.get()).defaultBlockState();
            _bs = world.getBlockState(_bp);
            var12 = _bs.getValues().entrySet().iterator();

            while(var12.hasNext()) {
               entry = (Entry)var12.next();
               _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                  } catch (Exception var17) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Trigger", Power);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }
      } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.NODE_TRIGGER_ON.get()) {
         if (0.0D < ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Trigger")) {
            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("Trigger", ((<undefinedtype>)(new Object() {
                     public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                     }
                  })).getValue(world, BlockPos.containing(x, y, z), "Trigger") - 1.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         } else {
            _bp = BlockPos.containing(x, y, z);
            _bs = ((Block)CrustyChunksModBlocks.NODE_TRIGGER.get()).defaultBlockState();
            _bs = world.getBlockState(_bp);
            var12 = _bs.getValues().entrySet().iterator();

            while(var12.hasNext()) {
               entry = (Entry)var12.next();
               _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                  } catch (Exception var16) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
         }
      }

   }
}
