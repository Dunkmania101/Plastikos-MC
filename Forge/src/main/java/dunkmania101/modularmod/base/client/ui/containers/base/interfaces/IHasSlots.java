package dunkmania101.modularmod.base.client.ui.containers.base.interfaces;

import java.util.ArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import dunkmania101.modularmod.base.client.ui.base.interfaces.IHasVisualContent;
import dunkmania101.modularmod.base.data.ModularModConstants;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public interface IHasSlots extends IHasVisualContent<IHasSlots> {
    default Container getRootContainer() {
        IHasVisualContent<?> parent = getParent();
        if (parent instanceof IHasSlots slotsParent) {
            return slotsParent.getRootContainer();
        }
        return null;
    }

    @Nonnull
    ArrayList<Slot> getSlots();

    default Slot getSlot(int index) {
        if (index < 0 || index >= getSlotCount()) {
            return null;
        }
        return getSlots().get(index);
    }

    default int getSlotCount() {
        return getSlots().size();
    }

    default Slot addSlot(Slot slot) {
        getSlots().add(slot);
        return slot;
    }

    @Nullable
    default Slot addSlot(int x, int y, int id, Container container) {
        if (id >= container.getContainerSize()) {
            return null;
        }
        return addSlot(new Slot(container, id, x, y));
    }

    @Nullable
    default Slot addSlot(int x, int y, int id) {
        return addSlot(x, y, id, getRootContainer());
    }

    default void drawSlotGrid(int x, int y, int gap, int slotsX, int slotsY, int startId, Container container) {
        for (int slotY = 0; slotY < slotsY; slotY++) {
            for (int slotX = 0; slotX < slotsX; slotX++) {
                int id = slotX + slotY*slotsX;
                if (id >= container.getContainerSize()) {
                    return;
                }
                addSlot(x+(slotX*(gap+ModularModConstants.SLOT_SIZE)), y+(slotY*(gap+ModularModConstants.SLOT_SIZE)), startId+id, container);
            }
        }
    }

    default void drawSlotGrid(int x, int y, int slotsX, int slotsY, int startId, Container container) {
        drawSlotGrid(x, y, 2, slotsX, slotsY, startId, container);
    }

    default void drawSlotGrid(int x, int y, int gap, int slotsX, int slotsY, int startId) {
        drawSlotGrid(x, y, gap, slotsX, slotsY, startId, getRootContainer());
    }

    default void drawSlotGrid(int x, int y, int slotsX, int slotsY, int startId) {
        drawSlotGrid(x, y, 2, slotsX, slotsY, startId);
    }

    default void drawSlotGrid(int x, int y, int slotsX, int slotsY, Container container) {
        drawSlotGrid(x, y, 2, slotsX, slotsY, 0, container);
    }

    default void drawSlotGrid(int x, int y, int slotsX, int slotsY) {
        drawSlotGrid(x, y, slotsX, slotsY, 0);
    }

    default void drawSlots() {}

    @Override
    default void draw() {
        drawSlots();
    }

    default boolean moveItemStackTo(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
        boolean flag = false;
        int i = startIndex;
        if (reverseDirection) {
            i = endIndex - 1;
        }

        if (stack.isStackable()) {
            while (!stack.isEmpty()) {
                if (reverseDirection) {
                    if (i < startIndex) {
                        break;
                    }
                } else if (i >= endIndex) {
                    break;
                }

                Slot slot = getSlot(i);
                ItemStack itemstack = slot.getItem();
                if (!itemstack.isEmpty() && ItemStack.isSameItemSameTags(stack, itemstack)) {
                    int j = itemstack.getCount() + stack.getCount();
                    int maxSize = Math.min(slot.getMaxStackSize(), stack.getMaxStackSize());
                    if (j <= maxSize) {
                        stack.setCount(0);
                        itemstack.setCount(j);
                        slot.setChanged();
                        flag = true;
                    } else if (itemstack.getCount() < maxSize) {
                        stack.shrink(maxSize - itemstack.getCount());
                        itemstack.setCount(maxSize);
                        slot.setChanged();
                        flag = true;
                    }
                }

                if (reverseDirection) {
                    --i;
                } else {
                    ++i;
                }
            }
        }

        if (!stack.isEmpty()) {
            if (reverseDirection) {
                i = endIndex - 1;
            } else {
                i = startIndex;
            }

            while (true) {
                if (reverseDirection) {
                    if (i < startIndex) {
                        break;
                    }
                } else if (i >= endIndex) {
                    break;
                }

                Slot slot1 = getSlot(i);
                ItemStack itemstack1 = slot1.getItem();
                if (itemstack1.isEmpty() && slot1.mayPlace(stack)) {
                    if (stack.getCount() > slot1.getMaxStackSize()) {
                        slot1.set(stack.split(slot1.getMaxStackSize()));
                    } else {
                        slot1.set(stack.split(stack.getCount()));
                    }

                    slot1.setChanged();
                    flag = true;
                    break;
                }

                if (reverseDirection) {
                    --i;
                } else {
                    ++i;
                }
            }
        }

        return flag;
    }

    default ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = getSlot(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < getSlotCount()) {
                if (!this.moveItemStackTo(itemstack1, getSlotCount(), getSlotCount(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, getSlotCount(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }
}
