package com.wariumapi.munitions;

import com.wariumapi.munitions.profile.MunitionProfile;
import com.wariumapi.munitions.profile.WarheadProfile;
import java.util.Collection;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface MunitionsService {
   void registerWarhead(ResourceLocation var1, WarheadProfile var2);

   void registerMunition(ResourceLocation var1, MunitionProfile var2);

   void bindMunition(ResourceLocation var1, EntityType<?> var2);

   void bindMunition(ResourceLocation var1, Item var2);

   void bindMunitionItemTag(ResourceLocation var1, TagKey<Item> var2);

   Optional<WarheadProfile> getWarhead(ResourceLocation var1);

   Optional<MunitionProfile> getMunition(ResourceLocation var1);

   Optional<MunitionProfile> getMunition(Entity var1);

   Optional<MunitionProfile> getMunition(ItemStack var1);

   Collection<ResourceLocation> listMunitions();

   Collection<ResourceLocation> listWarheads();
}
