package dunkmania101.plastikos.modules.mobs.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosMobsItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosMobsItemRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> FIELD_NET;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> MOUSETRAP;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> ANIMAL_CAGE;

    @Override
    public void registerObjects() {
        // Tools
        this.FIELD_NET = this.registerObject("field_net", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));

        // BlockItems
        this.MOUSETRAP = this.registerObject("mousetrap", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.MOBS.BLOCKS.MOUSETRAP.getValue().get(), getBaseProperties()));
        this.ANIMAL_CAGE = this.registerObject("animal_cage", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.MOBS.BLOCKS.ANIMAL_CAGE.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.FIELD_NET.getKey());
    }
}
