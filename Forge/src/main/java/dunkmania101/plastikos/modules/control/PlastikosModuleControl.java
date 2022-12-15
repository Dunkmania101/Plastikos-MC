package dunkmania101.plastikos.modules.control;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.control.common.registry.PlastikosControlBlockRegistry;
import dunkmania101.plastikos.modules.control.common.registry.PlastikosControlItemRegistry;
import dunkmania101.plastikos.modules.control.modules.terminals.PlastikosModuleControlModuleTerminals;

public class PlastikosModuleControl extends BasePlastikosModule {
    public final PlastikosModuleControlModuleTerminals TERMINALS;

    public final PlastikosControlBlockRegistry BLOCKS;
    public final PlastikosControlItemRegistry ITEMS;

    public PlastikosModuleControl(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosControlBlockRegistry(this);
        this.ITEMS = new PlastikosControlItemRegistry(this);

        this.TERMINALS = registerChild(new PlastikosModuleControlModuleTerminals(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_CONTROL;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
