package dev.flenarn.infernalexp.client.rendering.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class GlowstoneSparkleParticle extends SpriteBillboardParticle {

    private GlowstoneSparkleParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z);
        this.velocityX = (velocityX + random.nextFloat() - 0.5) / 3;
        this.velocityY = (velocityY + random.nextFloat()) / 5;
        this.velocityZ = (velocityZ + random.nextFloat() - 0.5) / 3;
        this.scale *= 0.75F;
        this.maxAge = 60 + this.random.nextInt(12);
    }

    public void move(double x, double y, double z) {
        this.setBoundingBox(this.getBoundingBox().offset(x, y, z));
        this.repositionFromBoundingBox();
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.x = this.velocityX;
            this.y = this.velocityY;
            this.z = this.velocityZ;
            if (this.velocityX > 0.1) this.velocityX *= 0.9;
            if (this.velocityY > 0.1) this.velocityY *= 0.9;
            if (this.velocityZ > 0.1) this.velocityZ *= 0.9;
        }
    }

    public int getBrightness(float toInt) {
        return 15728880;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Environment(EnvType.CLIENT)
    public static class DefaultFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public DefaultFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            GlowstoneSparkleParticle glowstoneSparkleParticle = new GlowstoneSparkleParticle(world, x, y, z, velocityX, velocityY, velocityZ);
            glowstoneSparkleParticle.setSprite(this.spriteProvider);
            glowstoneSparkleParticle.scale(0.5F);
            return glowstoneSparkleParticle;
        }
    }
}
