package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class EnergyMeterTestProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               int var10001 = ((<undefinedtype>)(new Object() {
                  public int getEnergyStored(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getEnergyStored());
                        });
                     }

                     return _retval.get();
                  }
               })).getEnergyStored(world, BlockPos.containing(x, y, z));
               _player.displayClientMessage(Component.literal(var10001 + "/" + ((<undefinedtype>)(new Object() {
                  public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
                     AtomicInteger _retval = new AtomicInteger(0);
                     BlockEntity _ent = level.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ENERGY, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getMaxEnergyStored());
                        });
                     }

                     return _retval.get();
                  }
               })).getMaxEnergyStored(world, BlockPos.containing(x, y, z)) + " FE"), true);
            }
         }

      }
   }
}
