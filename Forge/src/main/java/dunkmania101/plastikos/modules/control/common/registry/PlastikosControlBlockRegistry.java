package dunkmania101.plastikos.modules.control.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosControlBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosControlBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> WIRELESS_ANTENNA;

    @Override
    public void mainRegisterObjects() {
        this.WIRELESS_ANTENNA = this.registerObject("wireless_antenna", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
