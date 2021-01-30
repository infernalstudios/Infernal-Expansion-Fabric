package dev.cernavskis.infernalexp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.cernavskis.infernalexp.blocks.IEBlocks;
import dev.cernavskis.infernalexp.entities.IEEntityTypes;
import dev.cernavskis.infernalexp.items.IEItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class InfernalExpansion implements ModInitializer {
    
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "infernalexp";
    public static final ItemGroup TAB = FabricItemGroupBuilder.build(
            new Identifier(InfernalExpansion.MOD_ID, "infernalexp_tab"),
            () -> new ItemStack(Items.BLAZE_POWDER));
    
    @Override
    public void onInitialize() {
        IEBlocks.registerBlocks();
        IEEntityTypes.registerEntities();
        IEEntityTypes.registerEntityAttributes();
        IEItems.registerItems();
    }
}