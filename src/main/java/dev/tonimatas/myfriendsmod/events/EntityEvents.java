package dev.tonimatas.myfriendsmod.events;

import dev.tonimatas.myfriendsmod.MyFriendsMod;
import dev.tonimatas.myfriendsmod.register.ModAttachments;
import dev.tonimatas.myfriendsmod.utils.EntityUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = MyFriendsMod.MODID)
public class EntityEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntitySpawn(FinalizeSpawnEvent event) {
        LivingEntity entity = event.getEntity();

        int level = 1; // TODO: Change this
        
        entity.setData(ModAttachments.LEVEL, level);
        AttributeInstance maxHealth = entity.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamage = entity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (maxHealth != null) {
            maxHealth.setBaseValue(5 * (level - 1) + entity.getHealth());
        }
        
        if (attackDamage != null) {
            attackDamage.setBaseValue(attackDamage.getValue() + 0.2 * level);
        }

        entity.setHealth(entity.getMaxHealth());
    }
    
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void setEntityNameOnSpawn(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player || entity instanceof ArmorStand) return;
        
        if (entity instanceof LivingEntity livingEntity) {
            if (!entity.hasCustomName()) {
                Component name = EntityUtils.getEntityName(livingEntity);
                entity.setCustomName(name);
            }
            
            entity.setCustomNameVisible(true);
        }
        
        if (entity instanceof ItemEntity) {
            entity.setCustomNameVisible(true);
        }
    }

    @SubscribeEvent
    public static void updateEntityNameOnDamage(LivingDamageEvent.Post event) {
        LivingEntity entity = event.getEntity();

        if (entity instanceof Player || entity instanceof ArmorStand) return;
        
        entity.setCustomName(EntityUtils.getEntityName(entity));
    }
}
