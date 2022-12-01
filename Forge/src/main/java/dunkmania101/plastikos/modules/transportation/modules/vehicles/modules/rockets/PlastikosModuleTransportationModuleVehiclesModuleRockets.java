package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets.common.registry.PlastikosTransportationVehiclesRocketsBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets.common.registry.PlastikosTransportationVehiclesRocketsItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleRockets implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosTransportationVehiclesRocketsBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesRocketsItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleRockets(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosTransportationVehiclesRocketsBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesRocketsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_TRANSPORTATION_VEHICLES_ROCKETS;
    }

    @Override
    public IModularModModule getParent() {
        return this.PARENT;
    }

    @Override
    public Map<String, IModularModModule> getChildren() {
        return this.MODULES;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
