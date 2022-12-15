package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets.common.registry.PlastikosTransportationVehiclesRocketsBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets.common.registry.PlastikosTransportationVehiclesRocketsItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleRockets extends BasePlastikosModule {
    public final PlastikosTransportationVehiclesRocketsBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesRocketsItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleRockets(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosTransportationVehiclesRocketsBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesRocketsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_ROCKETS;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
