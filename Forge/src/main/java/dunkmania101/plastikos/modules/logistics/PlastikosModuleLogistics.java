package dunkmania101.plastikos.modules.logistics;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.logistics.common.registry.PlastikosLogisticsBlockRegistry;
import dunkmania101.plastikos.modules.logistics.common.registry.PlastikosLogisticsItemRegistry;
import dunkmania101.plastikos.modules.logistics.modules.storage.PlastikosModuleLogisticsModuleStorage;

public class PlastikosModuleLogistics implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosModuleLogisticsModuleStorage STORAGE;

    public final PlastikosLogisticsBlockRegistry BLOCKS;
    public final PlastikosLogisticsItemRegistry ITEMS;

    public PlastikosModuleLogistics(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.STORAGE = registerChild(new PlastikosModuleLogisticsModuleStorage(this));

        this.BLOCKS = new PlastikosLogisticsBlockRegistry(this);
        this.ITEMS = new PlastikosLogisticsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_LOGISTICS;
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
