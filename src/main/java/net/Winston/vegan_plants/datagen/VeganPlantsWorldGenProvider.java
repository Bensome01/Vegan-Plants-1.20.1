package net.Winston.vegan_plants.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.Winston.vegan_plants.VeganPlants;
import net.Winston.vegan_plants.worldgen.VeganPlantsBiomeModifiers;
import net.Winston.vegan_plants.worldgen.VeganPlantsConfiguredFeatures;
import net.Winston.vegan_plants.worldgen.VeganPlantsPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class VeganPlantsWorldGenProvider extends DatapackBuiltinEntriesProvider{
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, VeganPlantsConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, VeganPlantsPlacedFeatures::bootstrap)
        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, VeganPlantsBiomeModifiers::bootstrap);

        public VeganPlantsWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries, BUILDER, Set.of(VeganPlants.MOD_ID));
    }
}
