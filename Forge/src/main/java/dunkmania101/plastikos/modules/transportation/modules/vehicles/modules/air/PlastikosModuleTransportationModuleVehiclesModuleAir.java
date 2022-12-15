package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air.common.registry.PlastikosTransportationVehiclesAirBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air.common.registry.PlastikosTransportationVehiclesAirItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleAir extends BasePlastikosModule {
    public final PlastikosTransportationVehiclesAirBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesAirItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleAir(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosTransportationVehiclesAirBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesAirItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_AIR;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
