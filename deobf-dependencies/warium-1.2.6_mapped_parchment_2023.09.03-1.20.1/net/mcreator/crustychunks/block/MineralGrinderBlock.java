package net.mcreator.crustychunks.block;

import io.netty.buffer.Unpooled;
import net.mcreator.crustychunks.block.entity.MineralGrinderBlockEntity;
import net.mcreator.crustychunks.world.inventory.MineralGrinderGUIMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

public class MineralGrinderBlock extends Block implements EntityBlock {
   public MineralGrinderBlock() {
      super(Properties.of().sound(SoundType.ANVIL).strength(1.0F, 10.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
         return false;
      }));
   }

   public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.or(box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), new VoxelShape[]{box(2.0D, 8.0D, 2.0D, 14.0D, 16.0D, 14.0D), box(7.0D, 16.0D, 7.0D, 9.0D, 24.0D, 9.0D), box(7.0D, 24.0D, 4.0D, 9.0D, 26.0D, 12.0D)});
   }

   public InteractionResult use(BlockState blockstate, Level world, final BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.use(blockstate, world, pos, entity, hand, hit);
      if (entity instanceof ServerPlayer) {
         ServerPlayer player = (ServerPlayer)entity;
         NetworkHooks.openScreen(player, new MenuProvider() {
            public Component getDisplayName() {
               return Component.literal("Mineral Grinder");
            }

            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
               return new MineralGrinderGUIMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).writeBlockPos(pos));
            }
         }, pos);
      }

      return InteractionResult.SUCCESS;
   }

   public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
      BlockEntity tileEntity = worldIn.getBlockEntity(pos);
      MenuProvider var10000;
      if (tileEntity instanceof MenuProvider) {
         MenuProvider menuProvider = (MenuProvider)tileEntity;
         var10000 = menuProvider;
      } else {
         var10000 = null;
      }

      return var10000;
   }

   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new MineralGrinderBlockEntity(pos, state);
   }

   public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.getBlock() != newState.getBlock()) {
         BlockEntity blockEntity = world.getBlockEntity(pos);
         if (blockEntity instanceof MineralGrinderBlockEntity) {
            MineralGrinderBlockEntity be = (MineralGrinderBlockEntity)blockEntity;
            Containers.dropContents(world, pos, be);
            world.updateNeighbourForOutputSignal(pos, this);
         }

         super.onRemove(state, world, pos, newState, isMoving);
      }

   }

   public boolean hasAnalogOutputSignal(BlockState state) {
      return true;
   }

   public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
      BlockEntity tileentity = world.getBlockEntity(pos);
      if (tileentity instanceof MineralGrinderBlockEntity) {
         MineralGrinderBlockEntity be = (MineralGrinderBlockEntity)tileentity;
         return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
      } else {
         return 0;
      }
   }
}
