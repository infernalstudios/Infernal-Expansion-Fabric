package dev.flenarn.infernalexp.registry;

import dev.flenarn.infernalexp.InfernalExpansion;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IESoundEvents {

    public static final SoundEvent MUSIC_DISC_SOUL_SPUNK = register("record.soul_spunk");
    public static final SoundEvent MUSIC_DISC_FLUSH = register("record.flush");


    /*
    Util Functions
     */

    public static void register() {
    }

    public static SoundEvent register(String ID) {
        Identifier identifier = new Identifier(InfernalExpansion.MOD_ID, ID);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }
}
