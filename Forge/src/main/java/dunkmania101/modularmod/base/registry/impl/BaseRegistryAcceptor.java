package dunkmania101.modularmod.base.registry.impl;

import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import net.minecraft.resources.ResourceLocation;

public abstract class BaseRegistryAcceptor<T> implements IRegistryAcceptor<T> {
    public abstract Entry<ResourceLocation, Supplier<T>> acceptObject(ResourceLocation rn, Supplier<T> value);
}
