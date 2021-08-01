package dev.flenarn.infernalexp.blocks;


import dev.flenarn.infernalexp.registry.IEBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemPlacementContext;
import org.jetbrains.annotations.Nullable;

public class GlowdustBlock extends SnowBlock {
    public GlowdustBlock(Settings settings) {
        super(settings);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            int i = blockState.get(LAYERS);
            if (i < 7) {
                return blockState.with(LAYERS, Math.min(8, i + 1));
            } else {
                return IEBlocks.GLOWDUST_SAND.getDefaultState();
            }
        } else {
            return super.getPlacementState(ctx);
        }
    }
}
