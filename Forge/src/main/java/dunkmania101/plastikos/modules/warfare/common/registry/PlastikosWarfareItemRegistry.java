package dunkmania101.plastikos.modules.warfare.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosWarfareItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosWarfareItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> ARAMID_TARP;

    @Override
    public void mainRegisterObjects() {
        this.ARAMID_TARP = this.registerObject("aramid_tarp", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.WARFARE.BLOCKS.ARAMID_TARP.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.ARAMID_TARP.getKey());
    }
}
