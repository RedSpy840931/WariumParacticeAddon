package com.wariumapi.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public record WrenchContext(Level level, Player player, BlockPos pos, BlockState state, ItemStack tool, Direction face, InteractionHand hand, boolean isSneaking) {
   public WrenchContext(Level level, Player player, BlockPos pos, BlockState state, ItemStack tool, Direction face, InteractionHand hand, boolean isSneaking) {
      this.level = level;
      this.player = player;
      this.pos = pos;
      this.state = state;
      this.tool = tool;
      this.face = face;
      this.hand = hand;
      this.isSneaking = isSneaking;
   }

   public Level level() {
      return this.level;
   }

   public Player player() {
      return this.player;
   }

   public BlockPos pos() {
      return this.pos;
   }

   public BlockState state() {
      return this.state;
   }

   public ItemStack tool() {
      return this.tool;
   }

   public Direction face() {
      return this.face;
   }

   public InteractionHand hand() {
      return this.hand;
   }

   public boolean isSneaking() {
      return this.isSneaking;
   }
}
