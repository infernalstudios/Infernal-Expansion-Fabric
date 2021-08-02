package org.infernalstudios.infernalexp.client.rendering;

import org.infernalstudios.infernalexp.access.PersistentProjectileEntityAccess;
import org.infernalstudios.infernalexp.registry.IEEffects;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.math.BlockPos;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Environment(EnvType.CLIENT)
public class DynamicLightingHandler {

    private static final MinecraftClient MinecraftInstance = MinecraftClient.getInstance();
    public static final Map<BlockPos, LightData> LIGHT_SOURCES = new ConcurrentHashMap<>();

    public static void tick(LivingEntity livingEntity) {
        if (livingEntity != null && MinecraftInstance.player != null) {
            if (shouldGlow(livingEntity)) {
                LIGHT_SOURCES.put(livingEntity.getBlockPos(), new LightData(getTimeAmplifier(livingEntity)));
            }

            if (livingEntity == MinecraftInstance.player) {
                LIGHT_SOURCES.forEach((pos, lightData) -> {
                    if (lightData.time == 0) {
                        lightData.shouldKeep = false;
                    }
                    if (lightData.time == 20 * lightData.amplifier || !lightData.shouldKeep) {
                        MinecraftInstance.world.getChunkManager().getLightingProvider().checkBlock(pos);
                    }

                    lightData.time -= 10;
                });
                LIGHT_SOURCES.entrySet().removeIf(blockPosLightDataEntry -> !blockPosLightDataEntry.getValue().shouldKeep);
            }
        }
    }

    public static void tick(PersistentProjectileEntity persistentProjectileEntity) {
        if (persistentProjectileEntity != null && MinecraftInstance.player != null) {
          if (shouldGlow(persistentProjectileEntity)) {
              LIGHT_SOURCES.put(persistentProjectileEntity.getBlockPos(), new LightData(0.5F));
          }
        }
    }

    public static int getTimeAmplifier(LivingEntity livingEntity) {
        StatusEffectInstance effectInstance = livingEntity.getStatusEffect(IEEffects.LUMINOUS);
        if (effectInstance != null) {
            return effectInstance.getAmplifier() == 0 ? 1 : 2;
        }
        return 1;
    }

    public static boolean shouldGlow(PersistentProjectileEntity persistentProjectileEntity) {
        return ((PersistentProjectileEntityAccess) persistentProjectileEntity).getGlow();
    }

    public static boolean shouldGlow(LivingEntity entity) {
        return entity.hasStatusEffect(IEEffects.LUMINOUS);
    }

    public static class LightData {
        public boolean shouldKeep = true;
        public double time;
        public double amplifier;

        public LightData(double amplifier) {
            this.amplifier = amplifier;
            this.time = 20 * amplifier;
        }
    }
}
