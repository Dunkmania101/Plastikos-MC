package dunkmania101.modularmod.base.registry.interfaces;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import dunkmania101.modularmod.base.data.ModularModConstants;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import net.minecraft.resources.ResourceLocation;

public interface IRegistryHandler<T> extends IRegistryAcceptor<T> {
    IRegistryAcceptor<T> getAcceptor();

    Map<ResourceLocation, Supplier<T>> getEntries();

    IModularModModule getParentModule();

    String getModId();
    String getModuleId();

    default Entry<ResourceLocation, Supplier<T>> registerObject(ResourceLocation rn, Supplier<T> value) {
        IRegistryAcceptor<T> acceptor = this.getAcceptor();
        if (rn != null && value != null) {
            if (acceptor != null) {
                getAcceptor().acceptObject(rn, value);
            }
            getEntries().put(rn, value);
            return Map.entry(rn, value);
        }
        return null;
    }

    default void acceptObject(ResourceLocation rn, Supplier<T> value) {
        registerObject(rn, value);
    }

    default Entry<ResourceLocation, Supplier<T>> registerObject(String name, Supplier<T> value, boolean doProcessName) {
        ResourceLocation rn = new ResourceLocation(this.getModId(), doProcessName ? processName(name) : name);
        return registerObject(rn, value);
    }

    default Entry<ResourceLocation, Supplier<T>> registerObject(String name, Supplier<T> value) {
        return registerObject(name, value, true);
    }

    default String processName(String baseName) {
        return getModuleId().concat(ModularModConstants.PATH_DELIMITER).concat(baseName);
    }

    default void registerObjects() {};
}
