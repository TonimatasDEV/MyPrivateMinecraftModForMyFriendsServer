package dev.tonimatas.myfriendsmod.utils;

import dev.tonimatas.myfriendsmod.register.ModAttachments;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class EntityUtils {

    public static Component getEntityName(LivingEntity entity) {
        ChatFormatting healthColor = entity.getHealth() == entity.getMaxHealth() ? ChatFormatting.GREEN : ChatFormatting.YELLOW;

        return Component.literal("")
                .append(Component.literal("[")
                        .withStyle(ChatFormatting.DARK_GRAY))
                .append(Component.literal("Lv" + entity.getData(ModAttachments.LEVEL))
                        .withStyle(ChatFormatting.GRAY))
                .append(Component.literal("] ")
                        .withStyle(ChatFormatting.DARK_GRAY))
                .append(Component.translatable(entity.getType().getDescriptionId())
                        .withStyle(ChatFormatting.RED))
                .append(Component.literal(" "))
                .append(Component.literal(String.valueOf((int) Math.ceil(entity.getHealth())))
                        .withStyle(healthColor))
                .append(Component.literal("/")
                        .withStyle(ChatFormatting.WHITE))
                .append(Component.literal(String.valueOf((int) entity.getMaxHealth()))
                        .withStyle(ChatFormatting.GREEN))
                .append(Component.literal("❤")
                        .withStyle(ChatFormatting.RED));
    }
}
