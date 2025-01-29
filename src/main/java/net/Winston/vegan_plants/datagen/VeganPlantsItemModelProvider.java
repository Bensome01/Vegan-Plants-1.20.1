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
        var resource1 = new ResourceLocation("item/generated");
        var resource2 = new ResourceLocation(VeganPlants.MOD_ID,
            "item/" + ItemRegistry.FEATHER_SEEDS.getId().getPath());

        withExistingParent(ItemRegistry.FEATHER_SEEDS.getId().getPath(), resource1)
            .texture("layer0", resource2);
    }

    // private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
    // return withExistingParent(item.getId().getPath(),
    // new ResourceLocation("item/generated")).texture("layer0",
    // new ResourceLocation(VeganPlants.MOD_ID,"item/" + item.getId().getPath()));
    // }
}
