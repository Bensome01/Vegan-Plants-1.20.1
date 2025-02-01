package net.Winston.vegan_plants.worldgen;

import net.Winston.vegan_plants.VeganPlants;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.List;


public class VeganPlantsPlacedFeatures {
    public static final ResourceKey<PlacedFeature> WILD_FEATHER_PLACED_KEY = registerKey("wild_feather_placed_key");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
            WILD_FEATHER_PLACED_KEY,
            new PlacedFeature(
                configuredFeatures
                    .getOrThrow(VeganPlantsConfiguredFeatures.WILD_FEATHER_KEY),
                VegetationPlacements.worldSurfaceSquaredWithCount(4)));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(VeganPlants.MOD_ID, name));
    }

    private static void register(
        BootstapContext<PlacedFeature> context,
        ResourceKey<PlacedFeature> key,
        Holder<ConfiguredFeature<?, ?>> configuration,
        List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

// //register a placed feature
// context.register
// (
//     //create a resource key for it to be known as
//     ResourceKey.create
//     (
//         Registries.PLACED_FEATURE,
//         new ResourceLocation
//         (
//             TutorialMod.MOD_ID,
//             "pine_placed"
//         )
//     ),
//     //define the placed feature
//     new PlacedFeature
//     (
//         //Holder<ConfiguredFeature<?, ?>> feature
//         context.lookup
//         (
//             Registries.CONFIGURED_FEATURE
//         ).getOrThrow
//         (
//             ModConfiguredFeatures.PINE_KEY
//         ),
//         //List<PlacementModifier> placement
//         List.copyOf
//         (
//             VegetationPlacements.treePlacement
//             (
//                 PlacementUtils.countExtra
//                 (
//                     3,
//                     0.1f,
//                     2
//                 ),
//                 ModBlocks.PINE_SAPLING.get()
//             )
//         )
//     )
// );
