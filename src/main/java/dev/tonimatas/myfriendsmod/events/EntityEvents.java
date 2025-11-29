package dev.tonimatas.myfriendsmod.events;

import dev.tonimatas.myfriendsmod.MyFriendsMod;
import dev.tonimatas.myfriendsmod.register.ModEffects;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = MyFriendsMod.MODID)
public class EntityEvents {
    /* I don't want to implement it right now
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntitySpawn(FinalizeSpawnEvent event) {
        LivingEntity entity = event.getEntity();

        int level = EntityUtils.getAroundLevel(entity);

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
     */

    @SubscribeEvent
    public static void totemEffect(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();

        if (!event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            if (entity.hasEffect(ModEffects.TOTEM_EFFECT.getDelegate())) {
                entity.removeEffect(ModEffects.TOTEM_EFFECT.getDelegate());
                entity.setHealth(1.0F);

                entity.removeEffectsCuredBy(EffectCures.PROTECTED_BY_TOTEM);
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                entity.level().broadcastEntityEvent(entity, (byte) 35);
                event.setCanceled(true);
            }
        }
    }

    /* I don't want to implement it right now
    @SubscribeEvent
    public static void mobKillIncrease(StatAwardEvent event) {
        Stat<?> stat = event.getStat();
        
        if (stat.getName().equals("minecraft.custom:minecraft.mob_kills")) {
            if (event.getEntity() instanceof ServerPlayer player) {
                int level = player.getStats().getValue(stat) / 100 + 1;
                player.setData(ModAttachments.LEVEL, level);
            }
        }
    }
     */
}
