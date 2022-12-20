package dunkmania101.modularmod.base.modules.interfaces;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import com.ibm.icu.impl.Pair;

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
    default boolean parentIsDep() {
        return false;
    }

    /*
     * @Return Pair<String, Boolean> where String is dependency id and Boolean is whether dependency is mandatory
     */
    default ArrayList<Pair<String, Boolean>> getDependencyIds() {
        ArrayList<Pair<String, Boolean>> deps = new ArrayList<>();
        if (parentIsDep()) {
            T parent = getParent();
            if (parent != null) {
                deps.add(Pair.of(getParent().getId(), true));
            }
        }
        return deps;
    }

    default Map<String, T> getChildren() {
        return null;
    }
    @SuppressWarnings("unchecked")
    default Optional<T> getChild(String id) {
        if (!id.isBlank()) {
            ArrayList<String> parts = NameUtils.separateParent(NameUtils.removeParentid(id, getId()));
            if (parts.size() >= 1) {
                Map<String, T> children = getChildren();
                if (children != null) {
                    T child = children.getOrDefault(NameUtils.appendName(getId(), parts.get(0)), null);
                    if (child != null) {
                        if (parts.size() == 1) {
                            return Optional.of(child);
                        } else {
                            return (Optional<T>) child.getChild(parts.get(1));
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }
    default boolean isChildPresent(String id) {
        return getChild(id).isPresent();
    }
    default boolean isChildDependable(String id, boolean def) {
        Optional<T> child = getChild(id);
        if (child.isPresent()) {
            return child.get().isDependable();
        }
        return def;
    }
    default boolean isChildDependable(String id) {
        return isChildDependable(id, false);
    }

    default boolean isDepDepdable(String id) {
        return getRoot().isChildDependable(id);
    }
    default boolean areDepsDependable(boolean checkOptionalDeps) {
        return getDependencyIds().isEmpty() ? true : getDependencyIds().stream().allMatch(id -> (!id.second && !checkOptionalDeps) || isDepDepdable(id.first));
    }
    default boolean areAllDepsDependable() {
        return areDepsDependable(true);
    }
    default boolean areEnoughDepsDependable() {
        return areDepsDependable(false);
    }

    // Separate from registerChild in case getChildren does not return the storage directly and thus this adding logic must be radically different
    default <M extends T> M addChild(M child) {
        if (child != null) {
            Map<String, T> children = this.getChildren();
            if (children != null) {
                children.put(child.getId(), child);
                return child;
            }
        }
        return null;
    }

    default <M extends T> M registerChild(M child) {
        if (child != null) {
            return addChild(child);
        }
        return null;
    }

    default boolean isAllowedToRegister() {
        return true;
    }
    default boolean isFunctionalityEnabled() {
        return true;
    }
    default boolean isLoadable() {
        return isAllowedToRegister();
    }
    default boolean isDependable() {
        return isFunctionalityEnabled() && isLoadable() && areEnoughDepsDependable();
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
