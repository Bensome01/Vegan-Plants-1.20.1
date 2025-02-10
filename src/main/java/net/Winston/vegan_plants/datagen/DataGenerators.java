package net.Winston.vegan_plants.datagen;

import java.util.concurrent.CompletableFuture;

import net.Winston.vegan_plants.VeganPlants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VeganPlants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), VeganPlantsLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new VeganPlantsBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new VeganPlantsItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new VeganPlantsWorldGenProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new VeganPlantsGlobalLootModifiersProvider(packOutput));
    }
}
