package dunkmania101.plastikos.modules.warfare.modules.materials;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.warfare.modules.materials.common.registry.PlastikosWarfareMaterialsBlockRegistry;
import dunkmania101.plastikos.modules.warfare.modules.materials.common.registry.PlastikosWarfareMaterialsItemRegistry;

public class PlastikosModuleWarfareModuleMaterials extends BasePlastikosModule {
    public final PlastikosWarfareMaterialsBlockRegistry BLOCKS;
    public final PlastikosWarfareMaterialsItemRegistry ITEMS;

    public PlastikosModuleWarfareModuleMaterials(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosWarfareMaterialsBlockRegistry(this);
        this.ITEMS = new PlastikosWarfareMaterialsItemRegistry(this);
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
