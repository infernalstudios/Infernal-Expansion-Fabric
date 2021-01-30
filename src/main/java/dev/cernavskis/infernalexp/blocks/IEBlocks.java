package dev.cernavskis.infernalexp.blocks;


import dev.cernavskis.infernalexp.InfernalExpansion;
import dev.cernavskis.infernalexp.items.IEBlockItemBase;
import dev.cernavskis.infernalexp.items.IEItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IEBlocks {
    
    /*       A single file in /blockstates pulls from (potentially multiple files in)
    /model/block, which pulls from /textures/blocks all the different ways a block can look.
       (If a block is animated, pull the name of the animation texture.)
       /item pulls from the individual json file in /model/block.    */
    
    // Blocks
    public static final Block DIMSTONE = registerBlock("dimstone",            new Block(getProperties(Material.GLASS, 3.5F, 2.0F).sounds(BlockSoundGroup.GLASS).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(12)));
    public static final Block DULLSTONE = registerBlock("dullstone",          new Block(getProperties(Material.GLASS, 10.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(0)));
    public static final Block SMOOTH_GLOWSTONE = registerBlock("smooth_glowstone",    new Block(getProperties(Material.GLASS, 1.5F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().breakByTool(FabricToolTags.PICKAXES).luminance(15)));
    public static final Block SMOOTH_DIMSTONE = registerBlock("smooth_dimstone",      new Block(getProperties(SMOOTH_GLOWSTONE).luminance(value -> 12)));
    public static final Block SMOOTH_DULLSTONE = registerBlock("smooth_dullstone",    new Block(getProperties(SMOOTH_GLOWSTONE).luminance(value -> 0)));
    public static final Block GLOWSTONE_BRICK = registerBlock("glowstone_brick",      new Block(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block DIMSTONE_BRICK = registerBlock("dimstone_brick",        new Block(getProperties(SMOOTH_DIMSTONE)));
    public static final Block DULLSTONE_BRICK = registerBlock("dullstone_brick",      new Block(getProperties(SMOOTH_DULLSTONE)));
    public static final Block CRACKED_GLOWSTONE_BRICK = registerBlock("cracked_glowstone_brick",   new Block(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block CRACKED_DIMSTONE_BRICK = registerBlock("cracked_dimstone_brick",     new Block(getProperties(SMOOTH_DIMSTONE)));
    public static final Block CRACKED_DULLSTONE_BRICK = registerBlock("cracked_dullstone_brick",   new Block(getProperties(SMOOTH_DULLSTONE)));
    public static final Block CHISELED_GLOWSTONE_BRICK = registerBlock("chiseled_glowstone_brick", new Block(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block CHISELED_DIMSTONE_BRICK = registerBlock("chiseled_dimstone_brick",   new Block(getProperties(SMOOTH_DIMSTONE)));
    public static final Block CHISELED_DULLSTONE_BRICK = registerBlock("chiseled_dullstone_brick", new Block(getProperties(SMOOTH_DULLSTONE)));
    public static final Block SMOOTH_GLOWSTONE_SLAB = registerBlock("smooth_glowstone_slab",       new SlabBlock(getProperties(SMOOTH_GLOWSTONE)));
    public static final Block SMOOTH_GLOWSTONE_STAIRS = registerBlock("smooth_glowstone_stairs",   new IEStairsBlock(SMOOTH_GLOWSTONE.getDefaultState(), getProperties(SMOOTH_GLOWSTONE)));
    public static final Block SMOOTH_DIMSTONE_SLAB = registerBlock("smooth_dimstone_slab",         new SlabBlock(getProperties(SMOOTH_DIMSTONE)));
    public static final Block SMOOTH_DIMSTONE_STAIRS = registerBlock("smooth_dimstone_stairs",     new IEStairsBlock( SMOOTH_DIMSTONE.getDefaultState(), getProperties(SMOOTH_DIMSTONE)));
    public static final Block SMOOTH_DULLSTONE_SLAB = registerBlock("smooth_dullstone_slab",       new SlabBlock(getProperties(SMOOTH_DULLSTONE)));
    public static final Block SMOOTH_DULLSTONE_STAIRS = registerBlock("smooth_dullstone_stairs",   new IEStairsBlock(SMOOTH_DULLSTONE.getDefaultState(), getProperties(SMOOTH_DULLSTONE)));
    public static final Block GLOWSTONE_BRICK_SLAB = registerBlock("glowstone_brick_slab",         new SlabBlock(getProperties(GLOWSTONE_BRICK)));
    public static final Block GLOWSTONE_BRICK_STAIRS = registerBlock("glowstone_brick_stairs",     new IEStairsBlock(GLOWSTONE_BRICK.getDefaultState(), getProperties(GLOWSTONE_BRICK)));
    public static final Block DIMSTONE_BRICK_SLAB = registerBlock("dimstone_brick_slab",           new SlabBlock(getProperties(DIMSTONE_BRICK)));
    public static final Block DIMSTONE_BRICK_STAIRS = registerBlock("dimstone_brick_stairs",       new IEStairsBlock(DIMSTONE_BRICK.getDefaultState(), getProperties(DIMSTONE_BRICK)));
    public static final Block DULLSTONE_BRICK_SLAB = registerBlock("dullstone_brick_slab",         new SlabBlock(getProperties(DULLSTONE_BRICK)));
    public static final Block DULLSTONE_BRICK_STAIRS = registerBlock("dullstone_brick_stairs",     new IEStairsBlock(DULLSTONE_BRICK.getDefaultState(), getProperties(DULLSTONE_BRICK)));
    
    /*
    public static final Block GLOWDUST = registerBlock("glowdust", new GlowdustBlock(getProperties(Blocks.SAND).setLightLevel(value -> 8).setRequiresTool().harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.2f)));
    public static final Block GLOWDUST_SAND = registerBlock("glowdust_sand",          new GlowSandBlock(0xFFC267, getProperties(GLOWDUST.get()).hardnessAndResistance(0.5F)));
    public static final Block GLOWDUST_STONE = registerBlock("glowdust_stone",                new GlowBlockBase(getProperties(Blocks.SANDSTONE).setLightLevel(value -> 8)));
    public static final Block GLOWDUST_STONE_BRICKS = registerBlock("glowdust_stone_bricks",  new GlowBlockBase(getProperties(Blocks.SANDSTONE).setLightLevel(value -> 8)));
    public static final Block GLOWDUST_STONE_BRICK_SLAB = registerBlock("glowdust_stone_brick_slab",      new GlowBlockBase(getProperties(Blocks.SANDSTONE).setLightLevel(value -> 8)));
    public static final Block GLOWDUST_STONE_BRICK_STAIRS = registerBlock("glowdust_stone_brick_stairs",  new GlowBlockBase(getProperties(Blocks.SANDSTONE).setLightLevel(value -> 8)));
    public static final Block TRAPPED_GLOWDUST_SAND = registerBlock("trapped_glowdust_sand",  new TrappedGlowSandBlock(0xFFC267, getProperties(GLOWDUST.get()).hardnessAndResistance(0.2F).setLightLevel(value -> 4)));
    public static final Block GLOWDUST_SANDSTONE = registerBlock("glowdust_sandstone",                    new GlowBlockBase(getProperties(Blocks.SANDSTONE).setLightLevel(value -> 8)));
    public static final Block CUT_GLOWDUST_SANDSTONE = registerBlock("cut_glowdust_sandstone",            new Block(getProperties(GLOWDUST_SANDSTONE.get())));
    public static final Block CHISELED_GLOWDUST_SANDSTONE = registerBlock("chiseled_glowdust_sandstone",  new Block(getProperties(GLOWDUST_SANDSTONE.get())));
    public static final Block SMOOTH_GLOWDUST_SANDSTONE = registerBlock("smooth_glowdust_sandstone",      new Block(getProperties(GLOWDUST_SANDSTONE.get())));
    public static final Block GLOWDUST_SANDSTONE_SLAB = registerBlock("glowdust_sandstone_slab",          new SlabBlock(getProperties(GLOWDUST_SANDSTONE.get())));
    public static final Block GLOWDUST_SANDSTONE_STAIRS = registerBlock("glowdust_sandstone_stairs",      new StairsBlock(GLOWDUST_SANDSTONE.get().getDefaultState(), getProperties(GLOWDUST_SANDSTONE.get())));
    public static final Block CUT_GLOWDUST_SANDSTONE_SLAB = registerBlock("cut_glowdust_sandstone_slab",              new SlabBlock(getProperties(CUT_GLOWDUST_SANDSTONE.get())));
    public static final Block SMOOTH_GLOWDUST_SANDSTONE_SLAB = registerBlock("smooth_glowdust_sandstone_slab",        new SlabBlock(getProperties(SMOOTH_GLOWDUST_SANDSTONE.get())));
    public static final Block SMOOTH_GLOWDUST_SANDSTONE_STAIRS = registerBlock("smooth_glowdust_sandstone_stairs",    new StairsBlock(SMOOTH_GLOWDUST_SANDSTONE.get().getDefaultState(), getProperties(SMOOTH_GLOWDUST_SANDSTONE.get())));
    public static final Block GLOWDUST_SANDSTONE_WALL = registerBlock("glowdust_sandstone_wall",          new WallBlock(getProperties(GLOWDUST_SANDSTONE.get())));
    
    public static final Block CRUMBLING_BLACKSTONE = registerBlock("crumbling_blackstone",    new CrumblingBlackstoneBlock(AbstractBlock.Settings.from(Blocks.NETHERRACK)));
    public static final Block GLIMMERING_BLACKSTONE = registerBlock("glimmering_blackstone",  new Block(getProperties(Blocks.BLACKSTONE).setLightLevel(value -> 6)));
    public static final Block SILT = registerBlock("silt",        new Block(getProperties(Blocks.SAND)));
    public static final Block RUBBLE = registerBlock("rubble",    new Block(getProperties(Blocks.GRAVEL)));
    
    //public static final Block BASALT_IRON_ORE = registerBlock("basalt_iron_ore",        new Block(AbstractBlock.Properties.from(Blocks.NETHER_GOLD_ORE)));
    
    public static final Block CRIMSON_FUNGUS_CAP = registerBlock("crimson_fungus_cap",  new Block(AbstractBlock.Properties.from(Blocks.NETHER_WART_BLOCK)));
    public static final Block WARPED_FUNGUS_CAP = registerBlock("warped_fungus_cap",    new Block(AbstractBlock.Properties.from(Blocks.WARPED_WART_BLOCK)));
    
    
    public static final Block GLOW_LANTERN = registerBlock("lantern_glow",        new LanternBlock(getProperties(Blocks.LANTERN)));
    public static final Block GLOW_TORCH = registerBlock("torch_glow",            new TorchBlock(getProperties(Blocks.TORCH), ParticleTypes.CRIT));
    public static final Block GLOW_WALL_TORCH = registerBlock("torch_glow_wall",  new WallTorchBlock(getProperties(ModBlocks.GLOW_TORCH.get()).lootFrom(GLOW_TORCH.get()), ParticleTypes.CRIT));
    public static final Block GLOW_CAMPFIRE = registerBlock("campfire_glow",      new GlowCampfireBlock(true, 2, getProperties(Blocks.CAMPFIRE)));
    public static final Block GLOW_FIRE = registerBlock("fire_glow",              new GlowFireBlock(getProperties(Blocks.FIRE)));
    
    // Foliage
    public static final Block LUMINOUS_FUNGUS = registerBlock("luminous_fungus",  new LuminousFungusBlock(getProperties(Material.PLANTS).setLightLevel(value -> 13).doesNotBlockMovement().sound(SoundType.PLANT)));
    public static final Block DULLTHORNS = registerBlock("dullthorns",            new DullthornsBlock(AbstractBlock.Properties.create(Material.CACTUS).setLightLevel(value -> 3).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.PLANT)));
    
    public static final FlowerPotBlock POTTED_LUMINOUS_FUNGUS = registerBlock("potted_luminous_fungus",   new FlowerPotBlock((FlowerPotBlock) Blocks.FLOWER_POT, LUMINOUS_FUNGUS, getProperties(Blocks.FLOWER_POT)));
    public static final FlowerPotBlock POTTED_DULLTHORNS = registerBlock("potted_dullthorns",             new FlowerPotBlock((FlowerPotBlock) Blocks.FLOWER_POT, DULLTHORNS, getProperties(Blocks.FLOWER_POT)));
    
    public static final Block SHROOMLIGHT_FUNGUS = registerBlock("shroomlight_fungus",                        new ShroomlightFungusBlock(getProperties(Material.PLANTS).setLightLevel(value -> 13).doesNotBlockMovement().sound(SoundType.PLANT)));
    public static final FlowerPotBlock POTTED_SHROOMLIGHT_FUNGUS = registerBlock("potted_shroomlight_fungus", new FlowerPotBlock((FlowerPotBlock) Blocks.FLOWER_POT, SHROOMLIGHT_FUNGUS, getProperties(Blocks.FLOWER_POT)));

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
    
    public static void registerBlocks() {
        InfernalExpansion.LOGGER.info("Infernal Expansion: Blocks Registered!");
    }
    
    public static Block registerBlock(String id, Block block, boolean registerItem) {
        return registerBlock(id, block, true, new FabricItemSettings());
    }
    
    public static Block registerBlock(String id, Block block, boolean registerItem, Settings settings) {
        if (registerItem) {
            IEItems.registerItem(id, (Item) new IEBlockItemBase(block, settings));
        }
        return Registry.register(Registry.BLOCK, new Identifier(InfernalExpansion.MOD_ID, id), block);
    }
    
    public static Block registerBlock(String id, Block block) {
        return registerBlock(id, block, true);
    }
}