package dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water.common.registry.PlastikosTransportationVehiclesWaterBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water.common.registry.PlastikosTransportationVehiclesWaterItemRegistry;

public class PlastikosModuleTransportationModuleVehiclesModuleWater implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosTransportationVehiclesWaterBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesWaterItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehiclesModuleWater(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosTransportationVehiclesWaterBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesWaterItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_WATER;
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
