package dunkmania101.plastikos.modules.mobs.modules.wildlife;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.mobs.modules.wildlife.common.registry.PlastikosMobsWildlifeBlockRegistry;
import dunkmania101.plastikos.modules.mobs.modules.wildlife.common.registry.PlastikosMobsWildlifeItemRegistry;

public class PlastikosModuleMobsModuleWildlife extends BasePlastikosModule {
    public final PlastikosMobsWildlifeBlockRegistry BLOCKS;
    public final PlastikosMobsWildlifeItemRegistry ITEMS;

    public PlastikosModuleMobsModuleWildlife(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosMobsWildlifeBlockRegistry(this);
        this.ITEMS = new PlastikosMobsWildlifeItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WILDLIFE;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
