package dunkmania101.plastikos.modules.logistics.modules.storage.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosLogisticsStorageBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosLogisticsStorageBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> SHIPPING_CONTAINER_DOOR;

    @Override
    public void registerObjects() {
        this.SHIPPING_CONTAINER_DOOR = this.registerObject("shipping_container_door", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
