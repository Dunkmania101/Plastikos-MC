package dunkmania101.plastikos.modules.base.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosBaseBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosBaseBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Block>> CAST_IRON_NAIL;

    @Override
    public void registerObjects() {
        this.CAST_IRON_NAIL = this.registerObject("cast_iron_nail", () -> new Block(getBasePropertiesMetal()));
    }
}
