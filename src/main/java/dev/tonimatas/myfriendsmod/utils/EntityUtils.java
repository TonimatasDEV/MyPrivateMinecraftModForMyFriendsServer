package dev.tonimatas.myfriendsmod.utils;

import dev.tonimatas.myfriendsmod.register.ModAttachments;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    
    public static List<Player> getNearbyPlayers(LivingEntity entity) {
        double radius = 128;

        AABB box = new AABB(
                entity.getX() - radius, entity.getY() - radius, entity.getZ() - radius,
                entity.getX() + radius, entity.getY() + radius, entity.getZ() + radius
        );

        return entity.level().getNearbyPlayers(TargetingConditions.forNonCombat().ignoreInvisibilityTesting().ignoreLineOfSight(), entity, box);
    }
    
    public static int getAroundLevel(LivingEntity entity) {
        List<Player> players = getNearbyPlayers(entity);
        
        AtomicInteger totalLevel = new AtomicInteger(1);
        players.forEach(player -> totalLevel.addAndGet(player.getData(ModAttachments.LEVEL)));

        System.out.println(players.isEmpty());
        if (players.isEmpty()) {
            return 1;
        }
        
        return Math.max(totalLevel.get() / players.size(), 1);
    }
}
