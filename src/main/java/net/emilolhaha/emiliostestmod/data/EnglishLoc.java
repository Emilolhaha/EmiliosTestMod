package net.emilolhaha.emiliostestmod.data;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.emilolhaha.emiliostestmod.block.ModBlocks;
import net.emilolhaha.emiliostestmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishLoc extends LanguageProvider {
    public EnglishLoc(PackOutput output) {
        super(output, EmiliosTestmod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModBlocks.TOPAZ_BLOCK.get(), "Topaz Block");
        add(ModItems.TOPAZ_SHARD.get(), "Topaz Shard");
        add(ModItems.TOPAZ.get(), "Topaz");
        add(ModItems.TOPAZ_ORE.get(), "Topaz Ore");
        add(ModItems.DEEPSLATE_TOPAZ_ORE.get(), "Deepslate Topaz Ore");
    }
}
