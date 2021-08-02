package org.infernalstudios.infernalexp.registry;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import org.infernalstudios.infernalexp.block.entities.GlowCampfireBlockEntity;

public class IEBlockEntities {

    public static final BlockEntityType GLOW_CAMPFIRE;

    @SuppressWarnings("Unused")
    public static void register(){
    }

    static {
        GLOW_CAMPFIRE = Registry.register(Registry.BLOCK_ENTITY_TYPE, "infernalexp:glow_campfire", BlockEntityType.Builder.create(GlowCampfireBlockEntity::new, IEBlocks.GLOW_CAMPFIRE).build(null));
    }

}
