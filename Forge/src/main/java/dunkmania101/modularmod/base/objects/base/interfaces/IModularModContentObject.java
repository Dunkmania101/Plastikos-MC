package dunkmania101.modularmod.base.objects.base.interfaces;

import java.util.Map;

import javax.annotation.Nullable;

import dunkmania101.modularmod.base.data.ModularModConstants;
import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.modularmod.base.util.NameUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;

public interface IModularModContentObject<M extends IModularModModule<?>> {
    M getParentModule();
    default String getBaseId() {
        return ModularModConstants.BLANKID;
    }

    default String getId() {
        return NameUtils.appendName(getParentModule().getId(), getBaseId());
    }

    default void tick() {
    }

    @Nullable
    default CompoundTag gatherData() {
        return null;
    }

    @Nullable
    default CompoundTag getData() {
        CompoundTag data = gatherData();
        if (data != null) {
            return data;
        }
        return null;
    }

    default void setData(CompoundTag data) {
    }

    @Nullable
    default Map<String, Component> getStats() {
        return null;
    }
}
