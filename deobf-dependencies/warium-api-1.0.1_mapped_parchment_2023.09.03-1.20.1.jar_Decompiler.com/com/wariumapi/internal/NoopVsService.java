package com.wariumapi.internal;

import com.wariumapi.vs.ShipController;
import com.wariumapi.vs.ShipPartProfile;
import com.wariumapi.vs.VsService;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

final class NoopVsService implements VsService {
   public void registerShipPart(ResourceLocation id, ShipPartProfile profile) {
   }

   public void bindShipPart(ResourceLocation profileId, Item item) {
   }

   public void bindShipPart(ResourceLocation profileId, Block block) {
   }

   public void bindShipPartItemTag(ResourceLocation profileId, TagKey<Item> itemTag) {
   }

   public void bindShipPartBlockTag(ResourceLocation profileId, TagKey<Block> blockTag) {
   }

   public Optional<ShipPartProfile> getShipPartProfile(ResourceLocation id) {
      return Optional.empty();
   }

   public Optional<ShipPartProfile> getShipPartProfile(ItemStack stack) {
      return Optional.empty();
   }

   public Optional<ShipPartProfile> getShipPartProfile(BlockState state) {
      return Optional.empty();
   }

   public Optional<ShipController> getShipController(Level level, BlockPos pos) {
      return Optional.empty();
   }
}
