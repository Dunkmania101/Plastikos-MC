package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air.common.registry.PlastikosTransportationVehiclesAirBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air.common.registry.PlastikosTransportationVehiclesAirItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleAir implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosTransportationVehiclesAirBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesAirItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleAir(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosTransportationVehiclesAirBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesAirItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_AIR;
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
