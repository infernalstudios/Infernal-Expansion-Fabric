package dev.flenarn.infernalexp.registry;

import dev.flenarn.infernalexp.blocks.BasalticMagmaBlock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;

import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.PaneBlock;

import static dev.flenarn.infernalexp.util.IEBlockRegistration.registerBlockWithDefaultItem;


public class IEBlocks {

    /*
     All blocks added by Infernal Expansion are registered here.
     */

    public static final Block BASALTIC_MAGMA = registerBlockWithDefaultItem("basaltic_magma", new BasalticMagmaBlock(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).luminance(2)));


    /*
    Glass-like blocks
     */
    public static final Block QUARTZ_GLASS = registerBlockWithDefaultItem("quartz_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(2.0F, 6.0F)));
    public static final Block QUARTZ_GLASS_PANE = registerBlockWithDefaultItem("quartz_glass_pane", new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS_PANE).strength(2.0F, 6.0F)));

    public static final Block GLOW_GLASS = registerBlockWithDefaultItem("glow_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(10)));
    public static final Block GLOW_GLASS_PANE = registerBlockWithDefaultItem("glow_glass_pane", new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(10)));

    /*
    Utility Functions
     */

    public static void register() {
    }


}
