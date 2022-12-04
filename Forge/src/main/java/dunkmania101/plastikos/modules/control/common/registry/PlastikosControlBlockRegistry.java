package dunkmania101.plastikos.modules.control.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosControlBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosControlBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Block>> WIRELESS_ANTENNA;

    @Override
    public void registerObjects() {
        this.WIRELESS_ANTENNA = this.registerObject("wireless_antenna", () -> new Block(getBasePropertiesMetal()));
    }
}
