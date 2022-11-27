package dunkmania101.modularmod.base.client.ui.containers.base;

import java.util.ArrayList;

import dunkmania101.modularmod.base.client.ui.base.interfaces.IHasVisualContent;
import dunkmania101.modularmod.base.client.ui.containers.base.interfaces.IHasSlots;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BaseContainerUIHolder extends AbstractContainerMenu implements IHasSlots {
    protected int TOP;
    protected int LEFT;
    protected IHasVisualContent<?> PARENT;
    protected ArrayList<IHasSlots> CHILDREN;

    public BaseContainerUIHolder(MenuType<BaseContainerUIHolder> menuType, int menuId) {
        super(menuType, menuId);
    }

    @Override
    public boolean moveItemStackTo(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
        return IHasSlots.super.moveItemStackTo(stack, startIndex, endIndex, reverseDirection);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return IHasSlots.super.quickMoveStack(player, index);
    }

    @Override
    public Slot addSlot(Slot slot) {
        this.slots.add(slot);
        return slot;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void setTop(int top) {
        this.TOP = top;
    }

    @Override
    public void setLeft(int left) {
        this.LEFT = left;
    }

    @Override
    public int getTop() {
        return this.TOP;
    }

    @Override
    public int getLeft() {
        return this.LEFT;
    }

    @Override
    public void setParent(IHasVisualContent<?> parent) {
    }

    @Override
    public IHasVisualContent<?> getParent() {
        return this;
    }

    @Override
    public ArrayList<IHasSlots> getChildren() {
        return this.CHILDREN;
    }

    @Override
    public ArrayList<Slot> getSlots() {
        return new ArrayList<>(this.slots);
    }
}
