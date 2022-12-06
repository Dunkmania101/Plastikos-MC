package dunkmania101.plastikos.modules.mobs.modules.monsters;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.mobs.modules.monsters.common.registry.PlastikosMobsMonstersBlockRegistry;
import dunkmania101.plastikos.modules.mobs.modules.monsters.common.registry.PlastikosMobsMonstersItemRegistry;

public class PlastikosModuleMobsModuleMonsters implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosMobsMonstersBlockRegistry BLOCKS;
    public final PlastikosMobsMonstersItemRegistry ITEMS;

    public PlastikosModuleMobsModuleMonsters(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.BLOCKS = new PlastikosMobsMonstersBlockRegistry(this);
        this.ITEMS = new PlastikosMobsMonstersItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_MONSTERS;
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
