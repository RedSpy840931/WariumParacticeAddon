package com.wariumapi.event;

import com.wariumapi.vehicle.VehicleControlNode;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.Event;

public class VehicleControlNodeActivatedEvent extends Event {
   private final Level level;
   private final BlockPos nodePos;
   private final VehicleControlNode node;
   private final Player player;

   public VehicleControlNodeActivatedEvent(Level level, BlockPos nodePos, VehicleControlNode node, Player player) {
      this.level = level;
      this.nodePos = nodePos;
      this.node = node;
      this.player = player;
   }

   public Level getLevel() {
      return this.level;
   }

   public BlockPos getNodePos() {
      return this.nodePos;
   }

   public VehicleControlNode getNode() {
      return this.node;
   }

   public Player getPlayer() {
      return this.player;
   }
}
