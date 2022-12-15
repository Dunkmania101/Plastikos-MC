package dunkmania101.plastikos.modules.logistics.modules.storage.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosLogisticsStorageItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosLogisticsStorageItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> SHIPPING_CONTAINER_DOOR;

    @Override
    public void registerObjects() {
        this.SHIPPING_CONTAINER_DOOR = this.registerObject("shipping_container_door", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.LOGISTICS.STORAGE.BLOCKS.SHIPPING_CONTAINER_DOOR.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.SHIPPING_CONTAINER_DOOR.getKey());
    }
}
