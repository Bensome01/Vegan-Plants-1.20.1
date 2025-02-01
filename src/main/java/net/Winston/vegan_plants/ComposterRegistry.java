package net.Winston.vegan_plants;

import java.util.function.Supplier;

import net.Winston.vegan_plants.item.ItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

public class ComposterRegistry {

    public static void registerCompost() {
        register(ItemRegistry.FEATHER_SEEDS, 0.3f);
        register(ItemRegistry.WILD_FEATHER, 0.3f);
    }

    private static void register(Supplier<? extends Item> item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.get(), chance);
    }
}
