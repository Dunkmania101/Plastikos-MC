package dunkmania101.plastikos.modules.warfare.modules.materials.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosWarfareMaterialsBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosWarfareMaterialsBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Block>> KEVLAR_SHEET;

    @Override
    public void registerObjects() {
        this.KEVLAR_SHEET = this.registerObject("kevlar_sheet", () -> new Block(getBasePropertiesCloth().explosionResistance(1000)));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
