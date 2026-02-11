package net.mcreator.crustychunks.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Locale;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintToolFireProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
      String BlockType = "";
      String result = "";
      if (1.0D <= itemstack.getOrCreateTag().getDouble("Fluid")) {
         BlockPos _bp;
         BlockState _bs;
         BlockState _bso;
         UnmodifiableIterator var13;
         Entry entry;
         Property _property;
         String var10000;
         ServerLevel _level;
         Level _level;
         BlockEntity _be;
         CompoundTag _bnbt;
         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:steel_armor_blocks")))) {
            if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("slab")) {
               BlockType = "_slab";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("optic")) {
               BlockType = "_optic";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("stairs")) {
               BlockType = "_stairs";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("trapdoor")) {
               BlockType = "_trapdoor";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("steel_layer")) {
               BlockType = "steel_layer";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("crusty_chunks:")) {
               BlockType = "";
            } else {
               BlockType = "NULL";
            }

            if (!itemstack.getOrCreateTag().getString("Color").equals("") && !itemstack.getOrCreateTag().getString("Color").equals("none") && !itemstack.getOrCreateTag().getString("Color").equals("remove")) {
               var10000 = itemstack.getOrCreateTag().getString("Color");
               result = "crusty_chunks:" + var10000 + "_armor" + BlockType;
            } else if ("steel_layer".equals(BlockType)) {
               result = "warium_extras:" + BlockType + "_" + itemstack.getOrCreateTag().getString("Color");
            }

            if (itemstack.getOrCreateTag().getString("Color").equals("remove")) {
               if (BlockType.equals("_optic")) {
                  result = "crusty_chunks:steel_optic";
               } else if (BlockType.equals("steel_layer")) {
                  result = "warium_extras:" + BlockType;
               } else {
                  result = "crusty_chunks:steel_plating" + BlockType;
               }
            }

            if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH))) != Blocks.AIR) {
               _bp = BlockPos.containing(x, y, z);
               _bs = ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH)))).defaultBlockState();
               _bso = world.getBlockState(_bp);
               var13 = _bso.getValues().entrySet().iterator();

               while(var13.hasNext()) {
                  entry = (Entry)var13.next();
                  _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                  if (_property != null && _bs.getValue(_property) != null) {
                     try {
                        _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                     } catch (Exception var20) {
                     }
                  }
               }

               _be = world.getBlockEntity(_bp);
               _bnbt = null;
               if (_be != null) {
                  _bnbt = _be.saveWithFullMetadata();
                  _be.setRemoved();
               }

               world.setBlock(_bp, _bs, 3);
               if (_bnbt != null) {
                  _be = world.getBlockEntity(_bp);
                  if (_be != null) {
                     try {
                        _be.load(_bnbt);
                     } catch (Exception var19) {
                     }
                  }
               }

               itemstack.getOrCreateTag().putDouble("Fluid", itemstack.getOrCreateTag().getDouble("Fluid") - 1.0D);
               if (world instanceof ServerLevel) {
                  _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.POOF, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.3D, 0.3D, 0.3D, 0.0D);
               }

               if (world instanceof Level) {
                  _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 1.0D));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 1.0D), false);
                  }
               }
            }
         }

         if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:aluminum_armor_blocks"))) && !ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("_dark_gray")) {
            if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("slab_wing")) {
               BlockType = "slab_wing";
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("crusty_chunks:full_armor")))) {
               BlockType = "_plating";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("plating_slab")) {
               BlockType = "_plating_slab";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("side_panel")) {
               BlockType = "_side_panel";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("stairs")) {
               BlockType = "_plating_stairs";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("trapdoor")) {
               BlockType = "_plating_trapdoor";
            } else if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("ac_barrel")) {
               BlockType = "_ac_barrel";
            } else {
               BlockType = "";
            }

            if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("control_surface")) {
               BlockType = "control_surface";
            }

            if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("vertical_control_surface")) {
               BlockType = "vertical_control_surface";
            }

            if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("control_surface_offset_top")) {
               BlockType = "control_surface_offset_top";
            }

            if (ForgeRegistries.BLOCKS.getKey(world.getBlockState(BlockPos.containing(x, y, z)).getBlock()).toString().contains("control_surface_offset_bottom")) {
               BlockType = "control_surface_offset_bottom";
            }

            if (!itemstack.getOrCreateTag().getString("Color").equals("") && !itemstack.getOrCreateTag().getString("Color").equals("none")) {
               if (!BlockType.contains("slab_wing") && !BlockType.contains("surface")) {
                  if (itemstack.getOrCreateTag().getString("Color").equals("remove")) {
                     result = "crusty_chunks:aluminum" + BlockType;
                     itemstack.getOrCreateTag().putDouble("Fluid", itemstack.getOrCreateTag().getDouble("Fluid") - 1.0D);
                  } else {
                     result = "crusty_chunks:aluminum" + BlockType + "_" + itemstack.getOrCreateTag().getString("Color");
                     itemstack.getOrCreateTag().putDouble("Fluid", itemstack.getOrCreateTag().getDouble("Fluid") - 1.0D);
                  }
               } else if (BlockType.contains("surface")) {
                  if (itemstack.getOrCreateTag().getString("Color").equals("remove")) {
                     result = "valkyrien_warium:" + BlockType;
                  } else {
                     var10000 = itemstack.getOrCreateTag().getString("Color");
                     result = "valkyrien_warium:" + var10000 + "_" + BlockType;
                  }
               } else if (itemstack.getOrCreateTag().getString("Color").equals("remove")) {
                  result = "valkyrien_warium:" + BlockType;
               } else {
                  result = "valkyrien_warium:" + BlockType + "_" + itemstack.getOrCreateTag().getString("Color");
               }

               if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH))) != Blocks.AIR) {
                  _bp = BlockPos.containing(x, y, z);
                  _bs = ((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(result.toLowerCase(Locale.ENGLISH)))).defaultBlockState();
                  _bso = world.getBlockState(_bp);
                  var13 = _bso.getValues().entrySet().iterator();

                  while(var13.hasNext()) {
                     entry = (Entry)var13.next();
                     _property = _bs.getBlock().getStateDefinition().getProperty(((Property)entry.getKey()).getName());
                     if (_property != null && _bs.getValue(_property) != null) {
                        try {
                           _bs = (BlockState)_bs.setValue(_property, (Comparable)entry.getValue());
                        } catch (Exception var18) {
                        }
                     }
                  }

                  _be = world.getBlockEntity(_bp);
                  _bnbt = null;
                  if (_be != null) {
                     _bnbt = _be.saveWithFullMetadata();
                     _be.setRemoved();
                  }

                  world.setBlock(_bp, _bs, 3);
                  if (_bnbt != null) {
                     _be = world.getBlockEntity(_bp);
                     if (_be != null) {
                        try {
                           _be.load(_bnbt);
                        } catch (Exception var17) {
                        }
                     }
                  }

                  itemstack.getOrCreateTag().putDouble("Fluid", itemstack.getOrCreateTag().getDouble("Fluid") - 1.0D);
                  if (world instanceof ServerLevel) {
                     _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.POOF, x + 0.5D, y + 0.5D, z + 0.5D, 5, 0.3D, 0.3D, 0.3D, 0.0D);
                  }

                  if (world instanceof Level) {
                     _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 1.0D));
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.puffer_fish.blow_out")), SoundSource.BLOCKS, 1.0F, (float)Mth.nextDouble(RandomSource.create(), 0.7D, 1.0D), false);
                     }
                  }
               }
            }
         }
      }

   }
}
