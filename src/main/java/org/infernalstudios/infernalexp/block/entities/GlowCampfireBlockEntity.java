package org.infernalstudios.infernalexp.block.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.util.math.BlockPos;
import org.infernalstudios.infernalexp.registry.IEBlockEntities;

public class GlowCampfireBlockEntity extends CampfireBlockEntity {
    public GlowCampfireBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }


    public BlockEntityType<?> getType() {
        return IEBlockEntities.GLOW_CAMPFIRE;
    }
}
