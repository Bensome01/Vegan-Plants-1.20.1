package net.Winston.vegan_plants.worldgen;

import net.Winston.vegan_plants.VeganPlants;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.levelgen.GenerationStep;

public class VeganPlantsBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_WILD_FEATHER = registerKey("add_wild_feather");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var biomes = context.lookup(Registries.BIOME);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(
            ADD_WILD_FEATHER,
            new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(VeganPlantsPlacedFeatures.WILD_FEATHER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(VeganPlants.MOD_ID, name));
    }
}

// //register a biome modifier
// context.register
// (
//     //create a resource key for biome modifier
//     ResourceKey.create
//     (
//         ForgeRegistries.Keys.BIOME_MODIFIERS,
//         new ResourceLocation
//         (
//             TutorialMod.MOD_ID, "add_pine_tree"
//         )
//     ),
//     //define biome modifier
//     new ForgeBiomeModifiers.AddFeaturesBiomeModifier
//     (
//         //which biome is being modified
//         biomes.getOrThrow
//         (
//             Tags.Biomes.IS_PLAINS
//         ),
//         //what are we placing
//         HolderSet.direct
//         (
//             context.lookup
//             (
//                 Registries.PLACED_FEATURE
//             ).getOrThrow
//             (
//                 ModPlacedFeatures.PINE_PLACED_KEY
//             )
//         ),
//         //what type of generation ex caves, ores, 
//         GenerationStep.Decoration.VEGETAL_DECORATION
//     )
// );

