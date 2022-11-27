package dunkmania101.plastikos.modules.base.modules.materials.common.registry;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseItemRegistryHandler;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class PlastikosBaseMaterialsItemRegistry extends BaseItemRegistryHandler {
    public PlastikosBaseMaterialsItemRegistry(IModularModModule parent) {
        super(parent);
    }

    // Ingredients
    public ResourceLocation PLASTIC_POWDER;

    public ResourceLocation MODULATING_DUST;
    public ResourceLocation MODULATING_SHARD;
    public ResourceLocation MODULATING_CRYSTAL;

    // BlockItems
    public ResourceLocation WOODEN_FRAME;
    public ResourceLocation STONE_FRAME;
    public ResourceLocation IRON_FRAME;

    @Override
    public void registerObjects() {
        // Ingredients
        this.PLASTIC_POWDER = this.registerObject("plastic_powder", () -> new Item(getBaseProperties())).getKey();

        this.MODULATING_DUST = this.registerObject("modulating_dust", () -> new Item(getBaseProperties())).getKey();
        this.MODULATING_SHARD = this.registerObject("modulating_shard", () -> new Item(getBaseProperties())).getKey();
        this.MODULATING_CRYSTAL = this.registerObject("modulating_crystal", () -> new Item(getBaseProperties())).getKey();

        // BlockItems
        //this.WOODEN_FRAME = this.registerObject("wooden_frame", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.getEntries().get(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.WOODEN_FRAME).get(), getBaseProperties())).getKey();
        //this.STONE_FRAME = this.registerObject("stone_frame", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.getEntries().get(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.STONE_FRAME).get(), getBaseProperties())).getKey();
        //this.IRON_FRAME = this.registerObject("iron_frame", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.getEntries().get(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.IRON_FRAME).get(), getBaseProperties())).getKey();
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
