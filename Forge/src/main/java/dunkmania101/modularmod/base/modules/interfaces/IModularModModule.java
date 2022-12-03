package dunkmania101.modularmod.base.modules.interfaces;

import java.util.Map;

import dunkmania101.modularmod.base.registry.interfaces.IRegistryAcceptor;
import dunkmania101.modularmod.base.util.NameUtils;
import net.minecraft.resources.ResourceLocation;

public interface IModularModModule {
    String getBaseId();
    default String getId() {
        String id = getBaseId();

        IModularModModule parent = getParent();
        if (parent != null && parent != this) {
            return NameUtils.appendName(parent.getId(), id);
        }

        return id;
    }

    default String getFriendlyName() {
        return this.getId();
    }

    default Map<String, IModularModModule> getChildren() {
        return null;
    }
    default IModularModModule getParent() {
        return null;
    }

    default <M extends IModularModModule> M registerChild(M child) {
        if (child != null) {
            Map<String, IModularModModule> children = this.getChildren();
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

    default <T> IRegistryAcceptor<T> getRegistryAcceptorOfId(ResourceLocation registry) {
        IModularModModule parent = this.getParent();
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
        Map<String, IModularModModule> children = this.getChildren();
        if (children != null) {
            for (IModularModModule child : children.values()) {
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
        Map<String, IModularModModule> children = this.getChildren();
        if (children != null) {
            for (IModularModModule child : children.values()) {
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
        Map<String, IModularModModule> children = this.getChildren();
        if (children != null) {
            for (IModularModModule child : children.values()) {
                if (child != null) {
                    child.earlyServerSetup();
                }
            }
        }
    }

    default void commonSetup() {
        commonGeneralSetup();
        Map<String, IModularModModule> children = this.getChildren();
        if (children != null) {
            for (IModularModModule child : children.values()) {
                if (child != null) {
                    child.commonSetup();
                }
            }
        }
    }

    default void clientSetup() {
        clientGeneralSetup();
        Map<String, IModularModModule> children = this.getChildren();
        if (children != null) {
            for (IModularModModule child : children.values()) {
                if (child != null) {
                    child.clientSetup();
                }
            }
        }
    }

    default void serverSetup() {
        serverGeneralSetup();
        Map<String, IModularModModule> children = this.getChildren();
        if (children != null) {
            for (IModularModModule child : children.values()) {
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
