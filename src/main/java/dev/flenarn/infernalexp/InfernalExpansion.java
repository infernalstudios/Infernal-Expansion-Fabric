package dev.flenarn.infernalexp;

import dev.flenarn.infernalexp.registry.IEBlocks;
import dev.flenarn.infernalexp.registry.IEItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class InfernalExpansion implements ModInitializer {

    public static final String MOD_ID = "infernalexp";
    public static final ItemGroup TAB = FabricItemGroupBuilder.build(new Identifier(InfernalExpansion.MOD_ID, "infernalexp_tab"), () -> new ItemStack(IEItems.TAB_ITEM));

    @Override
    public void onInitialize() {
        IEBlocks.register();
        IEItems.register();
    }
}
