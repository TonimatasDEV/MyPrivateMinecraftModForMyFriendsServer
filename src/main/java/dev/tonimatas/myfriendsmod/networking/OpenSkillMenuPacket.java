package dev.tonimatas.myfriendsmod.networking;

import dev.tonimatas.myfriendsmod.MyFriendsMod;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.server.command.NeoForgeCommand;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record OpenSkillMenuPacket() implements CustomPacketPayload {
    public static final Type<OpenSkillMenuPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MyFriendsMod.MODID, "open_skill_menu"));

    public static final StreamCodec<FriendlyByteBuf, OpenSkillMenuPacket> STREAM_CODEC = StreamCodec.unit(new OpenSkillMenuPacket());
    
    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
    
    public static void handle(final OpenSkillMenuPacket packet, final IPayloadContext context) {
        context.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) context.player();

            player.openMenu(new MenuProvider() {
                @Override
                public @NotNull Component getDisplayName() {
                    return Component.literal("Test");
                }

                @Override
                public @NotNull AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
                    return ChestMenu.sixRows(1, player.getInventory(), new SimpleContainer(55));
                }
            });

            player.displayClientMessage(Component.literal("Test"), false);
        });
    }
}
