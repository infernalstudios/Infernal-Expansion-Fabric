package org.infernalstudios.infernalexp.block;

import org.infernalstudios.infernalexp.registry.IEParticles;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraft.state.property.Properties.HORIZONTAL_FACING;

public class GlowWallTorchBlock extends WallTorchBlock {
    public GlowWallTorchBlock(Settings settings) {
        super(settings, null);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.7D;
        double f = (double)pos.getZ() + 0.5D;
        Direction direction1 = state.get(FACING).getOpposite();
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        if (random.nextInt(2) == 1) {
            world.addParticle(IEParticles.GLOWSTONE_SPARKLE, d + 0.27D * (double) direction1.getOffsetX(), e + 0.22D, f + 0.27D * (double) direction1.getOffsetZ(), 0.0D, 0.0D, 0.0D);
        }
    }
}
