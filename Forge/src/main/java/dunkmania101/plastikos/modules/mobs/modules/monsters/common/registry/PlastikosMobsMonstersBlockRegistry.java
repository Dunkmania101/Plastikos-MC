package dunkmania101.plastikos.modules.mobs.modules.monsters.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosMobsMonstersBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosMobsMonstersBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> GRIZZLY_SPAWNER;

    @Override
    public void mainRegisterObjects() {
        this.GRIZZLY_SPAWNER = this.registerObject("grizzly_spawner", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
