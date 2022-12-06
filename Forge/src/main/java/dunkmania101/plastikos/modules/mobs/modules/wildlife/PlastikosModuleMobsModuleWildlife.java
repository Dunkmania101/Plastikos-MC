package dunkmania101.plastikos.modules.mobs.modules.wildlife;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.mobs.modules.wildlife.common.registry.PlastikosMobsWildlifeBlockRegistry;
import dunkmania101.plastikos.modules.mobs.modules.wildlife.common.registry.PlastikosMobsWildlifeItemRegistry;

public class PlastikosModuleMobsModuleWildlife implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosMobsWildlifeBlockRegistry BLOCKS;
    public final PlastikosMobsWildlifeItemRegistry ITEMS;

    public PlastikosModuleMobsModuleWildlife(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosMobsWildlifeBlockRegistry(this);
        this.ITEMS = new PlastikosMobsWildlifeItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WILDLIFE;
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
