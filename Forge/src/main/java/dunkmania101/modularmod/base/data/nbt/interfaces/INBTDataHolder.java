package dunkmania101.modularmod.base.data.nbt.interfaces;

import java.util.ArrayList;
import java.util.List;

import dunkmania101.modularmod.base.data.ModularModConstants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;

public interface INBTDataHolder {
    CompoundTag internalGetRoot();

    default String getRootKey() {
        return ModularModConstants.KEY_ROOT_DATA;
    }

    default ArrayList<String> getIntendedKeys() {
        return new ArrayList<>(List.of(getRootKey()));
    }

    default CompoundTag getRoot() {
        onRead();
        return internalGetRoot();
    }

    default void onRead() {}

    default void onWrite() {}

    default void write(CompoundTag data) {
        CompoundTag rootData = getRoot().getCompound(getRootKey());
        for (String key : data.getAllKeys()) {
            if (getIntendedKeys().contains(key)) {
                rootData.put(key, data.get(key));
                onWrite();
            }
        }
    }

    default Tag read(ArrayList<String> path) {
        CompoundTag tagPart = getRoot();
        for (int i = 0; i < path.size(); i++) {
            String pathPart = path.get(i);
            if (tagPart.contains(pathPart)) {
                Tag tagPart1 = tagPart.get(pathPart);
                if (tagPart1 instanceof CompoundTag tagPart1Compound) {
                    tagPart = tagPart1Compound;
                } else if (i == path.size() - 1) {
                    return tagPart1;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return tagPart;
    }
}
