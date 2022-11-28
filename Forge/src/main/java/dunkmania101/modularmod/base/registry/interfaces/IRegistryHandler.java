package dunkmania101.modularmod.base.registry.interfaces;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.util.NameUtils;
import net.minecraft.resources.ResourceLocation;

public interface IRegistryHandler<T> extends IRegistryAcceptor<T> {
    IRegistryAcceptor<T> getAcceptor();

    Map<ResourceLocation, Supplier<? extends T>> getEntries();

    IModularModModule getParentModule();

    String getModId();
    default String getModuleId() {
        return getParentModule().getId();
    }

    default <U extends T> Entry<ResourceLocation, Supplier<U>> registerObject(ResourceLocation rn, Supplier<U> value) {
        if (rn != null && value != null) {
            IRegistryAcceptor<T> acceptor = this.getAcceptor();
            if (acceptor != null && acceptor != this) {
                return getAcceptor().acceptObject(rn, value);
            } else {
                getEntries().put(rn, value);
                return Map.entry(rn, value);
            }
        }
        return null;
    }

    default <U extends T> Entry<ResourceLocation, Supplier<U>> acceptObject(ResourceLocation rn, Supplier<U> value) {
        return registerObject(rn, value);
    }

    default <U extends T> Entry<ResourceLocation, Supplier<U>> registerObject(String name, Supplier<U> value, boolean doProcessName) {
        ResourceLocation rn = new ResourceLocation(this.getModId(), doProcessName ? processName(name) : name);
        return registerObject(rn, value);
    }

    default <U extends T> Entry<ResourceLocation, Supplier<U>> registerObject(String name, Supplier<U> value) {
        return registerObject(name, value, true);
    }

    default String processName(String baseName) {
        return NameUtils.appendName(getModuleId(), baseName);
    }

    default void registerObjects() {};
}
