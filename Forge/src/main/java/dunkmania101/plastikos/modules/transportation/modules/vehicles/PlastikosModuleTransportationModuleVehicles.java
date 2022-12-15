package dunkmania101.plastikos.modules.transportation.modules.vehicles;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.common.registry.PlastikosTransportationVehiclesBlockRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.common.registry.PlastikosTransportationVehiclesItemRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.air.PlastikosModuleTransportationModuleVehiclesModuleAir;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.land.PlastikosModuleTransportationModuleVehiclesModuleLand;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.rockets.PlastikosModuleTransportationModuleVehiclesModuleRockets;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.modules.water.PlastikosModuleTransportationModuleVehiclesModuleWater;

public class PlastikosModuleTransportationModuleVehicles extends BasePlastikosModule {
    public final PlastikosModuleTransportationModuleVehiclesModuleLand LAND;
    public final PlastikosModuleTransportationModuleVehiclesModuleWater WATER;
    public final PlastikosModuleTransportationModuleVehiclesModuleAir AIR;
    public final PlastikosModuleTransportationModuleVehiclesModuleRockets ROCKETS;

    public final PlastikosTransportationVehiclesBlockRegistry BLOCKS;
    public final PlastikosTransportationVehiclesItemRegistry ITEMS;

    public PlastikosModuleTransportationModuleVehicles(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosTransportationVehiclesBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationVehiclesItemRegistry(this);

        this.LAND = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleLand(this));

        this.WATER = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleWater(this));
        this.AIR = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleAir(this));
        this.ROCKETS = registerChild(new PlastikosModuleTransportationModuleVehiclesModuleRockets(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_VEHICLES;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
