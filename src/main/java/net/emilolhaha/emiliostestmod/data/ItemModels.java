package net.emilolhaha.emiliostestmod.data;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.emilolhaha.emiliostestmod.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemModels extends ItemModelProvider {
    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EmiliosTestmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        forBlockItem(this, ModItems.TOPAZ_BLOCK, "topaz_block");

        basicItem(ModItems.TOPAZ.get());
        basicItem(ModItems.TOPAZ_SHARD.get());
    }

    public static void forBlockItem(ItemModelProvider tmp, DeferredItem<Item> item, String name) {
        if (item.get() instanceof BlockItem b)
            tmp.getBuilder(item.getId().getPath())
                    .parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(EmiliosTestmod.MOD_ID,
                            "block/" + BuiltInRegistries.BLOCK.getKey(b.getBlock()).getPath())));
    }
}
