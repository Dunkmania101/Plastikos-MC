package dunkmania101.plastikos.modules.base.modules.materials;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.base.modules.materials.common.registry.PlastikosBaseMaterialsBlockRegistry;
import dunkmania101.plastikos.modules.base.modules.materials.common.registry.PlastikosBaseMaterialsItemRegistry;

public class PlastikosModuleBaseModuleMaterials extends BasePlastikosModule {
    public final PlastikosBaseMaterialsBlockRegistry BLOCKS;
    public final PlastikosBaseMaterialsItemRegistry ITEMS;

    public PlastikosModuleBaseModuleMaterials(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosBaseMaterialsBlockRegistry(this);
        this.ITEMS = new PlastikosBaseMaterialsItemRegistry(this);
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
