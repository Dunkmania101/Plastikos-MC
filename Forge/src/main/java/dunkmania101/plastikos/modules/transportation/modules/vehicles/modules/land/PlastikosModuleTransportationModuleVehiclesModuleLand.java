package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land.common.registry.PlastikosTransportationVehiclesLandBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land.common.registry.PlastikosTransportationVehiclesLandItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleLand implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosTransportationVehiclesLandBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesLandItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleLand(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosTransportationVehiclesLandBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesLandItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_TRANSPORTATION_VEHICLES_LAND;
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
