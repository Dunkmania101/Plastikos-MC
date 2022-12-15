package dunkmania101.plastikos.base.modules.impl;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;

public abstract class BasePlastikosModule implements IPlastikosModule {
    protected final IPlastikosModule PARENT;

    public final Map<String, IPlastikosModule> MODULES;

    public BasePlastikosModule(IPlastikosModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_BASE;
    }

    @Override
    public IPlastikosModule getParent() {
        return this.PARENT;
    }

    @Override
    public Map<String, IPlastikosModule> getChildren() {
        return this.MODULES;
    }
}
