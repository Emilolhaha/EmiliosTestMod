package net.emilolhaha.emiliostestmod.item;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmiliosTestmod.MOD_ID);

    public static final DeferredItem<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TOPAZ_NUGGET = ITEMS.register("topaz_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}