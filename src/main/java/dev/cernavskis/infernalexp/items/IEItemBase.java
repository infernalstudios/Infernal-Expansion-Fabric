package dev.cernavskis.infernalexp.items;

import dev.cernavskis.infernalexp.InfernalExpansion;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class IEItemBase extends Item {
    
    public IEItemBase(Settings settings) {
        super(settings.group(InfernalExpansion.TAB));
    }
    
    public IEItemBase() {
        this(new FabricItemSettings());
    }
    
}