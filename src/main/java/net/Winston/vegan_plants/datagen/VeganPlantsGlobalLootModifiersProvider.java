package net.Winston.vegan_plants.datagen;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import net.Winston.vegan_plants.VeganPlants;
import net.Winston.vegan_plants.item.ItemRegistry;
import net.Winston.vegan_plants.loot.AddItemModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.CompositeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class VeganPlantsGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public VeganPlantsGlobalLootModifiersProvider(PackOutput output) {
        super(output, VeganPlants.MOD_ID);
    }

    @Override
    protected void start() {
        FeatherSeedChests();
    }

    private void FeatherSeedChests()
    {
        String[] selectedChests = new String[]{
            "abandoned_mineshaft",
            "buried_treasure",
            "desert_pyramid",
            "igloo_chest",
            "jungle_temple",
            "pillager_outpost",
            "shipwreck_map",
            "shipwreck_supply",
            "shipwreck_treasure",
            "simple_dungeon",
            "woodland_mansion"
        };

        String[] chestPaths = new String[selectedChests.length];
        for(int i = 0; i < selectedChests.length; i++)
        {
            chestPaths[i] = "chest/".concat(selectedChests[i]);
        }

        for(int i = 0; i < selectedChests.length; i++)
        {
            add("feather_seeds_in_" + selectedChests[i],
                new AddItemModifier(new LootItemCondition[]
                {
                    new LootTableIdCondition.Builder(
                        new ResourceLocation(chestPaths[i])).build()
                },
                ItemRegistry.FEATHER_SEEDS.get()));
        }
        
    }
}
