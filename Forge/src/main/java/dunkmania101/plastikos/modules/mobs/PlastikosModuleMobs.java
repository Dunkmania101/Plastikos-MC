package dunkmania101.plastikos.modules.mobs;

import java.util.HashMap;
import java.util.Map;

import dunkmania101.modularmod.base.modules.interfaces.IModularModModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.mobs.common.registry.PlastikosMobsBlockRegistry;
import dunkmania101.plastikos.modules.mobs.common.registry.PlastikosMobsItemRegistry;
import dunkmania101.plastikos.modules.mobs.modules.monsters.PlastikosModuleMobsModuleMonsters;
import dunkmania101.plastikos.modules.mobs.modules.wildlife.PlastikosModuleMobsModuleWildlife;

public class PlastikosModuleMobs implements IModularModModule {
    protected final IModularModModule PARENT;

    public final Map<String, IModularModModule> MODULES;

    public final PlastikosModuleMobsModuleWildlife WILDLIFE;
    public final PlastikosModuleMobsModuleMonsters MONSTERS;

    public final PlastikosMobsBlockRegistry BLOCKS;
    public final PlastikosMobsItemRegistry ITEMS;

    public PlastikosModuleMobs(IModularModModule parent) {
        this.PARENT = parent;
        this.MODULES = new HashMap<>();

        this.WILDLIFE = new PlastikosModuleMobsModuleWildlife(this);
        this.MONSTERS = new PlastikosModuleMobsModuleMonsters(this);

        this.BLOCKS = new PlastikosMobsBlockRegistry(this);
        this.ITEMS = new PlastikosMobsItemRegistry(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_MOBS;
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
