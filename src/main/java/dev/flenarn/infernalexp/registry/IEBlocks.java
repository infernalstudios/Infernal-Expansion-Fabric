package dev.flenarn.infernalexp.registry;

import dev.flenarn.infernalexp.blocks.BasalticMagmaBlock;
import dev.flenarn.infernalexp.blocks.GlowdustBlock;
import dev.flenarn.infernalexp.blocks.TrappedGlowSandBlock;
import dev.flenarn.infernalexp.blocks.templates.AbstractStoneButtonBlock;
import dev.flenarn.infernalexp.blocks.templates.LightUpPressurePlateBlock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;

import java.util.function.ToIntFunction;

import static dev.flenarn.infernalexp.util.IEBlockRegistration.registerBlock;
import static dev.flenarn.infernalexp.util.IEBlockRegistration.registerBlockWithDefaultItem;

public class IEBlocks {

    /*
     All blocks added by Infernal Expansion are registered here.
     */

    /*
    Base Set
     */
    public static final Block DIMSTONE = registerBlockWithDefaultItem("dimstone", new Block(FabricBlockSettings.of(Material.GLASS).strength(1.8F, 2.0F).sounds(IEBlockSoundGroups.DIMSTONE).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(12)));
    public static final Block DULLSTONE = registerBlockWithDefaultItem("dullstone", new Block(FabricBlockSettings.of(Material.GLASS).strength(1.5F, 6.0F).sounds(IEBlockSoundGroups.DULLSTONE).requiresTool().breakByTool(FabricToolTags.PICKAXES)));

    /*
    Smooth Base Set
     */
    public static final Block SMOOTH_GLOWSTONE = registerBlockWithDefaultItem("smooth_glowstone", new Block(FabricBlockSettings.of(Material.GLASS).strength(1.5F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(15)));
    public static final Block SMOOTH_DIMSTONE = registerBlockWithDefaultItem("smooth_dimstone", new Block(FabricBlockSettings.copy(DIMSTONE).strength(1.5F, 6.0F)));
    public static final Block SMOOTH_DULLSTONE = registerBlockWithDefaultItem("smooth_dullstone", new Block(FabricBlockSettings.copy(DULLSTONE).strength(1.5F, 6.0F)));

    /*
    Brick Base Set
     */
    public static final Block GLOWSTONE_BRICKS = registerBlockWithDefaultItem("glowstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_GLOWSTONE)));
    public static final Block DIMSTONE_BRICKS = registerBlockWithDefaultItem("dimstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_DIMSTONE)));
    public static final Block DULLSTONE_BRICKS = registerBlockWithDefaultItem("dullstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_DULLSTONE)));

    /*
    Cracked Brick Base Set
     */
    public static final Block CRACKED_GLOWSTONE_BRICKS = registerBlockWithDefaultItem("cracked_glowstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_GLOWSTONE)));
    public static final Block CRACKED_DIMSTONE_BRICKS = registerBlockWithDefaultItem("cracked_dimstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_DIMSTONE)));
    public static final Block CRACKED_DULLSTONE_BRICKS = registerBlockWithDefaultItem("cracked_dullstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_DULLSTONE)));

    /*
    Chiseled Brick Base Set
     */
    public static final Block CHISELED_GLOWSTONE_BRICKS = registerBlockWithDefaultItem("chiseled_glowstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_GLOWSTONE)));
    public static final Block CHISELED_DIMSTONE_BRICKS = registerBlockWithDefaultItem("chiseled_dimstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_DIMSTONE)));
    public static final Block CHISELED_DULLSTONE_BRICKS = registerBlockWithDefaultItem("chiseled_dullstone_bricks", new Block(FabricBlockSettings.copy(SMOOTH_DULLSTONE)));

    /*
    Smooth Glowstone Set
     */
    public static final Block SMOOTH_GLOWSTONE_SLAB = registerBlockWithDefaultItem("smooth_glowstone_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_GLOWSTONE)));
    public static final Block SMOOTH_GLOWSTONE_STAIRS = registerBlockWithDefaultItem("smooth_glowstone_stairs", new StairsBlock(SMOOTH_GLOWSTONE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_GLOWSTONE)));
    public static final Block SMOOTH_GLOWSTONE_BUTTON = registerBlockWithDefaultItem("smooth_glowstone_button", new AbstractStoneButtonBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GLASS).luminance(15).noCollision()));
    public static final Block SMOOTH_GLOWSTONE_PRESSURE_PLATE = registerBlockWithDefaultItem("smooth_glowstone_pressure_plate", new LightUpPressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.copy(SMOOTH_GLOWSTONE).luminance(getLuminanceValueLit(15))));

    /*
    Smooth Dimstone Set
     */
    public static final Block SMOOTH_DIMSTONE_SLAB = registerBlockWithDefaultItem("smooth_dimstone_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_DIMSTONE)));
    public static final Block SMOOTH_DIMSTONE_STAIRS = registerBlockWithDefaultItem("smooth_dimstone_stairs", new StairsBlock(SMOOTH_DIMSTONE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_DIMSTONE)));
    public static final Block SMOOTH_DIMSTONE_BUTTON = registerBlockWithDefaultItem("smooth_dimstone_button", new AbstractStoneButtonBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GLASS).luminance(12).noCollision()));

    /*
    Smooth Dullstone Set
     */
    public static final Block SMOOTH_DULLSTONE_SLAB = registerBlockWithDefaultItem("smooth_dullstone_slab", new SlabBlock(FabricBlockSettings.copy(SMOOTH_DULLSTONE)));
    public static final Block SMOOTH_DULLSTONE_STAIRS = registerBlockWithDefaultItem("smooth_dullstone_stairs", new StairsBlock(SMOOTH_DULLSTONE.getDefaultState(), FabricBlockSettings.copy(SMOOTH_DULLSTONE)));
    public static final Block SMOOTH_DULLSTONE_BUTTON = registerBlockWithDefaultItem("smooth_dullstone_button", new AbstractStoneButtonBlock(FabricBlockSettings.of(Material.DECORATION).strength(0.5F, 0.5F).sounds(IEBlockSoundGroups.DULLSTONE).noCollision()));

    /*
    Glowstone Brick Set
     */
    public static final Block GLOWSTONE_BRICK_SLAB = registerBlockWithDefaultItem("glowstone_brick_slab", new SlabBlock(FabricBlockSettings.copy(GLOWSTONE_BRICKS)));
    public static final Block GLOWSTONE_BRICK_STAIRS = registerBlockWithDefaultItem("glowstone_brick_stairs", new StairsBlock(GLOWSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(GLOWSTONE_BRICKS)));
    public static final Block GLOWSTONE_BRICK_WALL = registerBlockWithDefaultItem("glowstone_brick_wall", new WallBlock(FabricBlockSettings.copy(GLOWSTONE_BRICKS)));

    /*
    Dimstone Brick Set
     */
    public static final Block DIMSTONE_BRICK_SLAB = registerBlockWithDefaultItem("dimstone_brick_slab", new SlabBlock(FabricBlockSettings.copy(DIMSTONE_BRICKS)));
    public static final Block DIMSTONE_BRICK_STAIRS = registerBlockWithDefaultItem("dimstone_brick_stairs", new StairsBlock(DIMSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(DIMSTONE_BRICKS)));
    public static final Block DIMSTONE_BRICK_WALL = registerBlockWithDefaultItem("dimstone_brick_wall", new WallBlock(FabricBlockSettings.copy(DIMSTONE_BRICKS)));

    /*
    Dullstone Brick Set
     */
    public static final Block DULLSTONE_BRICK_SLAB = registerBlockWithDefaultItem("dullstone_brick_slab", new SlabBlock(FabricBlockSettings.copy(DULLSTONE_BRICKS)));
    public static final Block DULLSTONE_BRICK_STAIRS = registerBlockWithDefaultItem("dullstone_brick_stairs", new StairsBlock(DULLSTONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(DULLSTONE_BRICKS)));
    public static final Block DULLSTONE_BRICK_WALL = registerBlockWithDefaultItem("dullstone_brick_wall", new WallBlock(FabricBlockSettings.copy(DULLSTONE_BRICKS)));

    /*
    Luminous Wart
     */
    public static final Block LUMINOUS_WART_BLOCK = registerBlockWithDefaultItem("luminous_wart_block", new Block(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK).luminance(8)));

    /*
    Glowdust Set
     */
    public static final Block GLOWDUST_SAND = registerBlockWithDefaultItem("glowdust_sand", new SandBlock(0xFFC267, FabricBlockSettings.of(Material.SNOW_BLOCK, MapColor.PALE_YELLOW).requiresTool().breakByTool(FabricToolTags.SHOVELS).strength(0.2F, 0.2F).sounds(BlockSoundGroup.SAND)));
    public static final Block GLOWDUST = registerBlockWithDefaultItem("glowdust", new GlowdustBlock(FabricBlockSettings.of(Material.SNOW_BLOCK, MapColor.PALE_YELLOW).requiresTool().breakByTool(FabricToolTags.SHOVELS).strength(0.2F, 0.2F).sounds(BlockSoundGroup.SAND)));
    public static final Block TRAPPED_GLOWDUST_SAND = registerBlockWithDefaultItem("trapped_glowdust_sand", new TrappedGlowSandBlock(0xFFC267, FabricBlockSettings.copyOf(GLOWDUST_SAND).luminance(5)));

    /*
    Minor Ground Blocks
     */
    public static final Block CRUMBLING_BLACKSTONE = registerBlockWithDefaultItem("crumbling_blackstone", new Block(FabricBlockSettings.copyOf(Blocks.NETHERRACK)));
    public static final Block RUBBLE = registerBlockWithDefaultItem("rubble", new Block(FabricBlockSettings.copyOf(Blocks.GRAVEL)));
    public static final Block SILT = registerBlockWithDefaultItem("silt", new Block(FabricBlockSettings.copyOf(Blocks.SAND)));

    public static final Block BASALTIC_MAGMA = registerBlockWithDefaultItem("basaltic_magma", new BasalticMagmaBlock(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).luminance(2)));

    /*
    Glass Set
     */
    public static final Block QUARTZ_GLASS = registerBlockWithDefaultItem("quartz_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).strength(2.0F, 6.0F)));
    public static final Block QUARTZ_GLASS_PANE = registerBlockWithDefaultItem("quartz_glass_pane", new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS_PANE).strength(2.0F, 6.0F)));

    public static final Block GLOW_GLASS = registerBlockWithDefaultItem("glow_glass", new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(10)));
    public static final Block GLOW_GLASS_PANE = registerBlockWithDefaultItem("glow_glass_pane", new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(10)));

    /*
    Utility Functions
     */

    @SuppressWarnings("unused")
    public static void register() {
    }

    private static ToIntFunction<BlockState> getLuminanceValueLit(int luminanceLevel) {
        return (state) -> state.get(Properties.LIT) ? luminanceLevel : 0;
    }


}
