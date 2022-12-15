package dunkmania101.plastikos.modules.logistics;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.logistics.common.registry.PlastikosLogisticsBlockRegistry;
import dunkmania101.plastikos.modules.logistics.common.registry.PlastikosLogisticsItemRegistry;
import dunkmania101.plastikos.modules.logistics.modules.storage.PlastikosModuleLogisticsModuleStorage;

public class PlastikosModuleLogistics extends BasePlastikosModule {
    public final PlastikosModuleLogisticsModuleStorage STORAGE;

    public final PlastikosLogisticsBlockRegistry BLOCKS;
    public final PlastikosLogisticsItemRegistry ITEMS;

    public PlastikosModuleLogistics(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosLogisticsBlockRegistry(this);
        this.ITEMS = new PlastikosLogisticsItemRegistry(this);

        this.STORAGE = registerChild(new PlastikosModuleLogisticsModuleStorage(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_LOGISTICS;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
