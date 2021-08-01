package dev.flenarn.infernalexp.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.registry.Registry;

public class IEEffects {

    public static final StatusEffect LUMINOUS;

    static {
        LUMINOUS = Registry.register(Registry.STATUS_EFFECT, "infernalexp:luminous", new StatusEffect(StatusEffectType.NEUTRAL, 0xDCBC82));
    }
}
