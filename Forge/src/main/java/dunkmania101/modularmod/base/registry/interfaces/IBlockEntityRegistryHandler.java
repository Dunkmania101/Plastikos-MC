package dunkmania101.modularmod.base.registry.interfaces;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface IBlockEntityRegistryHandler<M extends IModularModModule<?>> extends IRegistryHandler<BlockEntityType<?>, M> {
}
