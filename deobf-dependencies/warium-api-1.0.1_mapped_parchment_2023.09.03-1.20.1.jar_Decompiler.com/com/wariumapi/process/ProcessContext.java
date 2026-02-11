package com.wariumapi.process;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public record ProcessContext(Level level, BlockPos pos, ProcessRecipe recipe) {
   public ProcessContext(Level level, BlockPos pos, ProcessRecipe recipe) {
      this.level = level;
      this.pos = pos;
      this.recipe = recipe;
   }

   public Level level() {
      return this.level;
   }

   public BlockPos pos() {
      return this.pos;
   }

   public ProcessRecipe recipe() {
      return this.recipe;
   }
}
