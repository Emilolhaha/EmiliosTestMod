package net.emilolhaha.emiliostestmod.data.models;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.emilolhaha.emiliostestmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModels extends BlockStateProvider {
    public BlockModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EmiliosTestmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.TOPAZ_BLOCK.get());
        simpleBlock(ModBlocks.TOPAZ_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
    }
}
