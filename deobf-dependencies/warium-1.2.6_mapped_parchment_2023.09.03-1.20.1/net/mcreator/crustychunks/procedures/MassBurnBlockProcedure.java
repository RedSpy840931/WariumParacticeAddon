package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class MassBurnBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      CleaningProcedureProcedure.execute(world, x, y, z);
      BlockPos _bp;
      BlockState _bs;
      BlockState _bso;
      UnmodifiableIterator var10;
      Entry entry;
      Property _property;
      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.GRASS_BLOCK && !ModList.get().isLoaded("burnt")) {
         _bp = BlockPos.containing(x, y, z);
         _bs = ((Block)CrustyChunksModBlocks.BURNTGRASS.get()).defaultBlockState();
         _bso = world.getBlockState(_bp);
         var10 = _bso.getValues().entrySet().iterator();

         while(var10.hasNext()) {
            entry = (Entry)var10.next();
            _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
            if (_property != null && _bs.getValue(_property) != null) {
               try {
                  _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
               } catch (Exception var18) {
               }
            }
         }

         world.setBlock(_bp, _bs, 3);
         if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == Blocks.AIR) {
            _bp = BlockPos.containing(x, y + 1.0D, z);
            _bs = Blocks.FIRE.defaultBlockState();
            _bso = world.getBlockState(_bp);
            var10 = _bso.getValues().entrySet().iterator();

            while(var10.hasNext()) {
               entry = (Entry)var10.next();
               _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
               if (_property != null && _bs.getValue(_property) != null) {
                  try {
                     _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                  } catch (Exception var17) {
                  }
               }
            }

            world.setBlock(_bp, _bs, 3);
         }
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:burnable"))) && !ModList.get().isLoaded("burnt")) {
         _bp = BlockPos.containing(x, y, z);
         _bs = ((Block)CrustyChunksModBlocks.CHARRED_BLOCK.get()).defaultBlockState();
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
         if (world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == Blocks.AIR) {
            _bp = BlockPos.containing(x, y + 1.0D, z);
            _bs = Blocks.FIRE.defaultBlockState();
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
      }

      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:inceneratable")))) {
         _bp = BlockPos.containing(x, y, z);
         _bs = Blocks.FIRE.defaultBlockState();
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

      if (1 == Mth.nextInt(RandomSource.create(), 1, 30)) {
         if (!ModList.get().isLoaded("burnt")) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.AIR && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == Blocks.AIR) {
               CrustyChunksMod.queueServerWork(1, () -> {
                  BlockPos _bp = BlockPos.containing(x, y + 1.0D, z);
                  BlockState _bs = Blocks.FIRE.defaultBlockState();
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
               });
            }
         } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.AIR && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && world.getBlockState(BlockPos.containing(x, y + 1.0D, z)).getBlock() == Blocks.AIR) {
            CrustyChunksMod.queueServerWork(1, () -> {
               BlockPos _bp = BlockPos.containing(x, y + 1.0D, z);
               BlockState _bs = ((Block)ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("crusty_chunks:firestarter"))).getRandomElement(RandomSource.create()).orElseGet(() -> {
                  return Blocks.AIR;
               })).defaultBlockState();
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
            });
         }
      }

   }
}
