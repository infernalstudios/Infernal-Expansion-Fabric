package org.infernalstudios.infernalexp.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MagmaBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public class BasalticMagmaBlock extends MagmaBlock {

    public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

    public BasalticMagmaBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    @Override
    public BlockState rotate(BlockState blockState, BlockRotation blockRotation) {
        return switch (blockRotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (blockState.get(AXIS)) {
                case X -> blockState.with(AXIS, Direction.Axis.Z);
                case Z -> blockState.with(AXIS, Direction.Axis.X);
                default -> blockState;
            };
            default -> blockState;
        };
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(AXIS);
    }

    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return this.getDefaultState().with(AXIS, itemPlacementContext.getPlayerFacing().getAxis());
    }
}
