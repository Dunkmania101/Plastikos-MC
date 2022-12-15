package dunkmania101.plastikos.modules.control.modules.terminals;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.control.modules.terminals.common.registry.PlastikosControlTerminalsBlockRegistry;
import dunkmania101.plastikos.modules.control.modules.terminals.common.registry.PlastikosControlTerminalsItemRegistry;

public class PlastikosModuleControlModuleTerminals extends BasePlastikosModule {
    public final PlastikosControlTerminalsBlockRegistry BLOCKS;
    public final PlastikosControlTerminalsItemRegistry ITEMS;

    public PlastikosModuleControlModuleTerminals(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosControlTerminalsBlockRegistry(this);
        this.ITEMS = new PlastikosControlTerminalsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_TERMINALS;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
