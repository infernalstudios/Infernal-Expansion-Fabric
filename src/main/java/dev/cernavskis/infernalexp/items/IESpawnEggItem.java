package dev.cernavskis.infernalexp.items;

import dev.cernavskis.infernalexp.InfernalExpansion;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;

public class IESpawnEggItem extends SpawnEggItem {
    
    public IESpawnEggItem(EntityType<?> entity, int primaryColor, int secondaryColor, Settings settings) {
        super(entity, primaryColor, secondaryColor, settings.group(InfernalExpansion.TAB));
    }
    
    public IESpawnEggItem(EntityType<?> entity, int primaryColor, int secondaryColor) {
        this(entity, primaryColor, secondaryColor, new FabricItemSettings());
    }
    
}