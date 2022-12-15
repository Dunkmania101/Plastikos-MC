package dunkmania101.plastikos.modules.production.modules.harvesting;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.production.modules.harvesting.common.registry.PlastikosProductionHarvestingBlockRegistry;
import dunkmania101.plastikos.modules.production.modules.harvesting.common.registry.PlastikosProductionHarvestingItemRegistry;

public class PlastikosModuleProductionModuleHarvesting extends BasePlastikosModule {
    public final PlastikosProductionHarvestingBlockRegistry BLOCKS;
    public final PlastikosProductionHarvestingItemRegistry ITEMS;

    public PlastikosModuleProductionModuleHarvesting(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosProductionHarvestingBlockRegistry(this);
        this.ITEMS = new PlastikosProductionHarvestingItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_HARVESTING;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
