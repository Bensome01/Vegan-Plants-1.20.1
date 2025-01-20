package net.Winston.vegan_plants.item;

import net.Winston.vegan_plants.Block.BlockRegistry;
import net.Winston.vegan_plants.VeganPlants;
import net.Winston.vegan_plants.item.Custom.FeatherSeeds;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, VeganPlants.MOD_ID);

    public static final RegistryObject<Item> FEATHER_SEEDS = ITEMS.register("feather_seeds",
            () -> new FeatherSeeds(BlockRegistry.FEATHER_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
