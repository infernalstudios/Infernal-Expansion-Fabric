package dev.cernavskis.infernalexp.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.SandBlock;

public class GlowSandBlock extends SandBlock {
    public GlowSandBlock(int dustColor, FabricBlockSettings settings) {
        super(dustColor, settings);
    }
}
