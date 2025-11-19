package dev.tonimatas.myfriendsmod.items;

import dev.tonimatas.myfriendsmod.register.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier BLOOD = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1400, 4f, 3f, 50, () -> Ingredient.of(ModItems.JADE));
}
