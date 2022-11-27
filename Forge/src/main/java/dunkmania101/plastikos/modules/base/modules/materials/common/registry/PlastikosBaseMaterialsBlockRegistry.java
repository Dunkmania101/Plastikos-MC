package dunkmania101.plastikos.modules.base.modules.materials.common.registry;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosBaseMaterialsBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosBaseMaterialsBlockRegistry(IModularModModule parent) {
        super(parent, parent.getRegistryAcceptorOfId(Registry.BLOCK_REGISTRY.location()));
    }

    public ResourceLocation WOODEN_FRAME;
    public ResourceLocation STONE_FRAME;
    public ResourceLocation IRON_FRAME;

    @Override
    public void registerObjects() {
        this.WOODEN_FRAME = this.registerObject("wooden_frame", () -> new Block(getBasePropertiesWood())).getKey();
        this.STONE_FRAME = this.registerObject("stone_frame", () -> new Block(getBasePropertiesStone())).getKey();
        this.IRON_FRAME = this.registerObject("iron_frame", () -> new Block(getBasePropertiesMetal())).getKey();
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
