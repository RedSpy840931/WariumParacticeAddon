package net.mcreator.crustychunks.block;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OrdinanceFissionInitiatorHeadBlock extends Block {
   public static final DirectionProperty FACING;
   public static final EnumProperty<AttachFace> FACE;

   public OrdinanceFissionInitiatorHeadBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.ANVIL).strength(1.0F, 5.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> {
         return false;
      }));
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(FACE, AttachFace.WALL));
   }

   public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.translatable("block.crusty_chunks.ordinance_fission_initiator_head.description_0"));
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
      VoxelShape var10000;
      switch((Direction)state.getValue(FACING)) {
      case NORTH:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), box(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            return var10000;
         case WALL:
            var10000 = Shapes.or(box(2.0D, 2.0D, 2.0D, 14.0D, 14.0D, 16.0D), box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 2.0D));
            return var10000;
         case CEILING:
            var10000 = Shapes.or(box(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), box(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      case EAST:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), box(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            return var10000;
         case WALL:
            var10000 = Shapes.or(box(0.0D, 2.0D, 2.0D, 14.0D, 14.0D, 14.0D), box(14.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D));
            return var10000;
         case CEILING:
            var10000 = Shapes.or(box(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), box(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      case WEST:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), box(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            return var10000;
         case WALL:
            var10000 = Shapes.or(box(2.0D, 2.0D, 2.0D, 16.0D, 14.0D, 14.0D), box(0.0D, 5.0D, 5.0D, 2.0D, 11.0D, 11.0D));
            return var10000;
         case CEILING:
            var10000 = Shapes.or(box(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), box(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            return var10000;
         default:
            throw new IncompatibleClassChangeError();
         }
      default:
         switch((AttachFace)state.getValue(FACE)) {
         case FLOOR:
            var10000 = Shapes.or(box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), box(5.0D, 14.0D, 5.0D, 11.0D, 16.0D, 11.0D));
            break;
         case WALL:
            var10000 = Shapes.or(box(2.0D, 2.0D, 0.0D, 14.0D, 14.0D, 14.0D), box(5.0D, 5.0D, 14.0D, 11.0D, 11.0D, 16.0D));
            break;
         case CEILING:
            var10000 = Shapes.or(box(2.0D, 2.0D, 2.0D, 14.0D, 16.0D, 14.0D), box(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D));
            break;
         default:
            throw new IncompatibleClassChangeError();
         }
      }

      return var10000;
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING, FACE});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACE, this.faceForDirection(context.getNearestLookingDirection()))).setValue(FACING, context.getHorizontalDirection().getOpposite());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   private AttachFace faceForDirection(Direction direction) {
      if (direction.getAxis() == Axis.Y) {
         return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
      } else {
         return AttachFace.WALL;
      }
   }

   static {
      FACING = HorizontalDirectionalBlock.FACING;
      FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
   }
}
