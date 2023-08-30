package dunkmania101.modularmod.base.client.ui.base.interfaces;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

public interface IHasVisualContent<T extends IHasVisualContent<?>> {
    default Minecraft getMinecraft() {
        Minecraft mc = Minecraft.getInstance(); // Trying to avoid a potential memory leak
        return mc;
    }

    default GuiGraphics getGuiGraphics() {
        GuiGraphics guigraphics = new GuiGraphics(getMinecraft(), getMinecraft().renderBuffers().bufferSource()); // Trying to avoid a potential memory leak
        return guigraphics;
    }

    void setParent(IHasVisualContent<?> newParent);

    IHasVisualContent<?> getParent();

    default void addChild(T child) {
        child.setParent(this);
        getChildren().add(child);
    }

    ArrayList<T> getChildren();

    default void draw() {
        getChildren().forEach(T::draw);
    }

    default void clear() {}

    default void redraw() {
        clear();
        draw();
    }

    void setTop(int top);

    void setLeft(int left);

    int getTop();

    int getLeft();

    default int getBottom() {
        int bottom = getTop();
        for (T child : getChildren()) {
            int childBottom = child.getBottom();
            if (childBottom > bottom) {
                bottom = childBottom;
            }
        }
        return bottom;
    }

    default int getRight() {
        int right = getLeft();
        for (T child : getChildren()) {
            int childRight = child.getRight();
            if (childRight > right) {
                right = childRight;
            }
        }
        return right;
    }

    default int getHeight() {
        return getBottom() - getTop();
    }

    default int getWidth() {
        return getRight() - getLeft();
    }
}
