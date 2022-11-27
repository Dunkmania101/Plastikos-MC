package dunkmania101.modularmod.base.registry.interfaces;

import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;

public interface IRegistryAcceptor<T> {
    void acceptObject(ResourceLocation rn, Supplier<T> value);
}
