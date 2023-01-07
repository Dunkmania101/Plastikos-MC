package dunkmania101.plastikos.modules.mobs.modules.monsters.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosMobsMonstersItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosMobsMonstersItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> GRIZZLY_SPAWNER;

    @Override
    public void mainRegisterObjects() {
        // BlockItems
        this.GRIZZLY_SPAWNER = this.registerObject("grizzly_spawner", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.MOBS.MONSTERS.BLOCKS.GRIZZLY_SPAWNER.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.GRIZZLY_SPAWNER.getKey());
    }
}
