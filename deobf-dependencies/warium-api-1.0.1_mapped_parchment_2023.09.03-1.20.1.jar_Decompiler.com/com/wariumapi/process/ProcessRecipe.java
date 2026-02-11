package com.wariumapi.process;

import net.minecraft.resources.ResourceLocation;

public record ProcessRecipe(ResourceLocation id, ResourceLocation processType, ResourceLocation inputId, boolean inputIsTag, ResourceLocation processItem, ResourceLocation resultItem, int runs) {
   public ProcessRecipe(ResourceLocation id, ResourceLocation processType, ResourceLocation inputId, boolean inputIsTag, ResourceLocation processItem, ResourceLocation resultItem, int runs) {
      this.id = id;
      this.processType = processType;
      this.inputId = inputId;
      this.inputIsTag = inputIsTag;
      this.processItem = processItem;
      this.resultItem = resultItem;
      this.runs = runs;
   }

   public ResourceLocation id() {
      return this.id;
   }

   public ResourceLocation processType() {
      return this.processType;
   }

   public ResourceLocation inputId() {
      return this.inputId;
   }

   public boolean inputIsTag() {
      return this.inputIsTag;
   }

   public ResourceLocation processItem() {
      return this.processItem;
   }

   public ResourceLocation resultItem() {
      return this.resultItem;
   }

   public int runs() {
      return this.runs;
   }
}
