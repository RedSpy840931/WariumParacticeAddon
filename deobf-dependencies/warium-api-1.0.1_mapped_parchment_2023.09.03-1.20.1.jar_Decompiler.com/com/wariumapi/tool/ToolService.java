package com.wariumapi.tool;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public interface ToolService {
   boolean isWrench(ItemStack var1);

   void registerWrench(ItemLike var1);

   void registerWrenchTag(TagKey<Item> var1);
}
