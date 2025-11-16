package dev.tonimatas.myfriendsmod;

import com.mojang.logging.LogUtils;
import dev.tonimatas.myfriendsmod.register.ModAttachments;
import dev.tonimatas.myfriendsmod.register.ModBlocks;
import dev.tonimatas.myfriendsmod.register.ModItems;
import dev.tonimatas.myfriendsmod.register.ModTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(MyFriendsMod.MODID)
public class MyFriendsMod {
    public static final String MODID = "myfriendsmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MyFriendsMod(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModAttachments.ATTACHMENT_TYPES.register(modEventBus);
        
        LOGGER.info("MyFriendsMod has been initialized!");
    }
}
