package dunkmania101.modularmod.base.registry.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.ModularModCreativeModeTab;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.interfaces.IItemRegistryHandler;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public abstract class BaseItemRegistryHandler<M extends IModularModModule<?>> implements IItemRegistryHandler<M> {
    private final M PARENT;
    private final Map<ResourceLocation, Supplier<? extends Item>> ENTRIES = new HashMap<>();
    private ResourceLocation TAB_ICON_ID;
    private ModularModCreativeModeTab CREATIVE_MODE_TAB;
    private final IRegistryAcceptor<? extends Item> acceptor;
    private final String ID;
    private final String FRIENDLY_NAME;

    public BaseItemRegistryHandler(M parent, IRegistryAcceptor<? extends Item> acceptor, String id, String friendlyName) {
        this.PARENT = parent;
        this.acceptor = acceptor;
        this.ID = id;
        this.FRIENDLY_NAME = friendlyName;
    }

    public BaseItemRegistryHandler(M parent, String id, String friendlyName) {
        this(parent, parent.getRegistryAcceptorOfId(Registries.ITEM.location()), id, friendlyName);
    }

    public BaseItemRegistryHandler(M parent, String id) {
        this(parent, id, null);
    }

    public BaseItemRegistryHandler(M parent) {
        this(parent, null);
    }

    @Override
    public String getId() {
        return this.ID == null ? IItemRegistryHandler.super.getId() : this.ID;
    }

    @Override
    public String getFriendlyName() {
        return this.FRIENDLY_NAME == null ? IItemRegistryHandler.super.getFriendlyName() : this.FRIENDLY_NAME;
    }

    @Override
    public IRegistryAcceptor<? extends Item> getAcceptor() {
        return this.acceptor;
    }

    @Override
    public M getParentModule() {
        return this.PARENT;
    }

    @Override
    public Map<ResourceLocation, Supplier<? extends Item>> getEntries() {
        return this.ENTRIES;
    }

    @Override
    public ModularModCreativeModeTab getCreativeModeTab() {
        return this.CREATIVE_MODE_TAB;
    }

    @Override
    public void setCreativeModeTab(ModularModCreativeModeTab tab) {
        this.CREATIVE_MODE_TAB = tab;
    }

    @Override
    public ResourceLocation getTabIconId() {
        return this.TAB_ICON_ID;
    }

    @Override
    public void setTabIconId(ResourceLocation id) {
        this.TAB_ICON_ID = id;
    }
}
