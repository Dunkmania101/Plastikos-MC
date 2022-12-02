package dunkmania101.plastikos.modules.warfare.modules.materials;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.warfare.modules.materials.common.registry.PlastikosWarfareMaterialsBlockRegistry;
import dunkmania101.plastikos.modules.warfare.modules.materials.common.registry.PlastikosWarfareMaterialsItemRegistry;

public class PlastikosModuleWarfareModuleMaterials implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosWarfareMaterialsBlockRegistry BLOCKS;
    public final PlastikosWarfareMaterialsItemRegistry ITEMS;

    public PlastikosModuleWarfareModuleMaterials(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosWarfareMaterialsBlockRegistry(this);
        this.ITEMS = new PlastikosWarfareMaterialsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WARFARE_MATERIALS;
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
