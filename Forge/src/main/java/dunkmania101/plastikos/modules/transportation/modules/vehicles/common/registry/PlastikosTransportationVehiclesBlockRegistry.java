package dunkmania101.plastikos.modules.transportation.modules.vehicles.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosTransportationVehiclesBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosTransportationVehiclesBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    // Wheels {
    // Cores {
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> SMALL_WHEEL_CORE;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> WHEEL_CORE;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> LARGE_WHEEL_CORE;
    // }
    // Tires {
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> SMALL_WHEEL_TIRE;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> WHEEL_TIRE;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> LARGE_WHEEL_TIRE;
    // }}

    @Override
    public void mainRegisterObjects() {
        this.SMALL_WHEEL_CORE = this.registerObject("small_wheel_core", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.WHEEL_CORE = this.registerObject("wheel_core", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.LARGE_WHEEL_CORE = this.registerObject("large_wheel_core", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));

        this.SMALL_WHEEL_TIRE = this.registerObject("small_wheel_tire", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.WHEEL_TIRE = this.registerObject("wheel_tire", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.LARGE_WHEEL_TIRE = this.registerObject("large_wheel_tire", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
    }
}
