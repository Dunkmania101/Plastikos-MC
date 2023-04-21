package dunkmania101.plastikos.modules.warfare;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.warfare.common.registry.PlastikosWarfareBlockRegistry;
import dunkmania101.plastikos.modules.warfare.common.registry.PlastikosWarfareItemRegistry;
import dunkmania101.plastikos.modules.warfare.modules.materials.PlastikosModuleWarfareModuleMaterials;

public class PlastikosModuleWarfare extends BasePlastikosModule {
    public final PlastikosModuleWarfareModuleMaterials MATERIALS;

    public final PlastikosWarfareBlockRegistry BLOCKS;
    public final PlastikosWarfareItemRegistry ITEMS;

    public PlastikosModuleWarfare(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosWarfareBlockRegistry(this);
        this.ITEMS = new PlastikosWarfareItemRegistry(this);

        this.MATERIALS = registerChild(new PlastikosModuleWarfareModuleMaterials(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WARFARE;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}

