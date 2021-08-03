package org.infernalstudios.infernalexp.block.templates;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.listener.GameEventListener;

import org.jetbrains.annotations.Nullable;

/**
 * Copy of the net.minecraft.block.WallMountedBlock class that extends org.infernalstudios.block.templates.HorizontalFacingBlockEntity
 * to allow for block entity creation.
 */

public class WallMountedBlockWithEntity extends HorizontalFacingBlockWithEntity{
    public static final EnumProperty<WallMountLocation> FACE;

    protected WallMountedBlockWithEntity(Settings settings) {
        super(settings);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return canPlaceAt(world, pos, getDirection(state).getOpposite());
    }

    public static boolean canPlaceAt(WorldView world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction);
        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction.getOpposite());
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction[] var2 = ctx.getPlacementDirections();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Direction direction = var2[var4];
            BlockState blockState2;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockState2 = this.getDefaultState().with(FACE, direction == Direction.UP ? WallMountLocation.CEILING : WallMountLocation.FLOOR).with(HORIZONTAL_FACING, ctx.getPlayerFacing());
            } else {
                blockState2 = this.getDefaultState().with(FACE, WallMountLocation.WALL).with(HORIZONTAL_FACING, direction.getOpposite());
            }

            if (blockState2.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
                return blockState2;
            }
        }

        return null;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return getDirection(state).getOpposite() == direction && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected static Direction getDirection(BlockState state) {
        switch(state.get(FACE)) {
            case CEILING:
                return Direction.DOWN;
            case FLOOR:
                return Direction.UP;
            default:
                return state.get(HORIZONTAL_FACING);
        }
    }

    static {
        FACE = Properties.WALL_MOUNT_LOCATION;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getGameEventListener(World world, T blockEntity) {
        return null;
    }
}
