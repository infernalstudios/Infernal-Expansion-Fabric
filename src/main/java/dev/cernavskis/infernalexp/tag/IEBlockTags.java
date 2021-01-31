package dev.cernavskis.infernalexp.tag;

import dev.cernavskis.infernalexp.InfernalExpansion;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class IEBlockTags {
    public static final Tag<Block> GLOW_FIRE_BASE_BLOCKS = register("glow_fire_base_blocks");
    
    private static Tag<Block> register(String name) {
       return TagRegistry.block(new Identifier(InfernalExpansion.MOD_ID, name));
    }
}
