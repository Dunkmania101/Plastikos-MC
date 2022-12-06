package dunkmania101.plastikos.modules.transportation.modules.vehicles;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.common.registry.PlastikosTransportationVehiclesBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.common.registry.PlastikosTransportationVehiclesItemRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air.PlastikosModuleTransportationModuleVehiclesModuleAir;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land.PlastikosModuleTransportationModuleVehiclesModuleLand;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets.PlastikosModuleTransportationModuleVehiclesModuleRockets;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water.PlastikosModuleTransportationModuleVehiclesModuleWater;

public class PlastikosModuleTransportationModuleVehicles implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosModuleTransportationModuleVehiclesModuleLand LAND;
    public final PlastikosModuleTransportationModuleVehiclesModuleWater WATER;
    public final PlastikosModuleTransportationModuleVehiclesModuleAir AIR;
    public final PlastikosModuleTransportationModuleVehiclesModuleRockets ROCKETS;

    public final PlastikosTransportationVehiclesBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehicles(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.LAND = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleLand(this));
        this.WATER = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleWater(this));
        this.AIR = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleAir(this));
        this.ROCKETS = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleRockets(this));

        this.BLOCKS = new PlastikosTransportationVehiclesBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_VEHICLES;
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
