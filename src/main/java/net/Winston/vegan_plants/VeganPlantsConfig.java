package net.Winston.vegan_plants;

import net.minecraftforge.common.ForgeConfigSpec;

public class VeganPlantsConfig {
    public static ForgeConfigSpec GENERAL_SPEC;
    public static ForgeConfigSpec.IntValue MINIMUM_FEATHER_CROP_y;

    static
    {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        GENERAL_SPEC = configBuilder.build();
    }

    private static void setupConfig(ForgeConfigSpec.Builder builder)
    {
        builder.comment("Configs of for Vegan Plants");
        builder.push("Feather Crop");
            MINIMUM_FEATHER_CROP_y = builder
                .comment("Minimum_Y that feather crop can grow")
                .defineInRange("Min_Y", 100, -64, 320);
        builder.pop();
    }
}