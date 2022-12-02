package dunkmania101.modularmod.base.registry.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.interfaces.IItemRegistryHandler;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public abstract class BaseItemRegistryHandler implements IItemRegistryHandler {
    private final IModularModModule PARENT;
    private final Map<ResourceLocation, Supplier<? extends Item>> ENTRIES = new HashMap<>();
    private ResourceLocation TAB_ICON_ID;
    private CreativeModeTab CREATIVE_MODE_TAB;
    private final IRegistryAcceptor<? extends Item> acceptor;

    public BaseItemRegistryHandler(IModularModModule parent, IRegistryAcceptor<? extends Item> acceptor) {
        this.PARENT = parent;
        this.acceptor = acceptor;
        this.createCreativeModeTab();
    }

    public BaseItemRegistryHandler(IModularModModule parent) {
        this(parent, parent.getRegistryAcceptorOfId(Registry.ITEM_REGISTRY.location()));
    }

    @Override
    public IRegistryAcceptor<? extends Item> getAcceptor() {
        return this.acceptor;
    }

    @Override
    public IModularModModule getParentModule() {
        return this.PARENT;
    }

    @Override
    public Map<ResourceLocation, Supplier<? extends Item>> getEntries() {
        return this.ENTRIES;
    }

    @Override
    public CreativeModeTab getCreativeModeTab() {
        return this.CREATIVE_MODE_TAB;
    }

    @Override
    public void setCreativeModeTab(CreativeModeTab tab) {
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
