package dunkmania101.modularmod.base.registry.interfaces;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public interface IBlockRegistryHandler<M extends IModularModModule<?>> extends IRegistryHandler<Block, M> {
    default Properties getBasePropertiesCloth() {
        return Properties.of(Material.CLOTH_DECORATION);
    }

    default Properties getBasePropertiesWool() {
        return Properties.of(Material.WOOL);
    }

    default Properties getBasePropertiesWood() {
        return Properties.of(Material.WOOD);
    }

    default Properties getBasePropertiesStone() {
        return Properties.of(Material.STONE);
    }

    default Properties getBasePropertiesMetal() {
        return Properties.of(Material.METAL);
    }

    default Block getDefaultBlockWood() {
        return new Block(getBasePropertiesWood());
    }

    default Block getDefaultBlockStone() {
        return new Block(getBasePropertiesStone());
    }

    default Block getDefaultBlockMetal() {
        return new Block(getBasePropertiesMetal());
    }
}
