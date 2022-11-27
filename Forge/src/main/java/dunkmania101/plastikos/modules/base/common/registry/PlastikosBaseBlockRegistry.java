package dunkmania101.plastikos.modules.base.common.registry;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.registry.impl.BaseBlockRegistryHandler;
import dunkmania101.plastikos.data.PlastikosConstants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PlastikosBaseBlockRegistry extends BaseBlockRegistryHandler {
    public PlastikosBaseBlockRegistry(IModularModModule parent) {
        super(parent, parent.getRegistryAcceptorOfId(Registry.BLOCK_REGISTRY.location()));
    }

    public ResourceLocation BIG_CAST_IRON_NAIL;

    @Override
    public void registerObjects() {
        this.BIG_CAST_IRON_NAIL = this.registerObject("big_cast_iron_nail", () -> new Block(getBasePropertiesMetal())).getKey();
    }

    @Override
    public String getModId() {
        return PlastikosConstants.MODID;
    }
}
