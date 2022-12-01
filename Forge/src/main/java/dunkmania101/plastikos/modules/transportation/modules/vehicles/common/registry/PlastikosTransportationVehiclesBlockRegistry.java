package dunkmania101.plastikos.modules.transportation.modules.vehicles.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosTransportationVehiclesBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosTransportationVehiclesBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    // Wheels {
    // Cores {
    public Entry<ResourceLocation, Supplier<Block>> SMALL_WHEEL_CORE;
    public Entry<ResourceLocation, Supplier<Block>> WHEEL_CORE;
    public Entry<ResourceLocation, Supplier<Block>> LARGE_WHEEL_CORE;
    // }
    // Tires {
    public Entry<ResourceLocation, Supplier<Block>> SMALL_WHEEL_TIRE;
    public Entry<ResourceLocation, Supplier<Block>> WHEEL_TIRE;
    public Entry<ResourceLocation, Supplier<Block>> LARGE_WHEEL_TIRE;
    // }}

    @Override
    public void registerObjects() {
        this.SMALL_WHEEL_CORE = this.registerObject("small_wheel_core", () -> new Block(getBasePropertiesWood()));
        this.WHEEL_CORE = this.registerObject("wheel_core", () -> new Block(getBasePropertiesWood()));
        this.LARGE_WHEEL_CORE = this.registerObject("large_wheel_core", () -> new Block(getBasePropertiesWood()));

        this.SMALL_WHEEL_TIRE = this.registerObject("small_wheel_tire", () -> new Block(getBasePropertiesWood()));
        this.WHEEL_TIRE = this.registerObject("wheel_tire", () -> new Block(getBasePropertiesWood()));
        this.LARGE_WHEEL_TIRE = this.registerObject("large_wheel_tire", () -> new Block(getBasePropertiesWood()));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
