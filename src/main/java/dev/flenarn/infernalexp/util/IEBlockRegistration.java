package dev.flenarn.infernalexp.util;

import dev.flenarn.infernalexp.InfernalExpansion;
import dev.flenarn.infernalexp.registry.IEItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class IEBlockRegistration {

    public static Block registerBlockWithDefaultItem(String ID, Block block) {
        IEItems.registerItem(ID, new BlockItem(block, new Item.Settings().group(InfernalExpansion.TAB)));
        return registerBlock(ID, block);
    }

    public static Block registerBlock(String ID, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(InfernalExpansion.MOD_ID, ID), block);
    }

    public static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    public static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
}
