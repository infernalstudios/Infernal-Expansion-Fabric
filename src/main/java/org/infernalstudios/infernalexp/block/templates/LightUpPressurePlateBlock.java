package org.infernalstudios.infernalexp.block.templates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public class LightUpPressurePlateBlock extends PressurePlateBlock {

    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty LIT = Properties.LIT;

    public LightUpPressurePlateBlock(ActivationRule type, Settings settings) {
        super(type, settings);
        this.setDefaultState(this.getDefaultState().with(POWERED, false).with(LIT, false));
    }

    @Override
    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return state.with(POWERED, rsOut > 0).with(LIT, rsOut > 0);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(POWERED).add(LIT);
    }
}
