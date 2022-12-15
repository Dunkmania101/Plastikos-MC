package dunkmania101.modularmod.base.modules.interfaces;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.modularmod.base.util.NameUtils;
import net.minecraft.resources.ResourceLocation;

public interface IModularModModule<T extends IModularModModule<?>> {
    String getBaseId();
    default String getId() {
        String id = getBaseId();

        T parent = getParent();
        if (parent != null && parent != this) {
            return NameUtils.appendName(parent.getId(), id);
        }

        return id;
    }

    default String getFriendlyName() {
        return this.getId();
    }

    T getRoot();
    default T getParent() {
        return null;
    }

    default ArrayList<String> getDependencyIds() {
        return new ArrayList<>();
    }

    default Map<String, T> getChildren() {
        return null;
    }
    @SuppressWarnings("unchecked")
    default Optional<T> getChild(String id) {
        if (!id.isBlank()) {
            String[] parts = NameUtils.separateParent(id);
            if (parts.length >= 1) {
                Map<String, T> children = getChildren();
                T child = children.getOrDefault(parts, null);
                if (child != null) {
                    if (parts.length == 1) {
                        return Optional.of(child);
                    } else {
                        return (Optional<T>) child.getChild(parts[1]);
                    }
                }
            }
        }
        return Optional.empty();
    }
    default boolean isChildDependable(String id) {
        Optional<T> child = getChild(id);
        if (child.isPresent()) {
            return child.get().isDependable();
        }
        return false;
    }

    default boolean isDepDepdable(String id) {
        return getRoot().isChildDependable(id);
    }
    default boolean areAllDepsDependable() {
        return getDependencyIds().isEmpty() ? true : getDependencyIds().stream().allMatch(id -> isDepDepdable(id));
    }

    default <M extends T> M registerChild(M child) {
        if (child != null) {
            Map<String, T> children = this.getChildren();
            if (children != null) {
                children.put(child.getId(), child);
                return child;
            }
        }
        return null;
    }

    default boolean isEnabled() {
        return true;
    }
    default boolean isAllowedToRegister() {
        return true;
    }
    default boolean isLoadable() {
        return isAllowedToRegister() && areAllDepsDependable();
    }
    default boolean isDependable() {
        return isAllowedToRegister() && isLoadable();
    }

    default <R> IRegistryAcceptor<R> getRegistryAcceptorOfId(ResourceLocation registry) {
        T parent = this.getParent();
        if (parent == null || parent == this) {
            return null;
        } else {
            return parent.getRegistryAcceptorOfId(registry);
        }
    }

    default void earlyCommonSetup() {
        commonConfigSetup();
        if (isAllowedToRegister()) {
            commonRegistrySetup();
        }
        Map<String, T> children = this.getChildren();
        if (children != null) {
            for (T child : children.values()) {
                if (child != null) {
                    child.earlyCommonSetup();
                }
            }
        }
    }

    default void earlyClientSetup() {
        clientConfigSetup();
        if (isAllowedToRegister()) {
            serverRegistrySetup();
        }
        Map<String, T> children = this.getChildren();
        if (children != null) {
            for (T child : children.values()) {
                if (child != null) {
                    child.earlyServerSetup();
                }
            }
        }
    }

    default void earlyServerSetup() {
        serverConfigSetup();
        if (isAllowedToRegister()) {
            serverRegistrySetup();
        }
        Map<String, T> children = this.getChildren();
        if (children != null) {
            for (T child : children.values()) {
                if (child != null) {
                    child.earlyServerSetup();
                }
            }
        }
    }

    default void commonSetup() {
        commonGeneralSetup();
        Map<String, T> children = this.getChildren();
        if (children != null) {
            for (T child : children.values()) {
                if (child != null) {
                    child.commonSetup();
                }
            }
        }
    }

    default void clientSetup() {
        clientGeneralSetup();
        Map<String, T> children = this.getChildren();
        if (children != null) {
            for (T child : children.values()) {
                if (child != null) {
                    child.clientSetup();
                }
            }
        }
    }

    default void serverSetup() {
        serverGeneralSetup();
        Map<String, T> children = this.getChildren();
        if (children != null) {
            for (T child : children.values()) {
                if (child != null) {
                    child.serverSetup();
                }
            }
        }
    }

    default void commonConfigSetup() {};
    default void clientConfigSetup() {};
    default void serverConfigSetup() {};

    default void commonRegistrySetup() {};
    default void clientRegistrySetup() {};
    default void serverRegistrySetup() {};

    default void commonGeneralSetup() {};
    default void clientGeneralSetup() {};
    default void serverGeneralSetup() {};
}
