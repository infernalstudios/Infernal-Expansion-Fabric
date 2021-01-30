package dev.cernavskis.infernalexp.items;

import dev.cernavskis.infernalexp.InfernalExpansion;
import dev.cernavskis.infernalexp.blocks.IEBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IEItems {
    public static final Item GLOWCOAL = new IEItemBase();
    public static final Item DULLROCKS = new IEItemBase();
    public static final Item BLINDSIGHT_TONGUE = new IEItemBase();

    public static final Item BLINDSIGHT_TONGUE_STEW = new SlurpSoupItem(new FabricItemSettings().maxCount(1).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST), 1.0F).build()));

    /*

    // Spawn Eggs
    public static final IESpawnEggItem VOLINE_SPAWN_EGG = ITEMS.register("voline_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.VOLINE, 0x2E2631, 0x652833, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem SHROOMLOIN_SPAWN_EGG = ITEMS.register("shroomloin_spawn_egg",() -> new IESpawnEggItem(ModEntityTypes.SHROOMLOIN, 0x854242, 0xFF6500, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem WARPBEETLE_SPAWN_EGG = ITEMS.register("warpbeetle_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.WARPBEETLE, 0x72EA95, 0x2D3860, new Item.Properties().group(InfernalExpansion.TAB)));
//  public static final IESpawnEggItem CEROBEETLE_SPAWN_EGG = ITEMS.register("cerobeetle_spawn_egg",() -> new IESpawnEggItem(ModEntityType.CEROBEETLE, 0x73EB96, 0x409089, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem EMBODY_SPAWN_EGG = ITEMS.register("embody_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.EMBODY, 0x796152, 0x6DEDF1, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem BASALT_GIANT_SPAWN_EGG = ITEMS.register("basalt_giant_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.BASALT_GIANT, 0x545454, 0xe36412, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem SKELETAL_PIGLIN_SPAWN_EGG = ITEMS.register("skeletal_piglin_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.SKELETAL_PIGLIN, 0xCBC9C9, 0x423C3C,new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem GLOWSQUITO_SPAWN_EGG = ITEMS.register("glowsquito_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.GLOWSQUITO, 0x383948, 0xe5c092, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem BLACKSTONE_DWARF_SPAWN_EGG = ITEMS.register ( "blackstone_dwarf_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.BLACKSTONE_DWARF, 0x1a1a1c, 0x36313f, new Item.Properties().group(InfernalExpansion.TAB)));
    public static final IESpawnEggItem BLINDSIGHT_SPAWN_EGG = ITEMS.register("blindsight_spawn_egg", () -> new IESpawnEggItem(ModEntityTypes.BLINDSIGHT, 0x312c36, 0xfbda74, new Item.Properties().group(InfernalExpansion.TAB)));
//  public static final IESpawnEggItem PYRNO_SPAWN_EGG = ITEMS.register("pyrno_spawn_egg", () -> new IESpawnEggItem(ModEntityType.PYRNO, 0x5D514B, 0xFEE15E, new Item.Properties().group(InfernalExpansion.TAB)));
    */
    
    // Block items
    public static final Item DIMSTONE = new IEBlockItemBase(IEBlocks.DIMSTONE);
    public static final Item DULLSTONE = new IEBlockItemBase(IEBlocks.DULLSTONE);
    public static final Item SMOOTH_GLOWSTONE = new IEBlockItemBase(IEBlocks.SMOOTH_GLOWSTONE);
    public static final Item SMOOTH_DIMSTONE = new IEBlockItemBase(IEBlocks.SMOOTH_DIMSTONE);
    public static final Item SMOOTH_DULLSTONE = new IEBlockItemBase(IEBlocks.SMOOTH_DULLSTONE);
    public static final Item GLOWSTONE_BRICK = new IEBlockItemBase(IEBlocks.GLOWSTONE_BRICK);
    public static final Item DIMSTONE_BRICK = new IEBlockItemBase(IEBlocks.DIMSTONE_BRICK);
    public static final Item DULLSTONE_BRICK = new IEBlockItemBase(IEBlocks.DULLSTONE_BRICK);
    public static final Item CRACKED_GLOWSTONE_BRICK = new IEBlockItemBase(IEBlocks.CRACKED_GLOWSTONE_BRICK);
    public static final Item CRACKED_DIMSTONE_BRICK = new IEBlockItemBase(IEBlocks.CRACKED_DIMSTONE_BRICK);
    public static final Item CRACKED_DULLSTONE_BRICK = new IEBlockItemBase(IEBlocks.CRACKED_DULLSTONE_BRICK);
    public static final Item CHISELED_GLOWSTONE_BRICK = new IEBlockItemBase(IEBlocks.CHISELED_GLOWSTONE_BRICK);
    public static final Item CHISELED_DIMSTONE_BRICK = new IEBlockItemBase(IEBlocks.CHISELED_DIMSTONE_BRICK);
    public static final Item CHISELED_DULLSTONE_BRICK = new IEBlockItemBase(IEBlocks.CHISELED_DULLSTONE_BRICK);
    public static final Item SMOOTH_GLOWSTONE_SLAB = new IEBlockItemBase(IEBlocks.SMOOTH_GLOWSTONE_SLAB);
    public static final Item SMOOTH_GLOWSTONE_STAIRS = new IEBlockItemBase(IEBlocks.SMOOTH_GLOWSTONE_STAIRS);
    public static final Item SMOOTH_DIMSTONE_SLAB = new IEBlockItemBase(IEBlocks.SMOOTH_DIMSTONE_SLAB);
    public static final Item SMOOTH_DIMSTONE_STAIRS = new IEBlockItemBase(IEBlocks.SMOOTH_DIMSTONE_STAIRS);
    public static final Item SMOOTH_DULLSTONE_SLAB = new IEBlockItemBase(IEBlocks.SMOOTH_DULLSTONE_SLAB);
    public static final Item SMOOTH_DULLSTONE_STAIRS = new IEBlockItemBase(IEBlocks.SMOOTH_DULLSTONE_STAIRS);
    public static final Item GLOWSTONE_BRICK_SLAB = new IEBlockItemBase(IEBlocks.GLOWSTONE_BRICK_SLAB);
    public static final Item GLOWSTONE_BRICK_STAIRS = new IEBlockItemBase(IEBlocks.GLOWSTONE_BRICK_STAIRS);
    public static final Item DIMSTONE_BRICK_SLAB = new IEBlockItemBase(IEBlocks.DIMSTONE_BRICK_SLAB);
    public static final Item DIMSTONE_BRICK_STAIRS = new IEBlockItemBase(IEBlocks.DIMSTONE_BRICK_STAIRS);
    public static final Item DULLSTONE_BRICK_SLAB = new IEBlockItemBase(IEBlocks.DULLSTONE_BRICK_SLAB);
    public static final Item DULLSTONE_BRICK_STAIRS = new IEBlockItemBase(IEBlocks.DULLSTONE_BRICK_STAIRS);

    /*
    public static final Item GLOWDUST = ITEMS.register("glowdust",                  () -> new IEBlockItemBase(IEBlocks.GLOWDUST.get()));
    public static final Item GLOWDUST_SAND = ITEMS.register("glowdust_sand",            () -> new IEBlockItemBase(IEBlocks.GLOWDUST_SAND.get()));
    public static final Item GLOWDUST_STONE = ITEMS.register("glowdust_stone",              () -> new IEBlockItemBase(IEBlocks.GLOWDUST_STONE.get()));
    public static final Item GLOWDUST_STONE_BRICKS = ITEMS.register("glowdust_stone_bricks",    () -> new IEBlockItemBase(IEBlocks.GLOWDUST_STONE_BRICKS.get()));
    public static final Item GLOWDUST_STONE_BRICK_SLAB = ITEMS.register("glowdust_stone_brick_slab",        () -> new IEBlockItemBase(IEBlocks.GLOWDUST_STONE_BRICK_SLAB.get()));
    public static final Item GLOWDUST_STONE_BRICK_STAIRS = ITEMS.register("glowdust_stone_brick_stairs",    () -> new IEBlockItemBase(IEBlocks.GLOWDUST_STONE_BRICK_STAIRS.get()));
    public static final Item TRAPPED_GLOWDUST_SAND = ITEMS.register("trapped_glowdust_sand",        () -> new IEBlockItemBase(IEBlocks.TRAPPED_GLOWDUST_SAND.get()));
    public static final Item GLOWDUST_SANDSTONE = ITEMS.register("glowdust_sandstone",                  () -> new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE.get()));
    public static final Item CUT_GLOWDUST_SANDSTONE = ITEMS.register("cut_glowdust_sandstone",              () -> new IEBlockItemBase(IEBlocks.CUT_GLOWDUST_SANDSTONE.get()));
    public static final Item CHISELED_GLOWDUST_SANDSTONE = ITEMS.register("chiseled_glowdust_sandstone",        () -> new IEBlockItemBase(IEBlocks.CHISELED_GLOWDUST_SANDSTONE.get()));
    public static final Item SMOOTH_GLOWDUST_SANDSTONE = ITEMS.register("smooth_glowdust_sandstone",                () -> new IEBlockItemBase(IEBlocks.SMOOTH_GLOWDUST_SANDSTONE.get()));
    public static final Item GLOWDUST_SANDSTONE_SLAB = ITEMS.register("glowdust_sandstone_slab",                    () -> new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE_SLAB.get()));
    public static final Item GLOWDUST_SANDSTONE_STAIRS = ITEMS.register("glowdust_sandstone_stairs",                () -> new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE_STAIRS.get()));
    public static final Item CUT_GLOWDUST_SANDSTONE_SLAB = ITEMS.register("cut_glowdust_sandstone_slab",            () -> new IEBlockItemBase(IEBlocks.CUT_GLOWDUST_SANDSTONE_SLAB.get()));
    public static final Item SMOOTH_GLOWDUST_SANDSTONE_SLAB = ITEMS.register("smooth_glowdust_sandstone_slab",      () -> new IEBlockItemBase(IEBlocks.SMOOTH_GLOWDUST_SANDSTONE_SLAB.get()));
    public static final Item SMOOTH_GLOWDUST_SANDSTONE_STAIRS = ITEMS.register("smooth_glowdust_sandstone_stairs",  () -> new IEBlockItemBase(IEBlocks.SMOOTH_GLOWDUST_SANDSTONE_STAIRS.get()));
    public static final Item GLOWDUST_SANDSTONE_WALL = ITEMS.register("glowdust_sandstone_wall",                    () -> new IEBlockItemBase(IEBlocks.GLOWDUST_SANDSTONE_WALL.get()));
    
    public static final Item CRUMBLING_BLACKSTONE = ITEMS.register("crumbling_blackstone",  () -> new IEBlockItemBase(IEBlocks.CRUMBLING_BLACKSTONE.get()));
    public static final Item GLIMMERING_BLACKSTONE = ITEMS.register("glimmering_blackstone", () -> new IEBlockItemBase(IEBlocks.GLIMMERING_BLACKSTONE.get()));
    public static final Item SILT = ITEMS.register("silt", () -> new IEBlockItemBase(IEBlocks.SILT.get()));
    public static final Item RUBBLE = ITEMS.register("rubble", () -> new IEBlockItemBase(IEBlocks.RUBBLE.get()));

    public static final Item CRIMSON_FUNGUS_CAP = ITEMS.register("crimson_fungus_cap", () -> new IEBlockItemBase(IEBlocks.CRIMSON_FUNGUS_CAP.get()));
    public static final Item WARPED_FUNGUS_CAP = ITEMS.register("warped_fungus_cap", () -> new IEBlockItemBase(IEBlocks.WARPED_FUNGUS_CAP.get()));

    public static final Item GLOW_LANTERN = ITEMS.register("lantern_glow",      () -> new IEBlockItemBase(IEBlocks.GLOW_LANTERN.get()));
    public static final Item GLOW_TORCH = ITEMS.register("torch_glow",          () -> new WallOrFloorItem(IEBlocks.GLOW_TORCH.get(), IEBlocks.GLOW_WALL_TORCH.get(), (new Item.Properties()).group(InfernalExpansion.TAB)));
    public static final Item GLOW_CAMPFIRE = ITEMS.register("campfire_glow",    () -> new IEBlockItemBase(IEBlocks.GLOW_CAMPFIRE.get()));

    public static final Item LUMINOUS_FUNGUS = ITEMS.register("luminous_fungus", () -> new IEBlockItemBase(IEBlocks.LUMINOUS_FUNGUS.get()));
    public static final Item DULLTHORNS = ITEMS.register("dullthorns",           () -> new IEBlockItemBase(IEBlocks.DULLTHORNS.get()));

    public static final Item SHROOMLIGHT_FUNGUS = ITEMS.register("shroomlight_fungus",      () -> new IEBlockItemBase(IEBlocks.SHROOMLIGHT_FUNGUS.get()));
    */
    public static final Item ASCUS_BOMB = new AscusBombItem();


    public static void registerItems() {
        registerItem("glowcoal", GLOWCOAL);
        registerItem("ascus_bomb", ASCUS_BOMB);
        registerItem("blindsight_tongue", BLINDSIGHT_TONGUE);
        registerItem("blindsight_tongue_stew", BLINDSIGHT_TONGUE_STEW);
        InfernalExpansion.LOGGER.info("Infernal Expansion: Items Registered!");
    }
    
    public static Item registerItem(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, id), item);
    }
}