package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class OilFireboxUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (((<undefinedtype>)(new Object() {
         public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getFluidInTank(tank).getAmount());
               });
            }

            return _retval.get();
         }
      })).getFluidTankLevel(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
         public int getBlockTanks(LevelAccessor level, BlockPos pos) {
            AtomicInteger _retval = new AtomicInteger(0);
            BlockEntity _ent = level.getBlockEntity(pos);
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  _retval.set(capability.getTanks());
               });
            }

            return _retval.get();
         }
      })).getBlockTanks(world, BlockPos.containing(x, y, z))) > 0) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 3.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.BLOCKS, 3.0F, 1.0F, false);
            }
         }

         BlockEntity _blockEntity;
         BlockState _bs;
         Level _level;
         BlockPos _bp;
         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x + 1.0D, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x + 1.0D, y, z), "Heat") + 5.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x - 1.0D, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x - 1.0D, y, z), "Heat") + 5.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z + 1.0D);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z + 1.0D), "Heat") + 5.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z - 1.0D);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z - 1.0D), "Heat") + 5.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y + 1.0D, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("Heat", ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y + 1.0D, z), "Heat") + 5.0D);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.FLAME, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.2D, 0.3D, 0.2D, 0.01D);
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x + 0.5D, y + 0.5D, z + 0.5D, 10, 0.2D, 0.3D, 0.2D, 0.01D);
         }

         BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
         int _amount = ((<undefinedtype>)(new Object() {
            public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
               AtomicInteger _retval = new AtomicInteger(0);
               BlockEntity _ent = level.getBlockEntity(pos);
               if (_ent != null) {
                  _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                     _retval.set(capability.drain(amount, FluidAction.SIMULATE).getAmount());
                  });
               }

               return _retval.get();
            }
         })).drainTankSimulate(world, BlockPos.containing(x, y, z), 2);
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
               capability.drain(_amount, FluidAction.EXECUTE);
            });
         }
      }

   }
}
