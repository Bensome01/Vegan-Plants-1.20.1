package net.Winston.vegan_plants.Block.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WildFeatherBlock extends TallGrassBlock {

    public WildFeatherBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void performBonemeal(ServerLevel p_222578_, RandomSource p_222579_, BlockPos p_222580_, BlockState p_222581_)
    {}
}
