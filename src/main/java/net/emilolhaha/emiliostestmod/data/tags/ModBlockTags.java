package net.emilolhaha.emiliostestmod.data.tags;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.emilolhaha.emiliostestmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider {
    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EmiliosTestmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.NEEDS_IRON_TOOL)
                .replace(false)
                .add(ModBlocks.TOPAZ_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get())
                .add(ModBlocks.TOPAZ_ORE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .replace(false)
                .add(ModBlocks.TOPAZ_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get())
                .add(ModBlocks.TOPAZ_ORE.get());
    }
}