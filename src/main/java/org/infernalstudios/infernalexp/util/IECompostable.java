package org.infernalstudios.infernalexp.util;

import net.minecraft.block.ComposterBlock;
import net.minecraft.item.Item;

public class IECompostable {

    public static void registerCompostable(float chance, Item item) {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item, chance);
    }
}
