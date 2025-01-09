package net.Winston.feather_crop.item;

import net.Winston.feather_crop.*;
import net.Winston.feather_crop.Block.BlockRegistry;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FeatherCrop.MOD_ID);

    public static final RegistryObject<Item> FEATHER_SEEDS = ITEMS.register("feather_seeds",
            () -> new ItemNameBlockItem(BlockRegistry.FEATHER_CROP.get(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
