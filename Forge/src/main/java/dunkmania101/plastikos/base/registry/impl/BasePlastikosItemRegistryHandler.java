package dunkmania101.plastikos.base.registry.impl;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public abstract class BasePlastikosItemRegistryHandler extends BaseItemRegistryHandler {
    public BasePlastikosItemRegistryHandler(IModularModModule parent, IRegistryAcceptor<? extends Item> acceptor) {
        super(parent, acceptor);
    }

    public BasePlastikosItemRegistryHandler(IModularModModule parent) {
        this(parent, parent.getRegistryAcceptorOfId(Registry.ITEM_REGISTRY.location()));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
