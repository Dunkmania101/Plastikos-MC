package dunkmania101.plastikos.modules.transportation;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.transportation.common.registry.PlastikosTransportationBlockRegistry;
import dunkmania101.plastikos.modules.transportation.common.registry.PlastikosTransportationItemRegistry;
import dunkmania101.plastikos.modules.transportation.modules.vehicles.PlastikosModuleTransportationModuleVehicles;

public class PlastikosModuleTransportation implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosModuleTransportationModuleVehicles VEHICLES;

    public final PlastikosTransportationBlockRegistry BLOCKS;
    public final PlastikosTransportationItemRegistry ITEMS;

    public PlastikosModuleTransportation(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.VEHICLES = registerChild(new PlastikosModuleTransportationModuleVehicles(this));

        this.BLOCKS = new PlastikosTransportationBlockRegistry(this);
        this.ITEMS = new PlastikosTransportationItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_TRANSPORTATION;
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
