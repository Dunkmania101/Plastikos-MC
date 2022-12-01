package dunkmania101.plastikos.modules.transportation.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosTransportationBlockRegistry extends BaseBlockRegistryHandler {
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

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
