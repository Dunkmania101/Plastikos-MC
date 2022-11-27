package dunkmania101.modularmod.base.modules;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModularModCreativeModeTab extends CreativeModeTab {
    public ModularModCreativeModeTab(String label) {
        super(label);
    }

    @Nullable
    public ResourceLocation getIconId() {
        return null;
    }

    @Nonnull
    public ResourceLocation getBlankIconId() {
       return Registry.ITEM.getDefaultKey();
    }

    @Override
    public ItemStack makeIcon() {
        ResourceLocation iconId = this.getIconId();
        return new ItemStack(Registry.ITEM.get(iconId == null ? this.getBlankIconId() : iconId));
    }
}
