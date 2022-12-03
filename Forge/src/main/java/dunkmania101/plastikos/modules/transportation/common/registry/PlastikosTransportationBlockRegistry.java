package dunkmania101.plastikos.modules.transportation.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosTransportationBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosTransportationBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    // Misc {
    public Entry<ResourceLocation, Supplier<Block>> TRAFFIC_CONE;
    // }

    @Override
    public void registerObjects() {
        this.TRAFFIC_CONE = this.registerObject("traffic_cone", () -> new Block(getBasePropertiesWood()));
    }
}
