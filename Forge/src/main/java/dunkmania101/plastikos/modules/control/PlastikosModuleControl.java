package dunkmania101.plastikos.modules.control;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.control.common.registry.PlastikosControlBlockRegistry;
import dunkmania101.plastikos.modules.control.common.registry.PlastikosControlItemRegistry;
import dunkmania101.plastikos.modules.control.modules.terminals.PlastikosModuleControlModuleTerminals;

public class PlastikosModuleControl implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosModuleControlModuleTerminals TERMINALS;

    public final PlastikosControlBlockRegistry BLOCKS;
    public final PlastikosControlItemRegistry ITEMS;

    public PlastikosModuleControl(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.TERMINALS = registerChild(new PlastikosModuleControlModuleTerminals(this));

        this.BLOCKS = new PlastikosControlBlockRegistry(this);
        this.ITEMS = new PlastikosControlItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_CONTROL;
    }

    @Override
    public IModularModModule getParent() {
        return this.PARENT;
    }

    @Override
    public Map<String, IModularModModule> getChildren() {
        return this.MODULES;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
