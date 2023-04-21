package dunkmania101.plastikos.modules.world.modules.planets;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.world.modules.planets.common.registry.PlastikosWorldPlanetsBlockRegistry;
import dunkmania101.plastikos.modules.world.modules.planets.common.registry.PlastikosWorldPlanetsItemRegistry;

public class PlastikosModuleWorldModulePlanets extends BasePlastikosModule {
    public final PlastikosWorldPlanetsBlockRegistry BLOCKS;
    public final PlastikosWorldPlanetsItemRegistry ITEMS;

    public PlastikosModuleWorldModulePlanets(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosWorldPlanetsBlockRegistry(this);
        this.ITEMS = new PlastikosWorldPlanetsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_PLANETS;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}

