package dunkmania101.plastikos.modules.base.modules.materials.common.registry;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.base.registry.impl.BasePlastikosBlockRegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosBaseMaterialsBlockRegistry extends BasePlastikosBlockRegistryHandler {
    public PlastikosBaseMaterialsBlockRegistry(IModularModModule parent) {
        super(parent);
    }

    public Entry<ResourceLocation, Supplier<Block>> CLOTH_FRAME_WRAP;
    public Entry<ResourceLocation, Supplier<Block>> WOODEN_FRAME;
    public Entry<ResourceLocation, Supplier<Block>> STONE_FRAME;
    public Entry<ResourceLocation, Supplier<Block>> IRON_FRAME;

    @Override
    public void registerObjects() {
        this.CLOTH_FRAME_WRAP = this.registerObject("cloth_frame_wrap", () -> new Block(getBasePropertiesWood()));
        this.WOODEN_FRAME = this.registerObject("wooden_frame", () -> new Block(getBasePropertiesWood()));
        this.STONE_FRAME = this.registerObject("stone_frame", () -> new Block(getBasePropertiesStone()));
        this.IRON_FRAME = this.registerObject("iron_frame", () -> new Block(getBasePropertiesMetal()));
    }
}
