package com.wariumapi.armor;

import java.util.Collection;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public interface ArmorService {
   void registerProfile(ResourceLocation var1, ArmorProfile var2);

   void bindProfile(ResourceLocation var1, Item var2);

   void bindProfile(ResourceLocation var1, Block var2);

   void bindProfileItemTag(ResourceLocation var1, TagKey<Item> var2);

   void bindProfileBlockTag(ResourceLocation var1, TagKey<Block> var2);

   Optional<ArmorProfile> getProfile(ResourceLocation var1);

   Optional<ArmorProfile> getProfile(ItemStack var1);

   Optional<ArmorProfile> getProfile(BlockState var1);

   Collection<ResourceLocation> listProfiles();
}
