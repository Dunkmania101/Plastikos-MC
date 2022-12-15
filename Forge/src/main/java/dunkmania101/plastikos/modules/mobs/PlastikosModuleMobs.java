package dunkmania101.plastikos.modules.mobs;

import dunkmania101.plastikos.base.modules.impl.BasePlastikosModule;
import dunkmania101.plastikos.base.modules.interfaces.IPlastikosModule;
import dunkmania101.plastikos.data.PlastikosConstants;
import dunkmania101.plastikos.modules.mobs.common.registry.PlastikosMobsBlockRegistry;
import dunkmania101.plastikos.modules.mobs.common.registry.PlastikosMobsItemRegistry;
import dunkmania101.plastikos.modules.mobs.modules.monsters.PlastikosModuleMobsModuleMonsters;
import dunkmania101.plastikos.modules.mobs.modules.wildlife.PlastikosModuleMobsModuleWildlife;

public class PlastikosModuleMobs extends BasePlastikosModule {
    public final PlastikosModuleMobsModuleWildlife WILDLIFE;
    public final PlastikosModuleMobsModuleMonsters MONSTERS;

    public final PlastikosMobsBlockRegistry BLOCKS;
    public final PlastikosMobsItemRegistry ITEMS;

    public PlastikosModuleMobs(IPlastikosModule parent) {
        super(parent);

        this.BLOCKS = new PlastikosMobsBlockRegistry(this);
        this.ITEMS = new PlastikosMobsItemRegistry(this);

        this.WILDLIFE = new PlastikosModuleMobsModuleWildlife(this);
        this.MONSTERS = new PlastikosModuleMobsModuleMonsters(this);
    }

    @Override
    public String getBaseId() {
        return PlastikosConstants.MODULEID_MOBS;
    }

    @Override
    public void commonRegistrySetup() {
        this.BLOCKS.registerObjects();
        this.ITEMS.registerObjects();
    }
}
