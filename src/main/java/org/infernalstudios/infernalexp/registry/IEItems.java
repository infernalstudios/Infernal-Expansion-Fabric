package org.infernalstudios.infernalexp.registry;

import net.minecraft.item.WallStandingBlockItem;
import org.infernalstudios.infernalexp.InfernalExpansion;
import org.infernalstudios.infernalexp.items.GlowsilkBowItem;
import org.infernalstudios.infernalexp.items.templates.AbstractDiscItem;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
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
    Glow Torch
     */
    public static final Item GLOW_TORCH = registerItem("glow_torch", new WallStandingBlockItem(IEBlocks.GLOW_TORCH, IEBlocks.GLOW_TORCH_WALL, new Item.Settings().group(InfernalExpansion.TAB)));

    /*
    Glowsilk Bow
     */
    public static final Item GLOWSILK_BOW = registerItem("glowsilk_bow", new GlowsilkBowItem(new Item.Settings().maxDamage(384).group(InfernalExpansion.TAB)));

    /*
    Util Items
     */
    public static final Item TAB_ITEM = registerItem("tab_icon", new Item(new Item.Settings()));

    /*
    Spawn Eggs
     */


    /*
      Utility Functions
     */

    @SuppressWarnings("unused")
    public static void register() {
    }

    public static Item registerItem(String ID, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, ID), item);
    }

    public static Item registerMusicDiscItem(String ID, int comparatorValue, SoundEvent soundEvent, Rarity rarity) {
        Item.Settings settings = new Item.Settings().rarity(rarity).maxCount(1).group(InfernalExpansion.TAB);
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, ID), new AbstractDiscItem(comparatorValue, soundEvent, settings));
    }

    public static Item registerSpawnEgg(String ID, EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor) {
        return registerItem(ID, new SpawnEggItem(type, primaryColor, secondaryColor, new Item.Settings().group(InfernalExpansion.TAB)));
    }
}
