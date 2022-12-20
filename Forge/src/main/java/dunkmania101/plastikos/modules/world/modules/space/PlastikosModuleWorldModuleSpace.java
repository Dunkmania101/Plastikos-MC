package dunkmania101.plastikos.modules.world.modules.space;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.world.modules.space.common.registry.PlastikosWorldSpaceBlockRegistry;
import dunkmania101.plastikos.modules.world.modules.space.common.registry.PlastikosWorldSpaceItemRegistry;

public class PlastikosModuleWorldModuleSpace extends BasePlastikosModule {
    public final PlastikosWorldSpaceBlockRegistry BLOCKS;
    public final PlastikosWorldSpaceItemRegistry ITEMS;

    public PlastikosModuleWorldModuleSpace(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosWorldSpaceBlockRegistry(this);
        this.ITEMS = new PlastikosWorldSpaceItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_SPACE;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
