package dunkmania101.plastikos.modules.transportation;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.common.registry.PlastikosTransportationBlockRegistry;
import dunkmania101.plastikos.modules.transportation.common.registry.PlastikosTransportationItemRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.PlastikosModuleTransportationModuleVehicles;

public class PlastikosModuleTransportation extends BasePlastikosModule {
    public final PlastikosModuleTransportationModuleVehicles VEHICLES;

    public final PlastikosTransportationBlockRegistry BLOCKS;
    public final PlastikosTransportationItemRegistry ITEMS;

    public PlastikosModuleTransportation(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosTransportationBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationItemRegistry(this);

        this.VEHICLES = registerChild(new PlastikosModuleTransportationModuleVehicles(this));
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_TRANSPORTATION;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
