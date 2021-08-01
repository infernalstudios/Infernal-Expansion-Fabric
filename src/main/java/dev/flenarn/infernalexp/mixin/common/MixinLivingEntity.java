package dev.flenarn.infernalexp.mixin.common;

import dev.flenarn.infernalexp.client.rendering.DynamicLightingHandler;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @Inject(at = @At("HEAD"), method = "tick")
    private void tickInfernalExpansion(CallbackInfo callbackInfo) {
        DynamicLightingHandler.tick((LivingEntity) ((Object) this));
    }

}
