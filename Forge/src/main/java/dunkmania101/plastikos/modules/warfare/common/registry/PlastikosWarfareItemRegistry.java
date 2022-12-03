package dunkmania101.plastikos.modules.warfare.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;

public class PlastikosWarfareItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosWarfareItemRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BlockItem>> KEVLAR_TARP;

    @Override
    public void registerObjects() {
        this.KEVLAR_TARP = this.registerObject("kevlar_tarp", () -> new BlockItem(PlastikosMod.INSTANCE.WARFARE.BLOCKS.KEVLAR_TARP.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.KEVLAR_TARP.getKey());
    }
}
