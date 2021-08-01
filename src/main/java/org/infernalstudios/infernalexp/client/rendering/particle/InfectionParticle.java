package dev.flenarn.infernalexp.client.rendering.particle;

import com.ibm.icu.text.MessagePattern;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class InfectionParticle extends SpriteBillboardParticle {

    SpriteProvider spriteProviderWithAge;

    protected InfectionParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProviderWithAge) {
        super(world, x, y, z, 0.5 - Math.random(), velocityY, 0.5 - Math.random());

        this.spriteProviderWithAge = spriteProviderWithAge;
        this.velocityY *= 0.1;

        if (velocityX == 0 && velocityY == 0) {
            this.velocityX *= 0.1;
            this.velocityZ *= 0.1;
        }

        this.scale *= 0.75;
        this.maxAge = (int) (16 / (Math.random() * 0.8 + 0.2));
        this.collidesWithWorld = false;
        this.setSpriteForAge(spriteProviderWithAge);

        this.colorRed = 0.5F;
        this.colorGreen = (float) Math.random() * 0.1F;
        this.colorBlue = (float) Math.random() * 0.1F;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        if (this.age++ > this.maxAge) {
            this.markDead();
        } else {
            this.setSpriteForAge(this.spriteProviderWithAge);
            this.velocityY -= 0.001;
            this.move(this.velocityX, this.velocityY, this.velocityZ);

            if (this.y == this.prevPosY) {
                this.velocityX *= 1.1;
                this.velocityZ *= 1.1;
            }

            this.velocityX *= 0.96;
            this.velocityY *= 0.96;
            this.velocityZ *= 0.96;

            if (this.onGround) {
                this.velocityX *= 0.7;
                this.velocityZ *= 0.7;
            }

            this.colorRed = 0.7F + (0.2F * MathHelper.sin(this.age / 10F));
        }
    }

    @Environment(EnvType.CLIENT)
    public static class DefaultFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public DefaultFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new InfectionParticle(world, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
