package net.Winston.vegan_plants.datagen;

import java.util.function.Function;

import net.Winston.vegan_plants.VeganPlants;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.Winston.vegan_plants.Block.BlockRegistry;
import net.Winston.vegan_plants.Block.Custom.FeatherCropBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;

public class VeganPlantsBlockStateProvider extends BlockStateProvider {
    public VeganPlantsBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VeganPlants.MOD_ID, exFileHelper);
    }

    @Override
    public void registerStatesAndModels()
    {
        Integer[] featherCropConditions = new Integer[16];
        for(int i = 0; i < 16; i++)
        {
            featherCropConditions[i] = i;
        }
        int[] featherCropModelSelection = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4};

        this.genericCropBlock(BlockRegistry.FEATHER_CROP,
            FeatherCropBlock.AGE,
            featherCropConditions,
            featherCropModelSelection,
            5);
    }
        
    private <T extends Comparable<T>> void genericCropBlock(RegistryObject<Block> crop,
        Property<T> prop,
        T[] values,
        int[] selectedModels,
        int modelCount)
    {
        //produces the model jsons and puts them in an array for blockstate declaration
        ConfiguredModel[] models = this.makeCropModels(crop, modelCount);

        //produces the blockstate json
        makeCropBlockStates(crop, prop, values, selectedModels, models);
    }
        
        private static String getBlockName(Block block) {
            return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private <T extends Comparable<T>> void makeCropBlockStates(RegistryObject<Block> crop,
        Property<T> prop,
        T[] values,
        int[] selectedModels,
        ConfiguredModel[] models)
    {
        var builder = this.getVariantBuilder(crop.get());
        for(int i = 0; i < values.length; i++)
        {
            builder.partialState().with(prop, values[i]).addModels(models[selectedModels[i]]);
        }
    }

    private ConfiguredModel[] makeCropModels(RegistryObject<Block> crop, int modelCount)
    {
        //get name of block from registry
        String name = getBlockName(crop.get());

        //produces the model jsons and puts them in an array for blockstate usage
        Function<Integer, ModelFile> model = i ->this.models()
            .crop(name + "_stage" + i, this.modLoc("block/" + name + "_stage" + i))
            .renderType("cutout");
        
        ConfiguredModel[] models = new ConfiguredModel[modelCount];
        for(int i = 0; i < modelCount; i++)
        {
            models[i] = new ConfiguredModel(model.apply(i));
        }

        return models;
    }
}
