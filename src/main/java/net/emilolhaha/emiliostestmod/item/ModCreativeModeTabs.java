package net.emilolhaha.emiliostestmod.item;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EmiliosTestmod.MOD_ID);

    public static final Supplier<CreativeModeTab> TESTMOD_TAB = CREATIVE_MODE_TAB.register("testmod_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.TOPAZ.get()))
                    .title(Component.translatable("creativetab.emiliostestmod.testmod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.TOPAZ);
                      output.accept(ModItems.TOPAZ_BLOCK);
                      output.accept(ModItems.TOPAZ_SHARD);
                      output.accept(ModItems.TOPAZ_ORE);
                      output.accept(ModItems.DEEPSLATE_TOPAZ_ORE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
