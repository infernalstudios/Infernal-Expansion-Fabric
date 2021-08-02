package org.infernalstudios.infernalexp.block.templates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class FungusCapBlock extends Block {
    public FungusCapBlock(Settings settings) {
        super(settings);
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            entity.handleFallDamage(fallDistance, 0.75F, DamageSource.FALL);
        } else {
            entity.handleFallDamage(fallDistance, 0.1F, DamageSource.FALL);
        }
    }

    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounceEntity(entity);
        }
    }

    private void bounceEntity(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0D) {
            double d0 = entity instanceof LivingEntity ? 0.5D : 0.3D;
            entity.setVelocity(vec3d.x, -vec3d.y * d0, vec3d.z);
        }
    }
}
