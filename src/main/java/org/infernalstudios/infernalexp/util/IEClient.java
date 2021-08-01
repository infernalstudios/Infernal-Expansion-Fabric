package dev.flenarn.infernalexp.util;

import dev.flenarn.infernalexp.registry.IEBlocks;

import dev.flenarn.infernalexp.registry.IEItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class IEClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(IEItems.GLOWSILK_BOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            }
            return entity.getActiveItem() != stack ? 0F : (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20F;
        });

        ModelPredicateProviderRegistry.register(IEItems.GLOWSILK_BOW, new Identifier("pulling"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            }
            return entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                IEBlocks.QUARTZ_GLASS,
                IEBlocks.QUARTZ_GLASS_PANE,
                IEBlocks.GLOW_GLASS,
                IEBlocks.GLOW_GLASS_PANE
        );
    }
}
