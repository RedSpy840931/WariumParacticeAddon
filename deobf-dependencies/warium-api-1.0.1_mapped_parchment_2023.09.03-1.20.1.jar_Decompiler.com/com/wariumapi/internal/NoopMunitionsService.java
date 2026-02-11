package com.wariumapi.internal;

import com.wariumapi.munitions.MunitionsService;
import com.wariumapi.munitions.profile.MunitionProfile;
import com.wariumapi.munitions.profile.WarheadProfile;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

final class NoopMunitionsService implements MunitionsService {
   public void registerWarhead(ResourceLocation id, WarheadProfile profile) {
   }

   public void registerMunition(ResourceLocation id, MunitionProfile profile) {
   }

   public void bindMunition(ResourceLocation profileId, EntityType<?> entityType) {
   }

   public void bindMunition(ResourceLocation profileId, Item item) {
   }

   public void bindMunitionItemTag(ResourceLocation profileId, TagKey<Item> itemTag) {
   }

   public Optional<WarheadProfile> getWarhead(ResourceLocation id) {
      return Optional.empty();
   }

   public Optional<MunitionProfile> getMunition(ResourceLocation id) {
      return Optional.empty();
   }

   public Optional<MunitionProfile> getMunition(Entity entity) {
      return Optional.empty();
   }

   public Optional<MunitionProfile> getMunition(ItemStack stack) {
      return Optional.empty();
   }

   public Collection<ResourceLocation> listMunitions() {
      return Collections.emptyList();
   }

   public Collection<ResourceLocation> listWarheads() {
      return Collections.emptyList();
   }
}
