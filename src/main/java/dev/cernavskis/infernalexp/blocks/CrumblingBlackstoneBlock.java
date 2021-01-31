package dev.cernavskis.infernalexp.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CrumblingBlackstoneBlock extends FallingBlock {

    public CrumblingBlackstoneBlock(Settings settings) {
        super(settings);
    }
    
    @Environment(EnvType.CLIENT)
    @Override
    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return -462091;
    }
    
}