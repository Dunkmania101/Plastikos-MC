package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land.common.registry;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;

public class PlastikosTransportationVehiclesLandBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosTransportationVehiclesLandBlockRegistry(IModularModModule parent) {
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
