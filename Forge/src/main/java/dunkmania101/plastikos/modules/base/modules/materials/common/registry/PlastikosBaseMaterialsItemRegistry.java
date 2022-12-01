package dunkmania101.plastikos.modules.base.modules.materials.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

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
    public Entry<ResourceLocation, Supplier<Item>> PLASTIC_POWDER;

    public Entry<ResourceLocation, Supplier<Item>> MODULATING_DUST;
    public Entry<ResourceLocation, Supplier<Item>> MODULATING_SHARD;
    public Entry<ResourceLocation, Supplier<Item>> MODULATING_CRYSTAL;

    // BlockItems
    public Entry<ResourceLocation, Supplier<BlockItem>> WOODEN_FRAME;
    public Entry<ResourceLocation, Supplier<BlockItem>> STONE_FRAME;
    public Entry<ResourceLocation, Supplier<BlockItem>> IRON_FRAME;

    @Override
    public void registerObjects() {
        // Ingredients
        this.PLASTIC_POWDER = this.registerObject("plastic_powder", () -> new Item(getBaseProperties()));

        this.MODULATING_DUST = this.registerObject("modulating_dust", () -> new Item(getBaseProperties()));
        this.MODULATING_SHARD = this.registerObject("modulating_shard", () -> new Item(getBaseProperties()));
        this.MODULATING_CRYSTAL = this.registerObject("modulating_crystal", () -> new Item(getBaseProperties()));

        // BlockItems
        this.WOODEN_FRAME = this.registerObject("wooden_frame", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.WOODEN_FRAME.getValue().get(), getBaseProperties()));
        this.STONE_FRAME = this.registerObject("stone_frame", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.STONE_FRAME.getValue().get(), getBaseProperties()));
        this.IRON_FRAME = this.registerObject("iron_frame", () -> new BlockItem(PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.IRON_FRAME.getValue().get(), getBaseProperties()));
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }

    @Override
    public ResourceLocation getTabIconId() {
        return this.PLASTIC_POWDER.getKey();
    }
}
