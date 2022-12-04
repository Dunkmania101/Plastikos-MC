package dunkmania101.plastikos.modules.control.modules.terminals;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.control.modules.terminals.common.registry.PlastikosControlTerminalsBlockRegistry;
import dunkmania101.plastikos.modules.control.modules.terminals.common.registry.PlastikosControlTerminalsItemRegistry;

public class PlastikosModuleControlModuleTerminals implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosControlTerminalsBlockRegistry BLOCKS;
    public final PlastikosControlTerminalsItemRegistry ITEMS;

    public PlastikosModuleControlModuleTerminals(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosControlTerminalsBlockRegistry(this);
        this.ITEMS = new PlastikosControlTerminalsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_CONTROL_TERMINALS;
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
