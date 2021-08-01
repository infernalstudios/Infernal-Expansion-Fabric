package dev.flenarn.infernalexp.mixin.client.render;

import dev.flenarn.infernalexp.client.rendering.particle.GlowstoneSparkleParticle;
import dev.flenarn.infernalexp.client.rendering.particle.IEParticles;
import dev.flenarn.infernalexp.client.rendering.particle.InfectionParticle;

import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleManager.class)
public abstract class MixinParticleManager {

    @Shadow
    protected abstract <T extends ParticleEffect> void registerFactory(ParticleType<T> type, ParticleManager.SpriteAwareFactory<T> factory);

    @Inject(method = "registerDefaultFactories", at = @At("TAIL"))
    private void extendDefaults(CallbackInfo ci) {
        this.registerFactory(IEParticles.GLOWSTONE_SPARKLE, GlowstoneSparkleParticle.DefaultFactory::new);
        this.registerFactory(IEParticles.INFECTION, InfectionParticle.DefaultFactory::new);
    }
}
