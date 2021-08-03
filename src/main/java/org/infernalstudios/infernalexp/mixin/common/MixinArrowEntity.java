package org.infernalstudios.infernalexp.mixin.common;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.potion.Potion;

import org.infernalstudios.infernalexp.access.PersistentProjectileEntityAccess;
import org.infernalstudios.infernalexp.registry.IEEffects;
import org.infernalstudios.infernalexp.registry.IEParticles;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(ArrowEntity.class)
public abstract class MixinArrowEntity {

    @Final
    @Shadow
    private Set<StatusEffectInstance> effects;

    @Shadow
    protected abstract void initColor();

    @Shadow
    private Potion potion; //TODO - Injection for this method.

    @Inject(at = @At("RETURN"), method = "onHit")
    private void onHitInfernalExpansion(LivingEntity livingEntity, CallbackInfo callbackInfo) {
        if (((PersistentProjectileEntityAccess) this).getLuminous()) {
            System.out.println("Luminous found");
            livingEntity.addStatusEffect(new StatusEffectInstance(IEEffects.LUMINOUS, 3600));
        }
    }

    @Inject(at = @At("RETURN"), method = "addEffect")
    private void addEffectInfernalExpansion(StatusEffectInstance effect, CallbackInfo callbackInfo) {
        for (StatusEffectInstance statusEffectInstance : this.effects) {
            if (statusEffectInstance.getEffectType() == IEEffects.LUMINOUS) {
                ((PersistentProjectileEntityAccess) this).setLuminous(true);
            }
        }
        this.initColor();
    }

    @Inject(at = @At("HEAD"), method = "spawnParticles")
    private void spawnParticlesInfernalExpansion(int amount, CallbackInfo callbackInfo) {
        if (((PersistentProjectileEntityAccess) this).getLuminous()) {
            for (int i = 0; i < amount; i++) {
                ((ArrowEntity) (Object) this).world.addParticle(IEParticles.GLOWSTONE_SPARKLE,
                        ((ArrowEntity) (Object) this).getParticleX(0.5D),
                        ((ArrowEntity) (Object) this).getRandomBodyY(),
                        ((ArrowEntity) (Object) this).getParticleZ(0.5D),
                        0.0D, 0.0D, 0.0D);
            }
        }
    }


}
