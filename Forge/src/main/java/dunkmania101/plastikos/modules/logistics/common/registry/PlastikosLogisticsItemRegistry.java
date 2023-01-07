package dunkmania101.plastikos.modules.logistics.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosLogisticsItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosLogisticsItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> ARAMID_BELT;

    @Override
    public void mainRegisterObjects() {
        this.ARAMID_BELT = this.registerObject("aramid_belt", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.LOGISTICS.BLOCKS.ARAMID_BELT.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.ARAMID_BELT.getKey());
    }
}
