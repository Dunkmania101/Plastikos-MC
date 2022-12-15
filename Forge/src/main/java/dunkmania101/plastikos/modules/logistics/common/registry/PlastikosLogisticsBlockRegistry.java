package dunkmania101.plastikos.modules.logistics.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosLogisticsBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosLogisticsBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> ARAMID_BELT;

    @Override
    public void registerObjects() {
        this.ARAMID_BELT = this.registerObject("aramid_belt", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
