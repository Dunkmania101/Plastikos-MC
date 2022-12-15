package dunkmania101.plastikos.modules.base.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosBlockItem;
import dunkmania101.plastikos.base.objects.items.base.BasePlastikosItem;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosItemRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosBaseItemRegistry extends BasePlastikosItemRegistryHandler {
    public PlastikosBaseItemRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosItem>> CAST_IRON_CROWBAR;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> CAST_IRON_NAIL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> STEEL_NAIL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRASS_NAIL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRONZE_NAIL;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> CAST_IRON_IBEAM;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> STEEL_IBEAM;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRASS_IBEAM;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRONZE_IBEAM;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> CAST_IRON_CCHANNEL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> STEEL_CCHANNEL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRASS_CCHANNEL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRONZE_CCHANNEL;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> CLOTH_FRAME_WRAP;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> WOODEN_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> STONE_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> IRON_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> CAST_IRON_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> STEEL_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRASS_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlockItem>> BRONZE_FRAME;

    @Override
    public void registerObjects() {
        // Tools
        this.CAST_IRON_CROWBAR = this.registerObject("cast_iron_crowbar", () -> new BasePlastikosItem(getParentModule(), getBaseProperties()));

        // BlockItems
        this.CAST_IRON_NAIL = this.registerObject("cast_iron_nail", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.CAST_IRON_NAIL.getValue().get(), getBaseProperties()));
        this.STEEL_NAIL = this.registerObject("steel_nail", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.STEEL_NAIL.getValue().get(), getBaseProperties()));
        this.BRASS_NAIL = this.registerObject("brass_nail", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRASS_NAIL.getValue().get(), getBaseProperties()));
        this.BRONZE_NAIL = this.registerObject("bronze_nail", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRONZE_NAIL.getValue().get(), getBaseProperties()));

        this.CAST_IRON_IBEAM = this.registerObject("cast_iron_ibeam", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.CAST_IRON_IBEAM.getValue().get(), getBaseProperties()));
        this.STEEL_IBEAM = this.registerObject("steel_ibeam", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.STEEL_IBEAM.getValue().get(), getBaseProperties()));
        this.BRASS_IBEAM = this.registerObject("brass_ibeam", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRASS_IBEAM.getValue().get(), getBaseProperties()));
        this.BRONZE_IBEAM = this.registerObject("bronze_ibeam", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRONZE_IBEAM.getValue().get(), getBaseProperties()));

        this.CAST_IRON_CCHANNEL = this.registerObject("cast_iron_cchannel", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.CAST_IRON_CCHANNEL.getValue().get(), getBaseProperties()));
        this.STEEL_CCHANNEL = this.registerObject("steel_cchannel", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.STEEL_CCHANNEL.getValue().get(), getBaseProperties()));
        this.BRASS_CCHANNEL = this.registerObject("brass_cchannel", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRASS_CCHANNEL.getValue().get(), getBaseProperties()));
        this.BRONZE_CCHANNEL = this.registerObject("bronze_cchannel", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRONZE_CCHANNEL.getValue().get(), getBaseProperties()));

        this.CLOTH_FRAME_WRAP = this.registerObject("cloth_frame_wrap", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.CLOTH_FRAME_WRAP.getValue().get(), getBaseProperties()));
        this.WOODEN_FRAME = this.registerObject("wooden_frame", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.WOODEN_FRAME.getValue().get(), getBaseProperties()));
        this.STONE_FRAME = this.registerObject("stone_frame", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.STONE_FRAME.getValue().get(), getBaseProperties()));
        this.IRON_FRAME = this.registerObject("iron_frame", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.IRON_FRAME.getValue().get(), getBaseProperties()));
        this.CAST_IRON_FRAME = this.registerObject("cast_iron_frame", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.CAST_IRON_FRAME.getValue().get(), getBaseProperties()));
        this.STEEL_FRAME = this.registerObject("steel_frame", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.STEEL_FRAME.getValue().get(), getBaseProperties()));
        this.BRASS_FRAME = this.registerObject("brass_frame", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRASS_FRAME.getValue().get(), getBaseProperties()));
        this.BRONZE_FRAME = this.registerObject("bronze_frame", () -> new BasePlastikosBlockItem(getParentModule(), PlastikosMod.INSTANCE.BASE.BLOCKS.BRONZE_FRAME.getValue().get(), getBaseProperties()));

        // Tab
        setTabIconId(this.CAST_IRON_NAIL.getKey());
    }
}
