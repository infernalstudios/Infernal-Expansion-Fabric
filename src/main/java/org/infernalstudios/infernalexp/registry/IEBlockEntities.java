package org.infernalstudios.infernalexp.registry;

import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.util.registry.Registry;
import org.infernalstudios.infernalexp.block.entities.GlowCampfireBlockEntity;
import org.infernalstudios.infernalexp.block.entities.LuminousFungusBlockEntity;

public class IEBlockEntities {

    public static final BlockEntityType<GlowCampfireBlockEntity> GLOW_CAMPFIRE_ENTITY;
    public static final BlockEntityType<LuminousFungusBlockEntity> LUMINOUS_FUNGUS_ENTITY;

    static {
        GLOW_CAMPFIRE_ENTITY = registerBlockEntity("glow_campfire", GlowCampfireBlockEntity::new, IEBlocks.GLOW_CAMPFIRE);
        LUMINOUS_FUNGUS_ENTITY = registerBlockEntity("luminous_fungus", LuminousFungusBlockEntity::new, IEBlocks.LUMINOUS_FUNGUS);
    }

    /*
    Util. Functions
     */
    @SuppressWarnings("Unused")
    public static void register(){
    }

    public static <T extends BlockEntity> void registerBER(BlockEntityType<T> type, BlockEntityRendererFactory<? super T> factory) {
        BlockEntityRendererRegistry.INSTANCE.register(type, factory);
    }

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String ID, BlockEntityType.BlockEntityFactory<T> factory, Block... blocks) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, "infernalexp:" + ID, BlockEntityType.Builder.create(factory, blocks).build(null));
    }
}
