package org.infernalstudios.infernalexp.blocks;

import org.infernalstudios.infernalexp.registry.IEParticles;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class GlowTorchBlock extends TorchBlock {

    public GlowTorchBlock(Settings settings) {
        super(settings, null);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.7D;
        double f = (double)pos.getZ() + 0.5D;
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        if (random.nextInt(2) == 1) {
            world.addParticle(IEParticles.GLOWSTONE_SPARKLE, d, e, f, 0.0D, 0.0D, 0.0D);
        }
    }
}
