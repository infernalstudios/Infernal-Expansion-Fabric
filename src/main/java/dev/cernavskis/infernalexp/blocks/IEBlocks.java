package dev.cernavskis.infernalexp.blocks;


import dev.cernavskis.infernalexp.InfernalExpansion;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IEBlocks {
    
    /*       A single file in /blockstates pulls from (potentially multiple files in)
    /model/block, which pulls from /textures/blocks all the different ways a block can look.
       (If a block is animated, pull the name of the animation texture.)
       /item pulls from the individual json file in /model/block.    */
    
    // Blocks
    public static final Block DIMSTONE = register("dimstone",            new Block(getProperties(Material.GLASS, 3.5F, 2.0F).sounds(BlockSoundGroup.GLASS).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(12)));
    public static final Block DULLSTONE = register("dullstone",          new Block(getProperties(Material.GLASS, 10.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(0)));
    public static final Block SMOOTH_GLOWSTONE = register("smooth_glowstone",    new Block(getProperties(Material.GLASS, 1.5F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(15)));
    public static final Block SMOOTH_DIMSTONE = register("smooth_dimstone",      new Block(getProperties(SMOOTH_GLOWSTONE).luminance(12)));
    public static final Block SMOOTH_DULLSTONE = register("smooth_dullstone",    new Block(getProperties(SMOOTH_GLOWSTONE).luminance(0)));
    public static final Block GLOWSTONE_BRICK = register("glowstone_brick",      new Block(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block DIMSTONE_BRICK = register("dimstone_brick",        new Block(getProperties(SMOOTH_DIMSTONE)));
    public static final Block DULLSTONE_BRICK = register("dullstone_brick",      new Block(getProperties(SMOOTH_DULLSTONE)));
    public static final Block CRACKED_GLOWSTONE_BRICK = register("cracked_glowstone_brick",   new Block(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block CRACKED_DIMSTONE_BRICK = register("cracked_dimstone_brick",     new Block(getProperties(SMOOTH_DIMSTONE)));
    public static final Block CRACKED_DULLSTONE_BRICK = register("cracked_dullstone_brick",   new Block(getProperties(SMOOTH_DULLSTONE)));
    public static final Block CHISELED_GLOWSTONE_BRICK = register("chiseled_glowstone_brick", new Block(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block CHISELED_DIMSTONE_BRICK = register("chiseled_dimstone_brick",   new Block(getProperties(SMOOTH_DIMSTONE)));
    public static final Block CHISELED_DULLSTONE_BRICK = register("chiseled_dullstone_brick", new Block(getProperties(SMOOTH_DULLSTONE)));
    public static final Block SMOOTH_GLOWSTONE_SLAB = register("smooth_glowstone_slab",       new SlabBlock(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block SMOOTH_GLOWSTONE_STAIRS = register("smooth_glowstone_stairs",   new IEStairsBlock(SMOOTH_GLOWSTONE.getDefaultState(), getProperties(SMOOTH_GLOWSTONE)));
    public static final Block SMOOTH_DIMSTONE_SLAB = register("smooth_dimstone_slab",         new SlabBlock(getProperties(SMOOTH_DIMSTONE)));
    public static final Block SMOOTH_DIMSTONE_STAIRS = register("smooth_dimstone_stairs",     new IEStairsBlock(SMOOTH_DIMSTONE.getDefaultState(), getProperties(SMOOTH_DIMSTONE)));
    public static final Block SMOOTH_DULLSTONE_SLAB = register("smooth_dullstone_slab",       new SlabBlock(getProperties(SMOOTH_DULLSTONE)));
    public static final Block SMOOTH_DULLSTONE_STAIRS = register("smooth_dullstone_stairs",   new IEStairsBlock(SMOOTH_DULLSTONE.getDefaultState(), getProperties(SMOOTH_DULLSTONE)));
    public static final Block GLOWSTONE_BRICK_SLAB = register("glowstone_brick_slab",         new SlabBlock(getProperties(GLOWSTONE_BRICK)));
    public static final Block GLOWSTONE_BRICK_STAIRS = register("glowstone_brick_stairs",     new IEStairsBlock(GLOWSTONE_BRICK.getDefaultState(), getProperties(GLOWSTONE_BRICK)));
    public static final Block DIMSTONE_BRICK_SLAB = register("dimstone_brick_slab",           new SlabBlock(getProperties(DIMSTONE_BRICK)));
    public static final Block DIMSTONE_BRICK_STAIRS = register("dimstone_brick_stairs",       new IEStairsBlock(DIMSTONE_BRICK.getDefaultState(), getProperties(DIMSTONE_BRICK)));
    public static final Block DULLSTONE_BRICK_SLAB = register("dullstone_brick_slab",         new SlabBlock(getProperties(DULLSTONE_BRICK)));
    public static final Block DULLSTONE_BRICK_STAIRS = register("dullstone_brick_stairs",     new IEStairsBlock(DULLSTONE_BRICK.getDefaultState(), getProperties(DULLSTONE_BRICK)));
    
    public static final Block GLOWDUST = register("glowdust", new GlowDustBlock(getProperties(Blocks.SAND).luminance(8).requiresTool().breakByTool(FabricToolTags.SHOVELS).strength(0.2f)));
    public static final Block GLOWDUST_SAND = register("glowdust_sand",   new GlowSandBlock(0xFFC267, getProperties(GLOWDUST).strength(0.5F)));
    public static final Block GLOWDUST_STONE = register("glowdust_stone", new Block(getProperties(Blocks.SANDSTONE).luminance(8)));
    public static final Block GLOWDUST_STONE_BRICKS = register("glowdust_stone_bricks",  new Block(getProperties(Blocks.SANDSTONE).luminance(8)));
    public static final Block GLOWDUST_STONE_BRICK_SLAB = register("glowdust_stone_brick_slab",      new Block(getProperties(Blocks.SANDSTONE).luminance(8)));
    public static final Block GLOWDUST_STONE_BRICK_STAIRS = register("glowdust_stone_brick_stairs",  new Block(getProperties(Blocks.SANDSTONE).luminance(8)));
    public static final Block TRAPPED_GLOWDUST_SAND = register("trapped_glowdust_sand",  new TrappedGlowSandBlock(0xFFC267, getProperties(GLOWDUST).strength(0.2F).luminance(4)));
    public static final Block GLOWDUST_SANDSTONE = register("glowdust_sandstone",                    new Block(getProperties(Blocks.SANDSTONE).luminance(8)));
    public static final Block CUT_GLOWDUST_SANDSTONE = register("cut_glowdust_sandstone",            new Block(getProperties(GLOWDUST_SANDSTONE)));
    public static final Block CHISELED_GLOWDUST_SANDSTONE = register("chiseled_glowdust_sandstone",  new Block(getProperties(GLOWDUST_SANDSTONE)));
    public static final Block SMOOTH_GLOWDUST_SANDSTONE = register("smooth_glowdust_sandstone",      new Block(getProperties(GLOWDUST_SANDSTONE)));
    public static final Block GLOWDUST_SANDSTONE_SLAB = register("glowdust_sandstone_slab",          new SlabBlock(getProperties(GLOWDUST_SANDSTONE)));
    public static final Block GLOWDUST_SANDSTONE_STAIRS = register("glowdust_sandstone_stairs",      new IEStairsBlock(GLOWDUST_SANDSTONE.getDefaultState(), getProperties(GLOWDUST_SANDSTONE)));
    public static final Block CUT_GLOWDUST_SANDSTONE_SLAB = register("cut_glowdust_sandstone_slab",              new SlabBlock(getProperties(CUT_GLOWDUST_SANDSTONE)));
    public static final Block SMOOTH_GLOWDUST_SANDSTONE_SLAB = register("smooth_glowdust_sandstone_slab",        new SlabBlock(getProperties(SMOOTH_GLOWDUST_SANDSTONE)));
    public static final Block SMOOTH_GLOWDUST_SANDSTONE_STAIRS = register("smooth_glowdust_sandstone_stairs",    new IEStairsBlock(SMOOTH_GLOWDUST_SANDSTONE.getDefaultState(), getProperties(SMOOTH_GLOWDUST_SANDSTONE)));
    public static final Block GLOWDUST_SANDSTONE_WALL = register("glowdust_sandstone_wall",          new WallBlock(getProperties(GLOWDUST_SANDSTONE)));
    

    public static final Block CRUMBLING_BLACKSTONE = register("crumbling_blackstone",    new CrumblingBlackstoneBlock(getProperties(Blocks.NETHERRACK)));
    public static final Block GLIMMERING_BLACKSTONE = register("glimmering_blackstone",  new Block(getProperties(Blocks.BLACKSTONE).luminance(6)));
    public static final Block SILT = register("silt",        new Block(getProperties(Blocks.SAND)));
    public static final Block RUBBLE = register("rubble",    new Block(getProperties(Blocks.GRAVEL)));
    
    //public static final Block BASALT_IRON_ORE = register("basalt_iron_ore",        new Block(AbstractBlock.Properties.from(Blocks.NETHER_GOLD_ORE)));
    
    public static final Block CRIMSON_FUNGUS_CAP = register("crimson_fungus_cap",  new Block(getProperties(Blocks.NETHER_WART_BLOCK)));
    public static final Block WARPED_FUNGUS_CAP = register("warped_fungus_cap",    new Block(getProperties(Blocks.WARPED_WART_BLOCK)));
    
    
    public static final Block GLOW_LANTERN = register("lantern_glow",        new LanternBlock(getProperties(Blocks.LANTERN)));
    public static final Block GLOW_TORCH = register("torch_glow",            new IETorchBlock(getProperties(Blocks.TORCH), ParticleTypes.CRIT));
    public static final Block GLOW_WALL_TORCH = register("torch_glow_wall",  new IEWallTorchBlock(getProperties(GLOW_TORCH).dropsLike(GLOW_TORCH), ParticleTypes.CRIT));
    // public static final Block GLOW_CAMPFIRE = register("campfire_glow",      new GlowCampfireBlock(true, 2, getProperties(Blocks.CAMPFIRE)));

    public static final Block GLOW_FIRE = register("fire_glow", new GlowFireBlock(getProperties(Blocks.FIRE)));
    /*
    // Foliage
    public static final Block LUMINOUS_FUNGUS = register("luminous_fungus",  new LuminousFungusBlock(getProperties(Material.PLANTS).luminance(13).doesNotBlockMovement().sound(SoundType.PLANT)));
    public static final Block DULLTHORNS = register("dullthorns",            new DullthornsBlock(AbstractBlock.Properties.create(Material.CACTUS).luminance(3).doesNotBlockMovement().tickRandomly().strength(0.1F).sound(SoundType.PLANT)));
    
    public static final FlowerPotBlock POTTED_LUMINOUS_FUNGUS = register("potted_luminous_fungus",   new FlowerPotBlock((FlowerPotBlock) Blocks.FLOWER_POT, LUMINOUS_FUNGUS, getProperties(Blocks.FLOWER_POT)));
    public static final FlowerPotBlock POTTED_DULLTHORNS = register("potted_dullthorns",             new FlowerPotBlock((FlowerPotBlock) Blocks.FLOWER_POT, DULLTHORNS, getProperties(Blocks.FLOWER_POT)));
    
    public static final Block SHROOMLIGHT_FUNGUS = register("shroomlight_fungus",                        new ShroomlightFungusBlock(getProperties(Material.PLANTS).luminance(13).doesNotBlockMovement().sound(SoundType.PLANT)));
    public static final FlowerPotBlock POTTED_SHROOMLIGHT_FUNGUS = register("potted_shroomlight_fungus", new FlowerPotBlock((FlowerPotBlock) Blocks.FLOWER_POT, SHROOMLIGHT_FUNGUS, getProperties(Blocks.FLOWER_POT)));
    */


    public static FabricBlockSettings getProperties(Material material, float hardnessAndResistance) {
        return getProperties(material, hardnessAndResistance, hardnessAndResistance);
    }

    public static FabricBlockSettings getProperties(Material material, float hardness, float resistance) {
        return FabricBlockSettings.of(material).strength(hardness, resistance);
    }
    public static FabricBlockSettings getProperties(Material material) {
        return FabricBlockSettings.of(material).breakInstantly();
    }

    public static FabricBlockSettings getProperties(Block block) {
        return FabricBlockSettings.copyOf(block);
    }
    
    public static void init() { }
    
    public static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(InfernalExpansion.MOD_ID, id), block);
    }
}