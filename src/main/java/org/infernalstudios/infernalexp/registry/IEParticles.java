package dev.flenarn.infernalexp.registry;


import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;

public class IEParticles {

    public static final DefaultParticleType GLOWSTONE_SPARKLE;
    public static final DefaultParticleType INFECTION;

    static {
        GLOWSTONE_SPARKLE = Registry.register(Registry.PARTICLE_TYPE, "infernalexp:glowstone_sparkle", new DefaultParticleType(true));
        INFECTION = Registry.register(Registry.PARTICLE_TYPE, "infernalexp:infection", new DefaultParticleType(true));
    }
}
