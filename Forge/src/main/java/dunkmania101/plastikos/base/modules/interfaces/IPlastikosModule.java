package dunkmania101.plastikos.base.modules.interfaces;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.PlastikosMod;

public interface IPlastikosModule extends IModularModModule<IPlastikosModule> {
    @Override
    default IPlastikosModule getRoot() {
        return PlastikosMod.INSTANCE;
    }
}
