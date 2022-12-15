package dunkmania101.plastikos.modules.control.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosControlItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosControlItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> WIRELESS_ANTENNA;

    @Override
    public void registerObjects() {
        // BlockItems
        this.WIRELESS_ANTENNA = this.registerObject("wireless_antenna", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.CONTROL.BLOCKS.WIRELESS_ANTENNA.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.WIRELESS_ANTENNA.getKey());
    }
}
