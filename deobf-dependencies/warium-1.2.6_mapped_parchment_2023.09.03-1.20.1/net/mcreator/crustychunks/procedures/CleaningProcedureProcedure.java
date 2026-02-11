package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class CleaningProcedureProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos _bp;
      BlockState _bs;
      BlockState _bso;
      UnmodifiableIterator var10;
      Entry entry;
      Property _property;
      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.MOSSY_COBBLESTONE) {
         _bp = BlockPos.containing(x, y, z);
         _bs = Blocks.COBBLESTONE.defaultBlockState();
         _bso = world.getBlockState(_bp);
         var10 = _bso.getValues().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
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

      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.MOSSY_STONE_BRICKS) {
         _bp = BlockPos.containing(x, y, z);
         _bs = Blocks.STONE_BRICKS.defaultBlockState();
         _bso = world.getBlockState(_bp);
         var10 = _bso.getValues().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
            _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
            if (_property != null && _bs.getValue(_property) != null) {
               try {
                  _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
               } catch (Exception var15) {
               }
            }
         }

         world.setBlock(_bp, _bs, 3);
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.OVERGROWN_REENFORCED_CONCRETE.get()) {
         _bp = BlockPos.containing(x, y, z);
         _bs = ((Block)CrustyChunksModBlocks.REENFORCED_CONCRETE.get()).defaultBlockState();
         _bso = world.getBlockState(_bp);
         var10 = _bso.getValues().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
            _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
            if (_property != null && _bs.getValue(_property) != null) {
               try {
                  _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
               } catch (Exception var14) {
               }
            }
         }

         world.setBlock(_bp, _bs, 3);
      }

   }
}
