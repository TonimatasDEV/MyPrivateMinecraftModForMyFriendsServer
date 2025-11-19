package dev.tonimatas.myfriendsmod.register;

import dev.tonimatas.myfriendsmod.MyFriendsMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MyFriendsMod.MODID);

    public static final DeferredItem<Item> PLATINUM_APPLE = ITEMS.registerSimpleItem("platinum_apple", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(12).saturationModifier(10f).effect(() -> new MobEffectInstance(ModEffects.TOTEM_EFFECT, 400, 0), 100)
            .build()));
    public static final DeferredItem<Item> BRONZE_COIN = ITEMS.registerSimpleItem("bronze_coin", new Item.Properties());
    public static final DeferredItem<Item> SILVER_COIN = ITEMS.registerSimpleItem("silver_coin", new Item.Properties());
    public static final DeferredItem<Item> GOLD_COIN = ITEMS.registerSimpleItem("gold_coin", new Item.Properties());
    public static final DeferredItem<Item> PLATINUM_COIN = ITEMS.registerSimpleItem("platinum_coin", new Item.Properties());
    public static final DeferredItem<Item> JADE = ITEMS.registerSimpleItem("jade", new Item.Properties());
}
