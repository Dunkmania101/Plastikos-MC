package dunkmania101.plastikos.modules.production;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.production.common.registry.PlastikosProductionBlockRegistry;
import dunkmania101.plastikos.modules.production.common.registry.PlastikosProductionItemRegistry;
import dunkmania101.plastikos.modules.production.modules.harvesting.PlastikosModuleProductionModuleHarvesting ;

public class PlastikosModuleProduction extends BasePlastikosModule {
    public final PlastikosModuleProductionModuleHarvesting HARVESTING;

    public final PlastikosProductionBlockRegistry BLOCKS;
    public final PlastikosProductionItemRegistry ITEMS;

    public PlastikosModuleProduction(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosProductionBlockRegistry(this);
        this.ITEMS = new PlastikosProductionItemRegistry(this);

        this.HARVESTING = registerChild(new PlastikosModuleProductionModuleHarvesting(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_PRODUCTION;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
