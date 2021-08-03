package org.infernalstudios.infernalexp.block.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import org.infernalstudios.infernalexp.block.LuminousFungusBlock;
import org.infernalstudios.infernalexp.registry.IEBlockEntities;

import java.util.List;
import java.util.Objects;

//TODO - Make it render, won't for some reason?

public class LuminousFungusBlockEntity extends BlockEntity {
    private int lightTime = 0;

    public LuminousFungusBlockEntity(BlockPos pos, BlockState state) {
        super(IEBlockEntities.LUMINOUS_FUNGUS_ENTITY, pos, state);
    }

    public static void tickServer(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (!Objects.requireNonNull(blockEntity.getWorld()).isClient()) {
            List<Entity> nearbyEntities = blockEntity.getWorld().getNonSpectatingEntities(Entity.class, new Box(blockEntity.getPos()).expand(3.0D));
            Vec3d blockPos = new Vec3d(blockEntity.getPos().getX(), blockEntity.getPos().getY(), blockEntity.getPos().getZ());
            nearbyEntities.removeIf((entity -> {
                Vec3d entityPos = new Vec3d(entity.getX(), entity.getEyeY(), entity.getZ());
                return blockEntity.getWorld().raycast(new RaycastContext(blockPos, entityPos, RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, entity)).getType() != HitResult.Type.MISS;
            }));

            boolean shouldLight = false;

            for (Entity entity : nearbyEntities) {
                if (entity.lastRenderX != entity.getX() || entity.lastRenderY != entity.getY() || entity.lastRenderZ != entity.getZ()) {
                    double velX = Math.abs(entity.getX() - entity.lastRenderX);
                    double velY = Math.abs(entity.getY() - entity.lastRenderY);
                    double velZ = Math.abs(entity.getZ() - entity.lastRenderZ);

                    if (velX >= (double) 0.003F || velY >= (double) 0.003F || velZ >= (double) 0.003F) {
                        shouldLight = true;
                        break;
                    }
                } else if (
                        entity.horizontalSpeed - entity.prevHorizontalSpeed > 0 || entity.getVelocity().length() > 0.1D
                ) {
                    shouldLight = true;
                    break;
                }
            }
            if (((LuminousFungusBlockEntity) blockEntity).lightTime == 0) {
                Objects.requireNonNull(blockEntity.getWorld()).setBlockState(blockEntity.getPos(), blockEntity.getCachedState().with(LuminousFungusBlock.LIT, shouldLight));
            } else {
                ((LuminousFungusBlockEntity) blockEntity).lightTime--;
            }
            if (shouldLight) ((LuminousFungusBlockEntity) blockEntity).lightTime = 60;
        }
    }
}
