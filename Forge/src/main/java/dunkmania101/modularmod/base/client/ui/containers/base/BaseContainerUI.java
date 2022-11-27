package dunkmania101.modularmod.base.client.ui.containers.base;

import java.util.ArrayList;

import dunkmania101.modularmod.base.client.ui.base.interfaces.IHasVisualContent;
import dunkmania101.modularmod.base.client.ui.containers.base.interfaces.IHasSlots;
import net.minecraft.world.inventory.Slot;

public abstract class BaseContainerUI implements IHasSlots {
    protected int TOP;
    protected int LEFT;
    protected IHasVisualContent<?> PARENT;
    protected ArrayList<IHasSlots> CHILDREN;
    protected ArrayList<Slot> SLOTS;

    public BaseContainerUI(int top, int left, IHasSlots parent) {
        this.CHILDREN = new ArrayList<>();
        this.SLOTS = new ArrayList<>();
        setTop(top);
        setLeft(left);
        setParent(parent);
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
        this.PARENT = parent;
    }

    @Override
    public IHasVisualContent<?> getParent() {
        return this.PARENT;
    }

    @Override
    public ArrayList<IHasSlots> getChildren() {
        return this.CHILDREN;
    }

    @Override
    public ArrayList<Slot> getSlots() {
        return this.SLOTS;
    }
}
