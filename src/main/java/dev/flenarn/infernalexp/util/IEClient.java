package dev.flenarn.infernalexp.util;

import dev.flenarn.infernalexp.registry.IEBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@SuppressWarnings("unused")
public class IEClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                IEBlocks.QUARTZ_GLASS,
                IEBlocks.QUARTZ_GLASS_PANE,
                IEBlocks.GLOW_GLASS,
                IEBlocks.GLOW_GLASS_PANE
        );
    }
}
