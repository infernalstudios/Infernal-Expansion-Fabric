package org.infernalstudios.infernalexp.registry;

import org.infernalstudios.infernalexp.block.BasaltIronOreBlock;
import org.infernalstudios.infernalexp.block.BasalticMagmaBlock;
import org.infernalstudios.infernalexp.block.GlowCampfireBlock;
import org.infernalstudios.infernalexp.block.GlowTorchBlock;
import org.infernalstudios.infernalexp.block.GlowWallTorchBlock;
import org.infernalstudios.infernalexp.block.GlowdustBlock;
import org.infernalstudios.infernalexp.block.LuminousFungusBlock;
import org.infernalstudios.infernalexp.block.TrappedGlowSandBlock;
import org.infernalstudios.infernalexp.block.templates.AbstractStoneButtonBlock;
import org.infernalstudios.infernalexp.block.templates.FungusCapBlock;
import org.infernalstudios.infernalexp.block.templates.LightUpPressurePlateBlock;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;

import java.util.function.ToIntFunction;

import static org.infernalstudios.infernalexp.util.IEBlockRegistration.registerBlock;
import static org.infernalstudios.infernalexp.util.IEBlockRegistration.registerBlockWithDefaultItem;

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
    Glowdust Stone Set
     */
    public static final Block GLOWDUST_STONE = registerBlockWithDefaultItem("glowdust_stone", new Block(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block GLOWDUST_STONE_SLAB = registerBlockWithDefaultItem("glowdust_stone_slab", new SlabBlock(FabricBlockSettings.copy(GLOWDUST_STONE)));
    public static final Block GLOWDUST_STONE_STAIRS = registerBlockWithDefaultItem("glowdust_stone_stairs", new StairsBlock(GLOWDUST_STONE.getDefaultState(), FabricBlockSettings.copy(GLOWDUST_STONE)));
    public static final Block GLOWDUST_STONE_WALL = registerBlockWithDefaultItem("glowdust_stone_wall", new WallBlock(FabricBlockSettings.copy(GLOWDUST_STONE)));

    /*
    Glowdust StoneBrick Set
     */
    public static final Block GLOWDUST_STONE_BRICKS = registerBlockWithDefaultItem("glowdust_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.SANDSTONE)));
    public static final Block GLOWDUST_STONE_BRICK_SLAB = registerBlockWithDefaultItem("glowdust_stone_brick_slab", new SlabBlock(FabricBlockSettings.copy(GLOWDUST_STONE_BRICKS)));
    public static final Block GLOWDUST_STONE_BRICK_STAIRS = registerBlockWithDefaultItem("glowdust_stone_brick_stairs", new StairsBlock(GLOWDUST_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(GLOWDUST_STONE_BRICKS)));
    public static final Block GLOWDUST_STONE_BRICK_WALL = registerBlockWithDefaultItem("glowdust_stone_brick_wall", new WallBlock(FabricBlockSettings.copy(GLOWDUST_STONE_BRICKS)));
    public static final Block CRACKED_GLOWDUST_STONE_BRICKS = registerBlockWithDefaultItem("cracked_glowdust_stone_bricks", new Block(FabricBlockSettings.copy(GLOWDUST_STONE_BRICKS)));
    public static final Block CHISELED_GLOWDUST_STONE_BRICKS = registerBlockWithDefaultItem("chiseled_glowdust_stone_bricks", new Block(FabricBlockSettings.copy(GLOWDUST_STONE_BRICKS)));

    /*
    Minor Ground Blocks
     */
    public static final Block CRUMBLING_BLACKSTONE = registerBlockWithDefaultItem("crumbling_blackstone", new Block(FabricBlockSettings.copyOf(Blocks.NETHERRACK)));
    public static final Block RUBBLE = registerBlockWithDefaultItem("rubble", new Block(FabricBlockSettings.copyOf(Blocks.GRAVEL)));
    public static final Block SILT = registerBlockWithDefaultItem("silt", new Block(FabricBlockSettings.copyOf(Blocks.SAND)));

    /*
    Cobbled Basalt Set
     */
    public static final Block BASALT_COBBLED = registerBlockWithDefaultItem("basalt_cobbled", new PillarBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL).sounds(BlockSoundGroup.BASALT)));
    public static final Block BASALT_COBBLED_SLAB = registerBlockWithDefaultItem("basalt_cobbled_slab", new SlabBlock(FabricBlockSettings.copy(BASALT_COBBLED)));

    /*
    Basalt Set
     */
    public static final Block BASALT_SLAB = registerBlockWithDefaultItem("basalt_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.BASALT)));
    public static final Block BASALT_STAIRS = registerBlockWithDefaultItem("basalt_stairs", new StairsBlock(Blocks.BASALT.getDefaultState(), FabricBlockSettings.copy(Blocks.BASALT)));
    public static final Block BASALT_WALL = registerBlockWithDefaultItem("basalt_wall", new WallBlock(FabricBlockSettings.copy(Blocks.BASALT)));
    public static final Block BASALT_BUTTON = registerBlockWithDefaultItem("basalt_button", new AbstractStoneButtonBlock(FabricBlockSettings.copy(Blocks.BASALT)));

    /*
    Basalt Brick Set
     */
    public static final Block BASALT_BRICKS = registerBlockWithDefaultItem("basalt_bricks", new PillarBlock(FabricBlockSettings.copy(Blocks.BASALT)));
    public static final Block BASALT_BRICK_SLAB = registerBlockWithDefaultItem("basalt_brick_slab", new SlabBlock(FabricBlockSettings.copy(BASALT_BRICKS)));
    public static final Block BASALT_BRICK_STAIRS = registerBlockWithDefaultItem("basalt_brick_stairs", new StairsBlock(Blocks.BASALT.getDefaultState(), FabricBlockSettings.copy(BASALT_BRICKS)));
    public static final Block BASALT_BRICK_WALL = registerBlockWithDefaultItem("basalt_brick_wall", new WallBlock(FabricBlockSettings.copy(BASALT_BRICKS)));
    public static final Block CRACKED_BASALT_BRICKS = registerBlockWithDefaultItem("cracked_basalt_bricks", new PillarBlock(FabricBlockSettings.copy(BASALT_BRICKS)));
    public static final Block CHISELED_BASALT_BRICKS = registerBlockWithDefaultItem("chiseled_basalt_bricks", new PillarBlock(FabricBlockSettings.copy(BASALT_BRICKS)));
    public static final Block MAGMATIC_CHISELED_BASALT_BRICKS = registerBlockWithDefaultItem("magmatic_chiseled_basalt_bricks", new PillarBlock(FabricBlockSettings.copy(BASALT_BRICKS)));

    /*
    Basalt Iron Ore
     */
    public static final Block BASALT_IRON_ORE = registerBlockWithDefaultItem("basalt_iron_ore", new BasaltIronOreBlock(FabricBlockSettings.copy(Blocks.NETHER_GOLD_ORE)));

    /*
    Basaltic Magma
     */
    public static final Block BASALTIC_MAGMA = registerBlockWithDefaultItem("basaltic_magma", new BasalticMagmaBlock(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).luminance(2)));

    /*
    Soul Soil
     */
    public static final Block SOUL_SAND_SLAB = registerBlockWithDefaultItem("soul_sand_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.SOUL_SAND)));
    public static final Block SOUL_SAND_STAIRS = registerBlockWithDefaultItem("soul_sand_stairs", new StairsBlock(Blocks.SOUL_SAND.getDefaultState(), FabricBlockSettings.copy(Blocks.SOUL_SAND)));

    /*
    Soul Soil Set
     */
    public static final Block SOUL_SOIL_SLAB = registerBlockWithDefaultItem("soul_soil_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.SOUL_SOIL)));
    public static final Block SOUL_SOIL_STAIRS = registerBlockWithDefaultItem("soul_soil_stairs", new StairsBlock(Blocks.SOUL_SOIL.getDefaultState(), FabricBlockSettings.copy(Blocks.SOUL_SOIL)));

    /*
    Soul Stone Set
     */
    public static final Block SOUL_STONE = registerBlockWithDefaultItem("soul_stone", new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).sounds(IEBlockSoundGroups.SOUL_STONE)));
    public static final Block SOUL_STONE_SLAB = registerBlockWithDefaultItem("soul_stone_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_STONE)));
    public static final Block SOUL_STONE_STAIRS = registerBlockWithDefaultItem("soul_stone_stairs", new StairsBlock(SOUL_STONE.getDefaultState(), FabricBlockSettings.copy(SOUL_STONE)));
    public static final Block SOUL_STONE_WALL = registerBlockWithDefaultItem("soul_stone_wall", new WallBlock(FabricBlockSettings.copy(SOUL_STONE)));

    /*
    Soul Slate Set
     */
    public static final Block SOUL_SLATE = registerBlockWithDefaultItem("soul_slate", new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS).sounds(IEBlockSoundGroups.SOUL_STONE)));
    public static final Block SOUL_SLATE_SLAB = registerBlockWithDefaultItem("soul_slate_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SLATE)));
    public static final Block SOUL_SLATE_STAIRS = registerBlockWithDefaultItem("soul_slate_stairs", new StairsBlock(SOUL_SLATE.getDefaultState(), FabricBlockSettings.copy(SOUL_SLATE)));
    public static final Block SOUL_SLATE_BUTTON = registerBlockWithDefaultItem("soul_slate_button", new AbstractStoneButtonBlock(FabricBlockSettings.copy(SOUL_SLATE)));
    public static final Block SOUL_SLATE_PRESSURE_PLATE = registerBlockWithDefaultItem("soul_slate_pressure_plate", new LightUpPressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.copyOf(SOUL_SLATE).luminance(getLuminanceValueLit(15))));

    /*
    Soul Stone Brick Set
     */
    public static final Block SOUL_STONE_BRICKS = registerBlockWithDefaultItem("soul_stone_bricks", new Block(FabricBlockSettings.copy(SOUL_STONE)));
    public static final Block SOUL_STONE_BRICK_SLAB = registerBlockWithDefaultItem("soul_stone_brick_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_STONE_BRICKS)));
    public static final Block SOUL_STONE_BRICK_STAIRS = registerBlockWithDefaultItem("soul_stone_brick_stairs", new StairsBlock(SOUL_STONE_BRICKS.getDefaultState(), FabricBlockSettings.copy(SOUL_STONE_BRICKS)));
    public static final Block SOUL_STONE_BRICK_WALL = registerBlockWithDefaultItem("soul_stone_brick_wall", new WallBlock(FabricBlockSettings.copy(SOUL_STONE_BRICKS)));
    public static final Block CRACKED_SOUL_STONE_BRICKS = registerBlockWithDefaultItem("cracked_soul_stone_bricks", new Block(FabricBlockSettings.copy(SOUL_STONE_BRICKS)));
    public static final Block CHISELED_SOUL_STONE_BRICKS = registerBlockWithDefaultItem("chiseled_soul_stone_bricks", new PillarBlock(FabricBlockSettings.copy(SOUL_STONE_BRICKS)));
    public static final Block CHARGED_CHISELED_SOUL_STONE_BRICKS = registerBlockWithDefaultItem("charged_chiseled_soul_stone_bricks", new PillarBlock(FabricBlockSettings.copy(SOUL_STONE_BRICKS)));

    /*
    Soul Slate Brick Set
     */
    public static final Block SOUL_SLATE_BRICKS = registerBlockWithDefaultItem("soul_slate_bricks", new Block(FabricBlockSettings.copy(SOUL_SLATE)));
    public static final Block SOUL_SLATE_BRICK_SLAB = registerBlockWithDefaultItem("soul_slate_brick_slab", new SlabBlock(FabricBlockSettings.copy(SOUL_SLATE_BRICKS)));
    public static final Block SOUL_SLATE_BRICK_STAIRS = registerBlockWithDefaultItem("soul_slate_brick_stairs", new StairsBlock(SOUL_SLATE_BRICKS.getDefaultState(), FabricBlockSettings.copy(SOUL_SLATE_BRICKS)));
    public static final Block SOUL_SLATE_BRICK_WALL = registerBlockWithDefaultItem("soul_slate_brick_wall", new WallBlock(FabricBlockSettings.copy(SOUL_SLATE_BRICKS)));
    public static final Block CRACKED_SOUL_SLATE_BRICKS = registerBlockWithDefaultItem("cracked_soul_slate_bricks", new Block(FabricBlockSettings.copy(SOUL_SLATE_BRICKS)));
    public static final Block CHISELED_SOUL_SLATE_BRICKS = registerBlockWithDefaultItem("chiseled_soul_slate_bricks", new PillarBlock(FabricBlockSettings.copy(SOUL_SLATE_BRICKS)));
    public static final Block CHARGED_CHISELED_SOUL_SLATE_BRICKS = registerBlockWithDefaultItem("charged_chiseled_soul_slate_bricks", new PillarBlock(FabricBlockSettings.copy(SOUL_SLATE_BRICKS)));

    /*
    Fungus Caps
     */
    public static final Block CRIMSON_FUNGUS_CAP = registerBlockWithDefaultItem("crimson_fungus_cap", new FungusCapBlock(FabricBlockSettings.copy(Blocks.NETHER_WART_BLOCK)));
    public static final Block WARPED_FUNGUS_CAP = registerBlockWithDefaultItem("warped_fungus_cap", new FungusCapBlock(FabricBlockSettings.copy(Blocks.WARPED_WART_BLOCK)));
    public static final Block LUMINOUS_FUNGUS_CAP = registerBlockWithDefaultItem("luminous_fungus_cap", new FungusCapBlock(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK).luminance(14)));

    /*
    Glow Set
     */
    public static final Block GLOW_LANTERN = registerBlockWithDefaultItem("glow_lantern", new LanternBlock(FabricBlockSettings.copy(Blocks.LANTERN)));
    public static final Block GLOW_TORCH = registerBlock("glow_torch", new GlowTorchBlock(FabricBlockSettings.copy(Blocks.TORCH)));
    public static final Block GLOW_TORCH_WALL = registerBlock("glow_torch_wall", new GlowWallTorchBlock(FabricBlockSettings.copy(GLOW_TORCH).dropsLike(GLOW_TORCH)));
    public static final Block GLOW_CAMPFIRE = registerBlockWithDefaultItem("glow_campfire", new GlowCampfireBlock(true, 2, FabricBlockSettings.copy(Blocks.CAMPFIRE)));

    /*
    Glowsilk Cocoon
     */
    public static final Block GLOWSILK_COCOON = registerBlockWithDefaultItem("glowsilk_cocoon", new PillarBlock(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.WOOL).requiresTool().breakByTool(FabricToolTags.HOES).strength(5.0F, 1200.F).luminance(5)));

    /*
    Luminous Fungus
     */
    public static final Block LUMINOUS_FUNGUS = registerBlockWithDefaultItem("luminous_fungus", new LuminousFungusBlock(FabricBlockSettings.of(Material.PLANT).luminance(getLuminanceValueLit(15)).noCollision().sounds(BlockSoundGroup.GRASS)));

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
