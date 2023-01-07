package dunkmania101.plastikos.modules.base.modules.materials.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.base.objects.blocks.base.BasePlastikosBlock;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;

public class PlastikosBaseMaterialsBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosBaseMaterialsBlockRegistry(IPlastikosModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> CAST_IRON_BLOCK;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> STEEL_BLOCK;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRASS_BLOCK;
    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> BRONZE_BLOCK;

    public Entry<ResourceLocation, Supplier<BasePlastikosBlock>> ARAMID_SHEET;

    @Override
    public void mainRegisterObjects() {
        this.CAST_IRON_BLOCK = this.registerObject("cast_iron_block", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.STEEL_BLOCK = this.registerObject("steel_block", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.BRASS_BLOCK = this.registerObject("brass_block", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));
        this.BRONZE_BLOCK = this.registerObject("bronze_block", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWood()));

        this.ARAMID_SHEET = this.registerObject("aramid_sheet", () -> new BasePlastikosBlock(getParentModule(), getBasePropertiesWool().explosionResistance(1000)));
    }
}
