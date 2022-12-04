package dunkmania101.plastikos.modules.control.modules.terminals.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosControlTerminalsBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosControlTerminalsBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Block>> TERMINAL_DOCK;

    @Override
    public void registerObjects() {
        this.TERMINAL_DOCK = this.registerObject("terminal_dock", () -> new Block(getBasePropertiesMetal()));
    }
}
