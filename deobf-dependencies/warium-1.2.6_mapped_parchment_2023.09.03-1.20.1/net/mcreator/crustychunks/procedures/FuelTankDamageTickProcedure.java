package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class FuelTankDamageTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (0 < ((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x, y, z)))) {
         ServerLevel _level;
         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 0.5D, z + 0.5D, 1, 0.2D, 0.2D, 0.2D, 0.0D);
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
         })).drainTankSimulate(world, BlockPos.containing(x, y, z), 10);
         if (_ent != null) {
            _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
               capability.drain(_amount, FluidAction.EXECUTE);
            });
         }

         if (((<undefinedtype>)(new Object() {
            public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
               BlockEntity blockEntity = level.getBlockEntity(pos);
               return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                  return fluidHandler.getFluidInTank(tank).copy();
               }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
            }
         })).getFluidInTank(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
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
         })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), 1)) || ((<undefinedtype>)(new Object() {
            public FluidStack getFluidInTank(LevelAccessor level, BlockPos pos, int tank) {
               BlockEntity blockEntity = level.getBlockEntity(pos);
               return blockEntity != null ? (FluidStack)blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).map((fluidHandler) -> {
                  return fluidHandler.getFluidInTank(tank).copy();
               }).orElse(FluidStack.EMPTY) : FluidStack.EMPTY;
            }
         })).getFluidInTank(world, BlockPos.containing(x, y, z), ((<undefinedtype>)(new Object() {
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
         })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.PETROLIUM.get(), 1))) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, (float)(2 - ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.containing(x, y, z))) / 1000));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, (float)(2 - ((<undefinedtype>)(new Object() {
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
                  })).getBlockTanks(world, BlockPos.containing(x, y, z))) / 1000), false);
               }
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, x + 0.5D, y + 0.5D, z + 0.5D, 4, 0.2D, 0.2D, 0.2D, 0.0D);
            }

            if (world instanceof ServerLevel) {
               _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.RISING_FLAME.get(), x + 0.5D, y + 0.5D, z + 0.5D, 1, 0.2D, 0.2D, 0.2D, 0.0D);
            }

            DamagesProcedure.execute(world, x + (double)Mth.nextInt(RandomSource.create(), -1, 1), y + (double)Mth.nextInt(RandomSource.create(), -1, 1), z + (double)Mth.nextInt(RandomSource.create(), -1, 1));
         }
      }

   }
}
