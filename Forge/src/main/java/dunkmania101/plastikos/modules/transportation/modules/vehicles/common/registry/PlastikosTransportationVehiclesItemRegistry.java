package dunkmania101.plastikos.modules.transportation.modules.vehicles.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;

public class PlastikosTransportationVehiclesItemRegistry extends BaseItemRegistryHandler {
    public PlastikosTransportationVehiclesItemRegistry(IModularModModule parent) {
        super(parent);
    }

    // BlockItems {
    public Entry<ResourceLocation, Supplier<BlockItem>> SMALL_WHEEL_CORE;
    public Entry<ResourceLocation, Supplier<BlockItem>> WHEEL_CORE;
    public Entry<ResourceLocation, Supplier<BlockItem>> LARGE_WHEEL_CORE;

    public Entry<ResourceLocation, Supplier<BlockItem>> SMALL_WHEEL_TIRE;
    public Entry<ResourceLocation, Supplier<BlockItem>> WHEEL_TIRE;
    public Entry<ResourceLocation, Supplier<BlockItem>> LARGE_WHEEL_TIRE;
    // }

    @Override
    public void registerObjects() {
        this.SMALL_WHEEL_CORE = this.registerObject("small_wheel_core", () -> new BlockItem(PlastikosMod.INSTANCE.TRANSPORTATION.VEHICLES.BLOCKS.SMALL_WHEEL_CORE.getValue().get(), getBaseProperties()));
        this.WHEEL_CORE = this.registerObject("wheel_core", () -> new BlockItem(PlastikosMod.INSTANCE.TRANSPORTATION.VEHICLES.BLOCKS.WHEEL_CORE.getValue().get(), getBaseProperties()));
        this.LARGE_WHEEL_CORE = this.registerObject("large_wheel_core", () -> new BlockItem(PlastikosMod.INSTANCE.TRANSPORTATION.VEHICLES.BLOCKS.LARGE_WHEEL_CORE.getValue().get(), getBaseProperties()));

        this.SMALL_WHEEL_TIRE = this.registerObject("small_wheel_tire", () -> new BlockItem(PlastikosMod.INSTANCE.TRANSPORTATION.VEHICLES.BLOCKS.SMALL_WHEEL_TIRE.getValue().get(), getBaseProperties()));
        this.WHEEL_TIRE = this.registerObject("wheel_tire", () -> new BlockItem(PlastikosMod.INSTANCE.TRANSPORTATION.VEHICLES.BLOCKS.WHEEL_TIRE.getValue().get(), getBaseProperties()));
        this.LARGE_WHEEL_TIRE = this.registerObject("large_wheel_tire", () -> new BlockItem(PlastikosMod.INSTANCE.TRANSPORTATION.VEHICLES.BLOCKS.LARGE_WHEEL_TIRE.getValue().get(), getBaseProperties()));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }

    @Override
    public ResourceLocation getTabIconId() {
        return this.LARGE_WHEEL_TIRE.getKey();
    }
}