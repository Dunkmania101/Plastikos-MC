package dunkmania101.plastikos.base.registry.impl;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;

public abstract class BasePlastikosBlockRegistryHandler extends BaseBlockRegistryHandler {
    public BasePlastikosBlockRegistryHandler(IModularModModule parent, IRegistryAcceptor<? extends Block> acceptor) {
        super(parent, acceptor);
    }

    public BasePlastikosBlockRegistryHandler(IModularModModule parent) {
        this(parent, parent.getRegistryAcceptorOfId(Registry.BLOCK_REGISTRY.location()));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
