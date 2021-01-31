package dev.cernavskis.infernalexp.items;

import dev.cernavskis.infernalexp.InfernalExpansion;
import dev.cernavskis.infernalexp.blocks.IEBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IEItems {
    public static final Item GLOWCOAL = register("glowcoal", new IEItemBase());
    public static final Item DULLROCKS = register("glownuggets", new IEItemBase());
    public static final Item BLINDSIGHT_TONGUE = register("blindsight_tongue", new IEItemBase());

    public static final Item BLINDSIGHT_TONGUE_STEW = register("blindsight_tongue_stew", new SlurpSoupItem(new FabricItemSettings().maxCount(1).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST), 1.0F).build())));

    /*

    // Spawn Eggs
    public static final IESpawnEggItem VOLINE_SPAWN_EGG = register("voline_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.VOLINE, 0x2E2631, 0x652833, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem SHROOMLOIN_SPAWN_EGG = register("shroomloin_spawn_egg",() -> new IESpawnEggItem(ModEntityTypes.SHROOMLOIN, 0x854242, 0xFF6500, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem WARPBEETLE_SPAWN_EGG = register("warpbeetle_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.WARPBEETLE, 0x72EA95, 0x2D3860, new Item.Properties().group(InfernalExpansion.TAB)));
//  public static final IESpawnEggItem CEROBEETLE_SPAWN_EGG = register("cerobeetle_spawn_egg",() -> new IESpawnEggItem(ModEntityType.CEROBEETLE, 0x73EB96, 0x409089, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem EMBODY_SPAWN_EGG = register("embody_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.EMBODY, 0x796152, 0x6DEDF1, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem BASALT_GIANT_SPAWN_EGG = register("basalt_giant_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.BASALT_GIANT, 0x545454, 0xe36412, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem SKELETAL_PIGLIN_SPAWN_EGG = register("skeletal_piglin_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.SKELETAL_PIGLIN, 0xCBC9C9, 0x423C3C,new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem GLOWSQUITO_SPAWN_EGG = register("glowsquito_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.GLOWSQUITO, 0x383948, 0xe5c092, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem BLACKSTONE_DWARF_SPAWN_EGG = register ( "blackstone_dwarf_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.BLACKSTONE_DWARF, 0x1a1a1c, 0x36313f, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem BLINDSIGHT_SPAWN_EGG = register("blindsight_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.BLINDSIGHT, 0x312c36, 0xfbda74, new Item.Properties().group(InfernalExpansion.TAB)));
//  public static final IESpawnEggItem PYRNO_SPAWN_EGG = register("pyrno_spawn_egg", () -> new IESpawnEggItem(ModEntityType.PYRNO, 0x5D514B, 0xFEE15E, new Item.Properties().group(InfernalExpansion.TAB)));
    */
    
    // Block items
    public static final Item DIMSTONE = register("dimstone",                                  new IEBlockItemBase(IEBlocks.DIMSTONE));
    public static final Item DULLSTONE = register("dullstone",                                new IEBlockItemBase(IEBlocks.DULLSTONE));
    public static final Item SMOOTH_GLOWSTONE = register("smooth_glowstone",                  new IEBlockItemBase(IEBlocks.SMOOTH_GLOWSTONE));
    public static final Item SMOOTH_DIMSTONE = register("smooth_dimstone",                    new IEBlockItemBase(IEBlocks.SMOOTH_DIMSTONE));
    public static final Item SMOOTH_DULLSTONE = register("smooth_dullstone",                  new IEBlockItemBase(IEBlocks.SMOOTH_DULLSTONE));
    public static final Item GLOWSTONE_BRICK = register("glowstone_brick",                    new IEBlockItemBase(IEBlocks.GLOWSTONE_BRICK));
    public static final Item DIMSTONE_BRICK = register("dimstone_brick",                      new IEBlockItemBase(IEBlocks.DIMSTONE_BRICK));
    public static final Item DULLSTONE_BRICK = register("dullstone_brick",                    new IEBlockItemBase(IEBlocks.DULLSTONE_BRICK));
    public static final Item CRACKED_GLOWSTONE_BRICK = register("cracked_glowstone_brick",    new IEBlockItemBase(IEBlocks.CRACKED_GLOWSTONE_BRICK));
    public static final Item CRACKED_DIMSTONE_BRICK = register("cracked_dimstone_brick",      new IEBlockItemBase(IEBlocks.CRACKED_DIMSTONE_BRICK));
    public static final Item CRACKED_DULLSTONE_BRICK = register("cracked_dullstone_brick",    new IEBlockItemBase(IEBlocks.CRACKED_DULLSTONE_BRICK));
    public static final Item CHISELED_GLOWSTONE_BRICK = register("chiseled_glowstone_brick",  new IEBlockItemBase(IEBlocks.CHISELED_GLOWSTONE_BRICK));
    public static final Item CHISELED_DIMSTONE_BRICK = register("chiseled_dimstone_brick",    new IEBlockItemBase(IEBlocks.CHISELED_DIMSTONE_BRICK));
    public static final Item CHISELED_DULLSTONE_BRICK = register("chiseled_dullstone_brick",  new IEBlockItemBase(IEBlocks.CHISELED_DULLSTONE_BRICK));
    public static final Item SMOOTH_GLOWSTONE_SLAB = register("smooth_glowstone_slab",        new IEBlockItemBase(IEBlocks.SMOOTH_GLOWSTONE_SLAB));
    public static final Item SMOOTH_GLOWSTONE_STAIRS = register("smooth_glowstone_stairs",    new IEBlockItemBase(IEBlocks.SMOOTH_GLOWSTONE_STAIRS));
    public static final Item SMOOTH_DIMSTONE_SLAB = register("smooth_dimstone_slab",          new IEBlockItemBase(IEBlocks.SMOOTH_DIMSTONE_SLAB));
    public static final Item SMOOTH_DIMSTONE_STAIRS = register("smooth_dimstone_stairs",      new IEBlockItemBase(IEBlocks.SMOOTH_DIMSTONE_STAIRS));
    public static final Item SMOOTH_DULLSTONE_SLAB = register("smooth_dullstone_slab",        new IEBlockItemBase(IEBlocks.SMOOTH_DULLSTONE_SLAB));
    public static final Item SMOOTH_DULLSTONE_STAIRS = register("smooth_dullstone_stairs",    new IEBlockItemBase(IEBlocks.SMOOTH_DULLSTONE_STAIRS));
    public static final Item GLOWSTONE_BRICK_SLAB = register("glowstone_brick_slab",          new IEBlockItemBase(IEBlocks.GLOWSTONE_BRICK_SLAB));
    public static final Item GLOWSTONE_BRICK_STAIRS = register("glowstone_brick_stairs",      new IEBlockItemBase(IEBlocks.GLOWSTONE_BRICK_STAIRS));
    public static final Item DIMSTONE_BRICK_SLAB = register("dimstone_brick_slab",            new IEBlockItemBase(IEBlocks.DIMSTONE_BRICK_SLAB));
    public static final Item DIMSTONE_BRICK_STAIRS = register("dimstone_brick_stairs",        new IEBlockItemBase(IEBlocks.DIMSTONE_BRICK_STAIRS));
    public static final Item DULLSTONE_BRICK_SLAB = register("dullstone_brick_slab",          new IEBlockItemBase(IEBlocks.DULLSTONE_BRICK_SLAB));
    public static final Item DULLSTONE_BRICK_STAIRS = register("dullstone_brick_stairs",      new IEBlockItemBase(IEBlocks.DULLSTONE_BRICK_STAIRS));

    public static final Item GLOWDUST = register("glowdust",                  new IEBlockItemBase(IEBlocks.GLOWDUST));
    public static final Item GLOWDUST_SAND = register("glowdust_sand",            new IEBlockItemBase(IEBlocks.GLOWDUST_SAND));
    public static final Item GLOWDUST_STONE = register("glowdust_stone",              new IEBlockItemBase(IEBlocks.GLOWDUST_STONE));
    public static final Item GLOWDUST_STONE_BRICKS = register("glowdust_stone_bricks",    new IEBlockItemBase(IEBlocks.GLOWDUST_STONE_BRICKS));
    public static final Item GLOWDUST_STONE_BRICK_SLAB = register("glowdust_stone_brick_slab",        new IEBlockItemBase(IEBlocks.GLOWDUST_STONE_BRICK_SLAB));
    public static final Item GLOWDUST_STONE_BRICK_STAIRS = register("glowdust_stone_brick_stairs",    new IEBlockItemBase(IEBlocks.GLOWDUST_STONE_BRICK_STAIRS));
    public static final Item TRAPPED_GLOWDUST_SAND = register("trapped_glowdust_sand",        new IEBlockItemBase(IEBlocks.TRAPPED_GLOWDUST_SAND));
    public static final Item GLOWDUST_SANDSTONE = register("glowdust_sandstone",                  new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE));
    public static final Item CUT_GLOWDUST_SANDSTONE = register("cut_glowdust_sandstone",              new IEBlockItemBase(IEBlocks.CUT_GLOWDUST_SANDSTONE));
    public static final Item CHISELED_GLOWDUST_SANDSTONE = register("chiseled_glowdust_sandstone",        new IEBlockItemBase(IEBlocks.CHISELED_GLOWDUST_SANDSTONE));
    public static final Item SMOOTH_GLOWDUST_SANDSTONE = register("smooth_glowdust_sandstone",                new IEBlockItemBase(IEBlocks.SMOOTH_GLOWDUST_SANDSTONE));
    public static final Item GLOWDUST_SANDSTONE_SLAB = register("glowdust_sandstone_slab",                    new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE_SLAB));
    public static final Item GLOWDUST_SANDSTONE_STAIRS = register("glowdust_sandstone_stairs",                new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE_STAIRS));
    public static final Item CUT_GLOWDUST_SANDSTONE_SLAB = register("cut_glowdust_sandstone_slab",            new IEBlockItemBase(IEBlocks.CUT_GLOWDUST_SANDSTONE_SLAB));
    public static final Item SMOOTH_GLOWDUST_SANDSTONE_SLAB = register("smooth_glowdust_sandstone_slab",      new IEBlockItemBase(IEBlocks.SMOOTH_GLOWDUST_SANDSTONE_SLAB));
    public static final Item SMOOTH_GLOWDUST_SANDSTONE_STAIRS = register("smooth_glowdust_sandstone_stairs",  new IEBlockItemBase(IEBlocks.SMOOTH_GLOWDUST_SANDSTONE_STAIRS));
    public static final Item GLOWDUST_SANDSTONE_WALL = register("glowdust_sandstone_wall",                    new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE_WALL));
    
    public static final Item CRUMBLING_BLACKSTONE = register("crumbling_blackstone",  new IEBlockItemBase(IEBlocks.CRUMBLING_BLACKSTONE));
    public static final Item GLIMMERING_BLACKSTONE = register("glimmering_blackstone", new IEBlockItemBase(IEBlocks.GLIMMERING_BLACKSTONE));
    public static final Item SILT = register("silt", new IEBlockItemBase(IEBlocks.SILT));
    public static final Item RUBBLE = register("rubble", new IEBlockItemBase(IEBlocks.RUBBLE));

    public static final Item CRIMSON_FUNGUS_CAP = register("crimson_fungus_cap", new IEBlockItemBase(IEBlocks.CRIMSON_FUNGUS_CAP));
    public static final Item WARPED_FUNGUS_CAP = register("warped_fungus_cap", new IEBlockItemBase(IEBlocks.WARPED_FUNGUS_CAP));

    public static final Item GLOW_LANTERN = register("lantern_glow",      new IEBlockItemBase(IEBlocks.GLOW_LANTERN));
    public static final Item GLOW_TORCH = register("torch_glow",          new WallStandingBlockItem(IEBlocks.GLOW_TORCH, IEBlocks.GLOW_WALL_TORCH, new FabricItemSettings().group(InfernalExpansion.TAB)));
    // public static final Item GLOW_CAMPFIRE = register("campfire_glow",    new IEBlockItemBase(IEBlocks.GLOW_CAMPFIRE));
    /*
    public static final Item LUMINOUS_FUNGUS = register("luminous_fungus", new IEBlockItemBase(IEBlocks.LUMINOUS_FUNGUS));
    public static final Item DULLTHORNS = register("dullthorns",           new IEBlockItemBase(IEBlocks.DULLTHORNS));

    public static final Item SHROOMLIGHT_FUNGUS = register("shroomlight_fungus",      new IEBlockItemBase(IEBlocks.SHROOMLIGHT_FUNGUS));
    */
    public static final Item ASCUS_BOMB = register("ascus_bomb", new AscusBombItem());
    
    public static void init() { }
    
    public static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, id), item);
    }
}