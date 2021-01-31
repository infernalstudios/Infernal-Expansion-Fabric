package dev.cernavskis.infernalexp.blocks;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemPlacementContext;

public class GlowDustBlock extends SnowBlock {
    public GlowDustBlock(FabricBlockSettings settings) {
        super(settings);
    }
    

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
       BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
       if (blockState.isOf(this)) {
          int i = (Integer) blockState.get(LAYERS);
          if (i < 7) {
              return (BlockState) blockState.with(LAYERS, Math.min(8, i + 1));              
          } else {
              return IEBlocks.GLOWDUST_SAND.getDefaultState();
          }
       } else {
          return super.getPlacementState(ctx);
       }
    }
}