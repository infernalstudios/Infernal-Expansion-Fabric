package dev.cernavskis.infernalexp.mixin;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.cernavskis.infernalexp.blocks.GlowFireBlock;
import dev.cernavskis.infernalexp.blocks.IEBlocks;

@Mixin(AbstractFireBlock.class)
public class GlowFireMixin {
        @Inject(method = "getState()V", at = @At("RETURN"), cancellable = true)
        private static void getState(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> info) {
            if (GlowFireBlock.isGlowBase(world.getBlockState(pos.down()).getBlock())) info.setReturnValue(IEBlocks.GLOW_FIRE.getDefaultState());
        }
}