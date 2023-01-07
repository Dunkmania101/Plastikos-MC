package dunkmania101.plastikos.modules.base.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosBaseBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosBaseBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> CAST_IRON_NAIL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> STEEL_NAIL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRASS_NAIL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRONZE_NAIL;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> CAST_IRON_IBEAM;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> STEEL_IBEAM;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRASS_IBEAM;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRONZE_IBEAM;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> CAST_IRON_CCHANNEL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> STEEL_CCHANNEL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRASS_CCHANNEL;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRONZE_CCHANNEL;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> CLOTH_FRAME_WRAP;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> WOODEN_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> STONE_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> IRON_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> CAST_IRON_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> STEEL_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRASS_FRAME;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRONZE_FRAME;

    @Override
    public void mainRegisterObjects() {
        this.CAST_IRON_NAIL = this.registerObject("cast_iron_nail", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.STEEL_NAIL = this.registerObject("steel_nail", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.BRASS_NAIL = this.registerObject("brass_nail", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.BRONZE_NAIL = this.registerObject("bronze_nail", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));

        this.CAST_IRON_IBEAM = this.registerObject("cast_iron_ibeam", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.STEEL_IBEAM = this.registerObject("steel_ibeam", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.BRASS_IBEAM = this.registerObject("brass_ibeam", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.BRONZE_IBEAM = this.registerObject("bronze_ibeam", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));

        this.CAST_IRON_CCHANNEL = this.registerObject("cast_iron_cchannel", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.STEEL_CCHANNEL = this.registerObject("steel_cchannel", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.BRASS_CCHANNEL = this.registerObject("brass_cchannel", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.BRONZE_CCHANNEL = this.registerObject("bronze_cchannel", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));

        this.CLOTH_FRAME_WRAP = this.registerObject("cloth_frame_wrap", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.WOODEN_FRAME = this.registerObject("wooden_frame", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.STONE_FRAME = this.registerObject("stone_frame", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesStone()));
        this.IRON_FRAME = this.registerObject("iron_frame", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.CAST_IRON_FRAME = this.registerObject("cast_iron_frame", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.STEEL_FRAME = this.registerObject("steel_frame", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.BRASS_FRAME = this.registerObject("brass_frame", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
        this.BRONZE_FRAME = this.registerObject("bronze_frame", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesMetal()));
    }
}
