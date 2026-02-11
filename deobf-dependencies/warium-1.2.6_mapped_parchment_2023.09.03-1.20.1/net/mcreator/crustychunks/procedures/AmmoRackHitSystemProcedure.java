package net.mcreator.crustychunks.procedures;

import java.util.concurrent.atomic.AtomicReference;
import net.mcreator.crustychunks.CrustyChunksMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class AmmoRackHitSystemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockState targetblock = Blocks.AIR.defaultBlockState();
      boolean explosive = false;
      double ZOffset = 0.0D;
      double checkslotID = 0.0D;
      double ItemCount = 0.0D;
      double YOffset = 0.0D;
      double XOffset = 0.0D;
      double explosivetimer = 0.0D;
      world.getBlockState(BlockPos.containing(x, y, z));
      explosive = false;
      checkslotID = 0.0D;
      int index1;
      if (((<undefinedtype>)(new Object() {
         public int getContainerSize(LevelAccessor world, BlockPos pos) {
            BlockEntity _ent = world.getBlockEntity(pos);
            if (_ent != null && _ent instanceof BaseContainerBlockEntity) {
               BaseContainerBlockEntity _block = (BaseContainerBlockEntity)_ent;
               return _block.getContainerSize();
            } else {
               return 0;
            }
         }

         public int getAmount(LevelAccessor world, BlockPos pos) {
            Block block = world.getBlockState(pos).getBlock();
            if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
               boolean var10000;
               label17: {
                  Property var6 = block.getStateDefinition().getProperty("type");
                  if (var6 instanceof EnumProperty) {
                     EnumProperty _getep5 = (EnumProperty)var6;
                     if (world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE")) {
                        var10000 = true;
                        break label17;
                     }
                  }

                  var10000 = false;
               }

               boolean isSingle = var10000;
               if (!isSingle) {
                  return this.getContainerSize(world, pos) * 2;
               }
            }

            return this.getContainerSize(world, pos);
         }
      })).getAmount(world, new BlockPos((int)x, (int)y, (int)z)) > 0) {
         for(index1 = 0; index1 < ((<undefinedtype>)(new Object() {
            public int getContainerSize(LevelAccessor world, BlockPos pos) {
               BlockEntity _ent = world.getBlockEntity(pos);
               if (_ent != null && _ent instanceof BaseContainerBlockEntity) {
                  BaseContainerBlockEntity _block = (BaseContainerBlockEntity)_ent;
                  return _block.getContainerSize();
               } else {
                  return 0;
               }
            }

            public int getAmount(LevelAccessor world, BlockPos pos) {
               Block block = world.getBlockState(pos).getBlock();
               if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
                  boolean var10000;
                  label17: {
                     Property var6 = block.getStateDefinition().getProperty("type");
                     if (var6 instanceof EnumProperty) {
                        EnumProperty _getep5 = (EnumProperty)var6;
                        if (world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE")) {
                           var10000 = true;
                           break label17;
                        }
                     }

                     var10000 = false;
                  }

                  boolean isSingle = var10000;
                  if (!isSingle) {
                     return this.getContainerSize(world, pos) * 2;
                  }
               }

               return this.getContainerSize(world, pos);
            }
         })).getAmount(world, new BlockPos((int)x, (int)y, (int)z)); ++index1) {
            if (((<undefinedtype>)(new Object() {
               public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                  AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.EMPTY);
                  BlockEntity _ent = world.getBlockEntity(pos);
                  if (_ent != null) {
                     _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        _retval.set(capability.getStackInSlot(slotid).copy());
                     });
                  }

                  return (ItemStack)_retval.get();
               }
            })).getItemStack(world, BlockPos.containing(x, y, z), (int)checkslotID).is(ItemTags.create(new ResourceLocation("crusty_chunks:containerexplosive")))) {
               ItemCount = ItemCount + 1.0D + (double)(Math.round((float)((<undefinedtype>)(new Object() {
                  public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
                     AtomicReference<ItemStack> _retval = new AtomicReference(ItemStack.EMPTY);
                     BlockEntity _ent = world.getBlockEntity(pos);
                     if (_ent != null) {
                        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                           _retval.set(capability.getStackInSlot(slotid).copy());
                        });
                     }

                     return (ItemStack)_retval.get();
                  }
               })).getItemStack(world, BlockPos.containing(x, y, z), (int)checkslotID).getCount()) / 10);
               explosive = true;
            }

            ++checkslotID;
         }
      }

      if (explosive) {
         if (ItemCount >= 100.0D) {
            GiantExplosionProcedure.execute(world, x, y, z);
         } else if (ItemCount >= 50.0D) {
            HugeExplosionProcedure.execute(world, x, y, z);
         } else if (ItemCount >= 25.0D) {
            LargeExplosionProcedure.execute(world, x, y, z);
         } else if (ItemCount >= 10.0D) {
            MediumExplosionProcedure.execute(world, x, y, z);
         } else {
            for(index1 = 0; index1 < (int)ItemCount; ++index1) {
               explosivetimer += 4.0D;
               CrustyChunksMod.queueServerWork((int)explosivetimer, () -> {
                  if (1 == Mth.nextInt(RandomSource.create(), 1, 5)) {
                     SmallExplosionProcedure.execute(world, x, y, z);
                  } else {
                     SmallFraglessProcedure.execute(world, x, y, z);
                  }

               });
            }
         }
      }

   }
}
