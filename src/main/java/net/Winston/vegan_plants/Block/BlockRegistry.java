package net.Winston.vegan_plants.Block;

import net.Winston.vegan_plants.Block.Custom.FeatherCropBlock;
import net.Winston.vegan_plants.Block.Custom.WildFeatherBlock;
import net.Winston.vegan_plants.VeganPlants;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, VeganPlants.MOD_ID);

    public static final RegistryObject<Block> FEATHER_CROP = BLOCKS.register("feather_crop",
            () -> new FeatherCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> WILD_FEATHER = BLOCKS.register("wild_feather",
            () -> new WildFeatherBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).noCollission().noOcclusion()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
