package dunkmania101.plastikos.modules.production.modules.harvesting.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosProductionHarvestingItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosProductionHarvestingItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> COMBINE_BLADE;

    @Override
    public void registerObjects() {
        this.COMBINE_BLADE = this.registerObject("combine_blade", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.PRODUCTION.HARVESTING.BLOCKS.COMBINE_BLADE.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.COMBINE_BLADE.getKey());
    }
}
