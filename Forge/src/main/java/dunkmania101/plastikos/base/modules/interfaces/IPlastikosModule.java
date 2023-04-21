package dunkmania101.plastikos.base.modules.interfaces;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.PlastikosMod;
import net.minecraft.network.chat.Component;

public interface IPlastikosModule extends IModularModModule<IPlastikosModule> {
    @Override
    default String getFriendlyName() {
        return Component.translatable(this.getId()).getString();
    }

    @Override
    default IPlastikosModule getRoot() {
        return PlastikosMod.INSTANCE;
    }
}
