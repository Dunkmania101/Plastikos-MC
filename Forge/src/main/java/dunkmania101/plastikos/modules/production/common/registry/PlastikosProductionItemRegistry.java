package dunkmania101.plastikos.modules.production.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosProductionItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosProductionItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> METAL_REINFORCED_FURNACE;

    @Override
    public void mainRegisterObjects() {
        this.METAL_REINFORCED_FURNACE = this.registerObject("metal_reinforced_furnace", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.PRODUCTION.BLOCKS.METAL_REINFORCED_FURNACE.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.METAL_REINFORCED_FURNACE.getKey());
    }
}
