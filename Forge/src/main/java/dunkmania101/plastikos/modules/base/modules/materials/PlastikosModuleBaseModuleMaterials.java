package dunkmania101.plastikos.modules.base.modules.materials;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.base.modules.materials.common.registry.PlastikosBaseMaterialsBlockRegistry;
import dunkmania101.plastikos.modules.base.modules.materials.common.registry.PlastikosBaseMaterialsItemRegistry;

public class PlastikosModuleBaseModuleMaterials implements IModularModModule {
    protected final IModularModModule PARENT;

    public final PlastikosBaseMaterialsBlockRegistry BLOCKS;
    public final PlastikosBaseMaterialsItemRegistry ITEMS;

    public PlastikosModuleBaseModuleMaterials(IModularModModule parent) {
        this.PARENT = parent;

        this.BLOCKS = new PlastikosBaseMaterialsBlockRegistry(this);
        this.ITEMS = new PlastikosBaseMaterialsItemRegistry(this);
    }

    @Override
    public IModularModModule getParent() {
        return this.PARENT;
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_MATERIALS;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
