package net.Winston.vegan_plants.worldgen.custom.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.VegetationPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;

public class WildFeatherFeature extends VegetationPatchFeature {
    public WildFeatherFeature() {
      super(VegetationPatchConfiguration.CODEC);
   }

    //For future world Gen Config
    @Override
    public boolean place(FeaturePlaceContext<VegetationPatchConfiguration> p_160612_)
    {
        return super.place(p_160612_);
    }
}
