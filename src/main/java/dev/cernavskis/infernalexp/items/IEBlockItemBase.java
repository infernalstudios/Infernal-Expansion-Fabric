package dev.cernavskis.infernalexp.items;

import dev.cernavskis.infernalexp.InfernalExpansion;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class IEBlockItemBase extends BlockItem {

    public IEBlockItemBase(Block block, Settings settings) {
        super(block, settings.group(InfernalExpansion.TAB));
    }
    
    public IEBlockItemBase(Block block) {
        this(block, new FabricItemSettings());
    }

}