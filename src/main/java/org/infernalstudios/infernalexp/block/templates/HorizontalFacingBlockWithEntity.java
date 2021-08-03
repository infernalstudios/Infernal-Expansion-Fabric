package org.infernalstudios.infernalexp.block.templates;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

/**
 * Copy of the net.minecraft.block.HorizontalFacingBlock that extends net.minecraft.block.BlockWithEntity
 * instead of net.minecraft.block.Block to allow creation of BlockEntities.
 */

public abstract class HorizontalFacingBlockWithEntity extends BlockWithEntity {

    public static final DirectionProperty HORIZONTAL_FACING;

    protected HorizontalFacingBlockWithEntity(Settings settings) {
        super(settings);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(HORIZONTAL_FACING, rotation.rotate((Direction)state.get(HORIZONTAL_FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(HORIZONTAL_FACING)));
    }

    static {
        HORIZONTAL_FACING = Properties.HORIZONTAL_FACING;
    }
}
