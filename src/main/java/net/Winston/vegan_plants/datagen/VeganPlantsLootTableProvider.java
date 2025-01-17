package net.Winston.vegan_plants.datagen;

import net.Winston.vegan_plants.datagen.loot.VeganPlantsBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class VeganPlantsLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(VeganPlantsBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
