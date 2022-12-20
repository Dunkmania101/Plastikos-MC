package dunkmania101.plastikos.base.modules.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibm.icu.impl.Pair;

import dunkmania101.plastikos.PlastikosMod;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;

public abstract class BasePlastikosModule implements IPlastikosModule {
    protected final IPlastikosModule PARENT;

    public final Map<String, IPlastikosModule> MODULES;

    public BasePlastikosModule(IPlastikosModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();
    }

    @Override
    public IPlastikosModule getParent() {
        return this.PARENT;
    }

    @Override
    public Map<String, IPlastikosModule> getChildren() {
        return this.MODULES;
    }

    @Override
    public ArrayList<Pair<String, Boolean>> getDependencyIds() {
        ArrayList<Pair<String, Boolean>> deps = IPlastikosModule.super.getDependencyIds();
        String baseId = PlastikosMod.INSTANCE.BASE.getId();
        if (!getId().equals(baseId)) {
            deps.add(Pair.of(baseId, true));
        }
        return deps;
    }
}
