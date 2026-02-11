package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.crustychunks.init.CrustyChunksModFluids;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidDrainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack Bucket = ItemStack.EMPTY;
         if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Fluid").equals("Oil") && ((<undefinedtype>)(new Object() {
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
         })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.OIL.get(), 1))) {
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.OIL_BUCKET.get())).copy();
         } else if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Fluid").equals("Diesel") && ((<undefinedtype>)(new Object() {
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
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.DIESEL_BUCKET.get())).copy();
         } else if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Fluid").equals("Kerosene") && ((<undefinedtype>)(new Object() {
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
         })).getBlockTanks(world, BlockPos.containing(x, y, z))).isFluidEqual(new FluidStack((Fluid)CrustyChunksModFluids.KEROSENE.get(), 1))) {
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.KEROSENE_BUCKET.get())).copy();
         } else if (((<undefinedtype>)(new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
               BlockEntity blockEntity = world.getBlockEntity(pos);
               return blockEntity != null ? blockEntity.getPersistentData().getString(tag) : "";
            }
         })).getValue(world, BlockPos.containing(x, y, z), "Fluid").equals("Petrolium") && ((<undefinedtype>)(new Object() {
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
            Bucket = (new ItemStack((ItemLike)CrustyChunksModItems.PETROLIUM_BUCKET.get())).copy();
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
         })).getBlockTanks(world, BlockPos.containing(x, y, z))).getAmount() >= 1000) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == Items.BUCKET) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               var10000.shrink(1);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, entity.getX(), entity.getY(), entity.getZ(), Bucket);
                  entityToSpawn.setPickUpDelay(5);
                  _level.addFreshEntity(entityToSpawn);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.fill")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               int _drain = 1000;
               BlockEntity blockEntity = world.getBlockEntity(BlockPos.containing(x, y, z));
               if (blockEntity != null) {
                  blockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, (Direction)null).ifPresent((capability) -> {
                     capability.drain(_drain, FluidAction.EXECUTE);
                  });
               }
            }
         }

      }
   }
}
