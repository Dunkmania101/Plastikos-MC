package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water.common.registry.PlastikosTransportationVehiclesWaterBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water.common.registry.PlastikosTransportationVehiclesWaterItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleWater extends BasePlastikosModule {
    public final PlastikosTransportationVehiclesWaterBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesWaterItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleWater(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosTransportationVehiclesWaterBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesWaterItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WATER;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
