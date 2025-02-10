package net.Winston.vegan_plants.datagen;

import net.Winston.vegan_plants.VeganPlants;
import net.Winston.vegan_plants.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class VeganPlantsItemModelProvider extends ItemModelProvider {
    public VeganPlantsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VeganPlants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        var parentResource = new ResourceLocation("item/generated");
        var featherSeedPath = new ResourceLocation(VeganPlants.MOD_ID,
            "item/" + ItemRegistry.FEATHER_SEEDS.getId().getPath());
        var wildFeatherPath = new ResourceLocation(VeganPlants.MOD_ID,
            "block/" + ItemRegistry.WILD_FEATHER.getId().getPath());

        withExistingParent(ItemRegistry.FEATHER_SEEDS.getId().getPath(), parentResource)
            .texture("layer0", featherSeedPath);

        withExistingParent(ItemRegistry.WILD_FEATHER.getId().getPath(), parentResource)
            .texture("layer0", wildFeatherPath);
    // models()
    // .singleTexture(
    //     blockTexture(BlockRegistry.WILD_FEATHER.get()).getPath(),
    //     new ResourceLocation("item/generated"),
    //     "layer0",
    //     new ResourceLocation(VeganPlants.MOD_ID,
    //         "item/" + ItemRegistry.WILD_FEATHER.getId().getPath()))
    // .renderType("cutout")
    }

    // private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
    // return withExistingParent(item.getId().getPath(),
    // new ResourceLocation("item/generated")).texture("layer0",
    // new ResourceLocation(VeganPlants.MOD_ID,"item/" + item.getId().getPath()));
    // }
}
