package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.entity.SmokeStackSmokeEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModEntities;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class EngineCyllinderOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      boolean found = false;
      double sx = 0.0D;
      double sy = 0.0D;
      double sz = 0.0D;
      double power = 0.0D;
      double smokestack = 0.0D;
      smokestack = 1.0D;

      for(int index0 = 0; index0 < 25; ++index0) {
         if (CrustyChunksModBlocks.LARGE_ENGINE_SMOKESTACK.get() == world.getBlockState(BlockPos.containing(x, y + smokestack, z)).getBlock()) {
            ++smokestack;
         }
      }

      power = 0.0D;
      BlockEntity _blockEntity;
      BlockState _bs;
      Level _level;
      BlockPos _bp;
      if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putString("FuelType", "Diesel");
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

      Level _level;
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
      })).getBlockTanks(world, BlockPos.containing(x, y, z))) > 0 && ((<undefinedtype>)(new Object() {
         public String getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
         }
      })).getValue(world, BlockPos.containing(x, y, z), "FuelType").equals("Diesel") && ((<undefinedtype>)(new Object() {
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
      })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.DIESEL.get(), 1))) {
         label100: {
            if (world instanceof Level) {
               _level = (Level)world;
               if (_level.hasNeighborSignal(BlockPos.containing(x, y, z))) {
                  power = 50.0D;
                  break label100;
               }
            }

            if (((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "ControlX"), ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "ControlY"), ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "ControlZ")), "Throttle") > 0.0D) {
               power = ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "ControlX"), ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "ControlY"), ((<undefinedtype>)(new Object() {
                  public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                     BlockEntity blockEntity = world.getBlockEntity(pos);
                     return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
                  }
               })).getValue(world, BlockPos.containing(x, y, z), "ControlZ")), "Throttle") * 5.0D;
            } else {
               power = 0.0D;
            }
         }

         if (0.0D >= ((<undefinedtype>)(new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
            }
         })).getValue(world, BlockPos.containing(x, y, z), "FuelQue")) {
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
            })).drainTankSimulate(world, BlockPos.containing(x + sx, y + sy, z + sz), (int)(power / 5.0D));
            if (_ent != null) {
               _ent.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                  capability.drain(_amount, FluidAction.EXECUTE);
               });
            }

            if (!world.isClientSide()) {
               _bp = BlockPos.containing(x, y, z);
               _blockEntity = world.getBlockEntity(_bp);
               _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("FuelQue", 20.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }
         }
      }

      ServerLevel _level;
      if (0.0D < power) {
         if (world instanceof Level) {
            _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, 5.0F, (float)(0.3D + power / 50.0D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D)));
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("crusty_chunks:engine")), SoundSource.NEUTRAL, 5.0F, (float)(0.3D + power / 50.0D + Mth.nextDouble(RandomSource.create(), -0.05D, 0.05D)), false);
            }
         }

         if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
               public Projectile getArrow(Level level, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new SmokeStackSmokeEntity((EntityType)CrustyChunksModEntities.SMOKE_STACK_SMOKE.get(), level);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setSilent(true);
                  return entityToSpawn;
               }
            })).getArrow(_level, 5.0F, 1);
            _entityToSpawn.setPos(x + 0.5D, y + smokestack, z + 0.5D);
            _entityToSpawn.shoot(0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            _level.addFreshEntity(_entityToSpawn);
         }

         if (!world.isClientSide()) {
            _bp = BlockPos.containing(x, y, z);
            _blockEntity = world.getBlockEntity(_bp);
            _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putDouble("PistonPower", power);
            }

            if (world instanceof Level) {
               _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }
      } else if (!world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("PistonPower", 0.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

      if (0.0D < ((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "FuelQue") && !world.isClientSide()) {
         _bp = BlockPos.containing(x, y, z);
         _blockEntity = world.getBlockEntity(_bp);
         _bs = world.getBlockState(_bp);
         if (_blockEntity != null) {
            _blockEntity.getPersistentData().putDouble("FuelQue", ((<undefinedtype>)(new Object() {
               public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                  BlockEntity blockEntity = world.getBlockEntity(pos);
                  return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
               }
            })).getValue(world, BlockPos.containing(x, y, z), "FuelQue") - 1.0D);
         }

         if (world instanceof Level) {
            _level = (Level)world;
            _level.sendBlockUpdated(_bp, _bs, _bs, 3);
         }
      }

      if (((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return blockEntity != null ? blockEntity.getPersistentData().getDouble(tag) : -1.0D;
         }
      })).getValue(world, BlockPos.containing(x, y, z), "Damage") >= 2.0D && world instanceof ServerLevel) {
         _level = (ServerLevel)world;
         _level.sendParticles((SimpleParticleType)CrustyChunksModParticleTypes.SMOKE.get(), x + 0.5D, y + 1.1D, z + 0.5D, 1, 0.0D, 1.0D, 0.0D, 0.1D);
      }

   }
}
