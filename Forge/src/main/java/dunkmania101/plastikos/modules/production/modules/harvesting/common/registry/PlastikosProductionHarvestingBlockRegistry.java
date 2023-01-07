package dunkmania101.plastikos.modules.production.modules.harvesting.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosProductionHarvestingBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosProductionHarvestingBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> COMBINE_BLADE;

    @Override
    public void mainRegisterObjects() {
        this.COMBINE_BLADE = this.registerObject("combine_blade", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
