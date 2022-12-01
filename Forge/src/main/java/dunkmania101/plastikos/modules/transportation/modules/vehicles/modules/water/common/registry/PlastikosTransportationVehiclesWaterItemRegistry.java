package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water.common.registry;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;

public class PlastikosTransportationVehiclesWaterItemRegistry extends BaseItemRegistryHandler {
    public PlastikosTransportationVehiclesWaterItemRegistry(IModularModModule parent) {
        super(parent);
    }

    @Override
    public void registerObjects() {
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
