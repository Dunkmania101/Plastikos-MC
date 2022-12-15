package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land.common.registry.PlastikosTransportationVehiclesLandBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land.common.registry.PlastikosTransportationVehiclesLandItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleLand extends BasePlastikosModule {
    public final PlastikosTransportationVehiclesLandBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesLandItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleLand(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosTransportationVehiclesLandBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesLandItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_LAND;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
