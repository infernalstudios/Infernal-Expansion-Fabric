package dev.flenarn.infernalexp.registry;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_BREAK;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_FALL;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_HIT;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_PLACE;
import static dev.flenarn.infernalexp.registry.IESoundEvents.DULLSTONE_STEP;

public class IEBlockSoundGroups {

    public static final BlockSoundGroup DULLSTONE = new BlockSoundGroup(1.0F, 1.0F, DULLSTONE_BREAK, DULLSTONE_STEP, DULLSTONE_PLACE, DULLSTONE_HIT, DULLSTONE_FALL);

    @SuppressWarnings("unused")
    public static void register(){
    }

}
