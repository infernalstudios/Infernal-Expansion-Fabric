package org.infernalstudios.infernalexp.mixin.client.world;

import org.infernalstudios.infernalexp.client.rendering.DynamicLightingHandler;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = BlockView.class, priority = 200)
public interface MixinBlockView {

    @Shadow BlockState getBlockState(BlockPos pos);

    @Overwrite
    default int getLuminance(BlockPos pos) {
        if (DynamicLightingHandler.LIGHT_SOURCES.containsKey(pos) && DynamicLightingHandler.LIGHT_SOURCES.get(pos).shouldKeep) {
            return 10;
        }
        return this.getBlockState(pos).getLuminance();
    }

}
