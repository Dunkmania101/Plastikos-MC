package dunkmania101.plastikos.modules.base.common.registry;

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

    public ResourceLocation CAST_IRON_CROWBAR;

    public ResourceLocation BIG_CAST_IRON_NAIL;

    @Override
    public void registerObjects() {
        // Tools
        this.CAST_IRON_CROWBAR = this.registerObject("crowbar", () -> new Item(getBaseProperties())).getKey();

        // BlockItems
        this.BIG_CAST_IRON_NAIL = this.registerObject("big_cast_iron_nail", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.BLOCKS.getEntries().get(PlastikosMod.INSTANCE.BASE.BLOCKS.BIG_CAST_IRON_NAIL).get(), getBaseProperties())).getKey();
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
