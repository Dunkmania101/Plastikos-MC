package dunkmania101.plastikos.modules.control.modules.terminals.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosControlTerminalsItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosControlTerminalsItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> TERMINAL_DOCK;

    @Override
    public void registerObjects() {
        // BlockItems
        this.TERMINAL_DOCK = this.registerObject("terminal_dock", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.CONTROL.TERMINALS.BLOCKS.TERMINAL_DOCK.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.TERMINAL_DOCK.getKey());
    }
}
