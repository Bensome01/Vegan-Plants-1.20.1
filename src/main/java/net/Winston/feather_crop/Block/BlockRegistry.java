package net.Winston.feather_crop.Block;

import net.Winston.feather_crop.FeatherCrop;
import net.Winston.feather_crop.Block.Custom.FeatherCropBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FeatherCrop.MOD_ID);

    public static final RegistryObject<Block> FEATHER_CROP = BLOCKS.register("feather_crop",
            () -> new FeatherCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
