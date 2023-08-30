package dunkmania101.modularmod.base.client.ui.screens.base.interfaces;

import com.mojang.blaze3d.vertex.PoseStack;

import dunkmania101.modularmod.base.client.ui.base.interfaces.IHasVisualContent;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public interface IBaseScreen extends IHasVisualContent<IBaseScreen> {
    default void drawImage(/*@Nonnull PoseStack poseStack,*/ ResourceLocation imageIn, int leftIn, int topIn, int widthIn, int heightIn) {
        //getMinecraft().getTextureManager().bindForSetup(imageIn);
        //getGuiGraphics().blit(poseStack, leftIn, topIn, 0, 0, widthIn, heightIn, widthIn, heightIn);
        getGuiGraphics().blit(imageIn, leftIn, topIn, 0, 0, widthIn, heightIn, widthIn, heightIn);
    }

    default void drawString(PoseStack poseStack, Font font, Component text, int x, int y, int color, boolean centered) {
        if (centered) {
            getGuiGraphics().drawCenteredString(/*poseStack,*/ font, text, x, y, color);
        } else {
            getGuiGraphics().drawString(/*poseStack,*/ font, text, x, y, color);
        }
    }
}
