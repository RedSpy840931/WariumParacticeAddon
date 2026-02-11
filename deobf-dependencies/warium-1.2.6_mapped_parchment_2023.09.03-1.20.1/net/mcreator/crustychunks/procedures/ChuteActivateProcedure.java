package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class ChuteActivateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos _bp = BlockPos.containing(x, y, z);
      BlockState _bs = ((Block)CrustyChunksModBlocks.ACTIVE_ROBOT_CHUTE.get()).defaultBlockState();
      BlockState _bso = world.getBlockState(_bp);
      UnmodifiableIterator var10 = _bso.getValues().entrySet().iterator();

      while(var10.hasNext()) {
         Entry<Property<?>, Comparable<?>> entry = (Entry)var10.next();
         Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
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
