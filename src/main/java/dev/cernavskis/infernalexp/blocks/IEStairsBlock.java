package dev.cernavskis.infernalexp.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class IEStairsBlock extends StairsBlock {

    public IEStairsBlock(BlockState block, FabricBlockSettings settings) {
        super(block, settings);
    }
    
    public IEStairsBlock(Block block) {
        this(block.getDefaultState(), FabricBlockSettings.copyOf(block));
    }
    
    public IEStairsBlock(Block block, FabricBlockSettings settings) {
        this(block.getDefaultState(), settings);
    }

}