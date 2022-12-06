package dunkmania101.plastikos.modules.logistics.modules.storage;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.logistics.modules.storage.common.registry.PlastikosLogisticsStorageBlockRegistry;
import dunkmania101.plastikos.modules.logistics.modules.storage.common.registry.PlastikosLogisticsStorageItemRegistry;

public class PlastikosModuleLogisticsModuleStorage implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosLogisticsStorageBlockRegistry BLOCKS;
    public final PlastikosLogisticsStorageItemRegistry ITEMS;

    public PlastikosModuleLogisticsModuleStorage(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosLogisticsStorageBlockRegistry(this);
        this.ITEMS = new PlastikosLogisticsStorageItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_STORAGE;
    }

    @Override
    public IModularModModule getParent() {
        return this.PARENT;
    }

    @Override
    public Map<String, IModularModModule> getChildren() {
        return this.MODULES;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
