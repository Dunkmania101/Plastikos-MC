package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets.common.registry;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;

public class PlastikosTransportationVehiclesRocketsBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosTransportationVehiclesRocketsBlockRegistry(IModularModModule parent) {
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