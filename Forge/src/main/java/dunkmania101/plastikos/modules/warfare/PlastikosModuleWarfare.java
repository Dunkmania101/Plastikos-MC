package dunkmania101.plastikos.modules.warfare;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.warfare.common.registry.PlastikosWarfareBlockRegistry;
import dunkmania101.plastikos.modules.warfare.common.registry.PlastikosWarfareItemRegistry;
import dunkmania101.plastikos.modules.warfare.modules.materials.PlastikosModuleWarfareModuleMaterials;

public class PlastikosModuleWarfare implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosModuleWarfareModuleMaterials MATERIALS;

    public final PlastikosWarfareBlockRegistry BLOCKS;
    public final PlastikosWarfareItemRegistry ITEMS;

    public PlastikosModuleWarfare(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.MATERIALS = registerChild(new PlastikosModuleWarfareModuleMaterials(this));

        this.BLOCKS = new PlastikosWarfareBlockRegistry(this);
        this.ITEMS = new PlastikosWarfareItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WARFARE;
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
