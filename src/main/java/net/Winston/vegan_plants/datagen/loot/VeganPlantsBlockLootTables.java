package net.Winston.vegan_plants.datagen.loot;

import java.util.Set;

import net.Winston.vegan_plants.Block.BlockRegistry;
import net.Winston.vegan_plants.Block.Custom.FeatherCropBlock;
import net.Winston.vegan_plants.item.ItemRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class VeganPlantsBlockLootTables extends BlockLootSubProvider {
    public VeganPlantsBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    // VanillaBlockLoot

    @Override
    protected void generate() {
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(BlockRegistry.FEATHER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FeatherCropBlock.AGE, 15));

        this.add(BlockRegistry.FEATHER_CROP.get(),
                featherCropLootTable(BlockRegistry.FEATHER_CROP.get(),
                        Items.FEATHER,
                        ItemRegistry.FEATHER_SEEDS.get(),
                        lootItemConditionBuilder));

        this.add(BlockRegistry.WILD_FEATHER.get(),
                createWildFeatherDrops(BlockRegistry.WILD_FEATHER.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder featherCropLootTable(Block block, Item feather, Item seeds,
            LootItemCondition.Builder condition) {
        /*
         * Loot Table of feather crop
         * does not drop from explosions
         * if age=15 drop feather
         * always drop seed
         * additional chance of 2 feathers 0.33% (affected by fortune)
         * additional chance of 1 seed 0.2% (affected by fortune)
         */
        return this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(feather)
                                .when(condition)
                                .otherwise(LootItem.lootTableItem(seeds))))
                .withPool(LootPool.lootPool()
                        .when(condition)
                        .add(LootItem.lootTableItem(feather)
                                .apply(ApplyBonusCount
                                        .addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.33f, 2))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(seeds))
                        .when(condition)
                        .add(LootItem.lootTableItem(seeds)
                                .apply(ApplyBonusCount
                                        .addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.2f, 1)))));
    }

    protected LootTable.Builder createWildFeatherDrops(Block block) {
        var seeds = ItemRegistry.FEATHER_SEEDS.get();
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .when(HAS_SHEARS)
                                .otherwise(LootItem.lootTableItem(seeds)
                                        .apply(ApplyBonusCount
                                                .addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))
                                        .when(LootItemRandomChanceCondition.randomChance(0.5f))
                                        .otherwise(LootItem.lootTableItem(Items.FEATHER)
                                                .apply(ApplyBonusCount
                                                        .addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))))));
    }
}
