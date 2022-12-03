package dunkmania101.plastikos.modules.transportation.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;

public class PlastikosTransportationItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosTransportationItemRegistry(IModularModModule parent) {
        super(parent);
    }

    // BlockItems {
    public Entry<ResourceLocation, Supplier<BlockItem>> TRAFFIC_CONE;
    // }

    @Override
    public void registerObjects() {
        this.TRAFFIC_CONE = this.registerObject("traffic_cone", () -> new BlockItem(PlastikosMod.INSTANCE.TRANSPORTATION.BLOCKS.TRAFFIC_CONE.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.TRAFFIC_CONE.getKey());
    }
}
