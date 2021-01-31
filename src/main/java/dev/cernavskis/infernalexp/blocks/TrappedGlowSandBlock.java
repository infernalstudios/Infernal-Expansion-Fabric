package dev.cernavskis.infernalexp.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TrappedGlowSandBlock extends GlowSandBlock {

    public TrappedGlowSandBlock(int dustColor, FabricBlockSettings settings) {
        super(dustColor, settings);
    }

    private static final int updateRadius = 4;

    @Override
    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        // Check if the world is the server
        if (!world.isClient() /*&& entity.getType() != ModEntityTypes.BLINDSIGHT.get()*/) {

            // Update all trapped blocks within a 3 block range
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
            FallingBlockEntity fallingblockentity = new FallingBlockEntity(world, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, world.getBlockState(pos));
            this.configureFallingBlockEntity(fallingblockentity);
            world.spawnEntity(fallingblockentity);
        }
    }

}
