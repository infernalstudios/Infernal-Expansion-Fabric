package org.infernalstudios.infernalexp.mixin.common;

import org.infernalstudios.infernalexp.registry.IEBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BubbleColumnBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BubbleColumnBlock.class)
public class MixinBubbleColumnBlock {

    @Inject(at = @At("HEAD"), method = "getBubbleState", cancellable = true)
    private static void IE_getBubbleState(BlockState state, CallbackInfoReturnable<BlockState> cir) {
        if (state.isOf(IEBlocks.BASALTIC_MAGMA)) {
            cir.setReturnValue(Blocks.BUBBLE_COLUMN.getDefaultState().with(Properties.DRAG, true));
        }
    }

    @Inject(at = @At("HEAD"), method = "canPlaceAt", cancellable = true)
    public void IE_canPlaceAt(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState blockState_IE = world.getBlockState(pos.down());
        if (blockState_IE.isOf(IEBlocks.BASALTIC_MAGMA)) {
            cir.setReturnValue(true);
        }
    }

}
