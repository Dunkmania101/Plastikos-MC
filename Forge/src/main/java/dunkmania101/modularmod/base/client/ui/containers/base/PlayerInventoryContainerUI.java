package dunkmania101.modularmod.base.client.ui.containers.base;

import dunkmania101.modularmod.base.client.ui.containers.base.interfaces.IHasSlots;
import dunkmania101.modularmod.base.data.ModularModConstants;
import net.minecraft.world.entity.player.Inventory;

public class PlayerInventoryContainerUI extends BaseContainerUI {
    protected final Inventory inventory;

    public PlayerInventoryContainerUI(int top, int left, IHasSlots parent, Inventory inventory) {
        super(top, left, parent);
        this.inventory = inventory;
    }

    @Override
    public void drawSlots() {
        drawSlotGrid(getLeft(), getTop(), 9, 3, inventory);
        drawSlotGrid(getLeft(), getTop()+((ModularModConstants.SLOT_SIZE+2)*3), 9, 1, 27, inventory);
    }
}
