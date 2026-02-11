package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class FuelTankDamagedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.FUEL_TANK.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.FUEL_TANK_MODULE.get() || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.FUEL_TANK_INPUT.get()) {
         BlockPos _bp = BlockPos.containing(x, y, z);
         BlockState _bs = ((Block)CrustyChunksModBlocks.DAMAGEDFUELTANK.get()).defaultBlockState();
         BlockState _bso = world.getBlockState(_bp);
         UnmodifiableIterator var10 = _bso.getValues().entrySet().iterator();

         while(var10.hasNext()) {
            Entry<Property<?>, Comparable<?>> entry = (Entry)var10.next();
            Property _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
            if (_property != null && _bs.getValue(_property) != null) {
               try {
                  _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
               } catch (Exception var15) {
               }
            }
         }

         BlockEntity _be = world.getBlockEntity(_bp);
         CompoundTag _bnbt = null;
         if (_be != null) {
            _bnbt = _be.saveWithFullMetadata();
            _be.setRemoved();
         }

         world.setBlock(_bp, _bs, 3);
         if (_bnbt != null) {
            _be = world.getBlockEntity(_bp);
            if (_be != null) {
               try {
                  _be.load(_bnbt);
               } catch (Exception var14) {
               }
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.FLAME, x + 0.5D, y + 0.5D, z + 0.5D, 15, 0.25D, 0.25D, 0.25D, 0.1D);
         }
      }

   }
}
