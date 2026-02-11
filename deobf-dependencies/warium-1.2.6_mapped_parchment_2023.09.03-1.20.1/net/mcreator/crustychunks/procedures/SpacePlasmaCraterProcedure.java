package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class SpacePlasmaCraterProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, double scale) {
      int horizontalRadiusSphere = (int)(45.0D * scale) - 1;
      int verticalRadiusSphere = (int)(45.0D * scale) - 1;
      int yIterationsSphere = verticalRadiusSphere;

      for(int i = -verticalRadiusSphere; i <= yIterationsSphere; ++i) {
         for(int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; ++xi) {
            for(int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; ++zi) {
               double distanceSq = (double)(xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere) + (double)(i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere) + (double)(zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);
               if (distanceSq <= 1.0D && !world.getBlockState(BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi)).is(BlockTags.create(new ResourceLocation("crusty_chunks:immortal")))) {
                  BlockPos _bp = BlockPos.containing(x + (double)xi, y + (double)i, z + (double)zi);
                  BlockState _bs = Blocks.FIRE.defaultBlockState();
                  BlockState _bso = world.getBlockState(_bp);
                  UnmodifiableIterator var20 = _bso.getValues().entrySet().iterator();

                  while(var20.hasNext()) {
                     Entry<Property<?>, Comparable<?>> entry = (Entry)var20.next();
                     Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var24) {
                        }
                     }
                  }

                  world.setBlock(_bp, _bs, 3);
               }
            }
         }
      }

   }
}
