package dev.flenarn.infernalexp.registry;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_BREAK;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_FALL;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_HIT;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_PLACE;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_STEP;
import static dev.flenarn.infernalexp.registry.IESoundEvents.SOUL_STONE_BREAK;

public class IEBlockSoundGroups {

    /*
    Block Sound Groups
     */
    public static final BlockSoundGroup DULLSTONE = new BlockSoundGroup(1.0F, 1.0F, DULLSTONE_BREAK, DULLSTONE_STEP, DULLSTONE_PLACE, DULLSTONE_HIT, DULLSTONE_FALL);
    public static final BlockSoundGroup DIMSTONE = new BlockSoundGroup(1.0F, 1.0F, SoundEvents.BLOCK_GLASS_BREAK, DULLSTONE_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL);
    public static final BlockSoundGroup SOUL_STONE = new BlockSoundGroup(1.0F, 1.0F, SOUL_STONE_BREAK, SoundEvents.BLOCK_SOUL_SOIL_STEP, SoundEvents.BLOCK_SOUL_SOIL_PLACE, SoundEvents.BLOCK_SOUL_SOIL_HIT, SoundEvents.BLOCK_SOUL_SOIL_FALL);

    @SuppressWarnings("unused")
    public static void register(){
    }

}
