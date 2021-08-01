package org.infernalstudios.infernalexp.blocks;

import org.infernalstudios.infernalexp.registry.IEParticles;
import org.infernalstudios.infernalexp.registry.IEBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class TrappedGlowSandBlock extends SandBlock {
    public TrappedGlowSandBlock(int color, Settings settings) {
        super(color, settings);
    }

    private static final int updateRadius = 4;
    private int ticksToFall = 10;

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            for (int x = -updateRadius; x <= updateRadius; x++) {
                for (int y = -updateRadius; y <= updateRadius; y++) {
                    for (int z = -updateRadius; z <= updateRadius; z++) {
                        if (world.getBlockState(pos.add(x, y, z)) == IEBlocks.TRAPPED_GLOWDUST_SAND.getDefaultState()) {
                            ((TrappedGlowSandBlock) world.getBlockState(pos.add(x, y, z)).getBlock()).startFalling((ServerWorld) world, pos.add(x, y, z));
                        }
                    }
                }
            }
        }
    }

    public void startFalling(ServerWorld world, BlockPos pos) {
        if ((world.isAir(pos.down()) || canFallThrough(world.getBlockState(pos.down())) && pos.getY() >= 0)) {
            if (this.ticksToFall == 0) {
                world.playSound(null, pos, SoundEvents.BLOCK_SAND_PLACE, SoundCategory.BLOCKS, 1.5F, world.random.nextFloat() * 0.1F + 0.9F);

                FallingBlockEntity fallingBlockEntity = new FallingBlockEntity(world, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, world.getBlockState(pos));
                this.configureFallingBlockEntity(fallingBlockEntity);
                world.spawnEntity(fallingBlockEntity);

                this.ticksToFall = 10;
            } else {
                world.spawnParticles(IEParticles.GLOWSTONE_SPARKLE, pos.getX(), pos.getY(), pos.getZ(), 1, 0.0, 1.0, 0.0, 0.0);
                this.ticksToFall--;
            }
        }
    }
}
