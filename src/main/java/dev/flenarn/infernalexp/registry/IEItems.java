package dev.flenarn.infernalexp.registry;

import dev.flenarn.infernalexp.InfernalExpansion;
import dev.flenarn.infernalexp.items.templates.AbstractDiscItem;

import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class IEItems {

    /*
    Music Discs
     */
    public static final Item DISC_SOUL_SPUNK = registerMusicDiscItem("music_disc_soul_spunk", 8, IESoundEvents.MUSIC_DISC_SOUL_SPUNK, Rarity.RARE);
    public static final Item DISC_FLUSH = registerMusicDiscItem("music_disc_flush", 7, IESoundEvents.MUSIC_DISC_FLUSH, Rarity.RARE);

    /*
    Util Items
     */
    public static final Item TAB_ITEM = registerItem("tab_icon", new Item(new Item.Settings()));


    /*
      Utility Functions
     */

    public static void register() {
    }

    public static Item registerItem(String ID, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, ID), item);
    }

    public static Item registerMusicDiscItem(String ID, int comparatorValue, SoundEvent soundEvent, Rarity rarity) {
        Item.Settings settings = new Item.Settings().rarity(rarity).maxCount(1).group(InfernalExpansion.TAB);
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, ID), new AbstractDiscItem(comparatorValue, soundEvent, settings));
    }

}
