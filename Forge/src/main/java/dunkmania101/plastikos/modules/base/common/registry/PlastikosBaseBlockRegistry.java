package dunkmania101.plastikos.modules.base.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosBaseBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosBaseBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Block>> BIG_CAST_IRON_NAIL;

    @Override
    public void registerObjects() {
        this.BIG_CAST_IRON_NAIL = this.registerObject("big_cast_iron_nail", () -> new Block(getBasePropertiesMetal()));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
