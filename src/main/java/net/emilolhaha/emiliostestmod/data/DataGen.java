package net.emilolhaha.emiliostestmod.data;


import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.emilolhaha.emiliostestmod.data.models.BlockModels;
import net.emilolhaha.emiliostestmod.data.models.ItemModels;
import net.emilolhaha.emiliostestmod.data.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = EmiliosTestmod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ItemModels(output, helper));
        generator.addProvider(true, new BlockModels(output, helper));

        generator.addProvider(event.includeServer(), new Recipes(output, lookupProvider));
        generator.addProvider(event.includeClient(), new EnglishLoc(output));

        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)), lookupProvider));
        event.getGenerator().addProvider(
                event.includeServer(),
                new ModBlockTags(output, lookupProvider, helper)
        );

        generator.addProvider(event.includeServer(), new DatapackProvider(output, lookupProvider));
    }
}
