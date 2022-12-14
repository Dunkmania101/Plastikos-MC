package dunkmania101.modularmod.base.registry.interfaces;

import dunkmania101.modularmod.base.modules.ModularModCreativeModeTab;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public interface IItemRegistryHandler<M extends IModularModModule<?>> extends IRegistryHandler<Item, M> {
    ModularModCreativeModeTab getCreativeModeTab();
    void setCreativeModeTab(ModularModCreativeModeTab tab);
    default void createCreativeModeTab() {
        this.setCreativeModeTab(new ModularModCreativeModeTab(getParentModule().getFriendlyName()) {
            @Override
            public ResourceLocation getIconId() {
                return getTabIconId();
            }
        });
        getParentModule().addCreativeTab(getCreativeModeTab());
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

    @Override
    default void postRegisterObjects() {
        IRegistryHandler.super.postRegisterObjects();
        createCreativeModeTab();
    }
}
