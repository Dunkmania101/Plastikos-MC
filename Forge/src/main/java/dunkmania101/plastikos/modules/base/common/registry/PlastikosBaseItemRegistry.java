package dunkmania101.plastikos.modules.base.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class PlastikosBaseItemRegistry extends BaseItemRegistryHandler {
    public PlastikosBaseItemRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Item>> CAST_IRON_CROWBAR;

    public Entry<ResourceLocation, Supplier<BlockItem>> CAST_IRON_NAIL;

    @Override
    public void registerObjects() {
        // Tools
        this.CAST_IRON_CROWBAR = this.registerObject("cast_iron_crowbar", () -> new Item(getBaseProperties()));

        // BlockItems
        this.CAST_IRON_NAIL = this.registerObject("cast_iron_nail", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.BLOCKS.CAST_IRON_NAIL.getValue().get(), getBaseProperties()));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }

    @Override
    public ResourceLocation getTabIconId() {
        return this.CAST_IRON_CROWBAR.getKey();
    }
}
