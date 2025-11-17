package dev.tonimatas.myfriendsmod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class TotemEffect extends MobEffect {
    public TotemEffect() {
        super(MobEffectCategory.BENEFICIAL, 100);
    }

    @Override
    public boolean applyEffectTick(LivingEntity p_19467_, int p_19468_) {
        return super.applyEffectTick(p_19467_, p_19468_);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return super.shouldApplyEffectTickThisTick(duration, amplifier);
    }

    @Override
    public void onEffectAdded(@NotNull LivingEntity entity, int amplifier) {
        super.onEffectAdded(entity, amplifier);
    }

    @Override
    public void onEffectStarted(@NotNull LivingEntity entity, int amplifier) {
        super.onEffectStarted(entity, amplifier);
    }
}
