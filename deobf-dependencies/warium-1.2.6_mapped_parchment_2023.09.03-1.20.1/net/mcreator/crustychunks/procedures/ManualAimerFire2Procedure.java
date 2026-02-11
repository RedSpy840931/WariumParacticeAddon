package net.mcreator.crustychunks.procedures;

import javax.annotation.Nullable;
import net.mcreator.crustychunks.entity.SeatEntityEntity;
import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ManualAimerFire2Procedure {
   @SubscribeEvent
   public static void onLeftClickBlock(LeftClickBlock event) {
      execute(event, event.getLevel(), event.getEntity());
   }

   public static void execute(LevelAccessor world, Entity entity) {
      execute((Event)null, world, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.getRootVehicle() instanceof SeatEntityEntity && world.getBlockState(BlockPos.containing(entity.getRootVehicle().getX(), entity.getRootVehicle().getY(), entity.getRootVehicle().getZ())).getBlock() == CrustyChunksModBlocks.MANUAL_AIMER.get()) {
            int _value = 5;
            BlockPos _pos = BlockPos.containing(entity.getRootVehicle().getX(), entity.getRootVehicle().getY(), entity.getRootVehicle().getZ());
            BlockState _bs = world.getBlockState(_pos);
            Property var7 = _bs.getBlock().getStateDefinition().getProperty("firing");
            if (var7 instanceof IntegerProperty) {
               IntegerProperty _integerProp = (IntegerProperty)var7;
               if (_integerProp.getPossibleValues().contains(Integer.valueOf(_value))) {
                  world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, Integer.valueOf(_value)), 3);
               }
            }
         }

      }
   }
}
