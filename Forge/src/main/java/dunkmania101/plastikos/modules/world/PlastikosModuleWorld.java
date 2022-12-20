package dunkmania101.plastikos.modules.world;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.world.common.registry.PlastikosWorldBlockRegistry;
import dunkmania101.plastikos.modules.world.common.registry.PlastikosWorldItemRegistry;
import dunkmania101.plastikos.modules.world.modules.planets.PlastikosModuleWorldModulePlanets;
import dunkmania101.plastikos.modules.world.modules.space.PlastikosModuleWorldModuleSpace;

public class PlastikosModuleWorld extends BasePlastikosModule {
    public final PlastikosModuleWorldModuleSpace SPACE;
    public final PlastikosModuleWorldModulePlanets PLANETS;

    public final PlastikosWorldBlockRegistry BLOCKS;
    public final PlastikosWorldItemRegistry ITEMS;

    public PlastikosModuleWorld(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosWorldBlockRegistry(this);
        this.ITEMS = new PlastikosWorldItemRegistry(this);

        this.SPACE = registerChild(new PlastikosModuleWorldModuleSpace(this));
        this.PLANETS = registerChild(new PlastikosModuleWorldModulePlanets(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WORLD;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
