package dev.tonimatas.myfriendsmod.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DefaultMenu extends AbstractContainerMenu {
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private int slotCount;
    
    public DefaultMenu(@Nullable MenuType<?> menuType, int containerId, Inventory inventory, int slotCount) {
        super(menuType, containerId);
        
        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);
        
        this.slotCount = slotCount;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int i) {
        Slot sourceSlot = slots.get(i);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (i < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + slotCount, false)) {
                return ItemStack.EMPTY;
            }
        } else if (i < TE_INVENTORY_FIRST_SLOT_INDEX + slotCount) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    private void addPlayerInventory(Inventory inventory) {
        int y = 99;

        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inventory, l + i * 9 + 9, 8 + l * 18, y + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inventory) {
        int y = 157;

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, y));
        }
    }
}
