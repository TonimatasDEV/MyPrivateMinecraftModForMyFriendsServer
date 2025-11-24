package dev.tonimatas.myfriendsmod.datagen;

import dev.tonimatas.myfriendsmod.register.ModBlocks;
import dev.tonimatas.myfriendsmod.register.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(ModBlocks.JADE_ORE.get(), block -> createOreDrop(ModBlocks.JADE_ORE.get(), ModItems.JADE.get()));
        add(ModBlocks.DEEPSLATE_JADE_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_JADE_ORE.get(), ModItems.JADE.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
