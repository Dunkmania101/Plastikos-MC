package dunkmania101.plastikos.modules.logistics.modules.storage;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.logistics.modules.storage.common.registry.PlastikosLogisticsStorageBlockRegistry;
import dunkmania101.plastikos.modules.logistics.modules.storage.common.registry.PlastikosLogisticsStorageItemRegistry;

public class PlastikosModuleLogisticsModuleStorage extends BasePlastikosModule {
    public final PlastikosLogisticsStorageBlockRegistry BLOCKS;
    public final PlastikosLogisticsStorageItemRegistry ITEMS;

    public PlastikosModuleLogisticsModuleStorage(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosLogisticsStorageBlockRegistry(this);
        this.ITEMS = new PlastikosLogisticsStorageItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_STORAGE;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
