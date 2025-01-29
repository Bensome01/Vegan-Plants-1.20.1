package net.Winston.vegan_plants.datagen;

import net.Winston.vegan_plants.VeganPlants;
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
        // CompletableFuture<HolderLookup.Provider> lookupProvider =
        // event.getLookupProvider(); //for tags

        generator.addProvider(event.includeServer(), VeganPlantsLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new VeganPlantsBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new VeganPlantsItemModelProvider(packOutput, existingFileHelper));

        // generator.addProvider(event.includeServer(), new
        // ModGlobalLootModifiersProvider(packOutput)); //for loot like chests and mobs
    }
}
