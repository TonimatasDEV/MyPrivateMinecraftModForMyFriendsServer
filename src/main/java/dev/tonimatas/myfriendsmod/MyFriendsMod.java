package dev.tonimatas.myfriendsmod;

import com.mojang.logging.LogUtils;
import dev.tonimatas.myfriendsmod.register.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(MyFriendsMod.MODID)
public class MyFriendsMod {
    public static final String MODID = "myfriendsmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MyFriendsMod(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModAttachments.ATTACHMENT_TYPES.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);

        LOGGER.info("MyFriendsMod has been initialized!");
    }
}
