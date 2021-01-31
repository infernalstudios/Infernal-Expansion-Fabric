package dev.cernavskis.infernalexp.blocks;

import dev.cernavskis.infernalexp.tag.IEBlockTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class GlowFireBlock extends AbstractFireBlock {
    public GlowFireBlock(FabricBlockSettings settings) {
        super(settings, 2.0F);
     }

     public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
     }

     public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isGlowBase(world.getBlockState(pos.down()).getBlock());
     }

     public static boolean isGlowBase(Block block) {
        System.out.println("isGlowBase: " + String.valueOf(block.isIn(IEBlockTags.GLOW_FIRE_BASE_BLOCKS)));
        return block.isIn(IEBlockTags.GLOW_FIRE_BASE_BLOCKS);
     }

     protected boolean isFlammable(BlockState state) {
        return true;
     }
}
