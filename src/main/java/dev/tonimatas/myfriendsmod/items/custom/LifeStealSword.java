package dev.tonimatas.myfriendsmod.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LifeStealSword extends SwordItem {
    private final float lifeStealPercentatge;

    public LifeStealSword(Tier p_43269_, Properties p_43272_, float lifeStealPercentatge) {
        super(p_43269_, p_43272_);
        this.lifeStealPercentatge = lifeStealPercentatge;
    }

    @Override
    public void postHurtEnemy(@NotNull ItemStack p_345553_, @NotNull LivingEntity p_345771_, @NotNull LivingEntity p_346282_) {
        super.postHurtEnemy(p_345553_, p_345771_, p_346282_);
        p_346282_.setHealth(p_346282_.getMaxHealth() * (lifeStealPercentatge / 100) + p_346282_.getHealth());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack p_41421_, @NotNull TooltipContext p_339594_, @NotNull List<Component> p_41423_, @NotNull TooltipFlag p_41424_) {
        p_41423_.add(Component.translatable("tooltip.myfriendsmod.blood_sword").append(lifeStealPercentatge + "%").withStyle(ChatFormatting.DARK_RED));
    }
}
