package net.Winston.vegan_plants.Block.Custom;

import net.Winston.vegan_plants.VeganPlantsConfig;
import net.Winston.vegan_plants.item.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FeatherCropBlock extends CropBlock {

    public static final int MAX_AGE = 15;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
        Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D)
    };

    @Override
    public VoxelShape getShape(BlockState p_52297_, BlockGetter p_52298_, BlockPos p_52299_, CollisionContext p_52300_) {
        return SHAPE_BY_AGE[this.getAge(p_52297_)];
    }

    public FeatherCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemRegistry.FEATHER_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    public void entityInside(BlockState p_58238_, Level p_58239_, BlockPos p_58240_, Entity p_58241_) {
        if (p_58241_ instanceof Ravager && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_58239_, p_58241_)) {
            p_58239_.destroyBlock(p_58240_, true, p_58241_);
        }

        if (this.getAge(p_58238_) == MAX_AGE && !p_58239_.isClientSide) {
            if (p_58241_ instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) p_58241_;
                livingentity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200));
            }

        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_255715_, BlockPos p_52259_, BlockState p_52260_, boolean p_52261_) {
        return p_52259_.getY() >= VeganPlantsConfig.MINIMUM_FEATHER_CROP_y.get()
                && super.isValidBonemealTarget(p_255715_, p_52259_, p_52260_, p_52261_);
    }

    @Override
    public void randomTick(BlockState p_221050_, ServerLevel p_221051_, BlockPos p_221052_, RandomSource p_221053_) {
        if (p_221052_.getY() < VeganPlantsConfig.MINIMUM_FEATHER_CROP_y.get()) {
            return;
        }
        super.randomTick(p_221050_, p_221051_, p_221052_, p_221053_);
    }
}
