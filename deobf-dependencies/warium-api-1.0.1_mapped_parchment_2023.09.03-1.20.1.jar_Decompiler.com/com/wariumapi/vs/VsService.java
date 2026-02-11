package com.wariumapi.vs;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public interface VsService {
   void registerShipPart(ResourceLocation var1, ShipPartProfile var2);

   void bindShipPart(ResourceLocation var1, Item var2);

   void bindShipPart(ResourceLocation var1, Block var2);

   void bindShipPartItemTag(ResourceLocation var1, TagKey<Item> var2);

   void bindShipPartBlockTag(ResourceLocation var1, TagKey<Block> var2);

   Optional<ShipPartProfile> getShipPartProfile(ResourceLocation var1);

   Optional<ShipPartProfile> getShipPartProfile(ItemStack var1);

   Optional<ShipPartProfile> getShipPartProfile(BlockState var1);

   Optional<ShipController> getShipController(Level var1, BlockPos var2);
}
