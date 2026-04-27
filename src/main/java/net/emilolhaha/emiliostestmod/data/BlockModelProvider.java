package net.emilolhaha.emiliostestmod.data;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.emilolhaha.emiliostestmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModelProvider extends BlockStateProvider {
    public BlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EmiliosTestmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.TOPAZ_BLOCK.get());
    }
}
