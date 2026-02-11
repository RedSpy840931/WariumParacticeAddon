package com.wariumapi.internal;

import com.wariumapi.armor.ArmorProfile;
import com.wariumapi.armor.ArmorService;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

final class NoopArmorService implements ArmorService {
   public void registerProfile(ResourceLocation id, ArmorProfile profile) {
   }

   public void bindProfile(ResourceLocation profileId, Item item) {
   }

   public void bindProfile(ResourceLocation profileId, Block block) {
   }

   public void bindProfileItemTag(ResourceLocation profileId, TagKey<Item> itemTag) {
   }

   public void bindProfileBlockTag(ResourceLocation profileId, TagKey<Block> blockTag) {
   }

   public Optional<ArmorProfile> getProfile(ResourceLocation id) {
      return Optional.empty();
   }

   public Optional<ArmorProfile> getProfile(ItemStack stack) {
      return Optional.empty();
   }

   public Optional<ArmorProfile> getProfile(BlockState state) {
      return Optional.empty();
   }

   public Collection<ResourceLocation> listProfiles() {
      return Collections.emptyList();
   }
}
