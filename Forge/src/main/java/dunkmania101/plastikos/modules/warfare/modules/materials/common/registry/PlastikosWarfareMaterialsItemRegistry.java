package dunkmania101.plastikos.modules.warfare.modules.materials.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;

public class PlastikosWarfareMaterialsItemRegistry extends BaseItemRegistryHandler {
    public PlastikosWarfareMaterialsItemRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BlockItem>> KEVLAR_SHEET;

    @Override
    public void registerObjects() {
        this.KEVLAR_SHEET = this.registerObject("kevlar_sheet", () -> new BlockItem(PlastikosMod.INSTANCE.WARFARE.MATERIALS.BLOCKS.KEVLAR_SHEET.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.KEVLAR_SHEET.getKey());
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
