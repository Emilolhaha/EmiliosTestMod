package net.emilolhaha.emiliostestmod.data;

import net.emilolhaha.emiliostestmod.EmiliosTestmod;
import net.emilolhaha.emiliostestmod.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

public class Recipes extends RecipeProvider {
    public Recipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static ResourceLocation ETMLoc(String texture) {
        return ResourceLocation.fromNamespaceAndPath(EmiliosTestmod.MOD_ID, texture);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        craftingRecipes(consumer);
    }

    private void craftingRecipes(RecipeOutput consumer) {
        // Topaz
        bundleItem9(Ingredient.of(ModItems.TOPAZ_NUGGET), ModItems.TOPAZ.get(), ModItems.TOPAZ_NUGGET.get(), consumer, "topaz_nugget");
        bundleItem9(Ingredient.of(ModItems.TOPAZ), ModItems.TOPAZ_BLOCK.get(), ModItems.TOPAZ.get(), consumer, "topaz");
    }

    public static void bundleItem9(Ingredient in, Item b, Item out, RecipeOutput consumer, String name) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, b, 1).requires(in, 9).unlockedBy(name, has(out))
                .save(consumer, ETMLoc(name + "_to_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, out, 9).requires(b).unlockedBy(name, has(b))
                .save(consumer, ETMLoc(name + "_from_block"));
    }
}