package dev.flenarn.infernalexp.registry;

import dev.flenarn.infernalexp.InfernalExpansion;
import dev.flenarn.infernalexp.items.templates.AbstractDiscItem;

import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static dev.flenarn.infernalexp.util.IEItemRegistration.registerItem;
import static dev.flenarn.infernalexp.util.IEItemRegistration.registerMusicDiscItem;


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

    @SuppressWarnings("unused")
    public static void register() {
    }
}
