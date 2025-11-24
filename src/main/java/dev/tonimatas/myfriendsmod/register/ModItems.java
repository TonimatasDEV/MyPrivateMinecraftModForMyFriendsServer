package dev.tonimatas.myfriendsmod.register;

import dev.tonimatas.myfriendsmod.MyFriendsMod;
import dev.tonimatas.myfriendsmod.items.ModToolTiers;
import dev.tonimatas.myfriendsmod.items.custom.LifeStealSword;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MyFriendsMod.MODID);

    public static final DeferredItem<Item> PLATINUM_APPLE = ITEMS.registerSimpleItem("platinum_apple", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(12).saturationModifier(10f).effect(() -> new MobEffectInstance(ModEffects.TOTEM_EFFECT, 400, 0), 100)
            .build()).rarity(Rarity.RARE));
    public static final DeferredItem<Item> BRONZE_COIN = ITEMS.registerSimpleItem("bronze_coin", new Item.Properties().rarity(Rarity.COMMON));
    public static final DeferredItem<Item> SILVER_COIN = ITEMS.registerSimpleItem("silver_coin", new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> GOLD_COIN = ITEMS.registerSimpleItem("gold_coin", new Item.Properties().rarity(Rarity.RARE));
    public static final DeferredItem<Item> PLATINUM_COIN = ITEMS.registerSimpleItem("platinum_coin", new Item.Properties().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> JADE = ITEMS.registerSimpleItem("jade", new Item.Properties().rarity(Rarity.COMMON));
    public static final DeferredItem<Item> JADE_SWORD = ITEMS.register("jade_sword", () -> new SwordItem(ModToolTiers.JADE, new Item.Properties()
            .attributes(SwordItem.createAttributes(ModToolTiers.JADE, 4F, -2.2F)).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> BLOOD_SWORD = ITEMS.register("blood_sword", () -> new LifeStealSword(ModToolTiers.BLOOD, new Item.Properties()
            .attributes(SwordItem.createAttributes(ModToolTiers.BLOOD, 5F, -2.4F)).rarity(Rarity.EPIC), 2.5F));
    public static final DeferredItem<Item> DRY_BLOOD = ITEMS.registerSimpleItem("dry_blood", new Item.Properties());
    public static final DeferredItem<Item> CHALICE = ITEMS.registerSimpleItem("chalice", new Item.Properties().rarity(Rarity.RARE));
    public static final DeferredItem<Item> VOID_AXE = ITEMS.register("void_axe", () -> new AxeItem(ModToolTiers.VOID, new Item.Properties()
            .attributes(AxeItem.createAttributes(ModToolTiers.VOID, 4F, -2.2F)).rarity(Rarity.EPIC)));
}
