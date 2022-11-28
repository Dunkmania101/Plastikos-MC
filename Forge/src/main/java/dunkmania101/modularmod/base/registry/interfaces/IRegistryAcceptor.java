package dunkmania101.modularmod.base.registry.interfaces;

import java.util.Map.Entry;
import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;

public interface IRegistryAcceptor<T> {
    <U extends T> Entry<ResourceLocation, Supplier<U>> acceptObject(ResourceLocation rn, Supplier<U> value);
}
