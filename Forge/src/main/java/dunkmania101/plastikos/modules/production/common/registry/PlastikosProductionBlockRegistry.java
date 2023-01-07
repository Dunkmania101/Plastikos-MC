package dunkmania101.plastikos.modules.production.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosProductionBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosProductionBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> METAL_REINFORCED_FURNACE;

    @Override
    public void mainRegisterObjects() {
        this.METAL_REINFORCED_FURNACE = this.registerObject("metal_reinforced_furnace", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
