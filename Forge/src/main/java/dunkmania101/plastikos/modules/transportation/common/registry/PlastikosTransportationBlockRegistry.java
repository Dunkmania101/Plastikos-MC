package dunkmania101.plastikos.modules.transportation.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import dunkmania101.plastikos.modules.transportation.common.objects.blocks.PalletBlock;
import net.minecraft.resources.ResourceLocation;

public class PlastikosTransportationBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosTransportationBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    // Misc {
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> TRAFFIC_CONE;
    public Entry<ResourceLocation, Supplier<PalletBlock>> PALLET;
    // }

    @Override
    public void mainRegisterObjects() {
        this.TRAFFIC_CONE = this.registerObject("traffic_cone", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.PALLET = this.registerObject("pallet", () -> new PalletBlock(getParentModule(), getBasePropertiesWood()));
    }
}
