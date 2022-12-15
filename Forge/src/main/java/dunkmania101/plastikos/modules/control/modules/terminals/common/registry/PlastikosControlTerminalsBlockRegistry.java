package dunkmania101.plastikos.modules.control.modules.terminals.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosControlTerminalsBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosControlTerminalsBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> TERMINAL_DOCK;

    @Override
    public void registerObjects() {
        this.TERMINAL_DOCK = this.registerObject("terminal_dock", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
