package dunkmania101.modularmod.base.registry.interfaces;

import dunkmania101.modularmod.base.modules.ModularModCreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public interface IItemRegistryHandler extends IRegistryHandler<Item> {
    CreativeModeTab getCreativeModeTab();
    void setCreativeModeTab(CreativeModeTab tab);
    default void createCreativeModeTab() {
        this.setCreativeModeTab(new ModularModCreativeModeTab(getParentModule().getFriendlyName()) {
            @Override
            public ResourceLocation getIconId() {
                return getTabIconId();
            }
        });
    }

    default Item.Properties getBaseProperties() {
        return new Item.Properties().tab(getCreativeModeTab());
    }

    default Item getDefaultItem() {
        return new Item(getBaseProperties());
    }

    default ResourceLocation getTabIconId() {return null;}
    default void setTabIconId(ResourceLocation id) {}
    default void updateTabIconId() {}
}
