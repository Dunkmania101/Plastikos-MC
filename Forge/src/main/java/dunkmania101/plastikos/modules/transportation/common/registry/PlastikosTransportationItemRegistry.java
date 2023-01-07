package dunkmania101.plastikos.modules.transportation.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosTransportationItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosTransportationItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    // BlockItems {
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> TRAFFIC_CONE;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> PALLET;
    // }

    @Override
    public void mainRegisterObjects() {
        this.TRAFFIC_CONE = this.registerObject("traffic_cone", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.TRANSPORTATION.BLOCKS.TRAFFIC_CONE.getValue().get(), getBaseProperties()));
        this.PALLET = this.registerObject("pallet", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.TRANSPORTATION.BLOCKS.PALLET.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.TRAFFIC_CONE.getKey());
    }
}
