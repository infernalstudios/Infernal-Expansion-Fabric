package dev.flenarn.infernalexp.util;

import dev.flenarn.infernalexp.InfernalExpansion;
import dev.flenarn.infernalexp.items.templates.AbstractDiscItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class IEItemRegistration {

    public static Item registerItem(String ID, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, ID), item);
    }

    public static Item registerMusicDiscItem(String ID, int comparatorValue, SoundEvent soundEvent, Rarity rarity) {
        Item.Settings settings = new Item.Settings().rarity(rarity).maxCount(1).group(InfernalExpansion.TAB);
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, ID), new AbstractDiscItem(comparatorValue, soundEvent, settings));
    }

}
