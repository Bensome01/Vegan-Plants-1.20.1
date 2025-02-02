package net.Winston.vegan_plants;

import net.minecraftforge.common.ForgeConfigSpec;

public class VeganPlantsConfig {
    public static ForgeConfigSpec GENERAL_SPEC;
    public static ForgeConfigSpec.IntValue MINIMUM_FEATHER_CROP_y;
    public static ForgeConfigSpec.ConfigValue<Integer> FEATHER_FALL_DURATION;
    public static ForgeConfigSpec.IntValue MINIMUM_WILD_FEATHER_y;

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
            FEATHER_FALL_DURATION = builder
                .comment("Tick duration of feather fall effect gratned by matured feather crop")
                .define("tick duration", 200);
        builder.pop();
        builder.push("Wild Feather");
            MINIMUM_WILD_FEATHER_y = builder
                .comment("Minimum y that Wild feather can be placed (this effects world gen)")
                .defineInRange("Min_y", 100, -64, 320);
        builder.pop();
    }
}