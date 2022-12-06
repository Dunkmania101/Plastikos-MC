package dunkmania101.plastikos.modules.base.modules.materials.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosBaseMaterialsItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosBaseMaterialsItemRegistry(IModularModModule parent) {
        super(parent);
    }

    // Ingredients
    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> PLASTIC_POWDER;
    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> PLASTIC_PELLETS;

    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> CAST_IRON_INGOT;
    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> STEEL_INGOT;
    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> BRASS_INGOT;
    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> BRONZE_INGOT;

    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> SPATIAL_DUST;
    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> SPATIAL_SHARD;
    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> SPATIAL_CRYSTAL;

    // BlockItems
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> CAST_IRON_BLOCK;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> STEEL_BLOCK;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRASS_BLOCK;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRONZE_BLOCK;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> ARAMID_SHEET;

    @Override
    public void registerObjects() {
        // Ingredients
        this.PLASTIC_POWDER = this.registerObject("plastic_powder", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));
        this.PLASTIC_PELLETS = this.registerObject("plastic_pellets", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));

        this.CAST_IRON_INGOT = this.registerObject("cast_iron_ingot", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));
        this.STEEL_INGOT = this.registerObject("steel_ingot", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));
        this.BRASS_INGOT = this.registerObject("brass_ingot", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));
        this.BRONZE_INGOT = this.registerObject("bronze_ingot", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));

        this.SPATIAL_DUST = this.registerObject("spatial_dust", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));
        this.SPATIAL_SHARD = this.registerObject("spatial_shard", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));
        this.SPATIAL_CRYSTAL = this.registerObject("spatial_crystal", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));

        // BlockItems
        this.CAST_IRON_BLOCK = this.registerObject("cast_iron_block", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.CAST_IRON_BLOCK.getValue().get(), getBaseProperties()));
        this.STEEL_BLOCK = this.registerObject("steel_block", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.STEEL_BLOCK.getValue().get(), getBaseProperties()));
        this.BRASS_BLOCK = this.registerObject("brass_block", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.BRASS_BLOCK.getValue().get(), getBaseProperties()));
        this.BRONZE_BLOCK = this.registerObject("bronze_block", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.BRONZE_BLOCK.getValue().get(), getBaseProperties()));

        this.ARAMID_SHEET = this.registerObject("aramid_sheet", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.MATERIALS.BLOCKS.ARAMID_SHEET.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.PLASTIC_PELLETS.getKey());
    }
}
