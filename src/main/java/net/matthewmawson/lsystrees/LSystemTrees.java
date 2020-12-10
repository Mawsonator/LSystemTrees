package net.matthewmawson.lsystrees;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LSystemTrees implements ModInitializer {

    public static final String MOD_ID = "lsystrees";

    public static final Block LSYS_BLOCK = new LSysBlock();
    public static final Block THIN_LOG_BLOCK = new ThinLogBlock();

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("lsystrees","lsys_block"), LSYS_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("lsystrees","lsys_block"), new BlockItem(LSYS_BLOCK,new Item.Settings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier("lsystrees","thin_log_block"), THIN_LOG_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("lsystrees","thin_log_block"), new BlockItem(THIN_LOG_BLOCK,new Item.Settings().group(ItemGroup.MISC)));
    }
}
