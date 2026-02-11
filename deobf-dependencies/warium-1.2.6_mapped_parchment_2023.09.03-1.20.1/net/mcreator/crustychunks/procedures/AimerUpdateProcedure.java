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

public class AimerUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double Multiplier = 0.0D;
         double Pitch = 0.0D;
         double Yaw = 0.0D;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getOffhandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == CrustyChunksModItems.AIMER.get()) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:cannon"))) || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == CrustyChunksModBlocks.AIMER_NODE.get()) {
               itemstack.getOrCreateTag().putDouble("POSX", x);
               itemstack.getOrCreateTag().putDouble("POSY", y);
               itemstack.getOrCreateTag().putDouble("POSZ", z);
            }
         } else {
            AimerProcedureProcedure.execute(world, x, y, z, entity, itemstack);
         }

      }
   }
}
