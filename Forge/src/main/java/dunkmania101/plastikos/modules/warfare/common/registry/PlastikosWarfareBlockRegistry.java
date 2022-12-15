package dunkmania101.plastikos.modules.warfare.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosWarfareBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosWarfareBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> ARAMID_TARP;

    @Override
    public void registerObjects() {
        this.ARAMID_TARP = this.registerObject("aramid_tarp", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWool().explosionResistance(1000)));
    }
}
