package dev.flenarn.infernalexp.registry;

import dev.flenarn.infernalexp.InfernalExpansion;
import net.minecraft.client.sound.Sound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

public class IESoundEvents {

    /*
    Voline
     */
    public static final SoundEvent VOLINE_AMBIENT = register("entity.voline.ambient");
    public static final SoundEvent VOLINE_HURT = register("entity.voline.hurt");

    /*
    Shroomloin
     */
    public static final SoundEvent SHROOMLOIN_AMBIENT = register("entity.shroomloin.ambient");
    public static final SoundEvent SHROOMLOIN_HURT = register("entity.shroomloin.hurt");
    public static final SoundEvent SHROOMLOIN_DEATH = register("entity.shroomloin.death");

    /*
    Warpbeetle
     */
    public static final SoundEvent WARPBEETLE_AMBIENT = register("entity.warpbeetle.ambient");
    public static final SoundEvent WARPBEETLE_HURT = register("entity.warpbeetle.hurt");
    public static final SoundEvent WARPBEETLE_DEATH = register("entity.warpbeetle.death");

    /*
    Cerobeetle
     */
    public static final SoundEvent CEROBEETLE_AMBIENT = register("entity.cerobeetle.ambient");
    public static final SoundEvent CEROBEETLE_HURT = register("entity.cerobeetle.hurt");
    public static final SoundEvent CEROBEETLE_DEATH = register("entity.cerobeetle.death");
    public static final SoundEvent CEROBEETLE_ROAR = register("entity.cerobeetle.roar");

    /*
    Embody
     */
    public static final SoundEvent EMBODY_AMBIENT = register("entity.embody.ambient");
    public static final SoundEvent EMBODY_HURT = register("entity.embody.hurt");
    public static final SoundEvent EMBODY_DEATH = register("entity.embody.death");

    /*
    Music Discs
     */
    public static final SoundEvent MUSIC_DISC_SOUL_SPUNK = register("record.soul_spunk");
    public static final SoundEvent MUSIC_DISC_FLUSH = register("record.flush");

    /*
    Glowstone Recharge / just use "SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE"?
     */
    public static final SoundEvent GLOWSTONE_RECHARGE = register("block.glowstone.recharge");

    /*
    Dullstone
     */
    public static final SoundEvent DULLSTONE_BREAK = register("block.dullstone.break");
    public static final SoundEvent DULLSTONE_STEP = register("block.dullstone.step");
    public static final SoundEvent DULLSTONE_PLACE = register("block.dullstone.place");
    public static final SoundEvent DULLSTONE_HIT = register("block.dullstone.hit");
    public static final SoundEvent DULLSTONE_FALL = register("block.dullstone.fall");

    /*
    Soulstone
     */
    public static final SoundEvent SOUL_STONE_BREAK = register("block.soul_stone_break");


    /*
    Util Functions
     */

    @SuppressWarnings("unused")
    public static void register() {
    }

    public static SoundEvent register(String ID) {
        Identifier identifier = new Identifier(InfernalExpansion.MOD_ID, ID);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }
}
