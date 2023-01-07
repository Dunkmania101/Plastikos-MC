package dunkmania101.plastikos.modules.mobs.modules.wildlife.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosMobsWildlifeItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosMobsWildlifeItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> LIVING_BLOOM;

    @Override
    public void mainRegisterObjects() {
        // BlockItems
        this.LIVING_BLOOM = this.registerObject("grizzly_spawner", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.MOBS.WILDLIFE.BLOCKS.LIVING_BLOOM.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.LIVING_BLOOM.getKey());
    }
}
