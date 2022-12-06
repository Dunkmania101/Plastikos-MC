package dunkmania101.plastikos.modules.mobs.modules.wildlife.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosMobsWildlifeBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosMobsWildlifeBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> LIVING_BLOOM;

    @Override
    public void registerObjects() {
        this.LIVING_BLOOM = this.registerObject("living_bloom", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
    }
}
