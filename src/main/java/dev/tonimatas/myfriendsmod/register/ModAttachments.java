package dev.tonimatas.myfriendsmod.register;

import com.mojang.serialization.Codec;
import dev.tonimatas.myfriendsmod.MyFriendsMod;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MyFriendsMod.MODID);

    public static final Supplier<AttachmentType<Integer>> LEVEL = ATTACHMENT_TYPES.register(
            "level", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );
}
