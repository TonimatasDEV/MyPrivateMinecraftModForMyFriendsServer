package dev.tonimatas.myfriendsmod.register;

import com.mojang.blaze3d.platform.InputConstants;
import dev.tonimatas.myfriendsmod.MyFriendsMod;
import dev.tonimatas.myfriendsmod.networking.OpenSkillMenuPacket;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinding {
    public static final String KEY_CATEGORY = "key.categories.myfriendsmod";
    public static final String KEY_TEST = "key.myfriendsmod.test";

    public static final Lazy<KeyMapping> TEST_MAPPING = Lazy.of(() -> new KeyMapping(KEY_TEST,
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Y, KEY_CATEGORY));

    @EventBusSubscriber(modid = MyFriendsMod.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            while (ModKeyBinding.TEST_MAPPING.get().consumeClick()) {
                PacketDistributor.sendToServer(new OpenSkillMenuPacket());
            }
        }
    }

    @EventBusSubscriber(modid = MyFriendsMod.MODID, value = Dist.CLIENT)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(ModKeyBinding.TEST_MAPPING.get());
        }
    }
}
