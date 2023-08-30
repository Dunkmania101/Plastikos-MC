package dunkmania101.modularmod.base.registry.interfaces;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public interface IBlockRegistryHandler<M extends IModularModModule<?>> extends IRegistryHandler<Block, M> {
    default Properties getBaseProperties(boolean requireTool) {
        return requireTool ? Properties.of().requiresCorrectToolForDrops() : Properties.of();
    }
    default Properties getBaseProperties() {
        return getBaseProperties(false);
    }


    default Properties getBasePropertiesCloth(boolean requireTool) {
        return getBaseProperties(requireTool).sound(SoundType.WOOL);
    }
    default Properties getBasePropertiesCloth() {
        return getBasePropertiesCloth(false);
    }

    default Properties getBasePropertiesWool(boolean requireTool) {
        return getBaseProperties(requireTool).sound(SoundType.WOOL);
    }
    default Properties getBasePropertiesWool() {
        return getBasePropertiesWool(false);
    }

    default Properties getBasePropertiesWood(boolean requireTool) {
        return getBaseProperties(requireTool).sound(SoundType.WOOD);
    }
    default Properties getBasePropertiesWood() {
        return getBasePropertiesWood(false);
    }

    default Properties getBasePropertiesStone(boolean requireTool) {
        return getBaseProperties(requireTool).sound(SoundType.STONE);
    }
    default Properties getBasePropertiesStone() {
        return getBasePropertiesStone(true);
    }

    default Properties getBasePropertiesMetal(boolean requireTool) {
        return getBaseProperties(requireTool).sound(SoundType.METAL);
    }
    default Properties getBasePropertiesMetal() {
        return getBasePropertiesMetal(true);
    }


    default Block getDefaultBlockCloth() {
        return new Block(getBasePropertiesCloth());
    }

    default Block getDefaultBlockWool() {
        return new Block(getBasePropertiesWool());
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
