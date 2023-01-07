package dunkmania101.plastikos.modules.mobs.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosMobsBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosMobsBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> MOUSETRAP;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> ANIMAL_CAGE;

    @Override
    public void mainRegisterObjects() {
        this.MOUSETRAP = this.registerObject("mousetrap", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.ANIMAL_CAGE = this.registerObject("animal_cage", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
