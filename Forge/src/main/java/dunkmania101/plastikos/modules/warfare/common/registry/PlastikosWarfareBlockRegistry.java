package dunkmania101.plastikos.modules.warfare.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosWarfareBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosWarfareBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Block>> KEVLAR_TARP;

    @Override
    public void registerObjects() {
        this.KEVLAR_TARP = this.registerObject("kevlar_tarp", () -> new Block(getBasePropertiesCloth().explosionResistance(1000)));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
