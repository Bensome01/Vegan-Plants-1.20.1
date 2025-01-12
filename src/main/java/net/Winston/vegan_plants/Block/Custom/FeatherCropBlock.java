package net.Winston.vegan_plants.Block.Custom;

import net.Winston.vegan_plants.item.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class FeatherCropBlock extends CropBlock{
    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

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
    protected boolean mayPlaceOn(BlockState p_52302_, BlockGetter p_52303_, BlockPos p_52304_) {
        return p_52304_.getY() >= 100 && super.mayPlaceOn(p_52302_, p_52303_, p_52304_);
    }

    @Override
    public void entityInside(BlockState p_58238_, Level p_58239_, BlockPos p_58240_, Entity p_58241_) {
        if (p_58241_ instanceof Ravager && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_58239_, p_58241_)) {
         p_58239_.destroyBlock(p_58240_, true, p_58241_);
      }

      if (this.getAge(p_58238_) == MAX_AGE && !p_58239_.isClientSide) {
         if (p_58241_ instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)p_58241_;
            livingentity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200));
         }

      }
    }
}
