package org.infernalstudios.infernalexp.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import org.infernalstudios.infernalexp.block.entities.LuminousFungusBlockEntity;
import org.infernalstudios.infernalexp.block.templates.HorizontalPlantBlockWithEntity;
import org.infernalstudios.infernalexp.registry.IEBlocks;
import org.infernalstudios.infernalexp.registry.IEEffects;

import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class LuminousFungusBlock extends HorizontalPlantBlockWithEntity implements Fertilizable {

    public static final BooleanProperty LIT = Properties.LIT;
    protected static final VoxelShape FLOOR_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.D, 11.0D);
    protected static final VoxelShape CEILING_SHAPE = Block.createCuboidShape(5.0D, 6.0D, 5.0D, 11.0D, 16.0D, 11.0D);

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return LuminousFungusBlockEntity::tickServer;
    }

    public LuminousFungusBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACE, WallMountLocation.FLOOR).with(HORIZONTAL_FACING, Direction.NORTH).with(LIT, false));
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView blockView, BlockPos blockPos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND) || floor.isIn(BlockTags.MUSHROOM_GROW_BLOCK) ||
                floor.isOf(IEBlocks.GLOWDUST_SAND) || floor.isIn(BlockTags.SAND) || floor.isOf(Blocks.SOUL_SOIL) ||
                floor.isOf(Blocks.GLOWSTONE) || floor.isOf(IEBlocks.DIMSTONE) || floor.isOf(IEBlocks.DULLSTONE); //Add DULLTHORNS HERE LATER
    }


    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        //TODO - Dullthorns still missing from code.
        Block block1 = world.getBlockState(pos.down()).getBlock();
        return false;
    }

    public boolean canAttach(WorldView world, BlockPos blockPos, Direction direction) {
        BlockPos blockPos1 = blockPos.offset(direction);
        return canPlantOnTop(world.getBlockState(blockPos1), world, blockPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !state.get(FACE).equals(WallMountLocation.WALL) && canAttach(world, pos, getDirection(state).getOpposite());
    }

    @Override
    public AbstractBlock.OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double) random.nextFloat() < 0.4D;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LuminousFungusBlockEntity(pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> blockStateBuilder) {
        super.appendProperties(blockStateBuilder);
        blockStateBuilder.add(HORIZONTAL_FACING).add(FACE).add(LIT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);

        return switch (state.get(FACE)) {
            case FLOOR -> FLOOR_SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
            default -> CEILING_SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
        };

    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient()) {
            if (entity instanceof LivingEntity && entity.isAlive()) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addStatusEffect(new StatusEffectInstance(IEEffects.LUMINOUS, 120, 0, true, true));
            }
        }
    }
}
