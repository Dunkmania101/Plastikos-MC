package dunkmania101.plastikos.modules.base;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.base.common.registry.PlastikosBaseBlockRegistry;
import dunkmania101.plastikos.modules.base.common.registry.PlastikosBaseItemRegistry;
import dunkmania101.plastikos.modules.base.modules.materials.PlastikosModuleBaseModuleMaterials;

public class PlastikosModuleBase extends BasePlastikosModule {
    public final PlastikosModuleBaseModuleMaterials MATERIALS;

    public final PlastikosBaseBlockRegistry BLOCKS;
    public final PlastikosBaseItemRegistry ITEMS;

    public PlastikosModuleBase(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosBaseBlockRegistry(this);
        this.ITEMS = new PlastikosBaseItemRegistry(this);

        this.MATERIALS = registerChild(new PlastikosModuleBaseModuleMaterials(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_BASE;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
