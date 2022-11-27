package dunkmania101.modularmod.base.registry.interfaces;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.util.NameUtils;
import net.minecraft.resources.ResourceLocation;

public interface IRegistryHandler<T> extends IRegistryAcceptor<T> {
    IRegistryAcceptor<T> getAcceptor();

    Map<ResourceLocation, Supplier<T>> getEntries();

    IModularModModule getParentModule();

    String getModId();
    default String getModuleId() {
        return getParentModule().getId();
    }

    default Entry<ResourceLocation, Supplier<T>> registerObject(ResourceLocation rn, Supplier<T> value) {
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

    default Entry<ResourceLocation, Supplier<T>> acceptObject(ResourceLocation rn, Supplier<T> value) {
        return registerObject(rn, value);
    }

    default Entry<ResourceLocation, Supplier<T>> registerObject(String name, Supplier<T> value, boolean doProcessName) {
        ResourceLocation rn = new ResourceLocation(this.getModId(), doProcessName ? processName(name) : name);
        return registerObject(rn, value);
    }

    default Entry<ResourceLocation, Supplier<T>> registerObject(String name, Supplier<T> value) {
        return registerObject(name, value, true);
    }

    default String processName(String baseName) {
        return NameUtils.appendName(getModuleId(), baseName);
    }

    default void registerObjects() {};
}
