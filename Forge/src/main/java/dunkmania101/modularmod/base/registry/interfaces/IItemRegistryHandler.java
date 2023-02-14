package dunkmania101.modularmod.base.registry.interfaces;

import dunkmania101.modularmod.base.modules.ModularModCreativeModeTab;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public interface IItemRegistryHandler<M extends IModularModModule<?>> extends IRegistryHandler<Item, M> {
    ModularModCreativeModeTab getCreativeModeTab();
    void setCreativeModeTab(ModularModCreativeModeTab tab);
    default void createCreativeModeTab(String label, String id) {
        setCreativeModeTab(new ModularModCreativeModeTab(label, () -> getEntries().values(), id) {
            @Override
            public ResourceLocation getIconId() {
                return getTabIconId();
            }
        });
        getParentModule().addCreativeTab(getCreativeModeTab());
    }
    default void createCreativeModeTab() {
        createCreativeModeTab(getFriendlyName(), getId());
    }

    default String getId() {
        return getParentModule().getId();
    }

    default String getFriendlyName() {
        return getParentModule().getFriendlyName();
    }

    default Item.Properties getBaseProperties() {
        return new Item.Properties();
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
