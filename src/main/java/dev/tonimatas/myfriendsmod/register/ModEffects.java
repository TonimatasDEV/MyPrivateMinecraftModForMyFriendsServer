package dev.tonimatas.myfriendsmod.register;

import dev.tonimatas.myfriendsmod.MyFriendsMod;
import dev.tonimatas.myfriendsmod.effects.TotemEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MyFriendsMod.MODID);

    public static final DeferredHolder<MobEffect, TotemEffect> TOTEM_EFFECT = MOB_EFFECTS.register("totem_effect", TotemEffect::new);

}
