package dunkmania101.modularmod.base.registry.interfaces;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import net.minecraft.world.entity.EntityType;

public interface IEntityRegistryHandler<M extends IModularModModule<?>> extends IRegistryHandler<EntityType<?>, M> {
}
