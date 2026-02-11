package net.mcreator.crustychunks.procedures;

import net.mcreator.crustychunks.init.CrustyChunksModBlocks;
import net.mcreator.crustychunks.init.CrustyChunksModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class DirectionUpdateProcedure {
   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == CrustyChunksModItems.AIMER.get() && (itemstack.getOrCreateTag().getDouble("POSX") != 0.0D || itemstack.getOrCreateTag().getDouble("POSY") != 0.0D || itemstack.getOrCreateTag().getDouble("POSZ") != 0.0D) && (world.getBlockState(BlockPos.containing(itemstack.getOrCreateTag().getDouble("POSX"), itemstack.getOrCreateTag().getDouble("POSY"), itemstack.getOrCreateTag().getDouble("POSZ"))).is(BlockTags.create(new ResourceLocation("crusty_chunks:cannon"))) || world.getBlockState(BlockPos.containing(itemstack.getOrCreateTag().getDouble("POSX"), itemstack.getOrCreateTag().getDouble("POSY"), itemstack.getOrCreateTag().getDouble("POSZ"))).getBlock() == CrustyChunksModBlocks.AIMER_NODE.get())) {
            AimerProcedureProcedure.execute(world, itemstack.getOrCreateTag().getDouble("POSX"), itemstack.getOrCreateTag().getDouble("POSY"), itemstack.getOrCreateTag().getDouble("POSZ"), entity, itemstack);
         }

      }
   }
}
