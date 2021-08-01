package dev.flenarn.infernalexp.mixin.common;

import dev.flenarn.infernalexp.access.PersistentProjectileEntityAccess;
import dev.flenarn.infernalexp.client.rendering.DynamicLightingHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.PersistentProjectileEntity;

import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public class MixinPersistentProjectileEntity implements PersistentProjectileEntityAccess {
    @Unique
    private static final TrackedData<Boolean> GLOW = DataTracker.registerData(PersistentProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Unique
    private static final TrackedData<Boolean> LUMINOUS = DataTracker.registerData(PersistentProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Unique
    private static final TrackedData<Boolean> INFECTION = DataTracker.registerData(PersistentProjectileEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    @Environment(EnvType.CLIENT)
    @Inject(at = @At("RETURN"), method = "tick")
    private void arrowTickInfernalExpansion(CallbackInfo callbackInfo) {
        DynamicLightingHandler.tick((PersistentProjectileEntity) (Object) this);
    }

    @Inject(at = @At("RETURN"), method = "initDataTracker")
    private void initDataTrackerInfernalExpansion(CallbackInfo callbackInfo) {
        ((PersistentProjectileEntity) (Object) this).getDataTracker().startTracking(LUMINOUS, false);
        ((PersistentProjectileEntity) (Object) this).getDataTracker().startTracking(INFECTION, false);
        ((PersistentProjectileEntity) (Object) this).getDataTracker().startTracking(GLOW, false);
    }

    @Inject(at = @At("RETURN"), method = "writeCustomDataToNbt")
    private void writeCustomDataToNbtInfernalExpansion(NbtCompound nbtCompound, CallbackInfo callbackInfo) {
        nbtCompound.putBoolean("Luminous", ((PersistentProjectileEntity) (Object) this).getDataTracker().get(LUMINOUS));
        nbtCompound.putBoolean("Infection", ((PersistentProjectileEntity) (Object) this).getDataTracker().get(INFECTION));
        nbtCompound.putBoolean("Glow", ((PersistentProjectileEntity) (Object) this).getDataTracker().get(GLOW));
    }

    @Inject(at = @At("RETURN"), method = "readCustomDataFromNbt")
    private void readCustomDataFromNbtInfernalExpansion(NbtCompound nbtCompound, CallbackInfo callbackInfo) {
        setLuminous(nbtCompound.getBoolean("Luminous"));
        setInfection(nbtCompound.getBoolean("Infection"));
        setGlow(nbtCompound.getBoolean("Glow"));
    }

    @Override
    public boolean getLuminous() {
        return ((PersistentProjectileEntity) (Object) this).getDataTracker().get(LUMINOUS);
    }

    @Override
    public void setLuminous(boolean isLuminous) {
        ((PersistentProjectileEntity) (Object) this).getDataTracker().set(LUMINOUS, isLuminous);
    }

    @Override
    public boolean getInfection() {
        return ((PersistentProjectileEntity) (Object) this).getDataTracker().get(INFECTION);
    }

    @Override
    public void setInfection(boolean isInfection) {
        ((PersistentProjectileEntity) (Object) this).getDataTracker().set(INFECTION, isInfection);
    }

    @Override
    public boolean getGlow() {
        return ((PersistentProjectileEntity) (Object) this).getDataTracker().get(GLOW);
    }

    @Override
    public void setGlow(boolean shouldGlow) {
        ((PersistentProjectileEntity) (Object) this).getDataTracker().set(GLOW, shouldGlow);
    }
}
