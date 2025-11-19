package dev.tonimatas.myfriendsmod.register;

import dev.tonimatas.myfriendsmod.MyFriendsMod;
import dev.tonimatas.myfriendsmod.networking.OpenSkillMenuPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = MyFriendsMod.MODID)
public class ModNetworking {
    public static final String PROTOCOL_VERSION = "1";
    
    @SubscribeEvent
    public static void registerNetworking(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(PROTOCOL_VERSION);
        registrar.commonToServer(OpenSkillMenuPacket.TYPE, OpenSkillMenuPacket.STREAM_CODEC, new MainThreadPayloadHandler<>(OpenSkillMenuPacket::handle));
    }
}
