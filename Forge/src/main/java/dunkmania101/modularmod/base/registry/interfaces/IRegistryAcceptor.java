package dunkmania101.modularmod.base.registry.interfaces;

import java.util.Map.Entry;
import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;

public interface IRegistryAcceptor<T> {
    Entry<ResourceLocation, Supplier<T>> acceptObject(ResourceLocation rn, Supplier<T> value);
}
