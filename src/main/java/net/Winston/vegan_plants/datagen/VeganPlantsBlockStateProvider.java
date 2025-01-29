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

public class VeganPlantsBlockStateProvider extends BlockStateProvider {
    public VeganPlantsBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VeganPlants.MOD_ID, exFileHelper);
    }

    @Override
    public void registerStatesAndModels()
    {
        this.featherCropBlock(BlockRegistry.FEATHER_CROP);
    }

    private void featherCropBlock(RegistryObject<Block> crop)
    {
        //get name of block from registry
        String name = getBlockName(crop.get());
        //produces the model jsons and puts them in an array for blockstate usage
        Function<Integer, ModelFile> model = i ->this.models()
            .crop(name + "_stage" + i, this.modLoc("block/" + name + "_stage" + i))
            .renderType("cutout");
        ConfiguredModel[] models = new ConfiguredModel[5];
        for(int i = 0; i < 5; i++)
        {
            models[i] = new ConfiguredModel(model.apply(i));
        }

        //produces the blockstate json
        this.getVariantBuilder(crop.get())
            .partialState().with(FeatherCropBlock.AGE, 0).addModels(models[0])
            .partialState().with(FeatherCropBlock.AGE, 1).addModels(models[0])
            .partialState().with(FeatherCropBlock.AGE, 2).addModels(models[1])
            .partialState().with(FeatherCropBlock.AGE, 3).addModels(models[1])
            .partialState().with(FeatherCropBlock.AGE, 4).addModels(models[1])
            .partialState().with(FeatherCropBlock.AGE, 5).addModels(models[1])
            .partialState().with(FeatherCropBlock.AGE, 6).addModels(models[2])
            .partialState().with(FeatherCropBlock.AGE, 7).addModels(models[2])
            .partialState().with(FeatherCropBlock.AGE, 8).addModels(models[2])
            .partialState().with(FeatherCropBlock.AGE, 9).addModels(models[2])
            .partialState().with(FeatherCropBlock.AGE, 10).addModels(models[3])
            .partialState().with(FeatherCropBlock.AGE, 11).addModels(models[3])
            .partialState().with(FeatherCropBlock.AGE, 12).addModels(models[3])
            .partialState().with(FeatherCropBlock.AGE, 13).addModels(models[3])
            .partialState().with(FeatherCropBlock.AGE, 14).addModels(models[3])
            .partialState().with(FeatherCropBlock.AGE, 15).addModels(models[0]);
    }

    private static String getBlockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    // private void wildBerryBush(RegistryObject<Block> bush) {
    //     String name = getBlockName(bush.get());
    //     Function<Integer, ModelFile> model = i ->
    //         this.models()
    //             .cross(name + "_stage" + i, this.modLoc("block/" + name + "_stage" + i))
    //             .renderType("cutout");
    //     this.getVariantBuilder(bush.get())
    //         .partialState().with(WildBerryBushBlock.AGE, 0).addModels(new ConfiguredModel(model.apply(0), 0, 0, true))
    //         .partialState().with(WildBerryBushBlock.AGE, 1).addModels(new ConfiguredModel(model.apply(1), 0, 0, true))
    //         .partialState().with(WildBerryBushBlock.AGE, 2).addModels(new ConfiguredModel(model.apply(2), 0, 0, true))
    //         .partialState().with(WildBerryBushBlock.AGE, 3).addModels(new ConfiguredModel(model.apply(3), 0, 0, true));
    // }
}
