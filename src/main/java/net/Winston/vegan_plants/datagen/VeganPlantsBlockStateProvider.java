package net.Winston.vegan_plants.datagen;

import net.Winston.vegan_plants.VeganPlants;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class VeganPlantsBlockStateProvider extends BlockStateProvider {
    public VeganPlantsBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VeganPlants.MOD_ID, exFileHelper);
    }

    @Override
    public void registerStatesAndModels()
    {
        //
    }
}
