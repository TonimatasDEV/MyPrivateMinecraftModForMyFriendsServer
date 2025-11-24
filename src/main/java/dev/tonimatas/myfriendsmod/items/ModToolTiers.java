package dev.tonimatas.myfriendsmod.items;

import dev.tonimatas.myfriendsmod.register.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier BLOOD = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1400, 4f, 16f, 50, () -> Ingredient.of(ModItems.DRY_BLOOD));
    public static final Tier JADE = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            800, 3f, 4f, 90, () -> Ingredient.of(ModItems.JADE));
    public static final Tier VOID = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2500, 60f, 5f, 100, Ingredient::of);
    public static final Tier INFERNAL = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            3100, 5f, 22f, 100, Ingredient::of);
}
