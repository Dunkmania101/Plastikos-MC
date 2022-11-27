package dunkmania101.plastikos.modules.base;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.base.common.registry.PlastikosBaseBlockRegistry;
import dunkmania101.plastikos.modules.base.common.registry.PlastikosBaseItemRegistry;

public class PlastikosModuleBase implements IModularModModule {
    protected final IModularModModule PARENT;

    public final PlastikosBaseItemRegistry ITEMS;
    public final PlastikosBaseBlockRegistry BLOCKS;

    public PlastikosModuleBase(IModularModModule parent) {
        this.PARENT = parent;
        this.ITEMS = new PlastikosBaseItemRegistry(this);
        this.BLOCKS = new PlastikosBaseBlockRegistry(this);
    }

    @Override
    public IModularModModule getParent() {
        return this.PARENT;
    }

    @Override
    public String getId() {
        return PlastikosConstants.MODULEID_BASE;
    }

    @Override
    public void commonRegistrySetup() {
        this.ITEMS.registerObjects();
        this.BLOCKS.registerObjects();
    }
}
