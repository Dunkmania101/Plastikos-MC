package dunkmania101.plastikos.base.registry.impl;

import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public abstract class BasePlastikosItemRegistryHandler extends BaseItemRegistryHandler<IPlastikosModule> {
    public BasePlastikosItemRegistryHandler(IPlastikosModule parent, IRegistryAcceptor<? extends Item> acceptor, String id, String friendlyName) {
        super(parent, acceptor, id, friendlyName);
    }

    public BasePlastikosItemRegistryHandler(IPlastikosModule parent) {
        this(parent, parent.getRegistryAcceptorOfId(Registries.ITEM.location()), null, null);
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
