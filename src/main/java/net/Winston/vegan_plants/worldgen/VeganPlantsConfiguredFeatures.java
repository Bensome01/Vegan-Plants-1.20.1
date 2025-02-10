package net.Winston.vegan_plants.worldgen;

import java.util.List;

import net.Winston.vegan_plants.VeganPlants;
import net.Winston.vegan_plants.Block.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

//Feature.RandomPatch for grass
public class VeganPlantsConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_FEATHER_KEY = registerKey("wild_feather");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(
            WILD_FEATHER_KEY,
            new ConfiguredFeature<>(
                Feature.RANDOM_PATCH,
                //there is probably a builder for this but this works
                FeatureUtils.simplePatchConfiguration(
                    Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider
                        .simple(BlockRegistry.WILD_FEATHER.get())),
                    List.of(Blocks.GRASS_BLOCK))
            )
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(VeganPlants.MOD_ID, name));
    }
}

// context.register
// (
//     registerKey
//     (
//         "pine"
//     ),
//     new ConfiguredFeature<>
//     (
//         Feature.TREE, 
//         new TreeConfiguration.TreeConfigurationBuilder
//         (
//             BlockStateProvider.simple
//             (
//                 ModBlocks.PINE_LOG.get()
//             ),
//             new StraightTrunkPlacer
//             (
//                 5,
//                 4,
//                 3
//             ),
//             BlockStateProvider.simple
//             (
//                 ModBlocks.PINE_LEAVES.get()
//             ),
//             new BlobFoliagePlacer
//             (
//                 ConstantInt.of
//                 (
//                     3
//                 ),
//                 ConstantInt.of
//                 (
//                     2
//                 ),
//                 3
//             ),
//             new TwoLayersFeatureSize
//             (
//                 1,
//                 0,
//                 2
//             )
//         ).build()
//     )
// );

