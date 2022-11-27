package dunkmania101.plastikos.modules.base.common.registry;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class PlastikosBaseItemRegistry extends BaseItemRegistryHandler {
    public PlastikosBaseItemRegistry(IModularModModule parent) {
        super(parent);
    }

    public ResourceLocation PLASTIC_POWDER;

    public ResourceLocation MODULATING_DUST;
    public ResourceLocation MODULATING_SHARD;
    public ResourceLocation MODULATING_CRYSTAL;

    @Override
    public void registerObjects() {
        this.PLASTIC_POWDER = this.registerObject("plastic_powder", () -> new Item(getBaseProperties())).getKey();

        this.MODULATING_DUST = this.registerObject("modulating_dust", () -> new Item(getBaseProperties())).getKey();
        this.MODULATING_SHARD = this.registerObject("modulating_shard", () -> new Item(getBaseProperties())).getKey();
        this.MODULATING_CRYSTAL = this.registerObject("modulating_crystal", () -> new Item(getBaseProperties())).getKey();
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }

    @Override
    public String getModuleId() {
        return PlastikosConstants.MODULEID_BASE;
    }
}
