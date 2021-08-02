package org.infernalstudios.infernalexp.util;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.client.render.block.entity.CampfireBlockEntityRenderer;
import org.infernalstudios.infernalexp.registry.IEBlockEntities;
import org.infernalstudios.infernalexp.registry.IEBlocks;
import org.infernalstudios.infernalexp.registry.IEItems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class IEClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        //BlockEntityType.CAMPFIRE = BlockEntityType.create("campfire", BlockEntityType.Builder.create(CampfireBlockEntity::new, Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE));

        /*
        Glowsilk Bow Rendering
         */
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


        /*
        Block Entity Render Registry
         */
        //IEBlockEntities.registerBER((BlockEntityType) IEBlockEntities.GLOW_CAMPFIRE, CampfireBlockEntityRenderer::new);
        //BlockEntityRendererRegistry.INSTANCE.register(IEBlockEntities.GLOW_CAMPFIRE, CampfireBlockEntityRenderer::new);


        /*
        Translucent Rendering
         */

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                IEBlocks.QUARTZ_GLASS,
                IEBlocks.QUARTZ_GLASS_PANE,
                IEBlocks.GLOW_GLASS,
                IEBlocks.GLOW_GLASS_PANE
        );

        /*
        Cut-out Rendering
         */
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                IEBlocks.GLOW_TORCH,
                IEBlocks.GLOW_TORCH_WALL,
                IEBlocks.GLOW_LANTERN,
                IEBlocks.GLOW_CAMPFIRE
        );


    }
}
